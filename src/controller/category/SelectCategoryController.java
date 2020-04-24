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
		
		String categoryname = request.getParameter("categoryname"); 
		if(categoryname==null || categoryname.equals("")) {
			throw new NotFoundException("이름이 없습니다");
		}
		
		List<Teacher> list = CategoryService.selectById(categoryname);
		request.setAttribute("teacherlist", list);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("");
		return mv;
	}

}
