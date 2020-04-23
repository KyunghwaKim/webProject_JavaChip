package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.OrderLine;

public interface OrderLineDAO {
	/**
	 * �������� Ȯ��
	 */
	List<OrderLine> selectAll() throws SQLException;
	
	/**
	 * �ֹ��ϱ�
	 */
	int insert(OrderLine orderLine) throws SQLException;
	
	/**
	 * ȯ���ϱ�
	 */
	int update(int totalPrice) throws SQLException;
	
	
	/**
	 * �ֹ���ȣ�� �ֹ����� ��������
	 */
	OrderLine selectBylLineNo(int lineNo) throws SQLException;
	
	
}
