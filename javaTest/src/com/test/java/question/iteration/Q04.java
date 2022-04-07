package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

	public static void main(String[] args) throws Exception {
		//Q04. 입력 횟수(N)와 숫자 N개를 입력받아 짝수의 합과 홀수의 합을 각각 출력하시오.
		//1. BufferedReader를 생성하여 입력횟수를 먼저 받는다. -> N
		//2. N개만큼 숫자를 입력받는다. 
		//3. 그 숫자가 짝수면 evenSum에 누적합산 + evenCount에 +1, 홀수면 oddSum에 누적합산 + oddCount에 +1.
		//3. evenCount개의 합: evenSum , oddCount개의 합: oddSum 출력 
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("입력 횟수: ");
		int count = Integer.parseInt(reader.readLine());
		
		int evenSum = 0;
		int oddSum = 0;
		int evenCount = 0;
		int oddCount = 0;
	
		for (int i=0; i<count; i++) {
			System.out.print("숫자: ");
			int num = Integer.parseInt(reader.readLine());
				if (num % 2 == 0) {
					evenSum += num;
					evenCount += 1;
				} else if (num % 2 != 0) {
					oddSum += num;
					oddCount += 1;
				}
		}
		
		System.out.printf("짝수 %d개의 합: %d\n", evenCount, evenSum);
		System.out.printf("홀수 %d개의 합: %d\n", oddCount, oddSum);
		
		
		
	}
}
