package com.test.java; //05.10

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;
import oracle.jdbc.OracleTypes;

public class Ex06_CallableStatement {

	public static void main(String[] args) {
		
		
		//JDBC는 기본적으로 모든 SQL의 실행은 자동 커밋이 수반된다. > executeXXX 수반된다.
		
		
		//Ex06_CallableStatement.java
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		m6();
	}

	private static void m6() {
	
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			//요구사항] 부서명 입력 > 부서의 직원의 보너스 지급 내역 출력
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("부서명: ");
			String buseo = scan.nextLine();
			
			
			String sql = "{ call procM6(?,?) }";
			
			stat = conn.prepareCall(sql);
			
			stat.setString(1, buseo);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(2);
			
			
			System.out.println("== 보너스 지급 내역 ==");
			System.out.println("[직원명]\t[지급액]");
			
			while (rs.next()) {
				System.out.printf("%s\t%,10d원\n"
										, rs.getString("name")
										, rs.getInt("bonus"));
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.temp");
			e.printStackTrace();
		}
		
		
	}

	private static void m5() {
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call procM5(?, ?) }";
			
			stat = conn.prepareCall(sql);
			
			stat.setString(1, "개발부");
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			//오라클 커서 == 자바 ResultSet > *******
			//커서를 받아올땐? 
			//getObject()로 받아와야해. ResultSet() 아님
			rs = (ResultSet)stat.getObject(2);
			// >> 이걸로 커서를 받아와야해
			
			while (rs.next()) {
				
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("jikwi"));
				System.out.println(rs.getString("basicpay"));
				System.out.println();
				
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.temp");
			e.printStackTrace();
		}
		
		
		
	}

	private static void m4() {
		
		//문제] 직원번호를 입력하면 그 직원의 이름, 부서, 직위, 지역을 반환 + 출력
		//- 직접 프로시저부터 만들어라. = procM4
		//- in > 직원 번호
		//- out > 이름
		//- out > 부서
		//- out > 직위
		//- out > 지역
		//직원 번호는 Scanner로 받아
		
		Scanner scan = new Scanner(System.in);
		
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call procM4(?, ?, ?, ?, ?) }";
			
			stat = conn.prepareCall(sql); //statement를 만들어야 매개변수를 넣을 수 있음.
			
			stat.setString(1, "1001"); //in
			
			//out 4개
			stat.registerOutParameter(2, OracleTypes.VARCHAR);
			stat.registerOutParameter(3, OracleTypes.VARCHAR);
			stat.registerOutParameter(4, OracleTypes.VARCHAR);
			stat.registerOutParameter(5, OracleTypes.VARCHAR);
			
			stat.executeQuery();
			
			//여긴 컬럼을 가져온게 아니라 파라미터를 가져온것. 그러니까 이름이 아니라 인덱스만 가져올 수 있음.
			System.out.println("이름: " + stat.getString(2));
			System.out.println("부서: " + stat.getString(3));
			System.out.println("직위: " + stat.getString(4));
			System.out.println("지역: " + stat.getString(5));
			
			
			stat.close();
			conn.close();
			
			//스캐너 깜빡 > 나중에 한번 해보자 스캐너로 수정
			
			
			
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.temp");
			e.printStackTrace();
		}
		
	}

	private static void m3() {
		
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			//이번엔 OUT 파라미터
			
			String sql = "{ call procM3(?) }";
			
			stat = conn.prepareCall(sql);
			
			//in 매개변수
			//stat.setString(1,값)
			
			//out 매개변수
			stat.registerOutParameter(1, OracleTypes.NUMBER); //이건 오라클 자료형 잘확인해야해!
			
			
			//PL/SQL 문에서 인출을 수행할 수 없습니다 : next
			//rs = stat.executeQuery();
			//System.out.println(rs.next)); > 사용 못함
			
			stat.executeQuery(); //rs(X)!!
			
			int count = stat.getInt(1); //Out Parameter 가져오는 역할
			
			System.out.println(count);
			
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.temp");
			e.printStackTrace();
		}
		
	}

	private static void m2() {

		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			
			//begin
	        //procM2('이름', 20, 'm', '010-1111-1111', '주소');
	        //end;
			//매개변수가 있는 프로시저 호출
			String sql = "{ call procM2(?, ?, ?, ?, ?) }"; //2,
			
			//String sql = "{ call procM2('상수', 22, 'm', '010-1111-1111', '주소') }"; //1.
			//물음표 말고 상수도 가능
			
			stat = conn.prepareCall(sql);
			
			//1.
			//물음표가 없으니까 데이터 전달할 필요 X, 반환값도 X
			// > 바로 호출
			
			
			//2.
			stat.setString(1, "홍길동");
			stat.setString(2, "25");
			stat.setString(3, "m");
			stat.setString(4, "010-1234-5421");
			stat.setString(5, "서울시");
			
			
			int result = stat.executeUpdate();
			
			System.out.println(result);
			
			stat.close();
			conn.close();
			
			
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.temp");
			e.printStackTrace();
		}
		
	}

	private static void m1() {
		
		//Statement > 정적 쿼리
		//PreparedStatement > 동적 쿼리
		//CallableStatement > 프로시저 호출
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call procM1 }";
			
			stat = conn.prepareCall(sql);// 매개변수 처리 능력 보유 > ? 지원
			
			int result = stat.executeUpdate();
			
			System.out.println(result);
			
			stat.close();
			conn.close();
			
			
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.temp");
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	private static void temp() {
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.temp");
			e.printStackTrace();
		}
		
	}
}
