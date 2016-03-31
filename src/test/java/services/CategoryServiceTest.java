package services;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Category;
import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml"})
@Transactional
@TransactionalConfiguration(defaultRollback = false)

public class CategoryServiceTest extends AbstractTest{

	//Service under test-------------
	@Autowired
	private CategoryService categoryService;
				
	/** Vamos a implementar los metodos de Test */
	/** TODO: Verificar que es correcto */
	@Test
	public void createTest() {

		categoryService = new CategoryService();
	}

	@Test
	public void findAllTest() {

		Collection<Category> result;

		result = categoryService.findAll();

		for(Category category : result){
			System.out.println(category.getName());
		}
	}

	@Test
	public void findOneTest() {
		
		int categoryId = 2;
		Assert.notNull(categoryId);

		categoryService.findOne(categoryId);
	}

	@Test
	public void saveTest() {

		Category category = new Category();
		Assert.notNull(category);
		categoryService.save(category);
	}

	@Test
	public void deleteTest() {
		
		Category category = new Category();
		Assert.notNull(category);
		categoryService.delete(category);
	}

	
	// ========== Other Business Methods =============

	/** Testeo con un String --> Muralla */
	@Test
	public void getCategoryByNameTest(){
		
		String cadena = "Muralla";
		categoryService.getCategoryByName(cadena);
	}
}
