package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.Category;
import model.domain.Teacher;

public interface CategoryDAO {
	/**
	 * ī�װ� �̸� �ߺ�Ȯ��
	 * @return : true�̸� �ߺ�, false�̸� �ߺ��ƴ�
	 */
	boolean nameCheck(String categoryName) throws SQLException;
	
	/**
	 * ī�װ��߰�
	 * @return int - 0: ���� / 0�� �ƴϸ� ����
	 */
	int insert(String categoryName) throws SQLException;
	
	/**
	 * ī�װ��� ������ȸ(������ ī�װ� ���̵�� �˻�)
	 */
	List<Teacher> selectById(int categoryId) throws SQLException;
	
	
	List<Category> selectAll() throws SQLException;
	
}
