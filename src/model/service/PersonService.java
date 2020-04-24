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
	   * PersonDAOImpl�� ���ڵ� �����ϴ� �޼ҵ� ȣ��
	   * */
	 public static void insert(Person person)throws SQLException {
		int result =  personDAO.insert(person);
		if(result==0)throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
	 }
	 
	 
	  
	 
		 

		  
	  
	  
	  
	  /**
	   * PersonDAOImpl�� id�� �ش��ϴ� ���ڵ� ����  �޼ҵ� ȣ��
	   * */
	  public static void update(Customer customer) throws SQLException{
		  Person dbPer=
			customerDAO.selectById(customer.getId());
		 
		//�����ϱ� ���� ��й�ȣ ���� üũ�Ѵ�.
		if(!dbPer.getPwd().equals(customer.getPwd())) {
		  throw new SQLException("��й�ȣ�� �ٽ� Ȯ�����ּ���.");
		}
		 
		 int result = personDAO.update(customer);
		 if(result==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
		  
	  }

}
