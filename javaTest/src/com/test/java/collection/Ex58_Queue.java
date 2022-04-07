package com.test.java.collection; //03.31

import java.util.LinkedList;
import java.util.Queue;

public class Ex58_Queue {
	
	public static void main(String[] args) {
		
		//Ex58_Queue.java
		
		//Queue
		//- 선입선출
		//클래스는 회색, 인터페이스는 보라색. -> Queue는 인터페이스 -> 인터페이스는 객체 생성 x
												//객체 못만드니까 알맹이 빌려옴.
		Queue<String> queue = new LinkedList(); //알맹이는 LinkedList지만 사용법은 Queue
		
		
		//1. 요소 추가하기 //다른 언어는 enque()
		//- boolean add(T value)
		queue.add("빨강");
		queue.add("파랑");
		queue.add("노랑");
		
		
		//2. 요소 개수
		//- int size()
		System.out.println(queue.size()); 	//3
		
		
		//3. 요소 읽기(==꺼내기)
		System.out.println(queue.poll());	//당기기(꺼내기) //다른 언어는 deque()	//빨강
		System.out.println(queue.size());	//2
		
		System.out.println(queue.poll());	//파랑
		System.out.println(queue.size());	//1
		
		System.out.println(queue.poll());	//노랑
		System.out.println(queue.size());	//0
		
		System.out.println(queue.poll());	//null
		System.out.println(queue.size());	//0
		
		
		//4. 비었는지?
		System.out.println(queue.size() == 0);	//true
		System.out.println(queue.isEmpty());	//true
		
		
		//5. 요소 확인
		queue.add("주황"); //확인 위해 하나 추가
		System.out.println(queue.peek());	//주황 (just읽기만)
		System.out.println(queue.size());	//1
		
		
		//6.
		queue.clear();
		System.out.println(queue.size());
		
		
	}//main

}//Ex58










