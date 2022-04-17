package com.test.java.obj.contstructor; //03.25

public class Ex37_Constructor {

	public static void main(String[] args) {
		
		//Ex37_Constructor
		//클래스 만들 때 getter/setter와 생성자는 걍 기본.
		
		
		
		//공산품 > 일괄적 초기화 (모든 제품이 같은 초기화) > model(m705), price(40000)
		Mouse m1 = new Mouse();
		
		Mouse m2 = new Mouse();
		m2.setPrice(35000);
		
		//QC > discount > 35000 > setPrice로 고칠 수 있음.
		
		Mouse m3 = new Mouse();
		m3.setPrice(35000);
		
		//객체의 초기 상태 > 상황에 따라 달라질 수 있음. 
					// > 이렇게 상황에 따라 달라져야할 경우엔 생성자의 매개변수 사용 > 다양성
					//  (인자가 있는 메소드를 만들어서 내부에서 통제해!)
		Mouse m4 = new Mouse(35000);
		
		Mouse m5 = new Mouse("A100"); //모델명은 지정하고 가격은 기본값으로 
		
		Mouse m6 = new Mouse("B123", 30000); 
		
		System.out.println(m1.getModel() + "," + m1.getPrice());
		System.out.println(m2.getModel() + "," + m2.getPrice());
		System.out.println(m3.getModel() + "," + m3.getPrice());
		System.out.println(m4.getModel() + "," + m4.getPrice());
		System.out.println(m5.getModel() + "," + m5.getPrice());
		System.out.println(m6.getModel() + "," + m6.getPrice());
		 
		
	}//main
} //Ex37


class Mouse {
	
	private String model;
	private int price;
	
	public Mouse() { //일괄 초기화 // 인자가 없을땐 자동으로 이 메소드를 호출
		
		this.model = "M705";
		this.price = 40000;
		
	}
	
	public Mouse(int price) { //생성자도 메소드라서 오버로딩 가능 (int인자가 있는 메소드 생성)
		// 40000으로 처음부터 초기화하지말고 처음부터 35000원을 넣고 싶을 때
		// 인자가 있을땐 이 메소드가 자동으로
		
		this.model = "M705";
		this.price = price;
		
	}
	
	public Mouse(String model) {
		this.model = model;
		this.price = 40000;
		
	}
	
	public Mouse(String model, int price) {
		this.model = model;
		this.price = price;
	}
	
	
	
	
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
































