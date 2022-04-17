package com.test.java.question.io; //04.04과제

import java.io.File;

public class Q08_dirRemove_teaching {

//	private static int dcount = 0;
//	private static int fcount = 0;
//	private static int lcount = 0;
//	
	public static void main(String[] args) {
		//Q08. 내용물이 있는 'delete' 폴더를 삭제하시오.
		//조건 
		//-재귀 메소드 사용
		//-삭제된 파일과 자식 폴더의 개수를 출력하시오.
		
		
		
		File dir = new File("C:\\class\\파일_디렉토리_문제\\폴더 삭제");
		
		deleteDir(dir);
		
		
		
		
//			
//			System.out.printf("총 파일 개수: %,d개\n", dcount);	//7 //처음 시작시 7개
//			System.out.printf("총 폴더 개수: %,d개\n", fcount);	//7 //처음 시작시 7개
			//System.out.printf("총 크기 : %,d\n", lcount);	//7 //처음 시작시 7개
			
			
		
	}
	
	private static void deleteDir(File dir) {
		
		//1.
		File[] list = dir.listFiles();
		
		//2.
		for (File f : list) {
			if(f.isFile())	{
				//fcount++;
				f.delete();	//폴더를 지우려면 그 안의 파일 먼저 지워야 함.
				
			}
		}
		
		//3.
		for (File d : list) {
			if (d.isDirectory()) {
				//dcount++;
				deleteDir(d);	//재귀메소드
			}
		}
		
		//여기까지 도착했다는 얘기는 dir이 빈 폴더가 됐다는 것!
		dir.delete();	
		
		
		
	} //main
}//Q08
