package com.test.java.question.io; //04.04과제

import java.io.File;
import java.util.ArrayList;

public class Q09_sort_teaching {

	public static void main(String[] args) {
		//Q09. 폴더 내의 모든 파일들을 찾아 크기를 비교하고, 크기가 큰 순으로 정렬하시오.
		//조건
		//-자식 폴더내의 파일도 모두 검색하시오.
		//-부모 자식 폴더에 상관없이 파일을 한번에 비교하시오.
		
		
		
		File dir = new File("C:\\class\\파일_디렉토리_문제\\크기 정렬");
		ArrayList<File> flist = new ArrayList<File>();
		searchFile(dir, flist);
		
		//크기순 정렬 > 버블 정렬
		for (int i=0; i<flist.size() - 1; i++) {
			for (int j=0; j<flist.size() - i - 1; j++) {
				
				if (flist.get(j).length() < flist.get(j+1).length()) { //내림차순이니가 앞의 수가 작아야 바꿔치기
					
					
					//swap
					File temp = flist.get(j);
					flist.set(j, flist.get(j+1));
					flist.set(j+1, temp);
					
				}
			}
		}
		
		
		for (File f : flist) {
			System.out.println(f.getParent().replace("C:\\class\\파일_디렉토리_문제\\크기 정렬\\", "")
													+ ">" +  f.getName() + "::" +f.length());
		}
		

}

	private static void searchFile(File dir, ArrayList<File> flist) {
		
		File [] list = dir.listFiles();
		
		for (File f : list) {
			if(f.isFile()) {
				flist.add(f);
			}
		}
		
		for (File d : list) {
			if (d.isDirectory()) {
				searchFile(d, flist);
			}
		}
	}
		
		
	
}//Q09
