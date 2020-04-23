package model.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import model.dao.ProductDAO;
import model.domain.Product;
import util.DbUtil;

public class ProductDAOImpl implements ProductDAO {

Properties pro = new Properties();
	
	public ProductDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int insert(Product product) throws SQLException{
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
	public int upate(Product product) throws SQLException{
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
	public int delete(Product product) throws SQLException{
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
	public List<Product> selectAll() throws SQLException {
		
		// 추가할것
		
		return null;
	}
	@Override
	public List<Product> selectByJogun(Map<String, String> map) throws SQLException {
		
		// 추가할것
		
		return null;
	}
	@Override
	public Product selectById(String id) throws SQLException {
		// 추가할것
		return null;
	}

}
