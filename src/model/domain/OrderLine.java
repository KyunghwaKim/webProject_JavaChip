package model.domain;

import java.util.Date;;

public class OrderLine {
	private int lineNo;
	private int total;
	private Date payDate;
	private Customer customer;
	
	public OrderLine() {}
	
	/**
	 * ���(insert) �� lineNo�� ������ ������, payDate�� �� ��� ��¥�� �ڵ� �����ȴ�.
	 */
	public OrderLine(int total, Customer customer) {
		super();
		this.total = total;
		this.customer = customer;
	}
	
	public OrderLine(int lineNo, int total, Date payDate, Customer customer) {
		this(total, customer);
		this.lineNo = lineNo;
		this.payDate = payDate;
	}

	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}

	public int getTotalPrice() {
		return total;
	}

	public void setTotalPrice(int total) {
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
