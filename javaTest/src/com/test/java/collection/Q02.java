package com.test.java.collection; //04.01 과제 (완료)

import java.util.Stack;

public class Q02 {

	public static void main(String[] args) {
		
		//Q02. MyStack
		
		
		Stack<String> stack2 = new Stack<String>(); //test용
		MyStack stack = new MyStack();
		
		
		//push test
		stack2.push("빨강");
		stack2.push("노랑");
		stack2.push("파랑");
		stack2.push("주황");
		stack2.push("검정");
		
		
		//push
		
		stack.push("빨강");
		stack.push("노랑");
		stack.push("파랑");
		stack.push("주황");
		stack.push("검정");
		
		
		
		//pop test
		System.out.println(stack2.pop());	//검정
		System.out.println(stack2.pop());	//주황
		System.out.println(stack2.pop());	//파랑
		//다섯번 이상 pop을 하면 EmptyStackException
		
		System.out.println();
		
		//pop = > x
		System.out.println(stack.pop());	//검정
		System.out.println(stack.pop());	//주황
		System.out.println(stack.pop());	//파랑
		
		
		System.out.println(stack);
		System.out.println();
		
		//size test
		System.out.println(stack2.size());	//2

		System.out.println(); 
		
		//size
		System.out.println(stack.size()); //2
		
		
		System.out.println();
		
		
		//peek test
		System.out.println(stack2.peek());	//노랑
		System.out.println(stack2.peek());	//노랑
		System.out.println(stack2.size());	//2
		
		//데이터가 없을때 peek하면 error -> EmptyStackException
		
		System.out.println();
		
		//peek
		System.out.println(stack.peek());	//노랑
		System.out.println(stack.peek());	//노랑
		System.out.println(stack.size());	//2
										
		
		
		System.out.println();
		
		//clear test
		//stack2.clear();
		//System.out.println(stack2.size());	//0
		
		System.out.println();
		
		//clear
		//stack.clear();
		//System.out.println(stack.size()); //0
		
		
		System.out.println();
		
		//trimToSize test
		stack2.trimToSize();
		
		//trimTosize
		stack.trimToSize();
		
		System.out.println(stack);
		
		
	}//main
	
}//MyStack
