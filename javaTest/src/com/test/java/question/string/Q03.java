package com.test.java.question.string; //(완료) + 보충하면 더 좋음

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {

	public static void main(String[] args) throws Exception  {
		//Q03. 숫자를 입력받아 각 자릿수의 수의 합을 구하시오.
		//문자열 추출
		//1. BufferedReader 생성 + 라벨 띄우기 ('숫자: ')
		//2. 입력값은 String num에 저장
		//3. num에 있는 숫자를 한자리씩 추출 (입력값의 길이만큼 반복)
			//3.1 각 자리의 수를 int타입으로 변환 후 int sum에 저장. (각 자릿수의 합)
			//3.2 각 자리의 수를 +기호와 함께 String add에 저장.
		//4. add와 sum을 출력.
		// * 마지막 숫자 뒤에 있는 +기호 지우는 거 귀찮아서 일단 \b했지만
		//	 시간 여유로우면 식으로 바꾸기
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자: ");
		String num = reader.readLine();
		
		int sum = 0;
		String add = "";
		for (int i=0; i<num.length(); i++) {
			
			sum += Integer.parseInt(num.substring(i, i+1));
			add += num.substring(i, i+1) + " + ";
		}
		
	
		System.out.printf("결과: %s\b\b = %d\n", add, sum);
	}
}
