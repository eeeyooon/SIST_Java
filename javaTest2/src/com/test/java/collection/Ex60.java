package com.test.java.collection; //04.01

import java.util.ArrayList;
import java.util.HashMap;

public class Ex60 {

	public static void main(String[] args) {
		
		//ArrayList + HashMap
		
		
		//학생 성적 처리 
		
		//학생(국어,영어,수학) x N명
		
		//국어, 영어, 수학 > 한곳에 저장할 자료형 필요
		//1. (순수) 배열
		//2. ArrayList
		//3. HashMap
		//4. 클래스 
		
		
		//Case:1 Array(ArrayList)
		//- 루프 사용
		//- 비용 낮음
		//- 가독성 문제 > 과목 식별을 방번호로
		
		
		int [] score = new int[3];
		
		score[0] = 100;		//국어
		score[1] = 90;		//영어
		score[2] = 80; 		//수학
		
		
		//Case:2 HashMap
		//- 가독성 높음. > 과목을 이름(Key)으로 식별
		//- 루프 사용 불가능
		//- 비용 낮음(만드는데 큰 노력이 안들어감) > b. 틀을 안만드니까 >> 이건 장점이자 단점이 되어버림. (동일한 객체를 만들때 규칙이 없음)
		//- 이 경우는 HashMap이 가장 좋음.
		
		HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
		
		scoreMap.put("국어", 100);
		scoreMap.put("영어", 90);
		scoreMap.put("수학", 80);
		
		HashMap<String, Integer> scoreMap2 = new HashMap<String, Integer>(); //두번째 학생
		
		scoreMap2.put("국어", 100);
		scoreMap2.put("영어", 90);
		scoreMap2.put("수학", 80);
		
		//key를 직접 서술해야하니까 오타 발생 가능성이 있음 -> 조금 위험 (오타는 에러도 안나) //a.->b
		
		//Case:3 Class
		//메소드가 포함된 행동의 단위일수도 있지만 변수가 저장된 저장공간이기도 하니까 자료구조라고 볼 수 있음.
		
		Score scoreObject = new Score();
		
		scoreObject = new Score();
		
		scoreObject.set국어(100);
		scoreObject.set영어(90);
		scoreObject.set수학(80);
		
		
		Score scoreObject2 = new Score();	//두번째 학생 >> c.동일한 객체를 만들땐 이게 해쉬맵보다 안전함. > 틀이 정해져있으니까
											//클래스 설계 및 구현이 귀찮고 복잡하지만 -> 이것만 잘해두면 동일 객체 생성시 편리하고 정확함.
											//틀로 만들어 정해두니 완전히 통제되고 정확해! 
											//여러개를 만들어야하면 클래스, 단편적인거면 해쉬맵?
		
		scoreObject2 = new Score();
		
		scoreObject2.set국어(100);
		scoreObject2.set영어(90);
		scoreObject2.set수학(80);
		
		
		
		
		//HashMap & Class
		//- 내부 요소를 이름으로 구분하는 공통점 (****) -> 그 이름을 해쉬맵은 키(key), 클래스는 멤버라고 부름.
		
		
		//> d.학생을 여러명 쓸거니까 클래스가 나아 근데 지금은 해쉬맵 복습할거니까 해쉬맵으로 할게~
		//학생 x 3명
		
		//HashMap<String,Integer>[] list = new HashMap<String, Integer>[3]; //error
		
		//2차원 배열
		ArrayList<HashMap<String,Integer>> list = new ArrayList<HashMap<String,Integer>>();
		
		HashMap<String, Integer> s1 = new HashMap<String, Integer>();
		s1.put("국어", 100);
		s1.put("영어", 90);
		s1.put("수학", 80);
		
		HashMap<String, Integer> s2 = new HashMap<String, Integer>();
		s2.put("국어", 95);
		s2.put("영어", 95);
		s2.put("수학", 75);
		
		HashMap<String, Integer> s3 = new HashMap<String, Integer>();
		s3.put("국어", 85);
		s3.put("영어", 65);
		s3.put("수학", 77);
		
		list.add(s1); //2차원 배열.add(1차원배열)
		list.add(s2);
		list.add(s3);
		
		System.out.println(list);
		//[{국어=100, 수학=80, 영어=90}, {국어=95, 수학=75, 영어=95}, {국어=85, 수학=77, 영어=65}]
		//겉은 어레이 각각은 해쉬맵
		
		
		
	}//main
}


//Case3 Class
//- 가독성 높음,  HashMap과 유사 -> 멤버에 뭐가 들었는지 확실히 알 수 있음. 변수에 확실히 이름이 들어가니까.
//- 멤버를 루프 돌릴 수 있음. (적용 불가능)
//- 비용 높음 (코드도 졸라 길어)

class Score {

	private int 국어;
	private int 영어;
	private int 수학;
	
	
	public int get국어() {
		return 국어;
	}
	public void set국어(int 국어) {
		this.국어 = 국어;
	}
	public int get영어() {
		return 영어;
	}
	public void set영어(int 영어) {
		this.영어 = 영어;
	}
	public int get수학() {
		return 수학;
	}
	public void set수학(int 수학) {
		this.수학 = 수학;
	}
	
	
}