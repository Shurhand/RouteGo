package services;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Comment;
import domain.Company;
import security.Authority;
import security.UserAccount;
import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml"})
@Transactional
@TransactionalConfiguration(defaultRollback = false)

public class CompanyServiceTest extends AbstractTest{

	//Service under test-------------
	@Autowired
	private CompanyService companyService;
			
	/** Vamos a implementar los metodos de Test */
	/** TODO: Verificar que es correcto */
	@Test
	public void createTest() {

		Company result;
		UserAccount userAccount;

		result = new Company();
		//userAccount = createCompanyAccount();

		//result.setUserAccount(userAccount);
		companyService = new CompanyService();
	}

	@Test
	public void findAllTest() {

		Collection<Company> result;

		result = companyService.findAll();
	}

	@Test
	public void findOneTest() {
		
		int companyId = 1;
		Assert.notNull(companyId);

		Company result;
		result = companyService.findOne(companyId);
	}

	@Test
	public void saveTest(Company company) {
		Assert.notNull(company);
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String password;

		password = company.getUserAccount().getPassword();
		password = encoder.encodePassword(password, null);
		company.getUserAccount().setPassword(password);

		//companyRepository.save(company);
	}

	@Test
	public void deleteTest() {
		//Assert.notNull(company);

		//companyRepository.delete(company);
		
		//Company company = new Comment();
		//Assert.notNull(company);
		//companyService.delete(company);
	}

	// ========== Other Business Methods =============

	@Test
	public void createCompanyAccountTest() {
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

	}
}
