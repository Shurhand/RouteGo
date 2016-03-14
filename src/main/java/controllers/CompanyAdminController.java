package controllers;

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

import domain.Company;
import services.CompanyService;

@Controller
@RequestMapping("/company/admin")
public class CompanyAdminController extends AbstractController {

	// =============== Services ===================

	@Autowired
	private CompanyService companyService;

	// =============== Creation ===================

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView res;

		Company company = companyService.create();

		res = createEditModelAndView(company);
		return res;
	}

	// =============== Edition ====================

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int companyId) {

		ModelAndView result;
		Company company;

		company = companyService.findOne(companyId);
		Assert.notNull(company);
		result = createEditModelAndView(company);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid @ModelAttribute Company company, BindingResult binding) {

		ModelAndView result;

		if (binding.hasErrors()) {
			result = createEditModelAndView(company);
		} else {
			try {
				companyService.save(company);
				result = new ModelAndView("redirect:/");
			} catch (Throwable oops) {
				result = createEditModelAndView(company, "company.commit.error");
			}
		}
		return result;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(Company company, BindingResult binding) {

		ModelAndView result;

		try {
			companyService.delete(company);
			result = new ModelAndView("redirect:list.do");
		} catch (Throwable oops) {
			result = createEditModelAndView(company, "company.commit.error");
		}
		return result;

	}

	// =============== Ancillary Methods ==========

	protected ModelAndView createEditModelAndView(Company company) {
		ModelAndView res;

		res = createEditModelAndView(company, null);

		return res;
	}

	protected ModelAndView createEditModelAndView(Company company, String message) {
		ModelAndView res;

		res = new ModelAndView("company/edit");
		res.addObject("company", company);
		res.addObject("message", message);

		return res;
	}

}
