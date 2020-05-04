package controller.productDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import model.domain.Product;
import model.domain.ProductDetail;
import model.domain.Storage;
import model.service.ProductDetailService;

public class InsertProductDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ProductDetail pd = new ProductDetail();
		
		String saveDir = request.getServletContext().getRealPath("/save");
		int maxSize = 1024*1024*100; // 100M
		String encoding="UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String prodnum = m.getParameter("model_num");		
		String chapter = m.getParameter("chapter_num");
		String title = m.getParameter("title");
		
		String videofileName = m.getFilesystemName("video_file");
		String url = videofileName;
		
		Product product = new Product();
		product.setId(prodnum);
		
		if(m.getFilesystemName("text_file") != null && m.getFile("text_file").length() > 0 ) {
			
			// �����ڷᰡ �����Ѵٸ�...
			String textfileName = m.getFilesystemName("text_file");
			Storage storage = new Storage(textfileName, textfileName);
			pd = new ProductDetail(chapter, url, title, storage, product);
					
		} else {
			
			// �����ڷᰡ ���ٸ�...				
			pd = new ProductDetail(chapter, url, title, product);			
		}		
		
		ProductDetailService.insert(pd);

		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("Admin/insertOk.jsp");
		return mv;

	}

}
