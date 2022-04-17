package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws Exception {
		
		//Q02.학생의 국어 점수를 입력받아 성적을 출력하시오.
		//-조건 : 유효성 검사를 하시오. (점수 0~100점 이내)
		//1. BufferedReader 생성 + throws Exception 작성
		//2. 라벨 띄우기 '점수: '
		//3. 입력 받음 점수에 따라서 성적 분류.
		//4. 0~100점 이내가 아닐 경우 안내메세지
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("점수: ");
		int kor = Integer.parseInt(reader.readLine());
		
		char score = ' ';
		
		if (0 <= kor && kor <= 100) {
			if (90 <= kor) {	//유효성검사에서 kor <=100이 있으니까 여기에선 뺌.
				score = 'A';
			} else if (80 <= kor && kor <= 89) {
				score = 'B';
			} else if (70 <= kor && kor <= 79) {
				score = 'C';
			} else if (60 <= kor && kor <= 69) {
				score = 'D';
			} else if (0 <= kor && kor <= 59) {
				score = 'F';
			}
			System.out.printf("입력한 %d점은 성적 %s입니다.\n", kor, score);
		} else {
			System.out.println("점수가 올바르지 않습니다. 0~100사이의 값을 입력하시오.");
		}

	

		

		
		
	
	
	}
}

