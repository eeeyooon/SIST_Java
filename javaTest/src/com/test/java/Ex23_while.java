package com.test.java;//3.17

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex23_while {

	public static void main(String[] args) throws Exception {
		
		//m1();
		//m2();
		//m3();
		m4();
	
	} //main
	
	private static void m4() throws Exception {
		
		
		//프로젝트 때 활용하라고 알려줌.
		
		//루프 : 메뉴 출력 > 선택 > 실행 > 다시 메뉴로 돌아가기
		
		//학생 관리 시스템
		
		//이런건 while문보단 for문이 더 깔끔함. (기능적 차이는 x . 걍 땡기는 거 써도 돼~ 근데 while이 좀 더 자유도가 높음.)
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		boolean loop = true;
		
		while (loop) {
			System.out.println("==============");
			System.out.println("학생 관리 시스템");
			System.out.println("==============");
			System.out.println("1. 학생 등록하기");
			System.out.println("2. 학생 목록보기");
			System.out.println("3. 학생 성적처리");
			System.out.println("4. 학생 상담일지");
			System.out.println("5. 프로그램 종료");
			System.out.println("선택: ");
			
			String sel = reader.readLine();
			
			if (sel.equals("1")) {
				//1. 학생등록하기
				add();
				
			} else if (sel.equals("2")) {
				//2. 학생 목록보기
				list();
				
			} else if (sel.equals("3")) {
				//3. 학생 성적처리
				
			} else if (sel.equals("4")) {
				//4. 학생 상담일지
				
			} else {
				//5. 프로그램 종료 //무한루프종료
				loop = false; //= 무한루프탈출 break;도 가능하나 이게 더 조작이 편함.
			}
		} //while
		
		System.out.println("프로그램 종료");
		
		
		
	}
	private static void list() {
		
		System.out.println("학생 명단...");
		
	}

	private static void add() {
		
		System.out.println("학생 등록");
		
	}

	private static void m3() {
		
		//구구단
		int dan = 5;
		int n = 1;
		
		while (n <= 9) {
			
			System.out.printf("%d x %d = %2d\n", dan, n, dan * n);
			n++;
			
			
		}
		
		
	}
	
	
	private static void m2() {
		
		//누적
		
		//1~100사이의 값 누적하기
		
		
		int sum = 0;
		int n = 1;
		
		while (n <= 100) {
			
			sum += n;
			
			n++;
		}
		
		System.out.println(sum);
		
		
	}
	
	
	
	
	private static void m1() {
		
		
		/*
		
			for (초기식; 조건식; 증감식) {
			
			}
			
			반복 실행 (반복 실행하는 if문)
			
			while (조건식) {
			
			}
			
			
			1회 실행 
			
			if (조건식) {
			
			}
			
			
			
		
		*/
		
		
//		int num = 10;
//		
//		while (num >0) { //무한루프
//			
//			System.out.println("양수");
//		}
//		
		
		
		
		
		
		//요구사항] 1~10까지 출력하시오.
		
		for (int i=1; i<=10; i++) { //초기식; 조건식; 증감식
			System.out.println(i);
		}
		System.out.println();
		
		
		
		
		//위 for문과 같은 문장.
		//while문 공부는 for문했던 걸 while문으로하면 연습됨.
		int num = 1; //초기식;
		
		while (num <= 10) {	//조건식;
			System.out.println(num);
			num++; //증감식
			
			
		}
		
		
		
		
	}
	
	
	
	

	
}





