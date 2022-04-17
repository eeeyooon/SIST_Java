package com.test.java.student;

import java.util.Scanner;

public class Output {

	//객체를 만들어도 되고, 안만들어도 돼 -> 우선 안만드는 쪽으로 (그래서 메소드를 static으로)
	//화면에 정적으로 찍히는 애들은 모두 여기 클래스로
	
	//일단 출력업무 담당하는 애들(정적출력, 데이터출력)은 다 따로 클래스로 할겨
	//그 중에서도 정적 출력은 여기
	public static void title() {
		
		System.out.println("===============================");
		System.out.println("         학생 관리 프로그램");
		System.out.println("===============================");
		
	}
	
	public static void mainmenu() {
		
		System.out.println("1. 학생 등록하기");
		System.out.println("2. 학생 목록보기");
		System.out.println("3. 학생 검색하기");
		System.out.println("4. 종료");
		System.out.print("선택: ");
		
	}
	
	public static void close() {
		

		System.out.println("프로그램 종료");
	
		
	}
	
	public static void subtitle(String title) {	//학생등록, 메뉴보기 등 계속 사용할거니까 하나로 여러개쓰게
												//rename할때 workspace로
		
		System.out.println(); //큰 타이틀과 메뉴 선택 구분할수 있게 개행문자
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println("          " + title);
		System.out.println("-------------------------------");
		
	}
	
	
	public static void submenu() {
		
		
		//여기서만 볼 수 있는 메뉴 띄우기
		System.out.println("-------------------------------");		
		System.out.println("1. 상세보기");
		System.out.println("2. 수정하기");
		System.out.println("3. 삭제하기");
		System.out.println("4. 메인으로 돌아가기");	 //상위메뉴, 즉 메인 메뉴로 돌아가기
		System.out.println("-------------------------------");		
		System.out.print("선택: ");
		
		
	}
	

	public static void pause() {

		System.out.println("계속하시려면 [엔터]를 눌러주세요.");
		
		//프로그램 일시 정지
		Scanner scan = new Scanner(System.in);
		
		scan.nextLine(); //블럭.. == 일시정지
		
		
	}
	
	
	
}











