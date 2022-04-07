package com.test.java.obj.inheritance; //03.28

public class Ex42_Object {

	public static void main(String[] args) {
		
		//Ex42_Object.java
		
		//object클래스
		//- 사용자가 만드는 모든 클래스는 자동으로 Object클래스를 상속받는다.
		//- 모든 클래스의 근원 클래스, Root class
		//- 모든 클래스는  Object 클래스로부터 파생됨. > 단군 할아버지 
		//- 우리가 명시적으로 부모클래스를 지정하지 않은 클래스는 자동으로 Object클래스의 자식 클래스가 됨.
		//- Object 멤버는 모든 클래스에게 상속됨. > 모든 클래스들에 필요하다고 생각하는 공통기능을 미리 구현해놓은 것.
		/*
		- Object 클릭했을 때 도움말
		
		Class Object is the root of the class hierarchy.
		Every class has Object as a superclass.
		All objects,including arrays, implement the methods of this class.
		
		*/
		Object o1 = new Object();
		
		Test t1 = new Test();
		
		
	}//main
}//Ex42


class Test extends Object {
	public int a;
	public int b;
	
}

class Other extends Test {
	
	public int c;
	public int d;
	
}











































