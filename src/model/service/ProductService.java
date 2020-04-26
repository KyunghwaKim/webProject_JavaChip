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

	public static void update(Product product) throws SQLException {
		int result = productDAO.update(product);
		if (result == 0)
			throw new SQLException("�������� �ʾҽ��ϴ�.");
	}

	/**
	 * ProductDAOImpl�� Id�� �ش��ϴ� ���ڵ� �˻��ϴ� �޼ҵ� ȣ��
	 */
	public static Product selectById(String prodId) throws SQLException {
		return productDAO.selectById(prodId);
	}

	public static List<Product> selectByJogun(Map<String, String> map) throws SQLException {
		return productDAO.selectByJogun(map);
	}

}
