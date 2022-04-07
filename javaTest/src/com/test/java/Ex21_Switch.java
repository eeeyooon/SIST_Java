package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex21_Switch {

	public static void main(String[] args) throws Exception {
		
		//Ex21_switch
		
		/*
		
			조건문
			1. if
			2. switch
			
			
			switch문, switch case문
			- 조건 : 값 > 반드시 정수(char도 정수니까 가능), 문자열, 열거형(enum)만 넣을 수 있음.
			- if문에 비해서 활용도가 낮다. 
			- if문에 비해서 가독성이 높다.
			
			
			
			switch (조건) {
				case 값:
					실행문;
					break; -> 최소 한번은 실행
				[case 값:
					실행문;
					break;] x N	-> 무제한 (안쓰거나 여러번써도 됨)
				[default:
					실행문;
					break;] x N -> 써도되고 안써도됨..
			}
		
		*/
		
		//m1();
		//m2();
		//m3();
		m4();
		
		
	}//main
	
	private static void m4() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//요구사항] 인터넷 쇼핑몰 > 상품 구매 > 옵션(패키지)
		//1. 노트북 + 메모리카드 -> USB C타입 케이블 + 마우스패드
		//2. 노트북 + 메모리카드 -> USB C타입 케이블
		//3. 노트북
		
		
		System.out.print("선택: ");
		
		String input = reader.readLine();
		
		switch (input) {
			case "1":
				System.out.println("마우스패드");
			case "2":
				System.out.println("USB C타입 케이블");
			case "3":
				System.out.println("노트북");
				break;
				
		}
		
		
	}
	
	
	
	
	private static void m3() throws Exception {
		
		//요구사항] 사용자가 월을 입력 > 해당월의 마지막 일?

		int lastDay = 0; //마지막 일을 저장할 변수
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("월: ");
		
		String month = reader.readLine();
		
		
		switch (month) {
			case "1":
			case "3":
			case "5":
			case "7":
			case "8":
			case "10":
			case "12":
				lastDay = 31;
				break;
			case "2":
				lastDay = 28;
				break;
			case "4":
			case "6":
			case "9":
			case "11":
				lastDay = 30;
				break;
			
		}
		
		System.out.printf("입력한 %s월의 마지막 날짜는 %d일입니다.\n", month, lastDay);
		
	}
	
	private static void m2() throws Exception {
		
		
		//요구사항] 자판기
		//- 메뉴 출력 > 음료 선택 > 가격 출력 
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("=================");
		System.out.println("       자판기");
		System.out.println("=================");
		System.out.println("1. 콜라");
		System.out.println("2. 사이다");
		System.out.println("3. 비타 500");
		System.out.println("------------------");
		System.out.println("선택: ");
		
		
		
		String sel = reader.readLine();
		
//		if (sel.equals("1")) {
//			System.out.println("700원입니다.");
//		} else if (sel.equals("2")) {
//			System.out.println("600원입니다.");
//		} else if (sel.equals("3")) {
//			System.out.println("500원입니다.");
//		}

		
//		switch (sel) {
//			case "1":
//				System.out.println("700원입니다.");
//				break;
//			case "2":
//				System.out.println("600원입니다.");
//				break;
//			case "3":
//				System.out.println("500원입니다.");
//				break;
//		}
//		
		
		
	//콜라와 사이다의 가격이 평생 같을 때.
		
		if (sel.equals("1") || sel.equals("2")) {
			System.out.println("800원입니다.");
		} else if (sel.equals("3")) {
			System.out.println("500원입니다.");
		}
		
		
		switch (sel) {
			case "1":
			case "2":
				System.out.println("800원입니다.");
				break;
			case "3":
				System.out.println("500원입니다.");
				break;
		}
		
		
		
		
	}
	
	
	private static void m1() {
		
		//요구사항] 숫자를 1개 입력받아 한글로 출력하시오.
		int num = 5; //사용자 입력
		
		
		if (num == 1) {
			System.out.println("하나");
		} else if (num == 2) {
			System.out.println("둘");
		} else if (num == 3) {
			System.out.println("셋");
		} else {
			System.out.println("나머지 숫자");
		}
		
		
		num = 4;
		
		//switch는 조건식을 넣는게 아니라 '조건'을 넣음. 그냥 데이터만 넣음.
		switch (num) {	//조건으로 값을 사용한다.
			case 1: //Label(위치를 표시하는 역할, 1:)
				System.out.println("하나");
				break; //switch문을 빠져나가라.
			case 2:
				System.out.println("둘");
				break;
			case 3:
				System.out.println("셋");
				break;
			default:	//if문의 else절과 같은 역할.
				System.out.println("나머지 숫자");
				break;
		}
		
		
	
	
	}//m1
	
	
	
	
	
	
	
} //class






