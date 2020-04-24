package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.Product;

public interface CartDAO {
	/**
	 * ��ٱ��� ��ü��ȸ
	 * @return List<Product>
	 */
	List<Product> selectAll(String userId) throws SQLException;
	
	/**
	 * ��ٱ��� ��ǰ �߰�
	 * @return int - 0: ���� / 0�� �ƴϸ� ����
	 */
	int insert(String userId, String prodId) throws SQLException;
	
	/**
	 * ��ٱ��� ��ǰ ����
	 * @return int - 0: ���� / 0�� �ƴϸ� ����
	 */
	int delete(String userId, List<Product> list) throws SQLException;
	
	int deleteAll(String userId) throws SQLException;
	
	int deleteById(String userId, String prodId) throws SQLException;
}
