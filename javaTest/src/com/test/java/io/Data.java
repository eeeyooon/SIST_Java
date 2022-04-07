package com.test.java.io;


//모든 데이터 파일의 경로를 저장하는 클래스로 사용할 것.
public class Data {

	//무조건 상수 static 변수로 선언
	final public static String EDIT = "data\\data.txt";
	final public static String MEMBER = "data\\member.txt";
	
	
	//=> 다른 클래스에서 Data.EDIT으로 불러올 수 있음 => 에러날 확률 극히 적음.
	// 이렇게 파일경로 정리하고 그 클래스를 공유하는게 좋음. (팀작업시)
}
