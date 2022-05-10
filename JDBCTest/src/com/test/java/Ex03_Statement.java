package com.test.java; //05.10

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Ex03_Statement {

	public static void main(String[] args) {
		
		//Ex03_Statement.java
		
		/*
			
			Connection
			- 연결/종료
			
			Statement
			- SQL 실행하는 역할
			- SQL Developer > SQL 작성 + 블럭 + ctrl/enter
			- 모든 SQL 실행 가능
			
			Statement 종류
			1. Statement
				- 기본
				
			2. PreparedStatement
				- Statement 개량 > 매개 변수 처리 특화
				- 장) 안정성 높음, 가독성 높음
				- 단) 코드량 증가
				
			3. CallableStatement
				- Statement 개량 > 프로시저 호출 전용
				- PreparedStatement 유사
			
		*/
		
		//m1();
		//m2();
		//m3();
		//m5();
		// > select를 뺀 나머지 실행 방법 (반환값이 없는 쿼리)
		
		
		//자바로 오라클을 잘 다루려면 자바가 아니라 SQL을 공부해야해!
		
	}//main

	private static void m5() {
		
		//UI + SQL
		//- 사용자 입력 > insert
		
		Connection conn = null;
		Statement stat = null;
		
		Scanner scan = new Scanner(System.in);
		
		try {
			
			//자바의 자료형 <-  아무 연관성X   -> 오라클 자료형 호환성
			//**언어가 다르면 자료형은 절대 호환 안됨.
			
			
			System.out.print("이름: ");
			String name = scan.nextLine();	//오라클에서 자료형 varchar2

			System.out.print("나이: ");
			String age = scan.nextLine();	//number
			
			System.out.print("성별(m,f): ");
			String gender = scan.nextLine();	//char
			
			System.out.print("전화번호: ");
			String tel = scan.nextLine();		//varchar2
			
			System.out.print("주소: ");
			String address = scan.nextLine();	//varchar2
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = String.format("insert into tblAddress(seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, '%s', %s, '%s', '%s', '%s', default)", name, age, gender, tel, address);

			
			int result = stat.executeUpdate(sql);
			
			System.out.println(result);
			
			conn.close();
			stat.close();
			
			
		} catch (Exception e) {
			System.out.println("Ex03_Statement.m5");
			e.printStackTrace();
		}
		
	}

	private static void m3() {
		
		Connection conn = null;
		Statement stat = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			//String sql = "delete from tblAddress where seq = 1";
			//String sql = "create sequence seqJava";
			//이건 무조건 0이 나옴. 왜냐면 행에 적용되는 쿼리는 아니니까.
			//String sql = "drop sequence seqJava";
			//String sql = "drop table tblAddress";
			String sql = "create table tblAddress("
					+ "        seq number primary key,"
					+ "        name varchar2(10) not null,"
					+ "        age number(3) not null check (age between 0 and 150),"
					+ "        gender char(1) not null check(gender in ('m', 'f')),"
					+ "        tel varchar2(15) not null,"
					+ "        address varchar2(300) not null,"
					+ "        regdate date default sysdate not null"
					+ ")";
			
			int result = stat.executeUpdate(sql);
			
			System.out.println(result); 
			//실행되면 1, 한번 더 실행하면 0 (0개의 행이 삭제되었습니다. -> 조건절을 만족하는애가 없어서 적용을 안한것)
			//적용된 행의 개수 '0'
			
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m2() {
		
		Connection conn = null;
		Statement stat = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			//error -> ORA-00911: invalid character > 거의 대부분 세미콜론때문에 뜨는 메세지
			//문자열 안에 ';' 을 넣으면 바로 에러가 남. 여기선 세미콜론 안써도 돼
			String sql = "update tblAddress set age = age + 1 where seq = 1";
			
			int result = stat.executeUpdate(sql);
			
			System.out.println(result);
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	private static void m1() {
		
		//insert 실행
		
		//1. DB 접속
		//2. SQL 실행
		//3. DB 종료
		
		//초기화를 먼저 해놓는게 편해
		Connection conn = null;
		Statement stat = null;
		
		try {
			
			//1.
			conn = DBUtil.open();
			
			if (!conn.isClosed()) {
			
				System.out.println("연결 성공");
				
				//2.
				//- 자바는 SQL을 모른다. > SQL을 문자열로 취급한다. (아무 의미x)
				String sql = "insert into tblAddress(seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, '아무개', 25, 'm', '010-5555-5555', '서울시 강남구 대치동 OO빌딩', default)";
				
				//stat > SQL실행 > 어느 DB + 어떤 계정으로 SQL 실행할지는 모름.
				stat = conn.createStatement();
				
				//반환값이 없는 쿼리 > 나머지
				//int(리턴값) stat.executeUpdate(sql)
				
				//반환값이 있는 쿼리 > select
				//ResultSet(리턴값) stat.executeQuery(sql)
				
				//SQL Developer > Ctrl + Enter
				int result = stat.executeUpdate(sql);
				//실행하는 순간 쿼리 오라클 서버로 날라감.
				//'1행이 삽입되었습니다.'와 같이 상태값을 돌려주는데 그게 result(적용된 행의 개수)
				
				
				//result(적용된 행의 개수)가 있으면 등록이 됐다는 것.
				if (result == 1) {
					System.out.println("등록 성공");
				} else {
					System.out.println("등록 실패");
				}
				
				//얘도 꼭 닫아야해 **** 모든 자원은 닫아야해
				stat.close();
				
			}
			
			
			//3.
			DBUtil.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}//Ex03


























