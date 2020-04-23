package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.EstimateBoard;
import model.domain.QnABoard;

public interface EstimateBoardDAO {
	/**
	 * �Խù� ���
	 */
	int insert(EstimateBoard estimate) throws SQLException;
	
	/**
	 * �Խù� ����
	 */
	int update(EstimateBoard estimate) throws SQLException;
	
	/**
	 * �Խù� ����
	 */
	int delete(EstimateBoard estimate) throws SQLException;
	
	/**
	 * ���ۿ� �ش��ϴ� ���� ���� ��ȸ�Ѵ�.	
	 */
	List<QnABoard> selectByName(String id) throws SQLException;
	
	/**
	 *  ��ü����ȸ
	 */	
	List<QnABoard> selectAll() throws SQLException;
		
	/**
	 * (���Ǹ� / ����� / ���� ��ȸ) Ű������ȸ
	 */
	List<QnABoard> selectByKeyword(String keyField, String keyword) throws SQLException;
	
}
