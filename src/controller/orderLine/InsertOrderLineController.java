package controller.orderLine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import exception.NotFoundException;
import model.domain.Customer;
import model.domain.OrderLine;
import model.service.OrderLineService;

public class InsertOrderLineController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * lineNo은 시퀀스이므로 값을 전달받지 않는다.
		 * totalPrice는 총 금액으로 프론트단에서 구매상품들의 가격을 더해서 넘겨주도록 한다
		 */
		String totalPrice = request.getParameter("totalPrice");
		String customerId = (String) request.getSession().getAttribute("userId");
		
		if (totalPrice == null || totalPrice.equals("") || customerId == null || customerId.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}

		Customer customer = new Customer();
		customer.setId(customerId);

		OrderLine orderLine = new OrderLine(Integer.parseInt(totalPrice), customer);

		OrderLineService.insert(orderLine);
		
		ModelAndView mv = new ModelAndView(true, "javaChip?command=selectCart");
		
		return mv;
	}

}
