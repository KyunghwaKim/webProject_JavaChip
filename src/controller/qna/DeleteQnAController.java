package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.service.QnAService;

public class DeleteQnAController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String qaBoardNo = request.getParameter("qaBoardNo");
		
		if(qaBoardNo==null||qaBoardNo.equals("")) {
			new NotFoundException("���ڰ� �����մϴ�.");
		}
		QnAService.delete(Integer.parseInt(qaBoardNo));
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("javaChip?command=selectAllQnA");
		return mv;
	}

}
