package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Category;
import repositories.CategoryRepository;

@Service
@Transactional
public class CategoryService {

	public CategoryService() {
		super();
	}

	// ========== Managed Repository =================

	@Autowired
	private CategoryRepository categoryRepository;

	// ========== Supporting services ================

	// ========== Simple CRUD Methods ================

	public Category create() {

		Category result;

		result = new Category();

		return result;
	}

	public Collection<Category> findAll() {

		Collection<Category> result;

		result = categoryRepository.findAll();

		return result;
	}

	public Category findOne(int categoryId) {
		Assert.notNull(categoryId);

		Category result;

		result = categoryRepository.findOne(categoryId);

		return result;
	}

	public void save(Category category) {
		Assert.notNull(category);

		categoryRepository.save(category);
	}

	public void delete(Category category) {
		Assert.notNull(category);

		categoryRepository.delete(category);
	}

	// ========== Other Business Methods =============

	public Category getCategoryByName(String s){
		
		Category res = categoryRepository.getCategoryByName(s);
		
		return res;
	}
}
