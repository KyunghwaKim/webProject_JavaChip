package controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.domain.Product;
import model.service.ProductService;

public class SelectProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

 		List<Product> list = ProductService.selectAll(); 
 		 
 		request.setAttribute("prodList", list); 
 		 
 		ModelAndView mv = new ModelAndView(); 
 		mv.setViewName(""); 
		 
 		return mv; 
	}

}
