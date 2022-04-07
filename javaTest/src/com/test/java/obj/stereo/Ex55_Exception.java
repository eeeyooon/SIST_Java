package com.test.java.obj.stereo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex55_Exception {

	public static void main(String[] args)  {
		
		//Ex55_Exception.java
		
		/*
			
			예외, Exception
			- 컴파일 발견 X > 실행 중 발견 O
			- 런타임 오류
			- 개발자 미리 예측 O, X
			
			카톡
			- 메세지 전송 기능
			
			
			예외 처리, Exception Handling
			1. 전통적인 방식
				-제어문 사용(조건문)
				
			2. 전용 처리 방식
				-try catch finally문 사용 
		
		
		
		*/
		
		
		//Ex55_Exception.m1(); -> 원랜 이건데 자신의 클래스 영역 안에서 자신의 소유인 메소드를 부르는 거니까
		// 						  클래스명이 생략된 것.
		
		//m1();
		//m2();
		//m3();
		try {
			m4();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//m4(); // error.
		//->m4()에 throws Exception으로 예외 미루기하면 호출부인 여기서 에러.
		// 여기서 try-catch문으로 묶든지 혹은 main()에서도 throws Exception으로 미룸. (지금까지)
		//   									=> 근데 이럼 안댜 무조건 main에서는 처리해야함.
		// ctrl + 1 누르면 자동 trycatch 생성 가능
		
		m5();
		
	}//main


	private static void m5()  {
		
		//예외 던지기
		
		//요구사항] 숫자 입력 > 처리
		//조건] 반드시 짝수만 입력
		//		홀수 입력시 에러
		
		int num = 5;
		
		if (num % 2 == 0) {
			System.out.println("업무 코드 진행");
		} else {
			System.out.println("예외 처리");
		}
		
		
		
		try {
			
			if (num % 2 == 1) {
				throw new Exception("홀수를 입력했습니다."); //강제 에러 발생 
				//+ 메세지 작성 가능 > getmessage로 가져오면돼
				//throw와 throws는 완전 달라
				//>> 이렇게까지 할 필요 없음.. if문써 만약 trycatch로 고정되어 있으면 걍 쓰고
			}
			
			System.out.println("업무 코드 진행"); //num = 5일때 그냥 업무코드 진행함 > error가 아니니까
			
		} catch (Exception e) {

			System.out.println("예외 처리");
			System.out.println(e.getMessage());

		}
		
	}


	private static void m4() throws Exception {
		
		//예외 미루기
		//- 해당 영역에서 예외 처리를 할만한 상황이 안되면 다른 곳으로 예외 처리의 책임을 떠 넘길 수 있음.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//Unhandled exception type IOException
		
		//String input = reader.readLine();
		
		
		
		//throws Exception -> 예외 미루기 : 누군가는 해야해. -> 그럼 호출부에서 에러가 뜸. (호출부로 미룸)
		
//		try {
//			reader.readLine(); //try-catch로 예외처리하면 error X 방법 1.
//		} catch (Exception e) {
//			
//		}
		
		
		
	}


	private static void m3() {
		
		
		//Exception 객체의 역할
		//너무 넓은 범위를 try로 묶는것도 안좋지만 너무 좁은 범위를 묶는것도 안좋음. > 상황에 따라 판단해야해.
		
		//이정도는 한꺼번에 try로 묶어도 ㄱㅊ
			try {
				int num = 0;
				System.out.println(100/num);  //A (0으로 나눌수도) ArithmeticException
							
				int[] nums = { 10, 20, 30 };
				System.out.println(nums[0]);  //B (배열 방번호 실수할수도) ArrayIndexOutOfBoundsException
				
				Parent p = new Parent();
				Child c;
				
				//c = (Child) p;	//C (형변환 에러) ClassCastException -> 이런 오류이름들 정리해 눈도장찍어놔
			
			} catch (ArithmeticException e) {
				
				System.out.println("0으로 나누기");
				
			} catch (ArrayIndexOutOfBoundsException e) {
				
				System.out.println("배열 첨자 오류");
				
			} catch (ClassCastException e) {
				
				System.out.println("형변환 오류");
				
			}  catch (Exception e) {
				
				//Exception > 모든 OOOException의 부모클래스
				//위에서 처리하지 못한 에러들 여기서 처리. 위에는 다 예측 가능한 에러지만 얘가 처리하는건 예측 불가능 에러.
				// > 그래서 무조건 만들어놔야해. 그리고 순서는 항상 마지막.
				
				System.out.println("예외처리");
				
				
				
			} //에러가 날때 그 에러의 종류마다 정해진 메세지 출력
			
//			} catch (Exception e) {
//				System.out.println("예외 처리");
//				System.out.println(e.getMessage());
//			}
			
			//예외를 num과 nums 모두에 줬지만 출력은 "예외 처리" 1개만 됨.
			// -> why? num에서 에러가 발생하면 그 즉시 중단 -> 예외처리 출력하긴 때문.
			
			//아쉬운 점: 에러를 구분시키지 못하고 일괄적으로 "예외 처리"만 실행. -> 이땐 getMessage()사용 >> 근데 이건 사용자한테 보여줄수없지
			// 		   사용자에게 보여주고 싶을땐 -> if문으로.. 이걸 어떻게 혀?
			
	}


	private static void m2() {
		
		//Exception 객체의 역할
		
		int num = 10;
		
		try {
			System.out.println(100/num);  //A (0으로 나눌수도) 에러가 날 수 있는 상황 세가지
		} catch(Exception e) {
			System.out.println("0으로 나누기"); //num=0이면 오류메세지 출력
		}
		
		
		int[] nums = { 10, 20, 30 };
		
		try {
			System.out.println(nums[0]);  //B (배열 방번호 실수할수도)
		} catch(Exception e) {
			System.out.println("배열 첨자 오류"); //방번호를 3이상 입력하면 오류메세지
		}
		
		Parent p = new Parent();
		Child c;
		
		try {
			//c = (Child) p;	//C
 	 	} catch(Exception e) {
			System.out.println("형변환 오류");
		}
		
		//try문 3개나 있는거 보기 안좋음. -> 너무 잦은 try-catch는 가독성이 너무 낮아짐.
		
		
	}





	//생각
	
	//메소드 자동 생성 > 생각?
	//1. private	-> 안정성때문에 private으로 제공하지만 사용자가 원하면 public으로 바꾸면 됨.
	//2. static		-> ? //static을 지우면 error가 남. static이 없는 메소드는 객체메소드, 있으면 정적 메소드.
					// 객체 메소드는 <heap 안>객체 안에 있어서, 정적 메소드는 static영역(클래스영역)에 있어서 
					// 메모리 공간이 애초부터 다름. (물리적인 차이)
					// 그래서 객체메소드는 객체.메소드로 접근하고 정적은 클래스.메소드로 접근해야했음.
					// static이 없으니까 객체로 접근해야하는데 
					// 모든 객체 메소드는 앞에 this나 이름이 들어가있어야함. 근데 this는 생략가능.
					// this.m1했을 때 error -> 현재 m1은 main()안에 있는데 main()는 static메소드임.
					// static 메소드 안에서는 this를 못씀 -> 이 말은 객체메소드를 호출하지 못한다는 말.
					// private static void m1()을 하면 main에 있는 m1() 앞엔 클래스명이 있어야함. 근데 생략되어 보이는 것.
					// 하나의 클래스 안에서 자신의 메소드를 부른 것이기때문에 클래스명을 생략한 것. (메소드의 소유주인 클래스)
					// 그래서 실제론 Ex55_Exception.m1(); 보통 호출은 메인 메소드에서 하는데 메인 메소드는 static이니
					// 클래스도 static인 것. 
					// static을 떼고 싶으면 Ex55_Exception클래스의 객체를 생성해야함. (객체를 통해 접근해야만 객체 메소드니까)
					// 근데 이건 굳이임. 이렇게 할 필요가 없음.
	
	
	
	//3. void 		-> return값이 없으니까
	//4. () 		-> 실인자값이 없으니까 매개변수 x
	private static void m1() {
		
		//요구사항] 숫자를 입력받아 연산을 하시오.
		
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Scanner가 더 편할때도 있음. Scanner는 throws Exception안써도 됨.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자: ");
		
		int num = scan.nextInt();
		//Integer.parseInt(reader.readeLIne()) -> Buffered는 이렇게 해줘야하는데 scanner는 알아서 해줌.
		
		
		//0을 입력하면 런타임오류 (예외) -> 예외 처리 하자
		//전통 방식
		
		//권장
		if (num != 0) {
			
			//비지니스 코드(업무 코드) >> 주목적!
			System.out.printf("100 / %d = %d\n", num, 100 / num); //>긍정적인 느낌 (원래 해야하니까)
		
		} else {
			
			//예외처리 코드
			System.out.println("0은 입력하면 안됩니다.");	//>부정적인 느낌 (문제 발생하면 처리하는거니까)
		
		}
		
		//비권장 > 가독성 낮음.
		if (num == 0) {
			//예외처리 코드
			System.out.println("0은 입력하면 안됩니다.");
			
		} else {
			//비지니스 코드(업무 코드) >> 주목적!
			System.out.printf("100 / %d = %d\n", num, 100 / num);
		}
		
		
		//왜 권장/비권장?
		
		/*
			if (조건) {
				참 블럭 > 긍정적인 영역이라는 생각이 있음. >> 긍정적인 비지니스 코드가 들어갈거라고 생각함.
			} else {
				거짓 블럭 > 부정적인 영역이라고 생각함. >> else절에는 예외처리코드 넣는 습관 길러.
			}
		
		
		
		*/
		
		System.out.println();
		
		//try문
		//- try: 반드시 비지니스 코드 작성
		//- catch: 예외 처리 코드 작성
		
		//조건?
		//1. 일단 try내부의 코드를 실행한다. > 실행해야하는 업무코드니까.
		//2. 아무 문제가 없음 > 빠져나감. (catch실행x)
		
		//1. 일단 try내부의 코드를 실행한다.
		//2. 에러 발생 > 남아있는 비즈니스 코드의 실행을 중단시킴.(업무코드가 더 남았어도 바로 중단.)
		//3. 즉시 catch로 이동.
		//4. catch 실행
		
		//if문 vs try문
		//- if문: 사전에 미리 검사를 해서 사고가 안나게 처리.
		//- try문: 일단 실행 > 감시!!! > 사고 터지면 그때 처리. >> 모든 사건에 대한 처리를 함.
		
		//if문은 사고가 나는 부분을 미리 알아야 하지만 try문은 몰라도됨. 어디서 어떤 에러가 날지 모름.
		// 어디서 어떤 에러가 날지 모르는데 불안할땐 try문으로 감싸면 됨. (사건을 정확히 예측을 못해도 막연히 의심갈때)
		// 그렇다고 try를 너무 남발하면 >> 무거워짐. '감시' = 비용도 많이 들고 프로그램이 무거워짐.
		// try의 범위가 넓어지면 넓어질수록 cpu도 많이 차지하고 오래걸림. 너무 광범위하게 묶는건 안좋아.
		
		//try의 영역 > 예외가 발생할거 같다고 예측 가능한 최소한의 영역에만 사용해야해.
		
		
		try {
			System.out.printf("100 / %d = %d\n", num, 100 / num); //1.여기서 에러 발생하면.
			System.out.println("나머지 업무코드"); //2. 얘도 안찍힘.
			
		} catch (Exception e) {
			System.out.println("0은 입력하면 안됩니다.");
			
			//Exception e
			//- 예외 객체
			//- 예외가 발생한 상황에 대한 정보를 알려준다.
			System.out.println(e.getMessage()); // /by zero
			//e.printStackTrace(); // 에러가 난 것처럼 보임. (에러메세지를 띄워준다?)
			
			
		} 
		
		System.out.println("종료");
		
		
	}//m1
	
	
	
}//Ex55




class Parent {
	
}

class Child {
	
}