package controller.productDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import model.domain.Product;
import model.domain.ProductDetail;
import model.domain.Storage;

public class UpdateProductDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String chapter = request.getParameter("chapter");
		String url = request.getParameter("prod_url");
		String title = request.getParameter("prod_title");
		String fileId = request.getParameter("file_id");
		String prod_id = request.getParameter("prod_id");
		
		if(chapter==null || chapter.equals("") || url==null || url.equals("") ||
				title==null || title.equals("") || fileId==null || fileId.equals("")) {
			new AddException("상품정보  입력실패");
		}
		

		
		Product product = new Product();
		product.setId(prod_id);
		Storage storage = new Storage();
		storage.setId(fileId);
		
		ProductDetail productDetail = new ProductDetail(chapter, url, title, storage, product);
		
		//OrderItemService.update(orderItem);
		
		

		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("");
		return mv;
		
	}

}
