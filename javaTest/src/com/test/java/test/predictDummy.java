package com.test.java.test; //04.13

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class predictDummy {

	public static void main(String[] args) {
		
		//승부예측
		//seq●아이디●경기일정seq●팀이름●예측성공여부(1-성공 2-실패)
		
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("src\\com\\test\\java\\student\\data\\회원 데이터.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("src\\com\\test\\java\\student\\data\\승부예측.txt"));
			
			ArrayList<String> idList = new ArrayList<String>();
			//회원 데이터.txt에서 아이디 목록만 빼와서 아이디 리스트를 만들고 이중에서 랜덤으로 출력
			
			String line = null;
			
			
			while((line = reader.readLine()) != null) {	
				
				String [] temp = line.split("●");
						idList.add(temp[4]);
			}
			
				
			for (int i=0; i<20; i++) {
					int count = 1;
					count += i;	//seq
					
					String id = idList.get((int)(Math.random() * 100 + 1)); //id
			
					int gameSeq = (int)(Math.random() * 45 + 1); //경기일정번호
					int sorf = (int)(Math.random() * 2 + 1); //성공여부 (success or fail)
					reader.close(); //reader닫기
					
					
					BufferedReader reader2 = new BufferedReader(new FileReader("src\\com\\test\\java\\student\\data\\팀 목록.txt"));
					
					//[3]이 팀이름
					
					ArrayList<String> teamList = new ArrayList<String>();
					//회원 데이터.txt에서 아이디 목록만 빼와서 아이디 리스트를 만들고 이중에서 랜덤으로 출력
					
					String line2 = null;
					
					
					while((line2 = reader2.readLine()) != null) {	
						
						String [] temp2 = line2.split("●");
								teamList.add(temp2[3]);
					}
					
					
							String team = teamList.get((int)(Math.random() * 10 + 1));
					
							reader2.close(); //reader닫기		
							
							//seq●아이디●경기일정seq●팀이름●예측성공여부(1-성공 2-실패)	
					writer.write(String.format("%d●%s●%d●%s●%d\n", count, id, gameSeq, team, sorf ));
					
				}
			
					writer.close();
					System.out.println("생성 완료");
			
		} catch (Exception e) {
			System.out.println("predictDummy.main");
			e.printStackTrace();
		}
		
		
	} //main
}// 




