package model.domain;

import java.util.Date;;

public class OrderLine {
	private int lineNo;
	private int total;
	private Date payDate;
	private Customer customer;
	
	public OrderLine() {}
	
	public OrderLine(int lineNo, int total, Date payDate, Customer customer) {
		super();
		this.lineNo = lineNo;
		this.total = total;
		this.payDate = payDate;
		this.customer = customer;
	}

	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
