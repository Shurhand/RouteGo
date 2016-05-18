package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Activity;
import domain.Category;
import domain.Customer;
import forms.ActivityForm;
import services.ActivityService;
import services.CategoryService;
import services.CustomerService;

@Controller
@RequestMapping("/activity")
public class ActivityController extends AbstractController {

	// =============== Services ===================

	@Autowired
	private ActivityService activityService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CustomerService customerService;

	// Listing ---------------------------------------------------------

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView result;
		Collection<Activity> activities;
		Customer princpial;

		princpial = customerService.findByPrincipal();
		activities = activityService.findByCustomerId(princpial.getId());

		result = new ModelAndView("activity/list");
		result.addObject("activities", activities);
		result.addObject("requestURI", "activity/list.do");

		return result;

	}

	// =============== Creation ===================

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView res;
		ActivityForm activityForm = new ActivityForm();

		res = createEditModelAndView2(activityForm);
		return res;
	}

	// =============== Edition ====================
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int activityId) {

		ModelAndView result;
		Activity activity;
		ActivityForm activityForm;

		activity = activityService.findOne(activityId);
		activityForm= activityService.transform(activity);
		Assert.notNull(activity);
		result = createEditModelAndView2(activityForm);

		return result;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid ActivityForm activityForm, BindingResult binding) {

		ModelAndView result;
		Activity activity;

		if (binding.hasErrors()) {
			for (ObjectError a : binding.getAllErrors()) {
				System.out.println(a);
			}
			result = createEditModelAndView2(activityForm);
		} else {
			try {
				Customer customer = customerService.findByPrincipal();
				activity = activityService.reconstruct(activityForm);
				activity.setCustomer(customer);
				activityService.save(activity);
				result = new ModelAndView("redirect:list.do");
			} catch (Throwable oops) {
				result = createEditModelAndView2(activityForm, "activity.commit.error");
			}
		}
		return result;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(ActivityForm activityForm, BindingResult binding) {

		ModelAndView result;
		Activity activity;

		try {
			activity = activityService.reconstruct(activityForm);
			activityService.delete(activity);
			result = new ModelAndView("redirect:list.do");
		} catch (Throwable oops) {
			result = createEditModelAndView2(activityForm, "activity.commit.error");
		}
		return result;

	}

	@RequestMapping(value = "/deleteActivity", method = RequestMethod.GET)
	public ModelAndView deleteActivity(@RequestParam int activityId) {

		ModelAndView result;
		Activity activity;

		activity = activityService.findOne(activityId);

		try {
			activityService.delete(activity);
			result = new ModelAndView("redirect:list.do");
		} catch (Throwable oops) {
			result = createEditModelAndView(activity, "activity.delete.error");
		}
		return result;

	}

	// =============== Ancillary Methods ==========

	protected ModelAndView createEditModelAndView(Activity activity) {
		ModelAndView res;

		res = createEditModelAndView(activity, null);

		return res;
	}

	protected ModelAndView createEditModelAndView(Activity activity, String message) {
		ModelAndView res;

		Collection<Category> categories;

		categories = categoryService.findAll();
		res = new ModelAndView("activity/edit");
		res.addObject("activity", activity);
		res.addObject("categories", categories);
		res.addObject("message", message);

		return res;
	}

	protected ModelAndView createEditModelAndView2(ActivityForm activityForm) {
		ModelAndView res;

		res = createEditModelAndView2(activityForm, null);

		return res;
	}

	protected ModelAndView createEditModelAndView2(ActivityForm activityForm, String message) {
		ModelAndView res;
		Collection<Category> categories;

		categories = categoryService.findAll();
		res = new ModelAndView("activity/edit");
		res.addObject("categories", categories);
		res.addObject("activityForm", activityForm);
		res.addObject("message", message);

		return res;
	}

}