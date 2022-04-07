package com.test.java; //03.15

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex20_if {

	public static void main(String[] args) throws Exception {
		//Ex20_if.java
		
		
		/*
		
			제어문
			- 수많은 명령어들의 흐름(실행 순서)을 통제하는 역할
			- 조건 제어, 반복 제어, 분기 제어
			
			
			1. 조건문
				-개발자가 조건을 제시한 후 프로그램의 흐름을 제어한다.
				a. if
				b. switch
				
			2. 반복문
				- 특정 코드를 개발자가 원하는 횟수만큼 반복 실행한다.
				a. for
				b. while
				c. do while
				d. for > 보통 자바만 이렇게 쓰고 다른 언어들은 foreach > java에서는 향상된 for문(Enhanced for)이라고 함.
				
			3. 분기문
				- 개발자가 코드의 흐름을 원하는 곳으로 이동시킴.
				a. break
				b. continue
				//c. goto(jdk 1.5에서 폐기 / c나 c++엔 있으나 요즘은 안씀.)
				
		*/
		
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
		
		
		
		
		
	}//main
	
	
	private static void m5() {
		
		//c나 c++ 배운사람들 주의해서 참고하라고 알려주는 것.
		//나중엔 자바랑 다르게 C처럼 boolean형 없는 언어 배움.
		
		/*
			조건의 조건식
			- 반드시 boolean값이어야만 한다. (100%)
			- 자바는 c계열 언어이다.
			- C언어는 boolean형이 없다. > 정수 사용(1, 0) > 자바는 boolean 자료형을 만들어냄.
			
			- 정수 : 0 (false), 1(true), 0이 아닌 모든 숫자 (true)
			- 실수 : 0.0(false), 0이 아닌 모든 숫자 (true)
			- 문자 : \0(null 문자, 문자코드값(0))(false), 그 이외의 모든 문자(true)
			- 문자열 : ""(빈문자열)(false), "홍길동"(true) 
			
			
			if (조건식) {
			
		
		*/
	}
	
	
	
	private static void m4() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//성적 입력 > 합격/불합격 통보
		
		System.out.println("성적: ");
		
		int score = Integer.parseInt(reader.readLine());
		
		//데이터의 자격(조건) > 0 ~ 100 > 유효성검사
		
		//if (score >= 60) {
		//	System.out.println("합격");
		//} else {
		//	System.out.println("불합격");
		//}
		
		
		// 첫번째 if문
		//- 조건 3개
		//1. (score >= 60 && score <= 100)
		//2. (score >=0 && score <= 59)
		//3. 100보다 크거나 0보다 작을때 걸림. (얜 성적처리가 아니라 예외처리 조건)
		// 얜 사람이 눈으로 직접 구분해야함. 여기까지가 성적처리, 여기까지가 예외처리
		
		
		if (score >= 60 && score <= 100) {
			System.out.println("합격");
		} else if (score >=0 && score <= 59) {
			System.out.println("불합격");
		} else {
			System.out.println("점수는 0 ~ 100점 사이로 입력하시오.");
		}
	
		
		//실습할때 *********
		//나열한 조건들이 동등한 레벨들인지, 서로 다른 레벨의 조건들인지 구분해야 해.
		//성질이 다르면 if문 쪼개!!!(중첩되는 형태로) 같으면 나란히 하고
		
		
		//두번째 if문 => 중첩 if문
		//1. (score >= 0 && score <= 100)	//선조건(유효성검사)
			//1.1 (score >= 60) 			//하위조건
			//1.2 else절						//1.1과 1.2는 성적처리 조건
		//2. 1을 만족하지 못했을때				//예외처리 조건
											//성적에 따라 명확히 구분됨. (구조적으로)
		
		
		//유효성 검사를 먼저하고 성적처리
		if(score >= 0 && score <= 100) {
		
			if (score >= 60) {
				System.out.println("합격");
			} else {
				System.out.println("불합격");
			}
		
		} else {
			System.out.println("점수는 0 ~ 100점 사이로 입력하시오.");
		}
		
		
		
		
	}
	
	
	private static void m3() throws Exception {
		
		//보기 > 선택 (선택에 따라 가점이 다름.)
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0; //누적 변수
		
		System.out.println("A. 무슨 색을 좋아합니까?");
		System.out.println("1. 검정색");
		System.out.println("2. 노란색");
		System.out.println("3. 파란색");
		
		System.out.println("선택: ");
		
		String input = reader.readLine();
		
		if (input.equals("1")) {
			sum = 10;
		} else if (input.equals("2")) {
			sum = 5;
		} else if (input.equals("3")) {
			sum = 3;
		}
		
		
		
		System.out.println("B. 어떤 언어를 선호합니까?");
		System.out.println("1. Java");
		System.out.println("2. C#");
		System.out.println("3. C++");
		
		System.out.println("선택: ");
		
		input = reader.readLine();
		
		if (input.equals("1")) {
			sum += 5;
		} else if (input.equals("2")) {
			sum += 3;
		} else if (input.equals("3")) {
			sum += 7;
		}
		
		
		System.out.println("완료되었니다.");
		System.out.println("[결과]");
		
		
		if (sum > 15) {
			System.out.println("당신은 진취적인 개발자입니다.");
		} else if (sum <= 15 && sum >= 10 ) {
			System.out.println("당신은 평범한 개발자입니다.");
		} else {
			System.out.println("다른 일을 찾아보세요");
		}
		
		
	}
	
	
	
	
	private static void m2() throws Exception {
		
		//요구사항] 나이 입력 받아 성인 / 미성년자 출력하기
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("나이: ");
		int age = Integer.parseInt(reader.readLine());
		
		String result = age >= 19 ? "성인" : "미성년자";
		System.out.println(result);

		
		//간단한 경우엔 삼항 연산자. 점점 커질수록 if문으로(90~95%)
		
		if (age >= 19) {
			result = "성인";
		} else {
			result = "미성년자";
		}
		System.out.println(result);
		
		
		
	}
	
	
	private static void m1() {
		
		/*
			if문
			- 개발자가 조건을 제시한 후 프로그램의 흐름을 제어한다.
			- 조건식 > boolean값을 가져야 함. 
			
			
			1. if문 (단일 조건문)
			
			if (조건식) {
			 	실행문; 
			 }
			
			
			2. if-else문
			
			if (조건식) 
			{
				실행문;
			} else {
				실행문;
			}
			
			
			
			3. if-else if문 +
			
			
			if (조건식) {
				실행문;
			}
			else if (조건식) {
				실행문;
			}
		
		
		
			4. if-else if문에도 마지막에 else 사용 가능.
			
			
			5. 총 정리
			
			if (조건식) {
				실행문;
			} 
			[else if (조건식) {
				실행문;
			}] x N 
			[else {
				실행문;
			}]
			
			[] : 사용해도 되고, 생략해도 됨.
			x N : 횟수 무제한. (마음대로)
			
		
		
		
		*/
		
		boolean flag = true;
		
		if (flag) {
			
			System.out.println("참입니다.");
			
		}//if
		
		
		int n = 10;
		
		if (n>0) {
			
			System.out.println("양수입니다.");
			
		}
		
		
		
		if (n>0) {
			
			System.out.println("양수입니다.");
			
		} else {
			
			System.out.println("양수가 아닙니다.");
			
		}
		
		if (n > 0) {
			
			System.out.println("양수입니다.");
			
		} else if (n < 0) {
			
			System.out.println("음수입니다.");
			
		} else { //else if (n == 0) 이거 말고 else만 해도 됨. 다중if문에도 else가능. 양수나 음수 아니면 0인경우밖에 없으니까.
			
			System.out.println("0입니다.");
			
		}
		
		
		
		
		System.out.println("프로그램 종료");
		
		
		
	}//main
	
	
}










