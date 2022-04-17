package com.test.java.obj.contstructor; //03.25

public class Ex36_Constructor {

	public static void main(String[] args) {
		
		//Ex36_Constructor.java
		
		
		/*
		 	
		 	생성자, Constructor
		 	- (특수한 목적을 가지는)메소드
		 	- 객체 멤버(=멤버변수)를 초기화하는 역할을 가지는 메소드 //변수 안에다 처음에 가져야할 값을 넣는 걸 초기화라고.
		 	- 일반 메소드처럼 마음대로 호출이 불가능하다. > 객체가 생성될 때 딱 1번만 호출된다. > 그 뒤에는 호출이 불가능 > 1회용임
		 	- 생성자는 클래스의 이름과 동일한 이름을 가짐.
		 	
		 	
		 	new, 객체 생성 연산자
		 	
		 	
		 	Test();
		 	
		 	Test t = new Test(); // new Test에서 Test가 생성자
		
		
		*/
		
		
		User u1 = new User(); //우리 눈엔 안보이지만 User메소드는 클래스 안에 있음 -> 자동으로 생기기때문에 안보이는 것. > 그걸 호출도 한것.
		
		System.out.println(u1.getName());	//null
		System.out.println(u1.getAge());	//0
		System.out.println(u1.isFlag());	//false	>> 이 초기값을 넣는 작업을 User메소드가 함.
		System.out.println();
		
		//12시 수업
		//하얀색, 미정
		//(3) (4) (1) (2) (5) : 실행 순서
		//____ _ ___ _____ _
		Cup c1 = new Cup() ;
		
		
		// new가 변수들 다 만들고 (집 만 들고 각각 방 만들고 ) > 생성자는 그 방안에 값을 찔러 넣음 (정해놓은 데이터 = 초기화)
		// new는 object만들기 + 생성자는 object의 멤버변수에 값을 넣어주는 역할 >> 각각 역할이 다름.
		
		
		//setter 역할 > 객체 초기화 (근데 이건 그냥 생성자로 하고)
		//setter 역할 > 초기화되어있는 각각에 객체를 개별 변경해줌. >> 객체 정보 수정
		//c1.setColor("yellow");
		
		//c1.setColor("white");
		//c1.setOwner("미정");
		
		Cup c2 = new Cup();
		
		//c2.setColor("white");
		//c2.setOwner("미정"); // 생성자에서 설계 (초기 상태를 세팅하는 전용 메서드 == 기본생성자)
							  // 메소드로 빼면 이렇게 c1, c2마다 각각 세팅을 할필요가 없음. 또한 메인안에서 코드가 깔끔해짐.
		
		c1.info();
		c2.info();
		
		
		
		
	} //main
} //Ex36


class Cup {
	
	private String color;
	private String owner;
	
	
	//생성자 만들자 ctrl + space 누르면 바로 생성자 뜸 (기본 생성자)
	//기본 생성자는 개발자가 작성 안하면 자동 생성됨.
	//기본 생성자는 개발자가 작성하면 자동생성 x. 
	//개발자가 기본생성자를 만들어 놓고 일부 멤버를 초기화를 안해도 그 일부 멤버에 한해서는 자동으로 초기화 코드가 작성됨.
	//(꼭 초기화를 해야하는게 기본 설정이 되어있음.)
	
	//***** > 객체의 멤버 변수는 반드시 초기화 과정을 거치게 된다. (개발자가 하든, 컴파일러가 자동으로 그 초기화 코드를 넣어주든.)
	
	
	public Cup() {
		this.color = "white";
		this.owner = "미정";
	}
	
	
	public void setColor(String color) {
		this.color = color;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	public void info() {
		System.out.printf("색상: %s, 소유주: %s\n", this.color, this.owner);
		
		
	}
	
	
	
	
}




class User {
	
	
	private String name;
	private String id;
	private int age;
	private boolean flag; //멤버변수를 boolean으로 만들면 setter는 set그대로 가는데 getter는 is로바뀜.
	
	
	
	
	//기본 생성자
	//1. 메소드명 == 클래스명
	//2. 반환값 명시 안함 > 생성자 반환값을 가질 수 없다. > 표현 안함.
	//3. return문 가질 수 없다.
	//4. 구현부는 해당 클래스의 멤버를 초기화하는 코드를 작성한다. (****)
	
	
	
	public User() { //반환타입이 없음.(void조차 없음) 
		
//		this.name = null;
//		this.id = null;
//		this.age = 0;
//		this.flag = false;
		
		// > 이게 우리가 하지도 않았는데도 생성자가 자동으로 한 작업 
		
//		this.name = "익명";
//		this.id = "none";
//		this.age = -1;
//		this.flag = true;
		
	}
	
	
	


	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public int getAge() {
		return age;
	}
	
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public boolean isFlag() {
		return flag;
	}
	
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}



















