package model.dao;

import java.sql.SQLException;

import model.domain.Person;

public interface PersonDAO {
	/**
	 * ȸ��or���� ��������(��й�ȣ, ��ȭ��ȣ, ����(����orŻ��ȸ��)
	 */
	 int update(Person person) throws SQLException;
}
