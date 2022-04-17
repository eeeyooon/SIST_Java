package com.test.java.obj.stereo;

public class Ex54_Generic {

	public static void main(String[] args) {
		
		//Ex54_Generic.java
		
		//Item is a raw type. References to generic type Item<T> should be parameterized
		// -> 여기에 타입변수가 있어서 인자값을 전달해야하는데 왜 안썼어?
		//	  제네릭은 <T>를 무시하고 객체를 생성해도 사용은 됨. 하지만 제대로된 사용법은 아님
		Item i1 = new Item();	//이건 그냥 클래스의 인스턴스를 만드는 코드
		
		Item<String> i2 = new Item<String>();	// > 이게 제대로 된 사용법.
		i2.c = "문자열";
		
		
		Item<Integer> i3 = new Item<Integer>();  //실인자값이 정해져있지 않다는 특징과 같음.
												 //자료형 중 아무거나 하나를 반환만 하면 돼.
		i3.c = 10;
		
		//같은 클래스로 만든 객체인데 변수의 타입이 달라짐. -> 이게 제네력이 하는일.
		//******값형을 사용할 수 없다. > 반드시 참조형(클래스)만 사용 가능.
		// 그래서 int말고 Integer로
		// 하지만 자료형은 모두 대체할 수 있는 클래스가 있음
		// byte -> Byte 
		// short -> Short
		// int -> Integer
		// double -> Double
		
		Pen<Boolean> p1 = new Pen<Boolean>();
		
		p1.a = true;
		p1.b = false;
		p1.c = true;
		
		
		Desk<String> d1 = new Desk<String>();
		
		d1.a = "문자열";
		d1.test("문자열");
		String result = d1.get();
		
		
		Cup<String, Integer> c1 = new Cup<String, Integer>("문자열", 100);
		
		Cup<Double, Boolean> c2 = new Cup<Double, Boolean>(3.14, false);
		
		System.out.println(c1.getA());
		System.out.println(c1.getB());
		
		
		
		
	} //main
	
} //Ex54


//int a = 10; > 데이터를 담는 공간(일반 변수)
//T = int; > 자료형을 담는 공간(타입 변수)
//T = String;
//T = Boolean;


//제네릭 클래스 >> 자료형을 설계 당시에 결정하는게 아니라 실행하며 결정하는 것.
//-T : 타입 변수 > 다른걸 적어도 상관없지만 보통 타입의 약자로 T (종류별로 보편적으로 쓰는 이름이있음)
//			   >> 자료형 그자체를 저장하는 변수
//-<> : 메서드의 소괄호같은 역할 '()'=인자리스트 역할
class Item<T> {
	
	//main에서 건네받은 자료형도 이 안에서 써먹어야 해.
	
	public int a;
	public int b;
	public T c;	//클래스 설계 당시에는 c의 자료형이 결정되지 않음. > 나중에 객체 생성할때 결정됨.
	
	
}



class Pen<T> {
	
	public T a;
	public T b;
	public T c;
	
	
}


class Desk<T> {
	
	public T a;	//멤버 변수의 자료형
	public void test(T a) {	//메소드 매개변수의 자료형
		//T b; //가능은 한데 비권장.. 지역변수로는 굳이 쓰지마 인스턴스에선 안보임. -> 메소드 안은 블랙박스니까
	}
	
	public T get() { //메소드 반환타입
		
		return this.a;
		
	}
	
}


class Cup<T,U> {
	
	public T a;
	public U b;
	
	public Cup(T a, U b) {
		
		this.a = a;
		this.b = b;
		
	}
	
	public T getA() {
		return this.a;
	}
	
	public U getB() {
		return this.b;
	}
}






















































