package model.service;

import java.sql.SQLException;

import exception.NotLoginExeception;
import model.dao.PersonDAO;
import model.dao.impl.PersonDAOImpl;
import model.domain.Person;

public class PersonService {
	private static PersonDAO personDAO = new PersonDAOImpl();
	
	/**
	 * �α��� ���
	 */
	public static Person login(String id, String pwd) throws Exception {

		Person person = personDAO.selectByIdAndPwd(id, pwd);
				
		if(person==null) throw new NotLoginExeception("���̵� Ȥ�� ��й�ȣ�� Ʋ���ϴ�.");
		
		return person;
	}
	/**
	 * �����ڰ� ����(����, ������) ���
	 * @throws SQLException 
	 */
	public static void insert(Person person) throws SQLException {
		int result = personDAO.insert(person);
		if(result == 0) {
			throw new SQLException("��Ͽ� �����Ͽ����ϴ�.");
						
		}
	}
	
	/**
	 *  ����id�� �ش��ϴ� ���������� �����´�.
	 */
	public static Person selectByTeacherid(String id) throws SQLException{
		
		return personDAO.selectById(id);
				
	}
	
}
