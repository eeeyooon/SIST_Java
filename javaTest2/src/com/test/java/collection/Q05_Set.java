package com.test.java.collection;

public class Q05_Set {

	public static void main(String[] args) {
		
		
		MySet set = new MySet();
		
		//추가
		set.add("홍길동");
		set.add("아무개");
		set.add("하하하");
		
		System.out.println(set);
		
		
		//개수
		System.out.println(set.size());

		
		//삭제
		set.remove("아무개");

		//개수
		System.out.println(set.size());


		//초기화
		set.clear();
		System.out.println(set.size());
		
		
		/*
		//탐색 + 읽기
		while (set.hasNext()) {
		      System.out.println(set.next());
		}
		*/
		
		
		
	}//main
	
}//Q05


























