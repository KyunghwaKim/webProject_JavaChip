package controller.orderLine;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.OrderItem;
import model.service.OrderLineService;

public class SelectByCustomerIdOrderLineController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerId = (String)request.getSession().getAttribute("id");	//���ǿ��� �α����� ȸ���� ���̵� �޾ƿ´�

		if (customerId == null || customerId.equals("")) {
			throw new NotFoundException("�Է°��� �����մϴ�.");
		}
		
		List<OrderItem> orderList = OrderLineService.selectByCustomerId("id");
		request.setAttribute("orderList", orderList);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("mypage/mypage.jsp");

		return mv;
	}

}
