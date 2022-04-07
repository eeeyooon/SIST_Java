package com.test.java.question.multifor; //3.17(과제)

public class Q05 {

	public static void main(String[] args) {
		//Q05. 구구단 출력하기 (2~9단인데 2~5단 위에 6~9단 아래 출력)
		

		
		for ( int dan=1; dan<=9; dan++) {
			
			for (int i=2; i<6; i++) {
				System.out.printf("%d x %d = %2d\t", dan, i, dan * i);
				continue;
			}
			
		}
	
		//이중 for문 2개
		
		
		
		
		
		

	} //main
} //class



//가로	
//int i, j;
//
//for (j=2 ; j<10 ; j++) {
//
//    for ( i=1 ; i< 10 ; i++) 
//
//        System.out.printf("%d x %d = %3d\t", j , i ,j*i);    
//
//    
//
//    System.out.println();            
//
//}	


//}//for