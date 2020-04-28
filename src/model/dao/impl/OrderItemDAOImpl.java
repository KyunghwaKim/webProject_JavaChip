package model.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.dao.OrderItemDAO;
import model.domain.OrderItem;
import model.domain.OrderLine;
import model.domain.Product;
import util.DbUtil;

public class OrderItemDAOImpl implements OrderItemDAO {

Properties pro = new Properties();
	
	public OrderItemDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<OrderItem> selectAll(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderItem> list = new ArrayList<OrderItem>();
		String sql = pro.getProperty("selectOrder");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customerId);
			rs = ps.executeQuery();
			while(rs.next()) {
				OrderLine orderLine = new OrderLine();
				orderLine.setLineNo(rs.getInt("order_no"));
				
				Product product = new Product();
				product.setId(rs.getString("prod_id"));
				product.setName(rs.getString("prod_name"));
				product.setPrice(rs.getInt("prod_price"));

				OrderItem orderItem = new OrderItem(rs.getInt("orderitem_no"), rs.getDate("end_date"), rs.getInt("isrefund"), orderLine, product);
				
				list.add(orderItem);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int insert(Connection con, OrderItem orderItem) throws SQLException {
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("insertOrderItem");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setDate(1, (Date) orderItem.getEndDate());
			ps.setInt(2, orderItem.getOrderLine().getLineNo());
			ps.setString(3, orderItem.getProduct().getId());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(null, ps);
		}
		return result;
	}

	@Override
	public int update(int itemNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("updateItem");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, itemNo);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}
