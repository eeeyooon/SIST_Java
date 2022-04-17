package com.test.java;

public class Ex13_Method {

	public static void main(String[] args) {
		
		//Ex13_Method.java
		
		/*
		
			public static void hello() {
				system.out.println();
			}
		
			접근지정자 정적키워드 반환자료형 메소드명 인자리스트 {
			-메소드명 : 호출하기 위한 식별자
			-지금은 반환자료형, 메소드명, 인자리스트만 수업. 앞 두개는 추후에 TODO 접근지정자, 정적키워드 나중에
		
		
				구현코드
				업무코드(비즈니스 코드)
			}	
		
			
			메소드 인자리스트
			-파라미터(Parameters)
			-인자(Arguments)
			-매개변수
			-메소드를 호출할 때 메소드에게 값을 전달할 수 있다. > 그걸 가능하게 하는 도구.
			
			
		*/
		
		hello();
		hello2();
		hello3(); //a
		
		helloEveryone("홍길동");	//여기다 값을 넣는 것!
		helloEveryone("아무개");	//실인자
		
		
		checkAge(15);	//인자리스트에 아무것도 없으면 errorㄴ
		
		// 실인자와 가인자의 자료형은 동일해야 함.
		// checkAge("스무살"); /error. int타입을 넣어야 함. 
		
		//실인자의 개수와 가인자의 개수가 동일해야 함.
		// checkAge(); /가인자가 1개면 실인자도 1개여야 함.
		
		
		score(100, 90, 80);
		
		
		//score(100); error -> 실인자, 가인자의 개수가 다름.
		//socre(100,200,300,400); error -> 많아도, 적어도 안됨.

		
		//실인자와 가인자의 순서가 일치해야 함.
		// 가인자에 국-영-수 순서면 실인자에도 국-영-수라고 해야함.
		//헷갈리면 ctrl+Space 눌러서 보면 뜸.
		
		
		//구현 메소드 > 각각의 담당업무를 구현하는 담당자가 됨. 
		//메인 메소드 > 구현 메소드들을 사용해서 흐름 생성.
		
		checkNumber(10);
		checkNumber(-5);
		checkNumber(0);
		
		
	}//main()
	
	
	public static void checkNumber(int num) {
		
		//양수? 음수? > 삼항 연산자로
		
		//String result = (num > 0) ? "양수" : "양수가 아님";
		
		String result = (num > 0) ? "양수" : (num < 0) ? "음수" : "영";
		
		
		System.out.printf("%d = %s\n", num, result);
		
		
	}
	
	
	
	//주석인데 > Document주석이라고 함. > Ctrl + Space 누르면 설명 보임.
	//개인적으로 할 땐 잘안하는데 팀플로 할땐 자주 씀. 유용.
	/**
	 * 성적을 처리하는 메소드
	 * @param kor 국어
	 * @param eng 영어
	 * @param math 수학
	 */
	// /**하고 엔터 + 메소드 설명 + 파라미터 뒤에다 변수 설명
	

	public static void score(int kor, int eng, int math) {	//각각 타입 줘서 선언해야함. //이게 예제 3
		
		System.out.println("국어: " + kor);
		System.out.println("영어: " + eng);
		System.out.println("수학: " + math);
		System.out.println("총점: " + (kor + eng + math));
		
		
		
		
	}
	
	
	public static void checkAge(int age) {	//예제 2
		
		String result = age >= 19 ? "성인" : "미성년자";
		
		System.out.printf("%d살은 %s입니다.\n", age, result);
		
	}
	
	//b.소괄호 안에 변수를 만들 수 있음. 얘를 매개변수라고 부름. + 매개변수에는 값을 넣을 수 없음. ex.String name = "홍길동"; (X)
	//-> 이런 걸 메소드 가용성이 높아졌다고 함. > 쓸모가 많아졌다!
	//생산성 향상 > 코드 절감
	public static void helloEveryone(String name) {	//가인자 : 자리맡아주는 역할.
		
		//String name = "";
		
		System.out.printf("%s님 안녕하세요.\n", name);	
		
		
	}
	
	
	//요구사항] '홍길동'에게 인사를 하는 메소드를 선언하시오. //a 예제1
	
	public static void hello() {
		System.out.println("홍길동님 안녕하세요.");	
		
	}
	
	//추가사항] '아무개'에게 인사를 하는 메소드를 추가하시오.
	
	
	public static void hello2() {
		System.out.println("아무개님 안녕하세요.");	
		
	}

	//추가사항] 우리가 강의실에 있는 모든 사람마다 인사를 하는 메소드를 추가하시오.
	
	public static void hello3() {
		System.out.println("박세인님 안녕하세요.");	//이걸 30개 생성?
		
	}
	
	
	//추가사항] 대한민국 사람 모두에게 인사를 하는 메소드. //x50,000,000
	
	
}
















