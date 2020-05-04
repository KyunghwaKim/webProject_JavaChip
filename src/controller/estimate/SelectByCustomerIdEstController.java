package controller.estimate;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.EstimateBoard;
import model.service.EstimateService;

public class SelectByCustomerIdEstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerId = (String) request.getSession().getAttribute("userId");
		
		if (customerId == null || customerId.equals("")) {
			throw new NotFoundException("인자가 부족합니다.");
		}
		List<EstimateBoard> estimateList = EstimateService.selectByCustomerId(customerId);
		ModelAndView mv=null;
		System.out.println(estimateList);
		if(estimateList.isEmpty()) { //작성한 강의평이 없음
			mv = new ModelAndView();
			mv.setViewName("community/evaluateForm.jsp");
		}else { //작성한 강의평이 있음
			mv = new ModelAndView();
			mv.setRedirect(true);
			mv.setViewName("javaChip?command=selectAllEst");
		}
		//request.setAttribute("estimateList", estimateList);
		return mv;
	}

}
