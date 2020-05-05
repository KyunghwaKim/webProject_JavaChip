package controller.estimate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.service.EstimateService;

public class DeleteEstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String estimateNo = request.getParameter("estimateNo"); // ������ ������ ��ȣ

		if (estimateNo == null || estimateNo.equals("")) {
			throw new NotFoundException("���ڰ��� �����մϴ�.");
		}
		EstimateService.delete(Integer.parseInt(estimateNo));

		ModelAndView mv = new ModelAndView(true, "javaChip?command=selectAllEst");
		
		return mv;
	}

}
