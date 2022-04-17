package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q10 {

	public static void main(String[] args) throws Exception {
		//Q10. 날짜를 입력받아 아래의 조건에 맞게 결과를 출력하시오.
		//-조건 : 입력받은 날짜가 평일이면 해당 주의 토요일을 알아낸다. 날짜가 일요일이면 아무것도 안한다.
		//1. BufferedReader를 생성하여 년, 월, 일을 입력 받는다.
		//2. 입력받은 년, 월, 일이 무슨 요일인지 확인한다.
		//3.  일~토(1~7)이므로 평일이면 if문으로 기본 설정된 값에 Date + n (7 - 해당요일)
		//3. Date를 + n한 날짜를 출력 = 토요일인 날짜
		//4. 평일이 아니면 (해당 요일이 1이나 7인 경우) 휴일로 출력한다.

		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("년: ");
		int year = Integer.parseInt(reader.readLine());
		
		System.out.print("월: ");
		int month = Integer.parseInt(reader.readLine()) - 1;
		
		System.out.print("일: ");
		int date = Integer.parseInt(reader.readLine());
		
		
		Calendar day = Calendar.getInstance();
		day.set(year, month, date);
		
		
		int inputDay = day.get(Calendar.DAY_OF_WEEK);
		int saturday = 0;
		
		
		if (2 <= inputDay && inputDay <= 6) {
			System.out.println("입력하신 날짜는 '평일'입니다.\n해당 주의 토요일로 이동합니다.");
			if (inputDay == 2) {
				day.add(Calendar.DATE, 5);
				System.out.printf("이동한 날짜는 \'%tF\'입니다.", day);
			} else if (inputDay == 3) {
				day.add(Calendar.DATE, 4);
				System.out.printf("이동한 날짜는 \'%tF\'입니다.", day);
			} else if (inputDay == 4) {
				day.add(Calendar.DATE, 3);
				System.out.printf("이동한 날짜는 \'%tF\'입니다.", day);
			} else if (inputDay == 5) {
				day.add(Calendar.DATE, 2);
				System.out.printf("이동한 날짜는 \'%tF\'입니다.", day);
			} else if (inputDay == 6) {
				day.add(Calendar.DATE, 1);
				System.out.printf("이동한 날짜는 \'%tF\'입니다.", day);
			} 
		} else {
			System.out.println("입력하신 날짜는 '휴일'입니다.\n결과가 없습니다.");
		}
			
//이렇게 계산할 필요없이 	찬진님 코드처럼 day에 '7- inputDay'를 더하거나 	
//수아님 코드처럼 'Calendar.SATURDAY'사용하여 그 주의 토요일로 이동하는 방법이 훨씬 깔끔함
		

		
		
		
	}//main
}





