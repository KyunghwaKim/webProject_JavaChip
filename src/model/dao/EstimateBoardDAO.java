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
	int delete(int no) throws SQLException;
	
	/**
	 * ���ۿ� �ش��ϴ� ���� ���� ��ȸ�Ѵ�.	
	 */
	List<EstimateBoard> selectByName(String id) throws SQLException;
	
	/**
	 *  ��ü����ȸ
	 */	
	List<EstimateBoard> selectAll() throws SQLException;
		
	/**
	 * (���Ǹ� / ����� / ���� ��ȸ) Ű������ȸ
	 */
	List<EstimateBoard> selectByKeyword(String keyField, String keyword) throws SQLException;
	
	/**
	 * �Խù� ���
	 */
	int insert(String subject, String userId, String prodId, int grade) throws SQLException;

	int delete(EstimateBoard estimate) throws SQLException;

	List<EstimateBoard> selectByGrade() throws SQLException;
	
}
