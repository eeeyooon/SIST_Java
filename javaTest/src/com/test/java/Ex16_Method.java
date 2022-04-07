package com.test.java;

public class Ex16_Method {

	public static void main(String[] args) {

		// Ex16_Method.java

		// Swap
		// - 2개의 공간안의 값을 서로 교환하는 작업

		int a = 10;
		int b = 20;

		swap(a, b);
		// method 수업없이 여기서 temp로 빼도됨. 다만 방금 오버로딩을 배웠으니까 연습해본것.

		String s1 = "홍길동";
		String s2 = "아무개";

		swap(s1, s2); // 같은 swap인데도 매개변수의 자료형이 다르니 사용가능
						// 근데 유저입장에서는 동일한 메소드처럼 인식됨. (장점)

		boolean b1 = true;
		boolean b2 = false;

		swap(b1, b2);


		// 본인이 스스로 연습을 많이 해봐야해.



		// swap 로직 방법
		// 1. 빈공간 추가로 사용(temp) > 잘사용
		// 2. 비트 연산자 사용 	>잘사용x > 정수값에만 적용 가능해서 

		int c = 10;
		int d = 20;

		d = c ^ d;
		d = c ^ d;
		c = c ^ d;

		System.out.printf("c: %d, d: %d\n", c, d);
		//이렇게 swap할 수 있는데 잘 안씀 이해정도만 하고 저 공식만 외우면 됨.

	} // main

	public static void swap(int a, int b) {

		System.out.printf("a: %d, b: %d\n", a, b);

		int temp;
		temp = a;
		a = b;
		b = temp;

		System.out.printf("a: %d, b: %d\n", a, b);

	}

	public static void swap(String a, String b) {

		System.out.printf("a: %s, b: %s\n", a, b);

		String temp;
		temp = a;
		a = b;
		b = temp;

		System.out.printf("a: %s, b: %s\n", a, b);

	}

	public static void swap(boolean a, boolean b) {

		System.out.printf("a: %b, b: %b\n", a, b);

		boolean temp;
		temp = a;
		a = b;
		b = temp;

		System.out.printf("a: %b, b: %b\n", a, b);

	}

}
