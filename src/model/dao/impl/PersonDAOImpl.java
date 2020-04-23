package model.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import model.dao.PersonDAO;
import model.domain.Customer;
import model.domain.Person;
import util.DbUtil;

public class PersonDAOImpl implements PersonDAO {

	Properties pro = new Properties();
	
	public PersonDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(Person person) throws SQLException{
		Connection con = null;
		PreparedStatement ps =null;
		int result = 0;
		String sql = pro.getProperty("insertPerson");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, person.getId());
			ps.setString(2, person.getPwd());
			ps.setString(3, person.getName());
			ps.setString(4, person.getPhone());
			ps.setString(5, person.getGender());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	/**
	 * 쿼리문 추가 수정 가능성 있음
	 * 추가되면 입력값을 더 추가해야함
	 */
	public int update(Customer customer) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("updateCustomer");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, customer.getPwd());
			ps.setString(2, customer.getId());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}
