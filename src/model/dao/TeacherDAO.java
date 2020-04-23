package model.dao;

import java.util.List;

import model.domain.Teacher;

public interface TeacherDAO {
	/**
	 * ����������ü��ȸ
	 */
	List<Teacher> selectAll();
	
	/**
	 * ��������� ��ȸ
	 */
	Teacher selectByName(String name);
	
	/**
	 * ������������ - Ż��� status ����
	 */
	int update(Teacher teacher);
}
