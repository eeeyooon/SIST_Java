package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {

	public static void main(String[] args) throws Exception {
		//Q05. 숫자 2개와 연산자 1개를 입력받아 연산 과정과 결과를 출력하시오.
		//-조건 : 정수만(유효성 검사x), 나머지 연산 결과는 소수 이하 첫째자리까지, 연산자는 산술연산자만
		//1. Bufferedreader 생성 + throws Exception 작성
		//2. 라벨 띄우기 '첫번째 숫자: ', '두번째 숫자: ', '연산자: '
		//3. operator == '+'?
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자: ");
		int num1 = Integer.parseInt(reader.readLine());
		
		System.out.print("두번째 숫자: ");
		int num2 = Integer.parseInt(reader.readLine());
		
		System.out.print("연산자: ");
		String operator = reader.readLine();
		
		
		if (operator.equals ("+")) {
			System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2); 
		} else if (operator.equals ("-")) {
			System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2); 
		} else if (operator.equals ("*")) {
			System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2); 
		} else if (operator.equals ("/")) {
			System.out.printf("%d / %d = %.1f\n", num1, num2, (double)num1 / num2); 
		} else if (operator.equals ("%")) {
			System.out.printf("%d %% %d = %d\n", num1, num2, num1 / num2); 
		} else {
			System.out.println("연산이 불가능합니다.");
		}
		
		
		
		
	} //main
}








