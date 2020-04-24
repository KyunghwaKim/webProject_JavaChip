package model.dao;

import java.sql.SQLException;

import model.domain.Person;

public interface PersonDAO {
	int update(Person person) throws SQLException;
}
