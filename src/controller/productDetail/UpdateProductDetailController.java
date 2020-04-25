package controller.productDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import exception.NotFoundException;
import model.domain.Product;
import model.domain.ProductDetail;
import model.domain.Storage;
import model.service.ProductDetailService;

public class UpdateProductDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String chapter = request.getParameter("chapter");
		String fileId = request.getParameter("file_id");
		String prodId = request.getParameter("prod_id");

		if (chapter == null || chapter.equals("") || fileId == null || fileId.equals("") || prodId == null
				|| prodId.equals("")) {
			new NotFoundException("���ڰ� �����մϴ�.");
		}

		Product product = new Product();
		product.setId(prodId);
		Storage storage = new Storage();
		storage.setId(fileId);

		ProductDetail productDetail = new ProductDetail(chapter, null, null, storage, product);

		ProductDetailService.update(productDetail);

		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("");
		return mv;

	}

}
