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

import model.dao.CustomerDAO;
import model.domain.Customer;
import util.DbUtil;

public class CustomerDAOImpl implements CustomerDAO {

	Properties pro = new Properties();

	public CustomerDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * regdate, coupon, howtocome 3���� �Է¹����� ���� �����ʿ�
	 */
	public int insert(Customer customer) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("insertCustomer");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, customer.getId());
			ps.setInt(2, customer.getAge());
			ps.setString(3, customer.getEmail());
			/*
			 * ps.setDate(4, customer.getRegDate()); ps.setString(5, customer.getCoupon());
			 * ps.setString(6, customer.getHowToCome());
			 */

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int update(String id, String pwd) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "";
		
		sql = pro.getProperty("updatePwdCustomer");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, pwd);
			ps.setString(2, id);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public int update(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "";
		
		sql = pro.getProperty("updateStatusCustomer");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public boolean idCheck(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		String sql = pro.getProperty("selectIdChk");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (id.equals(rs)) {
				flag = true;
			} else {
				flag = false;
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return flag;
	}

	@Override
	/**
	 * customer�� person �Ѵ� �Ѱ����� ������� �����ʿ�
	 */
	public List<Customer> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<Customer>();
		String sql = pro.getProperty("selectAllCustomer");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				Customer customer = new Customer(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
						rs.getString("phone"), rs.getString("gender"), rs.getInt("status"), rs.getInt("age"),
						rs.getString("email"), rs.getString("coupon"), rs.getString("howToCome"),
						rs.getDate("regDate"));

				list.add(customer);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	@Override
	/**
	 * ����� ���Ͽ� person���� ���Խ��Ѽ� �������� ����
	 */
	public Customer selectById(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer customer = null;
		String sql = pro.getProperty("selectCustomer");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
						rs.getString("phone"), rs.getString("gender"), rs.getInt("status"), rs.getInt("age"),
						rs.getString("email"), rs.getString("coupon"), rs.getString("howToCome"),
						rs.getDate("regDate"));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return customer;
	}

}
