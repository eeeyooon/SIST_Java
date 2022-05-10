package com.test.java; //05.10

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex05_PreparedStatement {

	public static void main(String[] args) {
		
		//Ex05_PreparedStatement.java
		
		//m1();
		m2();
		
		
	}//main

	private static void m2() {

		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			//정적 쿼리
			String sql = "select name from tblInsa where num = 1001";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			rs.close();
			stat.close();
			
			
			//동적 쿼리
			sql = "select name from tblInsa where num = ?";
			
			pstat = conn.prepareStatement(sql);
			
			//java.sql.SQLException : 인덱스에서 누락된 IN 또는 OUT 매개변수:: 1 > ?로만 두면 에러뜸 (setString 안하면)
			//pstat.setString(1, "1001");
			pstat.setInt(1, 1001);
			
			//둘중에 뭐든 상관X > 내부적으로 알아서 처리해줌
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			rs.close();
			pstat.close();
			
			
			//인자없는 쿼리 > pstat
			//이처럼 정적쿼리를 pstatement로 날리기도 하지만 > 약간 혼란줄수도..
			
			sql = "select count(*) as cnt from tblInsa";
			
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			rs.close();
			pstat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex05_PreparedStatement.m1");
			e.printStackTrace();
		}
		
	}

	private static void m1() {
		
		//Statement vs PreparedStatement
		//- SQL 실행
		//- 매개변수 처리 지원 유무
		//- Statement > 정적 SQL
		//- PreparedStatement > 동적 쿼리
		
		//insert > 사용자 입력
		String name = "하하하";
		String age = "20";
		String gender = "m";
		String tel = "010-1111-2222";
		String address = "서울시 동대문구 이문동";
		
		//SQL escape는 <'> (홑따옴표)임.
		//address 안에 홑따옴표를 넣고 싶으면 ex.이문'동
		//address = address.replace("'", "''");
		//근데 이것도 statement랑 preparedStatement의 경우가 다름.
		//statement는 문자열 안에 홑따옴표가 있으면 에러가 나지만, preparedStatement는 에러도 안나고 홑따옴표가 그대로 잘들어감.
		//PreparedStatement는 자동으로 이스케이프를 시켜줌.
		//아무변화없는 쿼리를 쓸땐 statement를 사용, 변화가 있으면 preparedStatement 사용하는 것이 좋음.
		
		
		
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement(); //A. 실행시 SQL 대입
			
			//Statement
			String sql = String.format("insert into tblAddress (seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, '%s', %s, '%s', '%s', '%s', default)", name, age, gender, tel, address);
			
			int result = stat.executeUpdate(sql);
			
			System.out.println(result);
			
			
			//PreparedStatement
			//- ?: 오라클 매개변수
			//- SQL 작성이 용이하다. > String.format() 유사
			//- 매개변수값으로 부적절한 값이 있어도 자동으로 이스케이프를 시켜준다. (**********)
			sql = "insert into tblAddress (seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, ?, ?, ?, ?, ?, default)";
			
			pstat = conn.prepareStatement(sql); //B. 실행전 미리 SQL 대입
			
			pstat.setString(1, name); //1번째 물음표에 name을 넣어라 (like %s)
			pstat.setString(2, age);
			pstat.setString(3, gender);
			pstat.setString(4, tel);
			pstat.setString(5, address);
			
			result = pstat.executeUpdate(); //B.
			
			System.out.println(result);
			
			
			stat.close();
			pstat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex05_PreparedStatement.m1");
			e.printStackTrace();
		}
		
		
	}
	
	
}


















