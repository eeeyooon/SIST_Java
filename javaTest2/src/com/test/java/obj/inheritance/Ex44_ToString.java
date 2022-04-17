package com.test.java.obj.inheritance; //03.28

import java.util.Calendar;
import java.util.Date;

public class Ex44_ToString {

	public static void main(String[] args) {
		//Ex44
		
		Time t1 = new Time(2, 30);
		System.out.println(t1.getHour()); //각각의 멤버변수 > Getter 호출
		System.out.println(t1.getMin());
		
		Time t2 = new Time(5, 10);
		System.out.println(t2.info());	//객체의 상태를 한방에 확인!!
		
		Date now = new Date();
		
		Calendar now2 = Calendar.getInstance();
		
		
		
		
		//Date, Calendar, Time의 객체를 출력!
		
		System.out.println(now);	//객체의 내부 데이터 출력
		System.out.println(now2);	//객체의 내부 데이터 출력
		System.out.println();
		
		//com.test.java.obj.inheritance.Time > 해당 객체의 자료형(패캐지.클래스)
		//@ > 구분자
		//2aafb23c > 숫자(16진수) > 메모리 주소값 > 해시코드(HashCode)라고 부름.
		System.out.println(t1);	//com.test.java.obj.inheritance.Time@2aafb23c
		System.out.println(t2);	//com.test.java.obj.inheritance.Time@2b80d80f
		System.out.println();
		
		//메소드는 크기를 차지하지 않음. 
		
		//객체의 출력 > 객체의 toString() 반환값을 출력
		System.out.println(now);
		System.out.println(now.toString());	//Object.toString
		
		System.out.println(t1);
		System.out.println(t1.toString()); //Object.toStirng()
		
		//now.toString(); String - Date (오버라이드한것)
		t1.toString(); //String - Object(오버라이드X) > time에서 재정의한 이후로는 String - time으로 바뀜.
		
		//오버라이드 시키면 뒤에 소유가 자식클래스로 바뀜.
		
		//Object.toString()
		//- 자식 클래스에서 그대로 사용하지 않는다. > 쓸모없음
		//- 반드시 메소드 오버라이드(재정의)를 해서 사용한다.
		//- 모든 객체는 toString()를 소유함.
		//- 어떤 코드를 재정의? > 자신이 소유한 데이터(멤버 변수)의 값을 문자열로 돌려주는 코드로.
		//					>> 이걸 덤프(dump)라고 함.
		//- 규칙 역할을 함 : 모든 메소드는 toString()를 사용할 수 있다.
		
	} //main
}// Ex44



class PPP {
	public void test() {
		
	}
}

class QQQ extends PPP {
	public void aaa() {
		
	}
	
	@Override
	public void test() {
		
	}
}

//클래스 = 멤버변수 + 생성자 + Getter/Setter + toString() 재정의

class Time {
	
	private int hour;
	private int min;
	
	public Time(int hour, int min) {
		this.hour = hour;
		this.min = min;
		
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	
	
	
	//객체의 상태를 확인하기 쉽도록, 개발자를 위해서 만든 dump메소드
	public String info() {
		return this.hour + ":" + this.min;
	}


// 오른쪽버튼 > source > generate toString으로도 만들 수 있음. (자동생성)
//	@Override
//	public String toString() {
//		return "Time [hour=" + hour + ", min=" + min + "]";
//	}
	

// 이건 ctrl+space한뒤 기본 생성 내용 지우고 내용 작성한 것.	
	@Override
	public String toString() {
		
		//return 문자열; //여기까지 약속. 그 다음부턴 사용자정의
						// > but 최소한의 규칙(권장사항) : 객체의 데이터를 알아볼 수 있게 문자열로
		
		return this.hour + ":"	+ this.min;
		
	}
}




























