package com.test.java.question.multifor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {
		//Q01.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행: ");
		int line = Integer.parseInt(reader.readLine());
		
		for (int i=0; i<line; i++) { 
				
				for (int j=0; j<i; j++) { 
					System.out.print(" ");
				}
				for (int j=line; j>i; j--) {
					System.out.print("*");
				} 
				System.out.println();
		} 
		
	}
 
}