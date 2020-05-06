package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Customer;
import model.service.CustomerService;

public class pwdCheckController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");
		String pwd = request.getParameter("pwd");

		Customer customer = CustomerService.selectById(id);
		String getpwd = customer.getPwd();
		request.setAttribute("getpwd", getpwd);
		
		if(!pwd.equals(getpwd)) {
			throw new NotFoundException("�߸��� ��й�ȣ�Դϴ�");
		}
		
		ModelAndView mv = new ModelAndView(false, "mypage/updatepwd.jsp");
		
		return mv;
	}

}
