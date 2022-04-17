package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09 {

	public static void main(String[] args) throws Exception {
		//Q09. 컴퓨터가 1~10 사이의 숫자 1개를 생각하면 사용자가 맞히는 프로그램을 구현하시오.
		//- 조건: 시도 횟수가 10회가 넘어가면 프로그램을 강제로 종료하시오.
		//1. BufferedReaderr 생성 + 라벨 띄우기 
		//2. Math.random()을 사용하여 난수 먼저 설정.
		//3. 숫자 기회는 정답을 맞힐때까지 (최대 10번)
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 0;
		int answer = (int)(Math.random() * 10) + 1;
		
		for (int i=0; i<10; i++) {
			count += 1;
			System.out.print("숫자: ");
			int num = Integer.parseInt(reader.readLine());
			if (num == answer) {
				System.out.println("맞았습니다.\n");
				break;
			} else {
				System.out.println("틀렸습니다.\n");
			}
		} 
		
		//count 따로 하지말고 i값을 복사해서 횟수 구하는 방법이 있음.
		
		System.out.printf("컴퓨터가 생각한 숫자는 %d입니다.\n", answer);
		System.out.printf("정답을 맞히는데 시도한 횟수는 %d입니다.\n\n", count);
		System.out.println("프로그램을 종료합니다.");

	
	
	
	} //main
}
