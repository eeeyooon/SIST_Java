package com.test.java.collection; //03.31 

import java.util.ArrayList;

public class Q01 {

	public static void main(String[] args) {
		
		//테스트용 진짜 ArrayList
		ArrayList<String> list2 = new ArrayList<String>(); 
		
		MyArrayList list = new MyArrayList();
		
		//add test
		list2.add("홍길동");
		list2.add("아무개");
		list2.add("테스트");
		list2.add("하하하");
		list2.add("헤헤헤");
		
		//add
		list.add("홍길동");
		list.add("아무개");
		list.add("테스트");
		list.add("하하하");
		list.add("헤헤헤");
	
		
		//list.add("호호호"); // -> 방 4칸짜리인데 하나 더 넣으려고 하니 당연 에러. 이걸 어떻게 해결할래?
	
		System.out.println(list2);
		System.out.println(list);
	
		System.out.println();
		
		//set test
		System.out.println(list2.size());

		//set
		System.out.println(list.size());
		
		System.out.println();
		
		//set test
		list2.set(2, "테스트2");
		
		System.out.println(list2);
		
		//set
		list.set(2, "테스트2");
		
		System.out.println(list);
		
		System.out.println();
		
		
		//remove test
		list2.remove(2);

		System.out.println(list2);
		
		System.out.println();
		
		//remove
		list.remove(2);
		
		System.out.println(list);
		
		System.out.println();
		
		
		//add test (삽입)
		list2.add(1,"하하하");
		System.out.println(list2);
		System.out.println();
		
		//add
		
		list.add(1,"하하하");
		System.out.println(list);
		System.out.println();
		
		
		//indexOf test
		System.out.println(list2.indexOf("하하하")); //1
		
		System.out.println();
		
		//indexOf
		System.out.println(list.indexOf("하하하")); //1
		
		//입력값이 배열에 없을 경우 -1 출력도 OK
		
		System.out.println();
		
		//lastIndexOf test
		System.out.println(list2.lastIndexOf("하하하")); //3
		
		System.out.println();
		
		//lastIndexOf
		System.out.println(list2.lastIndexOf("하하하")); //3
		
		
		System.out.println();
		
		//clear test
		list2.clear();
		System.out.println(list2.size()); //0
		System.out.println();
		
		//clear
		list.clear();
		System.out.println(list.size()); //0
		
		System.out.println();
		
		
		
		
		
		
	}
	
	//main
	
}//Q01
