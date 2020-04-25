package controller.productDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import model.domain.Product;
import model.domain.Storage;

public class InsertProductDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			
			String chapter = request.getParameter("chapter");
			String url = request.getParameter("prod_url");
			String title = request.getParameter("prod_title");
			String storage = request.getParameter("file_id");
			String prod_id = request.getParameter("prod_id");
			if(chapter==null || chapter.equals("") || url==null || url.equals("") ||
					title==null || title.equals("") || storage==null || storage.equals("")) {
				new AddException("상품정보  입력실패");
			}

			ModelAndView mv = new ModelAndView();
			mv.setRedirect(true);
			mv.setViewName("");
			return mv;
			
	}

}
