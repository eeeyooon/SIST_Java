package com.test.java;

public class Ex18_Method {

	public static void main(String[] args) {
		
		//Ex18_Method.java
		
		//재귀 메소드, Recursive Method
		//-메소드가 구현부에서 자기 자신을 호춣하는 구조를 가지는 메소드
		//-어렵다.
		//-파일 디렉토리 구조에서 사용. 
		//수업 듣고 정리 안되도 정상임 ㅎ 쓰는 사람도 어려워함.
		//어려운게 맞고 많이 연습해야 해.
		//이거 다시 듣자,,, 12시 수업.
		
		
		//m1();
		int n = 4;
		int result = m2(n);

		System.out.println(result);
		
		
	}//main
	
	
	public static int factorial(int n) {
		
		return (n == 1) ? 1 : n * factorial(n - 1);
		
	}
	
	
	public static int m2(int n) {
		
		System.out.println(n);

		int result = (n == 1) ? 1 : m2(n-1);
		
		return result;
		
	}
	
	//재귀 호출을 가지고 있는 메소드를 재귀 메소드라고함.
	public static void m1() {
		
		System.out.println("안녕하세요.");
		System.out.println("홍길동입니다.");
		
		m1(); //m1이 m1을 호출하는 것. = 재귀호출
		
		System.out.println("반갑습니다.");
	}
}
