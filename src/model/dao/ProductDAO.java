package model.dao;

import model.domain.Product;

public interface ProductDAO {
	/**
	 * ��ǰ �߰�
	 */
	int insert(Product product);
	
	/**
	 * ��ǰ ����
	 */
	int upate(Product product);
	
	/**
	 * ��ǰ ����
	 */
	int delete(Product product);
}