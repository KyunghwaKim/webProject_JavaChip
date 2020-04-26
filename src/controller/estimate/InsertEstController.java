package controller.estimate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Customer;
import model.domain.EstimateBoard;
import model.domain.Product;
import model.service.EstimateService;

public class InsertEstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subject = request.getParameter("subject");
		String customerId = request.getParameter("customerId");
		String prodId = request.getParameter("prodId");
		String grade = request.getParameter("grade");

		if (subject == null || subject.equals("") || customerId == null || customerId.equals("") || prodId == null
				|| prodId.equals("") || grade == null || grade.equals("")) {
			throw new NotFoundException("인자값이 부족합니다.");
		}

		Customer customer = new Customer();
		customer.setId(customerId);

		Product product = new Product();
		product.setId(prodId);

		EstimateBoard estBoard = new EstimateBoard(subject, customer, product, Integer.parseInt(grade));

		EstimateService.insert(estBoard);

		ModelAndView mv = new ModelAndView(true, "");

		return mv;
	}

}
