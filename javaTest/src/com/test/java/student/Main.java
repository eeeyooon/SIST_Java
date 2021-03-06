package com.test.java.student;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		/*
			
			1) 시작~ 공통코드 : 3시간 30분 > 2시간 30분
			
			2) 세부 업무 : 1시간 40분 > 2시간 30분
			
			
			
			학생 관리 프로그램 
			- 프로젝트 가이드
			- 파일 입출력 + 컬렉션 
			- 기본 행동: 생성하기, 읽기, 수정하기, 삭제하기 > CRUD
				- 학생 정보 추가하기(C)
				- 학생 정보 목록보기(R)
					- 학생 정보 상세보기(R)
					- 학생 정보 수정하기(E)
					- 학생 정보 삭제하기(D)
					
			- 업무별 > 클래스 분배 > 업무별 담당 클래스 나눠야 해
				
			- 데이터 설계
				- 정보 수집 > 이름, 나이, 성별, 주소, 성적(국어, 영어, 수학)
				- 분류 > (이름, 나이, 성별, 주소) (국어, 영어, 수학)
				- 파일 > 학생.txt, 성적.txt
				- 학생.txt 구조
					번호, 이름, 나이, 성별, 주소
					1,홍길동,15,1,서울시 강남구 역삼동
				- 성적.txt
					학생번호,국어,영어,수학
					1,100,80,90
				- 학생.txt <- (시험) -> 성적.txt
			
				- 데이터 파일 + 데이터 생성 //이번 샘플 코드는 한 패키지 안에서 데이터 파일 만들거야.
				
				//모든데이터는 컬렉션에
				
				- 클래스
					- 파일 경로 > DataPath.java 
				
				
				순서도
				1. 타이틀
				2. 메인 메뉴
				3. 선택
					- 각각의 기능 실행
					- 종료 > 2번으로 돌아가기
				4. 종료
				
				
				-어디까지가 공통으로 가져야하는 코드인지 회의를 통해 결정해(****)
				
				-수업 프로젝트 > 클래스 ?개
				
				-성격이 다르다 싶으면
				
				>>패캐지도 분리해야해
				
		*/
		
		//모든 데이터는 컬렉션에 옮겨서 해야 효율 생산성 속도 높음
		//파일 데이터 -> 메모리
		
		//이 메소드들도 클래스에 따로 빼기 (load(), save()) -> Data클래스
		
		
		
		Data.load();
		
		
		
		boolean loop = true;
		
		while (loop) {
			
			
			Output.title(); //초기화면 시작부
			Output.mainmenu(); //메뉴 선택 메세지
			Work work = new Work(); //여기에서 데이터를 사용함.
			
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			
			//각각의 업무를 main에서 하는게 아니라 각각 클래스를 따로 빼서 할 것. 
			//타이틀, 메뉴 선택, 종료 -> Output클래스로
			
			//학생들만 전문적으로 다루는 클래스도 하나 뺄 것.  (서비스 객체)
			//main에선 큰 틀만 잡지 세부내용은 다 다른 클래스할 거임.
			
			
			if (input.equals("1")) {	//학생 등록하기
				work.add(); //업무 위임
				
			} else if (input.equals("2")) {	//학생 목록보기
				work.list(); //업무 위임
				
			} else if (input.equals("3")) {	//학생 검색하기
				work.search(); 
			
			} else {	//4일땐 else 처리
				loop = false;
			}
			
		}// while
		
		
		Output.close(); //종료 메세지
		
		
		//scan.close는 언제하지? => 전체적인 흐름을 봤을땐 안닫는게 나을거같다. 열고닫고열고닫고반복이 힘들어.
		
		
		//메모리 > 파일 데이터에 옮기기
		Data.save();
		//실행중간에 갑자기 프로그램이 종료될 수 있으니 (그러면 실행했던 작업 다 날라감)
		//그게 걱정되면 큰 메뉴를 실행할때마다 save해줘도 됨. 근데 지금은 그냥 끝에서만 해도 ㄱㅊ
		
		
	}//main

}//class Main



















