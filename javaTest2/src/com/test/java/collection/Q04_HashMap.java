package com.test.java.collection; //04.01과제 
import java.util.HashMap;

public class Q04_HashMap {

	public static void main(String[] args) {
		
	
		MyHashMap map = new MyHashMap();
		HashMap map2 = new HashMap();
		
		
		//추가
		map.put("국어", "합격");
		map.put("영어", "불합격");
		map.put("수학", "보류");
		
		System.out.println(map);

		
		//읽기
		System.out.println(map.get("국어"));
		System.out.println(map.get("영어"));
		System.out.println(map.get("수학"));
		
		
		System.out.println();
		
		//개수									>> 수정or삭제 이후부터 개수 틀리게 나옴. (코드 수정해야함)
		System.out.println(map.size());

		
		System.out.println();
		
	
		
		//수정
		map.put("영어", "합격");
		System.out.println(map.get("영어"));
		
		
		System.out.println();
		
		System.out.println(map.size());
		
		System.out.println(map);
		
		
		//삭제
		map.remove("영어");
		
		System.out.println(map);	
		
		System.out.println(map.get("영어"));
		
		System.out.println(map.size());
		
		
		//검색(key)
		if (map.containKey("국어")) {
		      System.out.println("국어 점수 있음");
		} else {
		      System.out.println("국어 점수 없음");
		}

		
		//검색(value)
		if (map.containsValue("합격")) {
		      System.out.println("합격 과목 있음");
		} else {
		      System.out.println("합격 과목 없음");
		}

		//초기화
		map.clear();
		System.out.println(map.size());
		
		
		
	}//main
	
}//Q04



























