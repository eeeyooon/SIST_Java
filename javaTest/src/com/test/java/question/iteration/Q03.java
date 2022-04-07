package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {

	public static void main(String[] args) throws Exception {
		//Q03. 숫자 1개를 입력받아 1부터 입력한 숫자까지의 합을 출력하시오.
		//1. BufferedReader를 통해 숫자를 입력받고
		//2. 1부터 입력 숫자까지의 합을 계산함.
		//3. 출력할 땐 '1~입력숫자 = 2의 합'을 출력함.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("숫자: ");
		int num = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		
		for (int i=1; i<=num; i++) {
			sum += i;
		}
		
		System.out.printf("1 ~ %d = %d\n", num, sum);
			

		
	
	
	
	
	
	}
	
}
