package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.QnABoardDAO;
import model.dao.impl.QnABoardDAOImpl;
import model.domain.QnABoard;

public class QnAService {
	static QnABoardDAO dao = new QnABoardDAOImpl();
	
	/**
	 * �Խñ� ���
	 */
//	public static int insert(String subject, String title, String prodId, String id) throws SQLException{
//		return dao.insert(subject, title, prodId, id);
//	}
	
	/**
	 * �Խñ� ����
	 * @param �Խñ� ��ȣ
	 */
	public static int delete(int qaBoardNo) throws SQLException{
		return dao.delete(qaBoardNo);
	}
	
	/**
	 * �Խñ� ���� ����
	 */
	public static int update(int qaBoardNo, String content) throws SQLException{
		return dao.update(qaBoardNo, content);
		
	}
		
	/**
	 * ��ü �Խñ� ��ȸ
	 * @throws SQLException 
	 */
	public static List<QnABoard> selectAll() throws SQLException {
		return dao.selectAll();
		
	}
	
	/**
	 * ���� �� �Խñ� ��ȸ
	 * @param id
	 * @throws SQLException 
	 */
	public static List<QnABoard> selectById(String customerId) throws SQLException {
		return dao.selectByName(customerId);
		
	}
}
