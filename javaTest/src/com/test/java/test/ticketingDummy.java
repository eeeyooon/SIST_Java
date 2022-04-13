package com.test.java.test; //04.13

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class ticketingDummy {

	public static void main(String[] args) {
		
		
		
		try {
			
		
		BufferedReader reader = new BufferedReader(new FileReader("src\\com\\test\\java\\student\\data\\회원 데이터.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("src\\com\\test\\java\\student\\data\\예매내역.txt"));
		
		

		ArrayList<String> idList = new ArrayList<String>();
		//회원 데이터.txt에서 아이디 목록만 빼와서 아이디 리스트를 만들고 이중에서 랜덤으로 출력
		
		String line = null;
		
		
		while((line = reader.readLine()) != null) {	
			
			String [] temp = line.split("●");
					idList.add(temp[4]);
		}
		
			
		for (int i=0; i<20; i++) {
				int count = 1;
				count += i;
				String id = idList.get((int)(Math.random() * 100 + 1));
				
				
				//구역(ABCD) -> 랜덤
				//경기일정번호 -> 1~45까지 랜덤
				//경기 좌석 번호 -> 1~10까지 랜덤
				
				Random r = new Random();
				String[] blockList = { "A", "B", "C", "D" };
				String[] seatList = {"A", "B", "C", "D", "E", "F", "G", "H"};
				int seatNum = (int)(Math.random() * 10 + 1);
				int gameSeq = (int)(Math.random() * 45 + 1);
				
				
				int bn = (int)(Math.random() * blockList.length); //난수받고
				r.setBlock(blockList[bn]); //그 난수가 가리키는 구역리스트의 구역
	
				
				int sn = (int)(Math.random() * seatList.length);
				r.setSeat(seatList[sn]);
				
				reader.close(); //reader닫기
				
				
				writer.write(String.format("%d●%s●%d●%s구역●%s%d\n", count, id , gameSeq, r.getBlock(), r.getSeat(), seatNum));
		
			}
			writer.close(); //writer닫기
			
		
			System.out.println("생성 완료");
			
			
		} catch (Exception e) {
			System.out.println("ticketingDummy.main");
			e.printStackTrace();
		}
		
		
		
		
	}//main
	
}//class


class Random {
	
	private String block;
	
	private String seat;
	
	
	public String getBlock() {
		return block;
	}

	public int nextInt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	
	
	
	
}




