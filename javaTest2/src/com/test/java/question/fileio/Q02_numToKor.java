package com.test.java.question.fileio; // 04.05과제 (완료)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Q02_numToKor {

	public static void main(String[] args) {
		// Q02. 숫자를 한글로 바꾼 뒤 파일을 다른 이름으로 저장하시오.
		// 0-> 영, 1-> 일...
		// 출력] 변환 후 다른 이름으로 저장하였습니다.



		try {

			
			File file = new File("C:\\class\\파일_입출력_문제\\숫자.dat");
			File newFile = new File("C:\\class\\파일_입출력_문제\\숫자_변환.dat");

			if (file.exists()) {
				BufferedReader reader = new BufferedReader(new FileReader(file)); // 파일 열기
				BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));// 파일 내보내기

				String line = null;
				while ((line = reader.readLine()) != null) {

					// 한줄씩 가져와서 읽는데
					// 그 줄에 숫자가 있으면 추출
					// 숫자 -> 한글 replace

					for (int i = 0; i < line.length(); i++) { // 각 줄을 돌리면서 한문자씩 확인
						char ch = line.charAt(i);

						if (checkNum(ch)) { // 그 문자가 숫자인지 확인
							line = line.replace(ch, korRead(ch)); // 숫자면 한글 발음으로 교체
						}
					}
					writer.write(line);
					writer.write("\n");
				}


				reader.close();
				writer.close();
				file.renameTo(newFile);
				file.delete();


			}

			System.out.println("변환 후 다른 이름으로 저장하였습니다.");


		} catch (Exception e) {
			System.out.println("Q01_changeName.main");
			e.printStackTrace();

		}

	}// main

	private static boolean checkNum(char num) { // 숫자가 있는지 확인

		switch (num) {

			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				return true;

		}

		return false;

	}

	public static char korRead(char num) { // 숫자를 한글 발음으로 교체

		switch (num) {

			case '0':
				return '영';
			case '1':
				return '일';
			case '2':
				return '이';
			case '3':
				return '삼';
			case '4':
				return '사';
			case '5':
				return '오';
			case '6':
				return '육';
			case '7':
				return '칠';
			case '8':
				return '팔';
			case '9':
				return '구';
		}

		return '\0';
	}
}

