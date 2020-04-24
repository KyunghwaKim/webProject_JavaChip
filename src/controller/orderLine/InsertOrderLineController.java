package controller.orderLine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import model.domain.Customer;
import model.domain.OrderLine;
import model.service.OrderLineService;

public class InsertOrderLineController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//lineNo�� �������̹Ƿ� ���� ���޹��� �ʴ´�.
		String totalPrice = request.getParameter("totalPrice");
		String id = request.getParameter("id");

		if (totalPrice == null || totalPrice.equals("") || id == null || id.equals("")) {
			throw new AddException("�Է°��� �����մϴ�.");
		}

		Customer customer = new Customer();
		customer.setId(id);

		OrderLine orderLine = new OrderLine(Integer.parseInt(totalPrice), customer);

		OrderLineService.insert(orderLine);
		
		ModelAndView mv = new ModelAndView(true, "");
		
		return mv;
	}

}
