package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.OrderItem;

public interface OrderItemDAO {	
	/**
	 * 결제내역 확인
	 */
	List<OrderItem> selectAll(String customerId) throws SQLException;
	
	/**
	 * 주문하기
	 */
	int insert(OrderItem orderItem) throws SQLException;	
	
	/**
	 * 환불하기
	 */
	int update(int itemNo) throws SQLException;
}
