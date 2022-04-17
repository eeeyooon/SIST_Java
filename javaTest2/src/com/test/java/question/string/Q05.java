package com.test.java.question.string; //(완료)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {

	public static void main(String[] args) throws Exception {
		//Q05. 특정 단어가 문장 내에 몇회 있었는지 수를 세시오.
		//조건
		//-대상 문자열 : String content = "안녕~ 길동아~잘가~길동아~";
		//-검색 문자열 : String word = "길동";
		//출력 : '길동'을 총 2회 발견했습니다.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("대상 문자열: ");
		String content = reader.readLine();
		System.out.print("검색 문자열: ");
		String word = reader.readLine();
		String search = ".";

		int sum = 0;
		content = content.replace(word, search);
		for (int i=0; i<content.length(); i++) { //전체문장을 살필 동안
			if(content.substring(i, i+1).equals(search)) { // '.' 카운팅
				sum++; //'.'있으면 sum 값 증가
			}
		
			
		}
		System.out.printf("\'%s\'을 총 %d회 발견했습니다.\n", word, sum);

		
	}
}
