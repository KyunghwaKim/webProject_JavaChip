package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.QnABoard;

public interface QnABoardDAO {
	/**
	 * �Խù� ���
	 */
	int insert(QnABoard qaBoard) throws SQLException;
	
	/**
	 * �Խù� ����(�۳��븸)
	 */
	int update(int qaBoardNo, String content) throws SQLException;
	
	/**
	 * �Խù� ����
	 */
	int delete(int qaBoardNo) throws SQLException;	
	
	/**
	 * ���ۿ� �ش��ϴ� ���� ���� ��ȸ�Ѵ�.	
	 */
	List<QnABoard> selectByName(String id) throws SQLException;
	
	/**
	 *  ��ü����ȸ
	 */	
	List<QnABoard> selectAll() throws SQLException;
		
	/**
	 * (���� or �������� ��ȸ) Ű������ȸ
	 */
	List<QnABoard> selectByKeyword(String keyField, String keyword) throws SQLException;
}
