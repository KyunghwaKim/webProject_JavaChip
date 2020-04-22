package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.Product;

public interface CartDAO {
	/**
	 * 장바구니 전체조회
	 * @return List<Product>
	 */
	List<Product> selectAll() throws SQLException;
	
	/**
	 * 장바구니 물품 id로 선택
	 *  : 장바구니에서 일부 상품만 구매
	 * @return Product
	 */
	Product selectById(String id) throws SQLException;
	
	/**
	 * 장바구니 상품 추가
	 * @return int - 0: 실패 / 0이 아니면 성공
	 */
	int insert(Product product) throws SQLException;
	
	/**
	 * 장바구니 상품 삭제
	 * @return int - 0: 실패 / 0이 아니면 성공
	 */
	int delete(Product product) throws SQLException;
}
