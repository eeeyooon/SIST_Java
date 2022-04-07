package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {
		
		//1번 문제
		
		
		//요구사항] 태어난 년도를 입력받아 나이를 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.print("태어난 년도를 입력하세요: ");
		String input = reader.readLine();	
		
		int year = Integer.parseInt(input);
		
		int age = 2022 - year + 1;
		//printf에서 연산하는 것보다 age변수를 따로 만들어 연산값을 출력하는게 더 가독성있음.
		
		System.out.printf("나이 : %d세\n" , age);

		
		//더 생각해볼 것?
		//-시간적 여유가 있으면 직접 코드를 짜볼 예정
		
		// 숫자가 아닌 값을 입력하면? 삼항연산자 활용
		// 올바른 값이 아닌 걸 입력하면? 삼항연산자 활용
		// 올해가 2022년이 아니라면? 입력값 > 올해 년도, 태어난 년도.
		
	}
}
