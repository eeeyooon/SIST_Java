package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {

	public static void main(String[] args) throws Exception {
		
		//일곱번째 문제
		
		//요구사항] 영문 소문자를 1글자 입력받은 후 대문자로 변환해서 출력하시오.
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자 입력 : ");
		
		int small = reader.readLine().charAt(0); 
		
		int big = small-32;
		
		
		System.out.printf("소문자 \'%c\'의 대문자는 \'%c\'입니다.", small, big);
		
		//논의사항
		//- int -> char 형변환은 명시적형변환이라고 알고 있었는데, printf문에서 %c로 형변환없이 int값이 들어가도 괜찮은지?
		// > printf문 안에서는 우리가 알고있는 형변환의 형식이 아니기 때문에 형식만 따지는 것이라 가능함.
		//	 printf문 밖에서 작성시에는 명시적으로 형변환 해주는 것이 맞음.
		

		
	}
}
