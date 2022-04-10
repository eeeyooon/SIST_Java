package com.test.java.collection; //04.08

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class Ex70_TreeSet {

	public static void main(String[] args) {
		
		//Ex70_TreeSet.java
		
		/*
		
			Set
			- 순서가 없음
			- 중복값을 가지지 않음.
			
			
			HashSet
			
			TreeSet
			- 이진 트리 구조(B트리)
			- 자동 정렬 + 부분 집합 뽑아오기 가능
		
		
		
		*/
		
		
		m1(); //HashSet과 TreeSet의 비교 및 TreeSet의 특징
		
	}//main

	private static void m1() {

		HashSet<Integer> set1 = new HashSet<Integer>();
		TreeSet<Integer> set2 =  new TreeSet<Integer>();
		
		set1.add(10);
		set1.add(30);
		set1.add(40);
		set1.add(50);
		set1.add(20);
		
		set2.add(10);
		set2.add(30);
		set2.add(40);
		set2.add(50);
		set2.add(20);
		
		
		//탐색
		Iterator<Integer> iter1 = set1.iterator();
		
		while (iter1.hasNext()) {
			System.out.println(iter1.next());
		}
		
		System.out.println();
		
		Iterator<Integer> iter2 = set2.iterator();
		
		while (iter2.hasNext()) {
			System.out.println(iter2.next()); //가지런히 정렬돼서 나옴.
		}
		
		System.out.println();
		
		System.out.println(set1);
		System.out.println(set2);
		
		
		//set은 set인데 정렬돼서 출력하는게 필요하면 TreeSet을 써라!
		
		TreeSet<Integer> set3 = new TreeSet<Integer>();
		Random rnd = new Random();
		
		
//		for (int i=0; i<10; i++) {
//			
//			//set3.add(rnd.nextInt(10)); //0~9 >  중복값 x니까 최소 1개 최대 10개만 들어감. 
//			set3.add(rnd.nextInt(100));	 //운이 안좋으면 최소 1개~ (10바퀴 모두 중복값이면) ->고정으로 10개 못함 이건
//		}
//		
//		System.out.println(set3);
//		System.out.println(set3.size());
		
		//고정으로 10개가 꼭 나오게 하고싶으면?
		//for (; set3.size() < 10;) { -> 이렇게 쓸 수 있지만 for문이 지저분해져서 while문을 보통 씀
		
		while (set3.size() < 20) {
			set3.add(rnd.nextInt(100));	 
			//set3.add(rnd.nextInt(5));	 
			//이건 무한루프빠짐. (0~4까지인데 20를 못채워 중복값x니까) -> 사이즈보다 난수의 범위 가 커야해
			
		}
		
		System.out.println();
		System.out.println(set3);
		System.out.println(set3.size());
		System.out.println();
		
		//TreeSet 고유 메소드
		
		System.out.println(set3.first()); //set3의 첫번째 요소 반환
		System.out.println(set3.last());  //set3의 가장 마지막 요소를 반환해줌.
		
		//자바의 모든 인덱스 범위 ***
		//- 시작위치(포함)~끝위치(미포함) => 절대규칙

		System.out.println();
		System.out.println(set3.headSet(30)); //30보다 작은 요소만 출력  	 (30은 x) 		//미포함
		System.out.println(set3.tailSet(70)); //70 이상 요소들만 가져옴.		 (70은 O) 		//포함
		System.out.println(set3.subSet(30, 70)); //30이상 70보다 작은 요소만. (30 O, 70 X)	//앞 포함 ~ 뒤 미포함
	
		
		//TreeSet의 특징
		//자동정렬 + 부분집합 뽑아오기 기능 
		
	}
	
} //Ex70

























