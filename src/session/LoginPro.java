package session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginPro extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� â�� �������� �˷��ֱ� & �ѱ����ڵ� �����ϱ�
		response.setContentType("text/html;charset=UTF-8");
		
		String dbId="jang", dbPwd="1234";
		//�Ѿ���� data �ޱ�
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		
		if(dbId.equals(userId) && dbPwd.equals(userPwd)){		
			//������ ������� ������ session�� �����Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("sessionName", userName);
			session.setAttribute("sessionTime", new Date().toLocaleString());
												//�α��εǾ����� �� ������ �ð�
			
			//�̵��ϱ�
			response.sendRedirect("session/LoginOk.jsp");
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('"+userName+"�� ������ Ȯ�����ּ���.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
}
