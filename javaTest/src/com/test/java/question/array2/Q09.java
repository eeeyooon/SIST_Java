package com.test.java.question.array2;

public class Q09 {

	public static void main(String[] args) {
		//Q09. 달팽이
		
		int[][] nums = new int[5][5];
		
		//데이터 입력
		
		
		int d;//달팽이의 차수 
        int k=0;//달팽이 안쪽으로 들어갈 수록 감소되는 행,열 만큼 깎아줄 변수
        int n =1;//달팽이 배열에 넣을 숫자

        //달팽에 차수에 따라 몇번 반복할지 : (1회전 : 5) > (2회전 : 3) > (3회전 : 1) 
        for(d=5; d>0;d-=2){
        	int i,j;//행 열
            
        	
        	for(j=0;j<d;j++){ 

                nums[k][k+j]=n;

                n++;
                
                //1회전 : (0,0) (0,1) (0,2) (0,3) (0,4)
            }

            for(i=1;i<d;i++){ 

                nums[k+i][5-k-1]=n;

                n++;
                
                //1회전 : (1,4) (2,4) (3,4) (4,4)

            }

            for(j=1;j<d;j++){ //

                nums[k+i-1][5-k-j-1]=n;
                
                n++;
                
                //1회전 : (4,4) (4,3) (4,2) (4,1) (4,0)

            }

            for(j=1;j<d-1;j++){

                nums[5-k-j-1][k]=n;

                n++;
                
                //1회전 : (3,0) (2,0) (1,0)

            }   

            k++;

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
