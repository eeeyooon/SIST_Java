package com.test.java.question.io; //04.04과제

import java.io.File;

public class Q10_group_teaching {

	public static void main(String[] args) {
		//Q10. 아래의 조건에 따라 파일을 폴더별로 분류/이동하시오.
		//1. 직원 이름별 폴더 생성
		//2. 년도별 폴더 생성
		//3. 각 파일을 (직원\\년도) 폴더로 옮김.
		//아무게_2014_17
		
		File dir = new File("C:\\class\\파일_디렉토리_문제\\직원");
		
		File[] list = dir.listFiles();
		
		for (File file : list) {
			if (file.isFile()) {
				
				String fileName = file.getName();
				
				//System.out.println(fileName);
		
				//parsing : 의미있는 부분들을 쪼개는 작업
				
				fileName = fileName.replace("__","_"); 
				//혹시 언더바 두개가 있는 방이 있을 수 있으니까 미리 하나로 통일
				
				String[] temp = fileName.split("_");
				//temp[0] : 직원명
				//temp[1] : 년도
				
				//File newDir = new File(dir.getAbsoluteFile() + "\\" + "아무개" + "\\" + "2014");
				File newDir = new File(dir.getAbsoluteFile() + "\\" + temp[0] + "\\" + temp[1]);
				
				
				newDir.mkdirs(); //아무게라는 폴더와 그 자식폴더로 2014년도 한번에 만듦. (첫번째 파일을 읽었을때)
				
				File moveFile = new File(newDir.getAbsoluteFile() + "\\" + file.getName());
				//(언더라인 고친것 원래 이름이 아니니 file에서 가져와야함)
				
				file.renameTo(moveFile);
				
				System.out.println("이동");
			
			}
			
			
		} 

		System.out.println("분류가 완료되었습니다.");
		
	}//main

	
	
}//Q10
