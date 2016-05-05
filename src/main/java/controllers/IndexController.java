package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import security.Credentials;

@Controller
@RequestMapping("/")
public class IndexController extends AbstractController {
	
	public IndexController() {
		super();
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about() {
		ModelAndView result;
		Credentials credentials = new Credentials();
				
		result = new ModelAndView("welcome/index/about");
		result.addObject("credentials", credentials);
	
		return result;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact() {
		ModelAndView result;
		Credentials credentials = new Credentials();
				
		result = new ModelAndView("welcome/index/contact");
		result.addObject("credentials", credentials);
	
		return result;
	}
	
	@RequestMapping(value = "/tips", method = RequestMethod.GET)
	public ModelAndView tips() {
		ModelAndView result;
		Credentials credentials = new Credentials();
				
		result = new ModelAndView("welcome/index/tips");
		result.addObject("credentials", credentials);
	
		return result;
	}
	

}
