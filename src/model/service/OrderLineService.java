package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.OrderLineDAO;
import model.dao.ProductDAO;
import model.dao.impl.OrderLineDAOImpl;
import model.dao.impl.ProductDAOImpl;
import model.domain.OrderItem;
import model.domain.OrderLine;

public class OrderLineService {
	private static OrderLineDAO lineDAO = new OrderLineDAOImpl();
	private static ProductDAO prodDAO = new ProductDAOImpl();
	
	public static List<OrderLine> selectAll() throws SQLException {
		return lineDAO.selectAll();
	}
	
	public static void insert(OrderLine orderLine) throws SQLException {
		int result = lineDAO.insert(orderLine);
		if(result==0) throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
	}
	
	/**
	 * ��ǰ �� �ֹ������� �ѱݾ��� �˾ƿ��� ���� �ֹ���ȣ�� �Ѱ����ݾ��� �˾ƿ´�.
	 * @param lineNo : �ֹ���ȣ
	 * @param prodId : ��ǰ��ǰ�� ���̵�
	 * @throws SQLException
	 */
	public static void update(int lineNo, String prodId) throws SQLException {
		int beforePrice = lineDAO.selectBylLineNo(lineNo).getTotalPrice();
		int prodPrice = prodDAO.selectById(prodId).getPrice();
		int totalPrice = beforePrice - prodPrice;
		int result = lineDAO.update(lineNo, totalPrice);
		if(result==0) throw new SQLException("�������� �ʾҽ��ϴ�.");
	}

	public static OrderLine selectByLineNo(int lineNo) throws SQLException {
		return lineDAO.selectBylLineNo(lineNo);
	}
	
	public static List<OrderItem> selectByCustomerId(String customerId) throws SQLException{
		return lineDAO.selectByCustomerId(customerId);
	}
}
