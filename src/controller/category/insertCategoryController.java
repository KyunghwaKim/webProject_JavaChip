package controller.category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import model.service.CategoryService;

public class insertCategoryController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String categoryName = request.getParameter("categoryName");

		if (categoryName == null || categoryName.equals("")) {
			throw new AddException("�Է°��� �����մϴ�");
		}
		
		CategoryService.insert(categoryName);

		ModelAndView mv = new ModelAndView(true, "");

		return mv;
	}

}
