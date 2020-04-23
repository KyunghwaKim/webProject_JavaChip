package model.dao;

import model.domain.ProductDetail;

public interface ProductDetailDAO {
	/**
	 * 챕터(강의목차) 추가
	 */
	int insert(ProductDetail productDetail);
	
	/**
	 * 챕터(강의목차) 수정
	 */
	int update(ProductDetail productDetail);
	
	/**
	 * 챕터(강의목차) 삭제
	 */
	int delete(ProductDetail productDetail);
}
