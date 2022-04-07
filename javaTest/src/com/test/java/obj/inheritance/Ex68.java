package com.test.java.obj.inheritance;	//04.06

public class Ex68 {

	public static void main(String[] args) {
		
		//상속, this, super
		
		CupChild c = new CupChild(); // new CupParent()실행
		
		//외부
		c.b = 10;
		
		c.test();
		
		
	} //main
}//Ex68


class CupParent {
	
	
	//접근 지정자도 변함없이 그대로 상속 ***
	private int a;
	public int b;
	
	private void aaa() {
		
	}
	
	public void bbb() {
		System.out.println(this.a);
		
	}
	
	public void test() {
		System.out.println("부모 메소드");
	}
	
	
}

class CupChild extends CupParent {
	//부모가 물려준 멤버 4개도
	//근데 접근지정자도 물려받아서 부모의 private 멤버는 못씀.
	
	
	//*** 같은 클래스 내부에서는 접근 지정자가 동작하지 않는다.
	// 		> 같은 클래스 안에서 전부 같은 식구 > 접근할 수 있다.
	
	private int c;
	
	public void ccc() {
		
		System.out.println(c); //당연히 접근 가능 (직접 만든거니까)
		
		//부모가 물려준 private 멤버가 안보인다.
		//System.out.println(a); //빨간줄 뜸
		
		System.out.println(b);
		
		
	}
	
	
//	@Override
//	public void test() {
//		
//		System.out.println("자식 메소드");
//	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		super.test();	//안전장치 > 자식이 오버라이드를 완성X > 기존에 쓰던 부모 메소드라도 호출하라고.
	}
	
	public void call() {
		
		//부모한테 물려받은 test(), 자식이 오버라이드한 test()
		//둘중에 자식test()가 호출됨.
		//test();	//앞에 사실 this.test();임 -> 자식 호출
		
		super.test(); //부모의 test()
		
		//객체 접근 연산자
		//1. this > 나, 현재 객체
		//2. super > 부모 객체
	}
	
}

























