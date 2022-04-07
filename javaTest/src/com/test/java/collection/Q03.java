package com.test.java.collection; //04.01과제 (완료)

import java.util.LinkedList;
import java.util.Queue;

public class Q03 {

	public static void main(String[] args) {
		
		//Q03. MyQueue
		
		
		Queue<String> queue2 = new LinkedList(); //test용
		MyQueue queue = new MyQueue();
		
		
		//add test
		queue2.add("빨강");
		queue2.add("노랑");
		queue2.add("파랑");
		queue2.add("주황");
		queue2.add("검정");
		
		
		//add
		queue.add("빨강");
		queue.add("노랑");
		queue.add("파랑");
		queue.add("주황");
		queue.add("검정");
		
		
		
		//poll test
		System.out.println(queue2.poll());	//빨강
		System.out.println(queue2.poll());	//노랑
		System.out.println(queue2.poll());	//파랑
		
		System.out.println();
		
		//poll => x
		System.out.println(queue.poll());	//빨강
		System.out.println(queue.poll());	//노랑
		System.out.println(queue.poll());	//파랑
		
		System.out.println();
		
		//size test
		System.out.println(queue2.size()); //2
		
		//size
		System.out.println(queue.size());  //2
		
		System.out.println();
		
		//peek test
		System.out.println(queue2.peek());	//주황
		System.out.println(queue2.peek());	//주황
		System.out.println(queue2.size());	//2
		//데이터가 없으면 그냥 null값과 size는 0이 됨.
		
		System.out.println();
		
		//peek
		System.out.println(queue.peek());	//주황
		System.out.println(queue.peek());	//주황
		System.out.println(queue.size());	//2
		
		System.out.println();

		//trimToSize
		queue.trimToSize();
		
		//초기화 test
		queue2.clear();
		System.out.println(queue2.size()); //0
		
		System.out.println();
		
		//초기화
		queue.clear();
		System.out.println(queue.size());	//0
		
		
		
	}//main
}//MyQueue



































