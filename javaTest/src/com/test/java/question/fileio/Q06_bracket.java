package com.test.java.question.fileio;	//04.05과제 XX 다시 풀어

import java.io.FileReader;
import java.util.Stack;

public class Q06_bracket {
	//Q06. 모든 괄호가 서로 짝이 맞는지 검사하시오.
	
	public static void main(String[] args) throws Exception {
		
		//FileReader reader = new FileReader("C:\\class\\파일_입출력_문제\\괄호.java");
		FileReader reader = new FileReader("C:\\class\\java\\javaTest\\src\\com\\test\\java\\Ex21_Switch.java");
		Stack stack = new Stack();
		
		
		try {
			int count = -1;
			
			while((count = reader.read()) != -1) {
				
				if ('(' == count || '{' == count) {
					stack.push(count + "");
				}
				
				if (')' == count || '}' == count) {
					stack.pop();	
				}
			
			}//while
				
			if(stack.size()==0) System.out.println("괄호가 일치합니다.");
			else System.out.println("괄호가 일치하지 않습니다.");
			
			} catch (Exception e) {
				System.out.println("괄호가 일치하지 않습니다.");
		}
		
		
		reader.close();
		
		
	}//main

}
