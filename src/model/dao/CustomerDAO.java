package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.domain.Customer;

public interface CustomerDAO {
	/**
	 * ȸ�� ���
	 */
	int insert(Customer customer) throws SQLException;
	
	/**
	 * ��й�ȣ ����
	 */
	int update(String id, String pwd) throws SQLException;
	
	/**
	 * ȸ��Ż��
	 */
	int update(String id) throws SQLException;
	
	/**
	 * id �ߺ�üũ
	 * @return : true�̸� �ߺ�, false�̸� �ߺ��ƴ�
	 */
	boolean idCheck(String id) throws SQLException;
	
	/**
	 * ȸ�� ��ü�˻�
	 *  : ��� ���ڵ尡 0���̻� ���� - List
	 */
	List<Customer> selectAll() throws SQLException;
	
	/**
	 * id�� �ش��ϴ� ���ڵ� �˻�
	 *  : ��� ���ڵ尡 0 �Ǵ� 1�̸� Member
	 */
	Customer selectById(String id) throws SQLException;
}
