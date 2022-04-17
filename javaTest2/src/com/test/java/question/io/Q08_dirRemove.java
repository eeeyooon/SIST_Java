package com.test.java.question.io; //04.04과제

import java.io.File;

public class Q08_dirRemove {

	private static int dcount = 0;
	private static int fcount = 0;
	private static int lcount = 0;
	
	public static void main(String[] args) {
		//Q08. 내용물이 있는 'delete' 폴더를 삭제하시오.
		//조건 
		//-재귀 메소드 사용
		//-삭제된 파일과 자식 폴더의 개수를 출력하시오.
		
		
		
		String path = "C:\\class\\파일_디렉토리_문제\\폴더 삭제";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			 countFile(dir);
			
			System.out.printf("총 파일 개수: %,d개\n", dcount);	//7 //처음 시작시 7개
			System.out.printf("총 폴더 개수: %,d개\n", fcount);	//7 //처음 시작시 7개
			System.out.printf("총 크기 : %,d\n", lcount);	//7 //처음 시작시 7개
			
			
		}
	}
	
	//넘어온 폴더(dir)의 파일 개수 누적하는 역할. 
	private static void countFile(File dir) { //반복되는 애들 따로 메소드로 빼기
		
		//1. 목록 가져오기
		File[] list = dir.listFiles(); //dir은 매개변수로 넘어옴
		
		//2. 파일 개수 세기 + //2.3 크기 구하기(바이트)
		for (File subfile : list) {
			if (subfile.isFile()) {
				dcount++;
				
				lcount += subfile.length(); //크기 구하기 (2.3)
			}
		}
		
		
		//2.2 폴더 개수
		//3. 자식 폴더를 대상으로 1~2번 반복
		for (File subdir : list) {
			if (subdir.isDirectory()) {
				
				//fcount++; //폴더인 애들만 카운트 (2.2) > 이거하려면 2번 전체 주석처리해야해.
				
				//폴더인 애들 대상으로 (true일때) 1~3번 반복 그 안에서 또 반복 또 반복.
				
				countFile(subdir); //이번엔 자식 폴더를 대상으로 1~3번 반복. => 재귀 호출
				
				
				
			}
		}
		
		
		
		
	} //main
}//Q08
