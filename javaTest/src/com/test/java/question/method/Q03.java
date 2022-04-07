package com.test.java.question.method;

public class Q03 {

	public static void main(String[] args) {
		
		//Q03. 숫자 1개를 전달하면 4자리로 출력하는 메소드를 선언하시오.
		//조건 : void digit(int num), 입력한 숫자가 4자리 이상이면 그대로 출력.
		
		//설계
		//1. int 타입 가인자가 있는 digit 메소드 선언.
		//2. 입력한 숫자가 1~3자리 숫자일 땐 앞자리에 0을 채우고 4자리 이상 숫자는 그대로 출력함.

		
		
		digit(1);
		digit(12);
		digit(321);
		digit(5678);
		digit(98765);
		
		
	}//main
	
	
	
	public static void digit(int num) {
		
		System.out.printf("%d -> %04d\n", num, num);
		
	}
}
