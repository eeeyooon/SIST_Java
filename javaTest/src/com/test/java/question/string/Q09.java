package com.test.java.question.string; //(완료)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09 {

	public static void main(String[] args) throws Exception {
		//Q09. 금지어를 마스킹 처리 하시오.
		// 금지어 : 바보, 멍청이
		// 마스킹한 횟수도 출력
		
		//1. BufferedeReader 생성 + 라벨 띄우기('입력: ')
		//2. 입력값은 String content에 저장
		//3. 금지어 '바보'와 '멍청이'는 String word에 저장
		//4. content에서 word는 "*"로 교체
		//5. 교체한 횟수와 함께 출력.
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("입력: ");
		String content = reader.readLine();
		
		String[] words = {"바보", "멍청이"}; //금지어
		
		int count = 0; //금지어 마스킹 횟수
		
		
		if(content.indexOf("바보") > -1) {
			content = content.replace("바보", "**");
			count += 1;
		}
		
		if(content.indexOf("멍청이") > -1) {
			content = content.replace("멍청이", "***");
			count += 1;
		}
		System.out.printf("%s\n금지어를 %d회 마스킹했습니다.\n", content, count );
		
		
	}
}
