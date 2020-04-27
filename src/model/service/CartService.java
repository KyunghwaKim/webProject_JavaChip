package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.CartDAO;
import model.dao.impl.CartDAOImpl;
import model.domain.Cart;

public class CartService {
	static CartDAO cartDAO = new CartDAOImpl();
	
	/**
	 * ��ٱ��Ͽ� ��� ��ǰ ��ȸ
	 * @return List<Product>
	 * @throws SQLException
	 */
	public static List<Cart> selectAll(String customerId) throws SQLException {
		return cartDAO.selectAll(customerId);
	}
	
	/**
	 * ��ٱ��� ���
	 * @param product
	 * @throws SQLException
	 */
	public static void insert(String customerId, String prodId) throws SQLException {
		int result = cartDAO.insert(customerId, prodId);
		if(result==0) { //����
			throw new SQLException("��ٱ��� ��⿡ �����߽��ϴ�.");
		}
	}
	
	/**
	 * ���� ��ǰ ��ٱ��� ��Ͽ��� ����
	 */
	public static void delete(String customerId, List<String> list) throws SQLException {
		for (String prodId : list) {
			int result = cartDAO.delete(customerId, prodId);
			if (result == 0) {
				throw new SQLException("�����ϴµ� �����߽��ϴ�.");
			}
		}
	}

	public static void deleteAll(String customerId) throws SQLException {
		int result = cartDAO.deleteAll(customerId);
		if (result == 0) {
			throw new SQLException("��ü�����ϴµ� �����߽��ϴ�.");
		}
		
	}
}
