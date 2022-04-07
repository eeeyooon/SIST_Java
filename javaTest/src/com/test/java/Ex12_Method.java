package com.test.java;

public class Ex12_Method {
	
	//main 메소드
	//-특수 메소드
	//-이름이 예약된 메소드 (main = 예약어)
	//-프로그램이 시작되면 자바가 자동으로 호출(실행)하는 메소드
	//-프로그램의 시작점(Entry Point) + 동시에 종착점이기도 함. 모든 메서드는 최종적으로 다시 메인으로 돌아옴.
	
	
	public static void main(String[] args) {
		
		//Ex12_Method.java
		
		
		/*
		
			메소드, Method
			- 메소드(Method), 함수(Function), 프로시저(Procedure), 서브 루틴(Sub Routine) //다 같은 말
			- 코드의 집합	
			- 같은 목적을 가진 코드의 집합 > 1가지 목적을 위해 실행하는 코드의 집합
			- 코드 재사용의 단위 (*************)
			
			메소드 사용 단계
			1. 메소드 선언하기(정의하기)
				-단 1회
				
			2. 메소드 호출하기(사용하기)
				- 0회~ 무한대
			
			
			c. 메소드 검색
			1. outline
			2. 호출부에서 > F3
			3. 호출부 > Ctrl + 마우스 오버 > open 둘 중 아무거나 
			4. Quick Search로 찾을 수도 있음. 
			
			
			프로그램에서 실행되는 코드의 흐름
				-위 -> 아래
				-실행흐름 확인하는거 밑에 
			
			e. 이클립스 코드 실행 방법
			1. Ctrl + F11 > Break Point 동작 x
			2. F11(Debug모드) > 이 모드에서만 Break Point 동작 o (Break Point : 그 위까지만 실행/ 출력됨.)
			(Break Point = 앞에 줄번호 더블클릭 or Ctrl + Shift + B)
				a. F5 : 현재 라인에 메소드가 있다면 메소드 정의부로 이동
				b. F6 : 현재 라인을 실행하고 다음줄로 이동
				
			
			요구사항] "안녕하세요" x 5회
			수정사항] "반갑습니다" 수정하기
			
			
		*/
//			System.out.println("안녕하세요");
//			System.out.println("안녕하세요");
//			System.out.println("안녕하세요");
//			System.out.println("안녕하세요");
//			System.out.println("안녕하세요");
			
			// 이건 코드의 재사용 아님!!! 
			// 수정하려면 또 "반갑습니다" 하나 수정하고 복붙
			
			System.out.println("반갑습니다.");
			System.out.println("반갑습니다.");
			System.out.println("반갑습니다.");
			System.out.println("반갑습니다.");
			System.out.println("반갑습니다.");

			//1. 초기 생산 비용 고가 > 하드 코딩 > 저수준 방식
			//2. 유지보수 비용 고가 > 초기생산 비용 == 유지보수 비용
			//3. 가독성이 높다. > 주제별로 코드를 분리해서 관리하기 때문에
			
			
			//****** 프로그램 내에 같은 일을 하는 코드가 2군데 이상 동일한게 발견되면 큰일. (절대 안됨.) -> 질이 낮은 프로그램.
			//		> 질 낮은 프로그램이란 > 관리 불량(비용 발생이 심하다)
			
			
			//여기 어딘가에 hello() 호출하겠다는 문장을 넣으면 됨.
			//메소드 호출하기(실행하기, 사용하기)
			// -> hello라는 메소드가 가지는 코드를 실행해라.
			
			hello();	//페이지 이동 명령 -> 밑에 hello메서드 선언부로 감. 그걸 제어가 이동한다고 표현함. ->돌아왔을땐 문장종결자만 남음.
			System.out.println("중간 출력"); //d. 그다음 중간 출력하고
			hello();	//또다시 페이지 이동명령 -> 다시 밑에 hello메서드로. 
			hello();
			hello();
			hello();
			
			//호출 과정을 통해서 반복 실행도 가능함. 
			//내용을 수정하고 싶으면 호출한 메서드의 내용을 바꾸면 됨. (단 한번만 바꿔도 돼)
			//-> 정의된 코드 재사용
			//같은 코드가 필요할 땐 무조건 메서드 만들어!! 무조건!! > 이래야 질높은 코드에 가까워짐. **
			
			
			//요구사항] 숫자를 출력하시오.
			//1. 1~5까지
			//2. 하나~다섯까지
			//3. 6~10까지
			//4. 여섯~열까지
			
			printNumberOneToFive();
			printKoreanNumberOneToFive();
			printNumberSixToTen();
			printKoreanNumberSixToTen();
			
			//-> 가독성, 관리 훨씬 편리
			
			
			
	/*		System.out.println("1");
			System.out.println("2");
			System.out.println("3");
			System.out.println("4");
			System.out.println("5");
			
			System.out.println("하나");
			System.out.println("둘");
			System.out.println("셋");
			System.out.println("넷");
			System.out.println("다섯");
		
			System.out.println("6");
			System.out.println("7");
			System.out.println("8");
			System.out.println("9");
			System.out.println("10");
			
			System.out.println("여섯");
			System.out.println("일곱");
			System.out.println("여덟");
			System.out.println("아홉");
			System.out.println("열");
			
			*/
			
			//이런 상황에 가독성을 좋게 만들기 위해 메소드를 만드는 것.
			
			
	}	//main //끝 괄호에 주석을 달아두면 어디 괄호인지 알기 편함!
	
	//b.
	public static void printNumberOneToFive() {
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("4");
		System.out.println("5");	
	}
	
	public static void printNumberSixToTen() {
		System.out.println("6");
		System.out.println("7");
		System.out.println("8");
		System.out.println("9");
		System.out.println("10");
	}
	
	
	public static void printKoreanNumberOneToFive() {
		System.out.println("하나");
		System.out.println("둘");
		System.out.println("셋");
		System.out.println("넷");
		System.out.println("다섯");
		
	}
	
	
	
	public static void printKoreanNumberSixToTen() {
		System.out.println("여섯");
		System.out.println("일곱");
		System.out.println("여덟");
		System.out.println("아홉");
		System.out.println("열");
	}
	
	
	
	//a. 메소드 선언하기
	//-메소드는 클래스의 자식 위치에 선언한다.
	
	//public 	static	 void	 hello	()
	//접근지정자	정적키워드	 반환자료형 메소드명	인자리스트	
	//메소드명은 자유지만, 최소한의 명명법은 지켜야 함. (전에 배운 변수 명명법은 거의 모든 것에 적용)
	
	//d. 제어가 이동.
	public static void hello() {
		
		// {~ } : 바디(block) -> 해당 메소드가 하려는 업무 구현 (반복되는건 안적음, 반복되는 단위코드 하나만)
		System.out.println("반갑습니다.");
		
		//메소드는 호출을 해야만 실행이 됨. 얜 예약된 호출이 아님. 그래서 내가 해야 해.
		//코드가 길어지고 메소드가 많을 땐 outline에서 쉽게 찾고 들어갈 수 있음.
		//에러난 메소드를 수정하고 싶을 때 그 호출된 메소드에 커서 혹은 블록 잡아서 F3누르면 그 메소드의 헤더로 이동함.
		
		//d.제어가 이동된 후 메서드가 실행이 끝나면 다시 자신을 호출했던 곳으로 이동함. 
	}
	
	
	
}	// class //괄호 하나를 선택하고 위로 올라가서 보면 짝궁 괄호가 표시되어있음.




 



