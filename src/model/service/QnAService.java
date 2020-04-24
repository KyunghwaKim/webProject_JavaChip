package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.QnABoardDAO;
import model.dao.impl.QnABoardDAOImpl;
import model.domain.QnABoard;

public class QnAService {
	static QnABoardDAO dao = new QnABoardDAOImpl();
	
	/**
	 * 게시글 등록
	 */
//	public static int insert(String subject, String title, String prodId, String id) throws SQLException{
//		return dao.insert(subject, title, prodId, id);
//	}
	
	/**
	 * 게시글 삭제
	 * @param 게시글 번호
	 */
	public static int delete(int no) throws SQLException{
		return dao.delete(no);
	}
	
	/**
	 * 게시글 내용 수정
	 */
//	public static int update(String content, int no) throws SQLException{
//		return dao.update(content, no);
//		
//	}
		
	/**
	 * 전체 게시글 조회
	 * @throws SQLException 
	 */
	public static List<QnABoard> selectAll() throws SQLException {
		return dao.selectAll();
		
	}
	
	/**
	 * 내가 쓴 게시글 조회
	 * @param id
	 * @throws SQLException 
	 */
	public static List<QnABoard> selectById(String id) throws SQLException {
		return dao.selectByName(id);
		
	}
}
