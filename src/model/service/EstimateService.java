package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.EstimateBoardDAO;
import model.dao.impl.EstimateBoardDAOImpl;
import model.domain.EstimateBoard;

public class EstimateService {
	static EstimateBoardDAO estimateDAO = new EstimateBoardDAOImpl();

	/**
	 * ������ ���
	 */
	public static void insert(EstimateBoard estBoard) throws SQLException {
		int result = estimateDAO.insert(estBoard);
		if (result == 0) {
			throw new SQLException("������ �ۼ��� �����Ͽ����ϴ�.");
		}

	}

	/**
	 * ������ ����
	 */
	public static void delete(int estimateNo) throws SQLException {
		int result = estimateDAO.delete(estimateNo);
		if (result == 0) {
			throw new SQLException("������ ������ �����Ͽ����ϴ�.");
		}
	}

	public static List<EstimateBoard> selectAll() throws SQLException {
		return estimateDAO.selectAll();
	}

	public static void update(EstimateBoard estBoard) throws SQLException {
		int result = estimateDAO.update(estBoard);
		if (result == 0) {
			throw new SQLException("������ ������ �����Ͽ����ϴ�.");
		}
	}

	public static List<EstimateBoard> selectByCustomerId(String customerId) throws SQLException {
		return estimateDAO.selectByCustomerId(customerId);
	}

	public static List<EstimateBoard> selectByKeyword(String keyField, String keyword) throws SQLException {
		return estimateDAO.selectByKeyword(keyField, keyword);
	}

	public static EstimateBoard selectByNo(int no) throws SQLException {
		return estimateDAO.selectByNo(no);
	}

}
