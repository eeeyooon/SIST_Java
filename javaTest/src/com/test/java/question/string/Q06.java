package com.test.java.question.string; //(완료)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {

	public static void main(String[] args) throws Exception {
		//Q06. 주민 등록 번호 유효성 검사를 하시오.
		//- '-'의 입력 유무 상관없이 검사하시오.
		//설계
		/*
		1. BufferedReader 생성 + 라벨 띄우기 ('주민등록번호: ')
		2. 입력값은 String jumin에 저장
		3. '-'이 있을때와 없을때 모두 검사 가능하도록 if문으로 설정.
			3.1 '-'이 있다면 replace로 '-'제거
		4. 주민등록번호 유효성 검사
		5. (11-sum%11)이 두자리수를 넘어갈 경우 일의 자리 숫자와 주민번호의 마지막 숫자 비교
		*/
		
		
		
		// 주민등록번호 유효성 검사 ('-'입력시, '-' 미리 제거) > O 
		// (11-sum%11)이 두자리수를 넘어갈 경우 일의 자리 수와 주민등록번호 마지막 수를 비교. < O
		
		//951220-1021547 (올바름)  > O
		//951220-1234567 (올바르지x) > O
		//951220-0200001 (올바름) -> sum=77 >> (11-sum%11)이 10보다 클때 테스트용 > O
		
		
				
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("주민등록번호: ");
		String jumin = reader.readLine();
		
		if (jumin.length() == 14 && jumin.charAt(6) == '-') { //'-'이 있을때
			jumin = jumin.replace("-", ""); //'-'제거
			
			int sum = test(jumin);
			result(jumin, sum);
			
		} else if (jumin.length() ==13) {  //'-'이 없을때
			int sum = test(jumin);
			result(jumin, sum);
		
		} else {
			System.out.println("잘못 입력하셨습니다."); //주민번호의 숫자가 더 많거나 적을경우 안내
		}
	
	}

	private static void result(String jumin, int sum) {
		
		if (11-sum%11 < 10) { //(11-sum%11)이 두자리수를 넘지 않을 경우
			
			
			if ( (jumin.endsWith( "" + (11-sum%11) ) ) == false) {
				//숫자를 문자열로 바꾸기위해 "" 더함.
				//마지막 숫자와 (11-sum%11)이 같은지 비교
				System.out.println("올바르지 않은 주민등록번호입니다.");
				
			} else if ( (jumin.endsWith( "" + (11-sum%11) ) ) == true) {
				System.out.println("올바른 주민등록번호입니다.");
			}
			
			
		} else if (11-sum%11 > 9) { //(11-sum%11)이 두자리수를 넘어갈 경우 
			
			
			if ( (jumin.endsWith( "" + ( (11-sum%11)-10 ) ) ) == false) {  
				//일의 자리수와 주민번호의 마지막수 비교
				System.out.println("올바르지 않은 주민등록번호입니다.");
				
			} else if ( (jumin.endsWith( "" + ( (11-sum%11)-10 ) ) ) == true) {
				System.out.println("올바른 주민등록번호입니다.");
			}
			
			
		}
	}

	private static int test(String jumin) {
		
		//sum = (0)*2 + (1)*3 + (2)*4 + (3)*5 + (4)*6 + (5)*7 + (6)*8 + (7)*9 + (8)*2
		//		 + (9)*3 + (10)*4 + (11)*5 
		
		int sum = 0;
		int [] j = {2,3,4,5,6,7,8,9,2,3,4,5};
		for (int i=0; i<jumin.length()-1; i++) {  //13번 반복
			
			sum += (jumin.charAt(i)-'0')*j[i]; //char를 숫자로 바꾸기 위해 -'0'
			
		}
		return sum;
	}

}




