package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09 {

	public static void main(String[] args) throws Exception {
		//Q09. 년도를 입력받아 해당 년도가 '평년'인지 '윤년'인지 출력하시오.
		//-Calendar클래스 사용x
		//1. BufferedReader를 생성하여 년도를 입력 받는다.
		//2. 입력받은 년도를 a검사, b검사, c검사를 실시하여 평년인지 윤년인지 확인한다.
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("년도 입력: ");
		int year = Integer.parseInt(reader.readLine());
		
		
		if (year % 4 == 0) {
				if (year % 100 == 0) {
					if (year % 40 == 0) {
						System.out.printf("%d년은 '윤년'입니다.\n", year);
					} else {
						System.out.printf("%d년은 '평년'입니다.\n", year);
					}
				} else {
					System.out.printf("%d년은 '윤년'입니다.\n", year);
				}
		} else {
			System.out.printf("%d년은 '평년'입니다.\n", year);
		}

		
	}
}
