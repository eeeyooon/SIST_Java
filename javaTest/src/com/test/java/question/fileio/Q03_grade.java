package com.test.java.question.fileio; // 04.05(과제) 완료

import java.io.BufferedReader;
import java.io.FileReader;

public class Q03_grade {

	public static void main(String[] args) {
		// Q03. 성적을 확인 후 합격자/불합격자 명단을 출력하시오.
		// 조건
		// -합격 : 3과목 평균 60점 이상
		// -과락 조건 : 1과목 40점 미만

		// 1. 파일 읽기
		// 2. 한줄을 ',' 구분자로 쪼개기
		// 3. [0] : 이름 / [1] : 국어 / [2]: 영어 / [3] : 수학
		
		
		//영석님은 set으로 합격자를 받아서 불합격자는 차집합으로 구함.
		
		String name = "";
		String pass = "";
		String fail = "";

		int kor = 0;
		int eng = 0;
		int math = 0;

		try {

			BufferedReader reader =
					new BufferedReader(new FileReader("C:\\class\\파일_입출력_문제\\성적.dat"));

			String line = null;
			while ((line = reader.readLine()) != null) {

				String[] list = line.split(",");

				for (int i = 0; i < list.length; i++) {

					name += list[0] + "\n";
					kor = Integer.parseInt(list[1]);
					eng = Integer.parseInt(list[2]);
					math = Integer.parseInt(list[3]);

				}

				
				if (test(kor, eng, math)) {
					pass += list[0] + "\n";	//list[0] = 이름
				} else {
					fail += list[0] + "\n";
				}

			}

			System.out.printf("[합격자]\n%s\n", pass);
			System.out.printf("[불합격자]\n%s\n", fail);

			reader.close();

		} catch (Exception e) {
			System.out.println("Q03_grade.main");
			e.printStackTrace();
		}



	}// main

	public static boolean test(int kor, int eng, int math) {

		if (kor >= 40 && eng >= 40 && math >= 40) { // 과락이 아닌지 확인
			if ((kor + eng + math) / 3 >= 60) { // 평균 60이상인지 확인
				return true;
			}
			return false;
		} else {

			return false;
		}



	}
}// Q03


