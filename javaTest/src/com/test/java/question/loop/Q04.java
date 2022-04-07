package com.test.java.question.loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

	public static void main(String[] args) throws Exception {
		//Q04. 최대 9자리 정수를 입력받아 각 자리의 홀수 숫자합과 짝수 숫자합을 구하시오.
		//- 9자리 이하 숫자만 입력하시오.
		//- Math.pow()메소드 사용 or 나누기와 나머지 연산자 사용.
		// Math.pow(10, 0) -> 1 / Math.pow(10, 1) -> 10 /Math.pow(10, 2) -> 100 / Math.pow(10, 3) -> 1000 
		// > (N / 10) % 10 = N의 첫번째 자리
		// > 자리수마다 숫자 뽑는 걸 (1자리 ~ 9자리 반복)
		//숫자 입력: 273645281
		//짝수의 합: 22
		//홀수의 합: 16
		//while문?
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 입력: ");
		int num = Integer.parseInt(reader.readLine());
		
		 	int evenSum = 0;
		 	int oddSum = 0;
		    
		 	
		 	if (num >= 1000000000 ) {
		 		System.out.println("9자리 이하 숫자만 입력하시오."); //유효성 검사
		 		
		 	} else {
		 	
			 	for (int i=0; i<9; i++) {
			 		
			 		int digit = (int)(num / Math.pow(10, i)) % 10;
			 		if (digit % 2 == 0) {
			 			evenSum += digit;
			 		} else {
			 			oddSum += digit;
			 		}
			    	
			    }
		    System.out.println("짝수의 합: " + evenSum);
		    System.out.println("홀수의 합: " + oddSum);
		 	}
	}	    
}
	

