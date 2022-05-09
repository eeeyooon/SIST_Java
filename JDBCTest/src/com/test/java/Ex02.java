package com.test.java; //05.09

import java.sql.Connection;

public class Ex02 {
	
	public static void main(String[] args) {
		
		//Ex02.java
		
		
		try {
			
			//hr전용
			Connection conn = DBUtil.open();
			
			System.out.println(conn.isClosed() ? "연결안됨" : "연결됨");
			
			//conn.close();
			//이것도 되는데 형식 맞춰주려고 DBUtil로 open했으면 DBUtil로 close하면 더 좋음.
			
			DBUtil.close();
			/*
			[오류]
			1. 서버 주소가 틀렸을때
			 - IO 오류: The Network Adapter could not establish the connection
			
			2. 아이디 틀렸을때 or 암호 틀렸을때
			 - : ORA-01017: invalid username/password; logon denied
			
			3. 서버 중지
			 - Listener refused the connection with the following error:
			
			4. 연결 문자열 오타
			 - 부적절한 Oracle URL이 지정되었습니다.
			
			5. 포트번호 틀렸을때
			- IO 오류: The Network Adapter could not establish the connection
			- 1번이랑 동일 (이래서 헷갈림 ㅜ)
			
			6. SID X
			 - Listener refused the connection with the following error:
			 - ORA-12505, TNS:listener does not currently know of SID given in connect descriptor
			
			7. 드라이버 이름 틀렸을때
			 - Oracle.jdbc.driver.OracleDridver ('d'오타 들어간것)
			
			8. ojdbc5.jar 안가져왔을때 (라이브러리 참조를 x) > 가장 먼저 해야하는 행동인데
			- oracle.jdbc.driver.OrcaleDeriver (오타가 없는데도 7번이랑 똑같이 오류)
			
			
			
			
			-서비스 중지할때
			(services.msc
			OracleServicesXE 중지하면 중지됨.)
			
			(ip주소 : 127.0.0.10 -> 이걸 서버자리에 쓰면 연결됨.)
			
			
			*/
			
			//오버로딩한 클래스 사용
			conn = DBUtil.open("localhost", "hr", "java1234");
			
			System.out.println(conn.isClosed() ? "연결안됨" : "연결됨");
			
			DBUtil.close();
			
			
		} catch (Exception e) {
			System.out.println("Ex02.main");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}
}









