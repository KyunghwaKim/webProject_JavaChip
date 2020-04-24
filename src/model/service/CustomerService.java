package model.service;

import java.sql.SQLException;
import java.util.List;

import exception.AddException;
import exception.DuplicatedException;
import model.dao.CustomerDAO;
import model.dao.PersonDAO;
import model.dao.impl.CustomerDAOImpl;
import model.dao.impl.PersonDAOImpl;
import model.domain.Customer;

public class CustomerService {
	private static CustomerDAO customerDAO = new CustomerDAOImpl();
	private static PersonDAO personDAO = new PersonDAOImpl();

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
		if(customerDAO.idCheck(customer.getId())){
			throw new DuplicatedException("사용하실 수 없는 아이디입니다.");
		}
		int re = personDAO.insert(customer);
		if(re == 0)	throw new AddException("등록되지 않았습니다.");
		int result = customerDAO.insert(customer);
		if(result == 0) throw new AddException("등록되지 않았습니다.");
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

//	/**
//	   * CustomerDAOImpl의 Id에 해당하는 레코드 삭제 메소드 호출
//	   * */
//	  public static void delete(String id, String password) 
//			           throws SQLException{
//		  
//		  Customer dbcus= customerDAO.selectById(id);
//		
//		if(!dbcus.getPwd().equals(password)) {
//			throw new SQLException("비밀번호 오류입니다.^^");
//		}
//		
//		int result = customerDAO.delete(id, password);
//		if(result==0)throw new SQLException("삭제되지 않았습니다.");
//		
//		
//		}

}
