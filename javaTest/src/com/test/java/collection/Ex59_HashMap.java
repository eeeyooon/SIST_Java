package com.test.java.collection; //04.01

import java.util.ArrayList;
import java.util.HashMap;

public class Ex59_HashMap {

	public static void main(String[] args) {
		
		//Ex59_HashMap.java
		/*
			
			
			list라는 단어가 들어가면 다 방번호가 존재하는 집합이고,
			map이라는 단어가 들어가면 방의 이름이 존재하는 배열이라고 생각하면 돼 !
			
			ArrayList
			- 요소 접근 > 첨자(index) 사용
			- 순서가 있는 데이터의 집합(방번호 == 요소의 순서)
			ex) 강의실 6개 > 1강의실, 2강의실, 3강의실...6강의실
			- 스칼라 배열(Scalar Array) -> 원자갑을 가지는 배열
			- 요소 일괄 접근 가능 > 루프를 통해(for문)
			- 요소끼리 구분이 불편함 > 식별자만 가지고 판단하기 힘듦. > 식별자가 숫자니까 (꺼내기전까진 알기힘들어) 
			- 첨자(index)는 유일하다. (********)
			- 값(Value)은 중복이 가능함. (*****)
			
			
			HashMap (방번호x)
			- 요소 접근 > 키(Key) 사용
			- 순서가 없는 데이터 집합 > 방번호 없음 > 
			ex) 강의실 6개 > 햇님반, 달님반, 별님반... 지구반
			- 요소끼리의 구분이 아주 용이함 > 식별자가 의미를 가진 단어.
			- 요소 일괄 접근 불가능 > 루프 못돌림.
			- 요소 > 키(key) + 값(value) > 키와 값을 한쌍으로 하는 데이터 구조
			- 키(Key)는 유일하다. (********)
			- 값(Value)은 중복이 가능함. (*****)
		
		*/
		
		//-String : 키의 자료형
		//-Integer : value의 자료형
		
		//방의 이름을 문자열로 적고 그 방안에는 숫자로 넣겠습니다.
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//숫자(Integer)배열임. String은 데이터x 방의 이름
		
		//점수 입력(국, 영, 수)
		
		
		//1. 요소 추가
		//- V put(k key, V value)
		map.put("국어", 100);		//int 국어 = 100; 과 같은거임. (국어는 데이터가 아니야!!!!) 
		map.put("영어", 90);
		map.put("수학", 80);
		
		
		//2. 요소 개수
		//- int size()
		System.out.println(map.size()); //3
		
		
		//3. 요소 읽기
		//- V get(K key)
		System.out.println(map.get("국어")); //100
		System.out.println(map.get("영어"));	//90
		System.out.println(map.get("수학"));	//90
		
		System.out.println();
		
		//4. 일괄 탐색 (for문 돌면서 자동으로 탐색하고싶어) >> 불가능해 국어,영어,수학은 순서가 없음.
		// >> 이게 단점이긴한데 실제로 단점이라고 생각안함. 얜 원래 loop돌리려고 만든게 아님.
		
		
		//5. 요소 수정
		//- V put(K key, V value) //요소 추가랑 똑같음 
		map.put("국어", 99); //추가와 똑같아서 겉으론 구분 x 추가(x),수정(o)
							// > 이유는? 해쉬맵은 'key'가 유일성을 보장받음 > 절대 같은 이름의 방 안생김.
		
		System.out.println(map.get("국어")); //99 -> 수정이 되어 있음. 
		
		
		//6. 요소 검색 
		//- boolean containsKey(K key)
		//- boolean containsValue(V value)
		
		System.out.println(map.containsKey("국어")); //배열안에 국어점수가 있냐? //true
		System.out.println(map.containsKey("사회"));	//false
		
		System.out.println(map.containsValue(90));	//90점 맞은 과목이 있냐? //true
		System.out.println(map.containsValue(100));	//false
		
		
		//7. 요소 삭제
		//- V remove(K key)
		map.remove("국어");
		
		System.out.println(map.size()); //2
		
		System.out.println(map.get("과학")); //null
		
		
		//8. 초기화
		map.clear();
		System.out.println(map.size()); //0
		
		System.out.println(map.isEmpty()); //size:0 >> isEmpty //true
		
		
		
		//별개 설명
		
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("빨강");
		a1.add("파랑");
		a1.add("노랑");
		
		System.out.println(a1.get(0));	//방번호로 판단 //페이지 번호로 -> 데이터 접근
		
		HashMap<String,String> a2 = new HashMap<String, String>();
		a2.put("red", "빨강"); // 방이름이 red. 값은 빨강
		a2.put("blue", "파랑");
		a2.put("yellow", "노랑");
		
		//Map 구조를 '사전구조'라고도 함. > Dictionary
		System.out.println(a2.get("red"));	//방의 이름(Key)으로 판단 //단어로 -> 데이터 접근
		
		
		//toString() 재정의되어있음 > 덤프 
		System.out.println(a1); //[빨강, 파랑, 노랑]
		System.out.println(a2); //{red=빨강, blue=파랑, yellow=노랑}
								//toString이 오버라이드 되어있음
		
		//모든 컬렉션은 toString이 재정의되어있음 !! 꼭 굳이 dump따로 안만들어도 덤프 되어있음.
		
	}//main
	
}//HashMap

























