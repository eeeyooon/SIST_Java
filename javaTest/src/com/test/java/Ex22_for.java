package com.test.java; //03.16

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex22_for {

	public static void main(String[] args) throws Exception {
		//Ex22_for
		
		/*
			반복문
				- 특정 코드를 개발자가 원하는 횟수만큼 반복 실행한다.
				- 생산성 향상 + 유지보수성 향상
				
				
				
			for (초기식; 조건식; 증감식) {
				실행문;
				
			}
		
		
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
		//m11();
		//m12();
		//m13();
		m14();
		
	//m13, m14 조졌음 ㅠ 다시 공부해 선생님 코드보면서
		
	}//main
	
	
	private static void m14() {
		
		//달력 만들기
		
		//1. 해당 월의 마지막일 ? 31일까지 //getlastday
		//2. 해당 월의 1일이 무슨 요일인지 > 화요일 //m13에서 date를 1로
		
		int year = 2022;
		int month = 3;
		
		int lastDay = getLastDay(year, month);
		int dayOfWeek = getDayOfWeek(year, month); //7로 나눴을 때 나머지가 2
		
		System.out.println("=====================================================");
		System.out.printf("                     %d년 %d월\n", year, month);
		System.out.println("=====================================================");
		System.out.println("[일]\t[월]\t[화]\t[수]\t[목]\t[금]\t[토]");
		System.out.println("=====================================================");
		
		for (int i=0; i<dayOfWeek; i++) {
			System.out.print("\t");
		}
		
		//여기서부터 뭔가 실수했는데... ㅠ 달력 이상해
		
		
		for (int i=1; i<=lastDay; i++) {
			System.out.printf(" %2d\t", i);
			
			//토요일 개행
			if ((i + dayOfWeek) % 7 == 0) {
				System.out.println();
			}
		}
		
		
	} //m14
	
	
	private static int getDayOfWeek(int year, int month) {
		
		int total = 0;
		int date = 1;
		
		for (int i=1; i<year; i++) {
			total += 365;
			

			if (isLeafYear(i)) {
				total++;
				
			}
			
		}
		for (int i=1; i<month; i++) {
			
			total += getLastDay(year, i);
		}
		
		total += date;
		
		
		
		return total % 7;
		
		
	}


	private static void m13() {
		
		//Q08. 서기 1년 1월 1일부터 오늘까지 며칠째인지 합을 구하시오.
		//1년 = 365일
		
		int total = 0;
		int year = 2022;
		int month = 3;
		int date = 17;
		
		//1년 1월 1일 ~ 2021년 12월 31일까지만 구하자.
		//2021 x 365 하면 구할 수 있지만 윤년이 있으니 윤년을 체크해야 함.
		
		
		for (int i=1; i<year; i++) {
			total += 365;
			
			//현재 i가 윤년인지 검사
			//> 메소드로 빼자
			
			if (isLeafYear(i)) {
				total++;
				
			}
			
		}
		
		//2022sus 1월 1일 ~ 2022년 2월 28일
		for (int i=1; i<month; i++) {
			
			total += getLastDay(year, i);
		}
		
		//2022년 3월 1일 ~ 2022년 3월 17일
		total += date;
		
		
		//서기 1년 1월 1일은 > 월요일
		//특정 날짜의 요일? > 기준일 + 기준일 요일 + 기준일부터 특정 날짜의 날짜 합
		
		
		System.out.printf("%d년 %d월 %d일은 %,d일째 되는 날이고 %s요일입니다.\n"
																		, year
																		, month
																		, date
																		, total
																		, get_day(total));
		
		
		
	}
	
	
	public static String get_day(int date) {
		
			if (date % 7 == 1) {
				return "월";
			} else if (date % 7 == 2) {
				return "화";
			} else if (date % 7 == 3) {
				return "수";
			} else if (date % 7 == 4) {
				return "목";
			} else if (date % 7 == 5) {
				return "금";
			} else if (date % 7 == 6) {
				return "토";
			} else {
				return "일";
			}
	}
	
	
	private static int getLastDay(int year, int month) {
		
		
			
			switch (month) {
				case 1: 
				case 3: 
				case 5:
				case 7: 
				case 8: 
				case 10:
				case 12: 
					return 31;
				case 2:
					return isLeafYear(year) ? 29 : 28;
				case 4: 
				case 6: 
				case 9: 
				case 11:
					return 30;
			}
		
		return 0;
	}
	

	public static boolean isLeafYear(int year)	{
		
		if (year % 4 ==0 ) {
			
			if (year % 100 == 0) {
				
				if (year % 400 == 0) {
					return true;
				}
			} else {
				return true;
				
			}
		} else {
			return true; 
		}
		return false; //이부분 쌤 코드 다시 확인하기
		
		
	}
	
	
	
	
	
	//javatest > bin까지가 가서 콘솔(명령 프롬포트) 열어야함. (꼭 bin까지 가서 열어야 함.)
	//C:\class\java\JavTest\bin>java.exe co.m.test.java.Ex22_for
	//\b : backspace (이클립스 콘솔엔 x)
	private static void m12() {
		
		
		//Q7. 누적값이 1000을 넘어가는 순간 루프를 종료하시오.
		
		//1. 누적 변수 생성
		//2. 루프 생성
			//2.1 값 누적
			//2.2 값 출력
			//2.3 조건 > 누적값이 1000이상인지 확인 > 그땐 break
		//3. 출력
		
		int sum = 0;
		for (int i=1; ; i++) {
			
			System.out.printf("%d + ", i);
			
			if (sum > 1000) {
				break;
			}
		}
		
		//sysf 백스페이스써서 있음.
		
		
	}
	
	
	private static void m11() {
		
		//for문은 아닌데 문제풀때 필요해서 알려줌.
		//난수 , Random
		//- 임의의 수
		
		//1. Math.random()
		//2. Random 클래스
		//0~ 0.9999999999999
		//0이상 1미만의 값
		
		// System.out.println(Math.random());
		
		//1~10 사이의 난수
		//int num = (int)(Math.random() * B) + A ;
		//int num = (int)(Math.random() * 7) + 3 ;
		//A : 최소값 //3
		//A + B -1 : 최대값 //9
		
		for (int i=0; i<10; i++) {
			
//			int num = (int)(Math.random() * 10) + 1; //1을 더한 이유는 그 전엔 0~9까지만 있어서
			int num = (int)(Math.random() * 7) ; //곱한 수(7)는 바로 최대값 직전까지임. So, 최대값은 6. 여기에 + 3하면 0~9
			
			System.out.println(num);
		}
		
	}
	
	
	private static void m10() {
		
		//9번과 같은 예제를 Calendar로 해보기
		//2022년 3월 1일 ~ 3월 31일까지 날짜 출력
		
		//2022년 3월 1일 화요일 > 시작 날짜를 Calendar로 만들어.
		//2022년 3월 2일 수요일
		//2022년 3월 3일 목요일
		//...
		//2022년 3월 1일 목요일

		
		Calendar c1 = Calendar.getInstance();
		
		c1.set(2022, 2, 1); //2022년 3월 1일
		
		//c1이 속해있는 월의 최대값을 가져와라 > 마지막 날짜를 가져와라. 
		System.out.println(c1.getActualMaximum(Calendar.DATE));
		int lastDay = c1.getActualMaximum(Calendar.DATE); //조건식에 넣으면 여차 저차해서 이게 c1이 2월에서 3월로 변하고 3월의 
														  //최댓값이 31까지니까 두번 더 출력돼서 3월 1일 / 3월 2일까지 나오는 것
		for (int i=1; i<=lastDay; i++) {
			
			System.out.printf("%d년 %d월 %d일 %tA\n"
					, c1.get(Calendar.YEAR) 
					, c1.get(Calendar.MONTH) + 1 
					, c1.get(Calendar.DATE)
					, c1);
			
			c1.add(Calendar.DATE, 1); //루프 한바퀴당 > 1일 증가
			
		}
		
	}
	
	
	
	private static void m9() {
		
		
		//2022년 3월 1일 ~ 3월 31일까지 날짜 출력
		
		//2022년 3월 1일 화요일
		//2022년 3월 2일 수요일
		//2022년 3월 3일 목요일
		//...
		//2022년 3월 1일 목요일
		
		for (int date=1; date<=31; date++) {
			
		//(서기문제때문에 잠시 주석)	String day = getDay(date);
			
			//if값을 밑에 getDay메소드로 빼냄. (refactor에서 추출할 수 있음)
			
			System.out.printf("2022년 03월 %02d일 요일\n", date);
			
			//여기도 졸지에 오류남 %s 지우고 뒤에 day 지움 ㅠㅠ  ******
		}
		
		
	} //코드량은 비슷해도 이렇게 메소드를 빼놓으면 코드가 간결해지고 보기 깔끔함.
	
	//error. This method must return a result of type String 
	//모든 경우의 수를 따졌을 때 return문이 존재하지 않는 경우도 있음.
	public static String getDay(int date) {
		
		if (date % 7 == 1) {
			return "화";
		} else if (date % 7 == 2) {
			return "수";
		} else if (date % 7 == 3) {
			return "목";
		} else if (date % 7 == 4) {
			return "금";
		} else if (date % 7 == 5) {
			return "토";
		} else if (date % 7 == 6) {
			return "일";
		} else if (date % 7 == 0) {
			return "월";
		}
		
		//return X인 경우도 추가
		return " "; //return null;
		
		//or if문 마지막인 else if (date % 7 == 0) 얠 그냥 다 지우고 else로 해서 return "월";
		
	}//getDay()
	
	private static void m8() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int sum  = 0;
		
		//짝수만 누적
		
		for (;;) {
			
			System.out.println("숫자: ");
			
			int num = Integer.parseInt(reader.readLine());
			
			if (num == 0) {
				break;
			}
			
//			if (num % 2 == 1) {
//				
//				continue; //홀수일 땐 누적합산하지말아라.
//			}
			
			if (num % 2 == 0) {
			
				sum += num;
			
			}
		
		}
		System.out.println("최종 합: " + sum);
}
	
	private static void m7() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//사용자 입력 숫자 > 누적 > 횟수 사용자 마음대로 // 0이면 종료
		int sum = 0;
		
		for (;;) {
			
			System.out.print("숫자: ");
			
			int num = Integer.parseInt(reader.readLine());
			
			if (num == 0) {
				break;
			}
			
			sum += num;
		}
		System.out.println("최종 합: " + sum);
		
	} //m7
	
	
	
	private static void m6() {
		
		//무한 루프, infinite loop (엄밀히 따지면 이 예제는 유한 루프임. 멈추긴 함. int 범위까지만 // 약 21억 바퀴)
//		for (int i=0; i<10; i--) {
//			System.out.println("안녕하세요");
//		}
		
		
		//무한 루프를 일부러 만들기
//		for (;;) {	// 항상 참. =무조건 true
//			System.out.println("무한 루프");
		
//		for (int i=0; ; i++) {	//조건식만 안적음 -> 무한루프. 1이 증가하다가 21억까지 찍고, 그 순간 음수로 바뀜 그래서 또 -21까지 x무한
//								//무한 루프 + 루프 변수 활용
//								//조건식에 true 적는 사람도 O . (안적어도 되는데 그냥 확실히 알려고)
//			System.out.println(i);
//		
//		}
		
		
//		//b.무한루프엔 문법적으로 코드를 작성할 수 없음.
//		//다만 if문 + break 작성하면 무한루프 탈출가능
//		for (int i=0; ; i++) {	
//			
//			System.out.println(i);
//			
//			if (i > 100000) {
//				break;
//			}
//
//		}
//		System.out.println();
		
		
		
		//a.루프 탈출하는 방법
		for (int i=1; i<=10; i++) {
			
			System.out.println(i);
			
			if (i == 5) {
				break;	//if문을 제외한 나머지 제어문을 탈출하는 역할. (하던 일을 멈추고 break가 포함된 제어문(if문 예외)을 빠져나감.)
		
			}
		}
		System.out.println();
		
		
		
		for (int i=1; i<=10; i++) {
			
			if (i == 5) {
				continue;	//for문에 대해서 동작. (if문에 동작x -> 예외) : 하던 일을 멈추고 제어의 처음으로 돌아가세요.
			}
			
			System.out.println(i);
		}
		
		
	}//m6
	
	
	private static void m5() throws Exception {
		
		//구구단 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("단: ");
		
		int dan = Integer.parseInt(reader.readLine());
		
		//출력 : 5 x 1 = 5
		//		5 x 2 = 10
		//			...
		//		5 x 9 = 45
		
		for (int i = 1; i<10; i++) {
			System.out.printf("%d x %d = %2d\n", dan, i, dan * i);
		}
		
		
	}
	
	
	
	private static void m4() throws Exception {
		
		//요구사항] 사용자 숫자 입력 > x10번 입력 > 숫자의 합

		
		
		//요구사항] 1~10까지의 합
		//1 + 2 + 3 + 4 + ...
		
		int sum = 0; 	//누적 변수(반드시 0으로 초기화) *******
		
		for (int i=1; i<=10; i++) {
			sum = sum + i;
			//sum = 0 + 1					 = 2
			//sum = 0 + 1 + 2;				 = 3	
			//sum = 0 + 1 + 2 + 3;			 = 6
			//sum = 0 + 1 + 2 + 3 + 4;		 = 10
			// ...	
			//sum = 0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
		}
		System.out.println(sum);
		
		
		
		//요구사항] 사용자 숫자 입력 > x10번 입력 > 숫자의 합

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		sum = 0;
		
		for (int i=0; i<10; i++) {
			System.out.print("숫자: ");
			int num = Integer.parseInt(reader.readLine());
			sum += num;
		}
		
		System.out.println(sum);
		
		
	}
	
	private static void m3() {
		
		//반복문 사용 이유
		//1. 반복하기 위해
		//2. 루프 변수를 사용하기 위해서(*******) > 연습 필요!! >> 수열 생성
		
		
		//요구사항] 숫자 1~10까지 출력
		//1.
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("4");
		System.out.println("5");
		System.out.println("6");
		System.out.println("7");
		System.out.println("8");
		System.out.println("9");
		System.out.println("10");
		
		//2.
		int num = 1;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println();
		
		//3.
		for (int i=1; i<=10; i++) {
			System.out.println(i);
		}
		System.out.println();
		
		
		//
		for (int i=1; i<=10; i=i+2) {	//1~10사이에 홀수만 출력
			System.out.println(i);
		}
		System.out.println();
		
		for (int i=2; i<=10; i=i+2) {	//1~10사이에 짝수만 출력
			System.out.println(i);
		}
		System.out.println();
		
		
		for (int i=7; i<=100; i=i+7) {	//1~100사이에 7의 배수만 출력
			System.out.println(i);
		}
		System.out.println();
		
	}
	
	
	private static void m2() {
		
		//반복문을 보면 > 몇회전을 하는지부터 계산해야 함.
		for (int i=0; i<5; i++) {
			
			System.out.println("실행문");
		}
		System.out.println();
		
		for (int i=3; i<=7; i++) {
			
			System.out.println("실행문");
		}
		System.out.println();
		
		for (int i=10; i>5; i--) {
			System.out.println("실행문");
		}
		
	}//m2
	
	private static void m1() {
		
		//요구사항] "안녕하세요" x 5 출력
//		hello();
//		hello();
//		hello();
//		hello();
//		hello();
		
		//hello()를 for문으로 할수도 있음.
		for (int i=1; i<=5; i++) {
			hello();
		}
		System.out.println();
		
		
		
		//int i=1; 	//초기식, for문에 처음 진입할때 딴 1회만 실행한다.
		//i<-5; 	//조건식, 반복 유무를 결정한다.
		//i++;		//증감식, 조건식의 변화를 유발한다.
		
		//반복문 > loop라고함. (= iteration) > i > = 루프 변수 (관습적으로 i를 씀. integer의 i)
		for (int i=1; i<=5; i++) {
			System.out.println("안녕하세요.");
			
		}
		
		
	}
	
	public static void hello() {
		System.out.println("안녕하세요.");
	}
	
	
}//class






