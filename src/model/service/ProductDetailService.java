package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.ProductDetailDAO;
import model.dao.impl.ProductDetailDAOImpl;
import model.domain.ProductDetail;

public class ProductDetailService {
	static ProductDetailDAO  productDetailDAO = new ProductDetailDAOImpl();

	/**
	 * ProductDetailDAOImpl의 레코드 삽입하는 메소드 호출
	 */
	public static void insert(ProductDetail productDetail) throws Exception {
		
		int result = productDetailDAO.insert(productDetail);
		if(result==0) throw new SQLException("등록되지 않았습니다.");
	}

	/**
	 * ProductDetailDAOImpl의 productDetail에 해당하는 비밀번호 수정 메소드 호출
	 */
	public static void update(ProductDetail productDetail) throws SQLException {
		int result = productDetailDAO.update(productDetail);
		if(result==0) throw new SQLException("수정되지 않았습니다.");
	}
		
	/**
	 * ProductDetail 삭제
	 * 
	 */
	public static void delete(String prodId, String chapter) throws SQLException {
		int result = productDetailDAO.delete(prodId, chapter);
		if(result==0) throw new SQLException("삭제되지 않았습니다.");
	}
	
	public static List<ProductDetail> selectAll(String prodId) throws SQLException {
		return productDetailDAO.selectAll(prodId);
	}

}
