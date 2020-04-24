package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import model.service.QnAService;

public class InsertQnAController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subject = request.getParameter("subject");
		String title = request.getParameter("title");
		String prodId = request.getParameter("prod_id");
		String id = request.getParameter("id");
		if(subject==null || subject.equals("") || title==null || title.equals("")) {
			new AddException("게시글 추가에 필요한 입력값이 부족합니다.");
		}
//		QnAService.insert(subject, title, prodId, id);
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("");
		return mv;
	}

}
