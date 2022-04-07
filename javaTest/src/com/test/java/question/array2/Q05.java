package com.test.java.question.array2;

public class Q05 {

	public static void main(String[] args) {
		//Q05.
		// 행이 증가하면서 열의 시작값은 -1, 마지막값은 +1씩 변화.
		//가운데 2번째 행을 기준으로
		
		
		int[][] nums = new int[5][5];
		
		//데이터 입력

		int n = 1; //1~13까지 증가하는 변수

			for(int i=0;i<=4;i++){
				
				if(i<=2){

					for(int j=2-i;j<=2+i;j++){

					nums[i][j]=n;
					n++;

					}

				}else{

					for(int j=i-2;j<=6-i;j++){

					nums[i][j]=n;
					n++;

					}

				}

			}

		
		//데이터 출력 > 
		
		for (int i=0; i<5; i++) { //일단 (?) length 말고 상수..
			for (int j=0; j<5; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
		
		
		
	}
}
