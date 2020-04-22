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
	
	/**
	 * keyField�� �ش��ϴ�(�ʵ��) keyword�� ������ ���ڵ� �˻��ϱ�
	 *  : ��� ���ڵ尡 0���̻�
	 *  ex)
	 *  select * from member where id like '%a%' or
	 *  select * from member where name like '%a%' or
	 *  select * from member where addr like '%a%'
	 */
	List<Customer> searchByKeyword(String keyField, String keyWord) throws SQLException;
	
	
	/**
	 * ȸ���������� - Ż��� status ����
	 */
	int update(Customer customer);
	
}
