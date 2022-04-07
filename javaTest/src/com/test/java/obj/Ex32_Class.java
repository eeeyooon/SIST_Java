package com.test.java.obj; //03.23

public class Ex32_Class {

	public static void main(String[] args) {
		
		//Ex32_Class.java
		
		/*
		Quick Search ctrl +  shift +  L 
		- 보통 자바에서는 물리적인 파일 1개에 클래스를 (되도록) 1개만 선언한다.
		- 이유 > 관리 차원에서 ..
			-> Ex20_if에서 문제 발생 >> 찾기 쉬움
			-> Size 클래스에서 문제 발생
		
		-절대규칙] 파일의 이름과 클래스의 이름이 "반드시" 동일해야 함.
			-> 위반하면 컴파일 에러 발생
		
		- 파일 1개에 N개의 클래스를 선언할 수 있음.
			> 파일 안의 N개의 클래스 중 public을 가지는 클래스는 딱 1개!!
			> public 클래스 == 대표클래스 > 대표 클래스의 이름이 파일명이 되는 것.
		
		
		*/
	}
	
	
}//class

//나중엔 우리도 파일 하나당 클래스 하나만 할 거임 (초반이라)

class Mouse {
	
}

//class Point { //error
	//클래스의 영역은 패키지임. (엄청 넓음) 
	//그래서 다른 파일의 class Point와 충돌
	// >> 한 패키지엔 동일한 클래스가 있을 수 없음.

//}








