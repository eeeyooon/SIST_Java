package com.project.sports.admin.bannedword;

import java.util.Scanner;
import com.project.sports.input.BannedWord;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

public class EditBannedWord {

	public static void editBannedWord () {
		
		Scanner sc = new Scanner(System.in);
		boolean editBannedNumFlag = true;
		
		while(editBannedNumFlag) {
			
			
			System.out.println("수정할 금지어의 번호를 선택하세요. : ");
			String editNum = sc.nextLine();
			
			if (editNum.equals("")) { 
				System.out.println("내용을 입력해주세요.");
				
			} else if (editNum.equals("0")) {
				Output.backMsg();
				break;
				
			} else { // 유효성검사

			}
			
			
			boolean editBannedWordFlag = true;
			while(editBannedWordFlag) {
				
				System.out.println("수정할 금지어를 입력하세요. (0. 뒤로가기)");
				String editWord = sc.nextLine();
				
				
				if (editWord.equals("")) { 
					System.out.println("내용을 입력해주세요.");
					
				} else if (editWord.equals("0")) {
					Output.backMsg();
					break;
					
				} else { // 유효성검사

				}
				
				
				boolean editFlag = true;
				
				while(editFlag) {
					
					System.out.println("금지어를 수정하시겠습니까? (y/n)");
					String answer = sc.nextLine().toUpperCase();
					
					
					if(answer.equals("Y")) {
						
						for (BannedWord b : Data.bannedWordList) {
							
							
							if(Integer.parseInt(editNum) == 
									AdminBannedWord.bannedWordList.get(Integer.parseInt(editNum)-1).getSeq()) {
								
							//	b.getBannedWord(editWord);
								
								//BannedWord bannedWord = new BannedWord(lastSeq, input);
								//Data.bannedWordList.add(bannedWord);
								
								BannedWord bannedWord = new BannedWord(Integer.parseInt(editNum), editWord);
							
								Data.bannedWordList.set(Integer.parseInt(editNum), bannedWord);
								
								
								//AdminBannedWord.bannedWordList.set(AdminBannedWord.bannedWordList.get(Integer.parseInt(edintNum)-1).getSeq(), editWord);
								
								//일요일에 여기서부터!
								
								System.out.println("등록이 완료되었습니다.");
								System.out.println("엔터(Enter)를 누르시면 이전 메뉴로 돌아갑니다.");
								Scanner scanner = new Scanner(System.in);
							    scanner.nextLine();
							    editFlag = false;
							    editBannedWordFlag = false;
							    
								
								
								
								
							}
							
							//입력한 번호와 금지어 목록의 번호가 일치하면
							//if (editNum == )
							
							//그 목록 -> 새로 바꾸기
							
							
							
						}
						
					
					
					
				}   else if (answer.equals("N")) {
					System.out.println("등록을 취소합니다.");
					System.out.println("엔터(Enter)를 누르시면 이전 메뉴로 돌아갑니다.");
					Scanner scanner = new Scanner(System.in);
				    scanner.nextLine();
				    editFlag = false;
				    editBannedWordFlag = false;
				} 
				
				//BannedWord bannedWord = new BannedWord(lastSeq, input);
				//Data.bannedWordList.add(bannedWord);
				
				
				
				
				
			}
			
			
			//확인
			System.out.printf("\"%s\"\n", editNum);
			System.out.println("수정할 금지어가 맞습니까?(y/n): ");
			String answer = sc.nextLine().toUpperCase();
			
			
			}
			
		}
		
		
	}
}
