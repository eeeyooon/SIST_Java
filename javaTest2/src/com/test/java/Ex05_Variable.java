package com.test.java;

public class Ex05_Variable {

	public static void main(String[] args) {
		
		//Ex05_Variable.java
		
		//1. 각 자료형 변수 만들기
		//2. 각 자료형 리터럴 만드는 방법
		
		
		//정수형 
		byte b1;
		
		b1 = 10; //10 > 정수형 리터럴. = 숫자를 있는 그대로 나열하면 끝.
		System.out.println(b1);
		
		b1 = 127;
		System.out.println(b1);
		
		//b1 = 128;
		//System.out.println(b1);	// 해당 값의 범위를 넘어가는 값은 절대 저장이 불가능함.
		
		b1 = -128;
		System.out.println(b1);
		
	
		//b1 = -129;
		
		b1 = Byte.MAX_VALUE;	//JDK가 제공하는 상수. (미리 만들어져있는 상수)
		System.out.println(b1);	//byte값이 가질 수 있는 최대값을 가져다줌.
		
		b1 = Byte.MIN_VALUE;
		System.out.println(b1);	//byte값이 가질 수 있는 최소값.
		
		
		
		
		short s1;
		s1 = 3000;
		System.out.println(s1);
		
		s1 = -3000;
		System.out.println(s1);
		
		s1 = Short.MAX_VALUE;
		System.out.println(s1);
		
		
		int n1;
		n1 = 1000000000;
		System.out.println(n1);
		
		
		n1 = Integer.MAX_VALUE;
		System.out.println(n1);	//2147483647
		
		
		long l1;
		l1 = 1000000000;
		
		//=l1 = 2300000000;	//The literal 2300000000 of type int is out of range 
		//System.out.println(l1);
		
		// b. 정수형 리터럴은 대입 전에 int형태로 먼저 만들어진 뒤 -> 그 자료형 변수로 들어감.
		// 그렇기 때문에 int타입은 23억을 표시할 수 없어서 error.
		// 정수형 리터럴은 int 범위를 벗어나게 표현할 수 없음. 최대값은 2147483647
		// int 범위 넘어가서 넣을 수 있는 방법이 있긴 함.(밑에 L 참고)
		
		
		l1 = Long.MAX_VALUE;
		System.out.println(l1);	//9223372036854775807
		
		
		l1 = 2300000000L;	//뒤에 L붙으면 에러 안남.> 상수가 int 타입이 아니라 long타입으로 잡힘.
		System.out.println(l1);
		
		l1 = 10L; // b. 붙여도 되고 안붙여도 됨. (int범위 내에서는 접미어 자유롭게 사용.)
		
		
		
		//a. 변수만 자료형이 있는게 아니라, 모든 리터럴(상수)도 자료형이 있음.
		
		//10
		//=
		//byte b2
		
		//이렇게 세가지 행동이 합쳐진 것.
		
		
		byte	b2 = 10;
		short	s2 = 10;
		int		n2 = 10;
		long	l2 = 10;
		
		System.out.println(b2);	//10 > byte
		System.out.println(s2);	
		System.out.println(n2);
		System.out.println(l2);
		System.out.println(10);	//이 10이라는 숫자는 어떤 자료형? > int
		
		//a. ** 정수형 리터럴은 무조건 int이다. **( a~b 순서대로 필기. ) > CPU + 운영체제
		//현재는 보통 64bit 운영체제를 쓰지만 > 불과 10년전만 해도 32bit 운영체제를 사용.(과거로 갈수록 더 낮은 bit)
		// -> CPU가 한번에 처리하는 데이터의 양을 말함.
		
		//예로부터 프로그래밍 언어의 'int' 자료형은 운영체제의 bit와 동일함.
		
		//int -> 64bit (그래서 이땐 운영체제가 64bit라도 내부적으론 int를 32bit로 동결시킴)
		//int -> 32bit (이때 시기가 90년대 말이라 16>32로 바뀌며 개발자들의 혼란이 많았음)
		//int -> 16bit (int는 운영체제에 따라 bit 수가 다름. 하지만 이제 와선 16이나 32bit는 안씀)
		
		//데이터를 CPU가 바로 가져다 쓸 수 있게 하려면 > 데이터가 int가 되는 것.
		
		byte b3;	// 1byte -> 내부적으로 3byte를 늘려서 CPU가 -> 4byte로 가져감.
		short s3;	// 2byte -> +2byte -> 4byte
		long l3;	// 8byte -> 1/2 -> 4byte + 4byte로 가져감. (간단히 이해하자면 이럼.)
		int n3;		//4byte -> 그대로 4byte (그래서 int가 처리 속도가 가장 빠름. 가장 이상적인 자료형)
		
		// 정수형 자료형 4개중 > 거의 int만 사용함. (공간이 남더라도.) + 가끔씩 long을 사용함.
		
		
		//------------------------------------------- (여기까지가 정수)
		
		//실수형 리터럴(상수)는 float인가? double인가?
		//** 정수형 리터럴은 int이다.	> CPU 
		//** 실수형 리터럴은 double이다. > 정밀도가 높아서
		
		//실수형 리터럴(상수)는 float인가? double인가?
		
		//TODO 정밀도가 이해 안감
		//float > 단정도형
		float f1;
		
		f1 = 3.14F; //실수형 리터럴 표기법
		System.out.println(f1);
		
		//double > 배정도형
		double d1;
		d1 = 3.14;
		System.out.println(d1);
		
		
		f1 = 123.1234567890123456789012345678901234567890F; //소수이하 5자리 (손실분이 더 많음)
		d1 = 123.1234567890123456789012345678901234567890D; //소수이하 14자리
		
		System.out.println(f1); //123.12346
		System.out.println(d1); //123.1234567890125
		
		
		//long이 저장할 수 있는 데이터의 범위에 비해 훨씬 더 많음.
		
		//	 1.2345679 x 10^31
		//	 123456790000000000000000000000000000000	//손실이 많음.
		f1 = 123456789012345678901234567890123456789F;	//1.2345679E38
		
		//	 1.2345678901234568000000000000000000000	//float보단 손실이 적음.
		d1 = 123456789012345678901234567890123456789D;	//1.2345678901234568E38
		
		// 정수보다 표현할 수 있는 범위는 훨씬 많지만 손실이 발생하기 때문에 절대 잃으면 안되는 숫자를
		// 써야할 때는 무조건 정수형을 써야함. / 손실은 있어도 되지만 범위가 큰 숫자를 써야한다면 float이나 double
		
		
		System.out.println(f1);
		System.out.println(d1);
		
		
		//보통 실수형은 잘 사용 안한다. > 손실분 발생때문에 반드시 필요한 경우나 손실분이 미미한 경우에만 사용한다.
		
		
		//컴파일러는 기본적으로 어떤 단어가 오면 무언가의 식별자 혹은 예약된 키워드라고 판단함.
		
		//문자형
		
		char c1;
		c1 = 'A';	//문자형 상수(리터럴) 표기법 // ''는 데이터가 아니라 ''안에 있는 게 데이터라는 걸 알려주는 기능.
		System.out.println(c1);
		
		c1 = '가';
		System.out.println(c1);
		
		c1 = '@';
		System.out.println(c1);
		
		c1 = '1'; // '1'은 숫자가 아니라 문자로서의 '1'이다.
		System.out.println(c1);
		
		//c1 = '홍길동;'//char형은 반드시 1개의 문자만 저장할 수 있음. (2글자 이상x)
		//System.out.println(c1);
		
		char name1 = '홍';
		char name2 = '길';
		char name3 = '동';
		
		
		//논리형
		//-상수의 종류가 딱 2종류
		
		boolean flag;
		
		flag = true;	//논리형 리터럴(true)
		flag = false;	//논리형 리터럴(false)
		
		System.out.println(flag);
		
		
		//10
		//10L
		//3.4F
		//3.4
		//3.4D
		//'A'
		//true
		
		
		//문자열, String
		//-추가 자료형
		//-참조형에 속함
		//-문자의 열
		//-문자들이 열을 지어 있는 형태 > 문자의 집합 > char가 여러개 모여있는 형태
		
		
		String name;
		name = "홍길동"; // 문자열 리터럴(상수) 표기법
		System.out.println(name);
		
		
		//A -> 저장
		
		char m1 = 'A';
		String m2 = "A";
	
		//ABC -> 저장
		//char m3 = 'ABC';
		String m4 = "ABC";
	
		//보통 char보다 String을 많이 사용함.
		
		String m5 = "";	//0개의 문자열(공백x) > 빈문자열, Empty String
		
		//char m6 = '';	//빈문자 x char는 ''안에 무조건 뭔가가 들어가야 함.
		
		char m7 = '\0'; //빈문자(Null 문자)
		
		
		
		
		//9개의 자료형
		//값형(8개) + 참조형 (1개)
		
		
		//똑같은 값을 가지는 변수 2개 필요
		//int age = 30;
		//int copy = 30; -> 하나만 바꾸는 실수가 많음. 
		
		int age = 20;	//변수 = 값;
		int copy = age;	//변수 = 변수; > 변수 = 변수가 가지는 값
		
		//*** 변수끼리 값을 복사할 수 있음.
		
		
		//연산자 -> =(대입), + 
		
		int a1 = 10;
		int a2 = 20;
		int a3 = a1 + a2;			//산술 연산
		System.out.println(a3);
		
		String str1 = "홍길동";
		String str2 = "안녕하세요";
		String str3 = str1 + str2;	//산술 연산(x), 문자열 연산자 > Concat
		System.out.println(str3);	//홍길동안녕하세요.
		
		
		a1 = 100;
		a2 = 200;
		a3 = a1 + a2;
		
		//화면에 출력 > (결과만 출력하는게 아니라) 연산과정과 함게 출력시오.
		
		System.out.println("100 + 200 = 300");
		System.out.println("100 + 200 = "+ a3);	//산술 연산 vs 문자열 연산
		System.out.println(a1 + " + 200 = 300");
		System.out.println(a1 + " + " + a2 + " = " + a3);
		
		
		
		age = 20;
		
		//안녕하세요 저는 20살입니다.
		
		System.out.println("안녕하세요. 저는 " + age + "살입니다.");
	
		//식별자를 ""안에 넣으면 식별자가 아닌 그냥 문자가 된다. > 의미를 잃어버린다;;
		
		
		//숫자형 데이터를 저장할 변수를 만들 때 주의할 점!! (자료형 선택)
		//-수치로서의 데이터 > 더하기, 빼기를 한다 (가능)
		//-수치가 아닌 데이터 > 문자열로 취급!!
		
		//1. 몸무게 > 숫자
		int weight;
		weight = 70;
		
		//2. 주민등록번호 앞자리 (생년월일) > 숫자 x (더하기,빼기 안하니까)
		int jumin;	// 절대 금지!! 
		jumin = 951205;
		System.out.println(jumin);
		
		//3. 상품번호 > 얘도 숫자x 
		
		int productNo;
		productNo = 123;
		System.out.println(productNo);
		
		
		//2000년도에 태어난 아기
		//-2000-03-07
		jumin = 000307;	//1.000을 지워버림(int입장에선 쓸모없어서) 2.기수법 문제 -> 8진수 307을 10진수로 계산하면 199
		System.out.println(jumin);	//199
		
		//자바의 기수 표기법 / 2진수(BIN)
		//-데이터 표시는 아래와 같이 3개의 기수법을 제공한다.
		//-다만 출력은 기수법과 상관업싱 항상 10진수로 출력된다.
		
		//1. 10진수(DEC)	> 100 (일반적으로 사용하는 숫자)			>10	(읽을 땐 다 10으로 읽음)
		//2. 8진수(OCT)	> 0100 (10진수 100이 아닌 8진수 100)	>010	> 8
		//3. 16진수(HX)	> 0x100 (16진수 100) 					>0x10	> 16(f에서 올림)
		
		
		//상품번호, 주민번호, 전화번호 등 숫자처럼 생겼지만 계산하지 않는 숫자들은
		//되도록 숫자타입이 아닌 문자열로 만들어라
		
		
		String jumin1 = "000503";
		System.out.println(jumin1);
		
		
		
		
		//과제
		
		//구글드라이브 제출 폴더에 개인이름 폴더 안에 제출
		
		//- 초보자용 :)
		//- 각 자료형(9개) > 변수 10개씩 만들기 > 문장으로 출력하시오.
		//-자료형 + 변수 + 리터럴 + 출력 연습용
		
		//sample
		
		//1. 주변의 데이터 찾기 (아무거나) ex. 손가락 발가락 개수, 키, 나이, 몸무게, (가족수?), 좋아하는 색깔 등 
		//-만약 내 키가 180cm이야.
		//2. 1의 데이터가 자바의 어떤 자료형과 적합하는지 생각해보고 > 매칭 > 정수 vs 실수 + 길이 > double
		//3. 2의 자료형 > 변수 선언하기 > 의미있게 (이것도 연습해)
		//4. 3의 변수 > 데이터 대입 (자료형에 맞는 리터럴 표기법)
		//5. 출력 > 문장으로 만들어서 출력
		//-변수도 늘려보고 문장도 더 늘려보고 (시키는것만 해서는 실력 안늘어. 스스로 사고해서 더 추가해봐야 해)
		//-java파일을 통째로 올려주면돼 소스파일 원본을. (프로젝트가 아니라 소스 원본)
		
		//자료형마다 아래의 예제 10번씩. => 총 90개..
		double height = 180.5;
		System.out.println("제 키는 " + height + "cm입니다.");
		
		
		
		
		
	}
}
