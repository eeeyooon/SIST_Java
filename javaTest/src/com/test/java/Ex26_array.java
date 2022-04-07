package com.test.java; //03.18

import java.util.Arrays;

public class Ex26_array {

	public static void main(String[] args) {
		
		//Ex26_array.java
		
		//정렬, sort
		//1. 오름차순 정렬
		//2. 내림차순 정렬
		
		
		//배열 = 순서가 있는 집합
		
		
		//정렬하는 방법
		//1. 직접 구현
		// - 수많은 정렬 알고리즘 > 10여가지
		// - 버블 정렬
		
		//2. 구현된 기능 활용(JDk) >> 메소드 활용
		
		
		//m1();
		//m2();
		//m3();
		m4();
		
		
		
	}//main
	
	private static void m4() {
		
		int[] nums = {5, 3, 1, 4, 2};
		
		String[]name = {"유재석", "정형돈", "박나래", "하하", "박명수"};
		
		//오름차순
		//내림차순 ? > 메소드는 나중에 배울거니까 for문 더 연습해봐
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums); //개꿀?
		System.out.println(Arrays.toString(nums));
		
		System.out.println(Arrays.toString(name));
		Arrays.sort(name);
		System.out.println(Arrays.toString(name));
		
		
		//문제풀때나 공부할땐 for문으로 연습해~~ 수업땐 어쩔수없음.
		
	}

	private static void m3() {
		
		String[]name = {"유재석", "정형돈", "박나래", "하하", "박명수"};
		
		
		System.out.println(Arrays.toString(name)); //정렬 전
		
		for (int i=0; i<name.length-1; i++) {
			
			for (int j=0; j<name.length-1-i; j++) {
				
				
				//** 뭐와 뭘 비교?
				if (name[j].compareTo(name[j+1]) > 0 ) {
					
					String temp = name[j];
					name[j] = name[j+1];
					name[j+1] = temp;
					
				}
				
			}
			
		}
		
		System.out.println(Arrays.toString(name)); //정렬 후
		
	}

	private static void m2() {
		
		//정렬
		//1. 숫자 > 우위 비교 가능
		//2. 문자(열) > 문자코드값 비교를 통해 우위비교 가능.
		//3. 날짜 > 과거와 미래를 비교해서 우위비교함. > tick으로 정렬
		
		
		String[]name = {"유재석", "정형돈", "박나래", "하하", "박명수"};
		
//		String name1; 
//		String name2; //이거나 name[0], name[1] 이거나 같은 얘기임.
		
		//모든 참조형은 산출(비교)연산자의 피연산자가 될 수 없다.
		//주소값끼리는 연산을 할 수가 없음.
//		if (name[0] > name [1]) {
//			
//			
//		}
		
//		System.out.println(name[0].charAt(0)); //유 > 유재석 세글자를 글자마다 방에 넣어놓은 것.
//		System.out.println(name[0].charAt(1)); //재
//		System.out.println(name[0].charAt(2)); //석 
//		
//		
//		System.out.println((int)name[0].charAt(0)); //
//		System.out.println((int)name[0].charAt(1)); //
//		System.out.println((int)name[0].charAt(2)); //
		
		
		String name1 = "유재석";
		String name2 = "김형돈";
		
		String result = "";
		
		
		//**** 문자열의 우위비교는 문자열 내의 문자들의 문자코드값으로 비교한다. **
		
		//밑에는 굳이 외울 필요x 기억해봤자 쓸모 x
		
		for (int i=0; i<3; i++) { //이름 3글자
			
			char c1 = name1.charAt(i);
			char c2 = name2.charAt(i);
			
			if (c1 > c2) {
				result = name1;
				break; //for 탈출 > 다음 글자는 비교할 필요가 없어서
			} else if (c1 < c2) {
				result = name2;
				break;
			} 
			
		}
		
		System.out.println(result); //김형돈
		
		
		name1 = "나나나";
		name2 = "가가가";
		
		//>> 이미 만들어진 메소드 근데 반환값은 int 위의 코드 말고 이거 써 이 메소드 ^^
		//name1 > name2 : 양수 반환 (숫자가 뭔지 알필요x 그냥 양수인지 음수인지가 중요)
		//name1 < name2 : 음수 반환
		//name1 = name2 : 0 반환
		System.out.println(name1.compareTo(name2));
		
	}



	private static void m1() {
		
		int[] nums = {5, 3, 1, 4, 2};
		
		//오름차순 정렬 > {1, 2, 3, 4, 5} 재배치
		
		//버블 정렬 -> 가장 쉽지만, 가장 느림.  (여러 상황에 따라 속도가 다름. 정렬 알고리즘들은..)
		//  0  1  2  3
		//  0  1  2
		//  0  1
		//  0
		
		//i(0) > j(0 1 2 3)
		//i(1) > j(0 1 2)
		//i(2) > j(0 1)
		//i(3) > j(0)
		
//		3시반~4시 수업 버블정렬 다시 듣자 4시수업부터
		System.out.println(Arrays.toString(nums)); //정렬 전
		
		for (int i=0; i<nums.length-1; i++) {  // N Cycle
			
			for (int j=0; j<nums.length-i-1; j++) { //N Step
				
//				if (nums[j] > nums[j+1] ) {	//오름차순
				if (nums[j] < nums[j+1] ) {	//내림차순
					
					int temp = nums[j];	//swap
					nums[j] = nums[j+1];
					nums[j+1] = temp;
					
				}
					
			}
		}
		
		System.out.println(Arrays.toString(nums)); //정렬 후
	}
	
}









