package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.QnABoardDAO;
import model.dao.impl.QnABoardDAOImpl;
import model.domain.QnABoard;

public class QnAService {
	static QnABoardDAO qaDAO = new QnABoardDAOImpl();
	
	/**
	 * �Խñ� ���
	 */
	public static int insert(QnABoard qaBoard) throws SQLException{
		return qaDAO.insert(qaBoard);
	}
	
	/**
	 * �Խñ� ����
	 * @param �Խñ� ��ȣ
	 */
	public static int delete(int qaBoardNo) throws SQLException{
		return qaDAO.delete(qaBoardNo);
	}
	
	/**
	 * �Խñ� ���� ����
	 */
	public static int update(int qaBoardNo, String content) throws SQLException{
		return qaDAO.update(qaBoardNo, content);
		
	}
		
	/**
	 * ��ü �Խñ� ��ȸ
	 * @throws SQLException 
	 */
	public static List<QnABoard> selectAll() throws SQLException {
		return qaDAO.selectAll();
		
	}
	
	/**
	 * ���� �� �Խñ� ��ȸ
	 * @param id
	 * @throws SQLException 
	 */
	public static List<QnABoard> selectById(String id) throws SQLException {
		return qaDAO.selectById(id);
		
	}
	
	public static List<QnABoard> selectByKeyword(String keyField, String keyword) throws SQLException {
		return qaDAO.selectByKeyword(keyField, keyword);
	}
	
	/**
	 * �Խñ� ��ȣ�� ��ȸ
	 */
	public static QnABoard selectByNo(int no) throws SQLException {
		return qaDAO.selectByNo(no);	
	}
	
	/**
	 * ��ȸ�� ����
	 */
	public static int addViewCount(int no) throws SQLException{
		return qaDAO.addViewCount(no);
	}
	
	/**
	 * �亯 ���
	 * @return 
	 * @throws SQLException 
	 */
	public static int insertAnswer(String subject, String title, String prodId, int parentNumber, String id) throws SQLException {
		return qaDAO.insertAnswer(subject, title, prodId, parentNumber, id);
		
	}
}
