package com.test.java.question.io; //04.04과제

import java.io.File;

public class Q10_group {

	public static void main(String[] args) {
		//Q10. 아래의 조건에 따라 파일을 폴더별로 분류/이동하시오.
		//1. 직원 이름별 폴더 생성
		//2. 년도별 폴더 생성
		//3. 각 파일을 (직원\\년도) 폴더로 옮김.
		//아무게_2014_17
		
		String path = "C:\\class\\파일_디렉토리_문제\\직원";
		File file = new File(path);
		
		if(file.exists()) {			
			File[] list = file.listFiles();

			for(File f : list) {
				if(f.isFile()) {
					String[] temp = f.getName().split("_");
					String dirPath = file + "\\" + temp[0] + "\\" + temp[1];	 
					//temp[0]은 직원명, temp[1]은 년도
					
					//C:\\class\\파일_디렉토리_문제\\직원 + \\ + 아무게 + \\ +  2014
					
					File dir = new File(dirPath);	
					dir.mkdirs();					//직원명\\년도 폴더 생성
					
					String filePath = dirPath + "\\" + f.getName();
					File move = new File(filePath);
					f.renameTo(move);
				}
			}
			
			System.out.println("분류가 완료되었습니다.");
			
		} 

	}//main

	
	
}//Q10
