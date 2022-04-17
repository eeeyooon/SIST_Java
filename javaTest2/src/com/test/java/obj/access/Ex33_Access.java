package com.test.java.obj.access; //03.23

public class Ex33_Access {

	//Ctrl + Tab > 탭전환 
	public static void main(String[] args) {
		
		
		//접근 지정자(제어자), Access Modifier
		//- 클래스 멤버에 붙여서 사용한다.
		//- 클래스 자체에 붙여서 사용한다.
		//- 지역변수에는 사용 불가능
		//- 클래스(객체)의 영억을 기준으로 외부에 해당 멤버를 노출하는 수위를 결정
		//- 멤버를 외부에 공개할지 여부와 공개한다면 어느 정도를 공개할지를 조절하는 역할
		
		//1. public > 100% 공개
		//2. private > 100% 비공개
		//-----------(오늘은 위에 2개만)
		//3. protected
		//4. default
		
		
		Book b1 = new Book();
		
		b1.title = "자바의 정석";	// > public
		//b1.author = "남궁성"; //error. > private
		
		//"홍길동" 직원이 Phone 클래스를 설계
		//"아무개" 직원이 객체 새성
		
		/*
		public을 private으로 바꾸니까 당연 error
		
		Phone p1 = new Phone();
		
		p1.model = "S22";
		p1.color = "white";
		p1.price = 1200000;
		p1.weight = 350;
		
		System.out.println(p1.model);
		System.out.println(p1.color);
		System.out.println(p1.price);
		System.out.println(p1.weight);
		
		Phone p2 = new Phone();
		
		p2.model = "A10";
		p2.color = "yellow";
		p2.price = 1000000000;
		p2.weight = 1000000000;
		
		// > 말도 안되는 숫자를 넣어도 그냥 실행돼. 이런일이 없게 제약 주려고 private
		System.out.println(p2.model);
		System.out.println(p2.color);
		System.out.println(p2.price);
		System.out.println(p2.weight);
		
		
		*/
		
		
		Phone p3 = new Phone();
		//p3. // > 아무것도 안뜸
		
		p3.aaa("S22"); // model 변수에 "S22"저장
		System.out.println(p3.bbb()); //p3.bbb = model
		
		p3.ccc(1200000); 
		System.out.println(p3.ddd());
		
		System.out.println();
		
		
		//두번째수업
		
		SmartPhone s1 = new SmartPhone();
		
		s1.setModel("S22");
		s1.setColor("white");
		s1.setPrice(120);
		s1.setWeight(300);
		
		
		System.out.println(s1.getModel());
		System.out.println(s1.getColor());
		System.out.println(s1.getPrice());
		System.out.println(s1.getWeight());
		
		
		System.out.println();
		
		
		//******
		//클래스 설계시 접근 지정자 가이드 //TODO 접근지정자 가이드 (2022. 3. 23. 오후 3:44:22)
		//1. 멤버 변수 > private
		//2. 필요한 Getter/Setter > public
		//3. 불필요한 (호출x) 내부 멤버 메소드 > private
		//4. 외부 호출 멤버 메소드 > public
		
		//잘 모르겠다;;
		//1. 무조건 모두 다 private
		//2. 일단 Getter/Setter만 public
		//3. 필요한데 안보이는 애가 생기면 그때마다 하나씩 public으로 교체
		
		
		//세번째 수업
		
		
		Cup cup = new Cup();
		
		//Getter/Setter 역할
		//1. 멤버 보호(멤버 변수에 유효하지 않은 값이 들어가는 것을 방지!!)
		//2. 쓰기 전용, 읽기 전용 가능
		//3. 계산된 멤버 생성 가능
		
		
		//쓰기,읽기 프로퍼티
		cup.setColor("brown"); //쓰기
		System.out.println(cup.getColor()); //읽기 
		
		//쓰기 전용 프로퍼티
		cup.setWeight(500);
		//System.out.println(cup.getWeight); //읽기x -> Getter 안만듦
		
		//읽기 전용 프로퍼티
		//cup.setPrice(2000); //쓰기x
		System.out.println(cup.getPrice()); //읽기
		
		//변수는 쓰기전용이 안됨. (읽기전용은 파이널 상수)
		//메소드로 만들면 이런 통제가 가능.
		
		//private String info;가 없는데 있는 것처럼 보임
		// 얜 내부에서 가지고 있는 데이터를 가공처리해서 또다른 값을 보내줌.
		// 이걸 계산된 멤버라고..?
		System.out.println(cup.getInfo());
		
		
	} //main
	
} //Ex33

//정보 은닉화
//인터페이스
//캡슐화


//객체 > 내부에 여러가지 멤버 소유

//케이스(캡슐)로 감싸는 이유?
//- 외부로부터 내부 요소를 보호하기 위해서
//- 객체의 사용법을 단순화하기 위해서


//blackbox -> 동작만 잘되면 안에서 무슨 일이 일어나는지 알 필요 x 그래서 캡슐화하는 이유도 o
class Book { 
	
	public String title;	//도서명
	private String author;	//저자
	
	
}


class Phone {
	
	//1. 무조건 멤버 변수는 private을 지정한다. > why?
	// - public으로 하면 외부에서 맘대로 사용함. 그러니까 private으로!! >> 리모콘 메인보드를 플라스틱으로 감싸서 숨김
	private String model;
	private String color;
	private int price;
	private int weight;
	
