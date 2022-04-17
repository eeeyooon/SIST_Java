package com.test.java.question.method;

public class Q02 {

	public static void main(String[] args) {
		
		//Q02. 이름을 전달하면 이름 뒤에 '님'을 붙여서 반환하는 메소드를 선언하시오.
		//조건 : String getName(String name), name:ooo(이름), reutrun:ooo(이름)님
		//출력 : 고객:홍길동 \n 고객:아무개님
		
		//설계
		//1. 고객의 이름을 받으면 '님'을 붙여 반환하는 메소드 선언. 
		//2. 메소드를 호출하여 "고객: "과 함께 출력.
		
		
		String result;
		
		result = getName("홍길동");
		System.out.printf("고객: %s\n", result);
		
		result = getName("아무개");
		System.out.printf("고객: %s\n", result);
		
		
		
	} //main
	
	
	public static String getName(String name) {
		
		String result = name + "님";
		return result;
		
		
	}
}
