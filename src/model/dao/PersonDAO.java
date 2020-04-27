package model.dao;

import java.sql.SQLException;

import model.domain.Customer;
import model.domain.Person;

public interface PersonDAO {
	/**
	 * �̸�, �ڵ�����ȣ�� �ش��ϴ� ���̵� �˻�
	 */
	String selectByNameAndPhone(String name, String phone) throws SQLException;
	
	Person selectByIdAndPwd(String id, String pwd) throws SQLException;
	
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
