package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {

	public static void main(String[] args) throws Exception {
		//Q08. 주차 요금을 계산하시오.
		//조건 - 무료주차: 30분 , - 초과 10분당: 2,000원
		//1. BufferedReader 생성, 들어온 시간과 나간 시간 입력 받음.
		//2. 들어온 시간과 나간 시간을 set 하고 나간 시간 - 들어온 시간 = 사용시간 했을 때 
		//3. 사용 시간이 40 이상이면 (사용시간 - 30) / 10 * 2000(원) = 주차 요금.
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("[들어온 시간]\n시: ");
		int inHour = Integer.parseInt(reader.readLine());
		
		System.out.print("분: ");
		int inMinute = Integer.parseInt(reader.readLine());
		
		System.out.print("[나간 시간]\n시: ");
		int outHour = Integer.parseInt(reader.readLine());
		
		System.out.print("분: ");
		int outMinute = Integer.parseInt(reader.readLine());
		
		
		
		int useTime = ((outHour - inHour) * 60 + (outMinute - inMinute));
		
		if (useTime >= 40) {
			System.out.printf("주차 요금은 %,d원입니다.\n", (useTime - 30) / 10 * 2000);
		} else {
			System.out.println("주차요금은 없습니다.");
		}
		
		
		//31 이상?
		
	} //main
}








