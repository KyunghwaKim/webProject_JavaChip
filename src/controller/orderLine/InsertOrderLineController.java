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
		 * lineNo�� �������̹Ƿ� ���� ���޹��� �ʴ´�.
		 * totalPrice�� �� �ݾ����� ����Ʈ�ܿ��� ���Ż�ǰ���� ������ ���ؼ� �Ѱ��ֵ��� �Ѵ�
		 */
		String totalPrice = request.getParameter("totalPrice");
		String customerId = (String) request.getSession().getAttribute("userId");
		
		if (totalPrice == null || totalPrice.equals("") || customerId == null || customerId.equals("")) {
			throw new NotFoundException("�Է°��� �����մϴ�.");
		}

		Customer customer = new Customer();
		customer.setId(customerId);

		OrderLine orderLine = new OrderLine(Integer.parseInt(totalPrice), customer);

		OrderLineService.insert(orderLine);
		
		ModelAndView mv = new ModelAndView(true, "javaChip?command=selectCart");
		
		return mv;
	}

}
