package model.dao;

import java.sql.SQLException;

import model.domain.Person;

public interface PersonDAO {
	/**
	 * ȸ��or���� ��������(��й�ȣ, ��ȭ��ȣ
	 */
	 int update(Person person) throws SQLException;
	 
	 /**
	  * ȸ��Ż����(���°� ����)
	  */
	 int updateStatus(String personId) throws SQLException;
	 
	 /**
	  * �ҷ�ȸ�� ����Ż����(���°� ����) - ������
	  */
	 int updateStatus(String adminId, String customerId) throws SQLException;
}
