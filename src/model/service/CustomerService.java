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
	 * CustomerDAOImpl�� ��緹�ڵ� �˻��ϴ� �޼ҵ� ȣ��
	 */
	public static List<Customer> selectAll() throws SQLException {
		List<Customer> list = customerDAO.selectAll();
		return list;
	}

	/**
	 * CustomerDAOImpl�� ���ڵ� �����ϴ� �޼ҵ� ȣ��
	 */
	public static void insert(Customer customer) throws Exception {
		if(customerDAO.idCheck(customer.getId())){
			throw new DuplicatedException("����Ͻ� �� ���� ���̵��Դϴ�.");
		}
		int re = personDAO.insert(customer);
		if(re == 0)	throw new AddException("��ϵ��� �ʾҽ��ϴ�.");
		int result = customerDAO.insert(customer);
		if(result == 0) throw new AddException("��ϵ��� �ʾҽ��ϴ�.");
	}

	/**
	 * CustomerDAOImpl�� Id�� �ش��ϴ� ���ڵ� �˻��ϴ� �޼ҵ� ȣ��
	 */
	public static Customer selectById(String id) throws SQLException {

		Customer dbcus = customerDAO.selectById(id);
		if (dbcus == null)
			throw new SQLException("Id�� �ش��ϴ� ������ �˻��Ҽ� �����ϴ�.");

		return dbcus;
	}

//	/**
//	   * CustomerDAOImpl�� Id�� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
//	   * */
//	  public static void delete(String id, String password) 
//			           throws SQLException{
//		  
//		  Customer dbcus= customerDAO.selectById(id);
//		
//		if(!dbcus.getPwd().equals(password)) {
//			throw new SQLException("��й�ȣ �����Դϴ�.^^");
//		}
//		
//		int result = customerDAO.delete(id, password);
//		if(result==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
//		
//		
//		}

}
