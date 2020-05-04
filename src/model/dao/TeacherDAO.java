package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.Teacher;

public interface TeacherDAO {
	/**
	 * ����������ü��ȸ
	 */
	List<Teacher> selectAll() throws SQLException;
	
	/**
	 * ��������� ��ȸ
	 */
	Teacher selectByName(String teacherName) throws SQLException;
	
	
	int insert(Teacher teacher) throws SQLException;
	
}
