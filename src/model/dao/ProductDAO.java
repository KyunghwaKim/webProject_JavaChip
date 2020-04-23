package model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
		
	/**
	 *  ��ǰ��ü��ȸ (SQL�������� �ֱٳ�¥���� �����ؼ� ����Ѵ�)
	 */
	List<Product> selectAll() throws SQLException;
	
	/**
	 * SQL�������� SQL SELECT * FROM PRODUCT WHERE category="?" and teacher=? and level="?";
	 *  Map(key, value)
	 *  key category , java
	 *  key teacher , A���� 
	 *  key level , 1����
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	List<Product> selectByJogun(Map<String, String> map) throws SQLException;
	
		

	
	
	
	
	
}