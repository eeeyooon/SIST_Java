package com.test.java.question.array; //03.21

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q08_teaching {

	public static void main(String[] args) throws Exception {
		//Q08. 배열의 요소를 삭제하시오.
		//-배열 길이 : 10
		//-마지막 요소는 0으로 채우시오.
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("삭제 위치: ");
		int index = Integer.parseInt(reader.readLine());
		
		//int[]nums = {5, 6, 1, 3, 2, 0, 0, 0, 0, 0};
		int[]nums = {5, 6, 1, 3, 2, 8, 7, 4, 10, 9};
		
		//Left Shift, 좌측 시프트 > for 증가
		for (int i=index; i<nums.length-1; i++) {
			
			nums[i] = nums[i+1];
			
		}
		nums[nums.length-1] = 0;
		
		System.out.println(Arrays.toString(nums));
		
	}
}
