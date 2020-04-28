package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Person;
import model.service.PersonService;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(id == null || id.equals("") || pwd == null || pwd.equals("")) {
			throw new NotFoundException("�Է°��� �����մϴ�");
		}
		
		Person person = PersonService.login(id, pwd);
		System.out.println(person.getStatus());
		
		HttpSession session = request.getSession();
		session.setAttribute("userId" , id);
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		
		if(person.getStatus() == 3) {
			
			mv.setViewName("Admin/index.jsp");
			
		} else {
			
			mv.setViewName("marga/index.jsp");
		}
		
		
		return mv;
	}

}
