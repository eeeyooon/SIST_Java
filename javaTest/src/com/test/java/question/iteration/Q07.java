package com.test.java.question.iteration;

public class Q07 {

	public static void main(String[] args) {
		//Q07. 누적값이 1000을 넘어가는 순간 루프를 종료하시오.
		//1. sum 변수 생성,  sum에 1씩 더하는 무한루프를 만든다.
		//2. 1000이 넘으면 break;
		
		int sum = 0;
		for (int i=1; ; i++) {	
			
			sum = sum + i;
			
			if (sum > 1000) {
				System.out.printf("%d = %d", i, sum);
				break;
			} else {
				System.out.printf("%d + ", i);
			}
		}
		
		
	}//main
}
