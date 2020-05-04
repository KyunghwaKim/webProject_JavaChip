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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int update(Person person) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		String sql = pro.getProperty("updatePerson");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, person.getPwd());
			ps.setString(2, person.getPhone());
			ps.setString(3, person.getId());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public int updateStatus(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("updatePersonStatus");
		
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
	
	/*
	 * ����Ż���.. 
	 */
	@Override
	public int updateStatus(String adminId, String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("updatePersonStatusFromAdmin");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customerId);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * �̸�, �ڵ�����ȣ�� id ã��
	 */
	@Override
	public String selectByNameAndPhone(String name, String phone) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id=null;
		String sql = pro.getProperty("selectPersonByName");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getString("id");
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return id;
	}
	/**
	 * id, �̸�, �ڵ�����ȣ�� pwd ã��
	 */
	@Override
	public String selectByIdAndNameAndPhone(String id, String name, String phone) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pwd=null;
		String sql = pro.getProperty("selectPersonByIdNamePhone");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(1, name);
			ps.setString(2, phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				pwd = rs.getString("pwd");
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return pwd;
	}
	
	@Override
	public Person selectByIdAndPwd(String id, String pwd) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Person person = null;
		String sql = pro.getProperty("selectPersonById");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if (rs.next()) {
				person = new Person(rs.getString("id"), rs.getInt("status"));	//ȸ��Ȯ���̱� ������ �� �ʿ� ����
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return person;
	}
	
	@Override
	public int insert(Person person) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO PERSON(ID, PWD, NAME, PHONE, GENDER, STATUS) VALUES (?,?,?,?,?,?)";
		int result=0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, person.getId());
			ps.setString(2, person.getPwd());
			ps.setString(3, person.getName());
			ps.setString(4, person.getPhone());
			ps.setString(5, person.getGender());
			ps.setInt(6, person.getStatus());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public Person selectAdminById(String id) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Person person = null;
		String sql = "SELECT * FROM PERSON WHERE STATUS=3 AND ID=?";
		
		try {			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				person = new Person(rs.getString("ID"), rs.getString("PWD"), rs.getString("NAME"), rs.getString("PHONE"),
						rs.getString("GENDER"), rs.getInt("STATUS"));
				
				}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return person;
	}
	
	
}
