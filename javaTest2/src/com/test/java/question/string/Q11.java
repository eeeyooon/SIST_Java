package com.test.java.question.string; //(완료)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11 {

	public static void main(String[] args) throws Exception {
		//Q11. 입력받은 문장에서 숫자를 찾아 그 합을 구하시오.
		//-모든 숫자는 한자리 숫자로 처리한다.
		//홍길동의 나이는 20살입니다. 몸무게는 72kg이고, 전화번호는 010-2848-9372입니다. 
		// sum = 55
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("입력: ");
		String statement = reader.readLine();
		//입력받은 문장을 statement에 저장.
		
		
		String num = "";
		for (int i=0; i<statement.length(); i++) {
			char ch = statement.charAt(i); //문장의 모든 글자를 돌면서 숫자 탐색
			if (48 <= ch && ch <= 57) {
				num += ch;
				
			} // statement에서 숫자만 뽑아서 String num에 저장
			
		}
		int sum = 0;
		String[] numlist = num.split("");
		//하나씩 쪼갬 -> 그 값은 numlist배열에 순서대로 저장 
		for (int i=0; i<numlist.length; i++) {
			sum += Integer.parseInt(numlist[i]);
		}
		//배열의 모든 값을 sum에 더함.
		
		System.out.printf("문장에 존재하는 모든 숫자의 합은 %d입니다.\n", sum );
		

		
		
		
	}
}
