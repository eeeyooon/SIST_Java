package com.test.java.question.io; //04.04과제 (완료)

import java.io.File;
import java.util.Scanner;

public class Q02_search {

	public static void main(String[] args) {
		
		//Q02. 지정한 폴더의 특정 파일(확장자)만을 출력하시오.
		//조건 : 확장자 대소문자 구분없이 검색 가능
		//입력 : 폴더 / 확장자
		//입력받은 path의 파일중에서 입력받은 확장자만 출력.
		//폴더 : C:\class\eclipse
		//확장자 : exe / xml
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("폴더: ");
		String path = scan.next();
		
		System.out.print("확장자: ");
		String extensionName = scan.next();
		
		System.out.println();

		File dir = new File(path);
		
		if (dir.exists()) {
			
		File[] list = dir.listFiles(); //목록 가져오기
			
			
		
			for (File f : list) {
				
				if (f.isFile()) {
					
					String fileName = f.getName(); //입력받은 path밑의 파일 목록을 fileName에 복사.
												   //fileName에서 입력받은 확장자와 같은 파일의 이름만 출력.
					
						if (fileName.endsWith(extensionName.toLowerCase()) == true) {
							System.out.println(fileName);
						}
					
				}
				
			}
		}
		
	}//main
}//Q02
