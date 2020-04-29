package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.service.QnAService;

public class SelectQnAByNoController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");//게시판번호
		QnAService.selectByNo(Integer.parseInt(no));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("");
		return mv;
	}
}
