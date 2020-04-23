package controller.orderItem;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import model.domain.OrderItem;
import model.domain.OrderLine;
import model.domain.Product;
import model.service.OrderItemService;

public class InsertOrderItemController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String lineNo = request.getParameter("lineNo");
		String productId = request.getParameter("productId");
		
		if (lineNo == null || lineNo.equals("") || lineNo == null
				|| lineNo.equals("") || productId == null || productId.equals("")) {
			throw new AddException("입력값이 부족합니다.");
		}
		
		OrderLine orderLine = new OrderLine();
		orderLine.setLineNo(Integer.parseInt(lineNo));
		
		Product product = new Product();
		product.setId(productId);

//		int validDate = ProductService.selectById(productId).getValidDate;
//		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		cal.add(Calendar.DATE, validDate);
//		
//		Date date = new Date(cal.getTimeInMillis());
//		
//		OrderItem orderItem = new OrderItem(date, orderLine, product);

		//OrderItemService.insert(orderItem);
		
		ModelAndView mv = new ModelAndView(true, "");
		
		return mv;
	}

}
