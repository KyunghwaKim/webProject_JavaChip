package controller.category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import model.domain.Category;
import model.service.CategoryService;

public class insertCategoryController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String cateid = request.getParameter("id");
		String catename = request.getParameter("name");
				
			if(catename==null || catename.equals("")) {
				throw new AddException("입력값이 부족합니다");
			}
		Category category = new Category(Integer.parseInt(cateid),catename);
		
		CategoryService.insert(category);
		
		ModelAndView mv = new ModelAndView(true, "");
		
		return mv;
	}

}
