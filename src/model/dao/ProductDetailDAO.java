package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.OrderItem;
import model.domain.ProductDetail;

public interface ProductDetailDAO {
	/**
	 * é��(���Ǹ���) �߰�
	 */
	int insert(ProductDetail productDetail) throws SQLException;
	
	
	int insertNoFile(ProductDetail productDetail) throws SQLException;
	
	
	/**
	 * é��(���Ǹ���) ����
	 */
	int update(ProductDetail productDetail) throws SQLException;
	
	/**
	 * é��(���Ǹ���) ����
	 */
	int delete(String prodId, String chapter) throws SQLException;
	
	/**
	 * é�������� ���� ���� - ���ǿ� ���� ����
	 */
	List<ProductDetail> selectAll(String prodId) throws SQLException;

	/**
	 * é�������� ���� ���� - �������� �������� ���� �� �ִ���
	 */
	OrderItem selectProdStartEndDay(String customerId, String prodId) throws SQLException;


	int checkChapter(String prodId, String chapter) throws SQLException;
}
