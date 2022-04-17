package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {

	public static void main(String[] args) throws Exception {
		
		//세번째 문제
		
		//요구사항] 사각형의 너비와 높이를 입력받아 넓이와 둘레를 출력하시오.
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("너비(cm): ");
		int width = Integer.parseInt(reader.readLine());
		
		System.out.print("높이(cm): ");
		int height = Integer.parseInt(reader.readLine());
		
		System.out.printf("사각형의 넓이는 %d㎠입니다.\n", width * height);
		System.out.printf("사각형의 둘레는 %dcm입니다.\n", (width + height) * 2);
		
		
		
		
		//- 입력값을 치환하지 않을 땐 'input'보다 직관적으로 이해할 수 있는 변수명으로 설정해줘야함 
		
		//- input값을 변수로 따로 만들고, 값을 치환하는 문장을 따로 만드는 것보다
		//  	int height = Integer.parseInt(reader.readLIne());
		// 		int width = Integer.parseInt(reader.readLine());
		// 	> 위처럼 한문장으로 쓰는 것이 직관적이고 깔끔함.
		//-간편하게 쓰기 vs 직관적으로 보이게 쓰기. (width * 2) + (height * 2) vs (width + height) * 2 
		// > (width + height) * 2 가 더 깔끔하다고 결정.
		
		//- 출력만 하면 되는 문제니까 printf문에 연산식을 넣었지만, 연산식이 길어질 경우 변수를 따로 빼서 연산하는 게 가독성 있음.
		
		
	}
}


