package controller.estimate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.service.EstimateService;

public class InsertEstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subject = request.getParameter("subject");
		String userId = request.getParameter("userId");
		String prodId = request.getParameter("prodId");
		String grade = request.getParameter("grade");
		
//		EstimateService.insert(subject, userId, prodId, Integer.parseInt(grade));
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("");
		return mv;
	}

}
