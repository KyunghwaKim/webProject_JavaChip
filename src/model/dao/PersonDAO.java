package model.dao;

import java.sql.SQLException;

import model.domain.Customer;

public interface PersonDAO {
	/**
	 * ȸ����������(��й�ȣ, ��ȭ��ȣ, �̸���, ����(����orŻ��ȸ��)
	 */
	int update(Customer customer) throws SQLException;
}
