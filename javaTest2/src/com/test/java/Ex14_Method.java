package com.test.java;

public class Ex14_Method {

	public static void main(String[] args) {
		
		//Ex14_Method.java
		
		/*
		
			public static void hello() {
				Ssystem.out.println();
			}
	
			접근지정자 정적키워드 반환자료형 메소드명 인자리스트 {
			-메소드명 : 호출하기 위한 식별자
			-지금은 반환자료형, 메소드명, 인자리스트만 수업. 앞 두개는 추후에 TODO 접근지정자, 정적키워드 나중에
	
	
	
				구현코드
				업무코드(비즈니스 코드)
			}	
			
			
			
			메소드 매개변수
			- 호출 -> (데이터) -> 메소드
	
			메소드 반환값
			-메소드가 실행 뒤 호출한 곳에 값을 돌려주는 행동
			-메소드 -> (데이터) -> 호출
			-목적? 메소드 내에서 업무 진행의 결과를 이어서 사용하고자 반환.
			
			
			
		
		 */
		
		
		
		//리턴값 출력
		System.out.println(getNum());
		
		int num = getNum();	//메서드를 int에 저장한게 아니라 메서드의 반환값을 저장한 것!
		System.out.println(num);
		
		
		int age = 25;
		String result = checkAge(age);
	
		System.out.println(result);
		
		System.out.println(checkAge(17));
	
	
	
	}	//main
	
	
	public static int getNum() {	//이 메소드는 호출되면 int값을 반환하기로 약속되어있는 것.
		
		//int를 적었기때문에 할일을 다하고 맨 마지막엔 항상 int타입의 값을 결과로 반환해야 함.
		
		
		//리턴문, 반환문
		//-getNum을 호출한 곳에 아래의 값을 돌려줌.
		//-하나의 값만 반환 가능하다.
		return 10;
		
		
		
	}
	
	
	public static void test() {	//원래는 void자리에 자료형을 적어야 하는데, return문이 없을 땐 아무것도 반환하지 x는 의미
		
		//return 100;	-> error (리턴 없다매)
	}
	
	
	public static String checkAge(int age) {	//숫자 하나를 주면 문자를 돌려주기로 한 메소드
		
		String result = age >=19 ? "성인" : "미성년자";
		
		return result;
		
		
		
	}
	
}//class




















