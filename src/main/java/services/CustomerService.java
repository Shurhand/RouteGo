package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Customer;
import repositories.CustomerRepository;

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

		result = new Customer();

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

		customerRepository.save(customer);
	}

	public void delete(Customer customer) {
		Assert.notNull(customer);

		customerRepository.delete(customer);
	}

	// ========== Other Business Methods =============

}
