package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q04_codereview {

	public static void main(String[] args) throws Exception {
		
		//Q04
		//1.BufferedReader 생성 + throws Exception 작성
		//2. 라벨 띄우기 (남자/여자 이름, 만난날(년), 만난날(월), 만난날(일)
		//3. 입력받은 날짜를 만난 날짜로 set. (month는 -1)
		//4. 만난 날짜를 기준으로 각종 기념일 출력
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("남자 이름: ");
		String boyName = reader.readLine();
		
		System.out.print("여자 이름: ");
		String girlName = reader.readLine();
		
		System.out.print("만난 날(년): ");
		int year = Integer.parseInt(reader.readLine());
		
		System.out.print("만난 날(월): ");
		int month = Integer.parseInt(reader.readLine())-1;
		
		System.out.print("만난 날(일): ");
		int date = Integer.parseInt(reader.readLine());
		
		System.out.printf("\'%s\'과(와) \'%s\'의 기념일\n", boyName, girlName);
		
		anniversary(year, month, date, 100);
		anniversary(year, month, date, 200);
		anniversary(year, month, date, 300);
		anniversary(year, month, date, 500);
		anniversary(year, month, date, 1000);
		
	} //main
	
	public static void anniversary(int year, int month, int date, int day) {
	
		Calendar dateTime = Calendar.getInstance();
		dateTime.set(year, month, date);
		
		dateTime.add(Calendar.DATE, day);
		System.out.printf("%d일: %tF\n", day, dateTime);
		
		
	}
	
	
}
