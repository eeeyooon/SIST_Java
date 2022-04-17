package com.test.java.obj.staticmemeber; //03.25

public class Ex40_static {

	public static void main(String[] args) {
		//Ex40_static.java
		
		//요구사항]
		//1. 펜을 생산하시오.
		//2. 생산된 펜의 개수를 세시오.
		
		//Case 1. (일부러 더 꼬투리 잡는거임. 더 좋은 방법 알려주려고)
		//- Pen과 count간의 관계 약함. > 가독성도 낮음. (count라는 이름이 Pen하고 아무 상관이 없으니까)
		//- 오차 발생가능성이 높음. (count++; 누락하면 카운팅 x , count++; 두번해서 두번 누적, ... 등 )

//		int count = 0;
//		Pen p1 = new Pen("Monami", "Black");
//		count++;
//		
//		Pen p2 = new Pen("Monami", "Black");
//		count++;
//		
//		Pen p3 = new Pen("Monami", "Black");
//		count++;
//		
//		System.out.println("볼펜 개수: " + count);
		
		
		//Case 2.
		//- count변수와 Pen의 관계를 강하게 연결 > 결합 시킬 거임
		// class에서 count 변수 생성
		
//		Pen p1 = new Pen("Monami", "Black");
//		p1.count++; 
//		
//		Pen p2 = new Pen("Monami", "Black");
//		p1.count++; 
//		
//		Pen p3 = new Pen("Monami", "Black");
//		p1.count++;  //p1.count 하나에 저장
//		
//		
//		System.out.println("볼펜 개수: " + p1.count ); 
//		//p1이라는 한낱 객체(개인)이 모든 펜들의 개수를 세는 공통적인 값을 대표로 저장할만한 이유가 없음.
//		//p1이든, p2든, p3든 누구 아무나 가져도 됨. >> 이말은 즉, 볼팬 개수의 데이터를 어느 변수가 가지고 있는지 알수 없다는 것. (코드가 길어지면)
//		
		
		//Case 3.
		//- Pen과 count 변수의 관계 명확
		//- 소재 분명 > 여러곳이 아니라 > 유일! >> 변수 딱 1개
		
//		Pen p1 = new Pen("Monami", "Black");
//		Pen.count++;
//		
//		Pen p2 = new Pen("Monami", "Black");
//		Pen.count++;
//		
//		Pen p3 = new Pen("Monami", "Black");
//		Pen.count++;
//		
//		System.out.println("볼펜 개수: " + Pen.count); //여기 저기 다 있는게 아니라 딱 하나 유일한 Pen.count에 저장됨.
		
		
		//Case 4.
		
		Pen p1 = new Pen("Monami", "Black");
		
		Pen p2 = new Pen("Monami", "Black");
		
		Pen p3 = new Pen("Monami", "Black");
		
		System.out.println("볼펜 개수: " + Pen.count); //굳이 메인에서 카운트 안해도 생성자 내에서 카운트하니까 개수 출력됨.
		
		
		
	}//main
}//Ex40





//class Pen {
//	
//	private String model; // 얘는 객체변수
//	private String color; // 얘도 객체변수
//	public int count = 0; //c2 코드가 복잡해보이니까 잠시 public으로 열어놓음. >> 얘는 공용데이터 그럼?
//	
//	
//	public Pen(String model, String color) {
//		
//		this.model = model;
//		this.color = color;
//		
//	}
//	
//	public String dump() { //dump메소드 - 지금까지 info 였던 것 ^^
//		
//		return String.format("{ model: %s, color: %s }"
//								, this.model
//								, this.color);
//		
//		
//		
//	}
//}


class Pen {
	
	private String model; // 얘는 객체변수
	private String color; // 얘도 객체변수
	public static int count = 0; // 얘는 공용데이터 > static 붙여야지! 공용변수(1개)
	
	
	public Pen(String model, String color) {
		
		this.model = model;
		this.color = color;
		Pen.count++; 	//Case 4. > 펜을 만드는 생성자니까 여기다 카운트하는 것.
	}
	
	public String dump() { //dump메소드 - 지금까지 info 였던 것 ^^
		
		return String.format("{ model: %s, color: %s }"
								, this.model
								, this.color);
		
		
		
	}
}




