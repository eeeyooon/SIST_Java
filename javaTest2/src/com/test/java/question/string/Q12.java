package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q12 {

	public static void main(String[] args) throws Exception {
		//Q12. 연산식을 입력받아 실제 연산을 하시오.
		//메소드x?
		//미완료 > 연산식을 공백없이 입력하면 출력도 공백없이 그대로 나옴. 출력문을 따로..
		
		//정규식 표현 split 안에서도 | -> or 역할
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("입력: ");
		String input = reader.readLine();
		
		System.out.println(input + " = " + calculator(input));
		
}//main
		
public static int calculator(String input) { 
	int index;
	index = input.indexOf('+'); //'+' 문자의 인덱스 위치 확인

	if (index != -1) { //'+' 문자가 있으면 -1이 아님. 		
		return calculator(input.substring(0, index)) + calculator(input.substring(index + 1));
		
	} 
	else { //'+' 문자가 없을 경우는 '-', '*', '/' 연산자 포함 여부를 확인
		index = input.indexOf('-');  //'-'위치 확인
		if (index != -1) { 
			return calculator(input.substring(0, index)) - calculator(input.substring(index + 1)); 
		} 
		else {
			index = input.indexOf('*');  //'*' 위치 확인
			if (index != -1) {
				return calculator(input.substring(0, index)) * calculator(input.substring(index + 1)); 
			} 
			else { 
				index = input.indexOf('/');  //'/' 위치확인
				if (index != -1) { 
					return calculator(input.substring(0, index)) / calculator(input.substring(index + 1));
				} 
			} 
		} 
	}
			
	
	String result = input.trim();
	
	return Integer.parseInt(result); 
		
		
	}
	

}
