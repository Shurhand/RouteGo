package services;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Admin;
import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml"})
@Transactional
@TransactionalConfiguration(defaultRollback = false)

public class AdminServiceTest extends AbstractTest{

	//Service under test-------------
	@Autowired
	private AdminService adminService;
				
				
				
	/** Vamos a implementar los metodos de Test */
	
	/** TODO */
	@Test
	public void createTest() {

		adminService = new AdminService();
	}

	/** TODO */
	@Test
	public void findAllTest() {

		Collection<Admin> result;

		result = adminService.findAll();

		for(Admin administrar : result){
			System.out.println(administrar.getName());
		}
	}

	/** TODO */
	@Test
	public void findOneTest() {
		
		int adminId = 10;
		Assert.notNull(adminId);
		adminService.findOne(adminId);

	}

	/** TODO */
	@Test
	public void saveTest() {
		
		Admin admin = new Admin();
		Assert.notNull(admin);
		adminService.save(admin);
	}

	/** TODO */
	@Test
	public void deleteTest() {
		Admin admin = new Admin();
		Assert.notNull(admin);
		adminService.delete(admin);
	}
	
}
