package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.domain.Customer;

public interface CustomerDAO {
	/**
	 * 회원 등록
	 */
	int insert(Customer customer) throws SQLException;
	
	/**
	 * id 중복체크
	 * @return : true이면 중복, false이면 중복아님
	 */
	boolean idCheck(String id) throws SQLException;
	
	/**
	 * 회원 전체검색
	 *  : 결과 레코드가 0개이상 가능 - List
	 */
	List<Customer> selectAll() throws SQLException;
	
	/**
	 * id에 해당하는 레코드 검색
	 *  : 결과 레코드가 0 또는 1이면 Member
	 */
	Customer selectById(String id) throws SQLException;
	
	/**
	 * keyField에 해당하는(필드명) keyword를 포함한 레코드 검색하기
	 *  : 결과 레코드가 0개이상
	 *  ex)
	 *  select * from member where id like '%a%' or
	 *  select * from member where name like '%a%' or
	 *  select * from member where addr like '%a%'
	 */
	List<Customer> searchByKeyword(String keyField, String keyWord) throws SQLException;
	
	
	/**
	 * 회원정보수정 - 탈퇴는 status 변경
	 */
	int update(Customer customer);
	
}
