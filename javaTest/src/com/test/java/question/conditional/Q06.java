package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {

	public static void main(String[] args) throws Exception {
		//Q06. 영문자 1개를 입력받아 대/소문자 변환을 한 뒤 출력하시오.
		//조건 : 유효성 검사를 하시오 (영문자만 입력 가능)
		//1. BufferedReader를 생성하여 문자를 입력 받는다.
		//2. 소문자를 입력받으면 대문자로 출력, 대문자를 입력받으면 소문자로 출력.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자 : ");
		
		int word = reader.readLine().charAt(0); 
		

		if (65 <= word && word <= 128) {
			if (word <= 96) {		//유효성 검사에 65 <= word있으니까 뺌.
				System.out.printf("\'%s\'의 소문자는 \'%s\'입니다.", (char)word , (char)(word + 32));
			} else if (97 <= word) {
				System.out.printf("\'%s\'의 대문자는 \'%s\'입니다.", (char)word , (char)(word - 32));
			}
		} else {
			System.out.println("영문자만 입력하시오.");
		}
		
	
	}
}
