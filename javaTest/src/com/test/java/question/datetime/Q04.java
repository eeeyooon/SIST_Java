package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q04 {

	public static void main(String[] args) throws Exception {
		
		//Q04
		//1.BufferedReader 생성 + throws Exception 작성
		//2. 라벨 띄우기 (남자/여자 이름, 만난날(년), 만난날(월), 만난날(일)
		//3. 입력받은 날짜를 만난 날짜로 set. (month는 -1)
		//4. 만난 날짜를 기준으로 각종 기념일 출력
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("남자 이름: ");
		String boyName = reader.readLine();
		
		System.out.println("여자 이름: ");
		String girlName = reader.readLine();
		
		System.out.println("만난 날(년): ");
		int year = Integer.parseInt(reader.readLine());
		
		System.out.println("만난 날(월): ");
		int month = Integer.parseInt(reader.readLine())-1;
		
		System.out.println("만난 날(일): ");
		int date = Integer.parseInt(reader.readLine());
		
		System.out.printf("\'%s\'과(와) \'%s\'의 기념일\n", boyName, girlName);
		
		Calendar anniversary = Calendar.getInstance();
		
		anniversary.set(year, month, date);
		anniversary.add(Calendar.DATE, 100); 
		System.out.printf("100일: %tF\n", anniversary); 
		
		anniversary.set(year, month, date);
		anniversary.add(Calendar.DATE, 200); 
		System.out.printf("200일: %tF\n", anniversary); 
		
		anniversary.set(year, month, date);
		anniversary.add(Calendar.DATE, 300); 
		System.out.printf("300일: %tF\n", anniversary); 
		
		anniversary.set(year, month, date);
		anniversary.add(Calendar.DATE, 500); 
		System.out.printf("500일: %tF\n", anniversary); 
		
		anniversary.set(year, month, date);
		anniversary.add(Calendar.DATE, 1000); 
		System.out.printf("1000일: %tF\n", anniversary); 
		
		
	}//main
	
	//중복되는 set + add는 메소드로 빼기

	
	
}
