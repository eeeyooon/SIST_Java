package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {

	public static void main(String[] args) throws Exception {
		//Q06. 
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("시작 숫자: ");
		int start = Integer.parseInt(reader.readLine());
		
		System.out.print("종료 숫자: ");
		int end = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		for (int i=start; i<=end; i++) {
			if (i != start) {
			//첫번째 숫자는 예외처리 짝이면 (-), 홀이면 (+)
				if (i % 2 == 0) {
					System.out.printf(" - %d", i);
				} else if (i % 2 != 0) {
					System.out.printf(" + %d", i);
				}
				} else System.out.print(i);
			
			if (i % 2 == 0) {
				sum -= i;
			} else 
				sum += i;
			
			if (i == end) {
				System.out.printf(" = %d", sum);
			}
			
			
			//flag : 양수, 음수 부호를 바꿔주는 변수 생성.
			
		}//for		
		
	}//main

}//class