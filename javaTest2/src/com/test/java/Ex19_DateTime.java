package com.test.java; //03.14~03.15

import java.util.Calendar;
import java.util.Date;

public class Ex19_DateTime {

	public static void main(String[] args) {
		
		//Ex19_DateTime.java
		
		
		/*
		
			자바의 자료형
			1. 원시형(값형)
				- byte, short, int, long
				- float, double
				- char
				- boolean
				
			2. 참조형
				- 클래스
				- String
				- 날짜시간
				
				
				
			자바의 날짜시간 자료형
			1. Date 클래스 > 거의 안씀.
			2. Calendar 클래스 > 현역.
			3. 추가 클래스 > 현역.
		
			
			A. 시각
			B. 시간
			
			2022년 3월 14일 오후 4시 22분 27초 > 시간 vs 시각? > 시각
			
			8시간 수업 > 시간 vs 시각 > 시간
			
			자료형의 시각 > 둘은 완전 다른 자료형
			
			시각, 시간 > 연산 
			
			특정 기준일(1970년 1월 1일 0시 0분 0초로 기준 -우리가 배우는 언어는 대부분 다 여기 /서기 1년 1월 1일 자정을 기준으로 잡는 언어들도 있음.)로부터 
			해당 시각이 얼만큼 흘렀는지 구한 누적 시간 -> 틱(tick)값, Epoch Time //TimeStamp도 종종 쓰는 용어
			시각 + 시각 = 2022-03-01 + 2025-05-10 > X
			시각 - 시각 = 2025-05-10 - 2022-03-01 = O '시간'이 나옴.
			
			시간 + 시간 = 0(시간), 8시간 + 2시간 = 10시간
			시간 - 시간 = 0(시간), 8시간 - 2시간 = 6시간
			
			시각 + 시간 = 0(시각), 2022-03-01 + 5일 = 2022-03-06
			시각 - 시간 = 0(시각), 
			
			
		
		*/
		
		//m1(); //두번째 예제할땐 얠 주석처리, 보고싶으면 m2 주석 처리하고 얘 주석 제거.
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		m7();

		
	}//main
	
	
	private static void m7() {
		
		//현재 시각의 tick
		Calendar now = Calendar.getInstance();
		System.out.println(now.getTimeInMillis());
		
		//전용 메소드
		System.out.println(System.currentTimeMillis()); //이게 바로 위의 두 문장과 같은 문장.
		
	}
	private static void m6() {
		
		//1. 현재 시각 만들기 		> getInstance() + get()
		//2. 특정 시각 만들기 		> set()
		//3. 시각 + 시간 = 시각		> add()
		//4. 시각 - 시간 = 시각		> add()
		//5. 시각 - 시각 = 시간		> getTimeInMills()
		//6. 시간 + 시간 = 시간		
		//7. 시간 - 시간 = 시간		
		
		
		
		//2시간 30분 + 10분 = 2시간 40분
		
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.HOUR, 2);
		c1.set(Calendar.MINUTE, 30);
		//이건 2시간 30분 아니야. 이건 시각임. 2시 30분.
		
		//시간을 취급하는 특정 자료형은 존재하지 않음.
		int hour = 2;
		int min = 30;
		
		min += 10;
		
		System.out.printf("%d시간 %d분\n", hour, min);
		
		//2시간 30분 + 40분 = 2시간 70분 = 3시간 10분
		
		hour = 2;
		min = 30;
		
		min += 40;
		
		hour = hour + (min / 60); //정수 나누기 정수는 이미 몫임. (소수 이하는 버리니까)
		min = min % 60; //70분을 60으로 나눈 나머지가 분.
		
