package com.test.java.question.loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws Exception {
		//Q02. 숫자를 10개 입력받아 한글로 변환한 후 출력하시오.
		//-1~9까지만 입력하시오.
		//1. BufferedReader로 1~9까지의 범위 안에서 숫자 10개를 받는다. (그 외 숫자는 예외처리)
		//2. 숫자와 숫자를 한글로 읽은 글자를 case문으로 연결
		//3. 숫자를 입력을 받을 때마다 result에 그 숫자의 한글을 저장한다.
		//4. 숫자 입력을 10회까지 받고 result를 출력한다.
	
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String result = "";
		
		
		
		int i = 1;
		while(i <= 10) {
			System.out.print("숫자: ");
			int num = Integer.parseInt(reader.readLine());
			
			if (1 <= num && num <= 9) {
			
			i++;
			result += korRead(num);
		
			} else {
				System.out.println("1~9까지의 숫자만 입력하시오.");
				continue;
			}
		
		}
		System.out.println(result);
		
		
		
		//for문으로 했을 때
//		for (int i=1; i<=10; i++) {
//		
//			System.out.print("숫자: ");
//			int num = Integer.parseInt(reader.readLine());
//		
//			if (1 <= num && num <= 9) {
//				result += korRead(num);
//			} else {
//				System.out.println("1~9까지의 숫자만 입력하시오.");
//				break;
//			}
//		}
//		System.out.println(result);
		
	}//main
	
	public static String korRead(int num) {
		
		switch (num) {
			case 1:
				return "일";
			case 2:
				return "이";
			case 3:
				return "삼";
			case 4:
				return "사";
			case 5:
				return "오";
			case 6:
				return "육";
			case 7:
				return "칠";
			case 8:
				return "팔";
			case 9:
				return "구";
		}
			return null;
				
		}
		
	}
	
	

