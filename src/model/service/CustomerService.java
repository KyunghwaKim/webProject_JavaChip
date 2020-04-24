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
	 * PersonDAOImpl�� id�� �ش��ϴ� ��й�ȣ ���� �޼ҵ� ȣ��
	 */
	public static void update(String id, String pwd) throws SQLException {
		Person dbPer = customerDAO.selectById(id);

		// �����ϱ� ���� ��й�ȣ ���� üũ�Ѵ�.
		if (!dbPer.getPwd().equals(pwd)) {
			throw new SQLException("��й�ȣ�� �ٽ� Ȯ�����ּ���.");
		}

		int result = customerDAO.update(id, pwd);
		if (result == 0)
			throw new SQLException("�������� �ʾҽ��ϴ�.");

	}
	public static void update(String id) throws SQLException {
		Person dbPer = customerDAO.selectById(id);

		// �����ϱ� ���� ��й�ȣ ���� üũ�Ѵ�.
//		if (!dbPer.getPwd().equals(pwd)) {
//			throw new SQLException("��й�ȣ�� �ٽ� Ȯ�����ּ���.");
//		}
//
//		int result = customerDAO.update(id, pwd);
//		if (result == 0)
//			throw new SQLException("�������� �ʾҽ��ϴ�.");

	}
}
