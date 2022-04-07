package com.test.java;

public class Ex17_LocalVariable {

	public static void main(String[] args) {
		
		//Ex17_LocalVariable.java
		
		//자바 변수의 종류
		
		//1. 멤버 변수
		//-수업x
		
		//2. 지역 변수
		//-수업o
		
		//지역 변수, Local Variable
		//-메소드 안에서 선언한 변수
		//-메소드 영역(=지역, =해당 변수의 지역)
		//-자신이 선언된 메소드를 자신의 영역(Scope)이라고 생각한다. 지역 변수는 자신의 영역 밖으로 나가지 못한다.
		// > 외부 지역에서는 이 지역 변수에 접근이 불가능하다. ***) > 변수 가용 범위
		//- 메소드 매개변수도 지역변수임. (역할이 추가됨)
		
		//지역 변수의 생명주기, Life Cycle
		//-어떤 요소가 언제 태어나서 (메모리에 생성된다) ~ 언제 죽는지(메모리에서 소멸된다.)
		//- 생성 > 변수 선언문이 실행되는 순간.
		//- 소멸 > 변수 선언문이 포함된 자신의 영역에서 제어가 벗어나는 순간.
		
		
		int a = 10; //a는 main메소드의 지역변수다.
		
		int c = 10;
		
	}//main
	
	public static void m1() {
		
		int b = 20; //b는 m1메소드의 지역변수다.
		
		System.out.println(b);
//		System.out.println(a); //error. a cannot be resolved to a variable. //a라는 변수가 선언되지 않았다.
							   //이 메소드 안에서는 a 변수가 없는 것. 
		
		int c = 10;	//main()에 있는 c와는 완전히 다르기 때문에 (지역이 달라서) 중복 가능함.
		
		
		
	}
	
	
	
	
	
}
