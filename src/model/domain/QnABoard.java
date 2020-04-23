package model.domain;

import java.util.Date;

public class QnABoard {
	private int sequence;
	private String subject;
	private Date writeDay;
	private Customer customer;
	private Product product;
	private String title;
	private QnABoard parentNo;

	public QnABoard() {}

	public QnABoard(int sequence, String subject, Date writeDay, Customer customer, Product product, String title,
			QnABoard parentNo) {
		super();
		this.sequence = sequence;
		this.subject = subject;
		this.writeDay = writeDay;
		this.customer = customer;
		this.product = product;
		this.title = title;
		this.parentNo = parentNo;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getWriteDay() {
		return writeDay;
	}

	public void setWriteDay(Date writeDay) {
		this.writeDay = writeDay;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public QnABoard getParentNo() {
		return parentNo;
	}

	public void setParentNo(QnABoard parentNo) {
		this.parentNo = parentNo;
	}

}