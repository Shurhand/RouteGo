package controllers;

import java.text.SimpleDateFormat;
import java.util.Collection;

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
import domain.Comment;
import domain.Customer;
import domain.Route;
import security.Credentials;
import services.ActivityService;
import services.CategoryService;
import services.CommentService;
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

	@Autowired
	private CommentService commentService;

	// Listing ---------------------------------------------------------

	@RequestMapping(value = "/list2", method = RequestMethod.GET)
	public ModelAndView list2() {

		ModelAndView result;
		Collection<Route> routes;

		Credentials credentials = new Credentials();

		routes = routeService.findAllCustomerRoutes();

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
		Collection<Comment> comments;
		boolean estaAsignada;

		formatter = new SimpleDateFormat("dd/MM/yyyy");
		startingDate = formatter.format(route.getStartingDate());
		endDate = formatter.format(route.getEndDate());
		comments = route.getComments();
		estaAsignada = routeService.estaAsignada(route);

		result = new ModelAndView("route/list");
		result.addObject("route", route);
		result.addObject("startingDate", startingDate);
		result.addObject("endDate", endDate);
		result.addObject("comments", comments);
		result.addObject("credentials", credentials);
		result.addObject("estaAsignada", estaAsignada);
		result.addObject("requestURI", "route/customer/display.do");

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
			for (ObjectError o : binding.getAllErrors()) {
				System.out.println(o);
			}
			result = createEditModelAndView(route);
		} else {
			try {
				Customer customer = customerService.findByPrincipal();
				route.getCustomers().add(customer);
				route.setOwner(customer);
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

	@RequestMapping(value = "/ratea", method = RequestMethod.POST)
	public ModelAndView ratea(@RequestParam int rate, @RequestParam int routeId) {

		ModelAndView result;

		try {
			routeService.ratea(rate, routeId);
			result = new ModelAndView("redirect:/route/customer/list2.do");
			result.addObject("requestURI", "route/list2.do");
		} catch (Throwable error) {
			result = new ModelAndView("redirect:list2.do");
		}
		return result;

	}

	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public ModelAndView comment(@RequestParam String text, @RequestParam int routeId) {

		ModelAndView result;

		try {
			commentService.comenta(text, routeId);
			result = new ModelAndView("redirect:/route/customer/display.do?routeID=" + routeId);
			result.addObject("requestURI", "route/list.do");
		} catch (Throwable error) {
			result = new ModelAndView("redirect:list2.do");
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
		categories = categoryService.findAll();
		principal = customerService.findByPrincipal();
		activities = activityService.findByCustomerId(principal.getId());
		activityService.aņadeTodas(activities);
		res.addObject("route", route);
		res.addObject("activities", activities);
		res.addObject("categories", categories);
		res.addObject("credentials", credentials);
		res.addObject("principal", principal);

		res.addObject("message", message);

		return res;
	}

}
