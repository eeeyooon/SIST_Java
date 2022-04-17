package com.test.java.question.multifor; //얘 먼저 풀고 4번 풀자

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {

	public static void main(String[] args) throws Exception {
		//Q03. 별찍기 (행: 5 -> 피라미드) 
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행: ");
		
		int line = Integer.parseInt(reader.readLine());
		
		for(int i=0;i<line;i++){ 
			for(int j=(line-1)-i;j>0;j--){ 
				System.out.print(" "); 
			} 
			for(int j=0;j<2*i+1;j++){ 
				System.out.print("*"); 
			} 
			System.out.println(); 
			
		}
				
	}
}
