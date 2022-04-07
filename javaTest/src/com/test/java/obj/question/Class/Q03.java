package com.test.java.obj.question.Class; //완료 (tick부분 +1 왜 해야 하는지 고민)

import java.util.Calendar;

public class Q03 {

	public static void main(String[] args) {

		// Q03. 과자(Bugles) 클래스를 설계하시오.
		// Calendar 사용.
		// *** tick 부분 (+1일 해야하는이유) 고민해보기
		// *** 뭔가 자정 기준이라서 +1일을 해야하는 거 같기도 하고..


		Bugles snack = new Bugles();

		snack.setWeight(500);
		snack.setCreationTime(2022, 3, 20);
		System.out.printf("가격 : %,d원\n" , snack.getPrice());
		System.out.printf("유통기한이 %d일 남았습니다.\n", snack.getExpiration());

		snack.eat();
		
		Bugles snack2 = new Bugles();

		snack2.setWeight(300);
		snack2.setCreationTime(2022, 3, 12);
		System.out.printf("가격 : %,d원\n" , snack2.getPrice());
		System.out.printf("유통기한이 %d일 남았습니다.\n", snack2.getExpiration());

		snack2.eat();
		
	}// main
}// Q03


class Bugles {

	private int price; 	//읽기전용 getter만
	private int weight; //쓰기전용 Setter만
	private Calendar creationTime; //쓰기전용
	private int expiration; //읽기전용
	

	
	
	public int getPrice() {
				
		switch(this.weight) {
			case 300:
				this.price = 850;
				break;
			case 500:
				this.price = 1200;
				break;
			case 850:
				this.price =  1950;
				break;
		}
		
		return this.price;
	}


	public int getExpiration() {		// setter/getter엔 비지니스 코드 x -> 수정해야함.
		
		switch(this.weight) {
			case 300:
				this.expiration = 7;
				break;
			case 500:
				this.expiration = 10;
				break;
			case 850:
				this.expiration = 15;
				break;
		}
		
		//먹을 수 있는 날짜(일) = 유통기한(일) - (현재(일) - 제조시간(일))
		
		long creationTimeTick = creationTime.getTimeInMillis();
		
		Calendar now = Calendar.getInstance();
		long nowTick = now.getTimeInMillis();
		
		long eatTick; //현재(일) - 제조시간(일)
		eatTick = ((nowTick - creationTimeTick)/1000/60/60/24);
		
		this.expiration -= eatTick + 1; // //TODO +1을 왜 해야할까? >> 해결
		
		//double값을 해야 정확한데 double로 받으면.. 남은기간이 양수일땐 정확히 나오는데 음수일땐 틀리게 나옴.
		//double로 했을때 남은기간이 양수이면 5일(O), 음수이면 -5일(X) > 3/24 기준 양수는 5일, 음수는 -6일 나와야함.
			//+1을 하면 양수는 4일(X), 음수는 -6일(O)
		
		//그냥 long으로 계산하고 +1을 하면 양수일때나 음수일때나 둘다 정확하게 나옴.
		// -> 유통기한도 포함해야 하니까 +1해야함 !! 
				
		return expiration;
	}




	public void setWeight(int weight) {
		
		if (weight == 300 || weight == 500 || weight == 850) {
			this.weight = weight;
		} else {
			System.out.println("용량 오류");
		}
		
	}



	public void setCreationTime(int year, int month, int date) {
		Calendar creationTime = Calendar.getInstance();
		creationTime.set(year, month-1, date);
		this.creationTime = creationTime;
		
		
	}



	public void eat() {
		
		if (this.expiration > 0) {
			System.out.println("과자를 맛있게 먹습니다.\n");
		} else {
			System.out.println("유통기한이 지나 먹을 수 없습니다.\n");
		}
	
	}

}


