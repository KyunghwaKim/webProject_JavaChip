package controller.productDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.domain.Product;
import model.domain.ProductDetail;
import model.service.ProductDetailService;

public class DeleteProductDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String prodId = request.getParameter("prod_id");
		
		Product product = new Product();
		product.setId(prodId);
		
		ProductDetail productDetail = new ProductDetail();
		productDetail.setProduct(product);
		
		
		
		
		ProductDetailService.delete(productDetail);
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("");
		return mv;
	}

}
