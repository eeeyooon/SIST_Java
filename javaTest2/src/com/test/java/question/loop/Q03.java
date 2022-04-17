package com.test.java.question.loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {

	public static void main(String[] args) throws Exception {
		//Q03. 사용자가 입력한 범위의 숫자까지 369 게임 과정을 출력하시오. //1 2 짝 4 5 짝 78 짝 
		//- 최대 3자리까지만 입력하시오.
		// -369 게임? > 3 && 6 && 9 면 그 숫자 자리에 숫자 대신 "짝"입력 
		//while문으로 바꿔보기..
		
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("최대 숫자 : ");
		int num = Integer.parseInt(reader.readLine());
		
		if (num < 1000) {
			for(int i = 1; i<= num; i++) {
				if((i/10 == 3) || (i/10 == 6) || (i/10 == 9)) { //십의 자리수가 3, 6, 9인 경우
					 System.out.print("짝 ");
				} else if ((i%10 == 3) || (i%10 == 6) || (i%10 == 9)) { //일의 자리수가 3,6,9인경우
					System.out.print("짝 ");
				} else 
				System.out.print(i + " "); 
			} 
		} else {
			System.out.println("최대 3자리까지만 입력하시오."); // 최대 3자리 유효성 검사
		}
				
				
			
		
		
	
		
		
		
		
		
	}//main
}//class






