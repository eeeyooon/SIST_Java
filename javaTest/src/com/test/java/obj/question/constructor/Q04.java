package com.test.java.obj.question.constructor;	//03.25 과제(완료)

public class Q04 {

	public static void main(String[] args) {
		// Q04. 음료를 판매하고 그 매출액과 판매량을 구하시오.


		// 바리스타
		Barista barista = new Barista();

		// 손님 1
		// 에스프레소 1잔 주문 - 원두 30g
		Espresso e1 = barista.makeEspresso(30);
		e1.drink();
		// 손님 2
		// 라테 1잔 주문 - 원두 30g, 우유 250ml
		Latte l1 = barista.makeLatte(30, 250);
		l1.drink();

		// 손님 3
		// 아메리카노 1잔 주문 - 원두 30g, 물 300ml, 각얼음 20개
		Americano a1 = barista.makeAmericano(30, 300, 20);
		a1.drink();
		System.out.println();

		// 손님 4
		// 에스프레소 10잔 주문 - 원두 25g
		Espresso[] e2 = barista.makeEspressoes(25, 10);

		for (Espresso e : e2) {
			e.drink();
		}
		System.out.println();
		// 손님 5
		// 라테 5잔 주문 - 원두 25g, 우유 300ml
		Latte[] l2 = barista.makeLattes(25, 300, 5);

		for (Latte l : l2) {
			l.drink();
		}
		System.out.println();

		// 손님 6
		// 아메리카노 15잔 주문 - 원두 20g, 물 350ml, 각얼음 30개
		Americano[] a2 = barista.makeAmericanos(20, 350, 30, 15);

		for (Americano a : a2) {
			a.drink();
		}
		System.out.println();

		// 결산
		barista.result();



	}// main
}// Q04


class Barista { // 바리스타 클래스

	public Espresso makeEspresso(int bean) {

		Espresso Espresso = new Espresso(bean);
		return Espresso;


	}


	public Espresso[] makeEspressoes(int bean, int count) {

		
		Espresso[] Espresso = new Espresso[count];
		for(int i=0; i<Espresso.length; i++) {
			Espresso[i] = new Espresso(bean);
		}
		
		return Espresso;
	}


	public Latte makeLatte(int bean, int milk) {
		Latte Latte = new Latte(bean, milk);
		return Latte;
	}


	public Latte[] makeLattes(int bean, int milk, int count) {

		Latte[] Latte = new Latte[count];

		for (int i = 0; i < Latte.length; i++) {
			Latte[i] = new Latte(bean, milk);
		}

		return Latte;
	
	}

	public Americano makeAmericano(int bean, int water, int ice) {
		Americano Americano = new Americano(bean, water, ice);
		return Americano;
	}


	public Americano[] makeAmericanos(int bean, int water, int ice, int count) {

		Americano[] Americano = new Americano[count];

		for (int i = 0; i <Americano.length; i++) {
			Americano[i] = new Americano(bean, water, ice);
		}
		return Americano;
		
	}


	public void result() { // 음료 판매량, 원자재 소비량, 매출액

		/*
		---------------------------------
		음료 판매량
		---------------------------------
		에스프레소 : 11잔
		아메리카노 : 16잔
		라테 : 6잔
		
		---------------------------------
		원자재 소비량
		---------------------------------
		원두 : 765g
		물 : 5,550ml
		얼음 : 470개
		우유 : 1,750ml
		
		---------------------------------
		매출액
		---------------------------------
		원두 : 765원
		물 : 1,110원
		얼음 : 1,410원
		우유 : 7,000원
		
		*/
		System.out.println();
		System.out.println("=================================");
		System.out.println("판매 결과");
		System.out.println("=================================");
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("음료 판매량");
		System.out.println("---------------------------------");
		System.out.printf("에스프레소 : %d잔\n", Coffee.espresso);
		System.out.printf("아메리카노 : %d잔\n", Coffee.americano);
		System.out.printf("라떼 : %d잔\n", Coffee.latte);
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("원자재 소비량");
		System.out.println("---------------------------------");
		System.out.printf("원두 : %,dg\n", Coffee.bean);
		System.out.printf("물 : %,dml\n", Coffee.water);
		System.out.printf("얼음 : %d개\n", Coffee.ice);
		System.out.printf("우유 : %,dml\n", Coffee.milk);
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("매출액");
		System.out.println("---------------------------------");
		System.out.printf("원두 : %,d원\n", Coffee.beanTotalPrice);
		System.out.printf("물 : %,d원\n", Coffee.waterTotalPrice);
		System.out.printf("얼음 : %,d원\n", Coffee.iceTotalPrice);
		System.out.printf("우유 : %,d원\n", Coffee.milkTotalPrice);
		System.out.println();


	}



}


