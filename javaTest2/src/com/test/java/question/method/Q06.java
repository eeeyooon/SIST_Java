package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {

	public static void main(String[] args) throws Exception {

		// Q07. 국어, 영어, 수학 점수를 전달하면 '합격' 혹은 '불합격'이라는 단어를 반환하는 메소드를 선언하시오.
		// 조건 : 평균 점수 60점 이상은 '합격', 60점 미만은 '불합격', 한과목 이상 40점 미만이면 불합격(과락).

		// 설계
		// 1. BufferedReader를 생성하고 throws Exception 적는다.
		// 2. 라벨을 작성한다.
		// 3. 입력값 중 하나라도 40점 미만이면 불합격, 입력값 모두 40점 이상이라도 평균 점수가 60점 미만이면
		// 불합격, 평균점수가 60점 이상이면 합격인 메소드를 만든다.


		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("국어: ");
		int kor = Integer.parseInt(reader.readLine());

		System.out.println("영어: ");
		int eng = Integer.parseInt(reader.readLine());

		System.out.println("수학: ");
		int math = Integer.parseInt(reader.readLine());


		String result = test(kor, eng, math);
		System.out.println(result);


	}// main

	public static String test(int kor, int eng, int math) {

		String result = kor < 40 || eng < 40 || math < 40 ? "불합격입니다."
				: (kor + eng + math) / 3 < 60 ? "불합격입니다." : "합격입니다.";

		// String result = (kor >= 40 && eng >= 40 && math >= 40) ?
		// ((kor + eng + math)/3 >= 60 ? "합격입니다." : "불합격입니다.") : "불합격입니다.";



		return result;

	}


}
