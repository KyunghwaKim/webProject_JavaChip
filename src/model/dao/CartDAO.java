package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.Cart;

public interface CartDAO {
	/**
	 * ��ٱ��� ��ü��ȸ
	 * @return List<Product>
	 */
	List<Cart> selectAll(String customerId) throws SQLException;
	
	/**
	 * ��ٱ��� ��ǰ �߰�
	 * @return int - 0: ���� / 0�� �ƴϸ� ����
	 */
	int insert(String customerId, String prodId) throws SQLException;
	
	/**
	 * ��ٱ��� ��ǰ ����
	 * @return int - 0: ���� / 0�� �ƴϸ� ����
	 */
	int delete(String customerId, String prodId) throws SQLException;

	/**
	 * ��ٱ��� ��ǰ ��ü ����
	 * @return int - 0: ���� / 0�� �ƴϸ� ����
	 * @throws SQLException 
	 */
	int deleteAll(String customerId) throws SQLException;
}
