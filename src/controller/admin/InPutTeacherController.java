package controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import model.domain.Category;
import model.service.CategoryService;

public class InPutTeacherController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		List<Category> clist = CategoryService.selectAll();
		HttpSession session = request.getSession();
		
		session.setAttribute("clist", clist);
		
		ModelAndView mv = new ModelAndView();	
		mv.setRedirect(true);
		mv.setViewName("Admin/form.jsp");	
		
		return mv;
	}

}
