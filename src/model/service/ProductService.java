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
import model.domain.EstimateBoard;
import model.domain.GangiMokRok;
import model.domain.Product;
import model.domain.ProductDetail;

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
	
	
	/**
	 *  ���Ǹ�Ͽ� �Ѹ� ������ 
	 * 
	 */
	public static List<GangiMokRok> selectGangiMokRokAll() throws SQLException {
		
		return productDAO.GangiMokRokAll();
		
	}
	
	/**
	 * [���Ǹ��] > [�ڼ�������] �� ���� ����
	 * : ���Ǹ�(prod_name), ����(description), ����(price), ������(url)
	 */
	public static Map<EstimateBoard, ProductDetail> selectProdInfo(String prodId) throws SQLException {
		return productDAO.selectProdInfo(prodId);
	}
	
	/**
	 * ���� ī�װ� �� �ٸ� ��ǰ ����ֱ�
	 */
	public static List<String> selectSameCateProd(String prodId) throws SQLException {
		return productDAO.selectSameCateProd(prodId);
	}
	
	public static int deleteProd(String id) throws SQLException{
		
		return productDAO.deleteProd(id);
	}
	
	
	
	
}
