package model.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.dao.OrderLineDAO;
import model.domain.Customer;
import model.domain.OrderLine;
import util.DbUtil;

public class OrderLineDAOImpl implements OrderLineDAO {

	Properties pro = new Properties();

	public OrderLineDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderLine> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderLine> list = new ArrayList<OrderLine>();
		String sql = pro.getProperty("selectLines");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("user_id"));

				OrderLine orderLine = new OrderLine(rs.getInt("order_no"), rs.getInt("total_price"),
						rs.getDate("pay_date"), customer);

				list.add(orderLine);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int insert(OrderLine orderLine) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("insertLine");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, orderLine.getTotalPrice());
			ps.setString(2, orderLine.getCustomer().getId());

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int update(int lineNo, int totalPrice) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("updateLine");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, totalPrice);
			ps.setInt(2, lineNo);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public OrderLine selectBylLineNo(int lineNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		OrderLine orderLine = null;
		String sql = pro.getProperty("");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, lineNo);
			rs = ps.executeQuery();

			Customer customer = new Customer();

			if (rs.next()) {
				orderLine = new OrderLine(rs.getInt(lineNo), rs.getInt("total"), rs.getDate("payDate"), customer);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return orderLine;
	}

	@Override
	public List<OrderLine> selectByCustomerId(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderLine> list = new ArrayList<OrderLine>();
		String sql = pro.getProperty("");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customerId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("user_id"));

				OrderLine orderLine = new OrderLine(rs.getInt("order_no"), rs.getInt("total_price"),
						rs.getDate("pay_date"), customer);

				list.add(orderLine);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

}
