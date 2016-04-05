package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Activity;
import domain.Company;
import services.ActivityService;
import services.CompanyService;

@Controller
@RequestMapping("/activity/company")
public class ActivityCompanyController extends AbstractController {

	// =============== Services ===================

	@Autowired
	private ActivityService activityService;

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
		result.addObject("requestURI", "activity/list.do");

		return result;

	}

}
