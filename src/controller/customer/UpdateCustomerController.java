package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Customer;
import model.service.CustomerService;

public class UpdateCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String status = request.getParameter("status");
		String email = request.getParameter("email");

		if (id == null || id.equals("") || pwd == null || pwd.equals("") || phone == null || phone.equals("")
				|| status == null || status.equals("") || email == null || email.equals("")) {
			throw new NotFoundException("�Է°��� �����մϴ�.");
		}

		Customer customer = new Customer(id, pwd, phone, Integer.parseInt(status), email);
		CustomerService.update(customer);

		ModelAndView mv = new ModelAndView(true, "");
		return mv;
	}

}
