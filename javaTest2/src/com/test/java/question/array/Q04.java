package com.test.java.question.array;

public class Q04 {

	public static void main(String[] args) {
		//Q04. 1~20사이의 난수를 담고 있는 배열을 생성하고 최대값과 최소값을 출력하시오.
		//-조건 : 난수를 20개 발생한 후 배열에 넣는다. (난수는 1~20 사이)
		//Math.random() 그리고 최대값과 최소값
		
		
		
		int[] arr = new int[20];
		String result = "";
		
		
		for (int i=0; i<arr.length; i++) {
			//난수 20개 생성(1~20)
			arr[i] = (int)(Math.random() * 20) + 1; 
			
			//마지막 수는 그대로 
			if ( i == arr.length-1) {
				result += arr[i];
			} else	//그 외는 뒤에 ', '와 함께 저장
			result += arr[i] + ", ";	
		}
		
		System.out.printf("원본 : %s\n", result);
		
		//내림차순으로 정렬
		for (int i=0; i<arr.length-1; i++) {  
			
			for (int j=0; j<arr.length-i-1; j++) { 
				
				if (arr[j] < arr[j+1] ) {	//내림차순
					
					int temp = arr[j];	//swap
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
				}
					
			}
		}
		//최대값 : 맨 앞의 수, 최소값 : 맨 뒤의 수
		System.out.printf("최대값 : %d\n", arr[0]);
		System.out.printf("최소값 : %d\n", arr[arr.length-1]);
		
		
		
	}//main
	

}


