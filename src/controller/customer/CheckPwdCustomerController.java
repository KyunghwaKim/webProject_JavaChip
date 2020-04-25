package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.InconsistencyException;
import exception.NotEnoughException;
import model.domain.Customer;
import model.service.CustomerService;

public class CheckPwdCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(id==null||id.equals("")||pwd==null||pwd.equals("")) {
			throw new NotEnoughException("�Է°��� �����մϴ�.");
		}
		
		Customer customer = CustomerService.selectById(id);
		
		if(!customer.getPwd().equals(pwd)) {
			throw new InconsistencyException("�߸��� ��й�ȣ�Դϴ�.");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("");
		
		return mv;
	}

}
