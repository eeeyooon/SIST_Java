package com.test.java.question.array;

public class Q06 {

	public static void main(String[] args) {
		//Q06. 중복되지 않는 임의의 숫자 6개를 만드시오. (로또)
		//조건
		//-숫자의 범위 : 1~45
		//-오름차순 정렬
		
		long begin = System.nanoTime(); //tick
		
		int[] lotto = new int[6];
		for (int i=0; i<lotto.length; i++) {
			
			//1~45 사이의 임의의 수 생성
			lotto[i] = (int)(Math.random() * 45) + 1; 
			
			
			for(int j=0; j<i; j++) {
				
				if (lotto[i] == lotto[j]) {
					i--;
					
				}
			} 
		}
		
		
		//오름차순으로 정렬 후
		sortArr(lotto);
		//문자열로 출력
		System.out.println(dump(lotto));
		
		
		
		long end = System.nanoTime(); //tick
		System.out.println(end - begin); //소요시간
		
	} //main
	
	public static String dump(int[] list) { //dump메소드
		
		String result = "[";
		
		for (int i=0; i<list.length; i++) {
			result += list[i] + ", ";
			
		}
		
		result += "\b\b]";
		
		return result;
		
		
	}
	
	
	public static int[] sortArr(int[] arr) { //오름차순 정렬 메소드
	
		for (int i=0; i<arr.length-1; i++) {  
			
			for (int j=0; j<arr.length-i-1; j++) { 
				
				if (arr[j] > arr[j+1] ) {	
					
					int temp = arr[j];	//swap
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				
				}
			
			}
		} return arr;
	}	
}
