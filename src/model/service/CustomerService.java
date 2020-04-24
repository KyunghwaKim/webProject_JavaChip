package model.service;

import java.sql.SQLException;
import java.util.List;

import exception.AddException;
import exception.DuplicatedException;
import model.dao.CustomerDAO;
import model.dao.impl.CustomerDAOImpl;
import model.domain.Customer;
import model.domain.Person;

public class CustomerService {
	private static CustomerDAO customerDAO = new CustomerDAOImpl();

	/**
	 * CustomerDAOImpl의 모든레코드 검색하는 메소드 호출
	 */
	public static List<Customer> selectAll() throws SQLException {
		List<Customer> list = customerDAO.selectAll();
		return list;
	}

	/**
	 * CustomerDAOImpl의 레코드 삽입하는 메소드 호출
	 */
	public static void insert(Customer customer) throws Exception {
		if (customerDAO.idCheck(customer.getId())) {
			throw new DuplicatedException("사용하실 수 없는 아이디입니다.");
		}
		int result = customerDAO.insert(customer);
		if (result == 0)
			throw new AddException("등록되지 않았습니다.");
	}

	/**
	 * CustomerDAOImpl의 Id에 해당하는 레코드 검색하는 메소드 호출
	 */
	public static Customer selectById(String id) throws SQLException {

		Customer dbcus = customerDAO.selectById(id);
		if (dbcus == null)
			throw new SQLException("Id에 해당하는 정보를 검색할수 없습니다.");

		return dbcus;
	}

	/**
	 * PersonDAOImpl의 id에 해당하는 비밀번호 수정 메소드 호출
	 */
	public static void update(String id, String pwd) throws SQLException {
		Person dbPer = customerDAO.selectById(id);

		// 수정하기 전에 비밀번호 먼저 체크한다.
		if (!dbPer.getPwd().equals(pwd)) {
			throw new SQLException("비밀번호를 다시 확인해주세요.");
		}

		int result = customerDAO.update(id, pwd);
		if (result == 0)
			throw new SQLException("수정되지 않았습니다.");

	}
	public static void update(String id) throws SQLException {
		Person dbPer = customerDAO.selectById(id);

		// 수정하기 전에 비밀번호 먼저 체크한다.
//		if (!dbPer.getPwd().equals(pwd)) {
//			throw new SQLException("비밀번호를 다시 확인해주세요.");
//		}
//
//		int result = customerDAO.update(id, pwd);
//		if (result == 0)
//			throw new SQLException("수정되지 않았습니다.");

	}
}
