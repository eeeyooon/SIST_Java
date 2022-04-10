package com.test.java.lambda; //04.08


public class Ex72_Lambda { //04.08

	public static void main(String[] args) {
		
		
		/*
		 
		 	람다식, Lambda Expression
		 	- 함수형 프로그래밍 방식을 지원하는 표현식
		 	- 람다식을 사용하면 코드가 간결해진다. (그럼 의미가 함축이 되니 익숙하지 않으면 되려 어렵게 느껴질 수도 있음)
		 	- 자바 > 컬렉션(배열) 조작을 위해서 제공 
		 	- 자바의 메소드 표현
		 	- 람다식은 매개변수를 가지는 코드블럭이다. (=메소드)
		 	- 자바의 람다식은 반드시 인터페이스를 사용해서 만든다. (*******) -> 인터페이스를 상속받은 추상메소드니까.
		 	 (자바말고 다른 언어에서는 인터페이스없이 직접 만듦.)
		 	- 자바의 람다식은 익명 객체를 만드는 방법을 간소화시킨 기술임. (****)
		 		-> 우리는 메소드 표현을 간단히 했지만 눈에 안보이는 메소드를 감싸는 객체가 존재하고 이걸 익명 객체라고 함.
		 			>> 그래서 람다식으로 간결히 표현할 수 있는 것 
		 			>> 평범한 클래스엔 쓸수없음. 익명클래스만 가능.
		 	
		 	
		 	
		 	람다식 형식
		 	- 인터페이스 변수 = 람다식; 
		 	- ex) MyInterface m1 = () -> {}; //'->'도 문법임. '() -> {}' 이만큼을 람다식, 람다객체라고 함.
		 	- (매개변수리스트) -> {실행블럭}
		 	- a. (매개변수) : 메소드의 매개변수 리스트와 동일.
		 	- b. -> : 화살표(Arrow), 코드블럭을 호출하는 역할
		 	- c. {실행블럭} : 메소드의 구현과 동일
		
		*/
		
		
		//요구사항] MyInterface를 구현한 객체를 1개 만드시오.
		
		//Case 1. 클래스 선언 + 객체 생성
		MyInterface m1 = new MyClass();
		m1.test();
		
		//Case 2. 익명 객체 생성 (클래스 선언x)
		MyInterface m2 = new MyInterface() {
			@Override
			public void test() {
				System.out.println("익명 클래스 객체에서 구현한 메소드");
				//사용자가 자신의 의견을 담은 코드는 이거뿐. 나머지는 언제나 모두에게 동일.
			}
		}; //이걸 줄여보자..?
		
		m2.test();
		
		//Case 3. 람다식 (불필요한 부분을 없애보자. -> 내가 코딩한 내용만 남기고)
		MyInterface m3 = () -> { System.out.println("람다식으로 만든 객체에서 구현한 메소드"); };
		
		// 앞엔 매개변수블록 살림 위의 메소드 블럭 남김.  그리고 마지막 또 세미콜론..
		// 이게 곧 Case2의 test 메소드를 표현한 것. -> 람다식 == 메소드 (인터페이스로부터 상속받아 재정의한 메소드 ***)
		// 익명객체도 귀찮다고 줄여놓은게 람다 객체
		// 기능은 셋다 같음. 1번은 객체 재사용을 위해 만드는 것. 2,3번은 1회용 객체 만들때(2번보다 줄인게 3번인 차이뿐)
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//B.
		//익명 객체의 (추상) 메소드 형식에 따라
		
		NoParameterNoReturn pr1 = new NoParameterNoReturn() { //익명객체 만들기
			@Override
			public void call() {
				System.out.println("pr1"); //할일은 지금 중요하지x
			}
		};
		
		pr1.call(); //pr1의 메소드 이름은 call //pr1
		
		
		//람다식 만들기 (익명객체를 간결히)
		NoParameterNoReturn pr2 = () -> {
			System.out.println("pr2");
		}; 
		
		pr2.call(); //pr2의 메소드 이름은 보이진 않지만 call임. 
		
		//** 실행블럭에 문장이 유일하면 {} 생략 가능
		NoParameterNoReturn pr3 = () -> System.out.println("pr3"); 
		//람다식은 메소드임에도 불구하고 안에 코드가 한줄이면 메소드블럭을 생략할 수 있음.
		pr3.call();
		
		
		ParameterNoRetrun pr4 = (int num) -> {
			System.out.println(num);
		};
		
		pr4.call(100); //매개변수O(int num)이니까 int 넣어야돼.
		pr4.call(200);
		pr4.call(300);
		
		
		//**매개변수의 자료형을 생략할 수 있다.
		ParameterNoRetrun pr5 = (int num) -> System.out.println(num); //이렇게 블럭 생략 가능하지만
		//+ 매개변수의 자료형 생략도 가능함.
		pr5.call(400);
		pr5.call(500);
		
		//**매개변수의 자료형을 생략할 수 있다.
		ParameterNoRetrun pr6 = num -> System.out.println(num); //이렇게 블럭 생략 가능하지만
		//+ 매개변수의 자료형 생략도 가능함.
		pr6.call(600);
		pr6.call(700);
		
		//void call(String name, int age);
		MultiParameterNoReturn pr7 = (String name, int age) -> {
			System.out.println(name + "," + age);
		};
		
		pr7.call("홍길동", 20);
		
									// 소괄호 생략은 X >> 매개변수가 1개일때만 가능함. ****
		MultiParameterNoReturn pr8 = (name, age) -> {	//얘도 자료형 지울수있음 추상메소드에 구현되어있으니까 구분 ㄱㄴ
			System.out.println(name + "," + age);
		};
		
		pr8.call("아무개", 25);
		
		
		//int call()
		NoParameterRetrun pr9 = () -> { return 10; };
		System.out.println(pr9.call());
		
		//** 실행문에 return문이 유일하면 {}와 return을 생략할 수 있음.
		NoParameterRetrun pr10 = () -> 20; // = return 20;
		//이렇게 줄이기도 가능 return + {} 생략 가능
		
		
		
		/*
		
		-이런 계통의 애들은 제어문의 블럭 안에 실행코드가 한줄이면 블럭을 생략할 수 있음. (한줄만) -> 모든 제어문 다 가능
		 코드가 확장되거나 유지보수할 때도 있으니까 적는 버릇을 들이는게 편함. 가독성도 좋고.
		 딱 제어문만. 클래스나 메소드 다 x (근데 람다식은 메소드이긴하지만 생략가능)
		  
		if (true) 
			System.out.println("true");
		else
			System.out.println("false");
		
		while (true) System.out.println("test"); //무한루프
		
		
		*/
		
		
		
		
		
	}//main

}//Ex72


interface MyInterface {
	void test();
	
}

class MyClass implements MyInterface {

	@Override
	public void test() {
		System.out.println("실명 클래스 객체에서 구현한 메소드");
		
	}
	
	
}
	

//B.


interface NoParameterNoReturn {	//인자값X 리턴값X
	void call();
}

interface ParameterNoRetrun {	//인자값O 리턴값X
	void call(int num);
}

interface MultiParameterNoReturn {	//인자값 여러개, 리턴값X
	void call(String name, int age);
}

interface NoParameterRetrun { //인자값X, 리턴값O
	int call();
}
	





















