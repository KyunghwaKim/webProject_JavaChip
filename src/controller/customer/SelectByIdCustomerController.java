package controller.customer;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.domain.Customer;
import model.service.CustomerService;

	public class SelectByIdCustomerController implements Controller {
		@Override
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

			String id = request.getParameter("id");
	 		Customer customer = CustomerService.selectById(id); 
	 		 
	 		request.setAttribute("customer", customer); 
	 		 
	 		ModelAndView mv = new ModelAndView(); 
	 		mv.setViewName(""); 
			 
	 		return mv; 
		} 


}
