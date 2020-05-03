package model.dao;

import java.sql.Connection;
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
	 * �̹� ���ŵ� ��ǰ���� Ȯ��(��ȿ�Ⱓ�� ���Ҵ���, ȯ�ҵ��� �ʾҴ���)
	 */
	int selectAlreadyInsertOrder(String customerId, String prodId) throws SQLException;
	
	/**
	 * �ֹ��ϱ�(Ʈ����� ����, Ŭ����)
	 */
	void insert(OrderItem orderItem) throws Exception;
	
	/**
	 * �ֹ��ϱ�
	 */
	int insert(Connection con, OrderLine orderLine) throws SQLException;
	
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
