package model.service;

import java.sql.SQLException;
import java.util.List;

import exception.NotFoundException;
import model.dao.ProductDAO;
import model.dao.ProductDetailDAO;
import model.dao.impl.ProductDAOImpl;
import model.dao.impl.ProductDetailDAOImpl;
import model.domain.OrderItem;
import model.domain.ProductDetail;

public class ProductDetailService {
	static ProductDetailDAO  productDetailDAO = new ProductDetailDAOImpl();
	static ProductDAO productDAO = new ProductDAOImpl();

	/**
	 * ProductDetailDAOImpl�� ���ڵ� �����ϴ� �޼ҵ� ȣ��
	 */
	public static void insert(ProductDetail productDetail) throws Exception {
		
		if(productDetail.getFileName() == null) {			
			int result = productDetailDAO.insertNoFile(productDetail);	
			if(result==0) throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
		} else {		
			
			if(productDAO.selectById(productDetail.getProduct().getId())==null) {
				throw new NotFoundException("�������� �ʴ� �����Դϴ�.");
			}
			int result = productDetailDAO.insert(productDetail);
			if(result==0) throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
			
		}
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
	
	/**
	 * é�������� ���� ���� - ���ǿ� ���� ����
	 */
	public static List<ProductDetail> selectAll(String prodId) throws SQLException {
		return productDetailDAO.selectAll(prodId);
	}

	/**
	 * é�������� ���� ���� - �������� �������� ���� �� �ִ���
	 */
	public static OrderItem selectProdStartEndDay(String customerId, String prodId) throws SQLException {
		return productDetailDAO.selectProdStartEndDay(customerId, prodId);
	}
	
	
	/**
	 * é������üũ
	 */
	
	public static int checkChatper(String prodId, String chapter) throws SQLException{
		
		return productDetailDAO.checkChapter(prodId, chapter);
		
	}
	
	
	
	
	
	
}
