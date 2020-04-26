package controller.category;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Teacher;
import model.service.CategoryService;

public class SelectCategoryController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String categoryId = request.getParameter("categoryId"); 
		
		if(categoryId==null || categoryId.equals("")) {
			throw new NotFoundException("�Է°��� �����մϴ�.");
		}
		
		List<Teacher> teacherList = CategoryService.selectById(Integer.parseInt(categoryId));
		request.setAttribute("teacherList", teacherList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("");
		return mv;
	}

}
