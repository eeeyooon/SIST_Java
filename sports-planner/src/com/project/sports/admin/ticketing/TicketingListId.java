package com.project.sports.admin.ticketing;

import java.util.Scanner;
import com.project.sports.input.Schedule;
import com.project.sports.input.Ticketing;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

public class TicketingListId {

	public static void idSearch () { //아이디 검색
		
		
		Scanner sc = new Scanner(System.in);
		boolean idSearchFlag = true;
		
		while(idSearchFlag) {	//예매 내역 확인에서 아이디 검색을 선택했을 때
			
				System.out.println("예매내역을 확인할 회원의 아이디를 검색해주세요. (0. 뒤로가기)");
				System.out.print("아이디 입력 : ");
				String input = sc.nextLine(); // 회원 아이디 입력받기
				
				//0odf7eyeeulatf
				//예매내역 2개인 사람
				
				Boolean hasUser = false; //회원이 존재하는지
			
				int idSeq = 0;
				for (Ticketing t : Data.ticketingList) {
				
					if (input.equals(t.getId())) { //입력받은 아이디의 회원의 예매내역이 있으면
					
						hasUser = true;	//회원이 존재하면 hasUser를 true로 반환
						idSeq += 1; //회원이 있을때마다 회원 seq +1
						
						int ticketingGame = t.getScheduleSeq(); //회원이 예매한 경기번호를 
						
						String ticketingTeam1 = "";
						String ticketingTeam2 = "";
						
						for (Schedule s : Data.scheduleList) {
							
							if (ticketingGame == s.getSeq()) {
								
								ticketingTeam1 = s.getTeam1();
								ticketingTeam2 = s.getTeam2();
								
							}
						}
						
						//날짜, 시간, 경기장 추가하기
						System.out.println("번호\t아이디\t\t\t경기\t\t\t 예매좌석");
						System.out.printf("%d\t%-16s\t%-7s vs %-7s   %s%s\n",
											idSeq,
											t.getId(),
											ticketingTeam1,
											ticketingTeam2,
											t.getBlock(),
											t.getSeatNum());
						
					}	
				
				}
				
				
				if(input.equals("")){ //아무것도 입력하지 않으면 입력하라는 메세지 출력
					
					System.out.println("내용을 입력해주세요.");
					System.out.println();
					
				} else if(input.equals("0")) { //0을 입력하면 back메세지와 함께 뒤로가기
					
					Output.backMsg();
					idSearchFlag = false;
					
				} else if (hasUser == false) { //아이디가 존재하지 않으면
					System.out.println("일치하는 회원이 없습니다.");
					System.out.println();
					Output.pause();
					
				} else {
					System.out.println();
					Output.pause();
				}
					
						
				
				
				
			}
		
		
		
	}
}
