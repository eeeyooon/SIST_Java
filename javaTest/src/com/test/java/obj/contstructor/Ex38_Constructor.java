package com.test.java.obj.contstructor; //03.25

public class Ex38_Constructor {

	public static void main(String[] args) {
		
		
	Developer d1 = new Developer();
	d1.info();
	
	
	Developer d2 = new Developer("홍길동");
	d2.info();
	
	
	Developer d3 = new Developer("아무개", "Java");
	d3.info();
	
	
	//익명 + 없음 만들고 싶음. (-> B로 이렇게 만들기)
	Developer d4 = new Developer("익명"); //-> 이러면 A랑 똑같아짐.
	d4.info();
	//> A가 할 수 있는 일은 B가 할 수 있음.
	
	
	//B->C ? C->B? > C도 A가 할 수 있는 일 할 수 있음. 
	
	
	}//main
} //Ex38



class Developer {
	
	private String name;
	private String language;
	
	
	//생성자를 여러거 생성하면 (오버로딩을 하면)
	//- 대부분의 생성자가 비슷한 행동을 함.
	//- 그러다보면 중복코드가 발생함
	//- 	> 다른 생성자 호출 형태 코드로 개선함 > this(); // 생성자 호출하는 표현
	
	//A가 할 수 있는을 B가 할 수 있고 A,B의 일을 C가 할 수 있음
	// A < B < C
	
	//A.
	public Developer() {
		
		//this.name = "익명";
		//this.language = "없음";
	
		// C를 호출
		this("익명", "없음"); // 이름을 무조건 this라고 해. 메소드 형식으로 호출하는 문법 -> this가 생성자임.
	}
	
	//B.
	public Developer(String name) {
		
		//this.name = name;
		//this.language = "없음";
	
		//C를 호출
		this(name, "없음"); //> 위에 주석단 두줄과 세번째 메소드를 호출한 이 this();가 같아짐.
		
		
	}
	
	//C.
	public Developer(String name, String language) { //String language만 못만듦 -> 이미 String오버로딩 O니까
		
		//이름 유효성 검사
		this.name = name;
		
		//언어 유효성검사 			>> 여기 C에만 하면, A나 B에선 유효성검사할필요 없음 > C에서 하고 C를 호출했으니까.
		this.language = language;
	}
	
	
	
	
	public void info() {
		
		System.out.println("이름: " + this.name);
		System.out.println("언어: " + this.language);
		System.out.println();
		
	}
	
}















