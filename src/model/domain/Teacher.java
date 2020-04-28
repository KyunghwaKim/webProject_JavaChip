package model.domain;

public class Teacher extends Person {
	private Category category;
	private String fileName;
	
	public Teacher() {}

	public Teacher(Category category, String fileName) {
		super();
		this.category = category;
		this.fileName = fileName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
