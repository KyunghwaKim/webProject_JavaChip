package model.dao;

import model.domain.Person;

public interface PersonDAO {
	/**
	 * 회원 등록
	 */
	int insert(Person person);
}
