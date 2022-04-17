package com.test.java; //3.18

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex25_array {

	public static void main(String[] args) throws Exception {
		
		//Ex25_array.java
		
		/*
			//계속 연습해야해. 배열을 연습하려면 제어문을 연습할 수밖에 없음.
			배열, Array
			- 자료형
			- 집합 자료형 > 데이터를 여러개 저장할 수 있는 자료형
			- 같은 자료형을 저장하는 집합 > 같은 자료형 변수들의 집합
		
		*/
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		//m10();
		m11();
		
		
		// 2시에 코드리뷰 바로 하자. (1시간 30분) 
		// 3시 30분 : 보충 수업 (배열) > 문제풀이
		// 이후 : 배열 문제 풀이
		// 오늘 과제는 오늘 안에 못 풀거임. ㅠ ㅠ ㅠ ㅠ ㅠ ㅠ ㅠ
		
		
		
	}//main

	private static void m11() {
		
		//1~10 사이의 난수
		int[] ns = new int[10];
		
		for (int i=0; i<ns.length; i++) {
			
			ns[i] = (int)(Math.random() * 10) + 1; //0~9까지만 나오니까 +1
			
		}

		//배열 안의 상태가 궁금 > 확인 작업 !
		for (int i=0; i<ns.length; i++) {
			
			System.out.println(ns[i]);
		}
		
		printArr(ns);
		System.err.println(dump(ns)); //err이 뭐야? 형광색?
		
		//배열의 작업을 도와주는 클래스 > Arrays
		System.out.println(Arrays.toString(ns)); //return값 String
		//덤프 메소드 >> 배열 상태 확인용으로 사용!!! 자주 씀. *** 문제 풀때 필요함.
		
		
		
	}
	
	//배열의 상태를 문자열로 바꿔서 반환 > 덤프(Dump)라고 함. = 상황에 따라 뜻이 조금씩 다르지만 이 상황에도 적용
	// dump메소드 라고 부름.
	public static String dump(int[] ns) {
		
		String txt = "[";
		
		for (int i=0; i<ns.length; i++) {
			txt += ns[i] + ",";
		}
		
		
		txt += "]";
		
		return txt;
		
		
	}

	private static void m10() {
		
		//배열 초기화 리스트
		
		int[] ns1 = new int[5];
		
		printArr(ns1); //자동 초기화
		System.out.println();
		
		//수동 초기화
		ns1[0] = 100;
		ns1[1] = 90;
		ns1[2] = 80;
		ns1[3] = 70;
		ns1[4] = 60;
		printArr(ns1); //사용자 초기화
		System.out.println();
		
		int[] ns2 = new int[] {100, 90, 80, 70, 60}; //초기화 리스트
		printArr(ns2);
		System.out.println();
		
		int[] ns3 = {100, 90, 80, 70, 60}; //초기화 리스트 -> 가장 단축할 수 있는 방법
		printArr(ns3);
		System.out.println();
		
		
		String[] name1 = new String[3];
		
		name1[0] = "홍길동";
		name1[1] = "아무개"; // -> 얜 for문 돌릴 수 있음. 정석으로, fm돌릴때 
		
		String[] name2 = new String[] {"홍길동", "아무개", "하하하" }; //배열길이 안에 숫자 넣으면 x -> 얜 for문 못돌림. 적은양 가볍게할땐
		
		
		
		
		
	}

	private static void m9() {
		
		//배열의 생성 직후 상태
		
		//int a; //null상태
		//System.out.println(a);
		
		int[] ns = new int[3];
		System.out.println(ns[0]); // 0 출력
		System.out.println(ns[1]);
		System.out.println(ns[2]);
		
		//배열 자동 초기화
		//배열(모든 참조형)은 값형과 다르게 생성 직후에 사용자(개발자)가 아무것도 안해도 자동으로 초기화.
		
		//규칙
		//1. 정수배열 -> 0
		//2. 실수배열 -> 0.0
		//3. 문자배열 -> \0 (null)
		//4. 논리배열 -> false
		//5. 참조형배열 -> null
		
		
		double[] ns2 = new double[3];
		System.out.println(ns2[0]);
		
		boolean[] ns3 = new boolean[3];
		System.out.println(ns3[0]);
		
		String[] ns4 = new String[3];
		System.out.println(ns4[0]);
		
		
		
	}

	private static void m8() {
		
		//배열 복사
		//1. 얕은 복사, Shallow Copy > copy = ns; 
		//	- 주소값 복사
		//	- side Effect 발생
		
		//2. 깊은 복사, Deep Copy
		// 대부분은 얕은 복사만으로 충분하나 가끔 깊은 복사가 필요할 때가 있음.
		//- 요소끼리 복사 > 값 복사
		//- Side Effect 발생 X
		
		//개발자가 직접적으로 건드릴 수 있는 공간은 Stack뿐. (Heap을 가고 싶어도 우선 Stack을 가서 Stack을 통해 갈 수 밖에 없음)
		// 수면을 얘로 들면 Stack은 수면 바로 밑이라 직접 닿고 보임. Heap은 더 깊게 있음.
		// >> Stack에서 일어나는 복사 = 얕은 복사 / Heap에서 일어나는 복사 = 깊은 복사.
		
		//깊은 복사
		int[] ns = new int [3];
		
		ns[0] = 10;
		ns[1] = 20;
		ns[2] = 30;
		
		int[] copy = new int[3];
	
		for (int i=0; i<ns.length; i++) {
			//int = int >> 값형 복사
			copy[i]  = ns[i]; //첫번째 방부터 마지막 방까지 복사. 둘다 int
			
		}
		
		ns[0] = 100;	//Side Effect 발생 X
		
		printArr(ns);
		System.out.println();
		
		printArr(copy);
		
		
		//얕은 복사
//		int[] ns = new int [3];
//		
//		ns[0] = 10;
//		ns[1] = 20;
//		ns[2] = 30;
//		
//		int[] copy; // = new int[3]; > 복사할땐 Heap가지도 않으니까 꼭 공간 만들필요x
//		
//		//copy = ns;
//		//ns[0] = 100;
//		
//		
//		
//		
//		printArr(ns);
//		System.out.println();
//		
//		printArr(copy);
		
	}
	
	public static void printArr(int[] ns) { //변수로 만들 수 있는 건 모두 다 매개변수도, 반환값도 가능
		
		for (int i=0; i<ns.length; i++) {
			System.out.printf("%d: %d\n" , i, ns[i]);
		}
		
		
	}
	private static void m7() {
		
		//배열 복사(= 참조형 복사)
		
		//복사
		//1. 값형 복사
		//2. 참조형 복사 (오늘 배우는 내용을 적용해야해)
		
		// 메모리에는 Stack / Heap (11시수업)
		//우리가 배운 지역 변수는 모두 Stack에 저장됨.
		//오늘 배울 내용은 Heap에 저장. (Managed Heap)이라고도 함.
		//공간 안에는 공간을 넣을 수 없음. 그래서 Stack 안에도 ns배열 그대로 (상자그림) 못들어감. 
		//Stack에 ns배열 공간이 생김. (int[]ns)  Heap 어딘가에 int 변수 3개가 연속적으로 생김. > 무슨일이 있어도 연속으로 할당됨. >new int[3];
		//ns배열 안에 그 연속적으로 할당된 공간을 넣는다? > 안된다니까 >> 그래서 ns배열에 그 연속적으로 할당된 공간의 "주소"를 넣음.
		// ns배열 변수가 그 값이 있는 위치를 기억하기 위해 '번지수'를 넣는 것임. 연속적으로 저장되어있으니 제일 첫번째 번지수를 저장.
		
		//a안에는 데이터, 즉 값 10이 들어있음. >> 그래서 값형이라고함. (Value Type) = 공간자체가 데이터를 가지고 있음.
		int a = 10;
		int b;
		
		
		//값형의 복사 > 공간이 가지는 값을 복사한다.
		b = a;
		
		//원본 수정 > 복사본은 영향 없음. > Side Effect가 발생하지 않음. (관계 맺은 애한테 추가적인 영향을 미치지x)
		a = 20;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		
		//ns안에는 실제 배열의 주소값이 들어있음. >> 그래서 참조형이라고함. (Rerference Type) 
		// = 변수 안에 데이터가 없는 대신에 Heap에 항상 데이터가 존재하고, 그 주소값을 가지고 있음. 
		// > 우리가 ns를 찾았을 때 ns가 가지고 있는 다른 공간의 주소(ex300번지)를 가지고 그 공간을 찾아감 >> 이걸 "참조(Rerference)"라고 함.
		int[] ns = new int[3];
		
		ns[0] = 10;
		ns[1] = 20;
		ns[2] = 30;
		
		int[] copy = new int[3];
		
		//int[] = int[] > 둘다 int배열 (자료형이 같으면 복사 가능)
		//참조형 복사 > 주소값을 복사한다.
		copy = ns; //Heap에 있는 값을 복사한게 아니라 주소값을 복사한 것!
		
		//원본 수정 > 복사본 영향 있음 > Side Effect가 발생함 > 주의해야 해 ******
		ns[0] = 100;
		
		
		
		System.out.println(ns[0]);
		System.out.println(copy[0]);
		
		//copy한 후 ns[0]가 바뀐건데도 copy[0]도 같이 바뀜.
		// Heap에서 copy가 일어나는게 아니라, ns에 있는 주소값이 copy에 복사된 것.
		
		
		//String name = "홍길동"; //얘도 홍길동이 있는 공간의 주소를 가지고 있음. 
		
		
		
		
		
		
	}

	private static void m6() throws Exception {
		
		//프로그램을 만들 때 > 메모리에 공간을 할당받음 > 변수 생성
		//*********** 메모리 할당 받은 공간의 크기는 불변이다. **************
		//******** 배열의 길이는 불변임. >> 소스를 고친다는게 아니라 프로그램이 완성되고 난 이후를 말하는 것.
		
		//컴파일이 끝나고 프로그램으로 만들어짐. 그럼 더이상 저 숫자를 고칠 수 없음. 
		//그런데 프로그램 내에서 어떤 방법이나 행동을 해서라도 고칠 수 있냐? > 없음.
		//but 이걸 할 수 있는 프로그래밍 언어들이 있음. (근데 자바는 아님 ㅋ)
		
		
		//성적 처리 프로그램
		//- 배열의 길이? > 교장 선생님한테 물어봐야지 ㅎ > 학생수 : 300 -> 전학생 올 수 있으니 300으로 제한 하면 안돼.
		//- 요구사항 설계할 때 현재 인원수 / 전년도 전전년도 전학생 수 비교 > 그 중 최대치로 (역대 최다 전학생수 20)
		// >> 그러면 320~330명으로 제한두자. (전학생 올 것까지 염려 + 너무 낭비되지 않게 = 예측 데이터의 최대치 가까이. )
		
		//자바의 배열은 길이는 불변이지만, 동적할당은 가능하다. 
		
		// 이건 정적할당 > 컴파일할 때 이미 배열의 길이가 정해짐.
		int[] nums = new int[3];
		
		//동적할당 ? > 컴파일때는 배열의 길이를 모름. > 런타임때 정해짐.
		//언제 ? int[] nums2 = new int[?]; > '?' 부분이 사용자의 입력값에 넣으려고 할 때.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("배열 길이: ");
		int length = Integer.parseInt(reader.readLine());
		
		int[] nums2 = new int[length]; //이게 동적할당.
		
		System.out.println(nums2.length);
		
		//사용자가 5입력하면 배열의 길이 5로 정해짐 -> 이 뒤로도 역시 바꿀 수 없음.
		
		
	}

	private static void m5() {
		
		//각 자료형을 배열로 만들어보자 
		
		//정수 배열(byte, short, int, long)
		byte[] list1 = new byte[3];
		list1[0] = 10; //byte배열의 방 하나 = byte변수 그 자체
		System.out.println(list1[0]);
		
		long[] list2 = new long[3];
		list2[0] = 1000000000000L;
		System.out.println(list2[0]);
		
		
		//실수 배열(float, double)
		double[] list3 = new double[3];
		list3[0] = 3.14;
		System.out.println(list3[0]);
		
		//문자 배열(char)
		char[] list4 = new char[3];
		list4[0] = 'A';
		System.out.println(list4[0]);
		
		//논리 배열(boolean)
		boolean[] list5 = new boolean[3];
		list5[0] = true;
		System.out.println(list5[0]);
		
		//문자열 배열, 참조형 배열 
		String[] list6 = new String[3];
		list6[0] = "홍길동";
		System.out.println(list6[0]);
		
	}

	private static void m4() {
		
		int[] kors = new int[3];
		
		kors[0] = 100;
		kors[1]	= 90;
		kors[2]	= 80;
		
		//kors[3]	 = 70;	//실수로 한명을 더 넣음. -> error X > 컴파일 오류가 아닌 것. >> 얘는 런타임 오류임.
		//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
		// ArrayIndexOutOfBoundsException -> 배열의 인덱스가 범위를 넘었습니다. *
		// 3번 방 없는디요?;
		// 에러노트에 넣기 ~ ^ㅇ^ //TODO error note 넣기 (2022. 3. 18. 오전 10:27:02)
		
		//kors.length말고 상수를 직접 넣는 경우
		for (int i=0; i<3; i++) {
			System.out.printf("kors[%d] = %d\n", i, kors[i] ); //현재 내가 만든 배열의 상태 확인 가능 
		}
		// 실수로 i<=3 or i<4 이렇게 범위를 틀려버리면 오류남.
		// IndexOutOfBounds error 발생 >> 그니깐 걍 바로 length 쓰삼.
		
		
		
		
	}

	private static void m3() {
		//- int[] > int 배열
		//- kors > 변수명, 배열명
		//- new > 객체 생성 연산자
		//- int[3]	> 3 > 배열의 길이 > 변수의 개수
		int[] kors = new int[3];
		
		// 물리적으론 변수가 맞지만 자바에서는 프로퍼티(Porperty) / 필드(field)라고 불림.
		//배열의 길이 == 방의 개수
		System.out.println(kors.length); // 3
		
		
		int index = 0;
		
		kors[index] = 100; //배열 0번째 방에 100을 넣어라
		
		index++;
		
		kors[index] = 90; //배열 1번째 방에 90을 넣어라
		
		
		//배열 방 > 요소(Element)
		//배열 방번호 > 첨자(Index)라고 함.
		//자바 배열의 방번호는 0부터 시작한다. > Zero-based Index
		//0부터 시작하는 for문은 배열에 바로 써먹기 좋음 > 그래서 주로 for문을 돌릴 땐 습관적으로 0부터.
		
		//루프 변수(i)의 변화 = 배열의 방번호 변화
		//이런 for문을 배열의 탐색이라고 함.
		for (int i=0; i<kors.length; i++) {
			
			kors[i] = 100;
			
		}
		
		int total = 0;
		
		for (int i=0; i<kors.length; i++) {
			total += kors[i];
		} //학생 수가 늘어나도 이 부분은 수정할 필요 x
		
		
		double avg = (double) total / kors.length;
		
		
		
		
	}

	private static void m2() {
		
		//요구사항] 학생 3명 > 국어 점수 > 총점, 평균
		
		//1. 배열 선언하기(생성하기)
		//- 자료형[] 변수명 = new 자료형[길이]; *(길이 = 방의 개수)
		//2. 배열 사용하기(입/출력)
		
		
		int n = 10;
		
		//같은 자료형을 가진 변수들의 집합 = 배열
		//kors는 집합의 이름이지 변수 개개의 이름은 아님.
		//kors의 자료형? int[]입니다. > 읽을 때 : int 배열입니다.
		//kors[0]의 자료형? int
		//int [] kors = new int[3]; //> int변수를 3개 만들어라.
		
		//변수 300개?
		int[] kors = new int[300];
		
		kors[0] = 100;
		kors[1] = 90;
		kors[2] = 80;
		//..
		kors[299] = 100; 
		//지금은 하나하나 다 넣어야 함. -> 나중엔 쉽게 가능 //TODO 배열 안에 다른 변수 넣기 배운 후 (2022. 3. 18. 오전 9:46:42)
		
		int total = kors[0] + kors[1] + kors[2]; //+ kors[3] +...+kors[297] -> 이것도 나중엔 노가다 안해도됨.
												 //데이터가 들어간 자리에 ([]) 다른 변수 넣을 수 있음.
		//double avg = total / 3.0;
		double avg = (double) total / kors.length; //배열의 길이(방의 개수 = 즉, 학생 수 300명) > 배열의 길이가 계속 변해도 수정할 필요 없음.
		
		System.out.printf("총점: %d점, 평균: %.1f점\n", total, avg);
		
		
	}

	private static void m1() {
		
		//**** 같은 성격의 데이터를 여러개 취급하는 상황 ( 같은 성격? > 데이터의 성격(국어점수), 자료형(int)
		
		//요구사항] 학생 3명 > 국어 점수 > 총점, 평점 구해라
		//추가사항] 학생 수 증가 > 300명
		
		int kor1; 
		int kor2;
		int kor3;
		
		kor1 = 100;
		kor2 = 90;
		kor3 = 80;
		
		int total = kor1 + kor2 + kor3;
		double avg = total / 3.0;
		
		System.out.printf("총점: %d점, 평균: %.1f점\n", total, avg);
		
		
	}
	
	
	
	
}
