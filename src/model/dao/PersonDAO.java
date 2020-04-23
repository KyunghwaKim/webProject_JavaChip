package model.dao;

import java.sql.SQLException;

import model.domain.Customer;
import model.domain.Person;

public interface PersonDAO {
	/**
	 * ȸ�� ���
	 */
	int insert(Person person) throws SQLException;
	
	/**
	 * ȸ����������
	 */
	int update(Customer customer) throws SQLException;
	
}
