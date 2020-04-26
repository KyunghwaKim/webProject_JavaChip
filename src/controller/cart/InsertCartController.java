package controller.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import exception.NotFoundException;
import model.domain.Cart;
import model.domain.Customer;
import model.domain.Product;
import model.service.CartService;

public class InsertCartController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String customerId = request.getParameter("id");
		String prodId = request.getParameter("prodId");
		
		if(customerId==null || customerId.equals("") || prodId==null || prodId.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}
		
		CartService.insert(customerId, prodId);

		ModelAndView mv = new ModelAndView(true, "");
		
		return mv;
	}

}
