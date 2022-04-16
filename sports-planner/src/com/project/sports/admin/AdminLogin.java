package com.project.sports.admin;

import java.util.Scanner;

public class AdminLogin {

	public static void adminLogin() {
		Scanner sc = new Scanner(System.in);
		Boolean adminLoginFlag = true;
		String adminNum = "1234";
		
		while(adminLoginFlag) {
			System.out.print("관리자 번호 : ");
			String input = sc.nextLine(); //관리자 번호 입력받기
			
			if (input.equals(adminNum)) { //관리자 번호가 일치하면
		           
		           System.out.println("로그인 성공");
	        	   adminLoginFlag = false;
	        	   
	        	   AdminMenu.selectAdminMenu();
	        	   
	        	   //관리자 메뉴
		          		           
		           
		        } else {
		           System.out.println("관리자 번호가 틀렸습니다.");
		           adminLoginFlag = false;
		        }
		
		}
	}
}
