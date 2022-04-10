package com.test.java.collection; //04.08

import java.util.TreeMap;

public class Ex71_TreeMap {

	
	public static void main(String[] args) {
	
		//key가 순서대로 정렬되어있는 HashMap
		//내부구조는 Tree
		
		
		//Tree + Map
		//- 이진트리 구조의 Map
		//- 자동 정렬 + 범위 검색(추출) 용이
		
		TreeMap<String, String> map = new TreeMap<String, String>();
		
		map.put("white", "하양");
		map.put("black", "검정");
		map.put("yellow", "노랑");
		map.put("red", "빨강");
		map.put("blue", "파랑");
		
		System.out.println(map.size()); //5
		
		System.out.println(map); //ABC순으로 정렬되어있음
		
		System.out.println(map.firstKey());		//black
		System.out.println(map.lastKey());		//yellow
		
		
		System.out.println(map.firstEntry());	//black=검정		//MyHashMap > Item과 같은 친구
		System.out.println(map.lastEntry());	//yellow=노랑

		System.out.println(map.headMap("m"));		//{black=검정, blue=파랑}
		System.out.println(map.tailMap("m"));		//{red=빨강, white=하양, yellow=노랑}
		System.out.println(map.subMap("r", "w"));	//{red=빨강}  // (white 미포함)

		/*
		 	
		 	
		//TODO list,set,map 정리 (2022. 4. 8. 오전 11:33:47)
			
			복습하기***
			*** 길이 가변
			
			일단 처음 선택은 (1,5,7)임 -잘 모를떄 [8시간] > 상황에 따라 (2,3,4 / 6 / 8) 쓰면 돼 [2시간]
			=> 비중 나눠서 공부혀
			
			List
			1. ArrayList > 배열이 필요할때, 삽입/삭제(x)
			2. LinkedList > ArrayList 대체재 + 삽입/삭제(O)
			3. Stack > 스택 구조
			4. Queue > 큐 구조
			
			Set
			5. HashSet > 중복값 배제 집합이 필요할때
			6. TreeSet > 그러면서도 자동 정렬이 필요할때
			
			Map
			7. HashMap > 엔트리형식(key/value)의 배열이 필요할 때
			8. TreeMap > 그러면서도 자동 정렬이 필요할때
		
			=> 얘만 우선적으로 공부
		
		*/
		
	}//main
	
}//Ex71














