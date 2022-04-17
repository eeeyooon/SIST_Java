package com.project.sports.admin.bannedword;

import java.util.ArrayList;
import java.util.Scanner;
import com.project.sports.admin.AdminOutput;
import com.project.sports.input.BannedWord;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

public class BannedWordMenu {

	
	public static ArrayList<BannedWord> bannedWordList2 = new ArrayList<BannedWord>();
	
	public static void bannedWordMenu() {
		
		Scanner sc = new Scanner(System.in);
		boolean bannedWordFlag = true;
		
		while(bannedWordFlag) {
			
			//금지어 리스트 출력
			
			bannedWordList2 = new ArrayList<BannedWord>();
			
			System.out.println("번호 금지어");
			for (BannedWord b : Data.bannedWordList) {
				
				System.out.printf("%d %s\n", b.getSeq(), b.getBannedWord());
				//bannedWordList2.add(b);
				
			}
			
			System.out.println();
			System.out.println();
			
			//금지어 관리 메뉴 보여주기
			
			AdminOutput.bannedWordMenu();
			
			String input = sc.nextLine(); //금지어 관리 메뉴 번호 입력받기
			
			
			if (input.equals("1")) { //금지어 등록
				
				AddBannedWord.addBannedWord();
				
			} else if (input.equals("2")) { //금지어 수정
				
				EditBannedWord.editBannedWord();
				
			} else if (input.equals("3")) {
				
				
			} else if (input.equals("0")) {
				
				
				Output.back();
				bannedWordFlag = false;
				
			}
			
		}
		
	}
	
	
	
}
