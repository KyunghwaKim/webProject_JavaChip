package model.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import exception.ModifyException;
import model.dao.OrderItemDAO;
import model.dao.OrderLineDAO;
import model.dao.ProductDAO;
import model.dao.impl.OrderItemDAOImpl;
import model.dao.impl.OrderLineDAOImpl;
import model.dao.impl.ProductDAOImpl;
import model.domain.Customer;
import model.domain.OrderItem;
import model.domain.OrderLine;
import model.domain.Product;

public class OrderLineService {
	private static OrderLineDAO lineDAO = new OrderLineDAOImpl();
	private static ProductDAO prodDAO = new ProductDAOImpl();
	private static OrderItemDAO itemDAO = new OrderItemDAOImpl();

	public static List<OrderLine> selectAll() throws SQLException {
		return lineDAO.selectAll();
	}

	public static void insert(OrderItem orderItem) throws Exception {
		Product product = prodDAO.selectById(orderItem.getProduct().getId());
		orderItem.setProduct(product);
		long validDate = 0;

		String customerId = orderItem.getOrderLine().getCustomer().getId();
		int itemNo = lineDAO.selectAlreadyInsertOrder(customerId, orderItem.getProduct().getId());
		if (itemNo != 0) {
			if (itemDAO.update(3, itemNo, customerId) == 0)
				throw new ModifyException("�������Ż�ǰ�� isrefund���� �������� ���߽��ϴ�.");
			Date startDate = itemDAO.selectEndDate(itemNo, customerId);
			validDate = startDate.getTime();
			System.out.println(validDate);
		} else {
			validDate = System.currentTimeMillis();
		}

		validDate += (long) product.getValidDate() * 24 * 60 * 60 * 1000;
		Date endDate = new Date(validDate);
		orderItem.setEndDate(endDate);

		OrderLine orderLine = orderItem.getOrderLine();
		orderLine.setTotalPrice(product.getPrice());
		orderItem.setOrderLine(orderLine);

		lineDAO.insert(orderItem);
	}

	/**
	 * ��ǰ �� �ֹ������� �ѱݾ��� �˾ƿ��� ���� �ֹ���ȣ�� �Ѱ����ݾ��� �˾ƿ´�.
	 * 
	 * @param lineNo : �ֹ���ȣ
	 * @param prodId : ��ǰ��ǰ�� ���̵�
	 * @throws SQLException
	 */
	public static void update(int lineNo, String prodId) throws SQLException {
		int beforePrice = lineDAO.selectBylLineNo(lineNo).getTotalPrice();
		int prodPrice = prodDAO.selectById(prodId).getPrice();
		int totalPrice = beforePrice - prodPrice;
		int result = lineDAO.update(lineNo, totalPrice);
		if (result == 0)
			throw new SQLException("�������� �ʾҽ��ϴ�.");
	}

	public static OrderLine selectByLineNo(int lineNo) throws SQLException {
		return lineDAO.selectBylLineNo(lineNo);
	}

	public static List<OrderItem> selectByCustomerId(String customerId) throws SQLException {
		return lineDAO.selectByCustomerId(customerId);
	}
}
