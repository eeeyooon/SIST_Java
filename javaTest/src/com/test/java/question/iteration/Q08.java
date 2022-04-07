package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {

	public static void main(String[] args) throws Exception {
		//Q08. 서기 1년 1월 1일부터 오늘까지 며칠째인지 합을 구하시오.
		//- 조건 : Calendar 클래스 사용 금지
		//1년은 365일?
		
		
		int year = 2022;
		
		
		int month = 3;
		
		
		int date = 16;
		
		int totalYear = (year - 1) * 365 + (year / 4 ) - (year / 100) + (year / 400);
		int totalMonth = month(month)-1;
		int totalDay = totalYear + totalMonth + date;
		
		String day = day(totalDay); //요일
		System.out.printf("%d년 %02d월 %02d일은 %,d일째 되는 날이고 %s요일입니다.\n", year, month, date, totalDay, day);

		
		} //main
	
	public static String day(int totalDay) {

			if (totalDay % 7 == 1) {
				return "화";
			} else if (totalDay % 7 == 2) {
				return "수";
			} else if (totalDay % 7 == 3) {
				return "목";
			} else if (totalDay % 7 == 4) {
				return "금";
			} else if (totalDay % 7 == 5) {
				return "토";
			} else if (totalDay % 7 == 6) {
				return "일";
			} else {
				return "월";
			}
		
		
	}
	public static int month(int month) {
		int totalMonth = 0;
		
		switch (month) {
			case 1: 
			case 3: 
			case 5:
			case 7: 
			case 8: 
			case 10:
			case 12: 
				totalMonth += 31;
				break;
			case 2:
				totalMonth += 28;
				break;
			case 4: 
			case 6: 
			case 9: 
			case 11:
				totalMonth += 30;
				break;
		}
		return totalMonth;
	
	}
	
	
	
	
}//class




