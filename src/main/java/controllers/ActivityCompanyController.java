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
import domain.Company;
import services.ActivityService;
import services.CategoryService;
import services.CompanyService;

@Controller
@RequestMapping("/activity/company")
public class ActivityCompanyController extends AbstractController {

	// =============== Services ===================

	@Autowired
	private ActivityService activityService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CompanyService companyService;

	// Listing ---------------------------------------------------------

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView result;
		Collection<Activity> activities;
		Company principal;
		int companyId;

		principal = companyService.findByPrincipal();
		companyId = principal.getId();
		activities = activityService.findByCompanyId(companyId);

		result = new ModelAndView("activity/list");
		result.addObject("activities", activities);
		result.addObject("requestURI", "activity/company/list.do");

		return result;

	}

	// =============== Creation ===================

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView res;

		Activity activity = activityService.create();

		res = createEditModelAndView(activity);
		return res;
	}

	// =============== Edition ====================

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int activityId) {

		ModelAndView result;
		Activity activity;

		activity = activityService.findOne(activityId);
		Assert.notNull(activity);
		result = createEditModelAndView(activity);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid @ModelAttribute Activity activity, BindingResult binding) {

		ModelAndView result;

		if (binding.hasErrors()) {
			result = createEditModelAndView(activity);
		} else {
			try {
				Company principal= companyService.findByPrincipal();
				activity.setCompany(principal);
				activityService.assignCompany(activity, principal);
				activityService.save(activity);
				result = new ModelAndView("redirect:list.do");
			} catch (Throwable oops) {
				result = createEditModelAndView(activity, "activity.commit.error");
			}
		}
		return result;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(Activity activity, BindingResult binding) {

		ModelAndView result;

		try {
			activityService.delete(activity);
			result = new ModelAndView("redirect:list.do");
		} catch (Throwable oops) {
			result = createEditModelAndView(activity, "activity.commit.error");
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
		res = new ModelAndView("activity/edit2");
		res.addObject("activity", activity);
		res.addObject("categories", categories);
		res.addObject("message", message);

		return res;
	}

}