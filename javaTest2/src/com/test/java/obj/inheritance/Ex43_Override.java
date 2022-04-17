package com.test.java.obj.inheritance; //03.28

public class Ex43_Override {

	public static void main(String[] args) {
		//Ex43
		
		/*
		 
		 	메소드 오버로딩, Method Overloading
		 	- 메소드 이름 동일 x N 생성 > 인자 리스트
		 	
		 	메소드 오버라이드, Method Override
		 	- 클래스 상속시에 발생
		 	- 메소드 재정의
			
			포인트
			1. 자식 클래스가 상속받은 부모의 메소드를 그대로 사용하기 싫음.
				- 상속은 거부할 수 없음. 무조건 100% 진행 (골라 받을 수 없음.)
			2. 상속 관계에 있는 클래스의 객체들은 대부분 공통된 사용법(메소드)을 가지고 있다고 생각을 함.
				- 이 생각을 깨고 스스로 다른 형식의 메소드를 생성해버리면 > 규칙 파괴;
			3. 겉으로 보기엔 부모의 메소드와 동일한데, 내용물만 바뀐 메소드를 만들어내자. (자식클래스의 hello():하이~버전)
		
		*/
		
		//** 상속관계에 있는 클래스 > 같은 목적을 가지는 메소드 구현 > 반드시(****) 메소드 시그니처를 동일하게 만드는것이 좋음.
		
		//길을 가다가 마주침.
		OverrideParent p1 = new OverrideParent();
		p1.name = "홍길동";
		p1.hello();
		
		OverrideChild c1 = new OverrideChild();
		c1.name = "홍아들";
		//c1.hi();
		
		//외부에서 보면 부모의 hello()와 자식의 hello()는 구분이 불가능함.
		// > 결론 > 무조건 자식의 hello()가 호출됨. (선택 불가능)

		c1.hello(); //무조건 자식의 hello()가 호출됨. (선택 불가능)
					//외부에서 보면 행동이 바뀐 것처럼 보임. > 메소드의 겉모습은 똑같은데 알맹이가 수정된것처럼 보임.
					// 내용을 Upgrade하면서 사용법(메소드)은 유지. 	>> 메소드 재정의 = 메소드 오버라이드
		
	}//main
}//Ex43


class OverrideParent {
	
	public String name;
	
	public void hello() {
		System.out.printf("안녕하세요. 좋은 아침입니다. 저는 %s입니다.\n", this.name);
	}
}

class OverrideChild extends OverrideParent {
	
	//자기 방식대로 인사를 하고 싶다.
	//부모로부터 물려받은 메소드는 쓰지 않고, 자신만의 메소드를 선언함.
	
//	public void hi() {
//		System.out.printf("하이~ 난 %s야\n", this.name);
//	}
	
	//새로운 메소드를 만들지 않아도 부모로부터 받은 메소드 내용을 수정하는 것이 가능함.
	//메소드 오버라이드 > 메소드 재정의
	//-부모로부터 물려받은 메소드와 동일한 메소드를 자식 클래스에서 다시 선언하는 행동
	//-부모 메소드와 자식 메소드가 동일하게 2개 존재하게 됨.
	
	@Override // 주석의 일종 (프로그래밍 기능이 O) > Annotation
			  //이거 해 놓으면, 부모가 가지고 있는 메소드인지 아닌지를 체크해줌. > 웬만하면 붙여주는 걸 권장.
	
	public void hello() {
		System.out.printf("하이~ 난 %s야\n", this.name);
	}
	
	//직접 안적고 ctrl + space하면 됨. 그러면 부모 클래스의 메소드를 오버라이드할 수 있는 메뉴가 뜸.
//	@Override
//	public void hello() {
//
//	}
	
}






















































