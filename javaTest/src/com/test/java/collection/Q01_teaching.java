package com.test.java.collection; //03.31

import java.util.ArrayList;

public class Q01_teaching {

	public static void main(String[] args) {
		
		
		
		MyArrayList_teaching list = new MyArrayList_teaching();
		
		list.add("바나나");
		list.add("사과");
		list.add("포도");
		list.add("딸기");
		//list.add("귤");
		
		System.out.println(list);
		
		list.add("귤");
		
//		System.out.println(list);
//		
//		list.add("복숭아");
//		list.add("앵두");
//		list.add("배");
		
		System.out.println(list);
		
		//System.out.println(list.get(6)); //과일이 5개뿐인데 6번을 하면 에러가 아닌 null값이 나옴 -> 실제 어레이리스트와 다름.
										   //그래서 에러메세지 뜨게 설정
	
		System.out.println(list.size());
		
		//list.set(1, "딸기");
		//System.out.println(list); // O
		
		//list.set(6, "복숭아");
		//System.out.println(list); //6번방에 있는 null이 '복숭아'로 바뀜. -> 실제 어레이리스트는 에러가 나야 함. (설정 따로해! 아직x)
	
		
		list.remove(2);
		System.out.println(list);	//삭제는 되지만 index의 값은 그대로임. 
		
		list.add("망고");
		System.out.println(list); 	//중간에 null이 생김 (4번 null 5번 망고) >> 그래서 this.index--해줘야해. (이젠 함. 고쳐짐)
		
		list.add(2, "참외");
		list.add(2, "앵두");
		list.add(2, "토마토");
		list.add(2, "파파야"); //따로 방을 안늘려주면 파파야가 추가되면서 망고가 삭제됨.
		
		
		System.out.println(list);
	
		
		System.out.println(list.indexOf("딸기"));
		System.out.println(list.lastIndexOf("참외"));
		
		//list.clear();	//모두 지웠다 생각, 
		//System.out.println(list);	//리스트엔 데이터가 남아있는데?
		
		//System.out.println("과일의 개수: " + list.size()); //근데 0 나옴 ㅎㅎ
		
		//>>데이터가 실제로 들어가있는것과는 별개로 우리는 업무의 모든 초점이 인덱스를 중심으로 일어남. 그래서 인덱스가 0이 되는 순간,
		//	우리는 다음번에 데이터를 넣을 때 인덱스 방부터 (0부터) 넣음. -> 기존 데이터들은 garbage 취급해버림.

		
		//System.out.println(list);
		//list.trimToSize();
	//	System.out.println(list); //trimToSize도 확인할수있게 dump를 해놓는게 좋음. (dump해놔야 그때 그때 확인이 편함.)
		
		
	}//main
	
}//Q01



































