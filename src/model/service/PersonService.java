package model.service;

import exception.NotFoundException;
import model.dao.PersonDAO;
import model.dao.impl.PersonDAOImpl;
import model.domain.Person;

public class PersonService {
	private static PersonDAO personDAO = new PersonDAOImpl();
	
	/**
	 * 로그인 기능
	 */
	public static void login(String id, String pwd) throws Exception {

		Person person = personDAO.selectByIdAndPwd(id, pwd);
		
		if(person==null) throw new NotFoundException("잘못된 입력값입니다.");
	}
}
