package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.ProductDetailDAO;
import model.dao.impl.ProductDetailDAOImpl;
import model.domain.ProductDetail;

public class ProductDetailService {
	static ProductDetailDAO  productDetailDAO = new ProductDetailDAOImpl();

	/**
	 * ProductDetailDAOImpl�� ���ڵ� �����ϴ� �޼ҵ� ȣ��
	 */
	public static void insert(ProductDetail productDetail) throws Exception {
		
		int result = productDetailDAO.insert(productDetail);
		if(result==0) throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
	}

	/**
	 * ProductDetailDAOImpl�� productDetail�� �ش��ϴ� ��й�ȣ ���� �޼ҵ� ȣ��
	 */
	public static void update(ProductDetail productDetail) throws SQLException {
		int result = productDetailDAO.update(productDetail);
		if(result==0) throw new SQLException("�������� �ʾҽ��ϴ�.");
	}
		
	/**
	 * ProductDetail ����
	 * 
	 */
	public static void delete(String prodId, String chapter) throws SQLException {
		int result = productDetailDAO.delete(prodId, chapter);
		if(result==0) throw new SQLException("�������� �ʾҽ��ϴ�.");
	}
	
	public static List<ProductDetail> selectAll(String prodId) throws SQLException {
		return productDetailDAO.selectAll(prodId);
	}

}