package com.project.sports.user;

import java.util.Scanner;
import com.project.sports.output.Output;
import com.project.sports.user.infoMenu.InfoMenu;

public class UserFunction {

	
	public static void loginSuccessMenu() {
		
		UserFunction user = new UserFunction();
		Scanner sc = new Scanner(System.in);
		boolean successFlag = true;
		
        while(successFlag) { //로그인 성공시 메뉴 출력 및 선택
     	   Output.typeMenu(); //마이페이지/종목선택하기
	           String input = sc.nextLine(); //메뉴 입력받기
	  
	           if(input.equals("1")){ //마이페이지
	        	   
	        	   
	        	   
	           } else if(input.equals("2")) { //종목선택하기
		        	   typeSelectMenu();
		        	   
		        	   
		        	   
	           } else if(input.equals("0")) {
	        	   successFlag = false;
	           } else { //유효성 검사
	        	   
	           }
        }
		
	}
	
	public static void typeSelectMenu() {
		Scanner sc = new Scanner(System.in);
		boolean typeSelectMenuFlag = true;
		while(typeSelectMenuFlag) {
			Output.selectTypeMenu();
			String input = sc.nextLine();
			
			if(input.equals("0")) {
				break;
			}
			
			if(input.equals("1")) { //야구선택
				
				mainMenu();
				
			} else if(input.equals("2")) { //축구
				
			} else if (input.equals("3")) { //농구
				
			} else if(input.equals("4")) { //배구
				
			} else if(input.equals("0")) {
				typeSelectMenuFlag = false;
			} else { //유효성
				
			}
		}
		}
	
	public static void mainMenu() {
		
		Scanner sc = new Scanner(System.in);
		boolean menuFlag = true;
		while(menuFlag) { 
			Output.mainMenu(); //메인메뉴 선택
			String input = sc.nextLine();
			
			if(input.equals("1")) { //정보
			
				InfoMenu.selectInfo();
				
			} else if(input.equals("2")) { //일정 

			} else if(input.equals("3")) { //순위
				
			} else if(input.equals("4")) { //예매
			
			} else if(input.equals("5")) { //승부예측
				
			} else if(input.equals("6")) { //커뮤니티
				
			} else if(input.equals("0")){
				menuFlag = false;
			} else {
				System.out.println("오류");
			}
		}
		
	}


}














