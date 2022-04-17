package com.test.java; //3.17

public class Ex24_for {

	public static void main(String[] args) {
		
		//Ex24_for.java
		
		/*
		
		
		*/
		
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		
		m8();
		
		
	}//main
	
	
	private static void m8() {

		//별찍기
		for (int i=0; i<5; i++) {
			
			for (int j=0; j<5; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		System.out.println();
		
		
		//아래로 내려가는 삼각형 54321
		for (int i=0; i<5; i++) { //행 변화x
			
			for (int j=i; j<5; j++) { //열 변화o(5->1)
				System.out.print("*");
			}
			
			System.out.println();
		}
		System.out.println();
		
		
		//위로 올라가는 삼각형 12345
		for (int i=0; i<5; i++) {
			
			for (int j=0; j<=i; j++) { // 열만들기 (1 -> 5)
				System.out.print("*");
			}
			
			System.out.println();
		}
		System.out.println();
		
		
		//위의 예제 좌우대칭
		for (int i=0; i<5; i++) {
			
			for (int j=0; j<(4-i); j++) {
				System.out.print(" ");
			}
			
			for (int j=0; j<=i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		System.out.println();
		
		
		
	}//m8()


	private static void m7() {
		
		for (int i=0; i<10; i++) {
			
			for (int j=0; j<10; j++) {
				
				if (i == 5 || j == 5) {
					break; //break에 커서 올리면 어디를 통과하는지 알 수 있음. (현재 안쪽 for문만 탈출함.)
							//break, continue는 자신이 직접 포함된 제어문만 탈출함.
							//j==5일 땐 회전수 50 (i:10xj:5)
							//i==5일 땐 회전수 90 (i가 5일때 10번 빼니까)
							//i==5 && j==5일 땐 95번 (i가 5일 때 j는 0~4까지만 가고 나머지 5개는 버려지니까)
							//i==5 || j==5일 땐 45번 (i가 0일때 j:0~4 X 9번 하니까 45)
				}
				
				System.out.printf("i: %d, j: %d\n", i, j);
			}
			
		}
		
		
	}


	private static void m6() {
		
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				
				System.out.printf("i: %d, j: %d\n", i, j);
			}
			
		}
	}


	private static void m5() {
		
		//구구단
		//- 2단 ~ 9단 출력
		
		
		for (int dan=2; dan<=9; dan++) {
		
			//int dan = 2;
			
			
			System.out.println("===========");
			System.out.printf("    %d단\n", dan);
			System.out.println("===========");
			
			for (int i=1; i<=9; i++) {
				
				System.out.printf("%d x %d = %2d\n", dan, i, dan * i);
				
			}
			
			System.out.println();
		}
	}


	private static void m4() {
		
		//지역 변수
		//- 메소드와 제어문 내에서 선언한 변수
		
		if (true) {
			int a = 10;
			System.out.println(a); //10
		}
		
		if (true) {
			int a = 20;
			System.out.println(a); //20
		} //제어문 안에서 선언된 변수는 제어문 호출이 끝나면 끝.
		
//		System.out.println(a); a가 제어문이 끝나며 죽어버려서 error.
	}


	private static void m3() {
		
		//학교
	
	for (int k=1; k<=3; k++) { // 학년 루프
		for (int j=1; j<=10; j++) {	// 반 루프
		
				for (int i=1; i<=30; i++) { // 학생 루프
					System.out.printf("%d학년 %d반 %d번 학생\n", k, j, i);
				}
		
			}
		}
	}



	private static void m2() {
		
		/*
		
			제어문 중첩
			- 모든 제어문은 종류에 상관없이 서로 중첩할 수 있음.
			
			for문(반복문)끼리 중첩
			- 다중 반복문
			- 단일 for문
			- 2중 for문
			- 3중 for문
		
		*/
		
		//단일 for문
		for (int i=0; i<10; i++) {
			System.out.println("i: " + i);
		}
		
		
		//2중 for문
		for (int i=0; i<10; i++) { //대회전
			for (int j=0; j<10; j++) { // 소회전
				
				System.out.println("안녕하세요."); //몇번 실행되는지?
				System.out.printf("i: %d, j: %d\n", i, j);
			}
		}
		
		
		//3중 for문
		for (int i=0; i<10; i++) { //시침 i<24
			
			for (int j=0; j<10; j++) { //분침 j<60
				
				for (int k=0; k<10; k++) { //초침 k<60
					
					System.out.printf("i: %d, j: %d, k: %d\n", i, j, k);
				}
			}
		}//for
		
		
	}
	
	private static void m1() {
		
		//do while 문 - 연습 안해도 돼 요즘 거의 x
		
		/*
		 	int num = 10;
		 	
			while (num < 0) {
				실행문;
			}
			
			
			//조건 만족을 못해도 1회는 실행함.
			
			do
			{
				실행문;
			} while (num < 0);
			
		
		*/
		
		int num = 0;
		
		do {
			
			System.out.println(num);
			num++;
			
		} while (num < 10);
		
		
		
		
		
	}
	
	
}
