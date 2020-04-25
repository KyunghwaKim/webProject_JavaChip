package model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.dao.CustomerDAO;
import model.dao.PersonDAO;
import model.dao.ProductDAO;
import model.dao.impl.CustomerDAOImpl;
import model.dao.impl.PersonDAOImpl;
import model.dao.impl.ProductDAOImpl;
import model.domain.Customer;
import model.domain.Product;

public class ProductService {
	private static ProductDAO productDAO = new ProductDAOImpl();

	/**
	 * ProductDAOImpl�� ���ڵ� �����ϴ� �޼ҵ� ȣ��
	 */

	public static void insert(Product product) throws SQLException {
		int result = productDAO.insert(product);
		if (result == 0)
			throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
	}

	/**
	 * ProductDAOImpl�� ��緹�ڵ� �˻��ϴ� �޼ҵ� ȣ��
	 */
	public static List<Product> selectAll() throws SQLException {
		List<Product> list = productDAO.selectAll();
		return list;
	}

	/**
	 * ProductDAOImpl�� ��緹�ڵ� �����ϴ� �޼ҵ� ȣ��
	 */
	public static void update(List<Product> list) throws SQLException {

	}

	/**
	 * ProductDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
	 * 
	 * @param path
	 */
	public static void delete() throws SQLException {

	}

	/**
	   * ProductDAOImpl�� Id�� �ش��ϴ� ���ڵ� �˻��ϴ� �޼ҵ� ȣ��
	   * */
//	public static Product selectByJogun(String id) 
//			                        throws SQLException{
//		
//
//		
//		Product pro = ProductDAOImpl.selectByJogun(Map<K, V>);
//		if(pro==null)throw new SQLException("Id�� �ش��ϴ� ������ �˻��Ҽ� �����ϴ�.");
//		
//		return pro;
//	}

}
