package com.test.java.mvc; //05.11 ****닫기 언제하는지 선생님 코드 확인

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylibrary.db.DBUtil;


//JDBC 코드 담당 > DB 업무 담당
public class DAO {
	
	
	private Connection conn = null;
	private Statement stat = null;
	private PreparedStatement pstat = null;
	//둘중 동적을 쓸지 정적을 쓸지 지금은 모르니 둘다 만듦
	private ResultSet rs = null;
	//얘도 일단 미리 생성
	
	//닫기 언제하는지 선생님 코드 확인 *****
	
	public DAO() {
		

		conn = DBUtil.open();
		
	}
	
	public int add(Address dto) {
		
		//데이터 insert
		
		//먼저 데이터베이스 연결부터
		//이거 위에 private 으로 뺌
		
		
		
		try {
			
			//conn = DBUtil.open() > 이거 생성자로 뺌
			
			String sql = "insert into tblAddress (seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, ?, ?, ?, ?, ?, default)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getAge());
			pstat.setString(3, dto.getGender());
			pstat.setString(4, dto.getTel());
			pstat.setString(5, dto.getAddress());
			
			int result= pstat.executeUpdate();
			
			return result; //1. 성공, 0. 실패
			
			
			
		} catch (Exception e) {
			System.out.println("DAO.add");
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public ArrayList<Address> list() {
		
		
		try {
			
			//목록 가져오기 (select)
			String sql = "select * from tblAddress order by seq asc";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			//ResultSet -> (복사) -> ArrayList<Address>
			ArrayList<Address> list = new ArrayList<Address>();
			
			while (rs.next()) {
				
				//레코드 1개 > Address 1개
				Address dto = new Address();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
				
				//select의 결과가 arraylist에 들어감
			}
			
			
			return list; //select의 결과를 Service에게 반환. (그 리스트를 돌려줌)
			
		} catch (Exception e) {
			System.out.println("DAO.list");
			e.printStackTrace();
		}
		
		
		return null;
	}

	public Address get(String seq) {

		
		try {
			
			//레코드 한줄 가져오기
			String sql = "select * from tblAddress where seq = ?";
			
			//매개변수가 있으면 무조건 prepared 없으면 그냥 statement ***
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				//가져온 레코드 1개를 > Address 1개로 바꿔서 전달
				
				Address dto = new Address();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setRegdate(rs.getString("regdate"));
				
				return dto; //반호나
				
				
			}
			
			
		} catch (Exception e) {
			System.out.println("DAO.get");
			e.printStackTrace();
		}
		
		return null;
	}

	public int edit(Address dto) {

		try {
			
			//모든 컬럼을 업데이트한다. > SQL을 1개만 만들기 위해서!!!!  *** 항상 이렇게 (일부만 수정+업데이트 X)
			// 수정하기 싫은 것도 해야해 > 단 기존값 그대로!
			String sql = "update tblAddress set name = ?, age = ?, gender = ?, tel = ?, address = ? where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getAge());
			pstat.setString(3, dto.getGender());
			pstat.setString(4, dto.getTel());
			pstat.setString(5, dto.getAddress());
			pstat.setString(6, dto.getSeq()); //where절 seq
			
			
			int result= pstat.executeUpdate();
			
			return result; //1. 성공, 0. 실패
			
			
			
		} catch (Exception e) {
			System.out.println("DAO.edit");
			e.printStackTrace();
		}
		
		return 0;
	}

	public int del(String seq) {
		
		
			try {
			
			
			String sql = "delete from tblAddress where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq); //where절 seq (입력받은 seq 그대로, dto x)
			
			int result= pstat.executeUpdate();
			
			return result; //1. 성공, 0. 실패
			
			
			} catch (Exception e) {
				System.out.println("DAO.edit");
				e.printStackTrace();
			}
		
		return 0;
		
			//삭제시 seq도 삭제 되는건.. 그니까 삭제된 seq 자리가 빵꾸나는건 어쩌지 > sql developer에서 수정해야하나?
		
	}

}


//***
//언젠가 꼭 공부해야 해
//디자인 패턴
//- MVC Pattern
//	- Model > Data > Address.java (+ DAO.java > 관대하게 보면 얘도 여기 포함일수도)
//	- View > 출력 > View.java
//	- Controller > 운용 역할. + 제어 > Main, Service 
//>> 웹수업때 좀 더 제대로 수업 할 것

//우리가 지금까지 한게 완벽한 MVC패턴은 아니더라도 거의 유사























