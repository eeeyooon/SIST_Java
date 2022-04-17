package com.test.java.question.multifor; //3.17(과제)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {

	public static void main(String[] args) throws Exception {
		//Q08. 숫자 2개를 입력받아 각각의 약수와 두 숫자의 공약수를 구하시오.
		//- 공약수 : 둘 이상의 정수에 공통된 약수
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자: ");
		int num1 = Integer.parseInt(reader.readLine());
		
		System.out.print("두번째 숫자: ");
		int num2 = Integer.parseInt(reader.readLine());
		
		
	}
}
