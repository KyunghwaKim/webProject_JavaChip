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
import java.util.Locale.Category;

import model.dao.CategoryDAO;
import model.domain.Teacher;
import util.DbUtil;

public class CategoryDAOImpl implements CategoryDAO {
	
Properties pro = new Properties();
	
	public CategoryDAOImpl() {
		//sqlQuery.properties파일을 로딩하기
		InputStream input = getClass().getClassLoader().getResourceAsStream("kosta/mvc/model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Category category) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
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
	public List<Teacher> selectById(String categoryid) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Teacher> list = new ArrayList<Teacher>();
		String sql = pro.getProperty("");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);			
			rs = ps.executeQuery();
			while(rs.next()) {
				Teacher teacher = new Teacher();
				
				list.add(teacher);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

}
