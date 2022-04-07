package com.test.java.collection; //04.06

import java.util.Arrays;
import java.util.Comparator;

public class Ex66_sort {

	public static void main(String[] args) {
		
		//배열 or 컬렉션(ArrayList)만 해당됨.
		//- 오름차순 정렬, 내림차순 정렬
		//1. 직접 구현 > 정렬 알고리즘으로 구현
		//2. JDK에서 제공하는 기능
		
		//제네릭이 Integer니까 Integer로 수정
		Integer [] nums = { 1, 5, 2, 4, 3};
		
		System.out.println(Arrays.toString(nums)); //정렬 전 dump 출력
		
		//오름차순
		
//		//1차원 배열 요구
//		Arrays.sort(nums);
//		System.out.println(Arrays.toString(nums));	//정렬 후 dump 출력
//		//[1, 2, 3, 4, 5]
		
		//******
		//내림차순 > 지원안함 > 직접 구현(반 조립) 큰틀은 구현되어있고 그 안에서 세부적인 조작 필요
		// > Comparator(인터페이스)
		
		//인터페이스를 매개변수로 요구 ? > 인터페이스를 구현한 객체를 달라는 듯.
		
		Arrays.sort(nums, new MyComparator());	//객체 그대로 넣으면 돼
		// 정렬을 할때 뭐로 기준으로 할지 객체한테 그대로 맡김. 그럼 그 객체 안에서 어떤식으로 정렬할지 규칙을 정해야 해
		
		//Arrays.sort(null, Comparator); -> <T> => 클래스에서도 꺽새 넣어줘야해
		
		
		System.out.println(Arrays.toString(nums));
		
		
		//b. 객체를 만들어보자
		// ????? > mc1의 가치는? 이 메소드를 사용할일이 있어? >> 없음!!!
		// >> 이런경우가 대표적으로 클래스를 만드는게 안좋은 상황. > 익명객체로 전환하는게 나음.
		
		MyComparator mc1 = new MyComparator();
		System.out.println(mc1.compare(10, 20));	//10 >> 쓸일 없음
		
		
		//익명 객체로 전환하는 방법
		//2시 수업 이어서
		
		//Comparator<Integer> c = new Comparator<Integer>() {
		//};
		
		
		
		Arrays.sort(nums, new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {

				return o1-o2; //오름차순
			}
			
		});
		
		System.out.println(Arrays.toString(nums));
		
		
	}//main
	
}//Ex66


class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) { //if문과 같다..?
		//<Integer>니까 (제네릭도 Integer니까) 매개변수도 Integer
		
		//이렇게 메소드가 조작되어있음. (compare)
		//o1 vs o2
		//오름차순
		//1. o1이 더 크면 > 양수 반환
		//2. o2가 더 크면 > 음수 반환
		//3. 같으면 > 0 반환
		
		//내림차순
		//1. o1이 더 크면 > 음수 반환
		//2. o2가 더 크면 > 양수 반환
		//3. 같으면 > 0 반환
		
		
//		if (o1 > o2) {
//			return 1;			 //양수반환
//		} else if (o1 < o2) {
//			return -1; 			 //음수반환
//		} else {	//둘이 같을때
//			return 0;			 //0반환	
//		}
		
		//위의 if문을 간단하게
		
		//return o1-o2; //결과물이 같음
		//앞에 거가 더 크면 큰게 뒤로 가 >> 오름차순
		
		return o2-o1; //이렇게하면 내림차순(정렬기준도 반대로 됨.)
		
	}

// 내림차순 안 if문
//	if (nums[j] < nums[j+1] ) {	//내림차순
//		
//		int temp = nums[j];	//swap
//		nums[j] = nums[j+1];
//		nums[j+1] = temp;
	
	
	
}





















