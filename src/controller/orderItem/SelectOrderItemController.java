package controller.orderItem;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.OrderItem;
import model.service.OrderItemService;

public class SelectOrderItemController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerId = request.getParameter("id");
		
		if (customerId == null || customerId.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}
		
		List<OrderItem> itemList = OrderItemService.selectAll(customerId);

		request.setAttribute("itemList", itemList);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("");

		return mv;
	}

}
