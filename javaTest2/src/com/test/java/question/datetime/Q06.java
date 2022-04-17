package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q06 {

	public static void main(String[] args) throws Exception {
		
		//Q06
		//1. BufferedReader 생성 + throws Exception
		//2. 라벨 띄우기 (음식을 받기 위한 시각 / 시: / 분: )
		//3. 입력 받은 시간으로 '음식을 받기 원하는 시각' set
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("음식을 받기 원하는 시각\n시: ");
		int hour = Integer.parseInt(reader.readLine());
		
		System.out.print("분: ");
		int minute = Integer.parseInt(reader.readLine());
		
		Calendar time = Calendar.getInstance();
		time.set(Calendar.HOUR_OF_DAY, hour);
		time.set(Calendar.MINUTE, minute);
		
	
		time.add(Calendar.MINUTE, -10);		
		System.out.printf("짜장면: %d시 %d분\n", time.get(Calendar.HOUR_OF_DAY) , time.get(Calendar.MINUTE));
		
		
		time.set(Calendar.HOUR_OF_DAY, hour);
		time.set(Calendar.MINUTE, minute);
		time.add(Calendar.MINUTE, -18);		
		System.out.printf("치킨: %d시 %d분\n", time.get(Calendar.HOUR_OF_DAY) , time.get(Calendar.MINUTE));

		time.set(Calendar.HOUR_OF_DAY, hour);
		time.set(Calendar.MINUTE, minute);
		time.add(Calendar.MINUTE, -25);		
		System.out.printf("치킨: %d시 %d분\n", time.get(Calendar.HOUR_OF_DAY) , time.get(Calendar.MINUTE));
		

		
	} //main
	
		
//11시 이후 주문은 어떻게 할것?
	
	
}
