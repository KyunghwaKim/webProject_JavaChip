package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import model.dao.impl.PersonDAOImpl;
import model.domain.Customer;
import model.domain.Person;
import model.domain.Product;
import model.domain.QnABoard;
import model.service.QnAService;

public class InsertQnAController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = (String) request.getSession().getAttribute("userId");
		Person person = new PersonDAOImpl().selectById(id);
		int userStatus = person.getStatus();
		
		if(userStatus==1) {
			String subject = request.getParameter("content");
			String prodId = request.getParameter("prodId");
			String title = request.getParameter("title");
			String status = request.getParameter("status");
			String pwd = request.getParameter("pwd");
			
			if (subject == null || subject.equals("") || title == null || title.equals("") || prodId == null
					|| prodId.equals("") || id == null || id.equals("")) {
				new AddException("�Խñ� �߰��� �ʿ��� �Է°��� �����մϴ�.");
			}
			
			Customer customer = new Customer();
			customer.setId(id);
			
			Product product = new Product();
			product.setId(prodId);
			
			if(pwd == null || pwd.equals("")) { //�Ϲݱ�
				QnABoard qaBoard=new QnABoard(subject, customer, product, title, Integer.parseInt(status));
				qaBoard.setPwd(0); //�Ϲݱ��� ��� �⺻ ��й�ȣ 0 ����
				QnAService.insert(qaBoard);
			}else { //��б�
				QnABoard qaBoard = new QnABoard(subject, customer, product, title, Integer.parseInt(status), Integer.parseInt(pwd));
				QnAService.insert(qaBoard);
			}
		}else if(userStatus==2) {//��� �ۼ� 
			String subject = request.getParameter("content");
			String title = request.getParameter("title");
			String prodId = request.getParameter("prodId");
			String parentNumber = request.getParameter("no"); //�Խñ� ��ȣ
			QnAService.insertAnswer(subject, title, prodId, Integer.parseInt(parentNumber), id);
		}
	
		ModelAndView mv = new ModelAndView(true, "javaChip?command=selectAllQnA");
		return mv;
	}

}
