package com.test.java.question.fileio; //04.05과제 (완료)

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Q04_memberInfo {

	public static void main(String[] args) {
		//Q04. 이름을 입력받아 회원 정보를 검색 후 출력하시오.
		//회원번호, 이름, 주소, 번호
		//출력]	[홍길석]...
		//		번호: 33
		//		주소: 서울시 강남구 역삼동
		//		전화: 010-...
		
		//수아님 
		//boolean변수 만들고 if문 하나 더만들어서 회원이 존재하지 않을 경우에 메세지 출력하게함!
		//>> 유효성검사하심.
		
		
		try {
			
			File file = new File("C:\\class\\파일_입출력_문제\\단일검색.dat");
			BufferedReader reader =	new BufferedReader(new FileReader(file));
			Scanner scan = new Scanner(System.in);
			System.out.print("이름: ");
			String inputName = scan.nextLine();

			String line = null;
			while ((line = reader.readLine()) != null) {
				
				if(line.contains(inputName)) {
					String[] list = line.split(",");
					
					String num = list[0];
					String name = list[1];
					String address = list[2];
					String phone = list[3];

					System.out.printf("[%s]\n번호: %s\n주소: %s\n전화: %s\n"
										, name, num, address, phone);
					
				} 
				
				
			
			} 
			reader.close();
			scan.close();
			
		} catch (Exception e) {
			System.out.println("Q04_memberInfo.main");
			e.printStackTrace();
		}
		
	}//main
}
