package controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.domain.GangiMokRok;
import model.domain.Product;
import model.service.ProductService;

public class SelectProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

 		List<GangiMokRok> list = ProductService.selectGangiMokRokAll();
 		 					 
 		String filename = list.get(0).getProduct().getTeacher().getPictureName();
 		System.out.println(filename);
 		
 		request.setAttribute("Gangi", list); 
 		 
 		ModelAndView mv = new ModelAndView(); 
 		mv.setViewName("classlist/cart.jsp"); 
		 
 		return mv; 
	}

}
