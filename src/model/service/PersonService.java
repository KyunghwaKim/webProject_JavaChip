package model.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import model.dao.CustomerDAO;
import model.dao.PersonDAO;
import model.dao.impl.CustomerDAOImpl;
import model.dao.impl.PersonDAOImpl;
import model.domain.Person;
import model.domain.Customer;



public class PersonService {
	private static PersonDAO personDAO  = new PersonDAOImpl();
	private static CustomerDAO customerDAO  = new CustomerDAOImpl();
	

	  
	  /**
	   * PersonDAOImpl의 레코드 삽입하는 메소드 호출
	   * */
	 public static void insert(Person person)throws SQLException {
		int result =  personDAO.insert(person);
		if(result==0)throw new SQLException("등록되지 않았습니다.");
	 }
	 
	 
	  
	 
		 

		  
	  
	  
	  
	  /**
	   * PersonDAOImpl의 id에 해당하는 레코드 수정  메소드 호출
	   * */
	  public static void update(Customer customer) throws SQLException{
		  Person dbPer=
			customerDAO.selectById(customer.getId());
		 
		//수정하기 전에 비밀번호 먼저 체크한다.
		if(!dbPer.getPwd().equals(customer.getPwd())) {
		  throw new SQLException("비밀번호를 다시 확인해주세요.");
		}
		 
		 int result = personDAO.update(customer);
		 if(result==0)throw new SQLException("수정되지 않았습니다.");
		  
	  }

}
