package model.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.dao.ProductDAO;
import model.dao.impl.ProductDAOImpl;
import model.domain.Customer;
import model.domain.OrderLine;
import model.domain.Product;

public class AdminService {
	private static ProductDAO productDAO  = new ProductDAOImpl();
	
	
	/**
	 * �� ȸ����
	 * */
		public static int totalCustomer() 
	            throws SQLException{
			List<Customer> list = CustomerService.selectAll(); 
	 		int totalCustomer = list.size();
			
			
			return totalCustomer;
		
	}
	
	/**
	 * �� �Ǹż���
	 * */
		public static int totalQuantity() 
                throws SQLException{
			List<OrderLine> list = OrderLineService.selectAll(); 
	 		int totalQuantity = list.size();
	 		
	 		
			return totalQuantity;
			
		
		}
	
	/**
	 * ���� �Ǹŷ�
	 * */
		public static int weekSale() 
                throws SQLException{
			List<OrderLine> list = OrderLineService.selectAll();
			int date =new Date().getDate();
			int i;
			int weekSale =0;
			
			
			for(i = 0; i <list.size(); i++) {
				int now = list.get(i).getPayDate().getDate();
				if( date-now <7) {
					weekSale = weekSale+1;
				} 
			}
			
			
			return weekSale;
				
			}
	


	
	/**
	 * �� �Ǹűݾ�
	 * @param i 
	 * */
		public static int totalSalePrice() 
                throws SQLException{
			List<OrderLine> order = OrderLineService.selectAll();
			List<Product> products = ProductService.selectAll(); 
			int i;
			int totalSalePrice =0;
			for(i = 0; i <order.size(); i++) {
			
				totalSalePrice = totalSalePrice + order.get(i).getTotalPrice();
			}
			
			return totalSalePrice;
					
				}
	/**
	 * �ֱ��Ǹ� ���
	 * */
		public static List<Product> productList() 
                throws SQLException{
			List<Product> list = productDAO.selectAll();
			 return list;
						
						
		}				
}
