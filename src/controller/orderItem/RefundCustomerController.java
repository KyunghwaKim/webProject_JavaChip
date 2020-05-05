package controller.orderItem;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import model.service.OrderItemService;

public class RefundCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("환불컨트롤러 호출됨....");
		
		String orderno = request.getParameter("orderNo");
		
		OrderItemService.refund(Integer.parseInt(orderno));
		
		ServletContext application = request.getServletContext();
		
		String path = application.getContextPath();		
		
		ModelAndView mv = new ModelAndView(true, path+"/javaChip?command=selectByCusIdOrderLine");
				
		return mv;
	}

}
