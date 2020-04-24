package model.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import model.dao.TeacherDAO;
import model.dao.impl.TeacherDAOImpl;
import model.domain.Teacher;




public class TeacherService {
	private static TeacherDAO teacherDAO  = new TeacherDAOImpl();

	  
	/**
	 * TeacherDAOImpl�� ��緹�ڵ� �˻��ϴ� �޼ҵ� ȣ��
	 * */
	 public static List<Teacher> selectAll()throws SQLException {
		 List<Teacher> list = teacherDAO.selectAll();
		 return list;
	 }
	  
	 
	 
	 
	  
	  /**
	   * TeacherDAOImpl�� �̸��� �ش��ϴ� ���ڵ� �˻��ϴ� �޼ҵ� ȣ��
	   * */
	public static Teacher selectByName(String name) 
			                        throws SQLException{

		
		Teacher dbTea = teacherDAO.selectByName(name);
		if(dbTea==null)throw new SQLException("�ش��ϴ� ������ �˻��Ҽ� �����ϴ�.");
		
		return dbTea;
	}
		 
	/**
	   * TeacherDAOImpl�� �̸��� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
	   * */
	  public static void delete(String modelNum, String password, String path) 
			           throws SQLException{
		  
//		  Teacher dbElec= teacherDAO.selectByModelNum(modelNum);
//		
//		if(!dbElec.getPassword().equals(password)) {
//			throw new SQLException("��й�ȣ �����Դϴ�.^^");
//		}
//		
//		int result = elecDAO.delete(modelNum, password);
//		if(result==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
//		
//		//���� �Ϸ��Ŀ� ���Ͽ� ���� ���� �ϰ� �ʹ�.
//		if(dbElec.getFname() !=null) {
//			 new File(path , dbElec.getFname()).delete();
//		}
		
		  
	  }






	  
}
