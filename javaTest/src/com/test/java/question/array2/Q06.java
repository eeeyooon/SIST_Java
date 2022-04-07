package com.test.java.question.array2;

public class Q06 {

	public static void main(String[] args) {
		//Q06.
		//마지막 행 : 열의 합.
		//마지막 행 에러 
		//26 아니고 36
		
		int[][] nums = new int[5][5];
		int n = 1;
		//데이터 입력
		for (int i=0; i<5; i++ ) {
            for (int j=0; j<4; j++) {
                nums[i][j] = n; 
                
                n++;        
                nums[i][4] += nums[i][j];
                nums[4][j] += nums[i][j];
                
                nums[4][4] += nums[i][j];
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


//맨 밑 가로줄 못구함
//
//		int n = 1; 
//		int count = 0;
//		for (int i=0; i<4; i++) { 
//			for (int j=0; j<5; j++) { 
//				if (j!=4) {
//					
//					nums[i][j] = n;
//					count += n;
//					n++; 
//				
//				} else { //마지막 열은 행의 합
//					nums[i][j] = count;
//				}
//			} count = 0;
//		} 