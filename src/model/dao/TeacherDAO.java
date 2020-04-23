package model.dao;

import java.util.List;

import model.domain.Teacher;

public interface TeacherDAO {
	/**
	 * 강사정보전체조회
	 */
	List<Teacher> selectAll();
	
	/**
	 * 강사명으로 조회
	 */
	Teacher selectByName(String name);
	
	/**
	 * 강사정보수정 - 탈퇴는 status 변경
	 */
	int update(Teacher teacher);
}
