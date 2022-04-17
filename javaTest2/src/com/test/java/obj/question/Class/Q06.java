package com.test.java.obj.question.Class;

import java.util.Calendar;

public class Q06 {

	public static void main(String[] args) {
		//06. Refrigerator 클래스와 Item 클래스를 설계하시오.
		
		//Ex35예제 복습하고 
		//문제 제대로 이해해서
		// 틀 좀 잡고
		// 풀어보자,,,,,,
		
		//지금 문제에 나온 기초코드부터
		//이해가 졸라 안되고 있으니께,,ㅎㅎ
		
		
		
		Refrigerator r = new Refrigerator();

		Item item1 = new Item();
		item1.setName("김치");
		item1.setExpiration(2022, 4, 8);
		r.add(item1);//냉장고에 넣기
		
		Item item2 = new Item();
		item2.setName("깍두기");
		item2.setExpiration(2022, 4, 1);
		r.add(item2);//냉장고에 넣기

		Item item3 = new Item();
		item3.setName("멸치볶음");
		item3.setExpiration(2022, 4, 3);
		r.add(item3);//냉장고에 넣기

		//Item item4 = r.get("깍두기");//냉장고에서 꺼내기
		//System.out.printf("%s의 유통기한 : %d\n", item4.getName(), item4.getExpiration());

		//System.out.printf("냉장고 안의 총 아이템 개수 : %d개\n", r.count());

		//r.listItem();
		
		
		
	}//class
	
}//Q06



class Refrigerator {
	
	private Item[] items = new Item[100];
	
	private int j = 0; // 임의로 추가
	
	public void add(Item item) {
		
		if (j == 99) {
			System.out.println("더이상 남아있는 냉장고 공간이 없습니다.");
			return;
			
		} else {
		
		this.items[j] = item;
		//System.out.printf("'%s'를 냉장고에 넣었습니다.\n", items[i].getName());
		
		}
	}
	
	public Item get(String name) { //Item get...... 이 코드 더 공부해보기...
		System.out.println();
		
		int count = 0;
	//	for (int i=count; )
		
		j--;
		this.items[j] = null;
		
		return null;
		
	}
	
	public int count() {
		return 0;
		
	}
	
	public void listItem() {
		
	}
	




	
	
}



class Item {
	private String name;
	
	private Calendar expiration;

	
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	
	public void setExpiration(int year, int month, int date) {
		
		Calendar expriration = Calendar.getInstance();
		expiration.set(year, month-1, date);
		this.expiration = expiration;
		

		
	}
	
}

















