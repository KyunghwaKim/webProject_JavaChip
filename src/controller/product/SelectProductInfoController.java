package controller.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.EstimateBoard;
import model.domain.ProductDetail;
import model.service.ProductService;

public class SelectProductInfoController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prodId = request.getParameter("prodId");
		
		if(prodId==null||prodId.equals("")) {
			throw new NotFoundException("존재하지 않는 상품번호입니다.");
		}
		
		Map<ProductDetail, EstimateBoard> map = ProductService.selectProdInfo(prodId);
		
		for(ProductDetail key : map.keySet()) {
			request.setAttribute("prodDetail", key);
			request.setAttribute("estimate", map.get(key));
		}
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("detail_information/detail.jsp");
		 
		return mv; 
	}

}
