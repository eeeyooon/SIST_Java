package com.test.java.question.fileio; //04.05과제 //다시풀어야돼 문제 착각함 ㅠㅠ

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Q05_orderInfo {

	public static void main(String[] args) {
		//Q05. 이름을 입력받아 회원 주문 정보를 검색 후 출력하시오.
		//정재재, 하재명, 전돈형, 황길돈
		
		try {
			File file = new File("C:\\class\\파일_입출력_문제\\검색_회원.dat");
			BufferedReader reader =	new BufferedReader(new FileReader(file));
			
			Scanner scan = new Scanner(System.in);
			System.out.print("이름: ");
			String inputName = scan.nextLine();
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				if(line.contains(inputName)) {
					String[] list = line.split(",");
					Print(list);
				}
			}
			
		} catch (Exception e) {
			System.out.println("Q05_orderInfo.main");
			e.printStackTrace();
		}
	

	}//main

	private static void Print(String[] list) throws IOException {
		String num = list[0];
		String name = list[1];
		String address = list[2];
		String goods = null;
		String amount = null;
		
		
		File file = new File("C:\\class\\파일_입출력_문제\\검색_주문.dat");
		BufferedReader reader =	new BufferedReader(new FileReader(file));
		
		String line = null;
		
		while((line = reader.readLine())!=null) {
			if(line.contains(num)) {
				String[] sublist = line.split(",");
				goods = sublist[1];
				amount = sublist[2];
			}
		}
		
		reader.close();
		System.out.println("====================구매내역=====================");
		System.out.println("[번호]\t[이름]\t[상품명]\t[개수]\t[배송지]");
		System.out.printf("%3s\t%3s\t%4s\t%3s\t%s",num, name, goods, amount, address);
		
	}
	
	
}//Q05




























