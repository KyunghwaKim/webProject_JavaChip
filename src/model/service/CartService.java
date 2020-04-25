package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.CartDAO;
import model.dao.impl.CartDAOImpl;
import model.domain.Product;

public class CartService {
	static CartDAO dao = new CartDAOImpl();
	
	/**
	 * ��ٱ��Ͽ� ��� ��ǰ ��ȸ
	 * @return List<Product>
	 * @throws SQLException
	 */
	public static List<Product> selectAll(String customerId) throws SQLException {
		List<Product> list = dao.selectAll(customerId);
		return list;
	}
	
	/**
	 * ��ٱ��� ���
	 * @param product
	 * @throws SQLException
	 */
	public static void insert(String customerId, String prodId) throws SQLException {
		int result = dao.insert(customerId, prodId);
		if(result==0) { //����
			throw new SQLException("��ٱ��� ��⿡ �����߽��ϴ�.");
		}
	}
	
	/**
	 * ��ٱ��� ��� ��ü ����
	 * @throws SQLException 
	 */
	public static void deleteAll(String customerId) throws SQLException {
		int result = dao.deleteAll(customerId);
		if(result==0) {
			throw new SQLException("��ٱ��� ��� ���⿡ �����߽��ϴ�.");
		}
	}
	
	/**
	 * ���� ��ǰ ��ٱ��Ͽ��� ����
	 * @param userId, prodId
	 * @throws SQLException
	 */
	public static void deleteById(String customerId, String prodId) throws SQLException {
		int result = dao.deleteById(customerId, prodId);
		if(result==0) {
			throw new SQLException("��ٱ��Ͽ��� �����ϴµ� �����߽��ϴ�.");
		}
	}
	
	/**
	 * ���� ��ǰ ��ٱ��� ��Ͽ��� ���� - ���� ��
	 */
	public static void delete(String customerId, List<Product> list) throws SQLException {
		int result = dao.delete(customerId, list);
		if(result==0) {
			throw new SQLException("�����ϴµ� �����߽��ϴ�.");
		}
	}
	
}
