package com.test.java.question.array2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {

	public static void main(String[] args) throws Exception {
		//Q07.
		//-String[][]score = new String[10][3];
		//미완
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("국어 점수 : ");
		String kor = reader.readLine();
		System.out.print("영어 점수 : ");
		String eng = reader.readLine();
		System.out.print("수학 점수 : ");
		String math = reader.readLine();
		
		String[][]score = new String[10][3];
		
		//데이터 입력
		
		String n = "";		
		for (int i=0; i<5; i++) { 
			for (int j=0; j<5; j++) { 
				score[j][i] = n;
				
			}
		}
				
		//데이터 출력 > 
				
		for (int i=0; i<5; i++) { 
			for (int j=0; j<5; j++) {
				System.out.printf("%5d", score[i][j]);
			}
			System.out.println();
		}
		
//		System.out.println("■");
		
		
	}
}
