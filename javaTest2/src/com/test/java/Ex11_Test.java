package com.test.java;	//03.10

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex11_Test {

	public static void main(String[] args) throws Exception {
		
		//연산자 수업 연장 > 일부 테스트
		
		//요구사항] 사용자 키보드 입력 > 문자 1개 > 영어 소문자인지 검사
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("영소문자 입력: ");
		String input = reader.readLine();
		
		System.out.println("입력된 문자: " + input);
		
		//입력한 문자의 문자코드값을 얻어야함.
		//String -> int : 참조형과 값형끼리는 형변환 불가능
		
		//Stirng -> char (바꾼 후)-> int
		char c = input.charAt(0);	//"a" -> 'a'
		
		int code = (int)c;
		
		System.out.println(code);
		
		
		//Alt + Shift + Y = 자동 줄바꿈? (파일 열때마다)
		
		
		//영 소문자 > a(97) ~ z (122)
		System.out.println(code >= 97);
		System.out.println(code <= 122);
		
		System.out.println(code >= (int)'a');	//소문자의 문자코드 외우지 않아도 캐스팅하면 됨.
		System.out.println(code >= (int)'z');
		
		//char 자료형은 우위 비교가 가능함. > 내부적으로 숫자라서
		System.out.println('f' >= 'a');
		System.out.println('f' <= 'z');
		
		//String 자료형은 우위 비교가 불가능함.
		//System.out.println("f" >= "a"); // error
		
		
		
		
		
		
		
		
		
		
		
	}
}
