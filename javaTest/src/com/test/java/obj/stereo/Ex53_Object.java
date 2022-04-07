package com.test.java.obj.stereo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

public class Ex53_Object {

	public static void main(String[] args) {
		
		//Ex53_Object.java
		
		//업 캐스팅
		
		//*** Object 변수는 이 세상 모든 것들을 담을 수 있다!!! ****
		SSS s1 = new SSS();
		
		SSS s2 = new TTT(); //업 캐스팅
		
		Object o1 = new Object();
		
		Object o2 = new SSS(); //가능, 업캐스팅
		
		Object o3 = new TTT(); //가능, 업캐스팅, 손자 -> 할아버지
		
		Object o4 = new Date();
		
		Object o5 = Calendar.getInstance();
		
		Object o6 = new BufferedReader(new InputStreamReader(System.in));
		
		Object o7 = new G304();
		
		
		
		//Obeject 변수
		//1. 모든걸 담을 수 있다.
		//2. 모든걸 담지 않아.. -> 처음에 무언갈 담으면 죽을 때까지 그 자료형만 담는다. 
		//Object 장점
		//1. 모든걸 담을 수 있다. >> 근데 이게 너무 커 걍 깡패임.
		//2. 끝.
		//Object 단점
		//1. 다운 캐스팅이 종종 필요하다.
		//2. 다운 캐스팅 과정에서 원래 자료의 자료형을 유추하기 힘들다.
		System.out.println(o4); //마우스 갖다대도 Object라고만 나옴. 위에 올라가서 얘 코드를 찾아야해
		
		//업캐스팅이 가능하니 모든 자료형을 Object에 담을 수 있었음.
		// 업캐스팅의 조건 > 상속관계에 있는 클래스끼리
		
		Object o10 = new SSS();
		
		//근데 이건 상속도 아니고, 100은 클래스도 아니잖아. -> 값형 데이터
		//값형 데이터를 어떻게 참조형 변수에 넣어?;;
		//주소값 변수는 죽을때까지 주소값만 넣을 수 있음.. // 값형 변수도 죽을때까지 값형만 넣을 수 있음.
		Object o11 = 100;
		System.out.println(o11); //100 예쁘게 잘 출력됨.. why~?
		//-> 우리 모르게 포장해서 10을 담고 있는 주소값으로 보내줌.
		// 이렇게  값형이 우리도 모르게 객체가 되는걸 박싱(Boxing)이라고해 (오토박싱)
		// >> 값형 데이터를 자동으로 객체로 만드는 작업 
		
		//System.out.println(o11 * 2); //error
		//-> 주소값 * 2는 못함 > 주소값은 연산의 대상이 되는 데이터가 아니기 때문에.
		
		System.out.println((int)(o11)*2);
		// -> 형변환을 하라는 얘기는 상자 안에 있는 숫자를 꺼내라 라는 뜻임. = 원래 숫자로 꺼내라. (일종의 다운캐스팅) 
		// => 이걸 언박싱(UnBoxing)이라고 함.
		// 		- Object 변수에 들어있는 값형 데이터를 원래 값형으로 자료형을 반환하는 작업. 
		
		int a = 10;		 //비용 보통
		Object b = 20;	 //비용 비쌈
		
		//-> 이 해결책이 바로 제네릭..!
		
	}
}


class SSS { // extends object가 생략되어있음.
	
}

class TTT extends SSS {
	
}































