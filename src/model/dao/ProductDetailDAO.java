package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.ProductDetail;

public interface ProductDetailDAO {
	/**
	 * é��(���Ǹ���) �߰�
	 */
	int insert(ProductDetail productDetail) throws SQLException;
	
	/**
	 * é��(���Ǹ���) ����
	 */
	int update(ProductDetail productDetail) throws SQLException;
	
	/**
	 * é��(���Ǹ���) ����
	 */
	int delete(String prodId, String chapter) throws SQLException;
	
	/**
	 * é�� ���
	 */
	List<ProductDetail> selectAll(String prodId) throws SQLException;
}
