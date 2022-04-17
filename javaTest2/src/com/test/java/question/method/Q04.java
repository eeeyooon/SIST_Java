package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

	public static void main(String[] args) throws Exception {
		
		//Q04. 숫자를 2개 입력받아 연산식을 반환하는 메소드를 선언하시오. 
		//설계
		//1. 라벨을 먼저 띄우기 ("첫번째 숫자: ") ("두번째 숫자: ")
		//2. BufferedReaderf를 생성한다. > throws Exception을 작성한다.
		//3. 숫자 2개를 입력받는다. reader.readLine()
		//4. 연산식과 그 결과를 String 형으로 반환해주는 메소드를 만든다.
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("첫번째 숫자: ");
		int num1 = Integer.parseInt(reader.readLine());
		
		System.out.println("두번째 숫자: ");
		int num2 = Integer.parseInt(reader.readLine());
		
		String result;
		result = add(num1, num2);
		System.out.println(result);
		
		result = subtract(num1, num2);
		System.out.println(result);
		
		result = multiply(num1, num2);
		System.out.println(result);
		
		result = divide(num1, num2);
		System.out.println(result);
		
		result = mod(num1, num2);
		System.out.println(result);
		
		
	} //main
	
	public static String add(int n1, int n2) {
		
		int calculation = n1 + n2;
		
		String result = n1 + " + " + n2 + " = " + calculation;
		return result;
		
		
	}
		
	
	public static String subtract(int n1, int n2) {
	
		int calculation = n1 - n2;
		
		String result = n1 + " - " + n2 + " = " + calculation;
		return result;
		
	}
	
	public static String multiply(int n1, int n2) {
		
		int calculation = n1 * n2;
		
		String result = n1 + " * " + n2 + " = " + calculation;
		return result;
		
	}
	
	
	public static String divide(int n1, int n2) {
		
		double calculation = (double)n1 / n2;		
		
		
		String result = n1 + " / " + n2 + " = " + calculation;
		return result;
		
		//소수점 아래 1자리까지만 출력되어야 하나, 하지못함.
		
	}
	
	public static String mod(int n1, int n2) {
	
		int calculation = n1 % n2;
		
		String result = n1 + " % " + n2 + " = " + calculation;
		return result;
		
	}
	
}
