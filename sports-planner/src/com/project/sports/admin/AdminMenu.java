package com.project.sports.admin;

import java.util.Scanner;
import com.project.sports.admin.ticketing.AdminTicketing;
import com.project.sports.output.Output;

public class AdminMenu {

	public static void selectAdminMenu() {
		
	Scanner sc = new Scanner(System.in);
	boolean AdminMenuFlag = true;
	
	while(AdminMenuFlag) {	//관리자 로그인 성공시 
			
			//관리자 메뉴 보여주기
			AdminOutput.AdminMenu();
			
			String input = sc.nextLine(); // 관리자 메뉴 번호 입력받기
	
			if(input.equals("1")) { //1. 팀/선수 정보관리
				
				
			} else if(input.equals("2")) { //2.회원 관리
				
				
			} else if(input.equals("3")) { //3. 예매 관리
				
				AdminTicketing.adminTicketing(); //예매 관리 메뉴로
				
			} else if(input.equals("4")) { //4. 경기 관리
				
			} else if(input.equals("5")) {	//5. 커뮤니티 관리
				
			} else if(input.equals("0")){
				
				Output.backMsg();
				AdminMenuFlag = false;
				
			} else { //유효성검사
				
			}
		}
	}
	
}
	
	
	

