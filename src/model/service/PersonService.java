package model.service;

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
}
