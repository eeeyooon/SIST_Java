package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {

	public static void main(String[] args) throws Exception {
		//Q03. 문자 1개를 입력받아 아래와 같이 출력하시오.
		//대소문자 구분없이 f,F-> Father / m,M -> Mother / s,S -> Sister / b,B -> Brother
		//유효성 검사 (위 문자가 아닌 문자는 예외 처리)
		//1. BufferedReader 생성 + throws Exception 작성
		//2. 라벨 띄우기 '문자: '
		//3. word == 'f' || word == 'F' -> Father
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자: ");
		char word = reader.readLine().charAt(0);
		
		if (word == 'f' || word == 'F') {
			System.out.println("Father");
		} else if (word == 'm' || word == 'M') {
			System.out.println("Mother");
		} else if (word == 's' || word == 'S') {
			System.out.println("Sister");
		} else if (word == 'b' || word == 'B') {
			System.out.println("Brother");
		} else {
			System.out.println("입력한 문자가 올바르지 않습니다.");
		}

		//string으로 받는 방법도 ㅇ
		
	}//main
}






