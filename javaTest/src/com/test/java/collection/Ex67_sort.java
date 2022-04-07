package com.test.java.collection; //04.06

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class Ex67_sort {

	public static void main(String[] args) {
		
		
//		//compareTo(문자코드-문자코드) 값을 돌려주는 것
//		System.out.println("A".compareTo("A"));	//0
//		System.out.println("A".compareTo("B"));	//-1
//		System.out.println("A".compareTo("C"));	//-2
//		System.out.println("C".compareTo("A"));	//2
//		System.out.println("C".compareTo("B"));	//1
		
		
		//m1();
		m2();
		
	}//main

	private static void m2() {
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		nums.add(1);
		nums.add(5);
		nums.add(2);
		nums.add(4);
		nums.add(3);
		
		System.out.println(nums);
		
		Collections.sort(nums);
		
		System.out.println(nums);
		
		Collections.sort(nums, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		
		});
		
		System.out.println(nums);

		
		//얘는 배열을 따로 넣어줄 필요 없음. 매개변수로 Comparator넣어줌 
		nums.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
			
				return 0;
			}
			
			
			
		});
		
	}

	private static void m1() {

		String[] names = { "홍길동", "아무개", "하하하", "호호호", "테스트" };
		
		Arrays.sort(names); //얘는 기본값이 오름차순
		
		System.out.println(Arrays.toString(names));
		
		
		//역정렬
		
		Arrays.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
			
				return o2.compareTo(o1); //문자열 비교 -> 내림차순 so flack tns
			}
			
		});
		
		
		Calendar[] dates = new Calendar[5]; 
		//참조타입의 배열은 객체가 만들어진게 아니라 객체를 담을 수 있는 방이 만들어진것
		
		for (int i=0; i<dates.length; i++) {
			dates[i] = Calendar.getInstance();
		}
		
		dates[0].add(Calendar.DATE, 7);
		dates[1].add(Calendar.DATE, 2);
		dates[2].add(Calendar.DATE, 5);
		dates[3].add(Calendar.DATE, 1);
		dates[4].add(Calendar.DATE, 4);
		
		//이건 dump하지마 -> 알아보지못함.
		
		for (int i=0; i<dates.length; i++) {
			System.out.printf("%tF\n", dates[i]);
		}
		System.out.println();
		
		Arrays.sort(dates, new Comparator<Calendar>() {

			@Override
			public int compare(Calendar o1, Calendar o2) {
			
				//얘넨 tick을 빼면돼(둘다 long타입이라 int로 반환 x)
				//return o2.getTimeInMillis() - o1.getTimeInMillis();
				return o2.compareTo(o1);	//그냥 compareTo쓰면돼 
				
			}
			
			
		});
		
		
	}//m1
}
