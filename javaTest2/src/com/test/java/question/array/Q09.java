package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q09 {

	public static void main(String[] args) throws Exception {
		//Q09. 배열의 요소를 순차적으로 2개씩 더한 결과를 배열로 생성한 뒤 출력하시오.
		//-원본 배열 길이 : 사용자 입력
		//-원본 배열 요소 : 난수(1~9)
		//-결과 배열 길이: 사용자 입력 / 2
		// 사용자입력값이 홀수일땐 2로 나눴을 때 결과가 반올림 되어야 함.
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("배열 길이: ");
		
		
		int [] arr = new int[Integer.parseInt(reader.readLine())];
		int [] even = new int[arr.length/2];
		int [] odd = new int[(arr.length/2) + 1];
		
		
		//원본 생성 + 출력
		for (int i=0; i<arr.length; i++) {
			
			arr[i] = (int)(Math.random() * 9) + 1; 
				
		}
		
		System.out.println("원본: " + dump(arr));
		
		
		if (arr.length % 2 ==0) { //짝수일때
			
			for (int i=0; i<arr.length/2; i++) {
				
				even[i] = arr[i * 2] + arr[i * 2 +1];
				}
			
			System.out.println("결과: " + dump(even));
			
		} else  { //홀수일때
				
				for (int i=0; i<arr.length/2+1; i++) {
					
					if (i == arr.length/2) {
				
						odd[arr.length/2] = arr[arr.length-1]; //홀수의 마지막 숫자는 원본의 마지막 숫자 그대로
						
					} else
					odd[i] = arr[i * 2] + arr[i * 2 +1]; 
				}
				System.out.println("결과: " + dump(odd));
		}
		
	
	} //main
		
	public static String dump(int[] arr) {
	
		String result = "[";
		
		for (int i=0; i<arr.length; i++) {
			result += arr[i] + ", ";
			
		}
		
		result += "\b\b]";
		
		return result;
	
	}	
		
}	
		

