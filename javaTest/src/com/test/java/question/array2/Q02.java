package com.test.java.question.array2;

public class Q02 {

	public static void main(String[] args) {
		//Q02.
		
		int[][] nums = new int[5][5];
		
		//데이터 입력
		int n = 1; 
		
		for (int i=4; i>=0; i--) { 
			for (int j=4; j>=0; j--) { 
				nums[i][j] = n;
				n++; 
			}
		}
		
		//데이터 출력 > 
		
		for (int i=0; i<5; i++) { 
			for (int j=0; j<5; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
		
	}
}
