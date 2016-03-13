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
		
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		startingDate = formatter.format(route.getStartingDate());
		endDate = formatter.format(route.getEndDate());

		res = new ModelAndView("route/list");
		res.addObject("route", route);
		res.addObject("startingDate", startingDate);
		res.addObject("endDate", endDate);
		
		return res;
	}
		
	
	//	===========  Creation  ===========
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		ModelAndView res;
		
		TripForm customerForm = new TripForm();
		

		customerForm.setId(0);
		customerForm.setVersion(0);

		
		res = createEditModelAndView(customerForm);
		return res;
	}
	
	
//	=========== Show created trip ===========
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST, params="create")
	public ModelAndView save(@Valid TripForm tripForm, BindingResult binding){
		ModelAndView res;
				
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
			
		res = new ModelAndView("route/create");
		res.addObject("tripForm", tripForm);
		res.addObject("message", message);
	
		
		return res;
	}

}
