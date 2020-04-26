package controller.orderLine;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.OrderLine;
import model.service.OrderLineService;

public class SelectByCustomerIdOrderLineController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerId = request.getParameter("id");

		if (customerId == null || customerId.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}
		
		List<OrderLine> orderList = OrderLineService.selectByCustomerId(customerId);
		request.setAttribute("orderList", orderList);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("");

		return mv;
	}

}
