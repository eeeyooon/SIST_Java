package com.test.java.question.io; //04.04과제(완료)

import java.io.File;

public class Q04_serialNum {
	public static void main(String[] args) {
		
	
	//Q04. 음악 파일이 100개 있다. 파일명 앞에 일련 번호를 붙이시오.
	//조건 : '001'부터 3자리 형식으로 붙이시오.
	
		
	//(수정) 파일명 바꾸기 
		
		
	File music = new File("C:\\class\\파일_디렉토리_문제\\음악 파일\\Music");
	int count = 0;	//파일 개수 카운트
	
		if (music.exists()) {
			
			File[] list = music.listFiles(); //목록 가져오기
			
			for (File f : list) {
				
				if (f.isFile()) {
					count++;
					System.out.printf("[%03d]%s\n", count, f.getName()); //일련번호 + 파일명
				}
				
			}
		
		}
		
	}//main

}//Q04

