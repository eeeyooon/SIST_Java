package com.test.java.question.multifor; //3.17(과제)

public class Q10 {

	public static void main(String[] args) {
		//Q10. 아래와 같이 출력하시오.
		// 1 ~ 10 : 55
		// 11 ~ 20 : 155
		// ...
		// 91 ~ 100 : 955
		// 
		
		
		
		
		for (int i = 0; i<100; i+=10) {
			int sum = 0;
			for (int j=1+i; j<=i+10; j++) {
				sum += j;
			}
			System.out.printf("%2d ~ %3d : %3d\n", i+1, i+10, sum);
		}
		
		
		
	}
}
