package com.test.java; // 05.10

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Ex04_select {

	public static void main(String[] args) {

		// Ex04_select.java

		// 반환값이 있는 쿼리 (select)
		// m1();
		// m2();
		// m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		m9();
		
	} // main

	private static void m9() {
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;


		try {

			conn = DBUtil.open();
			stat = conn.createStatement();
			
			
			//tblAddress 출력
			String sql = "select * from tblAddress order by seq asc";
			
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			
			//자원해제코드, Clean-up code
			//안해도 실행 가능함. (에러x) 나중에 알아서 소멸되긴함. > 하지만 가능한 한 빨리 닫는게 메모리 효율에 좋음.
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void m8() {
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;


		try {

			conn = DBUtil.open();
			stat = conn.createStatement();
		
			//요구사항] 영업부 직원수와 영업부 직원 명단을 출력하시오. 
			//1. select count(*) as cnt from tblInsa where buseo = '영업부'
			//2. select * from tblInsa where buseo = '영업부'
			
			String sql = "";
			
			sql = "select * from tblInsa where buseo = '영업부'";
			
			rs = stat.executeQuery(sql);
			
			int n = 0;
			while (rs.next()) {
				System.out.println(rs.getString("name"));
				n++;
			}
			
			
			rs.close();
			
			System.out.println();
			System.out.println("직원수: " + n);
			//꼭 밑처럼 별도로 쿼리 추가 안해도 카운트 변수 만든 다음에 회전수 저장하면 직원수 출력 가능
			
			
//			sql = "select count(*) as cnt from tblInsa where buseo = '영업부'";
//			
//			rs = stat.executeQuery(sql);
//			
//			if (rs.next()) {
//				System.out.println("직원수: " + rs.getString("cnt"));
//			}
//			
//			
//			rs.close();
			
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m7() {
		
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;


		try {

			conn = DBUtil.open();
			stat = conn.createStatement();
			
			//회원명 + 대여한 비디오명
			String sql = "select m.name as name, v.name as video from tblVideo v inner join tblRent r on v.seq = r.video inner join tblMember m on m.seq = r.member";
			
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				
				//System.out.println(rs.getString(1));
				//System.out.println(rs.getString(2));
				
				//System.out.println(rs.getString("m.name"));
				//System.out.println(rs.getString("v.name"));
				
				//System.out.println(rs.getString("name"));
				//System.out.println(rs.getString("name_1"));
				
				//System.out.println(rs.getString("name")); //m.name
				//System.out.println(rs.getString("name")); //m.name
				
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("video"));
				
				System.out.println();
			}
			

			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void m6() {
		
		//select > 오류발생
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;


		try {

			conn = DBUtil.open();
			stat = conn.createStatement();
			
			//쿼리에 오타가 남 
			//SQL 오류는 SQL 오류가 뜸.
			//ORA-00904: "NAM": invalid idetifier
			String sql = "select name, buseo, jikwi from tblInsa";
			
			rs = stat.executeQuery(sql); //rs 안만들고 넘어가는 경우 많음 (NullPoint에러 뜸) > 주의하기
			
			
			while(rs.next()) {
				
				//여기서 이름 틀리면 Java 오류
				//java.sql.SQLException:부적합한 열 이름
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("buseo"));
				System.out.println(rs.getString("jikwi"));
				
				
			}
			
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m5() {
		
		//문제 > 완료
		//tblInsa + tblBonus
		//요구사항] 특정 직원에게 보너스를 지급하시오.
		//1. 모든 직원 명단 출력(직원번호, 이름, 부서, 직위) > m4() 참조
		//2. 사용자 > 직원 선택(직원번호 입력) -> 이 사람한테 보너스 지급
		//3. 사용자에게 보너스 금액 입력 요구 
		//4. 입력받은 보너스 지급 > insert tblBonus
		//5. 지급된 내역을 명단으로 출력(직원번호, 이름, 부서, 직위, 보너스 금액) > m4()처럼 select
		
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		Scanner scan = new Scanner(System.in);

		try {

			conn = DBUtil.open();
			stat = conn.createStatement();
			
			//1.
			
			String sql = "select num, name, buseo, jikwi from tblInsa";
			
			rs = stat.executeQuery(sql);
			
			System.out.println("[직원번호]\t[이름]\t[부서]\t[직위]");
			
			while (rs.next()) {
				
				System.out.printf("%s\t%s\t%s\t%s\n"
						, rs.getString("num")
						, rs.getString("name")
						, rs.getString("buseo")
						, rs.getString("jikwi"));
			}
			
			//다쓰면 닫아줘 (이거 추가하고 테스트 안해봄)
			rs.close();
			
			//2. 사용자 > 직원 선택(직원번호 입력) -> 이 사람한테 보너스 지급
			
			System.out.println();
			System.out.print("직원 번호: ");
			String num = scan.nextLine();
			
			
			//3. 사용자에게 보너스 금액 입력 요구 
			
			System.out.print("보너스 금액: ");
			String bonus = scan.nextLine();
			System.out.println("보너스 지급을 완료했습니다.");
			System.out.println();
			
			//4. 입력받은 보너스 지급 > insert tblBonus
			
			//시퀀스 객체 생성
			//String seqsql = "create sequence seqBonus"; 
			
			//int result1 = stat.executeUpdate(seqsql);
			//첫번째 실행때 생성하고 그 다음엔 주석!
			
			
			String sql2 = "insert into tblBonus(seq, num, bonus) values (seqBonus.nextVal, " + num + ", " + bonus + ")";
			int result2 = stat.executeUpdate(sql2);
			
			
			//5. 지급된 내역을 명단으로 출력(직원번호, 이름, 부서, 직위, 보너스 금액) > m4()처럼 select
			
			String sql3 = "select i.num as num, i.name as name, i.buseo as buseo, i.jikwi as jikwi, b.bonus as bonus from tblInsa i inner join tblBonus b on i.num = b.num";
			
			
			rs = stat.executeQuery(sql3);
			
			System.out.println("[직원번호]\t[이름]\t[부서]\t[직위]\t[보너스]");
			
			while (rs.next()) {
				
				System.out.printf("%s\t%s\t%s\t%s\t%,10d원\n"
						, rs.getString("num")
						, rs.getString("name")
						, rs.getString("buseo")
						, rs.getString("jikwi")
						, rs.getInt("bonus"));
			}
			
			
			System.out.println();
			
			rs.close();
			stat.close();
			conn.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void m4() {

		// 다중값 반환
		// - N행 N열
		// - 레코드 N줄 + 컬럼 N개

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;


		try {

			conn = DBUtil.open();
			stat = conn.createStatement();

			String buseo = "영업부";

			String sql =
					"select name, jikwi, city, basicpay from tblInsa where buseo = '" + buseo + "'";

			
			rs = stat.executeQuery(sql);
			
			System.out.println("[이름]\t[직위]\t[지역]\t[급여]");
			
			
			while (rs.next()) {
				
				//직원 1명
				System.out.printf("%s\t%s\t%s\t%,10d원\n"
										, rs.getString("name")
										, rs.getString("jikwi")
										, rs.getString("city")
										, rs.getInt("basicpay"));
				
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void m3() {

		// 다중값 반환
		// - N행 1열
		// - 레코드 N줄 + 컬럼 1개


		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;


		try {

			conn = DBUtil.open();
			stat = conn.createStatement();

			String sql = "select name from tblInsa order by name";

			// 60명
			rs = stat.executeQuery(sql);

			rs.next();
			rs.next();
			rs.next();
			// 이렇게 3번전진시켜놓으면 밑에 while문은 4번째부터 시작 (앞 3개는 안나옴.)

			// 몇 바퀴? > 60바퀴(내 건 59바퀴)
			// 총 몇행인지 매번 알 수 없으니까
			while (rs.next()) {

				System.out.println(rs.getString("name"));

			}

			// 혹은 while문이 다 끝나고
			// System.out.println(rs.getString("name"));
			// 하면 에러 뜸 > "결과 집합을 모두 소모했다."

			// 새로 rs를 초기화하고
			// rs = stat.executeQuery(sql); //현재는 BOF에 있는 상태(젤 처음 시작점) > 이떄 next()안하면 역시 데이터 안나옴.
			// 그다음 next()하고 sop하면 다시 데이터 나옴.
			// 이렇게 다시 읽기가 너무 불편함. 그래서 우리는 편하게 하기 위해 읽어온 작업들을 배열에 담아서 사용했음.
			// 이것 역시 그렇게 사용이 가능함.


			rs.close();
			stat.close();
			conn.close();


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void m2() {

		// 다중값 반환
		// -1행 N열
		// - 레코드 1줄 + 여러개 컬럼

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;


		try {

			conn = DBUtil.open();
			stat = conn.createStatement();

			String sql = "select name, age, tel, address from tblAddress where seq = 3";

			rs = stat.executeQuery(sql);

			// boolean값 반환함 (rs.next() > 커서를 시작점에서 다음 칸으로 한칸 전진)
			if (rs.next()) { // 커서가 한 행에서 멈춰있으니까 그 행에 있는 데이터 모두를 가져올수 있음.

				System.out.println("이름: " + rs.getString("name"));
				System.out.println("나이: " + rs.getString("age"));
				System.out.println("전화: " + rs.getString("tel"));
				System.out.println("주소: " + rs.getString("address"));


			} else {
				System.out.println("데이터가 없습니다.");
			}

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	private static void m1() {

		// 단일값 반환
		// - 1행 1열


		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {

			conn = DBUtil.open();
			stat = conn.createStatement();

			String sql = "select count(*) as cnt from tblInsa";
			// 엘리야스 붙이는 습관들이자 ** (밑처럼 컬럼명 가져올 경우가 있는데, 컬럼명이 길어지는 경우도 많으니까)

			// 반환값X 쿼리 -> executeUpdate()
			// 반환값O 쿼리 -> executeQuery()
			// > 이걸 조심해야하는게 서로 바뀌어도 에러가 안남.

			rs = stat.executeQuery(sql);

			// ResultSet == 커서(Cursor > select 결과로 나온 레코드를 참조하면서 하나하나 탐색함.)
			// >> 판독기 > 스트림, Iterator, 향상된 for
			// == 테이블을 참조해서 탐색할 수 있는 도구.

			rs.next(); // 커서를 1줄 전진 > 레코드 위치 이동 ==has.next()

			// rs.getXXX(); > 현재 커서가 가리키고 있는 레코드의 특정 컬럼값을 가져와라.(원하는 자료형으로)

			int cnt1 = rs.getInt(1); // 컬럼 순서(Index) > 오라클은 1부터 인덱스 시작이니까 그게 적용된 것.
			int cnt2 = rs.getInt("cnt"); // String으로 오버로딩된건 "컬럼명"을 요청함.*****
			String cnt3 = rs.getString("cnt");
			// 이처럼 가져올때 int로 가져올수도, String으로 가져올수도 있음.
			// (물론 형태는 어느정도 동일해야해 varchar2를 int로 가져올순x)

			System.out.println(cnt1);
			System.out.println(cnt2);
			System.out.println(cnt3);

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("Ex04_select.m1");
			e.printStackTrace();
		}



	}



}


