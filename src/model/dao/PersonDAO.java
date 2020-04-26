package model.dao;

import java.sql.SQLException;

import model.domain.Person;

public interface PersonDAO {
	/**
	 * 회원or강사 정보수정(비밀번호, 전화번호
	 */
	 int update(Person person) throws SQLException;
	 
	 /**
	  * 회원탈퇴기능(상태값 변경)
	  */
	 int updateStatus(String personId) throws SQLException;
	 
	 /**
	  * 불량회원 강제탈퇴기능(상태값 변경) - 관리자
	  */
	 int updateStatus(String adminId, String customerId) throws SQLException;
}
