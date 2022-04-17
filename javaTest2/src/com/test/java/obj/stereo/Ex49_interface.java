package com.test.java.obj.stereo;

public class Ex49_interface {

	public static void main(String[] args) {
		
		//Ex49_interface.java
		
		//다중 상속
		//- 자바에서는 다중 상속을 지원하지 않는다. (부모 클래스가 2개 이상) 
		//	-> 요즘 언어들의 특징임 (90년대 이전?) > why? 상황을 복잡하게 해
		
		//- 자바에서는 인터페이스에 한해서 다중 상속을 지원함. > 매우 활발하게 사용중 
		
	}//main

}//Ex49


//인터페이스는 규격(제약) -> 다르게 보면 '자격'이기도 함.

//아빠로서 갖추어야할 행동에 대한 정의를 하겠구나, 생각해야해
//나중에 클래스가 무조건 만들어야할 메소드의 집합
interface 아빠 { //쓰지말라고했지만 공부할땐 이게 더 와닿을테니까 잠깐 한글로 하자
	
	void 돈을번다();
	void 아이와놀아준다();
	void 가족을지킨다();
	
	
}

interface 남자 {
	
	void 굵은목소리로말한다();
	void 면도를한다();
	
}

interface 과장 {
	
	void 결재를한다();
	void 직원을관리한다();
	
}

interface 카페사장 {
	
	void 매장을연다();
	void 매장을닫는다();
	void 음료를판다();
	
}

//진짜 사람 > 아빠 역할을 해야 해
class 홍길동 implements 아빠 {

	//여러가지 멤버를 구현 > 에러난곳에 마우스 올리면 한번에 생성 가능

	@Override
	public void 돈을번다() {
		//이걸 홍길동 스타일로 구현
		
	}

	@Override
	public void 아이와놀아준다() {
		
	}

	@Override
	public void 가족을지킨다() {
		
	}
	
	
}




class 아무개 implements 과장 {

	
	
	@Override
	public void 결재를한다() {
		
	}

	@Override
	public void 직원을관리한다() {
		
	}
	
	
	
}



//결혼(아빠) + 과장
class 테스트 implements 아빠, 과장, 남자, 카페사장 {
	// -> 이게 다중상속 (무언가의 자격정도로 생각하면 접근하기 쉬움.) => 얼마든지 늘릴 수 있음.
	// 자격이 주어지는건 그 성격도 정해지는 것
	// 어떤 걸 만들때 성격이 비슷한 애들을 만들고 싶으면 인터페이스를 사용하면 돼.

	@Override
	public void 결재를한다() {
		
	}

	@Override
	public void 직원을관리한다() {
		
	}

	@Override
	public void 돈을번다() {
		
	}

	@Override
	public void 아이와놀아준다() {
		
	}

	@Override
	public void 가족을지킨다() {
		
	}

	@Override
	public void 매장을연다() {
		
	}

	@Override
	public void 매장을닫는다() {
		
	}

	@Override
	public void 음료를판다() {
		
	}

	@Override
	public void 굵은목소리로말한다() {
		
	}

	@Override
	public void 면도를한다() {
		
	}	
	
	
	
	
}
































