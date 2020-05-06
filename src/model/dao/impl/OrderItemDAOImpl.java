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
import model.domain.Customer;
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "SELECT ORDERITEM_NO FROM ORDERITEM WHERE ISREFUND<>2";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				num++;
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return num;
	}

	@Override
	public int selectBySevenDay() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "SELECT * FROM ORDERITEM oi JOIN ORDERLINE ol ON oi.ORDER_NO = ol.ORDER_NO "
				+ "WHERE ol.PAY_DATE >= TO_CHAR(SYSDATE-7,'YYYYMMDD') AND ISREFUND<>2";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				num++;
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return num;
	}

	@Override
	public long selectpriceAll() throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		long sum = 0;
		String sql = "SELECT * FROM ORDERLINE NATURAL JOIN ORDERITEM WHERE ISREFUND<>2";

		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				long lo = rs.getLong("TOTAL_PRICE");

				sum += lo;

			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return sum;
	}

	@Override
	public List<OrderItem> selectBySevenitemlist() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderItem> list = new ArrayList<OrderItem>();
		String sql = "SELECT * FROM (SELECT ROW_NUMBER() over (ORDER BY ORDERITEM_NO DESC) NUM, A.* "
				+ "FROM ORDERITEM A ORDER BY ORDERITEM_NO DESC) NATURAL JOIN ORDERLINE "
				+ "WHERE NUM<=7 AND ISREFUND<>2 ORDER BY NUM ASC";

		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				Customer customer = new Customer(rs.getString("USER_ID"));
				OrderLine orderline = new OrderLine(rs.getInt("ORDER_NO"), rs.getInt("TOTAL_PRICE"),
						rs.getDate("PAY_DATE"), customer);
				Product product = new Product(rs.getString("PROD_ID"));

				OrderItem orderitem = new OrderItem(orderline, product);

				list.add(orderitem);
			}

		} finally {
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
			ps = con.prepareStatement(sql);

			java.util.Date utilDate = orderItem.getEndDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			ps.setDate(1, sqlDate);
			ps.setInt(2, orderItem.getOrderLine().getLineNo());
			ps.setString(3, orderItem.getProduct().getId());

			result = ps.executeUpdate();
			if (result == 0)
				throw new SQLException();
		} finally {
			DbUtil.dbClose(null, ps);
		}
		return result;
	}

	@Override
	public int update(int isRefund, int itemNo, String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("updateItem");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, isRefund);
			ps.setInt(2, itemNo);
			ps.setString(3, customerId);
			result = ps.executeUpdate();
			System.out.println(result);
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public Date selectEndDate(int itemNo, String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Date date = null;
		String sql = pro.getProperty("selectEndDate");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, itemNo);
			ps.setString(2, customerId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				date = rs.getDate(1);
			}
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return date;
	}
	
	@Override
	public int refund(int orderNo, String customerId, String prodId) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE ORDERITEM SET ISREFUND=2 WHERE ORDERITEM_NO=?";
		int i = 0;
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderNo);
			i = ps.executeUpdate();
			
			sql = pro.getProperty("updateRefundBack");
			if(i != 0) {
				ps = con.prepareStatement(sql);
				ps.setString(1, customerId);
				ps.setString(2, prodId);
				i = ps.executeUpdate();
			}
			
		} finally {
			DbUtil.dbClose(con, ps);			
		}		
		return i;
	}

	@Override
	public String selectByOrderItemNo(int itemNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String prodId = null;
		String sql = pro.getProperty("selectByOrderItemNo");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, itemNo);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				prodId = rs.getString(1);
			}
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return prodId;
	}

}
