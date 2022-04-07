package com.test.java; //03.08

import java.io.BufferedReader; //import 잊지마
import java.io.InputStreamReader;

public class Ex08_Input {

	public static void main(String[] args) throws Exception { //예외처리 +reader클래스를 쓸땐 꼭 꼭 잊지말고!
		
		//Ex08_Input.java
		
		/*
		 
		  	1. System.in.read()
		  		- System.out.print() 반대 기능 
		  		- 가장 기본 기능 (오래된 기능)
		  		- 사용 불편
		  		- 그래서 잘 안씀
		  		
		  	2. BufferedReader 클래스 (***)
		  	
		  	3. Scanner 클래스
		  
		  
		 */
		
		//요구사항] 사용자에게 단어를 하나 입력받아 그대로 출력하시오.
		
		//BufferedReader reader : 변수 선언 
		//reader -> 콘솔 입력 도구
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//System.out.println("시작");
		
		//일시 중지!! reader.readLine();을 읽는 순간 대기 상태 > '블럭 걸렸다'라고 표현하지만
		//정확히는 사용자가 키보드로 무언가를 입력하기를 기다리고 있는 중인 것. (입력 대기 상태로 멈춰있음)
		//그래서 입력하면 바로 종료 뜨면서 끝!
	
		reader.readLine(); //우리가 입력한 순간 사라지고 내가 입력한 결과가 남음.
		
		System.out.print("단어: "); //Label
		String str = reader.readLine();
		
		System.out.printf("입력한 내용:[%s]\n", str);
		
		//System.out.println("종료");
		
		//요구사항] 나이를 입력 받아 문장을 출력하시오.
		System.out.print("나이: "	);
		String age = reader.readLine();
		
		System.out.printf("당신의 나이는 %s살입니다. \n", age);
		
//		이땐 run을 해도 콘솔창이 안뜸 새로 콘솔창을 보면 대기중인 상태로 들어가있음
//		그럴 땐 엔터를 치면 글자가 뜨고 글자입력하면 글자 출력됨.
		
		
		
		/*
		
		잠깐! 간단 설명!
		
			에러, error
			- 오류, 버그(Bug), 예외(Exception) 등..
			
			1. 컴파일 에러
				-컴파일 작업 중에 발생하는 에러
				-컴파일러가 발견!!>  문법이 틀려서
				-이클립스 편집기의 빨간 밑줄(x표)
				-발생하면 > 컴파일 작업 중단함 > 프로그램 생성 불가 > 반드시 해결 해야 함.
				-난이도 가장 낮음 > 컴파일러가 에러 메세지를 보내주기 때문에 > 발견이 쉽고 > 고치기 쉬움.
				-주로 오타에 의한 에러
				-해결방법 : 에러 메세지 확인 > 코드 수정
				
			2. 런타임 에러
				-컴파일 작업 중에는 없었는데, 실행중에 발생하는 에러
				-문법에는 오류가 없었는데 다른 원인으로 발생하는 언어
				-예외(Exception)
				-난이도 중간 > 발견하기 쉬운 정도도 중간 > 발견은 복불복으로 이루어짐. >테스트 > 발견 o > 코드 수정 > 발견x > 조치x
				-게임출시 > RPG > 소수의 개발자 모든 기능 테스트 > 모든 기능 테스트하는건 사실상 불가능이라 > 클로즈드 알파, 클로즈드 베타 테스트
				 > 오픈 알파, 오픈 베타 > 수정..
				-지구상의 모든 프로그램은 런타임 오류를 내재
				-패치, 업그레이드...
				-해결 방법 : 다양한 테스트 > 발견된 오류에 한해서 수정
				
				
			3. 논리 에러
				-컴파일 성공 ! + 실행 성공 > 결과 중 일부 이상
				-난이도 최상 > 발견 최악 + 수정 최악
			
			
			오류 노트 만들기 추천. 
			- 제목 > 나누기 연산 중 발생하는 오류
			- 상황 > 사용자로부터 입력 받은 숫자를 제수로 사용
			- 에러 메세지 > java.lang.ArithmeticException: / by zero (에러 났을 때 첫 줄)
			- 에러 발생 코드 > System.out.printf("100 / %d = %d\n", num, 100 / num);
			- 해결책 > 제수로 0을 사용하면 안된다.
			
			
			
		*/
		
		
		//런타임 에러를 내보자
		//요구사항] 사용자로부터 숫자 입력 > 연산식 출력
		
		System.out.println("숫자를 입력하세요.(**** 반드시 0이 아닌 숫자를 입력하세요");
		
		int num = 20; //사용자 입력 숫자(로 가정)
		
		System.out.printf("100 / %d = %d\n", num, 100 / num);
		
		
		int a = 10;
		int b = 5;
		
		System.out.println(a + b);
		
		
		
		
	}
}
