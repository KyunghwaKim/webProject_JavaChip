package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.OrderLineDAO;
import model.dao.impl.OrderLineDAOImpl;
import model.domain.OrderLine;

public class OrderLineService {
	private static OrderLineDAO lineDAO = new OrderLineDAOImpl();
	
	public static List<OrderLine> selectAll() throws SQLException {
		return lineDAO.selectAll();
	}
	
	public static void insert(OrderLine orderLine) throws SQLException {
		int result = lineDAO.insert(orderLine);
		if(result==0) throw new SQLException("등록되지 않았습니다.");
	}
	
	public static void update(OrderLine orderLine) throws SQLException {
		int result = lineDAO.update(orderLine);
		if(result==0) throw new SQLException("수정되지 않았습니다.");		
	}
}
