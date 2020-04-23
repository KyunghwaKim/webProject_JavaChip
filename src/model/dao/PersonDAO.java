package model.dao;

import java.sql.SQLException;

import model.domain.Customer;
import model.domain.Person;

public interface PersonDAO {
	/**
	 * 회원 등록
	 */
	int insert(Person person) throws SQLException;
	
	/**
	 * 회원정보변경
	 */
	int update(Customer customer) throws SQLException;
	
}
