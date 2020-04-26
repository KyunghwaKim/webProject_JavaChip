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
	 * ��ǰ ���� - ��ǰ��, ����, ����, ��ȿ�Ⱓ ����
	 */
	int update(Product product) throws SQLException;
		
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
	
	/**
	 * ��ǰ���̵�� ��ǰ��ȸ
	 */
	Product selectById(String prodId) throws SQLException;	
}