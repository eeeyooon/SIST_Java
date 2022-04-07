package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws Exception {
		
		//2번 문제
		
		//요구사항] 숫자 2개를 입력받아 아래의 연산식을 출력하시오.
		
		//- 천단위 표기 %,d / -소수 1자리 %1f
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.print("첫번째 숫자: ");
		String input1 = reader.readLine();	
		int num1 = Integer.parseInt(input1);
		
		System.out.print("두번째 숫자: ");
		String input2 = reader.readLine();	
		int num2 = Integer.parseInt(input2);
		
		
		System.out.printf("%d + %d = %,d\n", num1, num2, num1 + num2);	
		System.out.printf("%d - %d = %,d\n", num1, num2, num1 - num2);	
		System.out.printf("%d * %d = %,d\n", num1, num2, num1 * num2);	
		System.out.printf("%d / %d = %.1f\n", num1, num2, (double)num1 / num2);
		System.out.printf("%d %% %d = %,d\n", num1, num2, num1 % num2);	
		
		
		
//		double dnum1 = Integer.parseInt(input1);
//		System.out.printf("%d / %d = %.1f\n", num1, num2, dnum1 / num2);
		
		//printf문에서 형변환을 하는 것이 좋은지, double변수를 밖에서 만들고 출력하는 것이 좋은지에 대해 논의함.
		// > 따로 변수를 만들지 않아도 되니 프린트문 안에서 형변환하는 것이 좋음.
		//다만 연산 길이가 길어지면 printf문 밖에서 하는 것이 좋음.		
		//산술기호나 문장부호 띄어쓰기를 해야 가독성이 높음.
		//변수명은 직관적인 것이 이해하기 쉬움.
		
		//더 생각해볼 것
		//1. 숫자가 아닌 값을 입력하면? > 삼항연산자 활용
		//2. 나눗셈의 결과가 정수일때, 소수 이하의 표시를 표시안하려면..? > %.0f / 처음부터 int값으로 받기
		
		
	}
}
