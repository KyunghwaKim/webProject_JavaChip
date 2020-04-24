package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.EstimateBoardDAO;
import model.dao.impl.EstimateBoardDAOImpl;
import model.domain.EstimateBoard;

public class EstimateService {
	static EstimateBoardDAO dao = new EstimateBoardDAOImpl();
	
	
	/**
	 * ������ ���
	 * @param subject
	 * @param userId
	 * @param prodId
	 * @param parseInt
	 */
	public static void insert(String subject, String userId, String prodId, int grade) {
		try {
			dao.insert(subject, userId, prodId, grade);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * ������ ����
	 * @param parseInt
	 */
	public static void delete(int no) {
		try {
			dao.delete(no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ü ������ ���� ������ ��ȸ
	 * @return
	 */
	public static List<EstimateBoard> selectByGrade() {
		List<EstimateBoard> list=null;
		try {
			list = dao.selectByGrade();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static List<EstimateBoard> selectAll() {
		List<EstimateBoard> list=null;
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
