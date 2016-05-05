package controllers;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Activity;
import domain.Category;
import domain.Customer;
import domain.Route;
import security.Credentials;
import services.ActivityService;
import services.CategoryService;
import services.CustomerService;
import services.RouteService;

@Controller
@RequestMapping("/route/customer")
public class RouteCustomerController extends AbstractController {

	// =============== Services ===================

	@Autowired
	private RouteService routeService;

	@Autowired
	private ActivityService activityService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CustomerService customerService;

	// Listing ---------------------------------------------------------

	@RequestMapping(value = "/list2", method = RequestMethod.GET)
	public ModelAndView list2() {

		ModelAndView result;
		Collection<Route> routes;
		Customer customer;
		
		Credentials credentials = new Credentials();

		customer = customerService.findByPrincipal();
		routes = customer.getRoutes();
		

		result = new ModelAndView("route/list2");
		result.addObject("routes", routes);
		result.addObject("credentials", credentials);
		result.addObject("requestURI", "route/list2.do");

		return result;

	}

	@RequestMapping(value = "/listCustom", method = RequestMethod.GET)
	public ModelAndView listCustom() {

		ModelAndView result;
		Collection<Route> routes;
		Credentials credentials = new Credentials();
		Customer customer = customerService.findByPrincipal();

		routes = routeService.findAllCustom();

		result = new ModelAndView("route/list3");
		result.addObject("routes", routes);
		result.addObject("customer", customer);
		result.addObject("credentials", credentials);
		

		return result;

	}
	
	@RequestMapping(value = "/list2", method = RequestMethod.POST)
	public ModelAndView list2POST() {

		ModelAndView result;
		 
		result = new ModelAndView("redirect:/route/customer/list2.do");
		

		return result;

	}
	
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView display(@RequestParam int routeID) {

		ModelAndView result;
		Credentials credentials = new Credentials();
		Route route = routeService.findOne(routeID);
		String startingDate;
		String endDate;
		SimpleDateFormat formatter;
	
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		startingDate = formatter.format(route.getStartingDate());
		endDate = formatter.format(route.getEndDate());

		result = new ModelAndView("route/list");
		result.addObject("route", route);
		result.addObject("startingDate", startingDate);
		result.addObject("endDate", endDate);
		result.addObject("credentials", credentials);
		
		return result;

	}

	// =============== Creation ===================

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView res;

		Route route = routeService.create();

		res = createEditModelAndView(route);
		return res;
	}

	// =============== Edition ====================

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int routeId) {

		ModelAndView result;
		Route route;

		route = routeService.findOne(routeId);
		Assert.notNull(route);
		result = createEditModelAndView(route);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid @ModelAttribute Route route, BindingResult binding) {

		ModelAndView result;

		if (binding.hasErrors()) {
			for(ObjectError o :binding.getAllErrors()){
				System.out.println(o);
			}
			result = createEditModelAndView(route);
		} else {
			try {
				Customer customer = customerService.findByPrincipal();
				route.setCustomer(customer);
				route.setIsRandom(false);
				routeService.save(route);
				result = new ModelAndView("redirect:/route/customer/list2.do");
			} catch (Throwable oops) {
				result = createEditModelAndView(route, "route.commit.error");
			}
		}
		return result;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(Route route, BindingResult binding) {

		ModelAndView result;

		try {
			routeService.delete(route);
			result = new ModelAndView("redirect:list.do");
		} catch (Throwable oops) {
			result = createEditModelAndView(route, "route.commit.error");
		}
		return result;

	}

	// =============== Ancillary Methods ==========

	protected ModelAndView createEditModelAndView(Route route) {
		ModelAndView res;

		res = createEditModelAndView(route, null);

		return res;
	}

	protected ModelAndView createEditModelAndView(Route route, String message) {
		ModelAndView res;
		Collection<Activity> activities;
		Collection<Category> categories;
		Customer principal;
		Credentials credentials = new Credentials();

		res = new ModelAndView("route/edit");
		activities = activityService.findAll();
		categories = categoryService.findAll();
		principal = customerService.findByPrincipal();
		res.addObject("route", route);
		res.addObject("activities", activities);
		res.addObject("categories", categories);
		res.addObject("credentials", credentials);
		res.addObject("principal", principal);
		
		res.addObject("message", message);

		return res;
	}

}
