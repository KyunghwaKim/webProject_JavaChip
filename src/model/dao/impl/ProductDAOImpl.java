package model.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import model.dao.ProductDAO;
import model.domain.Category;
import model.domain.Product;
import model.domain.Teacher;
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
		String sql = pro.getProperty("insertProd");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getId());
			ps.setString(2, product.getName());
			ps.setInt(3, product.getPrice());
			ps.setString(4, product.getDescription());
			ps.setString(5, product.getLevel());
			ps.setString(6, product.getTeacher().getId());
			ps.setInt(7, product.getCategory().getId());
			ps.setInt(8, product.getValidDate());
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
		/**
		 * deleteCart=delete from cart where user_id=? AND prod_id=?
		 */
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
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		String sql = "selectProd";
		
		Teacher t = new Teacher();
		Category cate = new Category();
		
		
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
			
				
				
				Product product = new Product(rs.getString("prod_id"), rs.getString("prod_name"), rs.getInt("prod_price"), 
											  rs.getString("description"), rs.getString("prod_level"), t, 
											  cate, rs.getDate("upload_date"), rs.getInt("valid_Date"));
				
				list.add(product);
			}
			

		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}
	@Override
	public List<Product> selectByJogun(Map<String, String> map) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT * FROM PRODUCT WHERE category_id=? ";
		String keys []= {"category","teacher","level"};
		String value2 = map.get(keys[1]);
		String value3 = map.get(keys[2]);
		
		if(value2 !=null) {
			
			sql += "and teacher=? ";
					
		} else if(value3 != null) {
			
			sql += "and level=? ";
		}
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
			}
			
		}finally {
			
		}
		
		return list;
	}
	
	@Override
	public Product selectById(String id) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		String sql = pro.getProperty("selectProdById");
		/**
		 * selectProdById=select * from product where prod_id=?
		 */
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			
			
			if(rs.next()) {
				
				
//				product = new Product(rs.getString("id"), rs.getString("name"),
//						rs.getInt("price"),rs.getString("description"),
//						rs.getString("level"),null,null,
//						rs.getDate("uploadDate"));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return product;
	}

}


