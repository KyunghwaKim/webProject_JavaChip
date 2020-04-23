package model.dao;

import model.domain.Product;

public interface ProductDAO {
	/**
	 * 상품 추가
	 */
	int insert(Product product);
	
	/**
	 * 상품 수정
	 */
	int upate(Product product);
	
	/**
	 * 상품 삭제
	 */
	int delete(Product product);
}