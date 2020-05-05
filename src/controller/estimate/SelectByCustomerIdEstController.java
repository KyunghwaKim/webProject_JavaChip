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
			throw new NotFoundException("���ڰ� �����մϴ�.");
		}
		List<EstimateBoard> estimateList = EstimateService.selectByCustomerId(customerId);
		System.out.println(estimateList);
		request.setAttribute("estimateList", estimateList);
		
		//��Ʈ�ѷ����� ������ ���ǿ� ���� ������ �ۼ� data�� �ִ��� �˻��Ѵ�
		for(EstimateBoard estBoard:estimateList) {
			System.out.println(estBoard.getProduct().getId());
		}
		
		
		ModelAndView mv=new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("javaChip?command=selectAllEst");
		
		/*if(estimateList.isEmpty()) { //�ۼ��� �������� ����
			mv = new ModelAndView();
			mv.setViewName("");//community/evaluateForm.jsp
		}else { //�ۼ��� �������� ����
			mv = new ModelAndView();
			mv.setRedirect(true);
			mv.setViewName("");//javaChip?command=selectAllEst
			//request.setAttribute("estimateList", estimateList);
		}*/
		
		return mv;
	}

}
