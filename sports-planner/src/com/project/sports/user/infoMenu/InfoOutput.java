package com.project.sports.user.infoMenu;

import com.project.sports.output.Output;

public class InfoOutput {

	public static void infoMenu() { //1.팀 정보 상세보기 //2. 선수 검색
		
		System.out.println("1. 팀 정보 상세보기");
		System.out.println("2. 선수 검색");
		Output.back();
		Output.input();
	}
	
	
	public static void teamDetailMessage() {
		
		System.out.println("상세 정보를 보고싶은 팀의 번호를 입력해주세요. (0. 뒤로가기)");
		System.out.print("팀 번호 입력 : ");
		
		
	}
	
	
	public static void playerDetailMessage() {
		
		System.out.println("검색하고싶은 선수의 이름을 입력해주세요.(0.뒤로가기)");
		System.out.print("입력 : ");
		
	}
	
	
	public static void teamList() {
		
		System.out.println("┌───────────────┐");
		System.out.println("│ 1. LG 트윈스	│");
		System.out.println("│ 2. 두산 베어스	│");
		System.out.println("│ 3. 롯데 자이언츠	│");
		System.out.println("│ 4. SSG 랜더스	│");
		System.out.println("│ 5. KIA 타이거즈	│");
		System.out.println("│ 6. 키움 히어로즈	│");
		System.out.println("│ 7. NC 다이노스	│");
		System.out.println("│ 8. KT 위즈  	│");
		System.out.println("│ 9. 삼성 라이온즈	│");
		System.out.println("│ 10. 한화 이글스	│");
		System.out.println("└───────────────┘");
		System.out.println();
		
	}
		
		
	
}
