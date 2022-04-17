package com.test.java.question.array; //03.18 과제

public class Q03 {

	public static void main(String[] args) {
		//Q03. int배열을 매개변수로 받아 내용을 문자열로 반환하는 dump 메소드를 구현하시오.
		//조건: String dump(int[] list)
		//dump메소드 만들기
		
		
		int [] list = new int[4];
		
		list[0] = 10;
		list[1] = 20;
		list[2] = 30;
		list[3] = 40;
		
		String result = dump(list);
		System.out.printf("nums = %s\n", result);
		
		
		
	} //main
	
	
		public static String dump(int[] list) {
		
		String result = "[";
		
		
		for (int i=0; i<list.length; i++) {
			result += list[i] + ", ";
			
		}
		
		
		result += "\b\b]";
		
		return result;
		
		
		}
		
}
