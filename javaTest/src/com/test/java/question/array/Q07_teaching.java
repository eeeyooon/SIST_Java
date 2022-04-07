package com.test.java.question.array; //03.21

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q07_teaching {

	public static void main(String[] args) throws Exception {
		
		//Q07. 배열에 요소를 삽입하시오.
		//-배열 길이 : 10
		//-마지막 요소는 우측으로 옮겨질 공간이 없으면 삭제된다.
		//원본은 수동으로 넣고, 사용자에게 받아야할 값은 '삽입위치: ', '값: '
		// point = 덮어쓰기가 아니라 끼어들기
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("삽입 위치: ");
		int index = Integer.parseInt(reader.readLine());
		System.out.print("값: ");
		int value = Integer.parseInt(reader.readLine());
		
		
		int[]nums = {5, 6, 1, 3, 2, 0, 0, 0, 0, 0};
		//int[]nums = {5, 6, 1, 3, 2, 8, 7, 4, 10, 9};
		
		//Right Shift = 일괄적으로 모든 애들이 우측으로 이동.
		// > for 감소
		for (int i=nums.length-2; i>=index; i--) {
			nums[i+1] = nums[i]; //이동
			
		}
	
		System.out.println(Arrays.toString(nums));
		
		nums[index] = value;
		
		System.out.println(Arrays.toString(nums));
	}
	
}





