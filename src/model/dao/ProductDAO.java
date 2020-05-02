package model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.domain.EstimateBoard;
import model.domain.GangiMokRok;
import model.domain.Product;
import model.domain.ProductDetail;

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
	
	/**
	 *  ���Ǹ�� ��� ��ü ��ǰ ��ȸ
	 */
	List<GangiMokRok> GangiMokRokAll() throws SQLException;
	
	/**
	 * [���Ǹ��] > [�ڼ�������] �� ���� ���� 
	 * : ���Ǹ�(prod_name), ����(description), ����(price), ������(url)
	 */
	Map<EstimateBoard, ProductDetail> selectProdInfo(String prodId) throws SQLException;
	
	/**
	 * ���� ī�װ� �� �ٸ� ��ǰ ����ֱ�
	 */
	List<String> selectSameCateProd(String prodId) throws SQLException;
	
	/**
	 *  ��ǰ���� - �����ڱ��
	 */
	int deleteProd(String id) throws SQLException;
	
}