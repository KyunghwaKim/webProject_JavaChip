package controller.orderItem;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.OrderItem;
import model.domain.OrderLine;
import model.domain.Product;
import model.service.OrderItemService;

public class UpdateOrderItemController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String itemNo = request.getParameter("itemNo");
		String lineNo = request.getParameter("lineNo");
		String productId = request.getParameter("productId");
		
		if (lineNo == null || lineNo.equals("") || lineNo == null
				|| lineNo.equals("") || productId == null || productId.equals("")) {
			throw new NotFoundException("�Է°��� �����մϴ�.");
		}
		
		OrderLine orderLine = new OrderLine();
		orderLine.setLineNo(Integer.parseInt(lineNo));
		
		Product product = new Product();
		product.setId(productId);

		OrderItem orderItem = new OrderItem(Integer.parseInt(itemNo)
				, new Date(), 1, orderLine, product);

		//OrderItemService.update(orderItem);
		
		ModelAndView mv = new ModelAndView(true, "");
		
		return mv;
	}

}
