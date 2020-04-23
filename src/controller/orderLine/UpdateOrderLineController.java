package controller.orderLine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;

public class UpdateOrderLineController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String lineNo = request.getParameter("lineNo");
		String prodId = request.getParameter("prodId");
		
		//int lineNo, String prodId;
		return null;
	}

}
