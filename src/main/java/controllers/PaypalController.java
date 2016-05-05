package controllers;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Customer;
import domain.Route;
import security.Credentials;
import services.CustomerService;
import services.RouteService;
import utilities.paypal.IPN.IPNMessage;
import utilities.paypal.IPN.IPNMessageParser;
import utilities.paypal.IPN.IPNNotificationValidation;
import utilities.paypal.IPN.PayPalEnvironment;

@Controller
@RequestMapping("/paypal")
public class PaypalController extends AbstractController {
	
	private PayPalEnvironment environment = PayPalEnvironment.SANDBOX;
	
	@Autowired
	private RouteService routeService;
	@Autowired
	private CustomerService customerService;

   //  private final String paypalUrl;	
		
//	private static final Logger log = Logger.getLogger(PaypalController.class.getName());
	

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public void processIPN(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException	 {
						
			final IPNMessage message = new IPNMessageParser(nvp(req), false).parse();

			
			Map<String, String> res = nvp(req);
			
			System.out.println(res.entrySet() + "\n");
	
			final IPNNotificationValidation validation = new IPNNotificationValidation(message);
			
			if(validation.validate(environment)) {
				message.setValidated(true);
					
			}		
								
			if(message.isValidated() == true){
				
				Route rutaComprada = routeService.findOne(Integer.parseInt(message.getItemNumber()));
				Customer customer = customerService.findOne(Integer.parseInt(message.getCustom()));
				rutaComprada.getCustomers().add(customer);
							
				routeService.saveOnly(rutaComprada);
				customer.getRoutes().add(rutaComprada);
				customerService.saveOnly(customer);
				System.out.println(customer.getRoutes());

				System.out.println("Final");
								
			} else {
				resp.sendError(204,"Positivo con el fin de que no lo reintente más");
			}
			
		}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ModelAndView processIPNGet()
			throws ServletException, IOException {
	
		ModelAndView result;
		Collection<Route> routes;
		Customer customer;
		
		Credentials credentials = new Credentials();

		customer = customerService.findByPrincipal();
		routes = customer.getRoutes();
		

		result = new ModelAndView("route/list2");
		result.addObject("routes", routes);
		result.addObject("credentials", credentials);
		result.addObject("requestURI", "route/list2.do");

		return result;
		
	}
//	
//	@RequestMapping(value = "/process", method = RequestMethod.GET)
//	private void savePrueba(Route route){
//		
//		System.out.println("entro process");
//		routeService.saveOnly(route);
//		System.out.println("paso");
//		
//	}
	
	// Creación del map de contenidos
	@SuppressWarnings("unchecked")
	protected Map<String, String> nvp(HttpServletRequest req) {
		Map<String, String[]> params = (Map<String, String[]>) req
				.getParameterMap();
		Map<String, String> nvp = new HashMap<String, String>();
		for (Map.Entry<String, String[]> entry : params.entrySet()) {
			String value = "";
			for (int i = 0; i < entry.getValue().length; i++) {
				value += entry.getValue()[i];
				if (i < entry.getValue().length - 1)
					value += ",";
			}
			nvp.put(entry.getKey(), value);
		}
		return nvp;
	}
	


	}


