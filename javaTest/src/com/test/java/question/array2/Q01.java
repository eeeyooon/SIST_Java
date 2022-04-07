package com.test.java.question.array2; 

public class Q01 {

	public static void main(String[] args) {
		//Q01. 12345 
		//     109876  ...
		
		
		int[][] nums = new int[5][5];
		
		//데이터 입력
		int n = 1; //(루프 변수를 대신할 n)
		
		for (int i=0; i<5; i++) { 
			if (i%2 == 0) { //0번째, 2번째, 4번째 행 > j 증가
				for (int j=0; j<5; j++) { 
					nums[i][j] = n;
					n++; //n도 1~25까지 들어감.
				}
			} else { //1번째 3번째 행  > j 감소 
				for (int j=4; j>=0; j--) {
					nums[i][j] = n;
					n++;
				}
			}
		}
		
		//데이터 출력 
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
		
		
		
		
	}
}
