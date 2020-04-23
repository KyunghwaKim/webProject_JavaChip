package model.dao;

import java.sql.SQLException;

import model.domain.Product;

public interface ProductDAO {
	/**
	 * ��ǰ �߰�
	 */
	int insert(Product product) throws SQLException;
	
	/**
	 * ��ǰ ����
	 */
	int upate(Product product) throws SQLException;
	
	/**
	 * ��ǰ ����
	 */
	int delete(Product product) throws SQLException;
}