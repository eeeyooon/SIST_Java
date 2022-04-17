package com.test.java.question.multifor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행: ");
		int line = Integer.parseInt(reader.readLine());
		
		int i, j;
		
		for (i=0; i<line; i++) {
			for(j=0; j<(line-1)-i; j++) {
				System.out.print(" ");
			}
			for(j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
