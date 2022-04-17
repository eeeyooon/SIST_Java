package com.test.java.question.string; //(완료)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

	public static void main(String[] args) throws Exception {
		//Q04. 파일명 10개를 입력받아 각 확장자별로 총 개수를 출력하시오.
		//조건
		//-확장자는 다음으로 제한한다. : mp3, jpg, java, hwp, doc
		//-(당연히) 확장자는 대소문자 구분없이
		//1. BufferedReader 생성 + 라벨 띄우기 ('파일명: ')
		//2. lastIndexOf로 '확장자'만 뽑아서 path에 넣기
			//2.1 대소문자 구분없이 해야하니까 path에 넣기전에 toLowerCase
		//3. for문으로 10번 반복하고, 그 안에서 switch문으로 확장자별 counting
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
				
		int mp = 0;
		int jpg = 0;
		int java = 0;
		int hwp =0;
		int doc = 0;
		
		for (int i=0; i<10; i++) {
			System.out.print("파일명: ");
			String file = reader.readLine();
			
			int index = file.lastIndexOf("."); 
			String path = file.toLowerCase().substring(index);
		
			switch (path) {
				case ".mp3":
					mp += 1;
					break;
				case ".jpg":
					jpg += 1;
					break;
				case ".java":
					java += 1;
					break;
				case ".hwp":
					hwp += 1;
					break;
				case ".doc":
					doc += 1;
					break;
			}
		}
		System.out.printf("mp3 : %d개\njpg : %d개\njava : %d개\nhwp : %d개\ndoc : %d개\n",
			               mp, jpg, java, hwp, doc);		
		
		
		
		
	}//main
	
}
