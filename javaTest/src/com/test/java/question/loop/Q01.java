package com.test.java.question.loop; //3.17

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {
		//Q01. 숫자를 N개 입력 받아 아래와 같이 출력하시오.
		//-누적값이 100을 넘어가면 루프 종료
		//-짝수는 더하고 홀수는 빼기
		// 숫자 : 12 + 28 - 39 - 15 + 38 + 24 + 78 = 126
		//1. BufferedReader 생성 숫자 N개 입력받기 (loop)
		//2. 누적값이 100이 넘으면 루프 탈출
		//3. 짝수는 더하기 연산자를 홀수는 빼기 연산자를 앞에 붙여줌. 다만 첫번째 숫자는 연산자없이 출력.
			// > 첫번째 숫자는 그대로 str에 넣고 다음 숫자부터는 짝수는 + 짝수로, 홀수는 - 홀수로 저장.
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		String str = "";
		
		int sum = 0; //누적변수
			
			while (sum < 100) {
				System.out.print("숫자: ");
				int num = Integer.parseInt(reader.readLine());
				
				if (sum == 0) { //첫번째 숫자는 그대로 누적변수와 str에 저장.
					sum += num;
					str += num;
					} else if (num % 2 == 0) { //num이 짝수면 result에 더하고 str에는 
						sum += num;
						str += " + " + num;
					} else if (num % 2 != 0) {
						sum -= num;	//num이 홀수면 result에서 뺀다.
						str += " - " + num;
					}
					
				
				//짝수인지 홀수인지 먼저 구해라 >> 수아님 코드 보는게 젤 정확한듯. 
			} System.out.printf(str + " = %d\n", sum);
	}
}
