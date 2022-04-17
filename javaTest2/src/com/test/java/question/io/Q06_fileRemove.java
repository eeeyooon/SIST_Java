package com.test.java.question.io; //04.04과제(완료)

import java.io.File;

public class Q06_fileRemove {

	public static void main(String[] args) {
		//Q06. 파일의 크기가 0byte인 파일만 삭제하시오.
		
		
		
		File dir = new File("C:\\class\\파일_디렉토리_문제\\파일 제거");
		int count = 0; //삭제횟수
		if (dir.exists()) {
			
			File[] list = dir.listFiles(); //목록 가져오기
			
			for (File f : list) {
				
				if (f.isFile()) {
					
					if (f.length() == 0) {	//크기가 0인 파일은
						f.delete();			//삭제하기
						count++;			//삭제 횟수 카운트
					}
				}	

			}
			System.out.printf("총 %d개의 파일을 삭제했습니다.\n", count);
		
		}
		
		
		
		
		
	}//main
}//Q06


























