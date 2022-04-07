package com.test.java.question.array2;

public class Q08 {

	public static void main(String[] args) {
		//Q08.
		//9회전.
		//turn : 바깥쪽 반복문의 반복변수 (회전수)
		//i : 안쪽 반복문의 반복변수 (행위치)
		//j : 배열의 열 위치를 지정해주는 변수
		//성공 -> 다시 확인해보기
		
		//1회전 : (0,0)
		//2회전 : (0,1)(1,0)
		//3회전 : (0,2)(1,1)(2,0)
		//4회전 : (0,3)(1,2)(2,1),(3,0)
		//5회전 : (0,4)(1,3)(2,2)(3,1)(4,0)
		//6회전 : (1,4)(2,3)(3,2)(4,1)
		//7회전 : (2,4)(3,3)(4,2)
		//8회전 : (3,4)(4,3)
		//9회전 : (4,4)
		
		
		int[][] nums = new int[5][5];
		
		int turn; //회전수

		int n = 1; //1씩 증가되는 숫자가 저장되는 변수

		for(turn=0;turn<=8;turn++){ //대각선(9회전) 0~8
			for(int i=0;i<=4;i++){ //행(5회전) 0~4

				int j = turn - i; //열 

				if(j>=0 && j<=4){ //0보다 크거나 같고 4보다 작거나 같은 경우

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
