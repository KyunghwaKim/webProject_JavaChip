package controller.cart;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.domain.Product;
import model.service.CartService;

public class DeleteCartController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");//user_id
		//product��ü�� ����Ʈ Ÿ������ �����;� �Ѵ� --> front���� list���·� �����ؾ� ��
		Product product = (Product) request.getAttribute("product");
		

		//Product product = new Product(prodId);
		//list.add(product);
		
		//CartService.delete(list);
		//request.setAttribute("list", list);
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("");
		return null;
	}

}
