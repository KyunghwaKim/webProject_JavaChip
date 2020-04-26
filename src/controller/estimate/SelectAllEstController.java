package controller.estimate;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.domain.EstimateBoard;
import model.service.EstimateService;

public class SelectAllEstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<EstimateBoard> estimateList = EstimateService.selectAll();

		request.setAttribute("estimateList", estimateList);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("");

		return mv;
	}

}
