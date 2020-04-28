package controller.orderLine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import exception.NotFoundException;
import model.domain.Customer;
import model.domain.OrderItem;
import model.domain.OrderLine;
import model.domain.Product;
import model.service.OrderLineService;

public class InsertOrderLineController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prodId = request.getParameter("prodId");
		String price = request.getParameter("price");
		String validDate = request.getParameter("validDate");
		String customerId = (String) request.getSession().getAttribute("userId");

		if (prodId == null || prodId.equals("") || price == null || price.equals("") || validDate == null
				|| validDate.equals("") || customerId == null || customerId.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}

		Customer customer = new Customer();
		customer.setId(customerId);
		
		OrderLine orderLine = new OrderLine();
		orderLine.setCustomer(customer);
		
		Product product = new Product();
		product.setId(prodId);
		product.setPrice(Integer.parseInt(price));
		product.setValidDate(Integer.parseInt(validDate));
		
		OrderItem orderIem = new OrderItem(null, orderLine, product);

		OrderLineService.insert(orderIem);

		ModelAndView mv = new ModelAndView(true, "javaChip?command=selectCart");
		return mv;
	}

}
