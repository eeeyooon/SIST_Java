package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q03 {
	
	//Q03
	//1.BufferedReader 생성 + throws Exception 작성
	//2. '태어난 년도:' 라벨 띄우기
	//3. 현재년도 - birthYear(출생년도) + 1 = 현재 나이
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("태어난 년도: ");
		int birthYear = Integer.parseInt(reader.readLine());
		
		Calendar now = Calendar.getInstance();
		
		int nowYear = now.get(Calendar.YEAR);
		int age = nowYear - birthYear + 1;
		
		System.out.printf("나이: %d세\n", age );
		
		
		
	}//main
	
		
		
}
