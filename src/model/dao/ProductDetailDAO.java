package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.ProductDetail;

public interface ProductDetailDAO {
	/**
	 * 챕터(강의목차) 추가
	 */
	int insert(ProductDetail productDetail) throws SQLException;
	
	/**
	 * 챕터(강의목차) 수정
	 */
	int update(ProductDetail productDetail) throws SQLException;
	
	/**
	 * 챕터(강의목차) 삭제
	 */
	int delete(String prodId, String chapter) throws SQLException;
	
	/**
	 * 챕터 출력
	 */
	List<ProductDetail> selectAll(String prodId) throws SQLException;
}
