package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Route;
import forms.TripForm;
import security.Credentials;
import services.RouteService;

@Controller
@RequestMapping("/route")
public class RouteController extends AbstractController {
	
	
	@Autowired
	private RouteService routeService;
	
	private static Route ROUTE_CREATED = null;
	
	
	// listing-----------------------------------------
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView res;
		Route route = ROUTE_CREATED;
		SimpleDateFormat formatter;
		String startingDate;
		String endDate;
		Credentials credentials = new Credentials();
		
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		startingDate = formatter.format(route.getStartingDate());
		endDate = formatter.format(route.getEndDate());

		res = new ModelAndView("route/list");
		res.addObject("route", route);
		res.addObject("startingDate", startingDate);
		res.addObject("endDate", endDate);
		res.addObject("credentials", credentials);
		
		return res;
	}
		
	
	//	===========  Creation  ===========
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		ModelAndView res;
		
		TripForm tripForm = new TripForm();
		

		
		res = createEditModelAndView(tripForm);
		return res;
	}
	
	
//	=========== Show created trip ===========
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST, params="create")
	public ModelAndView save(@Valid TripForm tripForm, BindingResult binding){
		ModelAndView res;
		Credentials credentials = new Credentials();
				
		if (binding.hasErrors()) {
			for(ObjectError a : binding.getAllErrors()){
				System.out.println(a);
			}
			res = createEditModelAndView(tripForm);
		}
		else {
				Route route = routeService.reconstruct(tripForm);
				ROUTE_CREATED = route;
			//	routeService.save(route);
				res = new ModelAndView("redirect:/route/list.do");
				res.addObject("credentials", credentials);
				

		}
	return res;
	}
	
	
//	===========  Ancillary Methods  ===========
	protected ModelAndView createEditModelAndView(TripForm tripForm){
		ModelAndView res;
		
		res = createEditModelAndView(tripForm, null);
		
		return res;
	}
	
	protected ModelAndView createEditModelAndView(TripForm tripForm, String message){
		ModelAndView res;
		Credentials credentials = new Credentials();
			
		res = new ModelAndView("route/create");
		res.addObject("tripForm", tripForm);
		res.addObject("message", message);
		res.addObject("credentials", credentials);
	
		
		return res;
	}

}
