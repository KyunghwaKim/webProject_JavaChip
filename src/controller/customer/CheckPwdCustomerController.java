package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Customer;
import model.service.CustomerService;

public class CheckPwdCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(id==null||id.equals("")||pwd==null||pwd.equals("")) {
			throw new NotFoundException("�Է°��� �����մϴ�.");
		}
		
		Customer customer = CustomerService.selectById(id);
		
		if(!customer.getPwd().equals(pwd)) {
			throw new NotFoundException("�߸��� ��й�ȣ�Դϴ�.");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("");
		
		return mv;
	}

}
