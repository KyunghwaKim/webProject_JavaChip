package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;

public class SelectByJogunProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * Product�� List���·� ������ �޾ƿ;� �� > request or session or application�������� setAttribute�Ѱ� getAttribute��...
		 */ 
		 
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName(""); 
		 
		return mv; 
	}

}
