package com.test.java.student;

import java.util.Scanner;

//학생 처리 업무 담당 클래스 
public class Work {
	
	//메소드마다 공통으로 쓰는 자원들은 이렇게 맨 위에 빼서 멤버로 만들어주기.
	
	private Scanner scan;
	
	public Work() {		//생성자
		this.scan = new Scanner(System.in);
	}
	
	//CRUD
	//학생 추가하기
	public void add() { //객체로..? (객체할지 말지는 기준이 불명확. 그래서 둘다해보자)
		
		//scan 지역변수
		
		
		
		//작은 타이틀 띄우기

		Output.subtitle("학생 등록하기");
		
		//학생 정보에서 4개만 입력받을 것 (이름, 나이, 성별, 주소) -> 번호는 마지막 번호보다 하나 더 크게
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		System.out.print("나이: ");
		String age = scan.nextLine();
		
		System.out.print("성별(1.남자, 2.여자): ");	//가이드 라인 제시 (우린 이정도만 하자)
		String gender = scan.nextLine();
		
		System.out.print("주소: ");
		String address = scan.nextLine();
		
		
		String seq = getSeq(); //가장 마지막 번호에 +1 한 것
		
		//입력받은 데이터를 arraylist로
		
		//번호는 마지막 번호보다 하나 더 큰 번호로
		Student s = new Student(seq, name, age, gender, address); 
		
		Data.slist.add(s);	//학생 추가하기
		
		
		System.out.println();
		System.out.println("학생 추가 완료");
		
		Output.pause();	//출력에서 한텀 쉬기 -> 얘도 상투적인거라 Output으로
		
	}
	
	//마지막번호 (가장 큰 번호)
	private String getSeq() {
		
		int max = 0;
		
		for (Student s : Data.slist) {
			
			int seq = Integer.parseInt(s.getSeq()); //학생들의 번호
			
			if (seq > max) {	//가장 큰 번호 찾기
				max = seq;		//max = 가장 큰 번호
			}
			
		}
		
		return (max + 1) + "";	//가장 큰 번호(마지막 번호) + 1
		
	}


	//학생 목록보기
	public void list() {
		
		Output.subtitle("학생 목록보기");	//submenu보단 subtitle
		
		//포맷
		System.out.println("[번호]\t[이름]\t[나이]\t[성별]");
		
		for (Student s : Data.slist) {
			
			System.out.printf("%4s\t%4s\t%4s\t%4s\n"
								, s.getSeq()
								, s.getName()
								, s.getAge()
								, s.getGender().equals("1") ? "남자" : "여자");
		}
		
		System.out.println();
		System.out.println();
		//여기서만 볼 수 있는 메뉴 띄우기
		
		boolean loop = true;
		
		//mani메뉴 반복하듯이 반복
		while (loop) {
		
		
			Output.submenu();
			
			//메뉴 목록 보고 나서 선택 
			String input = scan.nextLine();
			
			if (input.equals("1")) {
				//상세보기
				view();
				
			} else if (input.equals("2")) {
				//수정하기
				edit();
				
			} else if (input.equals("3")) {
				//삭제하기
				delete();
				
			} else {	//= "4"
				//상위메뉴로 돌아가기
				//이 루프로 빠져나가면 main으로 돌아감(얘가 main안에 있는 list니까.)
				
				loop = false;
				
			}
			
			 Output.pause(); //일시중지 걸기
			
		}
		
		
	
	}//list
	
	

	public void search() {
		
		Output.subtitle("학생 검색하기");	
		
		//검색조건 입력 (이름? 번호? 이런거 미리 정해야해)
		//이름 or 주소 검색
		//-> 완전 검색할지(홍길동, 서울시 강남구 대치동 3번지) , 부분검색할지 (홍, 길동, 서울시, 강남구) 
		// => 데이터의 성질에 따라 결정해야 함. 여기서는 부분검색이 나음. 
		
		System.out.print("검색어(이름/주소): "); //길동으로 입력하면 사람이름일수도 있고, 주소 '길동'일수도 있게 둘다 받는걸로.
		String input = scan.nextLine();
		
		
		
		
		
		//포맷
		System.out.println("[번호]\t[이름]\t[나이]\t[성별]");
		
		for (Student s : Data.slist) { //하나하나 열어서 다 뒤지는 수밖에 없음.
			
			if (s.getName().contains(input) 
				|| s.getAddress().replace(" ", "").contains(input.replace(" ", ""))) { 
				//이름이나 주소에 입력값이 포함됐는지 확인
				//문자열 내에 공백 없애주기(검색어와 검색대상 모두)
				
				
				System.out.printf("%4s\t%4s\t%4s\t%4s\n"
									, s.getSeq()
									, s.getName()
									, s.getAge()
									, s.getGender().equals("1") ? "남자" : "여자");
			
			}
			
		}
		
		Output.pause();
		
	}
	
	
	
	
	//만약 이 업무량이 너무 많으면 하위 클래스 만들어서 빼주면돼
	//몇개 안되니까 여기서 할게 (work)
	
