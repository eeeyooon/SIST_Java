package com.test.java; //03.07

public class Ex06_Escape {
	
	public static void main(String[] args) {
		
		
		
		//내가 만든 프로그램을 다른 사람에게 주고 싶다!! > 배포
		//소스는 다른 사람한테 줄때 함부로 주면 안됨. 소스가 아닌 프로그램을 주는 방법.
		//자바의 기본 배포 단위 > 소스파일을 컴파일 결과물(*.class) > jar(러너블) > 자바 압축 파일
		/* (강의 다시봐 export)
		int age = 20;
		
		age = 20;
		
		System.out.println("안녕하세요. 저는 " + age + "살입니다.");
		*/
		
		
		
		//Ex06_Escape.java
		
		//특수 문자 > Escapes Sequence
		//-컴파일러가 번역을 할 때, 미리 약속된 표현을 만나면 그 표현을 바로 출력하지 않고, 약속한대로
		// 처리한 후에 출력하는 구성 요소
		//- 자료형이 바로 char
		
		
		//1. \n
		//- = new line, line feed
		//- 개행 문자
		
		char c1 = '\n';	// '\n'가 한 글자로 취급받음. (char) -> \ 뒤에 온 글자들은 한글자로 취급
		
		String str = "\n"; //문자열은 한글자도 ok, 여러글자도 ok. 그래서 쓰기 쉬운 문자열 사용.
		
		//문자열 맅터럴 안에는 엔터(개행)를 넣을 수 없음.
		
		
		//요구사항] "안녕하세요. 홍길동입니다." 출력해주세요.
		//수정사항] "안녕하세요.", "홍길동입니다." 각각 다른 라인에 출력해주세요.
		
		String msg = "안녕하세요.\n홍길동입니다.";
		System.out.println(msg);
		
		System.out.println();
		System.out.println();
		
	
		
		
		//2. \r
		//-carriage return
		//-커서(캐럿)의 위치를 현재 라인의 맨앞(첫번째 열)으로 이동
		//-키보드 > Home 키와 같다고 생각하면 됨.
		msg = "안녕하세요.\r홍길동";
		
		//실제 콘솔에서 출력 되는 것 :  홍길동세요. (덮어쓰기 모드로 동작함.)
		System.out.println(msg);
		
		
		//운영체제(os)
		//1. 윈도우:\r\n (이클립스 콘솔은 하나만 적어도 되지만 실제로는 둘 다 써야 엔터일 때가 있음)
		//2. 맥os :\r
		//3. 리눅스 :\n
		
		System.out.println("하나\r\n둘");	//나중엔 이렇게 둘다 써야하는 순간이 옴.
		System.out.println("하나\n둘");			
		
		
		//3. \t
		//-탭문자, tab
		//-탭이 뭐야?
		//-탭은 행동이 아니라 지표 : 이미 지정되어있는 탭들이 있고, 현재 위치에서 가장 가까운 탭으로 가라.는 명령어임.
		//-서식 작업(열 맞추기)
		
		msg = "하나\t둘\t셋\t넷";	//편집기상에서 탭문자 확인 쉬움 > 이 방식을 사용
		System.out.println(msg);
		
		msg = "하나  둘  셋  넷";	//편집기상에서 탭문자가 안보여서 잘 안씀.
		System.out.println(msg);
		
		
		//4. \b
		//-Backspace
		//-이클립스 콘솔에선 동작x
		
		msg = "홍길동\b입니다.";	//원래는 '홍길입니다.' 출력됨
		System.out.println(msg);
		
		
		//5. \",\',\\
		//-이미 무언가를 하는 문자들을 의미없게 만드는 역할.
		
		//요구사항] 화면 > 홍길동 : "안녕하세요."
		msg = "홍길동 : \"안녕하세요.\"";	//의미를 없애고 싶은 글자나 기호 앞에 \를 넣으면 의미없게 만듦.
		System.out.println(msg);
		
		
		//요구사항] 수업 폴더의 경로를 출력하시오.
		//C:\class\java
		
		String path = "C:\\class\\java";
		System.out.println(path);
		
		
		
		//과제하다가 쉽게 범하는 에러들~!
		
		//요구사항] 변수 2개, 숫자 대입, 더하기 연산 > 연산과정과 결과를 출력하세요.
		//10 + 20 = 30
		
		int a = 10;
		int b = 20;
		
		//System.out.println(a+b);
		
		//연산 방향(왼 -> 오른)
		System.out.println(a + " + " + b + " = " + a + b); //10 + 20 = 1020 이라는 이상한 값이 나옴.
		System.out.println(a + " + " + b + " = " + (a + b)); 	// -> 소괄호 : 연산자 우선순위를 높임.
		
		//a + " + " + b + " = " + a + b
		//"10 + " + b + " = " + a + b
		//"10 + 20" + " = " + a + b
		//"10 + 20 = " + a + b
		//"10 + 20 = 10" + b
		//"10 + 20 = 1020"
		
		
		
		//현재 num은 null 상태입니다.
		//현재 num은 null 값을 가집니다.
		//현재 num은 초기화되어 있지 않습니다.
		
		//int num;	//NULL 상태 > 변수는 NULL상태로는 아무것도 못함.
		
		//int reseult = num + 100;	//100 + NULL? (0 아님. 0도 데이터가 있는 것.)
		
		//The local variable num may not have been initialized -> 변수 num이 초기화 되지 않았대
		//System.out.println("숫자 : " + num);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
