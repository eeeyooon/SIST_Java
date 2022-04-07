package com.test.java.obj.inheritance; //03.28

public class Ex41_Inheritance {

	public static void main(String[] args) {
		
		
		//프로젝트 설계 > 여러 종류의 설계도
		// - UML언어 > 말은 언어지만 몇 종류의 다이어그램으로 되어있음 
		// - 그 중 하나가 Class Diagram
		
		//Stereo Type -> '<< >>' => 길로멧, 기메라고 부름.
		// c붙어있으면 생성자, s붙어있으면 static
		// 헤더 / 변수부 / 메소드부 이렇게 3영역
		// 변수부에 빨간색은? private
		// 변수부에 녹색은? public
		// 클래스 다이어그램만 보고 코딩을 할 줄 알아야해 
		
		//Ex41
		
		/*
			상속, Inheritance
			- 부모가 가지는 멤버(변수, 메소드)를 자식에게 물려주는 행동
			- 부모 클래스가 자식 클래스에게 물려주는 행동
			
			상속을 왜 하는지?
			- 자식 클래스가 구현해야 하는 멤버(코드)를 직접 구현하지 않고, 부모 클래스로부터 물려받아 자기가 직접 구현한 것처럼
			 사용하기 위해서 ..
			- 비용 절감, 코드 재사용(******)
			
		
			상속은 클래스가 최소 2개 필요함. 자식클래스, 부모 클래스
		
		
			상속 관계에 있는 클래스 호칭
			- 부모 클래스 <- 자식 클래스
			- 슈퍼 클래스 <- 서브 클래스 
			- 기본 클래스 <- 확장(파생) 클래스
			
			
		
		
		*/
		
		Parent p1 = new Parent();
		p1.a = 10;
		p1.b = 20;
		
		Child c1 = new Child();
		c1.a = 30;
		c1.b = 40;
		c1.ccc();
		c1.d = 50;
		c1.eee();
		
		DDD d1 = new DDD();
		System.out.println(d1.a);
		System.out.println(d1.b);
		System.out.println(d1.c);
		System.out.println(d1.d);
		
		
		
		
	}//main
}//Ex41

//부모 클래스
class Parent {
	
	public int a;
	public int b;
	public void ccc() {
		System.out.println("메소드");
	}
	
}


//자식 클래스
class Child extends Parent {
	public int d;
	public void eee() {
		
	}
	
	
}


class son extends Parent {
	public int f;
	public void ggg() {
		
	}
}


class Daughter extends Parent {
	public int h;
	public void iii() {
		
	}
}


class AAA {
	public int a = 10;
}

class BBB extends AAA {
	public int b = 20;
}

class CCC extends BBB {
	public int c = 30;
}

class DDD extends CCC {
	public int d = 40;
}





















