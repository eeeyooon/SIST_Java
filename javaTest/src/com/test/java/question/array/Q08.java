package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {

	public static void main(String[] args) throws Exception {
		//Q08. 배열의 요소를 삭제하시오.
		//-배열 길이 : 10
		//-마지막 요소는 0으로 채우시오.
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("삭제 위치: ");
		int index = Integer.parseInt(reader.readLine());
		
		
		
		//int[]arr = {5, 6, 1, 3, 2, 0, 0, 0, 0, 0};
		int[]arr = {5, 6, 1, 3, 2, 8, 7, 4, 10, 9};
		
		System.out.println("원본 : " + dump(arr)); 
		
		
		//삭제위치부터 숫자 한칸씩 앞으로 당기기
		for (int i = index; i<arr.length-1; i++) {
			
			arr[i] = arr[i+1];
		
			}
		//삭제시 항상 마지막 숫자는 0
		arr[arr.length-1] = 0;
		
		System.out.println("결과 : " + dump(arr)); 
		
		
		
		
		
	} //main
	//dump메소드
	public static String dump(int[] arr) {
		
		String result = "[";
		
		for (int i=0; i<arr.length; i++) {
			result += arr[i] + ", ";
			
		}
		
		result += "\b\b]";
		
		return result;
		
		
		
	}
}
