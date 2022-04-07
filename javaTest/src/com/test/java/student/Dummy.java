package com.test.java.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class Dummy {

	public static void main(String[] args) {
		
		
		
		
		//데이터 생성용
		try {
			
			//CreateStudent();
			createScore();
			
		} catch (Exception e) {
			System.out.println("Dummy.main");
			e.printStackTrace();
		}
		
	}

	
	private static void CreateStudent() throws Exception {
		
		//1~10
		//System.out.println((int)(Math.random() * 10) +1); //0이상의 실수만 랜덤
		
		Random rnd = new Random();
		//System.out.println(rnd.nextInt()); //-21억~21억 중 하나
		//System.out.println(rnd.nextInt(10) + 1 ); // 10-> 0~9까지만. +1 하면 1~10 중 하나
		
		//여러 자료형으로 랜덤 값 반환
		
		//번호, 이름, 나이, 성별, 주소
		//1,홍길동,15,1,서울시 강남구 역삼동 2번지
		//20명 만들기
		
		
		int size = 20;
		//배열 사용하여 이름 난수
		String[] name1 = { "김", "이", "박", "최", "정", "한", "유", "민", "고", "주" };	//랜덤으로 하나 '성'
		String[] name2 = { "지", "수", "은", "연", "현", "민", "정", "윤", "원", "재", "형", "서", "성" };
		String[] address1 = {"서울시", "인천시", "부산시", "제주시", "대구시" };
		String[] address2 = {"강남구", "강동구", "강서구", "강북구", "중구" };
		String[] address3 = {"역삼동", "대치동", "압구정동", "등촌동", "천호동" };
		
		
		//파일의 경로가 올바르게 작성된건지 궁금할때?
		//파일 객체 만들어보기
		
		File file = new File(DataPath.학생);
		System.out.println(file.exists()); //이게 true가 나오면 잘 작성된것
		
		//원래는 trycatch해야하는데 여기다 trycatch하면 복잡해질거같아서 예외 미루기할게
		//그리고 main에 trycatch
		BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.학생));
		
		
		for (int i=0; i<size; i++) {
			
			int seq = i + 1;
			//String name = name1[난수] + name2[난수] + name2[난수];
			String name = name1[rnd.nextInt(name1.length)]
						+ name2[rnd.nextInt(name2.length)]
						+ name2[rnd.nextInt(name2.length)];
			
			int age = rnd.nextInt(3) + 14; //0~2까지 가져와서 + 14 = 14~16
			int gender = rnd.nextInt(2) + 1; //0~1까지 + 1 = 1~2
			
			String address = address1[rnd.nextInt(address1.length)]
						   + " "	 
						   + address2[rnd.nextInt(address2.length)]
						   + " "	 
						   + address3[rnd.nextInt(address3.length)]		
						   + " "
						   + (rnd.nextInt(30) + 1)+ "번지";
			
			//System.out.println(seq + "," + name + "," + address);
			
			//학생.txt에 옮겨야해
			
			writer.write(String.format("%d,%s,%d,%d,%s\n"
										, seq
										, name
										, age
										, gender
										, address));
			
			
		}//for
		
		writer.close();
		
		System.out.println("생성 완료.");
		
	}


	private static void createScore() throws Exception {
		
		//****성적.txt
		//학생 20명 > 성적 3회 분량
		//학생번호,국어,영어,수학
		//홍길동,100,80,90
		//학생번호는 반드시 학생.txt에 있는걸 써야 함.
		//하다보면 패턴이없는 데이터가 생길 수 있음. (순서가 제각각이거나 빠진 숫자가 있거나)
		//그래서 학생.txt를 읽어서 실존하는 데이터를 가져와야 해.
		

		
		String temp = "";
		
		//랜덤 객체 만들기
		Random rnd = new Random();
		
		for (int j=0; j<3; j++) {
			
			//학생.txt에서 학생 번호 얻어오기
			BufferedReader reader = new BufferedReader(new FileReader(DataPath.학생)); //예외 던지기
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String seq = line.split(",")[0]; //학생번호는 0번째 방에
				
				int kor = rnd.nextInt(51) + 50; //50점부터 100점
				int eng = rnd.nextInt(51) + 50;
				int math = rnd.nextInt(51) + 50;
				
				temp += temp = String.format("%s,%d,%d,%d\n", seq,kor,eng,math);	//temp에 누적
				System.out.println(temp);
				
			}//while 
			
		}//for //근데 성적 3회분량이니까 while을 3번 반복 (바깥을 for문으로 감싸기)
		
		//write로 한번에 저장하기
		//반복문안에서 wirter쓰면 오히려 불편함. while문 안에 문자열 만들고 바깥에서 writer 한번에 
		BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.성적));
		
		
		writer.write(temp);
		writer.close();
		
		System.out.println("등록 완료.");
		
		//각 학생별 성적 3회분 저장까지 끝.
		//여기까지가 데이터작업
		
		
		
		
		
	}











}
