package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {
		//Q01. 사용자의 이름과 인사할 횟수를 입력 받아 출력하시오.
		//1. BufferedReader를 통해 이름과 인사할 횟수를 받은뒤 
		//2. for문을 작성하여 횟수만큼 반복.
		//3. 입력받은 이름과 함께 출력.
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이름: ");
		String name = reader.readLine();
		System.out.print("횟수: ");
		int num = Integer.parseInt(reader.readLine());
		
		
		for (int i=0; i<num; i++) {
			
			System.out.printf("%s님 안녕하세요~\n", name);
			
		}
		
	
	
	}
}
