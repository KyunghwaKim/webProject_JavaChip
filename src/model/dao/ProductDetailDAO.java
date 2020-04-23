package model.dao;

import model.domain.ProductDetail;

public interface ProductDetailDAO {
	/**
	 * é��(���Ǹ���) �߰�
	 */
	int insert(ProductDetail productDetail);
	
	/**
	 * é��(���Ǹ���) ����
	 */
	int update(ProductDetail productDetail);
	
	/**
	 * é��(���Ǹ���) ����
	 */
	int delete(ProductDetail productDetail);
}
