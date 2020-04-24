package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import model.dao.QnABoardDAO;
import model.domain.QnABoard;
import util.DbUtil;

public class QnABoardDAOImpl implements QnABoardDAO {
	Properties pro = new Properties();
	
	
	@Override
	public int update(QnABoard qaBoard) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int sequence) throws SQLException {
		String sql = pro.getProperty("deleteQnA");
		
		return 0;
	}

	@Override
	public List<QnABoard> selectByName(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QnABoard> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QnABoard> selectByKeyword(String keyField, String keyword) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(QnABoard qaBoard) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("insertQnA");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, qaBoard.getSubject());
			ps.setString(2, qaBoard.getTitle());
			ps.setString(3, qaBoard.getProduct().getId());
			ps.setString(4, qaBoard.getCustomer().getId());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
//	/**
//	 * 게시글 내용 수정
//	 */
//	@Override
//	public int update(int sequence, String content) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
