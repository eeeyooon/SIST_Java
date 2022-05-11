package com.test.java; //05.11 수업 중 scan관련 설명

import java.util.Scanner;

public class About_scan {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//scan.nextLine() vs scan.nextXXX()의 차이
		
		
		int num = scan.nextInt();
		System.out.println(num);
		
		int num2 = scan.nextInt();
		System.out.println(num2);
		
		
		//두번째 숫자를 입력 버퍼로부터 가져가고 입력 버퍼안에는 \r\n이 남아있는 상태. (원랜 나중에 메모리 안에서 자동으로 소멸됨.)
		//이 상태에서 nextLine()이 들어오면 엔터앞에 있는걸 읽고감. -> 즉, 빈문자열을 읽음. > 공회전을 함 = SKIP
		
		//여기서 nextLine()을 정상적으로 입력받으려면
		
		scan.skip("\r\n");
		//남아있는 엔터는 건너뛰세요, 라는 명령어를 넣어줘야함
		
		//>> nextLine()을 쓰기전에 다른 nextXXX()을 사용했으면 그냥 SKIP되니까 위 scan.skip(); 명령어를 넣어주면됨
		
		//방법 2개
		//1. scan.skip("\r\n")
		//2. scan.nextLine()을 한번 더 사용
		
		String txt = scan.nextLine(); //왜 여기선 안 멈춰? > scan.nextLine() vs scan.nextXXX()의 차이
		System.out.println(txt);
		
		System.out.println("종료");
	}
}
