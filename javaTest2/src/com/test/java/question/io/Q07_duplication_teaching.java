package com.test.java.question.io; //04.04과제

import java.io.File;
import java.util.HashSet;

public class Q07_duplication_teaching {
	
	public static void main(String[] args) {
		//Q07. MusicA 폴더와 MusicB 폴더를 서로 비교해서 양쪽 폴더에 모두 존재하는 파일만을 출력하시오.
		//조건 : 중복 파일을 찾아내시오.
		
		//case1
		//무난하게 리스트로
		
		
		File dirA = new File("C:\\class\\파일_디렉토리_문제\\동일 파일\\MusicA");
		File dirB = new File("C:\\class\\파일_디렉토리_문제\\동일 파일\\MusicB");
		
		String[] listA = dirA.list();
		String[] listB = dirB.list();
		
		
//		for (String s1 : listA) {
//			for (String s2 : listB) {
//				if (s1.equals(s2)) {
//					System.out.println(s1); //s2도 상관없음
//					break;
//					
//				}
//			}
//		}
		
		
		//HashSet > 중복값이 들어가면 한번 HashSet도 생각해봐라
		//1. 수업 중에서 배운 걸 조합하면 풀 수 있는 것
		//2. 안 배운 기능도 찾아봐야 해.
				// >> 수업 때 안 다룬 메소드들도 슬슬 관심을 가지면 좋겠다 
		
		
		//Set을 하면 무조건 집합 얘기가 나옴 > 교집합, 합집합, 차집합..
		HashSet<String> set1 = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();
		
		set1.add("빨강");
		set1.add("노랑");
		set1.add("파랑");
		set1.add("주황");
		set1.add("검정");
		
		set2.add("빨강");		//v 중복
		set2.add("초록");
		set2.add("분홍");
		set2.add("주황");		//v	
		set2.add("검정");		//v
		
		
		//합집합 & 교집합 & 차집합 구하는 메소드
		
//		set1.addAll(set2);
//		System.out.println(set1);
//		//[검정, 주황, 빨강, 초록, 분홍, 노랑, 파랑] => 합집합 (set1 + set2)
//		
//		set1.retainAll(set2);
//		System.out.println(set1); //[검정, 주황, 빨강] => 교집합
//		
//		set1.removeAll(set2);
//		System.out.println(set1); //[노랑, 파랑] => 차집합

		
		//Case2
		//교집합을 이용해서 푸는 방법
		HashSet<String> list1 = new HashSet<String>(); //A
		HashSet<String> list2 = new HashSet<String>(); //B
		
		for (String s : listA) {
			list1.add(s);
		}
		
		for (String s : listB) {
			list2.add(s);
		}
		
		
		list1.retainAll(list2);
		
		System.out.println(list1);
		
		
		
		
	}//main
}//Q07













