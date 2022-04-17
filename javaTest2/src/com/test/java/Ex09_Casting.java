package com.test.java;

public class Ex09_Casting {

	public static void main(String[] args) {
		
		//Ex09_Casting.java
		
		/*
		
			형변환, (자료)형변환, Casting, Data Type Casting
			- 코드를 유연하게 작성하기 위한 도구
			- int -> double
			- float -> short
			
			
			1. 암시적 형변환(= 자동 타입 변환)
				-큰 형 = 작은 형
				-100% 안전 
				-short = byte; //2칸짜리에 1칸을 복사
				-int = byte; //4칸 = 1칸
				-long = byte; //8칸 = 1칸
				-int = short; //4칸 = 2칸
				-long = short; //8칸 = 2칸
				-long = int; // 8칸에 5칸
			
			
			2. 명시적 형변환(= 강제 타입 변환)
				-작은 형 = 큰 형
				-경우에 따라 다름. > 작은형이 소화할 수 있는 범위의 원본값이면 복사가 가능하고, > 성공.
								 작은형이 소화할 수 없는 범위라면 손실분이 생김. > 실패.
				-필요할때도 있음. 단, 개발자의 주의를 요함.
			
			
			*형변환 하기전 잠깐 짧게 연산자 설명
			
			'=' 연산자
			-피연산자 2개 > 2항 연산자
			-할당 연산자, 대입 연산자
			변수 = 값(리터럴, 상수)
			-LValue = RValue
			-**** LValue의 자료형과 RValue의 자료형은 반드시 (*****) 동일 해야 함.
			 > 이 규칙을 만족하지 못하면 에러가 발생 ! (컴파일 에러)
		
		*/
			
			int a;
			a = 10;
			
			int b;
			
			//LValue(int) = RValue(int)
			
			b = a;
			
			short c;
			
			//LValue(short) = RValue(int)
			//c = a; //에러 발생
			
			
			byte b1;	//1칸
			short s1;	//2칸
			
			b1 = 127;	//원본
			
			//복사
			//short = byte
			//2byte = 1byte
			//암시적인 형변환 발생 > 개발자가 모르게 자료형을 바꾸는 행동이 발생!
			s1 = b1;
			
			//위의 복사가 안전하게 이루어졌는지 확인
			
			//System.out.println(s1);
			
			//byte가 가질 수 있는 모든 숫자는 short가 가질 수 있기 때문.
			//적은 범위의 자료형을 큰 범위의 자료형에 복사할 경우엔 문제가 생기지 않음.
			
			//	 (자료형)피연산자; : 형변환 연산자 > 피연산자의 자료형을 ()안의 자료형을 바꿔서 반환해라.
			
			s1 = (short)b1; // 얘가 원래 코드. (근데 컴파일러가 대신 short를 넣어줘서 우리가 안하는거)
			
			// -> s1의 자료형 byte가 short로 바뀌면서 에러가 안일어남~
			
			
			
			byte b2;	//1칸
			short s2;	//2칸
			
			s2 = 10;	//원본
			
			//복사
			//작은형 = 큰형
			
			//b2 = s2;	error.
			//형변환 연산자를 생략할 수 없음 > 명시적 형변환
			b2 = (byte)s2;	//소괄호 생략안하는건 개발자에게 경고, 여기 잘 보라고 주의 주는 것. 
			
			System.out.println(b2);
			
			//자꾸 이상한 값이 나오는 이유는 2진법으로 바뀐 숫자를 byte로 바꿀때 자리수가 모자르면 넘치는 앞자리들 자르고 뒷자리들만
			//복사했기 때문에 그 뒷자리들의 값으로 나온거임. ex.30000을 넣으니 48이 나온것처럼
			//128 넣었을 때 -128된건 부호비트에 1 들어가면서~ / 이거 안중요함 뭘 넣으면 뭐가 나오는지 의미 없음x 이미 그냥 이 행동이 잘못됐다는 것.(아무의미없는값)
			
			
			
			//은행 계좌 관리 프로그램
			//-기업은행(한독) 계좌
			int money = 2100000000; //21억(4byte)
			
			//계좌이체 -> 기업은행(잠실) 계좌
			short copy; //2byte
			
			//계좌이체 완료
			copy = (short)money;	//에러발생x > 논리오류!!!! 그래서 더 무섭고 조심해야함.
			
			//잠실 계좌 잔액: 29,952
			System.out.println("잠실 계좌 잔액: " + copy);
			
			
			//값도 달라지고,,에러도 안남. ㄷ
			
			
			//정리
			
			//자료형이 다른 값들끼리 복사할 때
			//1. 암시적 형변환	> 신경 쓸 필요 없음 > 그래도 확인은 해
			//2. 명시적 형변환	> 주의!!!!!!!!	> 조심x10000
			
			//명시적 형변환 시 발생하는 넘치는 현상 > 오버플로우(Overflow)발생
			//1. 위로 넘치는 현상 > Overflow(오버플로우)
			//2. 아래로 넘치는 현상 > Underflow(언더플로우)
			//>둘 합쳐서 Overflow라고 함.
			
			//**** 오버플로우가 발생할만한 상황은 미리 예측해서 관리가 필요함.
			
			
			
			//정수형 리터럴은 int이다.
			
			//byte = int
			//작은형(1) = 큰형(4) //원랜 오버플로우가 발생할 수 있으니 명시적 형변환을 해야 함. > 안하는 이유는 일종의 서비스 문법..임(^^?
			byte m1 = 10;
			
			//short = int
			//작은형(2) = 큰형(4)
			short m2 = 10;
			
			//int = int
			int m3 = 10;
			
			//long = int
			//큰형(8byte) = 작은형(4) > 암시적 형변환을 한 것
			long m4 = 10;
			//사실 long m4 = (long)10; 인 것.
			
			
			//float = double
			//작은형(4) = 큰형(8)
			float f1 = 3.14F;	//서비스 문법x, 그나마 서비스 문법인게 뒤에 f붙이는 거(이게 일종의 캐스팅 작업)
			
			//double = double
			double f2 = 3.14;
			
			
			
			
			//형변환
			//1. 정수 -> 정수
			//2. 실수 -> 실수
			//3. 실수 -> 정수
			//4. 정수 -> 실수
			
			
			int n1 = 1000;	//원본(4byte)
			float n2;		//복사본(4byte)
			
			//암시적 형변환 > 안전!
			n2 = n1;
			
			System.out.println(n2);
			
			
			
			int n3;				//복사(4byte)		> -21억 ~ 21억
			float n4 = 1000;	//원본(4byte)		> 무한대
			
			//명시적 형변환 > 불안전
			//왜 불안전? 같은 4byte이지만 float이 범위가 훨 커서 범위가 큰 걸 작은 것에 복사한 거라 명시적이어야 함.
			//n3 = n4;	//error
			n3 = (int)n4;
			
			System.out.println(n3);
			
			
			//크기 차이 확인 (자바의 정석 기초편에도 있던 듯)
			//int < float
			//long < float
			
			
			//크기 정리
			//byte(1) < short(2) < int(4) < long(8) < float(4) < double (8) /정수는 아무리 커도 실수보다 작음!**
			
			
			//char, boolean, String의 형변환은?
			//-boolean > 형변환의 대상 자체가 불가능함. (어떤 자료형이든 형변환 x.)\
			
			//-String > 값형과 참조형간에는 형변환이 불가능함.
			//	ex. "100"(String) -> 100(int) 형변환 x
			//		100(int) -> "100"(String) 형변환 x
			
			//char > 형변환의 대상 가능.
			//-겉보기엔 문자, 내부는 숫자. (문자형이라고 부르지만 실제로는 숫자 자료형 중 하나로 취급함)
			
			
			char c1;	//2byte
			short r1;	//2byte
			
			c1 = 'A';	//원본 
			
			//복사
			//r1 = c1;	 //error 뜸. 명시적 형변환 하라는 말.
			
			r1 = (short)c1;
			
			System.out.println("r1: " + r1);	//'A' -> 65 (절댓값. 변하지 않음.)
			
			
			char c2;
			short r2;
			
			r2 =65;
			
			//복사
			//c2= r2;	//error.
			
			c2 = (char)r2;
			
			System.out.println("c2: " + c2);	//65 -> 'A'
			
			
			//어느 한쪽이 명시적 형변환이면 정반대는 암시적. but char<->short는 둘다 명시적.
			
			//결론 : char를 숫자로 형변환하려면 반드시 int 이상의 자료형으로 변환해야 한다. (65335까지 표현할 수 있는 자료형이 필요)
			
			char c3;
			int a3;
			
			c3 = 'A';
			
			//암시적
			a3 = c3;
			
			System.out.println(a3);
			
			char c4;
			int a4;
			
			a4 = 65;
			c4 = (char)a4;
			
			System.out.println(c4);
			
			
			char c5;
			short r5;
			
			c5 = '가';
			
			r5 = (short)c5;
			
			System.out.println(r5);	//-21504
			
			
			char c6;
			int a6;
			
			
			c6 = '가';
			
			a6 = (int)c6;
			
			System.out.println(a6);	//44032
			System.out.println();
			
			//char <-> int //이것만 기억하면돼 ** 이해못해도
			
			
			//각 문자들의 문자 코드값 (*표 암기하면 편리~)
			
			System.out.println((int)'A');	//65	****
			System.out.println((int)'B');	//66
			System.out.println((int)'Z');	//90
			
			System.out.println((int)'a');	//97	****
			System.out.println((int)'z');	//122	****
			
			//1 vs '1'
			
			System.out.println((int)'0');	//48	****
			System.out.println((int)'9');	//57	****
			
			//한글 완성형 기준 (가~힣)
			System.out.println((int)'가');	//44032 (이건 굳이 기억안해도)
			System.out.println((int)'힣');	//55203 
			
			
			//유효성 검사
			//-데이터가 업무에 타당한 데이터인지 확인하는 검사
			//-모든 프로그램에 들어가는 필수 업무
			
			//ex) 사이트 회원가입 > 이름 입력(한글로만 입력)
			
			String name = "홍길동";
			
			//'홍' '길' '동'
			
			//(int)'홍' (int)'길' (int)'동'
			
			
			
			//형변환 복습 (얘네만 정리해도 ㄱㅊㄱㅊ)
			//1. int -> long
			//2. long -> int
			
			//3. 실수끼린 변환할 일 x (f<->d) 은 걍 넘어가.
			//4. int -> double
			//5. double -> int
			//6. double -> long
			
			//7. int -> char
			//8. char -> int
			
			
			//49가지 종류 > 8가지 종류
			
			
			
	}
}
