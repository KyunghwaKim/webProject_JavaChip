package controller.orderLine;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Customer;
import model.domain.OrderItem;
import model.service.CustomerService;
import model.service.OrderLineService;

public class SelectByCustomerIdOrderLineController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerId = (String)request.getSession().getAttribute("userId");	//���ǿ��� �α����� ȸ���� ���̵� �޾ƿ´�

		if (customerId == null || customerId.equals("")) {
			throw new NotFoundException("�Է°��� �����մϴ�.");
		}
		 
		List<OrderItem> orderList = OrderLineService.selectByCustomerId(customerId);
		Customer customer = CustomerService.selectById(customerId);
		
		for(OrderItem oi : orderList) {
			
			Date sysdate = new Date();
			Date date = oi.getOrderLine().getPayDate();
			Calendar cal = Calendar.getInstance();			
			 
			cal.setTime(date);			
			cal.add(Calendar.DATE, 7); 
			
			//7�������̸� ȯ�Ұ���..
			boolean result = sysdate.before(cal.getTime());
			
			oi.getOrderLine().setCanrefund(result);
			
		}
		
		request.setAttribute("orderList", orderList);
		request.setAttribute("user", customer);
		
		List<OrderItem> myLectureList = new ArrayList<OrderItem>();
		for(OrderItem item : orderList) {
			if(item.getIsRefund()==1) {
				myLectureList.add(item);
			}
		}
		request.setAttribute("myLectureList", myLectureList);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("mypage/mypage.jsp");

		return mv;
	}

}
