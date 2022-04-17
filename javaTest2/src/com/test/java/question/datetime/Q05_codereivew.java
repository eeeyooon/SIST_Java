package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q05_codereivew {

	public static void main(String[] args) throws Exception {
		
		//Q05.
		//1. BufferedReader생성 + throws Exception 작성
		//2. 라벨 띄우기 (아빠와 딸의 생년월일)
		//3. 입력 받은 값으로 태어난지 며칠인지 계산
		//4. 아빠의 값에서 딸의 값 빼기 연산
		//dad() / girl() 따로
		//정확한 값을 위해 double형으로 계산 (int형으로 하면 10299일 나옴)
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("아빠 생일(년): ");
		int dadYear = Integer.parseInt(reader.readLine());
		
		System.out.print("아빠 생일(월): ");
		int dadMonth = Integer.parseInt(reader.readLine())-1;
		
		System.out.print("아빠 생일(일): ");
		int dadDate = Integer.parseInt(reader.readLine());
		
		System.out.print("딸 생일(년): ");
		int girlYear = Integer.parseInt(reader.readLine());
		
		System.out.print("딸 생일(월): ");
		int girlMonth = Integer.parseInt(reader.readLine())-1;
		
		System.out.print("딸 생일(일): ");
		int girlDate = Integer.parseInt(reader.readLine());
		
		Calendar dadTime = Calendar.getInstance();
		dadTime.set(dadYear, dadMonth, dadDate);
		
		Calendar girlTime = Calendar.getInstance();
		girlTime.set(girlYear, girlMonth, girlDate);
		
		long time = (girlTime.getTimeInMillis() - dadTime.getTimeInMillis()) / 1000 / 60 / 60 / 24;
		
		
		System.out.printf("아빠는 딸보다 총 %,d일을 더 살았습니다. \n", time);
		
		
	}//main
	
		
	
	//메소드로 안빼고 또 now-dad/now-girl말고 바로 dad-girl해도 됨.
	//수정할 것.
	
	
}
