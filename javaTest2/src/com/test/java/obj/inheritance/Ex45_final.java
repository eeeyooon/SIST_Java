package com.test.java.obj.inheritance;

import java.util.Calendar; //03.28

public class Ex45_final {

	public static void main(String[] args) {
		
		//Ex45_final
		
		/*
		
			fianl 키워드
			- 한번 결정하면 바꿀 수 없다!
			
			1. 변수 적용 (지역변수 + 멤버변수)  ***** 이거 중심으로 해
				- 값을 초기화한 이후에 변경
				- 상수
				
			2. 메소드 적용	//2,3번은 집착하지 않아도 돼 가볍게
				- 상속시 재정의(Override)를 막는 역할
				
			3. 클래스 적용
				- 상속이 불가능함.
		
		
		
		*/

		
		//지역변수
		int a = 10;
		a = 20;
		
		//상수
		//- 상수는 되도록 선언과 동시에 초기화를 한다. (권장)
		final int b = 20;
		//b = 30; error	// The final local variable b cannot be assigned. 
						// It must be blank and not using a compound assignment.
		
		// 아래처럼 따로 초기화하는 방식은 비권장 > 변수처럼 보임.
		final int c;
		c = 30;
		//c = 40; error
		
		
		//****** 상수명은 모두 대문자로 작성한다. (명명법)
		final double PI = 3.14;
	
		
		Calendar now = Calendar.getInstance();
		
		System.out.println(now.get(1));			//의미없음
		
		int year = 1;
		System.out.println(now.get(year));		//의미 있음
		
		System.out.println(Calendar.YEAR); 		// = 1 -> 캘린더 상수 
		
		//Calendar.YEAR = 2; error -> The final field Calendar.YEAR cannot be assigned. = 상수다.
		System.out.println();
		
		
		
		User u1 = new User();
		System.out.println(u1.GENDER);
		//System.out.println(u1.age);
		
		
		User u2 = new User();
		System.out.println(u2.GENDER);
		//System.out.println(u2.age);
		
		User u3 = new User();
		System.out.println(u3.GENDER);
		//System.out.println(u3.age);
		
		System.out.println(User.NUM);		// final static 상수
		System.out.println(Calendar.YEAR);	// final static 상수임

		System.out.println();
		
		//Member m1 = new Member();
		//System.out.println(m1.a);			//10	
		//System.out.println(Member.b); 	//20
		
		System.out.println(Member.b);	//0	//static이 붙은건 메인 메소드 만들기도 전에 생성되어있음.
										// 20이 들어가려면 먼저 객체를 만들어야함. (객체를 만들어야 초기화가 됨.)
										// c. 아까는(b) 0이었는데 지금 20 (아무것도 안해도 정적 멤버는 초기화됨.)
		Member m1 = new Member();
		
		System.out.println(Member.b);	//b. 20
		
		Member.b += 5;
		System.out.println(Member.b);	//25
		
		Member m2 = new Member();
		
		System.out.println(Member.b); 	//20 -> 계속 20으로 초기화됨. b.
		
	} //main
}//Ex45


class User {
	
	//객체 변수의 역할(********) > 객체 각각의 자신의 저장공간 > 자신만의 데이터를 저장하기 위해
						//	 > 객체의 상태(State) > 객체를 구분함.
	public int age; 				//멤버 변수
	final public int GENDER = 2 ;	//멤버 상수 > 객체 멤버 상수는 잘 안만듦. (static과 유사)
									//final이 붙은 안붙든 얜 객체 변수이고 -> new가 붙어야 메모리에 저장됨.
	
	final public static int NUM = 3;	//static 변수 > 상수 > static 상수 (멤버상수와 비슷, 보통 static상수를 씀)
										//static이 붙으면 클래스가 아니라 생성자 명으로..접근..?
										//final과 static 순서는 바껴도 됨.
	public User() {
		this.age = 0;
		
	}
	
}

//final얘기 아님 별도 (질문에 대한 답변)

class Member {
							//private 하면 getter setter만들어야하니까 public 
	public int a;			//객체 멈버
	public static int b; 	//정적 멤버(공용 멤버)
	
	//얜 정확히 객체 생성자임. > 객체멤버만을 초기화하는 역할. (정적멤버는 포함하면 x)
	public Member() {
		this.a = 10;
		//Member.b = 20; //-> 얘 안됨. 정적 변수를 객체 생성자에서 초기화하면 안됨.!!! 얜 객체멤버 아니야. b.
						
	}
	
	//그럼 어떻게 해?
	// 생성자 중엔 정적 생성자라는 게 있음 > 정적 멤버만을 초기화하는 역할
	static {	//c. 접근지정자x, 이름x
		Member.b = 20;
	}	//c. 얘도 멤버의 객체를 만들지 않아도 이미 깔아져있음. > 수업중엔 정적생성자 볼 일 많이 x
}


//메소드
class FinalParent { 
	//부모 클래스 설계시
	//- 상속받는 자식이 이 메소드만큼은 고치지 않았으면, 하는 경우가 있음.
	//- 프로그램의 안정성 문제 (이 코드를 재정의하지 않고 그대로 갖고있어야 안정적이다 하는 코드가 있을때)
	// > Final 메소드
	public void test() {
		System.out.println("메소드");
	}
}

class FinalChild extends FinalParent {
	//Cannot override the final method from FinalParent >> 메소드 재정의 X
	@Override
	public void test() {
		System.out.println("재정의");
	}
}


//클래스

//부모 클래스를 생성할 당시 -> 먼 훗날 자식 클래스가 생길 수도 있지만, 난 포기 > 자식 안만들래 >> 앞에다가 final 붙이면 돼.
//- 이걸 터미널 클래스라고 함.
//- 리프 노드가 생기고 생기다가 마지막에 더이상 생기지 않는 마지막 노드.
//- 얘도 안정성 문제 때문에 함.
final class FinalUser {	// 얜 영원히 누군가의 부모클래스가 될 수 없음.
	
}

//The type FinalUserAdmin cannot subclass the final class FinalUser.
//class FinalUserAdmin extends FinalUser{ //>error
	
//}












