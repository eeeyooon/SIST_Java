package com.project.sports.output;

import java.util.Scanner;

public class Output {
	public static void startMenu() {
		System.out.println("1. 로그인");
		System.out.println("2. 비회원");
		System.out.println("3. 회원가입");
		System.out.println("4. 아이디/비밀번호 찾기");
		System.out.println("5. 프로그램 종료");
	}
	
	public static void input() {
		System.out.print("메뉴 번호 : ");
	}
	
	public static void loginMenu() {
		System.out.println("1. 회원");
		System.out.println("2. 관리자");
		back();
		input();
	}
	
	public static void typeMenu() {
		System.out.println("1. 마이페이지");
		System.out.println("2. 종목 선택하기");
		back();
		input();
	}
	
	public static void back() {
		System.out.println("0. 뒤로가기");
	}
	
	public static void selectTypeMenu() {
		System.out.println("1. 야구");
		System.out.println("2. 축구");
		System.out.println("3. 배구");
		System.out.println("4. 농구");
		back();
		input();
	}
	
	public static void mainMenu() {
		System.out.println("순위 top3");
		System.out.println("오늘의 빅매치");
		System.out.println("1. 정보");
		System.out.println("2. 일정");
		System.out.println("3. 순위");
		System.out.println("4. 예매");
		System.out.println("5. 승부예측");
		System.out.println("6. 커뮤니티");
		back();
		input();
	}
	
	
	
	public static void pause() {
	      System.out.println("계속하시려면 [엔터]를 입력하세요.");
	      Scanner scanner = new Scanner(System.in);
	      scanner.nextLine();
	}
	
	public static void backMsg() {
	      System.out.println("뒤로 이동합니다.");
	      System.out.println();
	      System.out.println();
	      
	}
	
	
	
}
