package model.dao;

import java.sql.SQLException;

import model.domain.EstimateBoard;

public interface EstimateBoardDAO {
	/**
	 * 게시물 등록
	 */
	int insert(EstimateBoard estimate) throws SQLException;
	
	/**
	 * 게시물 수정
	 */
	int update(EstimateBoard estimate) throws SQLException;
	
	/**
	 * 게시물 삭제
	 */
	int delete(EstimateBoard estimate) throws SQLException;
}
