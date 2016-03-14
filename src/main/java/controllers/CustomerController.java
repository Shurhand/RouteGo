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

import domain.Customer;
import services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController extends AbstractController {

	// =============== Services =======
	
	@Autowired
	private CustomerService customerService;

	// =========== Creation ===========

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView res;

		Customer customer = customerService.create();

		res = createEditModelAndView(customer);
		return res;
	}

	// =========== Edition =============

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int customerId) {

		ModelAndView result;
		Customer customer;

		customer = customerService.findOne(customerId);
		Assert.notNull(customer);
		result = createEditModelAndView(customer);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid @ModelAttribute Customer customer, BindingResult binding) {

		ModelAndView result;

		if (binding.hasErrors()) {
			result = createEditModelAndView(customer);
		} else {
			try {
				customerService.save(customer);
				result = new ModelAndView("redirect:/security/login.do");
			} catch (Throwable oops) {
				result = createEditModelAndView(customer, "customer.commit.error");
			}
		}
		return result;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(Customer customer, BindingResult binding) {

		ModelAndView result;

		try {
			customerService.delete(customer);
			result = new ModelAndView("redirect:list.do");
		} catch (Throwable oops) {
			result = createEditModelAndView(customer, "customer.commit.error");
		}
		return result;

	}

	// =========== Ancillary Methods ===========
	protected ModelAndView createEditModelAndView(Customer customer) {
		ModelAndView res;

		res = createEditModelAndView(customer, null);

		return res;
	}

	protected ModelAndView createEditModelAndView(Customer customer, String message) {
		ModelAndView res;

		res = new ModelAndView("customer/edit");
		res.addObject("customer", customer);
		res.addObject("message", message);

		return res;
	}

}
