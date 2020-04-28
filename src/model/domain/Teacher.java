package model.domain;

public class Teacher extends Person {
	private Category category;
<<<<<<< HEAD
	private String fileName;
=======
	private String pictureName;
>>>>>>> branch 'master' of https://github.com/KyunghwaKim/webProject_JavaChip.git
	
	public Teacher() {}
<<<<<<< HEAD

	public Teacher(Category category, String fileName) {
=======
	
	public Teacher(Category category, String pictureName) {
>>>>>>> branch 'master' of https://github.com/KyunghwaKim/webProject_JavaChip.git
		super();
		this.category = category;
<<<<<<< HEAD
		this.fileName = fileName;
=======
		this.pictureName = pictureName;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public Teacher(String id, String pwd, String name, String phone, String gender, int status, Category category) {
		super(id, pwd, name, phone, gender, status);
		this.category = category;
>>>>>>> branch 'master' of https://github.com/KyunghwaKim/webProject_JavaChip.git
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
