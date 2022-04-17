package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q05 {

	public static void main(String[] args) throws Exception {
		//Q05. 난수를 담고있는 배열을 생성한 뒤 아래와 같이 출력하시오.
		//조건 
		//-난수를 20개 발생한 후 배열에 넣는다.
		//-난수는 1~20사이
		//-배열을 탐색하여 범위에 만족하는 숫자만 출력한다.
		
	
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("최대범위 : ");
		int max = Integer.parseInt(reader.readLine());
		
		System.out.print("최소범위 : ");
		int min = Integer.parseInt(reader.readLine());
		
		
		if (max > min) { //유효성 검사
			int[] arr = new int[20];
			String result = "";
			
			//난수 생성(1~20)
			for (int i=0; i<arr.length; i++) {
				
				arr[i] = (int)(Math.random() * 20) + 1; 
				//마지막 수는 그대로
				if (i == arr.length-1) {
					result += arr[i];
				} else //나머지 수는 ', '과 함께 저장
				result += arr[i] + ", ";
				
				
			}
			
			System.out.printf("원본 : %s\n", result);
			
			System.out.print("결과 : ");
			for (int i=0; i<arr.length; i++) {
				
				if (min <= arr[i] && arr[i] <= max) {
					
					System.out.printf("%d, ", arr[i]);
				}
				
				
			}
			
			System.out.println("\b\b");
		
		} else //유효성 검사
		System.out.println("최대 범위는 최소 범위보다 커야 합니다.");
	}
}
