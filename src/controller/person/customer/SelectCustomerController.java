package controller.person.customer;

import java.util.List; 
 
 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
 
import controller.Controller; 
import controller.ModelAndView; 
import model.domain.Customer; 
import model.service.CustomerService; 


public class SelectCustomerController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception  { 
			
	 		List<Customer> list = CustomerService.selectAll(); 
	 		 
	 		request.setAttribute("list", list); 
	 		 
	 		ModelAndView mv = new ModelAndView(); 
	 		mv.setViewName(""); 
			 
	 		return mv; 
	} 


}
