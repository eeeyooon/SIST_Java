package com.test.java.mvc; //05.11

//DTO, VO
//- 멤버 변수
//- Getter/Setter 
//이것만하면돼
//-toString() > Debug용으로 만들기도
public class Address {

	
	//name, age, gender, tel, address + seq, regdate
	
	private String seq;
	private String name;
	private String age;
	private String gender;
	private String tel;
	private String address;
	private String regdate;
	
	
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
	
}
