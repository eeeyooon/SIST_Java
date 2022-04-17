package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {

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
		
		
		
		//int[]arr = {5, 6, 1, 3, 2, 0, 0, 0, 0, 0};
		int[]arr = {5, 6, 1, 3, 2, 8, 7, 4, 10, 9};
		
		System.out.println("원본 : " + dump(arr)); 
		
	
		for (int i = arr.length-1; i>index; i--) {
			
			//뒤에서부터 숫자를 한칸씩 뒤로 밀려보냄
			arr[i] = arr[i-1];
		}
			arr[index] = value; //삽입 위치에 입력받은 값
		
		System.out.println("결과 : " + dump(arr)); 
		
		
	} //main
	//dump메소드
	public static String dump(int[] arr) {
		
		String result = "[";
		
		for (int i=0; i<arr.length; i++) {
			result += arr[i] + ",";
			
		}
		
		result += "\b]";
		
		return result;
		
	}
	
}





