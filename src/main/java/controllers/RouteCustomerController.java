package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Activity;
import domain.Category;
import domain.Customer;
import domain.Route;
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
			result = createEditModelAndView(route, binding.toString());
		} else {
			try {
				Customer customer= customerService.findByPrincipal();
				route.setCustomer(customer);
				routeService.save(route);
				result = new ModelAndView("redirect:/");
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

		res = new ModelAndView("route/edit");
		activities = activityService.findAll();
		categories = categoryService.findAll();
		res.addObject("route", route);
		res.addObject("activities", activities);
		res.addObject("categories", categories);
		res.addObject("message", message);

		return res;
	}

}
