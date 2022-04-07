package com.test.java.question.io; //04.04과제

import java.io.File;
import java.util.HashMap;

public class Q05_count {
	public static void main(String[] args) {
		//Q05. 이미지 파일이 있다. 확장자별로 파일이 몇개 있는지 세시오.
		//조건
		//-새로운 확장자 파일이 추가되도 동작이 가능하게 구현하시오.
		//-'mouse.bmp'추가를 하면.. 소스 수정없이도 *.bpm : 1개 출력이 되게 하시오.
		//gif : 5개 jpg : 16개 png : 9개
		// *** HashMap 사용 ***
		//1. 파일 목록을 가져오기
		//2. 키 : 확장자명 value : 확장자 파일 개수
		//3. 
		
		
		File image = new File("C:\\class\\파일_디렉토리_문제\\확장자별 카운트");
		
		HashMap<String, Integer> count = new HashMap<String, Integer>();
		

		
		//map.put("수학", 80);
		
		if (image.exists()) {
			
			File[] list = image.listFiles(); //목록 가져오기
			
			for (File f : list) {
						
				String imageName = f.getName();
				
				//확장자명만 뽑아서 확장자명 리스트 생성
				String extension = imageName.substring(imageName.length()-4, imageName.length());
				
				
				//HashMap 사용

				
				//다른 문제풀고나서 !
				

				
			}
			
		
		}
		
		
		
		
		
	}//main

	
	
	
}//Q05
