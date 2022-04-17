package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {

	public static void main(String[] args) throws Exception {
		
		//Q05. 숫자를 전달하면 '짝수' 혹은 '홀수'라는 단어를 반환하는 메소드를 선언하시오.
		//조건 : String getNumber(int)
		
		//설계
		//1. BufferedReader를 생성하고 throws Exception을 적는다.
		//2. 입력값을 받는다. reader.readLine().
		//3. 숫자를 2로 나누었을 때 나머지가 0이면 짝수, 0이 아니면 홀수로 반환하는 삼항연산자 메소드를 만든다.
		
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("숫자: ");
		int n = Integer.parseInt(reader.readLine());
		
		String result = getNumber(n);
		System.out.printf("입력하신 숫자 \'%d\'는(은) \'%s\'입니다.\n", n, result);
		
	}//main
	
	
	public static String getNumber(int num) {
		
		String parity_check = num % 2 == 0 ? "짝수" : "홀수" ;
		return parity_check;
		
		
	}
}
