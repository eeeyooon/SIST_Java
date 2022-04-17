package com.test.java.question.io; //04.04과제 (완료!!)

import java.io.File;
import java.util.Scanner;

public class Q03_move {

	public static void main(String[] args) {
		//Q03. 지정한 파일을 다른 폴더로 이동하고, 이동한 파일과 동일한 파일명의 파일이 존재하는 경우 중복 처리하시오.
		//조건
		//C:\class\java\file\AAA\test.txt → C:\class\java\file\BBB\test.txt 로 이동하는 것이 목적
		//BBB 폴더에 이미 test.txt가 있을 경우 덮어쓰거나(y) 작업을 취소(n) 하시오.
		
		//라벨 : 파일 이동을 실행합니다. \n 같은 이름을 가지는 파일이 이미 존재합니다. 덮어쓸까요?(y/n) 
		//입력 : y 
		//출력 : y. 파일을 덮어썼습니다.
		//입력 : n
		//출력 : n. 작업을 취소합니다.
		
		
		//파일 이동하기
		
		File file = new File("C:\\class\\java\\file\\AAA\\test.txt");	//현재 파일 위치 (file)
		File file2 = new File("C:\\class\\java\\file\\BBB\\test.txt");	//바꾸고 싶은 파일 위치 (move)
		
			
		if (file.exists()) {	//1.이동시키고싶은 파일이 AAA에 존재할때
			
			if (!file2.exists()) {	//a.근데 BBB엔 없으면
				
			file.renameTo(file2);	//그 파일 BBB로 이동시킴.
			System.out.println("파일을 이동했습니다.");
			
			} else if (file2.exists()) { //b. BBB에 있으면
				Scanner scan = new Scanner(System.in);
				System.out.print("파일 이동을 실행합니다. \n같은 이름을 가지는 파일이 이미 존재합니다. 덮어쓸까요? (y/n)");
				String input = scan.next();
				
				if (input.toLowerCase().equals("y")) {		//사용자가 덮어쓰길 원하면 (y)
					file2.delete();							//기존 BBB에 있던 파일을 지우고
					file.renameTo(file2);					//AAA에서 이동한 파일을 생성
					
					System.out.printf("%s. 파일을 덮어썼습니다.", input);
					
				} else if (input.toLowerCase().equals("n")) {	//사용자가 작업 취소를 원하면(n)
					System.out.printf("%s. 작업을 취소합니다.\n", input); //작업 취소
					
				} else {
					System.out.println("y와 n 중에서 골라주세요."); // y와 n말고 다른걸 입력하면 종료.
				}
			}
			
		} else {					//2.이동시키고 싶은 파일이 AAA에 존재하지 않으면
			System.out.println("파일이 존재하지 않습니다.");
			
			//파일이 AAA에 없으면 자동생성 (=> 무한반복 가능)
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			
		}
		
		
		
	} //main

} //Q03






















