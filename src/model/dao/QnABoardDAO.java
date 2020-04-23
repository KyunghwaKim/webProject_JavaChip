package model.dao;

import model.domain.QnABoard;

public interface QnABoardDAO {
	/**
	 * 게시물 등록
	 */
	int insert(QnABoard qaBoard);
	
	/**
	 * 게시물 수정
	 */
	int update(QnABoard qaBoard);
	
	/**
	 * 게시물 삭제
	 */
	int delete(QnABoard qaBoard);
}
