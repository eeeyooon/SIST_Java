package com.test.java.question.multifor; //3.17(과제)

public class Q12 {

	public static void main(String[] args) {
		//Q12
		//- 마지막 숫자가 100이 넘기 전까지 출력하시오. //피보나치수열
		// 1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 + 34 + 55 + 89 = 232
		
		
		int num1 = 1; //첫번째 수열
		int num2 = 1; //두번째 수열
		int num3 = 0; //세번째 수열, 첫번재와 두번째의 합
		int sum = 2; //피보나치 수열의 합을 저장.
		int j = 11;
		
		

       
        for(int i=3; i<=j; i++) {
        	num3 = num1 + num2;
        	sum += num3;
        	num1 = num2;
        	num2 = num3;
        }
    
        
        	
        System.out.printf(" = %d\n", sum);
	
	} 
        
		
		
}

