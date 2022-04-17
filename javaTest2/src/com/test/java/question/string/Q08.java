package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {

	public static void main(String[] args) throws Exception {
		//Q08. 영단어를 입력받아 분리하시오.
		//합성어를 입력한다.
		//합성어는 파스칼 표기법
		//출력은 각 단어를 공백으로 구분한다.
		// 입력: StudentName / 출력: Student Name
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("단어: ");
		char[] pascal = reader.readLine().toCharArray();
		
		System.out.print("결과: ");
		
		for(int i=0; i<pascal.length; i++) {
			
			if('A' <= pascal[i] && pascal[i] <= 'Z') {
				System.out.print(" ");
			}
			System.out.print(pascal[i]);	
		}	
		
		
			
	}
}
