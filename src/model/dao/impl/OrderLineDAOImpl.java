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
import model.domain.OrderLine;
import util.DbUtil;

public class OrderLineDAOImpl implements OrderLineDAO {

Properties pro = new Properties();
	
	public OrderLineDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<OrderLine> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderLine> list = new ArrayList<OrderLine>();
		String sql = pro.getProperty("");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				OrderLine orderLine = new OrderLine();
				
				list.add(orderLine);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int insert(OrderLine orderLine) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int update(int totalPrice) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public OrderLine selectBylLineNo(int lineNo) throws SQLException {
		// 추가해주세요
		return null;
	}

}
