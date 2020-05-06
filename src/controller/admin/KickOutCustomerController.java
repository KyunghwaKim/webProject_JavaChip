package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.service.PersonService;

public class KickOutCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String adminId = (String) request.getSession().getAttribute("userId");
		String customerId = request.getParameter("customerId");

		if (adminId == null || adminId.equals("") || customerId == null || customerId.equals("")) {
			throw new NotFoundException("인자가 부족합니다.");
		}
		
		PersonService.updateStatus(adminId, customerId);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("javaChip?command=SelectAllperson");
		
		return mv;
	}

}
