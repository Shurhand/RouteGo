package services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Customer;
import domain.Route;
import repositories.CustomerRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class CustomerService {

	public CustomerService() {
		super();
	}

	// ========== Managed Repository =================

	@Autowired
	private CustomerRepository customerRepository;

	// ========== Supporting services ================

	// ========== Simple CRUD Methods ================

	public Customer create() {

		Customer result;
		UserAccount userAccount;
		Collection<Route> routes = new ArrayList<>();

		result = new Customer();
		userAccount = createCustomerAccount();
		result.setRoutes(routes);

		result.setUserAccount(userAccount);

		return result;
	}

	public Collection<Customer> findAll() {

		Collection<Customer> result;

		result = customerRepository.findAll();

		return result;
	}

	public Customer findOne(int customerId) {
		Assert.notNull(customerId);

		Customer result;

		result = customerRepository.findOne(customerId);

		return result;
	}

	public void save(Customer customer) {
		Assert.notNull(customer);
//		Collection<Route> routes = new ArrayList<>();
//		customer.setRoutes(routes);
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String password;
		
		password = customer.getUserAccount().getPassword();
		password = encoder.encodePassword(password, null);
		customer.getUserAccount().setPassword(password);

		customerRepository.save(customer);
	}

	
	public void saveOnly(Customer customer) {
		Assert.notNull(customer);

		customerRepository.save(customer);
	}
	
	public void delete(Customer customer) {
		Assert.notNull(customer);

		customerRepository.delete(customer);
	}

	// ========== Other Business Methods =============
	
	public Customer findByPrincipal() {
		Customer result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		result = findByUserAccount(userAccount);

		Assert.notNull(result);

		return result;
	}
	
	public Customer findByUserAccount(UserAccount userAccount) {
		assert userAccount != null;

		Customer result;

		result = customerRepository.findByUserAccountId(userAccount.getId());
		assert result != null;

		return result;
	}

	public UserAccount createCustomerAccount() {
		UserAccount result;
		// Collection<Authority> authorities;
		Authority authority;

		result = new UserAccount();
		// result.setUsername("");
		// result.setPassword("");

		authority = new Authority();
		authority.setAuthority("CUSTOMER");
		// authorities = new ArrayList<Authority>();
		// authorities.add(authority);

		// result.setAuthorities(authorities);
		result.addAuthority(authority);

		return result;
	}

}
