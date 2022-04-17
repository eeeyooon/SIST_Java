package com.test.java.question.array; //03.18 과제

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {
		//Q01. 숫자를 5개 입력받아 배열에 담은 뒤 역순으로 출력하시오.
		//조건: int[] nums = new int[5];
		//1. BufferedReader를 생성하여 숫자를 입력받는다.
			//1.2 5번을 받아야 하니 for문 안에서 받는다.
		//2. 입력 받은 숫자들을 배열에 넣는다.
		//3. 그 배열 안에 숫자들을 역순으로 출력한다.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		int [] nums = new int[5]; 
		
		for (int i=0; i<nums.length; i++) {
			
			System.out.print("숫자: ");
			nums[i] = Integer.parseInt(reader.readLine());
			
		}
		
		for (int i=4; i>=0; i--) {
			System.out.printf("nums[%d] = %d\n", i, nums[i] );
		}
		
		

		
		
	}
}
