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
import model.domain.Person;

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
		if (customerDAO.idCheck(customer.getId())) {
			throw new DuplicatedException("����Ͻ� �� ���� ���̵��Դϴ�.");
		}
		int result = customerDAO.insert(customer);
		if (result == 0)
			throw new AddException("��ϵ��� �ʾҽ��ϴ�.");
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

	/**
	 * id�� �ش��ϴ� ȸ����������
	 */
	public static void update(Customer customer) throws SQLException {
		int result = personDAO.update(customer);
		if (result == 0)
			throw new SQLException("�������� �ʾҽ��ϴ�.");

		result = customerDAO.update(customer);
		if (result == 0)
			throw new SQLException("�������� �ʾҽ��ϴ�.");

	}

	/**
	 * ȸ��Ż��
	 */
	public static void withdrawal(String id) throws SQLException {
		int result = personDAO.updateStatus(id);
		if (result == 0)
			throw new SQLException("�������� �ʾҽ��ϴ�.");
	}

	/**
	 * �̸��� ��ȭ��ȣ�� idã��
	 */
	public static String findId(String name, String phone) throws SQLException {
		String id = personDAO.selectByNameAndPhone(name, phone);
		if (id == null)
			throw new SQLException("�ش� ������ �����ϴ�");

		return id;
	}

	/**
	 * id �̸� ��ȭ��ȣ�� �н����� ã��
	 */
	public static String findPwd(String id, String name, String phone) throws SQLException {
		Person dbPerson = customerDAO.selectById(id);

		if (dbPerson == null || !name.equals(dbPerson.getName()) || !phone.equals(dbPerson.getPhone())) {
			throw new SQLException("�ش� ������ �����ϴ�");
		}
		return dbPerson.getPwd();
	}
}
