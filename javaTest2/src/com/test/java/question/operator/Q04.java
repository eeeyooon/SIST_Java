package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

	public static void main(String[] args) throws Exception {
		
		//네번째 문제
		
		//요구사항] 섭씨 온도를 입력받아서 화씨 온도로 변환하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("섭씨(℃): ");
		
		int celsius = Integer.parseInt(reader.readLine());
		
		double fahrenheit = (celsius*1.8f) + 32; 
						
		System.out.printf("섭씨 %d℃는 화씨 %.1f℉입니다.\n", celsius, fahrenheit );
		
		
		
		//앞 선 예제에서 나온 내용으로 코드를 정리함.
		//printf문 안에서 연산하지 않고 따로 변수를 만들어서 printf문 밖에서 연산함.
		
	}
}
