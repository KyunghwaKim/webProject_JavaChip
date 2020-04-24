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
	 * TeacherDAOImpl의 모든레코드 검색하는 메소드 호출
	 * */
	 public static List<Teacher> selectAll()throws SQLException {
		 List<Teacher> list = teacherDAO.selectAll();
		 return list;
	 }
	  
	 
	 
	 
	  
	  /**
	   * TeacherDAOImpl의 이름에 해당하는 레코드 검색하는 메소드 호출
	   * */
	public static Teacher selectByName(String name) 
			                        throws SQLException{

		
		Teacher dbTea = teacherDAO.selectByName(name);
		if(dbTea==null)throw new SQLException("해당하는 정보를 검색할수 없습니다.");
		
		return dbTea;
	}
		 
	/**
	   * TeacherDAOImpl의 이름에 해당하는 레코드 삭제 메소드 호출
	   * */
	  public static void delete(String modelNum, String password, String path) 
			           throws SQLException{
		  
//		  Teacher dbElec= teacherDAO.selectByModelNum(modelNum);
//		
//		if(!dbElec.getPassword().equals(password)) {
//			throw new SQLException("비밀번호 오류입니다.^^");
//		}
//		
//		int result = elecDAO.delete(modelNum, password);
//		if(result==0)throw new SQLException("삭제되지 않았습니다.");
//		
//		//삭제 완료후에 파일에 파일 삭제 하고 싶다.
//		if(dbElec.getFname() !=null) {
//			 new File(path , dbElec.getFname()).delete();
//		}
		
		  
	  }






	  
}
