package com.test.java.obj; //03.23

public class Ex31_Class {

	public static void main(String[] args) {
		
		//Ex31_Class
		
		//클래스 멤버
		//1. 멤버 변수
		//2. 멤버 메소드
		
		//11시 수업
		User u1 = new User(); //설계도대로(메소드 정의대로) 객체안에 그대로 적혀있음. (있다고 생각해~)
		
		u1.info(); //메소드 호출
		
		User u4 = new User();
		u4.info();
		u4.info();
		u4.info();
		System.out.println();
		System.out.println();
		
		
		
		//하나의 클래스로부터 만들어진 객체는 형태와 역할이 동일하다. > 같은 생산라인에서 만든 볼펜들
		//- 하나는 검은색 볼펜, 하나는 빨간색 볼펜 > 객체의 상태(멤버변수, State)의 차이로 구분이 가능함.
		//m1과 m2는 물리적인 설계가 똑같음. 그런데 멤버변수(데이터)가 다를때 각 객체가 가지는 상태가 달라짐.
		
		//객체의 유일성
		
		Member m1 = new Member();
		m1.id = "hong";
		m1.info();
		
		Member m2 = new Member();
		m2.id = "lee";
		m2.info();
	}
}

class User {
	
	public void info() {
		
		//정적
		System.out.println("회원의 정보를 출력합니다.");
		
	
		
	}
	
}



class Member { //클래스 안에 변수와 메소드 둘다 생성
	
	public String id; //-> 생명주기는 Member {~} 그래서 if{~}안에서도 쓸 수 있음.
	
	//멤버 메소드는 구현할 때 멤버 변수를 활용해야 진정한 가치를 가지게 된다.
	public void info() {
		System.out.printf("제 아이디는 %s입니다.\n", id); //본인의 멤버 변수를 활용 > 상태 활용
		
	}
	
}//Memeber















