package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Company;
import repositories.CompanyRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class CompanyService {

	public CompanyService() {
		super();
	}

	// ========== Managed Repository =================

	@Autowired
	private CompanyRepository companyRepository;


	// ========== Supporting services ================

	// ========== Simple CRUD Methods ================

	public Company create() {

		Company result;
		UserAccount userAccount;

		result = new Company();
		userAccount = createCompanyAccount();

		result.setUserAccount(userAccount);

		return result;
	}

	public Collection<Company> findAll() {

		Collection<Company> result;

		result = companyRepository.findAll();

		return result;
	}

	public Company findOne(int companyId) {
		Assert.notNull(companyId);

		Company result;

		result = companyRepository.findOne(companyId);

		return result;
	}

	public void save(Company company) {
		Assert.notNull(company);
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String password;

		password = company.getUserAccount().getPassword();
		password = encoder.encodePassword(password, null);
		company.getUserAccount().setPassword(password);

		companyRepository.save(company);
	}

	public void delete(Company company) {
		Assert.notNull(company);

		companyRepository.delete(company);
	}

	// ========== Other Business Methods =============
	
	public Company findByPrincipal() {
		Company result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		result = findByUserAccount(userAccount);

		Assert.notNull(result);

		return result;
	}
	
	public Company findByUserAccount(UserAccount userAccount) {
		assert userAccount != null;

		Company result;

		result = companyRepository.findByUserAccountId(userAccount.getId());
		assert result != null;

		return result;
	}

	public UserAccount createCompanyAccount() {
		UserAccount result;
		// Collection<Authority> authorities;
		Authority authority;

		result = new UserAccount();
		// result.setUsername("");
		// result.setPassword("");

		authority = new Authority();
		authority.setAuthority("COMPANY");
		// authorities = new ArrayList<Authority>();
		// authorities.add(authority);

		// result.setAuthorities(authorities);
		result.addAuthority(authority);

		return result;
	}

}
