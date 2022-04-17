package com.test.java.question.string; //03.22 과제 (완료)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {
		//Q01. 문장을 입력받아 역순으로 출력하시오.
		//1. BufferedReader 생성 + '문장 입력:' 라벨 띄우기
		//2. 문장의 길이만큼 반복 -> 입력값을 역순으로 result 문자열에 저장
		//3. result 출력
		//완료
		
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문장 입력: ");
		String statement = reader.readLine();
		
		String result = "";
		for (int i=statement.length(); i>0; i--) {
			
			result += statement.substring(i-1,i);
			
		}
		System.out.printf("역순 결과: \"%s\"\n", result );
		
		
	}
}
