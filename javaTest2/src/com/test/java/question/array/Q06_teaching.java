package com.test.java.question.array; //03.21

import java.util.Arrays;

public class Q06_teaching {

	public static void main(String[] args) {
		//Q06. 중복되지 않는 임의의 숫자 6개를 만드시오. (로또)
		//조건
		//-숫자의 범위 : 1~45
		//-오름차순 정렬
		//회전수 예측 x 
		
		//long begin = System.currentTimeMillis();
		long begin = System.nanoTime(); //tick //시간 측정 10억분의 1초
		
		int[] lotto = new int[6];
		boolean isDuplicate = false;
		for (int i=0; i<lotto.length; i++) {
			
			int n = (int)(Math.random() * 45) + 1;
			
			//생성한 난수를 배열에 넣기 전에 > 기존의 숫자와 중복되는지 검사!! 
			
			for (int j=0; j<i; j++) //기존의 숫자들
				if (lotto[j] == n) { //중복된 숫자
					isDuplicate = true;
					i--; //이 회차를 한번 실행.
					break; //중복이면 lotto[i]에 저장x
				}
			if (!isDuplicate) {
			lotto[i] = n; //여전히 isDuplicate이 false이면 중복x이라는 뜻.
			}
			
		}	
			
		//Arrays.sort(lotto);	//정렬
		System.out.println(Arrays.toString(lotto)); //덤프
			
		
		long end = System.nanoTime(); //tick
		
		System.out.println(end - begin); //소요시간
		
			
	}		
}			
