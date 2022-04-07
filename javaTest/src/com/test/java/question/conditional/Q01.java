package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Q01 {

	public static void main(String[] args) throws Exception {
		
	//Q01. 숫자 2개를 입력받아 큰 수와 작은 수를 출력하시오.
	//-조건 : 두 숫자가 얼마의 차이를 보이는지 출력하시오.
	//1. BufferedReadr 생성 + throws Exception
	//2. 라벨 작성 (첫번째 숫자:, 두번째 숫자: )
	//3. num1 > num2 -> 큰 수 : num1 작은 수 : num2 두 숫자의 차이 num1-num2
	//4. num2 > num1 -> 큰 수 : num2 작은 수 : num1 두 숫자의 차이 num2-num1
	//5. num1 == num2 -> 두 숫자는 동일합니다.

	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("첫번째 숫자: ");
	int num1 = Integer.parseInt(reader.readLine());
	
	System.out.print("두번째 숫자: ");
	int num2 = Integer.parseInt(reader.readLine());
	
	
	if (num1 > num2) {
		System.out.printf("큰 수는 %d이고, 작은수는 %d입니다. 두 숫자는 %d(가)이 차이납니다.\n", num1, num2, num1-num2);
	} else if (num2 > num1) {
		System.out.printf("큰 수는 %d이고, 작은수는 %d입니다. 두 숫자는 %d(가)이 차이납니다.\n", num2, num1, num2 - num1);
	} else {
		System.out.println("두 숫자는 동일합니다.");
	}
	
	
	}
}