		System.out.printf("%d시간 %d분\n", hour, min);
		
	
	}
	
	private static void m5() {
		
		//연산
		//- 시각 - 시각
		
		Calendar now = Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();
		birthday.set(1995, 4, 10);
		
		//now - birthday = 내가 살아온 시간.
		//System.out.println(now - birthday);	//error
		//모든 산술 연산자는 값형을 대상으로 연산을 한다. 캘린더는 참조형.
		
		//tick, epoch
		//- Returns this Calendar's time value in milliseconds.
		//- the current time as UTC milliseconds from the epoch.
		//800068005203ms
		System.out.println(birthday.getTimeInMillis());
		
		//1647306464532ms							초	  분		시	일	 년
		System.out.println(now.getTimeInMillis() / 1000 / 60 / 60 / 24 / 365); //52 > 1970년에서 52년이 흘렀다.
		
		System.out.println((now.getTimeInMillis()- birthday.getTimeInMillis()) /1000 / 60 / 60 / 24 ); //태어난지 9805일
		
		
		//올해 크리스마스 며칠 남았는지?
		//수료일까지 며칠 남았는지?
		//오늘 수업 끝나려면 몇시간 남았는지?
		//점심까지 몇분 남았는지?
		
		Calendar christmas = Calendar.getInstance();
		christmas.set(2022, 11, 25, 0, 0, 0); //크리스마스 정각
		
		long nowTick = now.getTimeInMillis();
		long christmasTick = christmas.getTimeInMillis();
		
		System.out.println((christmasTick - nowTick) / 1000 / 60 / 60 / 24	); //284일
		
		//수업 끝나려면 몇분
		
		Calendar end = Calendar.getInstance();
		end.set(Calendar.HOUR_OF_DAY, 18);
		end.set(Calendar.MINUTE, 0);
		
		long endTick = end.getTimeInMillis();
		
		System.out.println((double)(endTick - nowTick) / 1000/ 60 / 60); //double형으로 바꿔줘야 더 정확한 숫자
		
		
	}
	
	private static void m4() {
		
		//연산
		//- 시각 + 시간 (미래)
		//- 시각 - 시간 (과거)
		
		//오늘 만난 커플 > 100일 기념일
		Calendar now = Calendar.getInstance();
		
		System.out.printf("1일차: %tF\n", now);
		
		now.add(Calendar.DATE, 100); //now값이 100일 뒤로 수정됨.
		
		System.out.printf("100일차: %tF\n", now); 
		
		
	
		
		Calendar birthday = Calendar.getInstance();
		
		birthday.set(1999, 7, 8);
		
		birthday.add(Calendar.DATE, 100);
		
		System.out.printf("내 100일 잔치: %tF\n", birthday);
		
		//돌잔치
		birthday.set(1999, 7, 8); //now를 다시 생일로 설정
		birthday.add(Calendar.YEAR, 1);
		
		System.out.printf("내 돌잔치: %tF\n", birthday);
		
		
		
		//현재 시각 초기화
		now = Calendar.getInstance();
		
		now.add(Calendar.DATE, -50); //양수를 적으면 미래, 음수를 적으면 과거
		
		System.out.printf("%tF\n", now);
		
		
		
		now = Calendar.getInstance();
		
		//3시간 25분 뒤 비타민 복용
		now.add(Calendar.HOUR, 3);
		now.add(Calendar.MINUTE, 25);
		
		 System.out.printf("%tT\n", now);
		
		
		
		
	}
	
	
	private static void m3() {
		
		//Calendar메소드
		//1. int get(int) -> 원하는 시간을 가져오는 것.
		//2. int set(..) 
		
		
		//현재 시각 얻어오기
		Calendar cl = Calendar.getInstance();
		
		//꺼내 오는건 getxx() 넣을 땐 setxxx()
		
		//특정 시각 얻어오기 > 원하는 시각 만들기
		Calendar birthday = Calendar.getInstance();
		
		//시각 수정하기
		//-void set()
		birthday.set(Calendar.YEAR, 1995);
		//년도가 바뀌니까 년도 + 요일만 바뀜.
		birthday.set(Calendar.MONTH, 4);	//5월을 하고 싶으니 1 뺀 4로
		birthday.set(Calendar.DATE, 10);
		//년도 월 일만바뀌고 시간은 현재시각
		
		birthday.set(Calendar.HOUR, 10);
		birthday.set(Calendar.MINUTE, 30);
		birthday.set(Calendar.SECOND, 0);
		
		//이러면 특정시각 만들 수 있음. 근데 고작 특정시각 하나 만들기 위한 코드기엔 너무 과함. 
		System.out.printf("%tF %tT %tA\n", birthday, birthday, birthday);
		
		
		
		Calendar christmas = Calendar.getInstance();
		
		christmas.set(2022, 11, 25);	//overloading을 활용하면 한문장으로 가능.
		System.out.printf("%tF %tT %tA\n", christmas, christmas, christmas);
		
		christmas.set(2022, 11, 25, 18, 0);
		System.out.printf("%tF %tT %tA\n", christmas, christmas, christmas);
		
		christmas.set(2022, 11, 25, 18, 0, 0);
		System.out.printf("%tF %tT %tA\n", christmas, christmas, christmas);
		
		
		
		
	}
	
	
	private static void m2() {
		
		//두번째 예제
		
		//Calendar 클래스
		
		//현재 시각 얻어오기(가장 기본적인 행동) > 외워야 함. // > 현재 컴퓨터의 시계의 시각을 얻어옴.
		Calendar c1 = Calendar.getInstance();	//TODO Calendar클래스 (2022. 3. 14. 오후 5:08:00)
		
		System.out.println(c1);
		//엄청 길어.. c1안에 들어있는 수많은 데이터 중 원하는 데이터를 추출할 수 있음.
		//- int get(int) : int를 반환하는 형식의 메소드
		
		System.out.println(c1.get(1));	//년도 추출 > 2022
		System.out.println(c1.get(2));	//2
		System.out.println(c1.get(3));	//14
		System.out.println(c1.get(4));	//3
		System.out.println(c1.get(5));	//14
		
		
		int year = 1;
		System.out.println(c1.get(1));		//같은 문장이지만 가독성 낮음
		System.out.println(c1.get(year));	//가독성 높음
		
		
		//자바가 제공하는 Calenadar 상수(변수) > 상수라 읽기전용, 수정 x
		System.out.println(Calendar.YEAR);
		System.out.println(c1.get(Calendar.YEAR));	//****실제로 사용하는 최종 구문 (위에껀 안씀!!!)
		System.out.println();
		System.out.println();
		
		//이게 무슨 데이터인지 정도는 알아둬
		System.out.println(c1.get(Calendar.YEAR));			//2022	-년도
		System.out.println(c1.get(Calendar.MONTH));			//2 	-월(자바는 1월이 0이고, 12월이 11임. 0~11의 값을 반환함)
		System.out.println(c1.get(Calendar.DATE));			//14 	-일(날짜)
		System.out.println(c1.get(Calendar.HOUR));			//5		-시(12H)
		System.out.println(c1.get(Calendar.MINUTE));		//23	-분
		System.out.println(c1.get(Calendar.SECOND));		//22	-초
		System.out.println(c1.get(Calendar.MILLISECOND));	//251	-밀리초(1/1000)
		System.out.println(c1.get(Calendar.AM_PM));			//1		-오전(0), 오후(1)
		
		System.out.println(c1.get(Calendar.DAY_OF_YEAR));	//73	-올해 들어서 오늘이 며칠째냐. 
		System.out.println(c1.get(Calendar.DAY_OF_MONTH));	//14	-이번달 들어서 오늘이 며칠이냐 = DATE와 같음.
		System.out.println(c1.get(Calendar.DAY_OF_WEEK));	//2		-이번주 들어서 오늘이 며칠이냐 (요일) / 일요일부터 1, 토요일은 7 (1~7)
		
		System.out.println(c1.get(Calendar.WEEK_OF_YEAR));	//12	-올해 들어서 이번주가 몇주차인지
		System.out.println(c1.get(Calendar.WEEK_OF_MONTH));	//3		-이번달 들어서 이번주가 몆주째인지
		
		System.out.println(c1.get(Calendar.HOUR_OF_DAY));	//17	-시(24H) >주로 이걸씀.
			
		System.out.println();
		
		//첫주에 목요일이 포함되면 첫주, 목요일 없으면 그 다음주가 첫째주. > 상식으로 알아둬
		
		
		//요구사항] "오늘은 2022년 3월 14일입니다." + 출력하시오.
		
		Calendar now = Calendar.getInstance();
		System.out.printf("오늘은 %d년 %d월 %d일입니다.\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE) );
		
		//java에서는 월이 -1이니까 항상 +1 해줘야함.
		
		
		//요구사항] "지금은 오후 5시 37분입니다." + 출력하시오.
		System.out.printf("지금은 %s %d시 %d분입니다.\n", now.get(Calendar.AM_PM) == 0 ? "오전" : "오후" , now.get(Calendar.HOUR), now.get(Calendar.MINUTE));
		
		//printf(), format() > 형식문자 + 날짜시간 (날짜 시간을 지원하는 형식문자) > 꽤 편함.
		
		//%tF : 년월일 / %tT : 시분초 / %tA : 요일(윈도우에 설정된 언어로 요일 나옴.)
		System.out.printf("%tF\n", now);	//2022-03-14
		System.out.printf("%tT\n", now);	//17:45:23	**********
		System.out.printf("%tA\n", now);	//월요일
	}
	
	private static void m1() {
		//첫번째 예제
		
		//Date
		
		//java.util package가 필요.
		//Date라는 자료형에 date라는 변수를 만든 것.
		Date date = new Date();	//현재 시각을 생성해서 date라는 변수에 담아라. //TODO date클래스 (클래스 배우면 상세 설명) (2022. 3. 14. 오후 5:04:19)
		
		//Mon Mar 14 17:04:39 KST 2022
		System.out.println(date);
		
		
	}
}


// 날짜시간(오전중에) > 제어문 (***) > 문자열 > 배열 (***) > 클래스(***********)
























