package com.test.java; //03.14

public class Ex15_Overloading {

	public static void main(String[] args) {

		// Ex15_Overloading.java

		// 1. 호출 구문 > 메소드 자동 생성 (Ctrl + 1 > create)
		// 2. 블럭 선택 > refactor > extract method

		// a.
		// String result = test1();
		// System.out.println(result);



		// b.


		/*
		
			메소드 오버로딩, Method Overloading
			- 메소드가 인자 리스트를 다양한 형태로 가질 수 있는 기술
			- 같은 이름의 메소드 + 인자를 다양하게 > 여러 개 만들 수 있는 기술
			
			
			메소드 오버로딩을 하는 이유?
			- 성능 향상? (x)
			- 개발자 도움(o) > 머리 나쁜 개발자를 위한 기술 > 메소드 이름을 외우기 힘든 사람들을 위한 기술
			
			
			메소드 오버로딩 구현 조건 가능
			1. 매개변수의 개수
			2. 매개변수의 자료형
			
			
			메소드 오버로딩 구현 조건 불가능
			1. 매개변수의 이름
			2. 반환값의 자료형
			
			메소드를 선언하는 중..
			1. public static void test() {}				//O. 현재클래스에 중복되는 것 없으니
			2. public static void test() {}				//X. 바로 위에 생성되어있으니 생성X
			3. public static void test(int n) {} 		//매개변수의 개수가 1번(0)과 다름 -> O
			4. public static void test(int m) {}		//X. 3번 때문에 안됨.
			5. public static void test(String s) {} 	//O. 자료형이 다르면 ok.
			6. public static void test(int n, int m) {}	//O. 매개변수의 개수가 2개 이상인 건 6번뿐.
			7. public static int test() {}				//X. 갈 때는 1번과 7번을 구분하지 못함. (반환값의 자료형이 같기 때문에)
			
			메소드를 호출하기(검증하는 법) ****
			test();			//1번 호출 -> 메소드에 매개변수가 없으니 1번 호출임.
			test(10);		//3번 호출 -> 인자값이 있으니 3번 호출임.
			test("문자열");	//5번 호출
			test(10,20); 	//6번 호출
			
			
			
		*/

		// 요구사항] 선을 출력하는 메소드
		// 추가사항] 선의 모양을 다양하게
		drawLine();
		drawLine();
		drawLine(); // drawLineEqual()

		drawLine("*"); // drawLineAsterisk()
		drawLine("+"); // drawLinePlus()
		drawLine("$"); // drawLIneDoller()

		// 똑같이 선을 긋는 메소드이지만 선의 종류가 달라서 이름이 다 다름.
		// 종류가 많을 수록 메소드 이름을 기억하기 어려움.
		// 궁극적으로는 선을 긋는 행위를 한다는 것이 같으니, 사용자의 입장에선 이름을 따로 기억하는 것보단
		// '선 긋기'로 기억하는 것이 편하니 여러 메소드를 동시에 존재하게 할 수 있게 한 것이 오버로딩.


	}// main

	// *** 식별자가 중복될 땐 넘버링 하지마 (숫자 붙이지마) > 의미가 불분명하기 때문.

	// 메소드 생성 > 이름은?
	public static void drawLine() {

		System.out.println("=================================");

	}

	// public static void drawLine() {

	// System.out.println("*********************************");


	// }

	// 매개변수가 있으면 메소드 이름이 같아도 동시에 존재 가능. (매개변수x 메소드 / 매개변수 o 메소드)
	public static void drawLine(String s) {

		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);

		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);

		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);

		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);

		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);

		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.println();



	}



	// a.
	// private static String test1() {

	// printf() > 형식문자 사용 > 출력할 때만 사용 가능;;

	// 10/3 -> 3.3

	// System.out.println(10 / 3); //3
	// System.out.println(10.0 / 3); //3.33333
	// System.out.printf("%.1f\n", 10.0 / 3); //3.3

	// 소수점이하 1자리까지만 리턴값으로 주는 방법
	// 1. 자바 수학 기능 사용
	// 2. 형식 문자열 지원 메소드

	// System.out.println(Math.round(10.0 / 3 * 10)/10.0); //3.333 에서 10 곱해서 33 만들고 나누기 10하면 3.3
	// 반올림 메소드
	// return String.valueOf(Math.round(10.0 / 3 * 10) / 10.0);

	// printf 메소드와 기능은 동일하지만 > 결과를 출력(x), 결과를 반환(o)
	String result = String.format("%.1f", 10.0 / 3);

	// return result;



	// }

}
