package com.project.sports.admin;

import java.util.Scanner;
import com.project.sports.admin.ticketing.SelectSalesList;
import com.project.sports.admin.ticketing.SelectTicketingList;
import com.project.sports.output.Output;

public class AdminTicketing {

	public static void adminTicketing() {
		
		Scanner sc = new Scanner(System.in);
		boolean adminTicketingFlag = true;
		
		while(adminTicketingFlag) {	//예매관리를 눌렀을때
				
				AdminOutput.AdminTicketingMenu(); //예매 관리 메뉴 보여주기

				String input = sc.nextLine(); //예매 관리 메뉴 번호 입력받기
		
				if(input.equals("1")) { //1. 예매 내역 확인
					
					//예매내역 확인 메소드 (클래스)
					SelectTicketingList.selectTicketingList();
					
				} else if(input.equals("2")) { //2. 매출 확인
					
					//매출 확인 메소드 (클래스)
					SelectSalesList.selectSales();
					
				}else if(input.equals("0")){
					
					Output.backMsg();
					adminTicketingFlag = false;
					
				} else { //유효성검사
					
				}
			}
		
	}
	
}



