package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Category;
import model.domain.Product;
import model.domain.Teacher;
import model.service.ProductService;;

public class InsertProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("prod_id");
		String name = request.getParameter("prod_name");
		String price = request.getParameter("prod_price");
		String description = request.getParameter("description");
		String level = request.getParameter("prod_level");
		String teacherId = request.getParameter("teacher_id");
		String categoryId = request.getParameter("category_id");
		String validDate = request.getParameter("valid_Date");

		if (id == null || id.equals("") || name == null || name.equals("") || price == null || price.equals("")
				|| description == null || description.equals("") || level == null || level.equals("")
				|| teacherId == null || teacherId.equals("") || categoryId == null || categoryId.equals("")
				|| validDate == null || validDate.equals("")) {

			throw new NotFoundException("�Է°��� ������� �ʽ��ϴ�..");
		}

		Category category = new Category();
		category.setId(Integer.parseInt(categoryId));
		
		Teacher teacher = new Teacher();
		teacher.setId(teacherId);

		Product product = new Product(id, name, Integer.parseInt(price), description, level, teacher, category, null,
				Integer.parseInt(validDate));

		ProductService.insert(product);
		ModelAndView mv = new ModelAndView(true, "");
		return mv;
	}

}
