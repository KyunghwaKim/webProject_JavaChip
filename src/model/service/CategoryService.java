package model.service;

import java.sql.SQLException;
import java.util.List;

import exception.DuplicatedException;
import model.dao.CategoryDAO;
import model.dao.impl.CategoryDAOImpl;
import model.domain.Category;
import model.domain.Teacher;

public class CategoryService {

	static CategoryDAO categoryDAO = new CategoryDAOImpl();
	
	public static void insert(String categoryName) throws Exception{
		if(categoryDAO.nameCheck(categoryName)) {
			throw new DuplicatedException("�̹� �����ϴ� ī�װ��Դϴ�.");
		}
		int result = categoryDAO.insert(categoryName);
		if(result==0) {
			throw new SQLException("ī�װ� �߰��� �����߽��ϴ�");
		}
	}
	
	public static List<Teacher> selectById(int categoryid) throws SQLException{
		return categoryDAO.selectById(categoryid);
	}
	
	/*
	 *  Category ��ü ��� �����´�.
	 */
	public static List<Category> selectAll() throws SQLException{
		
		
		return null;
	}
	
	
	
}
