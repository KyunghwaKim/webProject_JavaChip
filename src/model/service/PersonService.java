package model.service;

import java.sql.SQLException;

import exception.NotFoundException;
import model.dao.PersonDAO;
import model.dao.impl.PersonDAOImpl;
import model.domain.Person;

public class PersonService {
	private static PersonDAO personDAO = new PersonDAOImpl();
	
	/**
	 * �α��� ���
	 */
	public static void login(String id, String pwd) throws Exception {

		Person person = personDAO.selectByIdAndPwd(id, pwd);
		
		if(person==null) throw new NotFoundException("�߸��� �Է°��Դϴ�.");
	}
	/**
	 * �����ڰ� ����(����, ������) ���
	 * @throws SQLException 
	 */

	public static void insert(String id, String pwd, String name, String phone, String gender, int status) throws SQLException {
		int result = personDAO.insert(id, pwd, name, phone, gender, status);
		if(result == 0) {
			throw new SQLException("��Ͽ� �����Ͽ����ϴ�.");
		}
	}
}
