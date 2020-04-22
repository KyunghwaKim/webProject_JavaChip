package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.Product;

public interface CartDAO {
	/**
	 * ��ٱ��� ��ü��ȸ
	 * @return List<Product>
	 */
	List<Product> selectAll() throws SQLException;
	
	/**
	 * ��ٱ��� ��ǰ id�� ����
	 *  : ��ٱ��Ͽ��� �Ϻ� ��ǰ�� ����
	 * @return Product
	 */
	Product selectById(String id) throws SQLException;
	
	/**
	 * ��ٱ��� ��ǰ �߰�
	 * @return int - 0: ���� / 0�� �ƴϸ� ����
	 */
	int insert(Product product) throws SQLException;
	
	/**
	 * ��ٱ��� ��ǰ ����
	 * @return int - 0: ���� / 0�� �ƴϸ� ����
	 */
	int delete(Product product) throws SQLException;
}
