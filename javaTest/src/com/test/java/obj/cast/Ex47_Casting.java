package com.test.java.obj.cast; //03.29

public class Ex47_Casting {

	public static void main(String[] args) {
		
		//Ex47_Casting.java
		
		//업캐스팅과 다운캐스팅은 언제 사용하는지? 왜 사용하는지?
		
		
		//내가 가지고 있는 마우스들 > 관리할때?
		G304 m1 = new G304("광", 45000, 5, 1200);
		G304 m2 = new G304("광", 38000, 4, 8000);
		
		G102 m3 = new G102("광", 28000, 8000, "검정");
		G102 m4 = new G102("광", 25000, 5000, "노랑");
		G102 m5 = new G102("광", 26000, 7000, "파랑");
		
		M331 m6 = new M331("광", "검정", 33000, 10000);
		M331 m7 = new M331("광", "연두", 32000, 0000);
		
		
		G304[] mlist1 = new G304[2];
		mlist1[0] = m1;
		mlist1[1] = m2;
		
		G102[] mlist2 = new G102[] { m3, m4, m5};
		
		M331[] mlist3 = new M331[] { m6, m7 };
		
		
		//마우스가 잘 있는지? 확인? > 마우스를 꺼내서 동작 테스트
		
		for (int i=0; i<mlist1.length; i++) {
			mlist1[i].click();
			mlist1[i].clean();
		}
		System.out.println();
		
		for (int i=0; i<mlist2.length; i++ ) {
			mlist2[i].click();
			mlist2[i].check();
		}
		System.out.println();
		
		for (int i=0; i<mlist3.length; i++ ) {
			mlist3[i].click();
			mlist3[i].charge();
		}
		System.out.println();
		
		
		
		//b.
		
		
		G304 m8 = new G304("", 0, 0, 0); //G304라는 인스턴스 만들기
		
		Mouse m9;
		
		//Mouse = G304
		//부모 클래스 = 자식 클래스
		//업캐스팅(100% O)
		m9 = m8;
		
		//위 3줄을 한문장으로 요약하면
		Mouse m10 = new G304("", 0, 0, 0); //업캐스팅 발생
		Mouse m11 = new G102("", 0, 0, "");
		Mouse m12 = new M331("", "", 0, 0);
		
		//마우스 7개 관리 > 모델별 배열 > 전체배열
		
		//서로 다른 자료형의 객체를 하나의 집합에 넣어서 관리하기 위해 업캐스팅을 사용함. (업캐스팅의 가장 흔한 사용법 중 하나가 이것.)
		//서로 다른 자료형의 객체를 추상화시키기 위해서 
		//하위 객체들의 공통적인 특질은 상위 클래스가 가지고 있으면 업캐스팅하여 사용
		//(ex. 남자, 여자를 따로 보는게 아니라 '사람'이라는 상위 단어로 보기 위해 업캐스팅)
		
		Mouse[] mlist = new Mouse[7];
		mlist[0] = m1;	//G304
		mlist[1] = m2;	//G304
		
		mlist[2] = m3;	//G102
		mlist[3] = m4;	//G102
		mlist[4] = m5;	//G102
		
		mlist[5] = m6;	//M331
		mlist[6] = m6;	//M331
		
		
		//mlist는 참조변수가 Mouse니까 click()이 안보임. 그래서 Mouse에다가 click()를 만들어줌.
		for (int i=0; i<mlist.length; i++) {
			mlist[i].click(); //부모걸 쓰는게 아니라 자식 본인의 click()를 씀.
			
			//G304가 갖는 clean()이라는 기능도 쓰고싶으면?
//			G304 a1 = (G304)mlist[i]; //부모인 Mouse 참조변수를 G304 변수에 복사. -> 다운 캐스팅
//			a1.clean(); //a1에서는 clean이 보이니까. >> 이래서 다운 캐스팅을 하는것.
			
			// 서로 다른 객체(형제)를 부모 배열에 한꺼번에 몰아넣어 관리 중인데,
			// 가끔씩 자식 고유의 기능을 사용해야 할 때
			// -> 부모 참조변수로는 자식 고유의 기능을 접근할 수 없음. (보이지 않으니까. 참조변수 눈에는 자신과 같은 자료형만 보임.)
			// => 이때 자식변수를 원래 자료형으로 되돌려서 고유 기능을 사용함. >> 다운 캐스팅 
			
			//에러는 mlist[2]부터 생김. G102를 G304로 형변환하려고 했으니까.  형제끼린 형변환 x?
		
		
			//연산자
			//- instanceof
			//- 2항 연산자임. (피연산자가 왼쪽에 하나 오른쪽에 하나 옴.)
			//- A라는 객체가 B라는 자료형의 객체냐?
			//- = A를 B로 형변환이 가능한가?
			
			//System.out.println(mlist[i] instanceof G304);
		
			if (mlist[i] instanceof G304) { //G304모델이면! 형변환 해라~ 그리고 clean() 기능을 써라
				((G304) mlist[i]).clean(); //형변환한 결과를 한번 더 괄호로 묶어야 함.
				
			}
			
			if (mlist[i] instanceof G102) {
				((G102) mlist[i]).check();
			}
			
			if (mlist[i] instanceof M331) {
				((M331) mlist[i]).charge();
			}
			
		}
		
		
		//일괄적인 통제는 한번에 관리하는 게 좋음. 공통적인 기능만 쓴다면 for문으로 한번에 해결할 수 있으니 장점이 있지만
		//각각 고유의 기능을 써야한다면 다시 원래 자료형으로 형변환을 해줘야한다는 단점.
		
		//각자 관리하는 것은 for문을 여러번 돌려야한다는 단점이있지만 각각 고유의 기능을 쓸땐 장점.
		
		//뭐가 낫다 별로다 할 수 없음. 그때 보면서. 만약 공통 기능만 쓸거면 한꺼번에 통제하는 걸 쓰는게 좋지만
		//각각의 기능을 쓰는것도 있다면 따로 통제하는 방안도 생각해봐야함 -> 상황에 따라 통제해야해.
		
		
		
		
		
		
		
	}//main
}//Ex47

