package services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Activity;
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

	public Route reconstruct(TripForm tripForm) {

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

		// Categories

		Collection<Category> categories = new ArrayList<>();

		if (tripForm.getCheckCulturalCategory() == true) {
			categories.add(categoryService.getCategoryByName("Cultural"));
		}
		if (tripForm.getCheckChurchesCategory() == true) {
			categories.add(categoryService.getCategoryByName("Churches"));
		}
		if (tripForm.getCheckRestaurantsCategory() == true) {
			categories.add(categoryService.getCategoryByName("Restaurants"));
		}
		if (tripForm.getCheckMuseumsCategory() == true) {
			categories.add(categoryService.getCategoryByName("Museums"));
		}
		if (tripForm.getCheckDrinksCategory() == true) {
			categories.add(categoryService.getCategoryByName("Drinks"));
		}
		if (tripForm.getCheckPaintingsCategory() == true) {
			categories.add(categoryService.getCategoryByName("Paintings"));
		}
		if (tripForm.getCheckMusicCategory() == true) {
			categories.add(categoryService.getCategoryByName("Music"));
		}
		if (tripForm.getCheckMonumentsCategory() == true) {
			categories.add(categoryService.getCategoryByName("Monuments"));
		}

		res.setCategories(categories);

		// Activities

		Collection<Activity> activities;

		Date startingDate = tripForm.getStartingDate();
		Date endingDate = tripForm.getEndDate();

		activities = activityService.findInDateRange(startingDate, endingDate);

		res.setActivities(activities);
		// res.setActivities(activityService.findAll());

		return res;

	}

	public Route filtraPrecio(Route route, double precio) {
		Route res;
		Collection<Activity> actividades;
		ArrayList<Activity> aRestantes;
		double p;

		res = route;
		actividades = new ArrayList<>();
		aRestantes = new ArrayList<>();
		p = precio;

		for (Activity ac : route.getActivities()) {
			aRestantes.add(ac);
		}

		while (p > 0 && aRestantes.size() > 0) {

			Random rnd = new Random();
			int i = rnd.nextInt(aRestantes.size());
			Activity a = aRestantes.get(i);
			aRestantes.remove(a);

			if (a.getCost() <= p) {
				actividades.add(a);
				p = p - a.getCost();

			}
		}

		// SIN RANDOM
		// for (Activity a : route.getActivities()) {
		// if (a.getCost() <= p) {
		// actividades.add(a);
		// p = p - a.getCost();
		// }
		// }

		res.setActivities(actividades);

		return res;
	}
}
