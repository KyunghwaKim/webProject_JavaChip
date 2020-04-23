package model.dao;

import java.sql.SQLException;

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
	int delete(ProductDetail productDetail) throws SQLException;
}
