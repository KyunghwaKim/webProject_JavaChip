package model.service;

import java.sql.SQLException;

import model.dao.ProductDetailDAO;
import model.dao.impl.ProductDetailDAOImpl;
import model.domain.ProductDetail;

public class ProductDetailService {
	static ProductDetailDAO  ProductDetailDAO = new ProductDetailDAOImpl();

	/**
	 * ProductDetailDAOImpl�� ���ڵ� �����ϴ� �޼ҵ� ȣ��
	 */
	public static void insert(ProductDetail productDetail) throws Exception {
		
		int result = ProductDetailDAO.insert(productDetail);
		if(result==0) throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
	}

	/**
	 * ProductDetailDAOImpl�� productDetail�� �ش��ϴ� ��й�ȣ ���� �޼ҵ� ȣ��
	 */
	public static void update(ProductDetail productDetail) throws SQLException {
		int result = ProductDetailDAO.update(productDetail);
		if(result==0) throw new SQLException("�������� �ʾҽ��ϴ�.");
	}
		
	/**
	 * ProductDetail ����
	 * 
	 */
	public static int delete(ProductDetail productDetail) throws SQLException{
		
		
		return ProductDetailDAO.delete(productDetail);
	}

}