	private void delete() {
		//삭제하기
		
		System.out.print("학생 선택(번호): ");
		
		String input = scan.nextLine();	//학생번호(seq)
		
		Student result = null;
		
		//입력받은 학생번호로 학생 찾기
		
		for (Student s : Data.slist) {
			
			if (s.getSeq().equals(input)) {	//입력받은 학생번호와 일치하는 학생
				result = s;
				break;
			}
			
		}
		
		
		if (result != null){
			
			Data.slist.remove(result); //그 학생 삭제
			System.out.println("삭제 완료");
			
			
		} else {
			
			System.out.println("입력한 학생 번호가 올바르지 않습니다.");
			
		}
		
		//Output.pause(); //이거하고 나가면 list나가서도 pause있어서 중복인듯?
		
		
	}

	private void edit() {
		//수정하기 (번호는 수정 X) => 수정할 내용이 너무 많으면 한두번 해보고 구현 안해도돼(메뉴는 살려두고 구현만 x해도돼)
		
		System.out.print("학생 선택(번호): ");
		
		String input = scan.nextLine();	//학생번호(seq)
		
		Student result = null;
		
		//입력받은 학생번호로 학생 찾기
		
		for (Student s : Data.slist) {
			
			if (s.getSeq().equals(input)) {	//입력받은 학생번호와 같은 번호가 있으면
				result = s;	//주소값 복사 > 참조형 (result를 수정하든 s를 수정하든 같은 값이 수정됨. s는 arraylist에 들어있던 애)
				break;
			}
			
		}
		
		
		if (result != null) { //학생이 있으면
			//수정작업
			
			// > 수정하기 싫으면 그냥 엔터만 입력하도록.
			System.out.println("[이름]" + result.getName()); //원래 이름이 뭐였는지
			System.out.print("수정: "); //수정받을 이름 입력받을 것 => 이름 수정하기 싫으면 엔터
			String name = scan.nextLine();
			
			//이름을 수정할거면 새로운 이름, 이름 수정을 원치않으면 엔터 -> 스캔이나 버퍼드 모두 입력안하고 엔터치면 ""(빈문자열)이 반환됨.
			
			if (!name.equals("")) {
				result.setName(name); //이름 수정
			}
			
			
			
			//나이수정
			System.out.println("[나이]" + result.getAge()); //원래 나이가 뭐였는지 보여줌
			System.out.print("수정: "); //수정받을 나이 입력받을 것 => 나이 수정하기 싫으면 엔터
			String age = scan.nextLine();
			
			//나이수정 원치 않으면 엔터
			if (!age.equals("")) {
				result.setAge(age); //나이 수정
			}
			
			//성별수정
			System.out.println("[성별]" + (result.getGender().equals("1") ? "남자" : "여자")); //원래 성별이 뭐였는지 보여줌
			System.out.print("수정: "); //수정받을 성별 입력받을 것 => 성별 수정하기 싫으면 엔터
			String gender = scan.nextLine();
			
			//성별수정 원치 않으면 엔터
			if (!gender.equals("")) {
				result.setGender(gender); //성별 수정
			}
			
			
			//주소수정
			System.out.println("[주소]" + result.getAddress()); //원래 주소가 뭐였는지 보여줌
			System.out.print("수정: "); //수정받을 주소 입력받을 것 => 주소 수정하기 싫으면 엔터
			String address = scan.nextLine();
			
			//나이수정 원치 않으면 엔터
			if (!address.equals("")) {
				result.setAddress(address); //나이 수정
			}
			
			System.out.println("수정 완료.");
			
		} else { //못찾았으면
			System.out.println("입력한 학생 번호가 올바르지 않습니다.");
			
		}
		
		//Output.pause(); > 얘도..
		
	}

	private void view() {
		//상세보기
		//위의 출력된 목록에서 한명 선택(번호로)
		
		System.out.print("학생 선택(번호): ");
		
		String input = scan.nextLine(); //학생 번호 입력 받음.
		
		Student result = null;
		
		//입력받은 학생번호로 학생 찾기
		
		for (Student s : Data.slist) {
			
			if (s.getSeq().equals(input)) {	//입력받은 학생번호와 같은 번호가 있으면
				result = s;
				break;
			}
			
		}
		
		//null이면 이런 학생이 없는 것
		if (result != null) {
			
			//학생 정보
			
			System.out.println("[번호]" + result.getSeq());
			System.out.println("[이름]" + result.getName());
			System.out.println("[나이]" + result.getAge());
			System.out.println("[성별]" + (result.getGender().equals("1") ? "남자" : "여자") );
			System.out.println("[주소]" + result.getAddress());
			
			//성적 출력
			
			for (Score s : Data.clist) {
				if (s.getSeq().equals(result.getSeq())) {
					System.out.printf("국어(%d), 영어(%d), 수학(%d) = 평균(%.1f)\n"
										, s.getKor()
										, s.getEng()
										, s.getMath()
										, (s.getKor() + s.getEng() + s.getMath()) / 3.0);
				}
				
			}
			
			
			
		} else {
			System.out.println("입력한 학생 번호가 올바르지 않습니다.");
		}
		
		System.out.println();
		//Output.pause(); //번호가 올바르지 않으면 그냥 바로 나가기 -> 이거 넣으니까 두번 나오는데
		
	}

}















