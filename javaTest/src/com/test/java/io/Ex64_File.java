package com.test.java.io;	//04.06

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex64_File {

	public static void main(String[] args) {

		//m1();
		//m2();
		//m3();
		m4();
		

	}// main

	private static void m4() {
		//전체 읽고 -> 조건에 해당하는 부분읽기 편하게 하는 법
		
		//User클래스 새로 만듦 (맨 밑) -> 한사람의 정보를 저장하는 클래스
		ArrayList<User> list = new ArrayList<User>();
		
		//파일 읽기는 한번 읽은걸 다시 돌아가기가 굉장히 불편함.
		//그래서 생각한 방법이 그 파일 내용을 처음부터 배열로 옮겨놓는것.
		//그럼 텍스트 파일을 읽고싶을 땐 배열을 읽으면 됨 (>>이게 압도적으로 편리함. 물리적인 성능차이도 큼)
		
		//매개 변수 전달 방식
		//1. 모든 값형 > Call by value	 >> 얘는 돌려받고싶으면 무조건 리턴을 써야하고
		//2. 모든 참조형 > Call by reference	>> 얘는 리턴을 안해도 참조형이기때문에 받을 수  있음
		load(list); //메소드로 빼서 배열에 옮길게
		
		//이제부턴 파일 입출력이 아닌 컬렉션조작임.
		for (User u : list) {
			System.out.printf("%s. %s(%d세)\n", u.getNo(), u.getName(), u.getAge());
		}
		
		System.out.println();
		
		//나이가 22이상인 사람만
		
		for (User u : list) {
			if (u.getAge() >= 22) {
				System.out.printf("%s. %s(%d세)\n", u.getNo(), u.getName(), u.getAge());
				
			}
		}
		
		//데이터 수정
		//- 나이가 많은 사람을 표시
		//- 홍길동 > 홍길동(*)
		
		for (User u : list) {
			if (u.getAge() >= 22) {
				u.setName(u.getName() + "(*)");
				
			}
		}
		
		//System.out.println(list);
		
		
		//데이터 삭제
		list.remove(2); //이건 컬렉션 삭제임 (텍스트 파일 삭제가 아니라)
		
		//배열 가지고 수정하고 삭제하고 뭘 하든간에 마지막에 텍스트 파일에 덮어쓰는 과정을 해야 함!
		//내용을 수정했으면 반대로 메모리(배열)에 있는걸 텍스트 파일로 반영해야해 ** 
		save(list); //내보내기
		
		
		//텍스트 파일로 입출력을 직접하는건 컬렉션으로 입출력하는 것보다 불편해
		//텍스트 파일을 수정삭제등 할거면 배열로 옮겨놔서 사용해
		//마지막에 텍스트 파일에 덮어쓰기하는것만 잊지마
		
		
	}

	private static void save(ArrayList<User> list) {
		//수정된 내용을 텍스트 파일로 반영하는 방법
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.MEMBER));
			//여기서도 덮어쓰기해야해
			
			//User 1개를 -> 1,홍길동,20 으로 만들고 -> Writer.write() 하면됨.
			
			
			for (User u : list) { //배열탐색(컬렉션탐색)
				
				writer.write(String.format("%s,%s,%d\n"
											, u.getNo(), u.getName(), u.getAge()));
				
			}
			
			writer.close();
			
		} catch (Exception e) {
			System.out.println("Ex64_File.load");
			e.printStackTrace();
		}
		
	}

	private static void load(ArrayList<User> list) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(Data.MEMBER));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				//1,홍길동,20
				
				String [] temp = line.split(",");
				
				//텍스트 파일의 1줄을 > User 객체 1개로 만듦.
				User user = new User(temp[0], temp[1], Integer.parseInt(temp[2]));
				
				list.add(user); //user를 ArrayList에 담기.
				// => 텍스트 파일에 있는 내용을 모두 잘라서 user에 넣어놓고 user를 list에 옮김.
				
				//리턴 안해도돼. 참조형이니까.

				
			}
			
		} catch (Exception e) {
			System.out.println("Ex64_File.load");
			e.printStackTrace();
		}
		
		
	}

	private static void m3() {
		//(1)파일 읽기
		
		try {
			
			//데이터 파일 구조 > Scheme(스키마)
			//CSV -> 컴마로 값을 구분하는 표기법
			//번호,이름,나이
			//1,홍길동,20 -> 한줄이 하나의 정보 -> 각각 객체는 컴마로 구분됨.
			
			BufferedReader reader = new BufferedReader(new FileReader(Data.MEMBER));
			//파일 시작부(BOF)에 커서를 만듦
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				//readLine -> 커서를 첫번째 줄로 내림. 커서가 가리키는 데이터를 출력 (다음 줄로 옮기며 반복)
				//		   -> 마지막 줄까지 읽고나서 EOF(마지막부)에 도달하면 null 반환
				// 이 커서(화살표)는 위에서 밑으로만 갈 수 있음.(위로 못감) = 전진 커서(일방향)
				
				String[] temp = line.split(",");
				System.out.printf("%s. %s(%s세)\n", temp[0], temp[1], temp[2]);
			}
			
			reader.close();
			
			System.out.println();
			
			//22세 이상 목록 다시 출력
			
			//리더는 재사용이 불가능함. (한번 읽으면 끝 또 못읽음) -> 다시 읽고 싶으면 생성해야해
			//스트림 객체를 다시 생성 > 생성 직후 커서는 BOF에 위치
			reader = new BufferedReader(new FileReader(Data.MEMBER));
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (Integer.parseInt(temp[2]) >= 22) {
				
					System.out.printf("%s. %s(%s세)\n", temp[0], temp[1], temp[2]);
				}
			
			}
			
			
		} catch (Exception e) {
			System.out.println("Ex64_File.m3");
			e.printStackTrace();
		}
		
		
	}

	private static void m2() {
		
		//파일 수정
		//1. 기존 내용을 출력한다.	> 읽기 (1)
		//2. 내용의 일부를 수정한다.
		//3. 저장한다.
		// -> 이걸 콘솔에서 해보자
		
		
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(Data.EDIT)); //Data클래스
			
			System.out.println("[현재 내용]");
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				System.out.println(line);
				
				
			}
			
			reader.close(); //읽기 닫기
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("[수정 내용]");
			
			String input = scan.nextLine();
			
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.EDIT));
			
			//입력 받은 내용 덮어쓰기
			writer.write(input);
			
			writer.close();
			
			System.out.println("수정 완료");
			
			//콘솔 여건상 불편해도 수정은 덮어쓰기하는 방법밖에 없음 (모든 언어가 다 덮어쓰기를 함. 메모장도)
			//UI는 달라보이지만 물리적으로 보면 덮어쓰는 방법은 같음. 
			
			
		} catch (Exception e) {
			System.out.println("Ex64_File.m2");
			e.printStackTrace();
		}
	}

	private static void m1() {


		// 읽고쓰는 파일의 위치
		// 1. 프로젝트 폴더 외부
		// 2. 프로젝트 폴더 내부
		// -관리 용이
		// -프로젝트 위치 이동 > 파일과 같이


		try {


			/*
			
				콘솔 명령어
				
				C:\Users\in> _
				현재위치 -> 깜박거리는 언더바는 프롬프트
				
				1. dir
					- 현재 디렉토리의 목록(내용물) 보여주세요.
				2. cd
					- change directory
					- cd 자식 폴더명
					- cd .. => 부모 폴더명 (유일하니까)
				
				자원 경로 표현법
				1. 절대 경로 
					- 기준점 : 절대 위치 
					- ex) 홍길동, A5열에 앉아있는 사람 (누가봐도 그 위치는 절대적임)
					- 무조건 드라이브명으로 시작하면 절대 경로임.
					- ex) C:\class\java\data.txt
				
				2. 상대 경로 
					- 기준점 : 상대 위치
					- ex) 나, 내 앞에 앉아있는 사람 (누구냐에 따라 위치가 달라짐)
					- 드라이브명 x
					- ex) .\data.txt => '.'은 자기자신.= 현재 이 표현을 한 파일이 속해있는 폴더, 현재 위치
					- ex) .\file\memeber.txt => 이 파일이 있는 폴더에 들어가면 memeber.txt 있다
					
					
				프로젝트 팀작업
				A팀원 
				- C:
				- D:\java\data 폴더에 데이터 넣어버럼.
				
				B팀원 (D드라이브X)
				- C:\java\data 폴더에 데이터 넣어서 관리하자고 약속.
				
				C팀원
				- C:\Users\in\Downloads\data 관리
					
			*/

			//File file = new File(".");	//현재 폴더(이 프로그램이 속해있는 현재 폴더) > 상대 경로
			
			//System.out.println(file.getAbsolutePath()); //절대 경로 (상대경로를 절대경로로 확인해서 알려줌)
			//C:\class\java\javaTest\.
			
			//System.out.println(file.getPath()); //상대 경로 >File생성때 표현을 그대로 반환
			//.

			
			//이클립스에서 자바프로젝트에 단순 폴더 생성 -> 그 폴더내 단순 파일 생성 => 공유하기 편함.
			//프젝할땐 절대경로말고 상대경로로 
			
			File file = new File("data\\data.txt");	//현재폴더 > 상대경로 (프젝할땐 상대경로로)
			//무조건 내가 중심이니까 맨 앞 '.\\' 안적어도 됨. (보통 안적음. 안적어도 있는걸로 생각함)
			
			
			//파일 수정하기(******)
			//- 파일 입출력에는 수정이라는 행동이 없음.
			//- 파일은 수정이 아니라 덮어쓰기로 구현함.
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			writer.write("테스트");
			writer.close();
			
			System.out.println("종료");
			


		} catch (Exception e) {
			System.out.println("Ex64_File.m1");
			e.printStackTrace();
		}

	}// m1

}// Ex64



class User {
	
	//번호,이름,나이
	//1,홍길동,20
	//한 줄이 한 사람. -> 한사람의 정보를 만들 수 있는 상자를 만들러 옴. (한 줄이 하나의 객체)
	//생성자, getter/setter, toString 자동 생성함
	
	private String no;
	private String name;
	private int age;
	
	
	public User(String no, String name, int age) {
		this.no = no;
		this.name = name;
		this.age = age;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}









