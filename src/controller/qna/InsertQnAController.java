package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import model.domain.Customer;
import model.domain.Product;
import model.domain.QnABoard;
import model.service.QnAService;

public class InsertQnAController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subject = request.getParameter("content");
		//String id = request.getParameter("id");
		String id = (String) request.getSession().getAttribute("userId"); //���ǿ��� �޴� ������ ����
		String prodId = request.getParameter("prodId");
		String title = request.getParameter("title");
		String status = request.getParameter("status");
		String pwd = request.getParameter("pwd");
		System.out.println(pwd);
		if (subject == null || subject.equals("") || title == null || title.equals("") || prodId == null
				|| prodId.equals("") || id == null || id.equals("")) {
			new AddException("�Խñ� �߰��� �ʿ��� �Է°��� �����մϴ�.");
		}
		
		
		Customer customer = new Customer();
		customer.setId(id);
		
		Product product = new Product();
		product.setId(prodId);
		
		
		if(pwd == null || pwd.equals("")) { //�Ϲݱ��� ��� ��й�ȣ 1234�� ����..
			QnABoard qaBoard=new QnABoard(subject, customer, product, title, Integer.parseInt(status));
			qaBoard.setPwd(1234);
			QnAService.insert(qaBoard);
		}else {
			QnABoard qaBoard = new QnABoard(subject, customer, product, title, Integer.parseInt(status), Integer.parseInt(pwd));
			QnAService.insert(qaBoard);
		}
		
		ModelAndView mv = new ModelAndView(true, "javaChip?command=selectAllQnA");
		
		return mv;
	}

}
