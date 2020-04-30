package model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.domain.OrderItem;

public interface OrderItemDAO {	
	/**
	 * �������� Ȯ��
	 */
	int selectAll() throws SQLException;
	
	/**
	 * �ֹ��ϱ�
	 */
	int insert(Connection con, OrderItem orderItem) throws SQLException;	
	
	/**
	 * ȯ���ϱ�
	 */
	int update(int itemNo) throws SQLException;
	
	
	/**
	 * 7�ϵ����Ǹż���
	 * @return
	 * @throws SQLException
	 */
	int selectBySevenDay() throws SQLException;
	
	/**
	 * ���Ǹż���
	 * @return
	 * @throws SQLException
	 */
	long selectpriceAll() throws SQLException;
	
	
	/**
	 *  �ֱ��Ǹ�7��...
	 */
	List<OrderItem> selectBySevenitemlist() throws SQLException;
	
}
