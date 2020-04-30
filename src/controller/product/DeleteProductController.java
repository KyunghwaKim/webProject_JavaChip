package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.ModifyException;
import model.service.ProductService;

public class DeleteProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("����Ʈ��Ʈ�ѷ�ȣ���....");
		String id = request.getParameter("delete");
		
		int i = ProductService.deleteProd(id);
		
		if(i==0) {
			throw new ModifyException("�������� ����");
		} 
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("Admin/table.jsp");
		
		return mv;
	}

}
