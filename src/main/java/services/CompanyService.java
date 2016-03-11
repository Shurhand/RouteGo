package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Company;
import repositories.CompanyRepository;

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

		result = new Company();

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

		companyRepository.save(company);
	}

	public void delete(Company company) {
		Assert.notNull(company);

		companyRepository.delete(company);
	}

	// ========== Other Business Methods =============

}
