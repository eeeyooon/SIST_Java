package com.test.java.lambda; //04.11

import java.util.Calendar;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex74_Lambda {

	public static void main(String[] args) {
		
		//Ex74_Lambda.java
		
		/*
		
			a.람다식 > 익명 객체의 추상 메소드 > 인터페이스 참조 변수에 저장
			> 람다식은 인터페이스 참조 변수가 필요화다.
			> 람다식은 인터페이스가 필요하다. (***)
			
			b.
			함수형 인터페이스, Functional Interface라고 부름.
			- 람다식을 사용하기 위해 JDK에서 제공하는 인터페이스.
			- 다른 용도로 사용 안함. 오직 람다식을 저장하는 용도로만 사용함.
			- 표준 API 함수형 인터페이스 > JDK 제공
			- 사용자 정의 함수형 인터페이스 > 개발자 선언
			
			
			
			b. 
			***복습
			표준 API 함수형 인터페이스 (카테고리당 1~2개 정도만 다룰 예정)
			1. Consumer > 매개변수 O, 반환값 X (들어간건 있는데 나오는게 없다 = 소비만 한다 > 소비자)
				- Consumer<T>
				- BiConsumer<T,U> -> 매개변수 2개짜리 Consumer
				- andThen() 이라는 메소드도 있음.
				
			2. Supplier > 매개변수 X, 반환값 O (제공만 함 > 공급자)
				- Supplier<T>
				
			3. Function 	> 매개변수 O, 반환값 O 
				- Operator와 Predicate의 상위셋 (얘네가 할 수 있는 일은 Function이 다할 수 있음)
				- 그 기능을 좀 더 개성적이고 전문적으로 할 수 있도록 하위 셋을 만든 것.
				- 어떤 행동을 하든 자신의 행동을 하고 결과값을 돌려줌. (그 행동이 Operator는 연산, Predicate은 판단)
				- Functino<T, R>
				- BiFunctino<T,U,R> //R은 반환값 T,U는 매개변수
				- andThen()
				- compose()
				
			4. Operator	> 매개변수 O, 반환값 O
				- Function의 하위 Set
				- 매개변수를 연산 후 반환 행동함.
				- BinaryOperator <T>
				
				
			5. Predicate > 매개변수 O, 반환값 O
				- Function의 하위 Set
				- 매개변수를 가지고 논리 연산 후 반환 행동
				- Predicate<T>
				- BiPredicate<T, U>
				- and()
				- or()
				- negate()
				- isEqaul()
				
			=> 이 8개(기본 메소드)는 꼭 기억하기!	+ 그 외 추가 메소드는 간간히 사용함. (억지로 외우진 말고 하다보면 자연스럽게 나옴.)
			
			
			//H
			자바의 인터페이스
			- final 상수 가질 수 있음.
			- default 메소드 가질 수 있음.
			- static 메소드 가질 수 있음.
			=> 얘네셋은 엄밀히 말하면 구현된 것. 근데 정적인 느낌이 더 강해서 어거지로 끼워 넣은 것. (다른 언어때 헷갈리니까 몰라도 된다고 했음.)
				> 근데 오늘 잠깐 볼게. (맨밑 interface Test로 가봐 //H)
			
			
			다른 언어의 인터페이스
			- 추상 메소드를 가짐. (보편적으로)
			- 구현 멤버를 가지지 못함. (변수, 구현 메소드)
			
			
		*/	
		
		
		//요구사항] 아래의 메소를 구현한 객체 1개가 필요하다.
		//1. 클래스 선언 > 객체 생성 : 다회성
		//2. 인터페이스 > 익명 객체 생성 : 일회성 객체 생성
		//3. 인터페이스 > 람다식 사용 > 익명 객체 생성 : 일회생 객체 생성
			//(2번과 같은 코드지만 훨씬 간결 -> 둘다 알면 무조건 3번 사용)
			//코드비용도 적게 들고 익숙해지면 가독성도 높아지니까
		
		//public int sum(int a, int b) {
		//		return a + b;
		//}
		
		//(a, b) -> { 
		//		return a + b;
		//};
		
		//익명 객체를 인터페이스의 자식클래스로 강제로 (익명객체의 도움이 없으면 인터페이스의 값을 저장할 곳이 없으니까 억지로 관계 생성)
		//-> 람다식을 인터페이스의 변수에 
		
		//>> 저 람다식을 추상 메소드로 구현하는 인터페이스가 반드시 필요함. (**) //이부분 복습
		
		
		//Test 인터페이스 만든 후
		
//		Test t = (a, b) -> { 
//				return a + b;
//		};
		
		//더 줄일 수 있으니까
		Test t = (a, b) -> a + b;

		System.out.println(t.sum(10, 20)); //30
		
		
		//*** 람다식을 왜 사용하는가?
		//		> 메소들르 간단하게 만들기 위해서(조금이라도 짧게 코딩하려고)
		//		> 익명객체 특징을 포함해서 하면 더 좋음 (일회용 객체를 생성하려고))
		//		>> 생산성을 위해
		
		//근데 그만큼 인터페이스를 생성했잖아? (의아) 
		//인터페이스를 만드는건 어쩔수없지만 인터페이스 생성으로 람다식의 장점이 훼손돼
		//그래서 자바는 이 람다식을 사용하기 위한 인터페이스들을 제공해줘! (다시 위에서 정리) > a.
		
		
		
		
		//C
		//m1();
		
		//D
		//m2();

		//E
		//m3();
		
		//F
		//m4();
		
		//G
		//m5();
		
		//I
		m6(); //H에 새로 추가한 메소드들 살펴보기
		
	} //main
	
	private static void m6() {
		
		//표준 API 함수형 인터페이스의 정적, 디폴트 메소드
		//- 일종의 람다 객체들의 연산자 역할 
		
		Calendar c = Calendar.getInstance();
		c.set(2020, 5, 10);
		User hong = new User("1", "홍길동", 25, "사원", c);
		
		
		//업무1. user를 건네받고 이름만 출력
		Consumer<User> c1 = user -> System.out.println("이름: " + user.getName());
		c1.accept(hong);	//이름: 홍길동
		
		//업무2. 이번엔 나이를 출력
		Consumer<User> c2 = user -> System.out.println("나이: " + user.getAge());
		c2.accept(hong);	//나이: 25
		
		//요구사항] 업무 1과 업무 2를 동시에 실행
		//Case1.
			//둘을 메소드로 따로 빼자
			//c1.accept(hong);
			//c2.accept(hong);
			//위 둘을 블럭으로 한번에 잡고 메소드 추출하면 간편
		
		//aaa(hong, c1, c2);
			
		//이게 늘상 썼던 거지만 메소드에 매개변수를 쓰면 조금 부담돼 -> 가독성이 그닥 좋지 않아.
		//다른 방법
		
		//Case2.
		//Consumer (c1) + Consumer (c2) = 새로운 Consumer (c3) => 그게 andThen()
		
		Consumer<User> c3 = c1.andThen(c2); //return값 존재 -> Consumer 리턴. (새로운 Consumer)
		c3.accept(hong);	// 이름: 홍길동 \n 나이: 25
		
		//>> 작업을 단순화 시킴. (가독성, 취급을 더 편리하게) -> 일종의 연산자임. (andThen())
		
		System.out.println();
		
		//요구사항] 이번엔 직급도 추가 >> c1 + c2 + c4
		Consumer<User> c4 = user -> System.out.println("직급: " + user.getPosition());
		
		//Case1.	
		Consumer<User> c5 = c1.andThen(c2).andThen(c4); //c1 + c2 + c4
		c5.accept(hong);
		
		System.out.println();
		
		//Case2. c3 + c4 (c3 = c1+c2)
		Consumer<User> c6 = c3.andThen(c4); //(c1 + c2) + c4
		c6.accept(hong);
		
		System.out.println();
		
		Consumer<User> c7 = c2.andThen(c1); //나이를 먼저 출력하고 그 다음 이름 출력
		c7.accept(hong);	// 나이: 25 \n 이름: 홍길동
		
		System.out.println();
		System.out.println();
		
		Function<Integer, Boolean> f1 = num -> num > 0;
		System.out.println(f1.apply(10));	//true
		
		Function<Boolean, String> f2 = result -> result ? "성공입니다." : "실패";
		System.out.println(f2.apply(true));	//성공
		
		System.out.println();
		
		//요구사항] Function (f1) + Function (f2) = 새로운 Function (f3)
		
		Function<Integer, String> f3 = f1.andThen(f2); 
		//Function<?,?> -> 자료형 2개는 무엇일지가 문제.
		//Integer > f1의 인자값(매개변수), String > f2의 반환값
		
		System.out.println(f3.apply(10));	//성공
		//f3에 넣은 10은 먼저 f1 매개변수로 전달됨. -> 그걸 가지고 true/false를 반환. 
		//그 반환값을 가지고 f2를 호출함. -> 그걸 가지고 String 반환. f3가 그 반환값을 받음.
		
		//andThen()으로 Function을 조작할땐 누가 앞에있고 누가 뒤에 있을때를 잘 봐야해. (Consumer는 순서 바꿔도 상관 x)
		//얜 세밀하게 조작해야하지만 할 수 있는 업무가 훨 많음. (더 복잡한 업무도 구현 가능)
		
		
		System.out.println();
		
		
		//f2의 리턴값을 염두에 두고 String
		Function<String, Integer> f4 = str -> str.length();
		
		//f1 + f2 + f4 = f5
		//f1의 매개변수가 f5의 매개변수, f4의 반환값이 f5의 반환값
		Function<Integer, Integer> f5 = f3.andThen(f4); //f3 = f1+f2
		System.out.println(f5.apply(10));	//6
		
		System.out.println();
		
		//compose()
		Function<Integer, String> f6 = num -> num > 0 ? "참" : "거짓";
		Function<String, Integer> f7 = str -> str.length();
		
		Function<Integer, Integer> f8 = f6.andThen(f7);	//f6 + f7 -> f6이 먼저 실행되고 f7 실행
		Function<Integer, Integer> f9 = f7.compose(f6); //f6 + f7 -> 얘도 순서는 f6이 먼저 실행. 그다음 f7실행
		//Function<Integer, Integer> f9 = f6.compose(f7); //에러 >> 뒤에 자세히 설명 넘어가.
		
		System.out.println(f8.apply(10));	//1 (둘다 참이니까 1 출력)
		System.out.println(f9.apply(10));	//1
		
		
		//*우선은 andThen()만 확인. compose() 위치바뀌는것만 확인하고 넘어가
		
		System.out.println();
		
		//Predicate >  and or negate
		//2의 배수 검사
		Predicate<Integer> p1 = num -> num % 2 == 0;
		
		//3의 배수 검사
		Predicate<Integer> p2 = num -> num % 3 == 0;
		
		int a = 10;
		System.out.println(p1.test(a)); //true
		System.out.println(p2.test(a));	//false
		
		System.out.println();
		
		
		//p1 and p2
		Predicate<Integer> p3 = p1.and(p2);
		//p3로 받아서 p1과 p2에 넘겨줘야하니까 Integer

		System.out.println(p3.test(a)); 	//false (2의 배수지만 3의배수는 아니니까)
		System.out.println(p3.test(12));	//true
		
		System.out.println();
		
		//p1 or p2
		Predicate<Integer> p4 = p1.or(p2);
		System.out.println(p4.test(a)); //true (2의 배수이거나 3의 배수일때 true)
		
		
		
		//and or -> 얘넨 순서 의미 xX
		
		
		//!p1
		Predicate<Integer> p5 = p1.negate();
		System.out.println(p5.test(a)); //false
		
		
		//A && B
		//A || B
		//!A
		
		// > 이런 메소드를 제공함.
		
		
		//오늘은 여기까지 수업. (이건 오늘 정리하지말고 내일 예제까지 다룬 다음에 복습)
		
		
		
		
	}
	
	//case1. 메소드를 빼는 방법
	private static void aaa(User hong, Consumer<User> c1, Consumer<User> c2) {
		c1.accept(hong);
		c2.accept(hong);
	}
	

	
	private static void m5() {
		
		//G
		//Predicate
		//- 매개변수를 전달하면 처리 후 반환값을 돌려주는 업무를 구현
		//- testXXX() 추상 메소드 제공
		//- 매개변수를 전달받아 논리 검사 진행 > 항상 Boolean값 반환하는 추상 메소드를 생성
		
		Function<Integer,Boolean> f1 = num -> num > 0;
		Predicate<Integer> 		  p1 = num -> num > 0; 		//둘이 같음
		//-> 얜 무조건 boolean을 반환하기때문에 반환값 안씀.
		
		System.out.println(f1.apply(10));	//true
		System.out.println(f1.apply(-10));	//false
		
		System.out.println(p1.test(10));	//true
		System.out.println(p1.test(-10));	//false
		
		//두개를 받아 비교함
		BiPredicate<String, String> p2 = (s1, s2) -> s1.length() > s2.length(); //둘중 어느게 길이가 더 긴지
		System.out.println(p2.test("홍길동", "홍아무개"));	//false
		
		
		
		
	}

	private static void m4() {
		
		//Operator
		//- 매개변수를 전달하면 처리 후 반환값을 돌려주는 업무를 구현
		//- applyXXX() 추상 메소드 제공
		//- 추상 메소드의 매개변수와 반환값이 동일함. 
		
		//매개변수 2개 + 반환값 1개 (근데 자료형은 하나) 인터페에이스
		BinaryOperator<Integer> bo1 = (a,b) -> a * b;
		System.out.println(bo1.apply(10, 20));	//200
		
		//이거랑 같다고 보면됨.
		BiFunction<Integer, Integer, Integer>  bf1 = (a, b) -> a * b;
		System.out.println(bf1.apply(10, 20));	//200
		
		
		BinaryOperator<String> bo2 = (s1, s2) -> s1 + s2;
		System.out.println(bo2.apply("홍", "길동"));  //홍길동
		
	}

	private static void m3() {
		
		//E
		//Function
		//- 매개변수를 전달하면 처리 후 반환값을 돌려주는 업무를 구현
		//- applyXXX() 추상 메소드 제공
		
		//IntToDoubleFunction
		//Function<Integer,Double>와 같은 기능을 하는 전용 인터페이스.
		// > 근데 대부분 전용 인터페이스를 잘안씀. (쓰면 좋을 경우도 있지만 그건 나중에) >> 제네릭 위주로 연습하는게 가성비가 젤 높음.
		
		//<Input, Return>
		Function<Integer, Boolean> f1 = num -> num > 0; //숫자 하나를 주면 true/false 하나 돌려주기로.
		System.out.println(f1.apply(10));	//true
		System.out.println(f1.apply(-10));	//flase
		
		Function<String, Integer> f2 = str -> str.length(); //String을 받으면 String의 길이 돌려줌. 
		System.out.println(f2.apply("홍길동"));	//3
		System.out.println(f2.apply("홍길동님"));	//4
		
		
		//객체 넣어보자(User객체를 받아서 그 사람의 직급을 확인하고 직급이 사원 / 대리면 사원급 or 간부급
		Function<User,String> f3 = user -> {
			if (user.getPosition().equals("사원") || user.getPosition().equals("대리")) {
				return "사원급";
			} else {
				return "간부급";
			}
		};
		
		
		
		System.out.println(f3.apply(new User("1", "홍길동", 25, "대리", null)));	//사원급
		System.out.println(f3.apply(new User("1", "홍길동", 25, "차장", null)));	//간부급
		
		// <첫번째 매개변수, 두번째 매개변수, 반환값>
		BiFunction<Integer, Integer, String> bf1 = (a, b) -> a > b ? "크다" : "작다";
		System.out.println(bf1.apply(10, 5));	//크다
		System.out.println(bf1.apply(5, 10));	//작다
		
			
		
	}

	private static void m2() {
		
		//D
		//Supplier 
		//- 매개변수 없이 반환값을 돌려주는 업무를 구현
		//- getXXX() 추상 메소드 제공
		
		
		Supplier<Integer> s1 = () -> 100; //return 100;
		System.out.println(s1.get()); //100

		Supplier<Double> s2 = () -> Math.random(); //return Math.random(); //0에서 1 사이의 난수
		System.out.println(s2.get());	//0.7511289638684316 (랜덤값)
		
		Supplier<String> s3 = () -> "홍길동";		//return "홍길동";
		System.out.println(s3.get()); //홍길동
		
		Supplier<Integer> s4 = () -> {
			Calendar c = Calendar.getInstance();
			return c.get(Calendar.HOUR_OF_DAY); //지금이 몇시인지 돌려줌.
		};
		
		System.out.println(s4.get()); // 10(지금이 10시니까)
		
		//get이라는 메소드를 호출하면 user라는 객체를 만들어서 돌려줌.
		Supplier<User> s5 = () -> new User("1", "홍길동", 25, "사원", null);
		System.out.println(s5.get());
		
		//얘도 Consumer처럼 IntSupplier / DoubleSupplier같은게 존재함. -> 근데 체크만하고 그냥 제네릭만 사용해도..
		
		
		
	}

	//C.
	private static void m1() {
		
		//Consumer
		//- 매개변수를 받아서 소비하는 업무를 구현.
		//- 인터페이스인까 추상 메소드를 가지고 있음. -> 그 추상 메소드 이름이 보통 accept로 시작.
		//- acceptxxx() 추상 메소드 제공.
		
		//C-1.
		MyConsumer m1 = num -> System.out.println(num * num); //여기서 에러가 남.
		m1.test(10);	//100
		m1.test(5);		//25
		
		
		//C-2 // MyConsumer와 똑같이 만듦
								//앞이 제네릭이라 자료형도 값형말고 Integer -> 근데 이것도 생략 가능하니까 신경 쓸 필요 X (Integer num)
		Consumer<Integer> c1 = num -> System.out.println(num * num);
		c1.accept(3);	//9
		c1.accept(4);	//16
		
		Consumer<String> c2 = str -> System.out.println(str.length());
		
		c2.accept("홍길동");					//3
		c2.accept("안녕하세요. 반갑습니다.");		//13
		
		Consumer<Integer> c3 = count -> {	//건네받은 애들을 소비하는데 쓰는 메소드
			for (int i=0; i<count; i++) {
				System.out.println(i);;
			}
			System.out.println();
		};
		
		c3.accept(5); //0 1 2 3 4 
		
		
		//이번엔 객체(Ex73때 만든 User class 사용)
		Consumer<User> c4 = user -> { //매개변수 이름은 user
			System.out.println("이름: " + user.getName());
			System.out.println("나이: " + user.getAge());
			System.out.println("직급: " + user.getPosition());
			
		};
		
		c4.accept(new User("1", "홍길동", 20, "사원", null)); //캘린더는 만들기 힘드니까 그냥 null
		//이름: 홍길동 \n 나이: 20 \n 직급: 사원
		
		//** 다시 보자 (복습)
		BiConsumer<String, Integer> bc1 = (name, age) -> {
			System.out.printf("이름 : %s, 나이 : %d세\n", name, age);
		};
		
		bc1.accept("홍길동", 25); //이름 : 홍길동, 나이 : 25세
		
		//Consumer<Integer> -> 제네릭은 편하게 자료형 바꿔라, 밑은 자료형을 고정 => 근데 선생님은 그냥 제네릭을 주로 사용.
		IntConsumer ic1 = num -> System.out.println(num * 2);
		ic1.accept(100); //200
		
	}
	
	
	
}//Ex74


