package com.project.sports.admin.bannedword;

import java.util.ArrayList;
import java.util.Scanner;
import com.project.sports.admin.AdminOutput;
import com.project.sports.input.BannedWord;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

public class AdminBannedWord {
	public static ArrayList<BannedWord> bannedWordList = new ArrayList<BannedWord>();

	public static void bannedWord() {
		
		
		//금지어 목록 출력
		
		
		Scanner sc = new Scanner(System.in);
		boolean bannedWordFlag = true;

		while (bannedWordFlag) { // 금지어 관리를 눌렀을때
			
			
			
			//금지어 목록 출력
			
			System.out.println("번호 금지어");
			for (BannedWord b : Data.bannedWordList) {
				
				
				System.out.printf("%d %s\n", b.getSeq(), b.getBannedWord());
				bannedWordList.add(b); //다 넣기
				
				
			}
			
			System.out.println();
			System.out.println();
			
			// 금지어 관리 메뉴 보여주기
			
			AdminOutput.bannedWordMenu();
			
			String input = sc.nextLine(); // 금지어 관리 메뉴 번호 입력받기

			if (input.equals("1")) { // 1. 금지어 등록
				
				AddBannedWord.addBannedWord();

			} else if (input.equals("2")) { // 2. 금지어 수정

				
			} else if (input.equals("3")) { //3. 금지어 삭제
				
				
			} else if (input.equals("0")) {
				
				Output.backMsg();
				bannedWordFlag = false;

			} else { // 유효성검사

			}
		}
		
		
		
		
	}
}
