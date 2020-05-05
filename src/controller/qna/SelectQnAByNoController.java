package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.dao.impl.PersonDAOImpl;
import model.domain.Person;
import model.domain.QnABoard;
import model.service.QnAService;

public class SelectQnAByNoController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");//�Խ��ǹ�ȣ
		QnABoard qnaBoard = QnAService.selectByNo(Integer.parseInt(no));
		
		String userId = qnaBoard.getCustomer().getId();//no�� �Խ����� �ۼ��� ����� id��������
		Person person = new PersonDAOImpl().selectById(userId);//id�� user�� status ��������
		int userStatus = person.getStatus();
		
		request.setAttribute("userStatus", userStatus);//�ۼ����� status
		request.setAttribute("qnaBoard", qnaBoard);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("community//qnaDetail.jsp");
		return mv;
	}
}