	//2. public 메소드를 생성한다.  > 대리자 > 인터페이스 > 리모콘의 버튼들..(올바른 사용일때만 조작 O, 아니면 조작 x) 
												//	>> 객체의 사용법(방법)
	
	public void aaa(String a) {
		//멤버변수의 스코프(생명주기)는 클래스 전체. 그 내에서 어디든 접근 가능.
		//클래스 안에선 public이든 private이든 상관없음. 사용가능.
		
		model = a; //매개변수를 넣으면 private도 public과 같은 효과를 냄
	}
	
	public String bbb() { //model을 직접 접근은 못해도 메소드를 통해 호출하여 model값을 돌려줌.
		return model;
	}
	
	public void ccc(int c) {
		
		if (c >=0 && c <= 1500000) { //가격의 제약을 두기 위해 private으로 받은거니까 여기서 제약 걸어
			price = c;
		} else {
			System.out.println("에러");
			
		}
	}
	
	public int ddd() {
		return price;
	}
}



//두번째 수업
class SmartPhone {
	
	//1. 멤버변수는 > 무조건 private
	private String model;
	private String color;
	private int price;
	private int weight;
	
	
	//2. 인터페이스 역할 메소드 생성
	
	//setter
	//- 쓰기
	//- 보통 setXXX()
	//- set멤버변수 + 메소드니까 캐멀표기법 -> 모델에 값 저장.
	
	public void setModel(String model) { //aaa 
		
		//model = model; >> 이건 둘다 매개변수 model임. (범위가 더 적은 것)
		
		//this.멤버변수 = 매개변수(지역변수) 
		//this = 현재 코드가 들어있는 객체 자신을 뜻함. "객체 자신, 나!" -> 상대표현 
		// SmartPhone s1 -> 이것도 객체이지만 얜 절대표현 (이름)
		// 둘다 동일한 객체를 표현하는 말인데 s1은 남이 불러주는 객관적인 이름, 
		// 상대적으로 자신이, 자신 스스로를 부르는 말이 this
		//만약 밑에꺼가 s1.model 이라고 하지 않는건 -> 객체를 만드는중인데 객체 이름을 어떻게 알고 넣냐
											 // 그냥 '나'라고 표현하는 것.
		//s1은 객체 밖, this는 객체 안. 그런데 뭐 동일한 위치에 서있는 것.
		//s1은 객체 안을 못보는데 this는 객체 안 (private까지) 다 볼 수 있음.
		this.model = model;
		
		
		
		
	}
	
	//getter
	//- 읽기
	//- getXXX()
	//- get멤버변수() -> 읽기 가능. 모델의 값이 뭔지 꺼낼 수 있음. 
	public String getModel() {//bbb
		return this.model; //혼자니까 충돌이 안나니 this를 안붙여도 되지만 가독성 땜에 보통 적음. (아 멤버변수구나!)
		
	}
	
	//color
	public void setColor(String color) {
		
		// 색상 > 주관식x고 정해져있겠지. (제한O) > 선택 >> 열거형이라고 함.
		if (color.equals("black")
			|| color.equals("white")
			|| color.equals("red")
			|| color.equals("yellow")
			|| color.equals("blue")) {
			this.color = color;
		} else {
			System.out.println("존재하지않는 색상입니다.");
		}
	}
	
	public String getColor() {
		return this.color;
	}
	
	
	//price
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
		
	}
	
	
	//weight
	public void setWeight(int weight) {
		
		if (weight > 0) {
			this.weight = weight;
		}
		
	}
	
	public double getWeight() { //just 돌려주기만(읽기작업만
		return calcWeight(this.weight); //g을 받고 kg으로 출력하기위해 
	//  return weight / 1000.0	 		//이렇게 getter에서 가공작업을 하기도
	//  이게 굉장히 긴 코드라 치고, 메소드로 빼서 calcWeight	메소드 생성
	}
	
	
	
	//**** 이 메소드의 성격?
	//- Getter X
	//- 내부업무(getter)에 필요한 작업을 분리시키기 위해 
	// 얜 사용자가 쓰라고 만든게 아니라 스마트폰클래스 내부에서 쓰기 위해 만든거임.
	// 그러니까 공개할 필요가 없음!!! 사용자에게 혼동을 줄 수 있기 때문에 이런건 private해야 함.
	// 메소드도 공개를 원치않으면 private으로 바꾸면 됨
	private double calcWeight(int weight) {
		
		return weight / 1000.0;
	}
}


//********모든 상황에서 범위가 큰 요소와 범위가 작은 요소끼리 충돌 발생
// 		  > 무조건(100%) 범위가 작은 요소가 우선함.



//세번째 수업


class Cup {
	
	private String color;
	private int weight;
	private int price;
	private String type;
	
	//클래스 영역 아무데나 누르고 오른쪽 버튼 > Source > Generate Getters and Setters >> 한번에 생성
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
	
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	
	
	public int getPrice() {
		return price;
	}
	

	
	
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getInfo() {
		
		if (this.price < 500) {
			return "싼 컵";
		} else if(this.price < 1000) {
			return "보통 컵";
		} else {
			return "비싼 컵";
		}
		
	}
	
}








