package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.impl.PersonDAOImpl;
import model.domain.Person;

public class UserStatusController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = (String) request.getSession().getAttribute("userId");

		// userId�� person�� status�� ���ǿ� ����
		if (userId != null) {
			Person person = new PersonDAOImpl().selectById(userId);
			int userStatus = person.getStatus();
			request.getSession().setAttribute("userStatus", userStatus);	
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("community/community.jsp");
		return mv;
	}

}
