package model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.domain.OrderItem;

public interface OrderItemDAO {	
	/**
	 * 결제내역 확인
	 */
	int selectAll() throws SQLException;
	
	/**
	 * 주문하기
	 */
	int insert(Connection con, OrderItem orderItem) throws SQLException;	
	
	/**
	 * 환불하기
	 */
	int update(int itemNo) throws SQLException;
	
	
	/**
	 * 7일동안판매수량
	 * @return
	 * @throws SQLException
	 */
	int selectBySevenDay() throws SQLException;
	
	/**
	 * 총판매수량
	 * @return
	 * @throws SQLException
	 */
	long selectpriceAll() throws SQLException;
	
	
	/**
	 *  최근판매7개...
	 */
	List<OrderItem> selectBySevenitemlist() throws SQLException;
	
}
