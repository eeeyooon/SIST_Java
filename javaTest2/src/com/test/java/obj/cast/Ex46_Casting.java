package com.test.java.obj.cast; //03.28, 03.29

public class Ex46_Casting {

	public static void main(String[] args) {
		
		//Ex46
		
		/*
			
			형변환, Type Casting (값형 <-> 참조형은 안되지만, 값형끼리/참조형끼리는 가넝)
			1. 값형 형변환, ValueType Casting
				- 값형끼리 형변환 가능 (boolean제외)
			
			2. 참조형 형변환, Reference Type Casting 
				- 참조형끼린 다 형변환 가능
				
			
			참조형 형변환
			- 상속관계의 클래스간의 형변환 (클래스도 자료형.) > 상속관계가 없으면 형변환이 불가능함. 
													>> 직계끼리만 가능(방계 불가능) 조부-조손도 가능.
			- A 클래스 > B클래스로
			 >> 이것도 형변환임.
			
			1. 업캐스팅, Up Casting
				-암시적인 형변환(문법으로 표시하지 않아도 자동으로 일어남)
				-자식 클래스 -> 부모 클래스
				-100% 가능												//03.29
				
			2. 다운캐스팅, Down Casting
				-명시적인 형변환(문법으로 표시안하면 하지 않기때문에 반드시 표시해야함.)
				-부모 클래스 -> 자식 클래스
				-100% 불가능(근본)
				-내부 조작을 통해 가능하게 함.
				
		*/
		
		//temp(); //%s에 대한 설명
		
		
		Parent p1 = new Parent();
		p1.a = 10;
		p1.b = 20;
		
		
		Child c1 = new Child();
		c1.a = 10;
		c1.b = 20;
		c1.c = 30;
		c1.d = 40;
		
		
		Parent p2;
		Child c2;
		
		c2 = new Child();
		
		//복사
		//Parent = child
		//암시적인 형변환
		//부모 클래스 = 자식 클래스
		//업 캐스팅(***)
		//100% 가능 > 아주 안전한 형변환
		// 자식 클래스 타입을 부모 클래스 타입으로 바꾸는 방법.
		p2 = c2;
		p2 = (Parent)c2;//원형
		
		//복사+형변환 > 제대로 진행되었는지, 완료되었는지 검증. > 복사된 참조변수를 가지고 모든 멤버 접근 테스트
		p2.a = 10;
		p2.b = 20;
		
		System.out.println(p2.a);	//10
		System.out.println(p2.b);	//20
		
		
		//참조변수의 type이 Child이면 Child를 통해 보는 데이터 역시 child 객체라고 믿음.
		//반대로 참조변수의 type이 Parent이면 그걸 통해 보는 데이터 역시 Parent 객체의 멤버라고 생각함.
		
		//p2.c = 30;	//error.
		// -> 이것 역시 Parent변수에 c가 있을 수 없음. Parent 클래스에는 c가 없으니까
		// 	  또한 참조변수 타입 역시 Parent니까 그 내용이 Child라도 겉모습이 Parent이니 Parent 데이터만 볼 수 있음.
		
		// 객체의 멤버(child)는 참조변수의 멤버(Parent)로만 접근할 수 있음. 참조변수의 멤버가 a와 b밖에 없으니까 
		// 객체의 멤버 중에서도 a,b만 볼 수 있음. (c와 d는 볼 수 없음 -> 얜 안보여도 상관없음. 중요하지 않음.)
		
		
		
		Parent p3;
		Child c3;
		
		p3 = new Parent(); //원본
		
		//Child = Parent
		//명시적 형변환
		//자식 클래스 = 부모 클래스
		//다운 캐스팅
		
		//c3 = p3; //error.
//		c3 = (Child)p3;	//이게 에러의 원인이기때문에, 이 원인을 아예 불가능한 작업으로 취급하자고 결론 내림.
		
		//검증 > 복사본이 사용에 문제가 없는지
//		c3.a = 10; //O
//		c3.b = 20; //O > 원본인 Parent객체에 a,b가 있으니까 가능
//		c3.c = 30; //X
//		c3.d = 40; //X > c,d는 Parent가 물려준게 아니라 Child가 자체적으로 만든거니까 불가능
		//> 그렇다고 a,b만 골라서 쓸 수 없음. 
		//>> 환경에 따라 골라쓸 수 있지만 어떤 환경에선 골라쓸 수 없음.
		//>>> 툴에 따라 가능할때도 불가능할때도 있으면 안되니까 그냥 이클립스에서는 일부만 안되도 모두 안되는걸로 설정.
		//.. 근데 또 이걸 가능하게 하는 방법이 있다?
		
//		System.out.println(c3.a);
//		System.out.println(c3.b);
//		System.out.println(c3.c);
//		System.out.println(c3.d);
		//다 error.
		
		
		
		Parent p4;
		Child c4;
		
		c4 = new Child(); //원본
		
		//업 캐스팅
		
		p4 = c4; //원본(Child)을 Parent에 복사
		
		
		
		Child c5;
		
		//다운 캐스팅 > 100% 불가능 > 런타임 오류 (컴파일 오류는 x)
		c5 = (Child)p4; //Child를 복사한 parent를 Child로 또 복사 (다운 캐스팅)
		
		c5.a = 100;
		c5.c = 300;
		
		System.out.println(c5.a);
		System.out.println(c5.c);
		
		
	}//main

	private static void temp() {
		System.out.printf("%s", "문자열");
		
		//%s는 자동으로 toString() 호출함. (%s만!)
		//그렇다고 다 %s로 받지말고 그냥 제각기 맞는 자료형으로 쓰는게 best
		
		//1. Wrapper Class
		//2. 참조형 변환
		//3. toString() 호출
		
//		System.out.printf("%d", 10);
//		System.out.printf("%s", 10);	
//		
//		System.out.printf("%b", true);
//		System.out.printf("%s", false);
//		
//		System.out.printf("%c", 'A');
//		System.out.printf("%s", 'z');
	}
}//Ex46


//03.29

//참조형 형변환 > 상속 관계에 있는 직계 클래스끼리 가능

class Parent {
	public int a;
	public int b;
	
}

class Child extends Parent {
	public int c;
	public int d;
}



























