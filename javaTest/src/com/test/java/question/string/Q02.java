package com.test.java.question.string; //03.22 과제 (완료)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws Exception {
		//Q02. 이메일 주소를 입력받아 아이디와 도메인을 각각 추출하시오.
		//- '@'를 기준으로 ID와 도메인 분리
		// 방법
			//1. '@' 찾고 substring으로 추출
			//2. '@'를 구분자로 하여 split
		//1. BufferedReader 생성 + 라벨 띄우기 ('이메일: ')
		//2. 입력값을 String input에 저장
		//3. String [] email =  input.split("@"); @를 구분자로 앞, 뒤 분리 
		//4. email[0] = 아이디 / email[1] = 도메인
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이메일: ");
		String input = reader.readLine();
		String [] email =  input.split("@");
		
		System.out.printf("아이디: %s\n도메인: %s\n", email[0], email[1]);
	}
}
