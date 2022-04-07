package com.test.java.question.fileio; // 04.05과제 (완료)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Q01_changeName {

	public static void main(String[] args) {
		// Q01. 특정 이름을 찾아 다른 이름으로 변환 후 파일을 다른 이름으로 저장하시오.
		// 조건
		// -'유재석' -> '메뚜기'
		// 저장할 파일명: 이름수정_변환.dat
		// 출력] 변환 후 다른 이름으로 저장하였습니다.


		
		try {

			File file = new File("C:\\class\\파일_입출력_문제\\이름수정.dat");
			File newFile = new File("C:\\class\\파일_입출력_문제\\이름수정_변환.dat");

			if (file.exists()) {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));

				String line = null;
				while ((line = reader.readLine()) != null) {

					writer.write(line.replace("유재석", "메뚜기")); //유재석 -> 메뚜기 교체
					writer.write("\n");	//엔터
				}
				
				//닫기
				reader.close();
				writer.close();
				
				//덮어쓰기
				file.renameTo(newFile);
				file.delete();
				
				
			}
			System.out.println("변환 후 다른 이름으로 저장하였습니다.");


		} catch (Exception e) {
			System.out.println("Q01_changeName.main");
			e.printStackTrace();
		}



	}// main
}// Q01


