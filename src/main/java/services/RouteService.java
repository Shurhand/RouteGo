package services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Category;
import domain.Route;
import forms.TripForm;
import repositories.RouteRepository;

@Service
@Transactional
public class RouteService {

	public RouteService() {
		super();
	}

	// ========== Managed Repository =================

	@Autowired
	private RouteRepository routeRepository;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private CategoryService categoryService;

	// ========== Supporting services ================

	// ========== Simple CRUD Methods ================

	public Route create() {

		Route result;

		result = new Route();

		return result;
	}

	public Collection<Route> findAll() {

		Collection<Route> result;

		result = routeRepository.findAll();

		return result;
	}

	public Route findOne(int routeId) {
		Assert.notNull(routeId);

		Route result;

		result = routeRepository.findOne(routeId);

		return result;
	}

	public void save(Route route) {
		Assert.notNull(route);

		routeRepository.save(route);
	}

	public void delete(Route route) {
		Assert.notNull(route);

		routeRepository.delete(route);
	}
	
	// ========== Other Business Methods =============

	
	public Route reconstruct(TripForm tripForm){
		
		Route res = new Route();
		res.setId(0);
		res.setVersion(0);
		res.setDescription("Descripción de prueba");
		res.setEndDate(tripForm.getEndDate());
		res.setStartingDate(tripForm.getStartingDate());
		res.setName("Viaje de prueba");
		res.setCustomer(null);
		res.setRating(null);
		res.setComments(null);
		
		//Categories
		
		Collection<Category> categories = new ArrayList<>();
		
//		if(tripForm.getCheckCulturalCategory() == true){
//			categories.add(categoryService.getCategoryByName("Cultural"));
//		}
//		if(tripForm.getCheckChurchesCategory() == true){
//			categories.add(categoryService.getCategoryByName("Churches"));
//		}
//		if(tripForm.getCheckRestaurantsCategory() == true){
//			categories.add(categoryService.getCategoryByName("Restaurants"));
//		}
//		if(tripForm.getCheckMuseumsCategory() == true){
//			categories.add(categoryService.getCategoryByName("Museums"));
//		}
		
		res.setCategories(categories);
		
		//Activities
		
		res.setActivities(activityService.findAll());
		
		return res;
		
	}
}

