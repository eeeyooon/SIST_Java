package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {

	public static void main(String[] args) throws Exception {
		
		//여섯번째 문제
		
		//요구사항] 사용자의 한달 수입을 입력받아 세후 금액을 출력하시오.
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("한달 수입 금액(원): ");
		
		int income = Integer.parseInt(reader.readLine());
		
		double tax = income * 0.033; 
		
		double after_tax = income - tax; 
						
		System.out.printf("세후 금액(원) : %,.0f원 \n세금(원) : %,.0f원\n", after_tax, tax );
		
		
		//앞 선 예제에서 나온 내용으로 코드를 정리함.
		//printf문에 연산식을 적지말고 따로 변수를 만들어서 연산하는 것이 더 가독성 있음.
		
	}
}
