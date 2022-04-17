package com.test.java.question.multifor; //3.17 (과제)

public class Q07 {

	public static void main(String[] args) {
		//Q07. 1부터 100사이의 완전수를 구하시오.
		//- 완전수 : 자기 자신을 제외한 나머지 약수들의 합이 자신과 동일한 수
		//- 약수 : 어떤 수나 식을 나누어 나머지가 없이 떨어지는 수
		//- 6 = [1,2,3] / 28 = [1, 2, 4, 7, 14]
		
		
		
		 for(int i=1; i<=100; i++) {
	         String result = "[";   
			 int sum = 0; //약수의 합
	            for(int j=1; j<i; j++) { //약수를 구하기 위한 조건식
	                if(i%j == 0)	{
	                    sum += j;	//약수를 sum에 모두 더하기
	                	result += (j*2 == i) ? j : j + ", ";
	                }
	            } result += "]";
	            if(sum == i) {
	                System.out.printf("%d = %s\n", sum, result); 
	             }
		 }
	}
}		


		
            
     
	

