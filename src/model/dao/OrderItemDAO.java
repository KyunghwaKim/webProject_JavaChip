package model.dao;

import java.sql.Connection;
import java.sql.Date;
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
	 * ȯ���ϱ� & �����ϱ� �� isRefund�� ����
	 * isRefund - 1:���Ż�ǰ, 2:ȯ�һ�ǰ, 3:����Ȼ�ǰ
	 */
	int update(int isRefund, int itemNo, String customerId) throws SQLException;
	
	
	/**
	 * ��ǰ�Ⱓ���� �� ���� ���Ż�ǰ�� ��ȿ�Ⱓ Ȯ��
	 */
	Date selectEndDate(int itemNo, String customerId) throws SQLException;
	
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