class Coffee { // 공용 정보 클래스

	public static int bean; // 총 원두량(g)

	public static int water; // 총 물 용량(ml)

	public static int milk; // 총 우유 용량(ml)

	public static int ice; // 총 얼음 개수(개)

	public static int beanUnitPrice = 1; // 원두 단가(원) 1g당 1원

	public static double waterUnitPrice = 0.2; // 물 단가(원) 1ml당 0.2원

	public static int iceUnitPrice = 3; // 얼음 단가(원) 1개당 3원

	public static int milkUnitPrice = 4; // 우유 단가(원) 1ml당 4원

	public static int beanTotalPrice; // 원두 총 판매액(원)

	public static int iceTotalPrice; // 얼음 총 판매액(원)

	public static int milkTotalPrice; // 우유 총 판매액(원)

	public static int waterTotalPrice; // 물 총 판매액(원)

	public static int americano; // 아메리카노 총 판매 개수(잔)

	public static int latte; // 라테 총 판매 개수(잔)

	public static int espresso; // 에스프레소 총 판매 개수(잔)



}


class Espresso { // 에스프레소 클래스

	private int bean;


	public Espresso(int bean) {
		if (bean > 0) {
			this.bean = bean;
			Coffee.bean += bean;
			Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
			Coffee.espresso++;
		} else {
			System.out.println("에스프레소 원두 오류");
		}


	}

	public int getBean() {
		return bean;
	}

	public void setBean(int bean) {
		this.bean = bean;
	}


	public void drink() {
		System.out.printf("원두 %dg으로 만들어진 에스프레소를 마십니다.\n", this.bean);
		//this.bean이 아니라 Coffee.bean으로 해버리면
		//모든 커피의 총 원두량이 나옴.
		


	}


} // Expresso


class Latte {

	private int bean;
	private int milk;


	public Latte(int bean, int milk) {
		if (bean > 0 && milk > 0) {
			this.bean = bean;
			this.milk = milk;
			Coffee.bean += bean;
			Coffee.milk += milk;
			Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
			Coffee.milkTotalPrice += milk * Coffee.milkUnitPrice;
			Coffee.latte++;

		} else {
			System.out.println("라떼 재료 오류");
		}


	}



	public int getBean() {
		return bean;
	}



	public void setBean(int bean) {
		this.bean = bean;
	}



	public int getMilk() {
		return milk;
	}



	public void setMilk(int milk) {
		this.milk = milk;
	}



	public void drink() {

		System.out.printf("원두 %dg, 우유 %dml로 만들어진 라테를 마십니다.\n", this.bean, this.milk);
		

	}

} // Latte



class Americano { // 아메리카노 클래스

	private int bean; // g
	private int water; // ml
	private int ice; // 개수


	public Americano(int bean, int water, int ice) {
		if (bean > 0 && water > 0 && ice > 0) {
			this.bean = bean;
			this.water = water;
			this.ice = ice;
			Coffee.bean += bean;
			Coffee.water += water;
			Coffee.ice += ice;
			Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
			Coffee.waterTotalPrice += water * Coffee.waterUnitPrice;
			Coffee.iceTotalPrice += ice * Coffee.iceUnitPrice;

		} else {
			System.out.println("아메리카노 재료 오류");
		}

	}



	public int getBean() {
		return bean;
	}


	public void setBean(int bean) {
		this.bean = bean;
	}


	public int getWater() {
		return water;
	}



	public void setWater(int water) {
		this.water = water;
	}



	public int getIce() {
		return ice;
	}


	public void setIce(int ice) {
		this.ice = ice;
	}



	public void drink() {
		System.out.printf("원두 %dg, 물 %dml, 얼음 %d개로 만들어진 아메리카노를 마십니다.\n", this.bean, this.water,
				this.ice);
	}



}// Americano


