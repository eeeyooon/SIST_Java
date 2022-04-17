package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {

	public static void main(String[] args) throws Exception {
		
		//Q07. 지하철 탑승 소요 시간을 구하시오. 지나가는 역의 개수, 환승역의 횟수, 시간대를 전달 받아 총 걸리는 시간을 반환하는 메소드를 선언하시오.
		//각 역간 소요 시간 : 2분 소요.
		//환승 소요 시간 N분 소요.
		//평상시 : 3분, 출근시 : 4분, 퇴근시 : 5분.
		
		//설계
		
		//1. 라벨 작성 (역의 개수, 환승역의 횟수, 시간대(1.평상시 2.출근시 3.퇴근시)
		//2. BufferedReader 생성 + throws Exception 작성
		//3. int getTime(int station, int change, int time) 메소드 선언.
		//4. 입력한 시간대의 환승소요 시간인 transfer_time 변수를 만든다.
		//5. station * 2 + transfer_time(시간대에 따른 환승 소요시간) * change 연산문을 작성한다.
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("역의 개수: ");
		int station = Integer.parseInt(reader.readLine());
		
		System.out.println("환승역의 횟수: ");
		int change = Integer.parseInt(reader.readLine());
		
		System.out.println("시간대(1.평상시, 2.출근시, 3.퇴근시 : ");
		int time = Integer.parseInt(reader.readLine());
		
		
		int result = getTime(station, change, time);
		System.out.printf("총 소요 시간은 %d분입니다.\n", result);
		
	}//main
	
	public static int getTime(int station, int change, int time) {
		
		int transfer_time = time + 2;
		int result = (station * 2) + (change * transfer_time);
		
		//int change_time = time == 1 ? "3" : time == 2 ? "4" : time == 3? "5" : null;
	
		return result;
		
	}
	
	//다른 숫자를 입력했거나 숫자가 아닌걸 입력했을 경우 새로 입력해달라는 문장 (안내 메세지)이 추가되면 좋겠다.
}


