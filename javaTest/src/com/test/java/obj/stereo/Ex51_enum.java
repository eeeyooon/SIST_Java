package com.test.java.obj.stereo; //03.28

public class Ex51_enum {

	public static void main(String[] args) {
		
		//Ex51_enum.java
		
		
		//클래스 종류
		//1. 클래스
		//2. 인터페이스
		//3. 추상 클래스
		//4. enum
		
		
		//열거형, Enumeration
		//- 클래스의 일종
		
		
		//요구사항] 의류 쇼핑몰 > 티셔츠 > 고객 > 색상 선택(빨강, 노랑 파랑)
		
		
		//Case1.  like 주관식
		String color = "빨강";	//오타 발생 가능성 높음.
		
		if (color.equals("빨강") || color.equals("노랑") || color.equals("파랑") ) {
			System.out.println("판매 가능");
		} else {
			System.out.println("재고 없음");
		}
		
		System.out.println();
		
		
		
		//Case2. like 객관식
		색상 c1 = 색상.빨강; //열거형명.enum데이터 > '.'을 찍었을때 나오는 데이터 아니면 쓸 수 없음.
						  // -> 단점이자 장점 : 제공한것들 중에서만 선택해서 사용해라. >> 안정성을 제공해줌.
		색상 c2 = 색상.파랑; //이게 변수만드는 방식.
		
		
		if (c1 == 색상.빨강 || c1 == 색상.노랑 || c1 == 색상.파랑) {
			System.out.println("판매 가능");
		} else {
			System.out.println("재고 없음");
		}
		
		
		//색상2 ->내부구조가 같으니까 enum과 if문도 같음.
		
		int c3 = 색상2.노랑;
		
		if (c3 == 색상2.빨강 || c3 == 색상2.노랑 || c3 == 색상2.파랑) {
			System.out.println("판매 가능");
		} else {
			System.out.println("재고 없음");
		}
		
		
		//직급
		
		직급 position = 직급.사원;
		
		//Gender
		
		Gender g1 = Gender.MALE;
		Gender g2 = Gender.FEMALE;
		
		
 		
	}//main

}//Ex51

//class, interface, abstract처럼 enum 역시 변수를 만들 수 있음.

class 클래스명 {
	//구현멤버
}

interface 인터페이스명 {
	//추상 멤버
}

abstract class 추상클래스명 {
	//구현 멤버
	//추상 멤버
}

enum 열거형명 {
	//열거형 멤버
}

//열거형 선언하기 
enum 색상 {	// { 빨강, 노랑, 파랑 } 과 같은 거임. 마지막에 콤마 안하게 조심.
	빨강,	 //얘네 final static 상수임 (굳이 기억 안해도돼. enum의 데이터 정도로만 기억해)
	노랑,
	파랑
}


//enum 색상은 사실 색상2클래스와 같음. (뒤에숫자는 저렇게 자동으로 설정되지만 그 숫자는 아무 의미가 없음!! 사용 xX)
class 색상2 {
	final public static int 빨강 = 0; 
	final public static int 파랑 = 1;
	final public static int 노랑 = 2;
}



enum 직급 {
	사원,
	대리,
	과장,
	부장
}

//열거형 멤버는 항상 대문자로 !! > 상수니께
enum Gender {
	MALE,
	FEMALE
}






