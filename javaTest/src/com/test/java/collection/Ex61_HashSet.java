package com.test.java.collection; //04.01

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Ex61_HashSet {

	public static void main(String[] args) {
	
		//Ex61_HashSet.java
		
		/*
		
			1. list
				- 순서가 있는 데이터 집합(*****************)
				- 첨자(방번호)
				(index관련한게 있으면 무조건 list)
				
			2. Set
				- 순서가 없는 데이터 집합 (방번호x)
				- 식별자가 없음. (이름도 못짓고 방번호도 없음.) > 방과 방을 구분할 수 없음.
				- 데이터 중복을 허용하지 않는다. (**********************) > 방과 방을 구별할 수 없으니까
				
			3. Map
				- 순서가 없는 데이터 집합
				- 키 + 값(*********************)
				
		*/
		
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
		
	}
	
	private static void m5() {
		
		//HashSet의 탐색(읽기)
		//- 방을 구분할 수 있는 방법이 없어서 좀 불편함. > 식별자가 없음.
		//- 그래서 Set은 Iterator 사용함 > 컬렉션 탐색 도구의 일조오
		
		//boolean HashNext 랑 Next 이문제는 이걸 이용해서 풀어야해
		
		
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("마우스");
		set.add("키보드");
		set.add("모니터");
		set.add("노트북");
		set.add("패드");
		
		Iterator<String> iter = set.iterator();
		
		/*
		System.out.println(iter.next()); 
		System.out.println(iter.next()); 
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.next());
		*/
		
		/*
		System.out.println(iter.hasNext()); //true  //Set안에 가져올 데이터가 있나?
		System.out.println(iter.next());			//있으면 가져와라
		
		System.out.println(iter.hasNext()); //true
		System.out.println(iter.next());
		
		System.out.println(iter.hasNext()); //true
		System.out.println(iter.next());
		
		System.out.println(iter.hasNext()); //true
		System.out.println(iter.next());
		
		System.out.println(iter.hasNext()); //true
		System.out.println(iter.next());
		
		System.out.println(iter.hasNext()); //false
		System.out.println(iter.next());
		*/
		
		//이렇게 iterator를 통해 루프 돌릴 수 있음. (순차적으로 접근 가능) > 순서는 x
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		
	}

	private static void m4() {
		
		
		//p1과 p2는 상태가 동일함 > but, 다른 사람!
		Person p1 = new Person("홍길동", 20);
		Person p2 = new Person("아무개", 25);
		Person p3 = new Person("홍길동", 20);
		
		//값형의 비교는 ==로 한다. 
		//모든 참조형의 비교는 equals()로 한다. > 문자열 포함해서!!!!
		System.out.println(p1.equals(p3)); 	//false  	//재정의 후 -> true
		System.out.println(p1.hashCode());	//100(임의)	// -> p1의 해쉬코드와 p3의 해쉬코드가 같음.
		System.out.println(p3.hashCode());	//200
		
		//*** p1과 p3를 같은 사람으로 취급하고 싶다. > How? equals를 재정의할거야. 이름과 나이가 같으면 메모리주소값이 똑같이 나오도록.
		//		>> equals와 hashcode 내부구조 수정해서 데이터만 같으면 같은 애로 취급하도록 만듦.
		// 복습 잘해봐

		
		
		//마지막 결론 (수정 다 하고 마지막으로 봐보기)
		HashSet<Person> set = new HashSet<Person>();
		
		set.add(new Person("홍길동", 20));	//1.
		set.add(new Person("아무개", 25));
		set.add(new Person("테스트", 28));
		
		set.add(new Person("홍길동", 25));	//2. 
		set.add(new Person("홍길동", 20)); 	//3. //> 수정하니 사라져있음. 첫번째 홍길동20과 마지막 홍길동20이 같은 걸로 취급되고
												 //		>> 중복값을 가질 수 없으니 마지막 홍길동20은 추가가 안된 것.
		System.out.println(set);
		
		
	}

	private static void m3() {
		
		HashSet<Person> set = new HashSet<Person>();
		
		set.add(new Person("홍길동", 20));	//1.
		set.add(new Person("아무개", 25));
		set.add(new Person("테스트", 28));
		
		set.add(new Person("홍길동", 25));	//2. 나이가 다름.(동명이인)
		set.add(new Person("홍길동", 20)); 	//3. 동명이인? 같은사람? > 내부 데이터는 동일하지만 1번과는 다른 사람
		
		Person p = new Person("하하하", 20);
		set.add(p);
		
		
		Person p2 = new Person("하하하", 20);
		set.add(p2);
		
		//b.
		//HashCode = 실제 메모리의 주소값.
		System.out.println(p.hashCode()); 	// 메모리 주소값 > 1252585652
		System.out.println(p2.hashCode());	// > 2036368507
											//주소값이 다르면 다른 객체
		
		//c. 번외 (같은 객체 두개)
		String s1 = "홍길동";
		String s2 = "홍길동";
		
		System.out.println(s1.hashCode());	//54150062
		System.out.println(s2.hashCode());	//54150062
											//s1이랑 s2는 같은 애거든. 메모리엔 홍길동이 하나뿐. 
		
		Person p3 = new Person("호호호", 25);
		set.add(p3);
		set.add(p3);
		//add를 두번 했지만 호호호가 1개 들어있음.
		
		//a.
		//홍길동, 하하하 vs 호호호 (의 차이?)
		//- new의 호출횟수 (홍,하 : 2번 vs 호호호 : 1번) > 객체 생성 횟수 차이
		// new가 호출되면 기존 객체와 데이터가 같더라도 ! 새로 만들어진 객체다 !
		
		//** Set은 객체를 취급할 때 > 메모리의 생성된 인스턴스를 구분함. (주소값을 구분함.) -> b.
		System.out.println(set); //1,3 > HashSet의 반응은? 다른 데이터로 인식.
		
		
	}

	private static void m2() {
		
		//로또 번호 > 중복되지 않는 난수 생성
		
		//Case:1
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		
		for (int i=0; i<6; i++) {
			
			boolean flag = false;
			int n = (int)(Math.random() * 45) + 1;
			
			for (int j=0; j<i; j++) {
				if (lotto.get(j) == n) {
					flag = true;
					break;
				}
			}
			
			if (flag) {	//중복
				i--; //for문 한번 더 돌려
			} else {	//중복이 안됨
				lotto.add(n);
			}
			
		}
		
		System.out.println(lotto);
	
		HashSet<Integer> lotto2 = new HashSet<Integer>();
		
		//while문과 for문의 선택기준 -> 회전수가 고정이면 for문이, 애매하면 while문. 
		//로또 역시 몇바퀴도는지 모름.(겉으로만 6바퀴지 중복되면 더 도니까) 
		//-> 그 당시엔 for문 수업중이라 for문한거지 set은 while이 더 편해
		
		while (lotto2.size() < 6) {	//데이터 개수가 6개가 될때까지
			
			int n = (int)(Math.random() * 45) + 1;
			lotto2.add(n); //Set 추가 > 중복값을 허용하지 않는다.
			
		}
		
		System.out.println(lotto2);
	
	
	
	}
	
	

	private static void m1() {
		
		//Collection > List, set
		
		ArrayList<String> list = new ArrayList<String>();
		
		HashSet<String> set = new HashSet<String>();
		
		
		//요소 추가하기
		
		list.add("사과");
		list.add("바나나");
		list.add("딸기");
		
		set.add("사과"); //얜 순서없이 그냥 들어감.
		set.add("바나나");
		set.add("딸기");
		
		
		//요소 개수
		System.out.println(list.size());	//3
		System.out.println(set.size());		//3
		
		
		//덤프
		System.out.println(list); 	//[사과, 바나나, 딸기]
		System.out.println(set);	//[사과, 바나나, 딸기]

		
		//요소 추가하기
		list.add("바나나");
		System.out.println(list); 	//[사과, 바나나, 딸기, 바나나]
		System.out.println(list.add("바나나"));	//true
		
		set.add("바나나");
		System.out.println(set); 	//[사과, 바나나, 딸기]
		System.out.println(set.add("바나나"));	//false > add 실패 "Set은 중복값을 가질 수 없다."
		
		
		//요소 삭제하기
		list.remove(1);	//방번호로 삭제
		list.remove("바나나");	//데이터로 삭제
		
		set.remove("바나나");
		
		System.out.println(set); //[사과, 딸기]
		
	}
	
}//Ex61



class Person {
	
	private String name;
	private int age;
	
	public Person() {	//기본생성자
		this("", 0);
	}
	
	public Person(String name, int age) { //오버로딩
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() { //dump
		return "Person [name=" + name + ", age=" + age + "]\n";
	}
	
	@Override
	public int hashCode() { 
		
		//원래 > 자신의 메모리 주소값을 반환.
		
		//p1 > "홍길동", 20 > "홍길동20" > 100
		//p2 > "아무개", 25 > "아무개25" > 200
		//p3 > "홍길동", 20 > "홍길동20" > 100
		
		return (this.name + this.age).hashCode();
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		//p1.equals(p3) -> p3가 obj임. 즉 this와 obj를 비교하는 것.
		//this == obj 와 같은 말.
		
		return this.hashCode() == obj.hashCode();
		
	}
	
	
}
























