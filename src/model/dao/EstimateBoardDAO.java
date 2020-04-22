package model.dao;

import java.sql.SQLException;

import model.domain.EstimateBoard;

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
}
