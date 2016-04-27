package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Activity;
import domain.Company;
import domain.Customer;
import services.ActivityService;
import services.CompanyService;
import services.CustomerService;

@Controller
@RequestMapping("/admin")
public class AdminController extends AbstractController {

	// =============== Services ===================

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private ActivityService activityService;

	// =============== Dashboard ==================

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView dashboard() {

		ModelAndView result;
		Collection<Customer> customers;
		Collection<Company> companies;
		Collection<Activity> activities;

		customers = customerService.findAll();
		companies = companyService.findAll();
		activities= activityService.findAll();

		result = new ModelAndView("admin/dashboard");
		result.addObject("customers",customers);
		result.addObject("companies",companies);
		result.addObject("activities",activities);
		result.addObject("requestURI", "admin/dashboard.do");

		return result;
	}
}
