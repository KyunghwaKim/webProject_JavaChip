package controller.productDetail;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.ProductDetail;
import model.service.ProductDetailService;

public class SelectProductDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prodId = request.getParameter("prodId");
		
		if(prodId == null || prodId.equals("")) {
			throw new NotFoundException("���ڰ� �����մϴ�.");
		}
		
		List<ProductDetail> list = ProductDetailService.selectAll(prodId);
		
		request.setAttribute("prodDetailList", list);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("");
		
		return mv;
	}

}
