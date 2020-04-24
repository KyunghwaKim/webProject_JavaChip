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

import model.dao.CartDAO;
import model.domain.Cart;
import model.domain.Product;
import util.DbUtil;

public class CartDAOImpl implements CartDAO {
	
	Properties pro = new Properties();
	
	public CartDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//수빈 수정
	/**
	 * 카트 목록 조회
	 * @param userId
	 */
	@Override
	public List<Product> selectAll(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		String sql = pro.getProperty("selectCart");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while(rs.next()) {
				//가져오는 컬럼 순서 확인필요
				
				//Customer customer = new Customer();
				//Cart cart = new Cart(cartNo, customer, product);
				
			
				Product product = new Product();//getter로 생성해야 함
				list.add(product);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}

	
	//수빈 수정
	@Override
	public int insert(String userId, String prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("insertCart");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, prodId);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	//수빈 수정
	/**
	 * 해당 user의 장바구니 목록 전체 삭제
	 */
	@Override
	public int deleteAll(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		int result =0;
		String sql=pro.getProperty("deleteAllCart");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	//수빈 추가
	/**
	 * 
	 */
	@Override
	public int deleteById(String userId, String prodId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql=pro.getProperty("deleteCart");
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, prodId);
			result=ps.executeUpdate(sql);
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}


	@Override
	public int delete(String userId, List<Product> list) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
