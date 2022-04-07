package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {

	public static void main(String[] args) throws Exception {
		//Q07. 숫자 5개를 입력받아 짝수와 훌수의 개수를 출력하시오.
		//조건 : 1~10 사이의 정수만 입력받으시오.
		//1. BufferedReader 생성하여 숫자 5개 입력 받기
		//2. 숫자 중 짝수의 개수, 홀수의 개수 세기
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 입력 1: ");
		int num1 = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 입력 2: ");
		int num2 = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 입력 3: ");
		int num3 = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 입력 4: ");
		int num4 = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 입력 5: ");
		int num5 = Integer.parseInt(reader.readLine());
		
		
		int even = 0;
		int odd = 0;
		
		if (num1 >= 0 && num1 <= 10) {
			if (num1 % 2 == 0 ) {
				even += 1;
			} else {
				odd += 1;
			}
		}
		
		if (num2 >= 0 && num2 <= 10) {
			if (num2 % 2 == 0 ) {
				even += 1;
			} else {
				odd += 1;
			}
		}
		
		
		if (num3 >= 0 && num3 <= 10) {
			if (num3 % 2 == 0 ) {
				even += 1;
			} else {
				odd += 1;
			}
		}
		
		
		if (num4 >= 0 && num4 <= 10) {
			if (num4 % 2 == 0 ) {
				even += 1;
			} else {
				odd += 1;
			}
		}
		
		if (num5 >= 0 && num5 <= 10) {
			if (num5 % 2 == 0 ) {
				even += 1;
			} else {
				odd += 1;
			}
		}
		
		System.out.printf("짝수는 %d개 홀수는 %d개 입력했습니다.\n", even, odd);
		if (odd > even) {
			System.out.printf("홀수가 짝수보다 %d개 더 많습니다.", odd - even );
		} else {
			System.out.printf("짝수가 홀수보다 %d개 더 많습니다.", even - odd );
			
		}
		
		
	}
}


//더 생각해볼 것 : 짝수가 홀수보다 많을 땐 -n개가 나온다. 어떻게 할지?
//if - else로 홀수가 더 많을 경우, 짝수가 더 많을 경우.


