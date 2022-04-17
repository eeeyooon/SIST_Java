package com.test.java.io;	//04.05

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ex63_File {

	public static void main(String[] args) {
		
		//63_File.java
		
		/*
			
			1. 파일/디렉토리 조작
			
			2. 파일 입출력
			- 자바 프로그램 <-> (데이터) <-> 저장 장치
			- 메모장
				
			
			저장 장치(HDD, SDD)
			- 데이터 1,0으로 저장
			- 데이터의 자료형 존재X
			
			
			인코딩, Encoding
			- 문자 코드(숫자포함)/응용 프로그램의 데이터)를 부호화(1,0) 시키는 작업
			- 자바 프로그램("홍길동", String) -> 텍스트 파일("1010100101")
			
			디코딩, Decoding
			- 부호 데이터를 문자코드로 변환하는 작업
			- 텍스트 파일("1010100101") -> 자바 프로그램("홍길동", String)
			
			
			
			인코딩/디코딩 규칙
			- 저장 장치 혹은 네트워크 상에서 데이터를 표현하는 규칙 //6개 기억해둬
			1. ISO-8859-1
			2. EUC-KR
			3. ANSI
			4. MS949
			5. UTF-8
			6. UTF-16
			
			
			ANSI(ISO-8859-1, EUC-KR, MS949)
			1. 영어(숫자, 특수문자, 서유럽) : 1byte
			2. 한글(한글, 일본어 등) : 2byte
			
			UTF-8 *** 이 인코딩을 사용함. (국제표준)
			1. 영어 : 1byte
			2. 한글 : 3byte
			
			UTF-16
			1. 영어 : 2byte
			2. 한글 : 2byte
			
			
		
		*/
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		m8();
		
		
		//3시 수업 문제풀이 이건 따로 저장함
		
	}//main
	private static void m8() {
		//긴 파일 읽기
		//파일 읽기
		try {
			
			File file = new File("C:\\class\\java\\javaTest\\src\\com\\test\\java\\Ex28_String.java");
			//문자열로 바로 읽을 순 있지만 파일로 만들어서 읽는게 더 많은 걸 할 수 있어. -> 사전검사나 이런거
			
			if (file.exists()) {
				
				BufferedReader reader = new BufferedReader(new FileReader(file));
				
				
				
				//이왕 출력하는거 소스처럼 보이게 하자
				//왼쪽 줄번호도 붙여보자 ㅎㅎ
				String line = null;
				int n = 1; //줄번호
				
				while ((line = reader.readLine()) != null ) {
					
					System.out.printf("%3d %s\n", n, line);
					n++;
					
					
				} 
				
				reader.close(); //이걸 안적어도 닫히긴 해 file이 지역 변수니까 가비지가 되며 소멸되는데 그때 닫힘.
								//근데 빨리 닫는게 나으니까! 그리고 가끔 오류로 삭제가 안되고 프로그램이 살아있을때도 있음
								//여러 변수들이 있으니까 무조건 닫아라
				
				
			} else {
				System.out.println("읽은 파일이 존재하지 않습니다.");
			}
			
		} catch (Exception e) {
			System.out.println("Ex63_File.m7");
			e.printStackTrace();
		}
		
	}
	private static void m7() {

		
		//파일 쓰기
		// - FileWrite or BufferedWrite를 쓰면 됨.
		
		//파일 읽기
		// 문장 단위로 읽을 수 있는 애가 유일하게 -> BufferedReader임.
		// 그래서 BufferedReadr쓰는게 젤 좋음.
		
		// >> 그러다보니 쓰기도 BufferedWrite를 주로 씀. (BufferedReader - BufferedWrite) 한세트로 많이 씀.
		// >> 근데 뭐,, 귀찮으면 FileWrite로 써도 됨 ㅎ 
		
		
		
		//파일 읽기
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\java\\file\\할일.txt")); //파일입력
			//매개변수가 reader 전에는 inputstreamreader를 넣어줬었음. -> 키입력을 받는 것
			// FileReader를 받을게 이번엔 파일을 받을거야
			
			
			//int code = reader.read();
			
			//파일의 한줄을 읽기 작업을 할거야. (위와 사용법같음)
			//String line = reader.readLine(); //키값에서 파일을 받는다는것만 바뀌었지 사용법은 똑같음.
												//사용자 경험 유지
			
			//System.out.println(line); //마트 장보기
			
			//여러번 출력하다 보면 더이상 읽을 문자열이 없을때가 옴. => "null"을 반환함.
			
			//모든 문자열 출력
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
			reader.close(); //얘도 꼭 닫는거 잊지말고
			
			
		} catch (Exception e) {
			System.out.println("Ex63_File.m6");
			e.printStackTrace();
		}
		
	}
	private static void m6() {
		
		//todo trycatch문 고침!
		//이방법은 한글이 안깨짐! > 얘도 막 추천은 x
		try {
			
			//FileWriter
			//FileReader
			
			FileReader reader = new FileReader("C:\\class\\java\\file\\할일.txt");  
			
//			int code = reader.read(); //문자 코드 값
//			System.out.println(code); 

			int code = -1;
			
			while ((code = reader.read()) != -1) {
				System.out.print((char)code);	//println아니고 print다!!
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Ex63_File.m6");
			e.printStackTrace();
		}
	}
		
//		//trycatch문 자동생성 내용 바꿈!
//		try {
//			
//			int a = 0;
//			System.out.println(100/a);
//			
//		} catch (Exception e) {	//예외처리를 해놓고 아무 코드 안적으면 안된다!!
//			
//			e.printStackTrace();
//		}
//		
//		System.out.println("종료");
	
	
	
	private static void m5() {
		//얘도 불편해서 잘안씀 (byte단위로 입출력하니까)
		//파일 읽기
		try {
			
			//FileOutStream
			//FileInputStream
			
			
			FileInputStream stream = new FileInputStream("C:\\class\\java\\file\\data.txt"); //"ABCDE"가 들어있음.
			
//			int code = stream.read(); //문자 코드 값
//			System.out.println(code); //A읽음 -> "65" 출력
//			
//			code = stream.read(); 
//			System.out.println(code); // 66
//			
//			code = stream.read(); 
//			System.out.println(code); // 67
//			
//			code = stream.read(); 
//			System.out.println(code); // 68
//			
//			code = stream.read(); 
//			System.out.println(code); // 69
//			
//			code = stream.read(); 
//			System.out.println(code); // -1 >> 더이상 읽을 문자가 없으면 -1 출력
			
			int code = -1;	//? 여기가 굳이 -1인 이유는 ? 0이어도 상관없는거같은데
			while ((code = stream.read()) != -1) {
				System.out.print((char)code);	//ABCDE
			}
			
			stream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	
	}
	
	private static void m4() {
		
		//파일쓰기
		try {
			
			//BufferedReader와 BufferedWriter는 범용 도구임 -> 서로 다른 전용 도구를 하나의 방식으로 통일시켜주는 역할.
			//-설정에 따라 다양한 소스를 입출력하는 도구
			//- BufferedReader reader;
			//- BufferedWriter writer;
			
			//전용 도구
			//- 파일을 대상으로 입출력하는 도구
			//- FileReader reader;
			//- FileWriter writer;
			
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\class\\java\\file\\list.txt")) ;
			
			writer.write("안녕하세요");
			writer.newLine(); // writer.write("\n")
			writer.write("홍길동입니다.");
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void m3() {
		
		//메모장 쓰기 > 콘솔 버전
		try {
			
			Scanner scan = new Scanner(System.in);
			System.out.print("저장할 파일명: ");
			String filename = scan.nextLine(); //reader.readLine()
			
			FileWriter writer = new FileWriter("C:\\class\\java\\file\\" + filename + ".txt", true);
			//파일명은 사용자한테 입력받기
			
			boolean loop = true;
			
			while(loop) {
				System.out.print("입력: ");
				String line = scan.nextLine();
				
				if (line.equals("exit")) {
					break;
				}
				
				writer.write(line); //한 줄 입력 > 한줄 쓰기
				writer.write("\n");
			}
			
			//자원 해제 코드, Clean-up Code
			scan.close();
			writer.close();
			
			System.out.println("쓰기 종료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//모든 파일 입출력은 무조건 trycatch가 필수
	private static void m2() {
		
		//쓰기 스트림
		try {
			
			FileWriter writer =  new FileWriter("C:\\class\\java\\file\\member.txt", true); //true넣으면 이어쓰는 모드
			
			writer.write("\n");
			writer.write("홍길동");
			writer.write("\n");
			writer.write("아무개");
			writer.write("\n");
			writer.write("하하하");
			
			writer.close();
			
			//스트림은 닫으면 끝!! 닫았는데 또 write하면 Stream close 에러 뜸 더 쓰고 싶으면 다시 열면됨.
			
			writer = new FileWriter("C:\\class\\java\\file\\member.txt", true); //다시 열기
			
			writer.write("\n");
			writer.write("추가 기록");
			
			writer.close(); //다시 닫기
			System.out.println("종료");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void m1() {
		
		
		//04.05 10시 수업 거의 못들음 ㅜㅜㅋ
		//파일 입출력
		
		//파일 쓰기 > 파일 출력
		//-스트림 생성(도구)
		
		//필기 놓쳤다!!!
		
		
		//쓰기 스트림 객체
		//1. 생성 모드(=덮어쓰기), Create mode
		// - 기본 방식
		
		//2. 추가 모드, Append Mode
		
		try {
			File file = new File("C:\\class\\java\\file\\data.txt");
			
			//스트림 열기
			FileOutputStream stream = new FileOutputStream(file);	//얜 try걸어줘야하는데 얘만 걸면 코드 이상하니까 전체로
			
			stream.write(65); //문자코드를 적어서 기록하는 방식
			stream.write(69);
			stream.write(70);
			
			//스트림 닫기 (무조건**)
			//- 닫지 않으면 저장이 안됨. close를 하는 순간 저장
			//- 잠긴 파일이 됨.
			stream.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}//Ex63


































