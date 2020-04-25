package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.Product;

public interface CartDAO {
	/**
	 * ��ٱ��� ��ü��ȸ
	 * @return List<Product>
	 */
	List<Product> selectAll(String customerId) throws SQLException;
	
	/**
	 * ��ٱ��� ��ǰ �߰�
	 * @return int - 0: ���� / 0�� �ƴϸ� ����
	 */
	int insert(String customerId, String prodId) throws SQLException;
	
	/**
	 * ��ٱ��� ��ǰ ����
	 * @return int - 0: ���� / 0�� �ƴϸ� ����
	 */
	int delete(String customerId, List<Product> list) throws SQLException;
	
	int deleteAll(String customerId) throws SQLException;
	
	int deleteById(String customerId, String prodId) throws SQLException;
}
