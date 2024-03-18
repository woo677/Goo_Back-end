package kr.co.gudi.dto;

public class MembereDTO {

	private String id;
	private String name;
	private int age;
	private String email;
	private String pw;
	private String gender;
	
	// 방법 1 : DTO에 직접 추가
	// 방법 2 : DTO에 생성자 추가

	public MembereDTO(String id,String name,int age,String email) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
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



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}

}
