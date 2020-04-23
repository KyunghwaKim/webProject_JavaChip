package model.domain;

import java.sql.Date;

public class Customer extends Person {
	private int age;
	private String email;
	private String coupon;
	private String howToCome;
	private Date regDate;
	
	public Customer() {}

	public Customer(int age, String email, String coupon, String howToCome, Date regDate) {
		super();
		this.age = age;
		this.email = email;
		this.coupon = coupon;
		this.howToCome = howToCome;
		this.regDate = regDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public String getHowToCome() {
		return howToCome;
	}

	public void setHowToCome(String howToCome) {
		this.howToCome = howToCome;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
