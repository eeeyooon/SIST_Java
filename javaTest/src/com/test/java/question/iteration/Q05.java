package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {

	public static void main(String[] args) throws Exception {
		//Q05 시작 숫자와 종료 숫자를 입력받고 시작 숫자부터 종료 숫자까지의 숫자 모두 합하여 출력
		//1. BufferedReader생성하여 시작 숫자, 종료 숫자 입력받음.
		//2. 시작숫자부터 종료숫자까지의 모든 숫자 합함
		//3. '시작숫자 + n + (n+1) + ... + 종료숫자 = 2의 합' 출력
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("시작 숫자: ");
		int start = Integer.parseInt(reader.readLine());
		
		System.out.print("종료 숫자: ");
		int end = Integer.parseInt(reader.readLine());
		
		
		int sum = 0;
		for (int i=start; i<=end; i++) {
			if (i == end) {
				System.out.printf("%d = ", i );
				sum += i;
			} else {
				System.out.printf("%d + ", i);
				sum += i;
			}
		} System.out.printf("%d\n", sum);
		
		
	
		
	}
}
