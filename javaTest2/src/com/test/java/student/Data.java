package com.test.java.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

//파일 데이터 <-> 메모리(배열) => load, save
public class Data {
	
	//프로그램 전체(전역)에서 사용하게 될 자원들(데이터)은 static으로 선언하면 편리함.
	//>이게 좋은 방법은 아니지만 지금 콘솔 프로젝트엔 다른 방법이 없으니 여기서만 이렇게.
	//실무에선 다른 방법(지금 우리가 하긴 어려운 방법)
	//static은 우리가 마음대로 못없애. 생명주기가 너무 길어 -> 이것때문에 좋은 방법이 아니라는 거지만
	//우리 프젝할땐 ㄱㅊ
	
	public static ArrayList<Student> slist = new ArrayList<Student>();
	public static ArrayList<Score> clist = new ArrayList<Score>();
	
	
	// >>> DataPath잡아놓은 것처럼 얘도 어디서든지 쓸 수 있음!! (똑같음.)
	
	
	
	//main에서 객체 안만들었으니까 static으로
	public static void load() {
		
		
		
		
		//여긴 예외 밀어낼데가 없어서 trycatch
		try {
			
			
			
			//학생.txt -> slist로 옮기기 완료
			BufferedReader reader = new BufferedReader(new FileReader(DataPath.학생));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				//번호, 이름, 나이, 성별, 주소
				//1,홍길동,15,1,서울시 강남구 역삼동
				
				String [] temp = line.split(",");
				
				//한 학생의 정보는 Student 클래스에, 한 학생의 점수는 Score클래스에
				
				Student s = new Student(temp[0], temp[1], temp[2], temp[3], temp[4]);
				
				slist.add(s); //이 정보들 arrylist에 담기
				
			}
			
			reader.close(); //reader닫기
			
			
			
			//성적.txt -> clist로 옮기기 완료
			reader = new BufferedReader(new FileReader(DataPath.성적));
			
			line = null;
			
			while((line = reader.readLine()) != null) {
				//학생번호,국어,영어,수학
				//1,100,80,90
				
				String [] temp = line.split(",");
				
				//한 학생의 정보는 Student 클래스에, 한 학생의 점수는 Score클래스에
				
				Score s = new Score(temp[0]
											, Integer.parseInt(temp[1])
											, Integer.parseInt(temp[2])
											, Integer.parseInt(temp[3]));
				
				clist.add(s); //이 정보들 arrylist에 담기
				
			}
			
			reader.close(); //reader닫기
			
			
		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}
		
	}
	
	public static void save() {
		
		
		//메모리 > 파일 데이터에 저장
		
		try {
			
			//slist > 학생.txt
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.학생));
			
			for (Student s : slist) {
			
				//번호, 이름, 나이, 성별, 주소
				//1,홍길동,15,1,서울시 강남구 역삼동
				
				//위처럼 한줄로 만들기
				String line = String.format("%s,%s,%s,%s,%s\n"
											, s.getSeq()
											, s.getName()
											, s.getAge()
											, s.getGender()
											, s.getAddress());
				
				writer.write(line);
			}
			
			writer.close();
			
			
			//clist > 성적.txt (성적 배열안에 있던 모든 내용을 가져와서 저장)
			writer = new BufferedWriter(new FileWriter(DataPath.성적));
			
			for (Score s : clist) {
			
				//학생번호,국어,영어,수학
				//1,100,80,90
				
				//위처럼 한줄로 만들기
				String line = String.format("%s,%d,%d,%d\n"
											, s.getSeq()
											, s.getKor()
											, s.getEng()
											, s.getMath());
				
				writer.write(line);
			}
			
			writer.close();
			
			
		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();
		}
		
		
	}
	

}//Data 












