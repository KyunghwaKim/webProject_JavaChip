package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.OrderItem;

public interface OrderItemDAO {	
	/**
	 * �������� Ȯ��
	 */
	List<OrderItem> selectAll() throws SQLException;
	
	/**
	 * �ֹ��ϱ�
	 */
	int insert(List<OrderItem> list) throws SQLException;	
	
	/**
	 * ȯ���ϱ�
	 */
	int update(List<OrderItem> list) throws SQLException;
}
