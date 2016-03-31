package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Customer;
import repositories.CustomerRepository;
import security.Authority;
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

		result = new Customer();
		userAccount = createCustomerAccount();

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
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String password;
		
		password = customer.getUserAccount().getPassword();
		password = encoder.encodePassword(password, null);
		customer.getUserAccount().setPassword(password);

		customerRepository.save(customer);
	}

	public void delete(Customer customer) {
		Assert.notNull(customer);

		customerRepository.delete(customer);
	}

	// ========== Other Business Methods =============

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
