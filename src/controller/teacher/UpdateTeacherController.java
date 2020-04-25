package controller.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Person;
import model.service.TeacherService;

public class UpdateTeacherController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String status = request.getParameter("status");

		if (id == null || id.equals("") || pwd == null || pwd.equals("") || phone == null || phone.equals("")
				|| status == null || status.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}

		Person teacher = new Person(id, pwd, phone, Integer.parseInt(status));
		TeacherService.update(teacher);

		ModelAndView mv = new ModelAndView(true, "");
		return mv;
	}

}