//C-1-1. >> 함수형 인터페이스라고 부름. (목적 : 람다식을 저장하려고 만든 인터페이스 -> 이 목적일때 함수형이라고 부름.)
		//> 문법적인 차이는 없고 목적만 다름!!
		//but 남들이 봤을 땐 일반 인터페이스와의 차이를 구분하기 어려움.
		//그래서 그 위에다가 "@FunctionalInterface"를 붙임 > 이러면 공식적으로 함수형인터페이스가 됨.
		
		//사실 문법적인 차이 하나 있음. 명백한 차이 
		// >> 함수형 인터페이스는 반드시 추상 메소드를 딱 1개만 가질 수 있음. > 이 1개의 추상메소드가 곧 람다식(익명 메소드)이 되기 때문에.

@FunctionalInterface	//1. 남에게 역할(함수형 인터페이스라고)을 알리기 위해. //2. 문법적인 체크(추상 메소드가 1개인지 검사)
interface MyConsumer {
	void test(int num);
	//void call(int test);	// C-1-2. (FunctionalInterface 안붙였을때) 메소드를 하나 더 추가했더니
							// 위에 람다식을 저장하는 문장에서 에러가 남.
							// > The target type of this expression must be a functional interface
							// >> 함수형 인터페이스라는게 메소드의 개수와 관련이 있다는 것.
							// 인터페이스가 물려준 메소드가 하나면 람다식의 이름없는 메소드가 딱 그거 하나로 결정되지만
							// 메소드 여러개면 람다식의 메소드가 어떤 것인지 구분할 수 없음 >> 그래서 에러 (다시C-1-1로)
							
}
//> 람다식을 저장하려고 만듦.



//인터페이스 자체가 필요해서 만든 인터페이스가 아니라
//람다식을 저장해야할 참조변수가 필요해서 만든 인터페이스. (**)
interface Test {
	int sum(int a, int b);
	
	//H
	//public int a;
	final public int b = 20; 
	//이게 가능함. -> 상수는 객체 멤버의 의미보단 모든 객체가 똑같이 가지고 있으니까 공용 멤버의 의미를 더 가지고 있음.
					// 그래서 구현의 의미보단 (object에 귀속된다기보단) 범용의 의미로 쓰여서 인정을 해버림.
	final public static int c = 30; 	//얘도 인정
	
	//public void aaa() {
	//	
	//}
	// 얜 안돼
	
	
	
	//둘다 인터페이스가 소유할 수 있는 공통 메소드 정도로만 생각해
	public static void bb() {	//얜 또 돼. 개인의 행동보단 -> 모두의 행동이니까 > 구현(실체화)보단 추상적인 의미로 생각
		
	}
	default void ccc() {
		
	}
	//얜 static 메소드랑 거의 비슷하다고 생각하면 돼
}





























