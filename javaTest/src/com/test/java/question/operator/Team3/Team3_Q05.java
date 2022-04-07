package com.test.java.question.operator.Team3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Team3_Q05 {

	public static void main(String[] args) throws Exception {
		
		//다섯번째 문제
		
		//요구사항] 자전거가 있다. 자전거의 바퀴는 지름(직경)이 26인치이다. 사용자가 페달을 밟은 횟수를 입력하면
		//		  자전거가 총 몇 m를 달렸는지 출력하시오.
		// 1인치 =  0.0254m

		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("사용자가 페달을 밟은 횟수: ");
		
		int pedal = Integer.parseInt(reader.readLine());

		final double PI = 3.14;
		final double INCH = 0.0254;
		
		double distance = pedal * INCH * (PI * 26) ;
		
		
		System.out.printf("사용자가 총 %d회 페달을 밟아 자전거가 총 %,.3fm를 달렸습니다.", pedal, distance);
		
		
		//앞 선 예제에서 나온 내용으로 코드를 정리함.
		//- 원주율과 인치값은 변하지 않는 값이므로 fianl 상수를 사용함. 
		//- 지름의 값이 바뀌는 문제라면 지름 변수를 따로 만들어야 함.
		//- 연산식이 길고 복잡하기 때문에 따로 변수를 만들어서 먼저 계산 후 printf문에 출력함.
		
						
		
	}
}
