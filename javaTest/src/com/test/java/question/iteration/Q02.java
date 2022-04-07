package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws Exception {
		//Q02. 시작 숫자, 종료 숫자, 증감치를 입력받아 숫자를 순차적으로 출력하시오.
		
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("시작 숫자: ");
		int start = Integer.parseInt(reader.readLine());
		
		System.out.print("종료 숫자: ");
		int end = Integer.parseInt(reader.readLine());
		
		System.out.print("증감치: ");
		int variation = Integer.parseInt(reader.readLine());
		
		
		
		if (start < end) {
		
			for (int i=start; i<=end; i=i+variation) {
				System.out.println(i);
			}
		} else if (start > end) {
			
			for (int i=start; i>=end; i=i+variation) {
				System.out.println(i);
			}
		} else {
			System.out.println("시작 숫자와 종료 숫자가 같으면 출력할 수 없습니다.");
		}
		
		
		
	}
}




