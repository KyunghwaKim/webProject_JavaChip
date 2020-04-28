package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.OrderItem;
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
	int update(int lineNo, int totalPrice) throws SQLException;
	
	/**
	 * �ֹ���ȣ�� �ֹ����� ��������
	 */
	OrderLine selectBylLineNo(int lineNo) throws SQLException;
	
	/**
	 * �ֹ��ں� �ֹ����� ��������
	 * - ������� : ��ǰ���Ź�ȣ, ��ǰ��, �����̸�, ����, ��������
	 */
	List<OrderItem> selectByCustomerId(String customerId) throws SQLException;	
	
	/**
	 * ����������
	 * - ������� : ��ǰ��, �����̸�, ���Ǹ� ���� �� �ִ� ��¥
	 */
	OrderItem selectMyLecture(String customerId) throws SQLException;
}
