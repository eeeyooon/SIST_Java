package com.test.java.obj.staticmemeber; //03.25

public class Ex39_static {
	
	//4시수업
	//1. 클래스 로딩, Class Loading (1번이 먼저 일어난다는 뜻)
	//- 해당 프로그램을 실행하기 전에 클래스의 정의를 미리 읽어서 메모리에 얹는 작업.
	//- 설계도를 미리 읽어서 언제든지 사용가능하게 메모리에 올려놓는 작업
	//- 클래스 로딩 과정에서 발견되는 모든 static멤버는 메모리에 구현됨. (****************)
	//2. main()

	
	public static void main(String[] args) {
		
		//Ex39_static
		
		//static 키워드
		//- 클래스 멤버에 붙는 키워드(***) > 보편적으로 이거
		//- 클래스에 붙이는 키워드
		//1. 멤버 변수
		//2. 멤버 메소드
		
		// static int a =10; //error
		
		
		Student.setSchool("역삼중학교"); //기존과 다르게 추가!
		
		Student s1 = new Student();
		
		
		s1.setName("홍길동");
		s1.setAge(15);
		//s1.setSchool("역삼중학교");
		System.out.println(s1.info());
		
		
		Student s2 = new Student();
		s2.setName("아무개");
		s2.setAge(14);
		//s2.setSchool("역삼중학교");
		System.out.println(s2.info());
		
		Student s3 = new Student();
		s3.setName("테스트");
		s3.setAge(16);
		//s3.setSchool("역삼중학교");
		System.out.println(s3.info());
		
		
		
		
		
	}//main
	
}


//원본
//학생 클래스
//- "역삼 중학교" > 모든 학생
//
//class Student {
//	
//	private String name; 
//	private int age; 
//	private String school;
//	
//	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String getSchool() {
//		return school;
//	}
//	public void setSchool(String school) {
//		this.school = school;
//	}
//	
//	
//	public String info() {
//		
//		return String.format("이름: %s, 나이: %d, 학교: %s"
//								, this.name
//								, this.age
//								, this.school);
//	}
//	
//}

//Q.학생이 3명에서 300명으로 늘어난다면? 학교이름이 역삼중에서 대치중으로 바뀐다면?
class Student {
	
	//클래스 멤버 변수 > 객체 변수, 정적변수 모두 들어감.
	
	
	//객체 변수 >> 얘넨 heap에서 생기지만 (heap -> 객체로 울타리) >> 객체 안에 만들어진다고 객체 변수
	//-나만의 데이터(********) > 개인의 특성(*********)
	private String name; 
	private int age; 
	// > 얘넨 나중에 s1이란 object
	
	//정적 변수, static변수, 클래스 변수. 공용변수 (웬만해선 정적 변수라고 부를게)
	//- 하나의 클래스로부터 만들어진 모든 객체가 공통적으로 가지는 데이터를 저장하는 변수 
	//- 모든 객체의 공통된 특성(****)
	//- 공용 사물함
	
	
	//>> 얜 static에서 생김. >> 얘도 포장해서 student이름으로 (-> class이름으로 울타리)
	//>> student 클래스의 울타리는 하나만 만들어짐.
	//>> static에서 생긴다고 static변수.
	
	private static String school;  //>> 이게 해결방법
	
	//메모리 공간은 stack, heap뿐만 아니라 static이라는 구역이 또 있음.
	//static > 모든 static 키워드가 붙은 멤버가 생성되는 곳.
	// static변수, static 메소드 등은 무조건 이 공간에서 생성됨. (예외 없음)
	
	
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
	

	//기존 getSchool, setSchool
//	public String getSchool() {	//static없음
//		return school;
//	}
//	
//	
//	public void setSchool(String school) {
//		this.school = school;	//this.school -> Student.school
//	}
	
	
	public static String getSchool() {
		return school;
	}
	public static void setSchool(String school) {
		Student.school = school;
		//this.shcool = school; //error
		//this는 자신이 속한 객체를 가리킴.
		//객체는 new로 만든 것. static은 객체가 아니라 클래스 영역임.
		//그래서 static은 this로 가리킬 수 가 없음.
	}
	
	
	
	
	public String info() {
		
		return String.format("이름: %s, 나이: %d, 학교: %s"
								, this.name
								, this.age
								//, this.school
								, Student.school);
	}
	
}









