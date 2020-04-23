package model.dao;

import model.domain.QnABoard;

public interface QnABoardDAO {
	/**
	 * �Խù� ���
	 */
	int insert(QnABoard qaBoard);
	
	/**
	 * �Խù� ����
	 */
	int update(QnABoard qaBoard);
	
	/**
	 * �Խù� ����
	 */
	int delete(QnABoard qaBoard);
}
