package com.test.java.question.datetime;

import java.util.Calendar;

public class Q02 {

	public static void main(String[] args) {
		
		
		Calendar birth = Calendar.getInstance();
				
		birth.add(Calendar.DATE, 100);
		System.out.printf("백일: %tF\n", birth);
		
		birth.add(Calendar.DATE, -100);
		birth.add(Calendar.YEAR, 1);
		System.out.printf("첫돌: %tF\n", birth);
		
		
	}//main
	
	
}
