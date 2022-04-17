package com.test.java.question.array; //03.18 과제

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws Exception {
		//Q02. 학생의 이름을 N개 입력받아 아래와 같이 출력하시오.
		//-조건: 이름을 오름차순으로 정렬하시오.
		//1. 학생수와 학생명(N개)을 받는다. -> 학생수가 곧 배열의 길이.
		//2. 학생수의 길이인 배열에 학생명을 모두 넣는다.
		//3. 입력한 학생의 수와 함께 학생명을 오름차순으로 정렬하여 출력한다.
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("학생수: ");
		int length = Integer.parseInt(reader.readLine());
		String student[] = new String[length];
		
		for (int i=0; i<student.length; i++) {
			System.out.print("학생명: ");
			student[i] = reader.readLine();
		}
		
		System.out.printf("입력하신 학생은 총 %d명입니다.\n", length);
		
		for (int i=0; i<student.length; i++) {
			
			for (int j = 0; j<length-i-1; j++) {
				
				//양수 > student[j]가 student[j+1]보다 큼.
				if (student[j].compareTo(student[j+1]) > 0) {
					String temp = student[j];
					student[j] = student[j+1];
					student[j+1] = temp;
				}
			}
			
			System.out.printf("%d. %s\n", i+1, student[i] );
		}
		
		
		
	}
}