//b.
class Mouse {
	public void click() {
		
	} //부모클래스에 click()이 생긴순간 자식클래스에 있던 click()는 부모클래스의 clikc()을 오버라이드한게 됨.
	
}


//source -> constructor Using fields
//source -> toString() // dump메소드
class G304 extends Mouse { //b. extends Mouse 추가
	
	private String type;
	private int price;
	private int dpi;
	private int button;
	
	public G304(String type, int price, int button, int dpi) {
		this.type = type;
		this.price = price;
		this.button = button;
		this.dpi = dpi;
	}

	@Override
	public String toString() {
		return "G304 [type=" + type + ", price=" + price + ", button=" + button + ", dpi=" + dpi
				+ "]";
	}
	
	public void click() {
		System.out.printf("클릭합니다.%d, %d\n", this.price, this.dpi);
	}
	
	public void clean() {
		System.out.println("광센서를 자동으로 세척합니다.");
	}
}



class G102 extends Mouse {
	private String type;
	private int price;
	private int dpi;
	private String color;
	
	public G102(String type, int price, int dpi, String color) {
		super();
		this.type = type;
		this.price = price;
		this.dpi = dpi;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "G102 [type=" + type + ", price=" + price + ", dpi=" + dpi + ", color=" + color
				+ "]";
	}
	
	public void click() {
		System.out.printf("Click~ %s\n", this.color);
	}
	
	public void check() {
		System.out.println("현재 DPI를 체크합니다.");
	}
	
}


class M331 extends Mouse {
	
	private String type;
	private String color;
	private int price;
	private int dpi;
	
	public M331(String type, String color, int price, int dpi) {
		super();
		this.type = type;
		this.color = color;
		this.price = price;
		this.dpi = dpi;
	}

	@Override
	public String toString() {
		return "M331 [type=" + type + ", color=" + color + ", price=" + price + ", dpi=" + dpi + "]";
	}
	
	public void click() {
		System.out.printf("클릭!! %s\n", this.type);
	}
	
	public void charge() {
		System.out.println("충전합니다.");
	}
}




















