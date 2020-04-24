package controller.customer;

import java.util.List; 
 
 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
 
import controller.Controller; 
import controller.ModelAndView;
import model.domain.Customer;
import model.domain.Person;
import model.service.CustomerService;
import model.service.PersonService; 


public class selectByIdCustomerController {
	
	 	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, String id) throws Exception { 
			
		
	 		Customer list = CustomerService.selectById(id); 
	 		 
	 		request.setAttribute("list", list); 
	 		 
	 		ModelAndView mv = new ModelAndView(); 
	 		mv.setViewName(""); 
			 
	 		return mv; 
	} 


}
