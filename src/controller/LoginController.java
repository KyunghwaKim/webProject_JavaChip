package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.service.PersonService;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(id == null || id.equals("") || pwd == null || pwd.equals("")) {
			throw new NotFoundException("입력값이 부족합니다");
		}
		
		PersonService.login(id, pwd);
		
		ModelAndView mv = new ModelAndView(true, "");
		
		return mv;
	}

}
