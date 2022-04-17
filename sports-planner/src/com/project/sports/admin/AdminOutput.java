package com.project.sports.admin;

import com.project.sports.output.Output;

public class AdminOutput {

	public static void AdminMenu() { //1.팀 정보 상세보기 //2. 선수 검색
		
		System.out.println("1. 팀/선수 정보 관리");
		System.out.println("2. 회원 관리");
		System.out.println("3. 예매 관리");
		System.out.println("4. 경기 일정 관리");
		System.out.println("5. 커뮤니티 관리");
		Output.back();
		Output.input();
	}

	public static void AdminTicketingMenu() {
		
		System.out.println("1. 예매 내역 확인");
		System.out.println("2. 매출 확인");
		Output.back();
		Output.input();
		
	}
	
	
	public static void ticketListMenu() {
		
		System.out.println("페이지 변경 <, > 입력");
		System.out.println("1. 예매 내역 상세보기");
		System.out.println("2. 아이디 검색");
		System.out.println("3. 날짜 검색");
		Output.back();
		Output.input();
		
		
	}
	
	public static void ticketListDetail() {
		
		System.out.println("예매 내역을 확인하고 싶은 경기 번호를 입력해주세요. (0. 뒤로가기)");
		System.out.print("경기 번호 입력 : ");
		
	}
	
	public static void bannedWordMenu() {
		
		System.out.println("1. 금지어 등록");
		System.out.println("2. 금지어 수정");
		System.out.println("3. 금지어 삭제");
		Output.back();
		Output.input();
		
	}
	

	
	

	
}
