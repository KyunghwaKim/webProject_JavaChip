package model.dao;

import java.sql.SQLException;

import model.domain.Customer;

public interface PersonDAO {
	/**
	 * 회원정보수정(비밀번호, 전화번호, 이메일, 상태(가입or탈퇴회원)
	 */
	int update(Customer customer) throws SQLException;
}
