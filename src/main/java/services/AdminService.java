package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Admin;
import repositories.AdminRepository;

@Service
@Transactional
public class AdminService {

	public AdminService() {
		super();
	}

	// ========== Managed Repository =================

	@Autowired
	private AdminRepository adminRepository;

	// ========== Supporting services ================

	// ========== Simple CRUD Methods ================

	public Admin create() {

		Admin result;

		result = new Admin();

		return result;
	}

	public Collection<Admin> findAll() {

		Collection<Admin> result;

		result = adminRepository.findAll();

		return result;
	}

	public Admin findOne(int adminId) {
		Assert.notNull(adminId);

		Admin result;

		result = adminRepository.findOne(adminId);

		return result;
	}

	public void save(Admin admin) {
		Assert.notNull(admin);

		adminRepository.save(admin);
	}

	public void delete(Admin admin) {
		Assert.notNull(admin);

		adminRepository.delete(admin);
	}

	// ========== Other Business Methods =============

}
