package model.domain;

import java.sql.Date;

public class OrderItem {
	private int itemNo;
	private Date endDate;
	private int isRefund;
	private OrderLine orderLine;
	private Product product;
	
	public OrderItem() {}

	public OrderItem(int itemNo, Date endDate, int isRefund, OrderLine orderLine, Product product) {
		super();
		this.itemNo = itemNo;
		this.endDate = endDate;
		this.isRefund = isRefund;
		this.orderLine = orderLine;
		this.product = product;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(int isRefund) {
		this.isRefund = isRefund;
	}

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
