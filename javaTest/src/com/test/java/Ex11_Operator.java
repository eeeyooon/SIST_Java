package com.test.java;	//03.10

public class Ex11_Operator {

//클래스의 이름은 반드시 파일의 이름과 같아야함. (클래스:Ex10_Input) = 파일의 이름(Ex10_Input.java)
//편집하고 싶은 패키지 탐색기 위에서 f2 눌러야함.
//변수 수정은 그 변수 긁은 뒤 ctrl+1 -> rename메뉴 (file)
	
	public static void main(String[] args) {
		
		//Ex11_Operator.java
		
		
		/*
			연산자, Operator
			-수학 연산자와 동일
			-피연산자를 대상으로 미리 정해진 연산(행동)을 한 후에 연산(행동)의 결과를 반환하는 요소
			-주로 기호를 많이 사용 + 단어도 많이 사용
			
			1. 문장, Statement
			2. 표현식, Expression
			3. 연산자, Operator
			4. 피연산자, Operand
			5. 연산자 우선순위
			6. 연산자 연산방향
			
			
			문장, Statement
			- int sum = 10 + 20=;
			
			표현식, Expression
			-문장을 구성하는 최소 단위
			-int sum (얘도 한 표현식)
			-10 + 20 (얘도)
			-sum = 30 (얘도)
			-10
			-20 (이렇게 상수만 있는 것도 표현식)
			-int (그렇지만 얘는 x 얜 반드시 뒤에 변수가 와야 함.)
			
			
			연산자, Operator
			- +
			- =
			
			피연산자, Operand
			- +: 10,20을 피연산자로 하고 있음.
			- =: 30, sum을 피연산자로.
			
			
			-> 이렇게 쪼개는 연습도 해야함. (최소한 어떤 문장을 줬을 때 저정도로는 쪼갤 수 있을정도로? 뭐라고 불리는지)
			
			
			
			
			연산자 종류
			1. 행동
				a. 산술 연산자
				b. 비교 연산자
				c. 논리 연산자
				d. 대입 연산자(=할당)
				e. 증감 연산자
				f. 조건 연산자
				g. 비트 연산자
				
			2. 형태(피연산자 개수)
				a. 1항 연산자
				b. 2항 연산자
				c. 3항 연산자
				
				
			산술 연산자
			- +, -, *, /, %(mod, 나머지)
			- 전부 2항 연산자 (피연산자를 2개씩 가져야함.)
			- 피연산자로 숫자형을 가진다.(정수,실수)
			
		
		*/
		
		int a = 10;
		int b = 3;
		
		System.out.printf("%d + %d = %d\n", a, b, a + b);	//10 + 3 = 13
		System.out.printf("%d - %d = %d\n", a, b, a - b);	//10 - 3 = 7
		System.out.printf("%d * %d = %d\n", a, b, a * b);	//10 *3 = 30
		System.out.printf("%d / %d = %d\n", a, b, a / b);	//10 / 3 = 3(몫) 
		System.out.printf("%d %% %d = %d\n", a, b, a % b);	//10 % 3 = 1(나머지)
		
		
		//error message 중 formatflags -> 형식문자 오류라는 말. 
		//printf는 %활용해서 형식문자를 쓰기 때문에 가운데 있는 연산자 %를 형식문자 %로 착각을 해서 에러인것.
		//이럴 땐 %% 나머지 연산자를 두개 쓰면 됨. (printf()에서만!!)

		
		//나누기 연산자 주의할 점
		//-나누기 피연산자가 1개 이상이 실수면 연산 결과가 실수임. > 이렇게 기억하면 안돼.(밑에 걸로)
		System.out.println(10 / 3); 		// 정수 / 정수		>3
		System.out.println(10.0 / 3.0); 	// 실수 / 실수 	>3.3333333333333335
		System.out.println(10.0 / 3); 		// 실수 / 정수		>3.3333333333333335
		System.out.println(10 / 3.0); 		// 정수 / 실수		>3.3333333333333335
		System.out.println(10 / 6);			//> 1
		
		
		//TODO 어떤 패턴으로 소수이하가 설정되는지 모르겠습니다. (2022. 3. 11. 오전 10:20:01)
		
		//*** 좀 더 자세히 설명하는 것.
		//모든 산술 연산자(나누기뿐만 아니라)의 결과 자료형은 두 피연산자의 자료형중에서 더 크기가 큰 자료형으로 반환이 된다. **
		//- + : 오버플로우가 나오지 않게 신경써야 함.
		//- - : 오버플로우는 언더플로우도 있으니까 신경써야함. 
		//- * : 더욱 신경쓸 것
		//- / , % : 적당히 
		
		
		System.out.println(10 / 3);		//int / int > 둘 자료형이 같은 int니까 결과값도 int
										//근데 int는 정수만 표현하는 자료형이니 소수값들이 다 날라가는 것.
		System.out.println(10.0 / 3.0);	// double / double > = double
		System.out.println(10.0 / 3); 	// double / int > double (double이 int보다 크니까)
		System.out.println(10 / 3.0); 	// int / double / double이 더 크니까 결과값도 double
		
		int c = 1000000000;
		int d = 2000000000;
		
		System.out.println(c + d);		//30억이 아니라 -1294967296 나옴. -> Overflow 발생. 그러니까 항상 주의
		System.out.println(c + d);		// int + int / 이럴 땐 둘 중 하나를 적어도 long으로 만들어줘야 함.
		System.out.println((long)c + d);//그러면 결과가 잘 나옴.	
		
		
		//byte, short
		byte b1 = 10;
		byte b2 = 20;
		
		//***byte, short의 연산 결과는 무조건 int형으로 나옴. > CPU 처리 단위가 int여서
		System.out.println(b1 + b2); // byte + byte = int (byte아님)
		
		
		byte b3 = (byte)(b1 + b2); // byte로 결과 나오게 하려면 이렇게 해야하는데 이게 너무 번거로우니 byte, short 사용 안함.
		
		
		
		//비교 연산자
		//- >, >=, <, <=, ==(equal), !=
		//- 2항 연산자
		//- 피연산자들의 우위(동등) 비교하는 연산자
		//- 피연산자는 숫자형을 가진다. //(문자열이 오는 경우가 있음)
		//- 연산의 결과가 boolean이다.
		
		
		
		a = 10;
		b = 3;
		
		System.out.printf("%d > %d = %b\n", a, b, a > b);	// 
		System.out.printf("%d >= %d = %b\n", a, b, a >= b);	// 
		
		System.out.printf("%d < %d = %b\n", a, b, a < b);	// 
		System.out.printf("%d <= %d = %b\n", a, b, a <= b);	// 
		
		System.out.printf("%d == %d = %b\n", a, b, a == b);	// 
		
		System.out.printf("%d != %d = %b\n", a, b, a != b);	// 
		
		
		//요구사항] 사용자 나이 입력 > 원하는 나이검사 ? 19세 이상 통과
		int age = 25;
		
		System.out.println(age >= 19); //권장되는 표현
		
		System.out.println(19 <= age); //비권장
		
		//A >= B 
		//A : 주체
		//B : 비교대상
		// 비교대상보다 주체가 먼저 와야 함. 
		
		
		
		//논리 연산자
		//- &&(and), ||(or), !(not)
		//- 2항 연산자(&&, ||), 1항 연산자(!)
		//- 피연산자의 자료형이 boolean이다.
		//- 연산의 결과가 boolean이다.
		//- 피연산자를 대상으로 정해진 규칙에 따라 정해진 값을 반환하는 연산자
		
		//A && B = ??
		//T && T = T
		//T && F = F
		//F && F = F
		//F && F = F
		
		//A || B = ?
		//T || T = T
		//T || F = T
		//F || T = T
		//F || F = F 
		
		
		System.out.println();
		
		
		//소개팅 > 남자소개
		//1. 키 180cm 이상
		//2. 잘생길 것
		
		
		boolean f1 = true;
		boolean f2 = false;
		
		System.out.println(f1 && f2);	//false
		System.out.println(f1 || f2);	//true
		
		
		System.out.println(+10);
		System.out.println(-10);
		System.out.println(!true);
		System.out.println(!false);
		
		
		
		//대입연산자
		//- =
		//- +=, -=, *=, /=. %= : 복합 대입 연산자
		//- LValue(변수) = RValue(상수, 변수)
		//- LValue와 RValue는 자료형이 동일해야 함. > 형변환
		//- 대입 연산자는 모든 연산자들 중 연산자 우선순위가 가장 낮음.
		
		//연산자 우선순위
		//- 하나의 문장에 속한 모든 연산자들은 실행 순서를 가짐.
		
		//연산자 연산 방향 
		//- 하나의 문장에 속한 동일 종류의 연산자들은 실행순서를 가진다.
		//- 대입 연산자, 증감 연산자 : 오른쪽 -> 왼쪽
		//- 나머지 연산자 : 왼쪽 -> 오른쪽
		
		int sum = 10 + 20 + 30;
		
		// 연산자 > 3개
		
		//int sum = 10 + 20 + 30;
		
		//10 + 20
		System.out.println(sum); //60
		
		
		int n = 10;
		
		//n이 가지는 값에 1을 더한다. > 누적 (*****)
		//n = 이름없는 공간에 11이 있는 걸 n에 덮어씌움.
		n = n + 1;
		System.out.println(n);
		
		n += 1; // n= n + 1 > 이렇게 표현하자고 약속함.
		System.out.println(n); //12
		
		n += 2; // 기존에 n이 값는 값에 2를 더하고 n에 덮어씌우라는 뜻.
		System.out.println(n); //14
		
		n += 10;
		System.out.println(n); //24
		
		
		n = n - 2;	//얘도 누적이라고 부름.
		System.out.println(n); //22
		
		n = n - 2;
		System.out.println(n); //20
		
		n -= 7l;
		System.out.println(n); //13
		
		n *= 2;
		System.out.println(n); //26
		
		n *= 2;
		System.out.println(n); //52
		
		n = n/3;
		System.out.println(n); //17
		
		n /= 3;
		System.out.println(n); //5
		
		
		n = n % 3;
		System.out.println(n); //2
		
		n %= 2;
		System.out.println(n); //0
		
		
		
		n = n + 10;
		n += 10;	//o
		
		n = n -5;
		n -= 5;		//o
		
		n = n + 10;
		n += 10;	//o
		
		n = 5 - n;
		n -= 5;		//x
		
		//-=, /=, %= : 피연산자 위치가 바뀌면 안됨. (+=, *=는 순서 상관없으니 가능.
		
		
		
		//문자열 연산자(+)
		//- 2항 연산자
		//- 피연산자로 문자열을 가진다.
		//- 연산 결과로 두 문자열을 합친 문자열을 반환하는 연산자
		
		//- 문자열 + 문자열 = 문자열
		//- 문자열 + 비문자열 = 문자열
		//- 비문자열 + 문자열 = 문자열
		//- 비문자열 + 비문자열 => 산술 연산자
		
		
		System.out.println(100 + 200 + 300);	//600
		System.out.println(100 + 200 + "300");	//300300
		System.out.println(100 + "200" + 300);	//100200300
		System.out.println("100" + 200 + 300);	//100200300
		
		
		//비교 연산자
		//- ==, !=
		
		int num1 = 100;
		int num2 = 100;
		int num3 = 200;
		int num4 = 50;
		num4 = num4 + 50;
		
		System.out.println(num1 == num2);	//true
		System.out.println(num1 == num3);	//false
		System.out.println(num1 == num4);	//true
		System.out.println();
		
		String txt1 = "홍길동";
		String txt2 = "홍길동";
		String txt3 = "아무개";
		String txt4 = "홍";
		txt4 = txt4 + "길동";
		
		System.out.println(txt4);	//홍길동
		
		System.out.println(txt1 == txt2);	//
		System.out.println(txt1 == txt3);
		System.out.println(txt1 == txt4);	//true(x) -> false(0) ******* ->이유는 나중에 (겉보기엔 같아보여도 내부구조상 다름)
		System.out.println();
		
		//*******자바는 문자열을 대상으로 ==, != 연산자를 절대로 사용하면 안된다.!!!!
		
		System.out.println(txt1.equals(txt2)); //true
		System.out.println(txt1.equals(txt4)); //true 얘는 글자가 똑같으면 true라고 함. (겉보기가 똑같으면) > 나중에 더 보충해줄 것. 
		
		System.out.println(!txt1.equals(txt2)); //앞에 ! 붙이면 not equals 됨. (부정 연산자)
		
		
		//증감 연산자
		//- ++, --
		//- 1항 연산자, 단항 연산자
		//- 피연산자는 숫자형을 가진다.
		//- 누적 연산을 한다. 기존의 값에 1을 더하거나, 1을 뺀다.
		//- 연산자와 피연산자의 위치를 바꿀 수 있다. > 연산자 우선순위가 달라짐.
		// a. ++n : 전위 배치 (전치 연산자)	> 연산자 우선 순위가 가장 높음. (산술 연산자보다 높음.)
		// b. n++ : 후위 배치 (후치 연산자)	> 연산자 우선 순위가 가장 낮음.
		
		
		
		
		n = 10;
		
		n = n+ 1;
		
		n += 1;
		
		++n;
		
		System.out.println(n); //11
		
		//n = n-1;
		//n -= 1;
		
		--n;
		
		System.out.println(n);
		
		System.out.println();
		
		n = 10;
		++n;	//+1
		
		System.out.println(n);
		
		
		n++;	//+1 (하는 일에는 변함이 없음.)
		
		System.out.println(n);
		
		System.out.println();
		
		n = 10;
		
		int result = 0;
		
		result = 10 + ++n;	//*** 가독성이 낮아서 요즘 잘 안씀
		//	  (1) (3)(2) > 연산 순서
		
		
		//가독성있는 표현식
		//++n;	//+1
		
		//result = 10 + n;	//
		
		System.out.println(result); //21
		
		
		n = 10;
		
		result = 0;
		
		result = 10 + n++;	//우선순위가 바뀜.*** 가독성이 낮아서 잘 안씀
		//	  (2)  (1)(3)
		
		
		//가독성있는 표현식
		//result = 10 + n;
		//n++;
		
		
		System.out.println(result); // result : 20, n : 11
		
		System.out.println(n);	//n: 11
		
		
		//*** 증감 연산자를 다른 연산과 함께 한 문장에서 사용하지 않는다. (이게 요즘 추세) > 권장 > 왜? 복잡하니께,,
		
		
		int o = 10;
		System.out.println(--o - o --);// ? 
		
		
		
		//조건 연산자
		//- A ? B : C
		//- ?: -> 이것만 연산자이고
		//- A, B, C -> 피연산자임.
		//- 3항 연산자.
		//- A : Bollean이어야 함.
		//- B,C : 상수, 변수, 연산식, 메소드 > 뭐든 "값"이 오면 돼.
		
		boolean flag = true;
		
		String fresult = flag ? "참" : "거짓";
		
		System.out.println(fresult);
		
		// -> 참이니까 String fresult = "참";만 남음.
		
		age = 15;
		
		fresult = age >= 19 ? "통과" : "거절";
		
		System.out.println(fresult);
		
		
		//쇼핑몰 > 티셔츠 구매 > 색상 선택(검정, 노랑, 파랑)
		String color = "노랑"; //색상 입력 요청
		
		fresult = (color.equals("검정") || color.equals("노랑") || color.equals("파랑")) ? "재고있음" : "재고없음";
		
		System.out.println(fresult);	//재고 있음.
		
		
		n = 5; //짝수 or 홀수?
		
		System.out.println(n % 2 == 0 ? "짝수" : "홀수" );
		
		
		
		//int num = true ? 10 : "홍길동"; //error. 만약 false면 "홍길동"이 int num에 들어가야 하는데, 타입이 안맞으니까.
									  //연산의 결과 자료형이 매번 달라짐. -? ;;
		//** 반드시 B와 C의 자료형이 동일해야 함.
		
		// update하지마!!!! 2021.03 버전 이상으로 가지마!! 조심해!!
		
		
		//문제 > 문제 풀이 > ? 또 뭘 시키면 > 그걸 이어서
		
		
		
		
	}
}






















