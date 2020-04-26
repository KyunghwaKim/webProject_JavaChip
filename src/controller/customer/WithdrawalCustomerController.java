package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.service.CustomerService;

public class WithdrawalCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");

		if (id == null || id.equals("")) {
			throw new NotFoundException("�Է°��� �����մϴ�.");
		}
		
		CustomerService.withdrawal(id);

		ModelAndView mv = new ModelAndView(true, "");
		return mv;
	}

}
