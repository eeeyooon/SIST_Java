package com.test.java.mvc; //05.11

import java.util.ArrayList;
import java.util.Scanner;

//Address 업무 담당 객체
//1. 쓰기
//2. 읽기
//3. 수정
//4. 삭제

public class Service {

	public void start() {
		
		
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		
		while (loop) {
			
		//각 메뉴당 볼륨이 크면 하위서비스객체로 만들면 되지만, 우리는 안크니까 여기서 메소드로	
			
		View view = new View();
		
		view.menu();
		
		String input = scan.nextLine();
		
		if (input.equals("1")) {
			add();
		} else if (input.equals("2")) {
			list();
		} else if (input.equals("3")) {
			edit();
		} else if (input.equals("4")) {
			del();
		} else { //돌아가기(loop 끝내기)
			
			loop = false;
			
		}
		
		
		}
		
	} //start()

	private void add() {
		
		System.out.println("[주소록 등록하기]");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		System.out.print("나이: ");
		String age = scan.nextLine();

		System.out.print("성별(m,f): ");
		String gender = scan.nextLine();
		
		System.out.print("전화: ");
		String tel = scan.nextLine();
		
		System.out.print("주소: ");
		String address = scan.nextLine();
		
		
		//DB 담당자
		DAO dao = new DAO();
		
		
		
		
		//int result = dao.add(데이터); //데이터를 맡기고 결과를 반환받음(보고) > 1.성공, 0.실패
		
		//Service -> (데이터) -> DAO
		Address dto = new Address(); //데이터를 상자로 포장
		
		dto.setName(name);
		dto.setAge(age);
		dto.setGender(gender);
		dto.setTel(tel);
		dto.setAddress(address);
		
		
		int result = dao.add(dto); //포장한 상자를 DAO한테 넘김 -> 결과 반환(보고) : result
		
		if (result == 1) {
			//성공
			System.out.println("주소록 등록을 완료했습니다.");
			
		} else {
			//실패
			System.out.println("주소록 등록을 실패했습니다.");
		}
		
		pause();
		
		
	}

	private void list() {
		
		System.out.println("[주소록 목록보기]");
		
		//1. DAO 위임 > DB > select > rs
		//2. 결과셋 반환
		//3. View에게 전달 + 출력
		
		DAO dao = new DAO();
		
		//DAO한테 데이터(목록)를 달라고 요청 > DAO는 select 날려서 데이터 가져옴
		
		//ResultSet rs = dao.list(); > 이거 안돼
		//**** DB 담당자 > DAO > JDBC 코드 관리하는애 
		// resultSet은 JDBC코드잖아
		//**** 이렇게하면 Service 담당자가 JDBC 코드를 관리하게 돼
		//**************Connection, Statement, ResultSet > 반드시 DAO.java에서만 코딩 (다른 클래스에서 발견되면 안돼)**********
		
		//이렇게 해야돼!
		ArrayList<Address> list = dao.list();
		
		//여기서 직접 출력하지말고 view한테 넘김
		View view = new View();
		view.list(list);
		
		
		pause();
		
	}

	private void edit() {
		
		System.out.println("[주소록 수정하기]");
		
		//수정할 번호 > 입력 > 현재 내용 출력 > 수정할 데이터 입력
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수정할 번호: ");
		String seq = scan.nextLine();
		
		
		DAO dao = new DAO();
		
		//그 seq의 레코드를 가져옴 (현재 상태 보여주기위해)
		Address dto = dao.get(seq); 
		
		System.out.println("이름: " + dto.getName());
		System.out.println("나이: " + dto.getAge());
		System.out.println("성별: " + dto.getGender());
		System.out.println("전화: " + dto.getTel());
		System.out.println("주소: " + dto.getAddress());
		System.out.println();
		//seq랑 주소는 바꿀거 아니니까 안가져옴.
		
		System.out.println("수정할 항목(수정하지 않으려면 입력하지 않고 엔터");
	
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		if (!name.equals("")) { //빈문자열이 아니라면(수정할 내용을 입력했다면)
			dto.setName(name); //입력받은 내용으로 수정 (DB는 있다가, 일단 DTO 이름 먼저)
		}
		
		
		System.out.print("나이: ");
		String age = scan.nextLine();
		
		if (!age.equals("")) { 
			dto.setAge(age); 
		}
		
		
		System.out.print("성별: ");
		String gender = scan.nextLine();
		
		if (!gender.equals("")) {
			dto.setGender(gender); 
		}
		
		
		System.out.print("전화: ");
		String tel = scan.nextLine();
		
		if (!tel.equals("")) { 
			dto.setTel(tel); 
		}
		
		
		System.out.print("주소: ");
		String address = scan.nextLine();
		
		if (!address.equals("")) { 
			dto.setAddress(address); 
		}
		
		
		//DB -> update
		int result = dao.edit(dto); 
		
		if (result == 1) {
			System.out.println("주소록 수정을 완료했습니다.");
		} else {
			System.out.println("주소록 수정을 실패했습니다.");
		}
		
		
		
		pause();
		
		
		
	}

	private void del() {

		System.out.println("[주소록 삭제하기]");
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제할 번호: ");
		String seq = scan.nextLine();
		
		DAO dao = new DAO();
		
		int result = dao.del(seq);
		
		if (result == 1) {
			System.out.println("주소록 삭제를 완료했습니다.");
		} else {
			System.out.println("주소록 삭제를 실패했습니다.");
		}
		
		
		pause();		
		
	}
	
	
	private void pause() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("계속 진행하시려면 엔터를 입력하세요.");
		scan.nextLine();
		
	}
	
	
	
} //Service
