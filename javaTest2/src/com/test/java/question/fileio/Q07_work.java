package com.test.java.question.fileio; //04.05과제 (완료)

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;


public class Q07_work {

	public static void main(String[] args) {
		//Q07. 직원들의 지각과 조퇴를 카운트하시오.
		//조건
		//-출근 : 오전 9시
		//-퇴근 : 오후 6시
		//비교 연산자를 사용하여 시간이 9보다 크면 지각/ 18보다 작으면 조퇴
		//날짜,이름,출근시간,퇴근시간
		//1. 이름Set생성 후 이름 저장 (중복없이)
		//2. 이름 set을 Itertor에 담아서 루프 돌리기
		//3. 직원 이름이 있으면 그 직원의 출근 시간, 퇴근 시간 따로 변수 만들어 저장
		//4. 비교 연산자로 조퇴와 지각 구하고 각각 count
		//5. StringBuilder로 출력
	
		
		try {
			
			File file = new File("C:\\class\\파일_입출력_문제\\출결.dat");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			HashSet<String> nameSet = new HashSet<String>(); //이름Set (중복X)
			StringBuilder sb = new StringBuilder(); //출력
			
			
			int late = 0;		//지각 횟수
			int early = 0;		//조퇴 횟수

			
			String line = null;
			while ((line = reader.readLine()) != null ) {
					nameSet.add(line.split(",")[1]);	//[1] = 이름 
				
			}
			
			//루프 돌리기 위해
			Iterator<String> iterator = nameSet.iterator(); //nameSet타입을 iterator로 저장
			
			while(iterator.hasNext()) {	//이후에 이름이 있는지 체크, 직원 이름이 있으면 루프(true)
				String name = iterator.next(); //그 이름을 반환
				
				//직원이 있을때마다 열어줘야 함
				reader = new BufferedReader(new FileReader(file)); 
				
				while((line = reader.readLine()) != null) {
					if (line.contains(name)) {	
						//이름이 포함되어있으면
						
						String[] come = line.split(",")[2].split(":");	 //출근시간 (시/분) [0][1]
						String[] leave = line.split(",")[3].split(":");  //퇴근시간 (시/분)
						
						//String comeHour = come[0];
						//String leaveHour = leave[0];
						
						int comeTime = Integer.parseInt(come[0]);	//출근 시 (hour) 
						int leaveTime = Integer.parseInt(leave[0]); //퇴근 시 (hour)
						
						
						
						if (comeTime >= 9) { 	//출근 시가 9시 이상이면 지각
							late++; 			//지각 카운트
						}
						
						if (leaveTime < 18) { 	//퇴근 시가 18시 이하면 조퇴
							early++;			//조퇴 카운트
						}
						
					}
				}
				
				sb.append(String.format("%s  %3d회  %3d회\n", name, late, early));
				
			}
			
			reader.close(); //닫기
			System.out.println("[이름]  [지각] [조퇴]");
			System.out.println(sb);
			
			
		} catch (Exception e) {
			System.out.println("Q07_work.main");
			e.printStackTrace();
		}

		
		
	}//main
}//Q07



















