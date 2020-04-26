package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.OrderItem;

public interface OrderItemDAO {	
	/**
	 * �������� Ȯ��
	 */
	List<OrderItem> selectAll(String customerId) throws SQLException;
	
	/**
	 * �ֹ��ϱ�
	 */
	int insert(OrderItem orderItem) throws SQLException;	
	
	/**
	 * ȯ���ϱ�
	 */
	int update(int itemNo) throws SQLException;
}
