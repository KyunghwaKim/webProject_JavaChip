package controller.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Cart;
import model.service.CartService;

public class SelectCartController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerId = request.getParameter("id");
		if(customerId==null || customerId.equals("")) {
			throw new NotFoundException("��ٱ��� ��ȸ�� ���� �� id�� ã�� �� �����ϴ�.");
		}
		List<Cart> list = CartService.selectAll(customerId);
		request.setAttribute("cartList", list);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mycart/cart/myCart.jsp");
		return mv;
	}

}
