package controller.orderLine;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		String lineNo = request.getParameter("lineNo");
		String totalPrice = request.getParameter("totalPrice");
		String payDate = request.getParameter("payDate");
		String customerId = request.getParameter("customerId");

		if (lineNo == null || lineNo.equals("") || totalPrice == null || totalPrice.equals("") || payDate == null
				|| payDate.equals("") || customerId == null || customerId.equals("")) {
			throw new AddException("입력값이 부족합니다.");
		}

		Customer customer = new Customer();
		customer.setId(customerId);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(payDate);

		OrderLine orderLine = new OrderLine(Integer.parseInt(lineNo), Integer.parseInt(totalPrice), date, customer);

		OrderLineService.insert(orderLine);
		
		ModelAndView mv = new ModelAndView(true, "");
		
		return mv;
	}

}
