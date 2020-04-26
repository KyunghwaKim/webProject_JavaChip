package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Product;
import model.service.ProductService;

public class UpdateProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("prodId");
		String name = request.getParameter("prodName");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String validDate = request.getParameter("validDate");

		if (id == null || id.equals("") || name == null || name.equals("") || price == null || price.equals("")
				|| description == null || description.equals("") || validDate == null || validDate.equals("")) {
			throw new NotFoundException("�Է°��� ������� �ʽ��ϴ�..");
		}
		Product pro = new Product(id, name, Integer.parseInt(price), description, Integer.parseInt(validDate));

		ProductService.insert(pro);
		
		ModelAndView mv = new ModelAndView(true, "");
		return mv;
	}

}
