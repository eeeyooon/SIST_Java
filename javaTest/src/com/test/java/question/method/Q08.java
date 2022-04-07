package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {

	public static void main(String[] args) throws Exception {
		
		//Q08. 사과나무가 있다. 사과 나무 씨앗을 심을 날로부터 특정 시간이 흘렀을 때 사과 총 몇개가 열리는지 구하는 메소드를 선언하시오.
		//사과 나무를 처음 심었을 때 나무의 길이 : 0m
		//맑은 날 사과 나무의 성장 : 5cm
		//흐린 날 사과 나무의 성장 : 2cm
		//사과 나무는 길이가 1m 넘는 시점부터 사과가 열린다.
		//1m가 넘는 시점부터 10cm 자랄 때마다 사과가 1개씩 열린다.
		
		//설계
		//1. BufferedReader생성 + throws Exception + 라벨 작성. (맑은 날: , 흐린 날: )
		//2. 맑은 날의 수와 흐린 날의 수를 입력 받고, (sunny * 5) + (foggy * 2) = 총 나무의 길이를 알아낸다.
		//3. 총 나무의 길이가 100(cm)이상이면 '/ 10'을 하여 나오는 정수의 값이 사과의 개수이다.
		//4. 총 사과의 개수를 출력한다.
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("맑은 날: ");
		int sunny = Integer.parseInt(reader.readLine());
		
		System.out.println("흐린 날: ");
		int foggy = Integer.parseInt(reader.readLine());
		
		int apple = getApple(sunny, foggy);
		System.out.printf("사과가 총 %d개 열렸습니다.\n", apple);
		
		
		
	}//main
	
	public static int getApple(int sunny, int foggy) {
		
		int length = (sunny * 5) + (foggy * 2);
				
		int apple = length >= 100 ? (length-100)/10 : 0;

		return apple;
	}
	
	
	
}
