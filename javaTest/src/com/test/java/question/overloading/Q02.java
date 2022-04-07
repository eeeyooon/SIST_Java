package com.test.java.question.overloading;

public class Q02 {

	public static void main(String[] args) {
		
		//Q02.
		//요구사항] 인자로 받은 이름들을 직급 순으로 출력하는 메소드를 선언하시오.
		
		position("홍길동");
		position("홍길동", "유재석");
		position("홍길동", "유재석", "박명수");
		position("홍길동", "유재석", "박명수", "정형돈");
		
	}//main
	
	
	public static void position(String staff) {
		System.out.println("사원: " + staff);
		System.out.println();
	}

	public static void position(String staff, String assistManger) {
		System.out.println("사원: " + staff);
		System.out.println("대리: " + assistManger);
		System.out.println();
		
	}

	public static void position(String staff, String assistManager, String manager) {
		System.out.println("사원: " + staff);
		System.out.println("대리: " + assistManager);
		System.out.println("과장: " + manager);
		System.out.println();
		
	}
	
	public static void position(String staff, String assistmanager, String manager, String director) {
		System.out.println("사원: " + staff);
		System.out.println("대리: " + assistmanager);
		System.out.println("과장: " + manager);
		System.out.println("부장: " + director);
		System.out.println();
		
	}
	
	
	//staff, assistManger, manger, Director //변수명을 의미있게.
	//printf문으로 한번에 출력 

}
