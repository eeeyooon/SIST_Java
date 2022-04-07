package com.test.java.obj.stereo; //03.29

public class Ex48_interface {

	public static void main(String[] args) {
		//Ex48
		
		/*
			
			Stereo Type
			- 추상적인 자료형
			- 인터페이스, 추상클래스 > 클래스의 일종. (객체 생성 못함)
			
			
			인터페이스, interface
			
			+ 인터페이스-인터페이스는 점선으로 , 클래스-클래스는 실선으로. => 클래스 다이어그램에서
		*/
		
		//a.
		G304 m1 = new G304();
		//m1.click();
		//m1.click();
		m1.click();
		
		
		//새 마우스로 교체 -> m1과 m2는 서로 다른 객체이지만 그 이전에 둘다 마우스임. (같은 범주에 속하는 객체) > 그러면 기대를 하게됨. 비슷하거나 똑같을거라고.
		
		G102 m2 = new G102();
		//m2.down();
		//m2.down();
		//m2.down();
		m2.click();
		
		//이 두 마우스는 클래스는 다르지만 하나의 인터페이스 안에 있기 때문에 한 마우스가 가지고 있는 사용법은 반드시 다른 마우스도 가지고 있음.
		// -> 반드시 공통적으로 존재하는 메소드가 있음! (강제적으로!) -> 여기선 click(), test()
		
		
		//b.
		//1. 인터페이스는 자료형이다. > 변수를 만들 수 있음.
		//2. 인터페이스는 객체를 만들 수 없다.
		// Mouse m1 = new Mouse(); -> 이게 안된다는 거. >> 추상 멤버(추상 메소드)를 가지고 있기 때문에(**) 실체화할 수 없음. 
		// 											>> 실체화가 뭐야? 객체를 생성하지 못한다는거. (new 연산자 못씀)
		
		
		//Mouse m1 = new Mouse();
		
		//m1.test(); // 이것때문에 만들 수 없음. (**********)
				   // > 메소드가 껍데기는 있는데 알맹이는 없으니까 이 객체를 사용할 수 없음. (객체를 만드는 행동 자체가 부정당함.)
		
	
		
		
		
	}//main
}//Ex48

//서로 비슷한 부류의 객체들의 사용법을 물리적으로 통일시키는 방법이 필요.
//같은 인터페이스 안 클래스들은 반드시 공통적으로 가지고 있는 메소드가 존재함.
//=> 인터페이스란 제품의 규격 역할을 함!

//인터페이스 선언 (클래스의 일종임. 얘도 자료형. but 객체를 못만드는 자료형)
interface Mouse {
	
	//인터페이스 멤버 선언
	//-> 멤버는 누구 ? 변수 못옴. 메소드 중에선 추상 메소드만!
	//- 추상 메소드를 멤버로 가진다. (**********) >> 인터페이스의 이유
	//- 멤버 변수는 가질 수 없다.
	//- 일반 멤버 메소드는 가질 수 없다. > ?? 선생님은 있다고 하셨는데 오타인지,,
	//public String name; 변수 선언 불가능.
	
	//Abstract methods do not specify a body -> 추상 메소드는 바디를 구현할 수 없다.
//	public void test() { //error.
//		
//	}
	
	
	//추상 메소드 선언(인터페이스 멤버)
	void test(); //구체적으로 행동을 정의하지 않았기 때문에 추상 메소드. (public 생략함)
	
	void click(); //c. click() 추가
	
}

//The type G304 must implement the inherited abstract method Mouse.test()
//304는 반드시 상속 받은 추상 메소드를 만들어야 합니다. -> void test();를 꼭 만들어야 한다. (must implement -> 실제로 구현하라는말)
//일반 클래스는 추상메소드를 가질 수 없음.. 반드시 바디를 가져야함. ';'말고 '{}' 부모가 물려준 메소드에 바디를..구현해야해.. => 메소드 오버라이드 해줘야해..
class G304 implements Mouse { 
	//extends Mouse하면 에러남. -> extends는 뒤에 일반 클래스만 올 수 있음. (Mouse는 인터페이스 -> implements를 써야함.)

	
	//클래스 멤버 선언
	private String type;
	private String color;
	private int dpi;
	
	public void click() { //c. 이미 있으니까 에러 x
		
	}
	
	
	//***인터페이스가 부모가 됐을 때 하는 일 -> 자식 클래스에게 강제로(****) 어떤 메소드를 만들도록 함!!! (안만들면 에러뜸.)
	//자신이 생각한대로 구현하지 않으면 바로 에러남. 
	@Override
	public void test() {
		//여긴 내맘대로 구현할 수 있음.
	}
}

class G102 implements Mouse {
	private String color;
	private int price;
	private int buttons;
	
	public void click() {
		
	}
	
	@Override
	public void test() {
		
	}
}






class AAA {
	private BBB b;
	private int num;
	private CCC[] list; //0..* (방의 개수를 표현 안했으니까 무한대 = '*') -> 0~무한대까지 넣을 수 있어요
						//근데 방의 길이를 정해도 *로 표시되네
	
}



class BBB {
	
}


class CCC {
	
}

class DDD {
	public void test() {
		EEE e = new EEE(); //어떤 하나의 클래스에서 다른 클래스의 객체가 필요해서 가져오는 것
	}
}

class EEE {
	
}





































