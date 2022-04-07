package com.test.java.question.io; //04.04과제

import java.io.File;

public class Q09_sort {

	public static void main(String[] args) {
		//Q09. 폴더 내의 모든 파일들을 찾아 크기를 비교하고, 크기가 큰 순으로 정렬하시오.
		//조건
		//-자식 폴더내의 파일도 모두 검색하시오.
		//-부모 자식 폴더에 상관없이 파일을 한번에 비교하시오.
		
		
		
		File dir = new File("C:\\class\\파일_디렉토리_문제\\크기 정렬");
		
			if (dir.exists()) {
			
			File[] list = dir.listFiles(); //목록 가져오기
			
			for (File d : list) {
				
				if (d.isDirectory()) {
					
					System.out.printf("[%s]\n", d.getName()); //폴더만 출력
				}
			}
			
			for (File f : list) {
				
				if (f.isFile()) {
					
					System.out.printf("%s\n", f.getName()); //그 다음 파일 출력
				}
				
			}
		
		}
		
		
	}
}
