package com.test.java.question.multifor; //3.17(과제)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

	public static void main(String[] args) throws Exception {
		
		//Q04. 행의 개수를 입력 받고 영문자 찍기. (피라미드 모양)
		//행: 5		
		//1회전: 공백 4출력   2회전: 공백 3				    
		//1회전: 97 = 'a'	   2회전: 97, 98 'ab' 출력     ...
		//1회전: 97 = 'a'   2회전 : 98, 97 'ba' 출력
		//'a' = 97
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행: ");
		
		int line = Integer.parseInt(reader.readLine());
		
		
		
		for (int i=0; i<line; i++) {		
			
			for (int j=line-1; j>i; j--) {  
					System.out.print(" ");
			}
			for (int j=97; j<i+98; j++) {	
				System.out.print((char)j);
			}
			for (int j=97+i; j>96; j--) {	
				System.out.print((char)j);
			}
			System.out.println();
		
		}
		

		

		
//피라미드 별찍기		
//		for(int i=0;i<line;i++){ 
//			for(int j=(line-1)-i;j>0;j--){ 
//				System.out.print(" "); 
//			} 
//			for(int j=0;j<2*i+1;j++){ 
//				System.out.print("*"); 
//			} 
//			System.out.println(); 
//			
//		}
		
		
		
		
		
	}
}
