package com.test.java.question.loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {

	public static void main(String[] args) throws Exception {
		//Q05. 자판기 프로그램을 구현하시오.
		
		//더 생각해볼 것
		//-투입 금액이 음료 가격보다 낮을 경우?
		//-투입 금액과 음료 가격이 같을 경우?
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		boolean loop = true;
		
		while (loop) {
			System.out.println("====================");
			System.out.println("        자판기");
			System.out.println("====================");
			System.out.println("1. 콜라 :   	700원");
			System.out.println("2. 사이다 :  	600원");
			System.out.println("3. 비타500 :	500원");
			System.out.println("---------------------");
			System.out.print("금액 투입(원) : \t");
			
			int insert = Integer.parseInt(reader.readLine());
			
			System.out.println("---------------------");
			System.out.print("음료 선택(번호) : \t");
			String num = reader.readLine();
			
			
			String drink = "";
			int coke = 700;
			int cider = 600;
			int vita = 500;
			
		
			if (num.equals("1")) {
				//1. 콜라
				drink = "콜라";
				insert -= coke;
			} else if (num.equals("2")) {
				//2. 사이다
				drink = "사이다";
				insert -= cider;
			} else if (num.equals("3")) {
				//3. 비타500
				drink = "비타500";
				insert -= vita;
				
			} else {
				loop = false; // 1~3번이 아닌 다른 숫자를 입력했을 때
				System.out.println("1~3번 중에 하나를 골라주세요.");
				break; //밑에 문장들을 출력하지 않기 위해
			}
			
			System.out.printf("+ %s를(을) 제공합니다.\n+ 잔돈 %d원을 제공합니다.\n", drink , insert);
			
			System.out.println("\n계속 하시려면 엔터를 입력하세요."); //엔터를 입력하면 계속 진행함.
			String enter = reader.readLine();
			
			if (!enter.equals("")) {
					
				break;
			}
		}
		
		
	}//main
	
	
	
}//class
