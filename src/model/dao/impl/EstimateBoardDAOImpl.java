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

import model.dao.EstimateBoardDAO;
import model.domain.EstimateBoard;
import model.domain.QnABoard;
import util.DbUtil;

public class EstimateBoardDAOImpl implements EstimateBoardDAO {

Properties pro = new Properties();
	
	public EstimateBoardDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(EstimateBoard estimate) throws SQLException {
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
	public int update(EstimateBoard estimate) throws SQLException {
		Connection con =null;
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
	public int delete(EstimateBoard estimate) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		int result =0;
		String sql=pro.getProperty("");
		try {
			con = DbUtil.getConnection();
			ps = con .prepareStatement(sql);
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public List<EstimateBoard> selectByName(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<EstimateBoard> list = new ArrayList<EstimateBoard>();
		String sql = pro.getProperty("");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				EstimateBoard estBoard = new EstimateBoard();
				
				list.add(estBoard);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<EstimateBoard> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<EstimateBoard> list = new ArrayList<EstimateBoard>();
		String sql = pro.getProperty("selectAllEst");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {//객체 생성을 위한 rs.get~~ 추가 필요
				EstimateBoard estimateBoard = new EstimateBoard();
				
				list.add(estimateBoard);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<EstimateBoard> selectByKeyword(String keyField, String keyword) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<EstimateBoard> list = new ArrayList<EstimateBoard>();
		String sql = pro.getProperty("");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, keyField);
			ps.setString(2, keyword);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				EstimateBoard estBoard = new EstimateBoard();
				
				list.add(estBoard);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

}
