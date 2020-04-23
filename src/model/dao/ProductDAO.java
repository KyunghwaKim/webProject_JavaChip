package model.dao;

import java.sql.SQLException;

import model.domain.Product;

public interface ProductDAO {
	/**
	 * 상품 추가
	 */
	int insert(Product product) throws SQLException;
	
	/**
	 * 상품 수정
	 */
	int upate(Product product) throws SQLException;
	
	/**
	 * 상품 삭제
	 */
	int delete(Product product) throws SQLException;
}