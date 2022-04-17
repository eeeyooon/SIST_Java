package com.test.java; //03.07

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_Input_2 {

	public static void main(String[] args)	throws Exception {	//꼭 입력해주기
		
		//Ex10_input.java
		
		//요구사항] 숫자 2개를 입력받아 두 숫자의 합을 구하시오.
		
		//Ctrl + Shift + O > 현재 페이지의 모든 클래스를 import(한꺼번에)
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 입력: ");
		String input1 = reader.readLine();	//무조건 문자열 변수를 만들어놔야해.
		
		System.out.print("숫자 입력: ");
		String input2 = reader.readLine();
		
		System.out.println(input1 + input2);	//"10" + "20" -> "1020"이 됨.
		
		//문자열이 입력받은 "10"을 10(실제 수)으로 바꾸는 과정이 필요함.
		//Stirng(참조형_ "10" -> int 10		//값형과 참조형간에는 형변환이 불가능함.
		
		//형변환은 불가능하나 해당 과정은 가능함. (따로 구현이 되어있음)
		
		
		
		//Byte.MAX_VALUE .. 이런걸 유틸 클래스라고 함.
		//-문자열을 자신의 자료형으로 바꿔주는 일 제공
		
		//input1 = "100";
		
		//Integer.parseInt("100");	//그럼 숫자 100으로 바꿔줌.
		//과정이 끝나면 사라지고 int 100만 남김.
		
		// > 문자열->값형으로 바꾸는 방법 (형변환이라고 부르지 않음. 실제로 형변환도 x)
		int num1 = Integer.parseInt(input1);
		int num2 = Integer.parseInt(input2);
		
		System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
		
		
		//Byte.parseByte("10");
		//Short.parseShort("10");
		//Integer.parseInt("10");
		//Long.parseLong("10");\
		
		//Float.parseFloat("3.14");
		//Double.parseDouble("3.14");
		
		//Boolean.parseBoolean("true");
		
		//Char는 없음. ex. "A" -> 'A'를 하고싶을 때.
		//"A".charAt(0)	-> 얘를 하면 가능하긴 함. (원래 이런 용도는 아닌데 ㅎ)
		
		
		
		//자신의 자료형을 문자열로 바꿔주는 일
		//100 -> "100"
		//String.valueOf(100) -> "100"으로
		//String.valueOf(3.14) -> "3.14"
		//String.valueOf(true) -> "true"
		
		
		//
		
		
		
		
		// 1장부터 2장까진 모두 봐야해 (진법p.42)제외.
		// 목요일엔 연산자를 나가는데 3장 5.2 비트 연산자 있는데 이건 수업x
		// 그거빼고 나머지는 다보는게 좋음 (예습 원하면)
		
		
		
		
		
		
		
		
	}
}
