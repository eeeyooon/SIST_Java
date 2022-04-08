package com.test.java.collection; //04.08

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex69_LinkedList {

	public static void main(String[] args) {
		
		//Ex69_LinkedList.java
		
		//List > LinkedList
		//Set > TreeSet
		//Map > TreeMap
		
		//m1();
		//m2();
		m3();
		
		
	}//main

	private static void m3() {
		
		//****복습하기 //TODO 인터페이스 사용 예시 복습하기 (2022. 4. 8. 오전 10:35:32)
		//인터페이스의 사용 에
		//***** 인터페이스를 구현하는 객체는 참조변수를 인터페이스로로 만들어라.
		
		
		//ArrayList<Integer> list = new ArrayList<Integer>();
		
		//-> ArrayList를 LinkedList로 바꾸기
		//	1. 참조변수의 자료형 수정
		//	2. 생성자 수정
		//LinkedList<Integer> list = new LinkedList<Integer>();

		
		//위처럼 하지말고 부모로 업캐스팅해(참조변수를 인터페이스로 만들어)
		//***** 리모콘   >  AAA건전지 방전 > 백셀 건전지가 들어있음 -> 다이소건전지로 바꿔치기 
		//***** 프로그램  >  List 인터페이스 > ArrayList 객체 > LinkedList 객체
		
		List<Integer> list = new LinkedList<Integer>(); //업캐스팅함.
		//여전히 유지보수나 기능추가할때 느림.
		//-> 변수타입은 건들지말고 그냥 생성자만 수정하면 돼 
		
		
		//처음엔 Append작업만 할줄 알았음 -> 그래서 Arraylist로 결정
		for (int i=0; i<1000000; i++) {
			list.add(i);	
		}
		
		System.out.println(list.size());
		
		
		//but 1년 뒤  유지보수 or 기능 추가 발생 => 시간이 오래걸리니까 LinkedList로 고쳐야 함.
		for (int i=0; i<5000; i++) {
			list.remove(0); //shift발생
		}
		
		System.out.println(list.size());

		
	}

	private static void m2() {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		
		long begin = 0, end = 0;
		
		//1. 순차적으로 데이터 추가하기, Append
		System.out.println("[순차적으로 데이터 추가하기]");
		
		
		//ArrayList
		begin = System.currentTimeMillis();	
		
		
		for (int i=0; i<1000000; i++) {
			list1.add(i);	//배열 끝에 추가
		}
		
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업 시간 : %,dms\n", end - begin); //23ms(0.02초)
		
		
		
		//LinkedList
		begin = System.currentTimeMillis();	
		
		
		for (int i=0; i<1000000; i++) {
			list2.add(i);	//배열 끝에 추가
		}
		
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업 시간 : %,dms\n", end - begin);	//187ms(0.18초)
		
		
		
		//2. 데이터 삽입하기, Insert > Arraylist는 Shift 발생
		
		System.out.println("[데이터 삽입하기]");
		
		
		//ArrayList
		begin = System.currentTimeMillis();	
		
		
		for (int i=0; i<10000; i++) {
			list1.add(0,i); //맨 앞에서 삽입하면 뒤에 모든 요소들 Shift 발생
		}
		
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업 시간 : %,dms\n", end - begin);	//2,550ms //2.5초
		
		
		
		
		//LinkedList
		begin = System.currentTimeMillis();	
		
		
		for (int i=0; i<10000; i++) {
			list2.add(0,i); //맨 앞에서 삽입하면 뒤에 모든 요소들 Shift 발생
		}
		
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업 시간 : %,dms\n", end - begin); //1ms
		

		
		//3. 중간에 있는 데이터 삭제하기(맨뒤데이터x) > ArrayList Shift 발생시키기 위해
		System.out.println("[데이터 삭제하기]");
		
		
		//ArrayList
		begin = System.currentTimeMillis();	
		
		
		for (int i=0; i<10000; i++) {
			list1.remove(0); //맨 앞에서 삭제하면 뒤에 모든 요소들 Shift 발생
		}
		
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업 시간 : %,dms\n", end - begin); //1,569ms //1.5초
		
		
		
		//LinkedList
		begin = System.currentTimeMillis();	
		
		
		for (int i=0; i<10000; i++) {
			list2.remove(0); //맨 앞에서 삭제하면 뒤에 모든 요소들 Shift 발생
		}
		
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업 시간 : %,dms\n", end - begin); //1ms //0.001초
		
		
		
		//4. 순차적으로 데이터 삭제하기
		System.out.println("[순차적으로 데이터 삭제하기]");
		
		//ArrayList
		begin = System.currentTimeMillis();	
		
		
		for (int i=list1.size()-1; i>=0; i--) {
			list1.remove(i); //끝방에서 처음방까지 하나씩 삭제
		}
		
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업 시간 : %,dms\n", end - begin); //6ms //0.006초

		
		
		//LinkedList
		begin = System.currentTimeMillis();	
		
		
		for (int i=list2.size()-1; i>=0; i--) {
			list2.remove(i); //끝방에서 처음방까지 하나씩 삭제
		}
		
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업 시간 : %,dms\n", end - begin); //23ms //0.023초
		
		//순차적으로 추가하거나 삭제하는건 ArrayList가 더 빠름. 근데 LinkedList도 막 느린 편은 아님. 
		//-> 순차추가,삭제, 중간삽입삭제 모두 해야하면 LinkedList가 나음. 중간 삽입/삭제가 없으면 ArrayList사용
		//=> 근데 우린 중간삽입삭제를 할 일이 많이 없음. ArrayList를 쓰는게 더 나은 일이 주위에 많음.
		
		
	}

	private static void m1() {
		
		//Collection(C) > List(I) > ArrayList(C), LinkedList(C)
		
		//ArrayList vs LinkedList
		//- 사용법 아주 유사 (같은 인터페이스를 물려받고, 이름에도 공통적으로 'List'가 들어감) > 개발자 경험을 살리기위해 유사하게
		//- 내부 구조가 다름. >> 사용 용도가 다르다.
		
		//물리적 구조 + 사용법(인터페이스)
		//Array + List
		//Linked + List
		//Hash + Map
		//Hash + Set
		
		
		//LinkedList는 점점 종류가 늘어남
		
		//LinkedList 종류
		//1. LinkedList : 일반통행
		//2. Double LinkedList : 양방향
		//3. Double Circular LinkedList : 양방향 + 처음~끝 연결 > java의 LinkedList
		
		//LinkedList는 다음 이어지는 방의 주소값을 저장하고 있음.  + 이전 방의 주소값도 저장함.  (양방향)
		//		=> + 첫번째 방은 마지막 방의 주소값을 마지막방은 첫번째 방의 주소값을 저장함. (양방향 원형 구조가 됨.)
		
		
		
		/*
		- ArrayList와 LinkedList의 구조적 차이(가 어떤 영향을 주는지?)
		
		ArrayList
		- 모든 컬렉션중에서 요소에 접근하는 속도가 가장 빠름. -> 이래서 ArrayList를 주로 쓰는 것
		- 요소의 중간 삽입이나 삭제에 대한 비용이 많이 든다. > 느리다 > Shift를 해야하는데 이게 비용이 큼 (**)
			(배열이 길면 길수록, 앞에 있는 요소를 건드릴 수록 비용이 많이 들어감. -> Shift해야할게 더 많아지니까)
		
		
		LinkedList
		- 요소에 접근하는 속도가 많이 느림. (특히 뒤에 있는 요소일수록 더욱 느려짐.)
		- 요소 삽입/삭제에 대한 비용이 거의 없음. > Shift가 불필요함.
		
		
		*/
		
		
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		
		//ArrayList
		list1.add(100);
		list1.add(200);
		list1.add(300);
		
		System.out.println(list1.size());
		
		for (Integer n : list1) {
			System.out.println(n);
		}
		
		System.out.println(list1.get(0));
		System.out.println(list1.get(1));
		System.out.println(list1.get(2));
		System.out.println();
		
		
		
		//LinkedList
		list2.add(100);
		list2.add(200);
		list2.add(300);
		
		
		
		for (Integer n : list2) {
			System.out.println(n);
		}
		
		System.out.println(list2.get(0));
		System.out.println(list2.get(1));
		System.out.println(list2.get(2));
		
		System.out.println();
		
		
		
		//-> 사용법이 똑같음
		
		
		
	
	
	
	}//m1
	
	
	
}//Ex69
























