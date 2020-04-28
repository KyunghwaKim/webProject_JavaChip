package controller.qna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.domain.QnABoard;
import model.service.QnAService;

public class SelectAllQnAController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<QnABoard> list = QnAService.selectAll();
		request.setAttribute("QnAList", list);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("community/Q&Aboard.jsp");
		return mv;
	}

}
