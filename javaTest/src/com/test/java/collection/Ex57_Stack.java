package com.test.java.collection; //03.31

import java.util.Stack;

public class Ex57_Stack {

	public static void main(String[] args) {
		
		//Ex57_Stack.java
		
		/*
		 	
		 	자료구조(컬렉션)
		 	- 데이터를 저장하는 공간의 구조
		 	- ex) 배열 > 선형 구조
		 	- 물리적인 특징
		 	- 추상적인 특징 
		 	
		  	ADT
		  	- Abstract Data Type, 추상적 자료형 
		  	- Stack, Queue (->얘네도 배열이야. 사용법이 좀 다른)
		  	- 물리적인 특성을 가지는 것이 아니라 사용법이 특성을 가진다.
		  
		 	
		 	Stack
		 	- 후입선출
		 	- LIFO, Last Input First Output
		 	- 저장소에 나중에 들어간 요소가 먼저 나온다.
		 	ex) 메모리 구조(Stack)
		 	ex) 되돌리기(Ctrl + Z), 다시하기(Ctrl + Y)
		 	
		 	
		 	Queue
		 	- 선입선출
		 	- FIFO, First Input First Output
		 	- 저장소에 먼저 들어간 요소가 먼저 나온다.
		 	ex) 줄서기 
		 	
		 	
		 */
		
		//m1();
		m2();
		
		
		
	}//main
	
	
	
	private static void m2() {
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("빨강");
		stack.push("파랑");
		stack.push("노랑");
		
		//5. 요소 확인하기(읽기 + 삭제x + 안꺼냄)
		System.out.println(stack.peek()); //꺼내지않고 just look 
		System.out.println(stack.peek()); //삭제하지않아도 읽을 수 있는겨
		
		
	}


	private static void m1() {
		
		Stack<String> stack = new Stack<String>();
		
		//후입선출
		
		//1. 요소 추가하기
		//- T push(T value) -> Push Down이라는 표현을 잘 씀.
		stack.push("빨강");
		stack.push("파랑");
		stack.push("노랑");
		
		//2. 요소 개수 확인
		//- int size()
		System.out.println(stack.size());	//3
		
		//3. 요소 읽기(꺼내는 동시에 삭제가 되어야 함!)
		//- T pop() -> push & pop이 이거였군... => 보통 Pop Up이라고 표현함.
		
		//stack.pop(); //무조건 마지막 방이 꺼내지니까 
		
		System.out.println(stack.pop());	//노랑 꺼내기
		System.out.println(stack.size());	//2
		
		System.out.println(stack.pop());	//파랑 꺼내기
		System.out.println(stack.size());	//1
		
		System.out.println(stack.pop());	//빨강 꺼내기
		System.out.println(stack.size());	//0
		
		
		//4. 스택이 비어있는지?
		System.out.println(stack.size() == 0);	//true
		System.out.println(stack.isEmpty());	//true
		
		if (!stack.isEmpty()) { //스택이 비어있지 않으면 팝업해라!
			System.out.println(stack.pop());
			System.out.println(stack.size());
		}
	}
	
}//Ex57




























