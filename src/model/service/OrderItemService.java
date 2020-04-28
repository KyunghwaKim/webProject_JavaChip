package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.OrderItemDAO;
import model.dao.impl.OrderItemDAOImpl;
import model.domain.OrderItem;

public class OrderItemService {
	public static OrderItemDAO itemDAO = new OrderItemDAOImpl();
	
	public static List<OrderItem> selectAll(String customerId) throws SQLException{
		return itemDAO.selectAll(customerId);
	}
	
//	public static void insert(List<OrderItem> list) throws SQLException{
//		for(OrderItem item : list) {
//			int result = itemDAO.insert(item);
//			if(result==0) throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
//		}
//	}
	
	public static void update(List<Integer> list) throws SQLException{
		for(int itemNo : list) {
			int result = itemDAO.update(itemNo);
			if(result==0) throw new SQLException("�������� �ʾҽ��ϴ�.");		
		}
	}
}
