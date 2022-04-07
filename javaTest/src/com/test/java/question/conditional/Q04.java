package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

	public static void main(String[] args) throws Exception {
		//Q05. 근무 년수를 입력받아 아래와 같이 출력하시오.
		//당신은 n년차 어떤 개발자입니다.
		//초급 : n년 더 근무하면 중급 개발자
		//중급 : n년전까지 초급 개발자, n년 더 근무하면 고급 개발자
		//고급 : n년 전까지 중급 개발자
		//1.Bufferedreader 생성 + throws Exception 작성
		//2. 라벨 띄우기 '근무 년수: '
		//3. 1~4년차 : 초급 / 5~9년차: 중급 / 10년차 이상: 고급 으로 분류하기
		//4. 유효성 검사 (1미만 입력 예외 처리)
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("근무 년수: ");
		int workYear = Integer.parseInt(reader.readLine());
		
		
		if (workYear >= 1) {
			if (workYear <= 4) {
				System.out.printf("%d년차 %s입니다.\n앞으로 %d년 더 근무를 하면 %s가 됩니다.\n", workYear, "초급 개발자", (5 - workYear), "중급 개발자");
			} else if (5 <= workYear && workYear <= 9) {
				System.out.printf("%d년차 %s입니다.\n당신은 %d년전까지 %s였습니다.\n앞으로 %d년 더 근무를 하면 %s가 됩니다.\n", workYear, "중급 개발자", (workYear - 4), "초급 개발자", (10 - workYear), "고급 개발자");
			} else {
				System.out.printf("%d년차 %s입니다.\n당신은 %d년전까지 %s였습니다.\n", workYear, "고급 개발자", (workYear - 9), "중급 개발자");
			}
		} else {
			System.out.println("입력한 값이 올바르지 않습니다. 1 이상의 값을 입력하시오.");
		}
		
		
		
	}//main
}
