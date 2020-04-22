package model.domain;

public class Admin extends Person {
	private String acessNo;
	
	public Admin() {}

	public Admin(String acessNo) {
		super();
		this.acessNo = acessNo;
	}

	public String getAcessNo() {
		return acessNo;
	}

	public void setAcessNo(String acessNo) {
		this.acessNo = acessNo;
	}
}
