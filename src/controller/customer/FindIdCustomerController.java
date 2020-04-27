package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.service.CustomerService;

public class FindIdCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		if (name == null || name.equals("") || phone == null || phone.equals("")) {
			throw new NotFoundException("�Է°��� �����մϴ�.");
		}

		String findCustomerId = CustomerService.findId(name, phone);

		request.setAttribute("findCustomerId", findCustomerId);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("");

		return mv;
	}

}
