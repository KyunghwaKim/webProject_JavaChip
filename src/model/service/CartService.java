package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.CartDAO;
import model.dao.impl.CartDAOImpl;
import model.domain.Cart;

public class CartService {
	static CartDAO cartDAO = new CartDAOImpl();
	
	/**
	 * 장바구니에 담긴 상품 조회
	 * @return List<Product>
	 * @throws SQLException
	 */
	public static List<Cart> selectAll(String customerId) throws SQLException {
		return cartDAO.selectAll(customerId);
	}
	
	/**
	 * 장바구니 담기
	 * @param product
	 * @throws SQLException
	 */
	public static void insert(String customerId, String prodId) throws SQLException {
		int result = cartDAO.insert(customerId, prodId);
		if(result==0) { //실패
			throw new SQLException("장바구니 담기에 실패했습니다.");
		}
	}
	
	/**
	 * 선택 상품 장바구니 목록에서 삭제
	 */
	public static void delete(String customerId, List<String> list) throws SQLException {
		for (String prodId : list) {
			int result = cartDAO.delete(customerId, prodId);
			if (result == 0) {
				throw new SQLException("삭제하는데 실패했습니다.");
			}
		}
	}

	public static void deleteAll(String customerId) throws SQLException {
		int result = cartDAO.deleteAll(customerId);
		if (result == 0) {
			throw new SQLException("전체삭제하는데 실패했습니다.");
		}
		
	}
}
