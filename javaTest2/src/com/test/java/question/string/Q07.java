package com.test.java.question.string; 

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {

	public static void main(String[] args) throws Exception {
		//Q07. 숫자를 입력받아 3자리마다 ,를 붙이시오.
		//-%,d 사용금지.
		//-substring사용하기. 
		//-끝에서부터 3개씩 잘라서 ','넣기
		//1. BufferedReader 생성 + 라벨 띄우기('숫자: ')
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자: ");
		String num = reader.readLine();
		
		
		
	}
}
