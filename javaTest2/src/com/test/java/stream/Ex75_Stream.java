package com.test.java.stream; //04.12

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import com.test.data.Data;
import com.test.data.User;

public class Ex75_Stream {

	public static void main(String[] args) {
		
		//Ex75_Stream.java
		
		
//		MyUtil util = new MyUtil();
//		System.out.println(util.getNum());
//		
//		System.out.println(Data.getIntList()); //숫자 100개
//		System.out.println(Data.getUserList()); 
		
		/*
		
			자바 스트림
			1. 입출력 스트림
				- 파일 입출력, 콘솔 입출력, 네트워크 입출력 등..
				
			2. 스트림 
				- Java 8(JDK 1.8) + 람다식
				- 배열(컬렉션)의 탐색(조작) 지원 기술
				- 파일 입출력 지원
				- 디렉토리 탐색 지원
				- 이 기술엔 익명객체가 반드시 필요
				- 스트림은 일회용임. (한번 탐색이 끝난 스트림은 재사용할 수 없음) > 또 필요하면 또 생성해야돼 (Iterator와 동일한 성질)
				
		
			배열, 컬렉션 탐색
			1. for문(루프 변수)
			2. 향상된 for문
			3. iterator (Arraylist도 iterator사용가능 -> 메소드가 따로 있음)
			4. 스트림
			
			
			-오늘 수업 내용
			람다식 + 표준 API 함수형 인터페이스 
			- (매개변수) -> {구현부};
			- 익명 객체가 구현한 추상 메소드를 표현하는 표현식
			
			- 인터페이스 참조변수 = (매개변수) -> {구현부}	//정의
			- 참조변수.추상메소드()						//호출(사용)
		
			
			1. Consumer
				- (매개변수) -> {구현부}
				- 리턴값x
			2. Supplier
				- () -> {return 값}
				- 매개변수 x 리턴값 o
				
			3. Function
				- (매개변수) -> {return 값}
				- 둘다 
				- applyxxx()
			
			4. Operator
				- (매개변수) -> {return 값}
				- 얘도 둘다
				- 매개변수와 리턴값이 동일한 자료형.
			
			5. Predicate
				- (매개변수) -> {retunr 값}
				- 얘도 둘다
				- 반환값이 무조건 boolean
		
		*/
		
		//선생님이 미리 만들어 놓은 데이터 활용. (Data메소드) -> MyLibrary 프로젝트도 git 연결하기
		//m1();
		//m2();
		//m3();
		m4();
		
		
	} //main

	private static void m4() {
		
		//스트림을 얻어오는 방법
		//- stream() 메소드를 사용한다.
		//1. 배열로부터
		//2. 컬렉션으로부터 (일부 컬렉션)
		//3. 숫자 범위로부터 
		//4. 파일로부터
		//5. 디렉토리로부터
		
		
		//1. 배열로부터
		int[] nums1 = { 10, 20, 30, 40, 50 };
		
		//배열을 매개변수로 넣어주면 스트림을 뽑아낼 수 있음.
		//nums1.stream() 이랑 같은 것 (이게 바로 안되니까)
		Arrays.stream(nums1).forEach(num -> System.out.println(num));
		System.out.println();
		
		
		//2.컬렉션으로부터
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		nums2.add(100);
		nums2.add(200);
		nums2.add(300);
		
		nums2.stream().forEach(num -> System.out.println(num)); //100 \n 200 \n 300 \n
		System.out.println(); 
		
		LinkedList<Integer> nums3 = new LinkedList<Integer>();
		nums3.add(1000);
		nums3.add(2000);
		nums3.add(3000);
		
		nums3.stream().forEach(num -> System.out.println(num)); //1000 \n 2000 \n 3000
		System.out.println();
		
		
		HashSet<Integer> nums4 = new HashSet<Integer>();
		nums4.add(10000);
		nums4.add(20000);
		nums4.add(30000);
		
		nums4.stream().forEach(num -> System.out.println(num)); //10000 \n 20000 \n 30000
		System.out.println();
		
		
		//위에 애들은 컬렉션에 상속받지만
		//HashMap은 컬렉션과 아무 관련없고 애초에 순서도 없음. -> Stream() 지원x
		//HashMap<String, Integer> nums5 = new HashMap<String, Integer>();
		
		
		//3. 숫자범위로부터
		//Stream<Integer> : 범용 스트림 > forEach > Consumer<Integer>
		//IntStream		  : 전용 스트림 > forEach > IntConsumer
		//완전히 같진 않지만 둘의 목적은 같음.
		
		//TODO 임의로 숫자만들때 생성기 (2022. 4. 12. 오전 11:39:26)
		
		IntStream.range(1, 10).forEach(num -> System.out.println(num)); //1~9
		//range는 임의로 숫자를 만들때 쓰는 생성기 (이게 싫으면 for문) >> 얜 뚜렷한 대체재가 없으니 많이 사용
		System.out.println();
		
		
		
		//외부입출력이라 trycatch로 미리 막아놔
		try {
			//4. 파일로부터
			//- 스트림을 통해서 파일 읽기가 가능
			
			//Path클래스 사용할거야.
			//Path path = Paths.get(경로);
			
			Path path = Paths.get("data\\number.txt");
			
			//Files클래스 -> 매개변수가 path (경로 전부읽고 라인단위로 끊어..?)
			Files.lines(path).forEach(line -> System.out.println(line));
			System.out.println();
			//아직까진 비주류 (BufferedReader를 많이 쓰는듯?)
			//자바에 이미 뚜렷한 대체재가 존재하니까..
			
			
			//5. 디렉로티로부터
			//- 목록보기 > dir.listFiles()
			Path dir = Paths.get("C:\\class\\eclipse");
			
			Files.list(dir).forEach(p -> {
				System.out.println(p.getFileName());
				//p.toFile(); //우리가 원래쓰던 파일객체의 메소드를 사용할 수 있게함.
				System.out.println(p.toFile().getName());
				System.out.println(p.toFile().isFile());
			});
			
			System.out.println();
			
			
			
		} catch (Exception e) {
			System.out.println("Ex75_Stream.m4");
			e.printStackTrace();
		}
		
		
	}

	private static void m3() {
		
		//함수형 프로그래밍 == 의식의 흐름
		Data.getIntList().stream().forEach(num -> System.out.printf("%3d", num)); //100개 숫자 곱게 출력
		System.out.println();
		
		
		//Data.getStringList().stream().forEach(str -> System.out.printf("%s(%d),", str, str.length()));
		
		//이게 좀 더 가독성이 있음. 
		Data
			.getStringList()
			.stream()
			.forEach(str -> System.out.printf("%s(%d),", str, str.length()));
		
		
		
		System.out.println();
		System.out.println();
		
		Data.getUserList().stream().forEach(user -> {
			System.out.println("[회원 정보]");
			System.out.println("이름: " + user.getName());
			System.out.println("나이: " + user.getAge());
			System.out.println("성별: " + (user.getGender() == 1 ? "남자" : "여자"));
			System.out.println();
		});
		
		System.out.println();
		
		
		Data.getItemList().stream().forEach(item -> {
			System.out.println(item.getName());
			System.out.println(item.getColor());
			System.out.println(item.getSize());
			System.out.printf("%tF", item.getDate());
			System.out.println();
			System.out.println();
			
		});
		
		
	}

	private static void m2() {
		
		//배열(컬렉션) 탐색
		List<String> list = Data.getStringList(30);
		
		//1. for문
		for (int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + "   ");
		}
		
		System.out.println();
		System.out.println();
		
		
		//2. 향상된 for문 (HashSet, TreeSet도 향상된 for문같음)
		
		for (String word : list) {				//stream.forEach
			System.out.print(word + "   ");		//c1.accept() 호출 -> 람다식
		}
		
		System.out.println();
		System.out.println();
		
		
		//3. iterator
		Iterator<String> iter = list.iterator(); //iterator
		
		while (iter.hasNext()) {
			System.out.print(iter.next() + "   ");
		}
		System.out.println();
		System.out.println();
		
		
		
		//4. Stream
		
		//foreach -> 향상된 for문 (다른 언어는 우리가 쓰는 향상된 for문을 foreach라고 함. 똑같은 단어임.)
		//stream.forEach(null); //매개변수로 Consumer를 달래. (매개변수o 리턴값x인 인터페이스 -> 매개변수 하나인 그냥 Consumer)
		//얘도 stream을 탐색하는 도구임. 그 stream은 배열에서 나옴. (ArrayList에서 가져옴.)	-> list를 탐색하겠다.
		
		Stream<String> stream = list.stream(); //list에서 stream을 얻어냄.
		Consumer<String> c1 = (str) -> { System.out.println(str); };
								// c1.accept(); (Consumer가 가지고 있는 메소드)
		
		//forEach 메소드의 행동
		//1. stream을 얻어낸 데이터 소스(ArrayList)로부터 요소를 하나씩 가져옴. > 마치 향상된 for문처럼
		//2. 가져온 요소(데이터)를 Consumer의 매개변수로 전달해서 람다식(추상메소드)을 호출함.
		
		stream.forEach(c1);	  //30회전   //매개변수로 Consumer 달라니까 c1 넣어줌. -> list 내용 출력됨.
		//stream.forEach(c1); //0회전
		
		
		//가져온 단어를 컨슈머의 매개변수로 넣어주면서 accept메소드를 호출함. (그 메소드의 매개변수도 가져온 단어로)
		//1. 첫 요소인 "애플아케이드"를 -> c1.accept("애플아케이드"); accept메소드를 호출하여 매개변수로.
		//2. 다음 요소인 "국내"를 -> c1.accept("국내");
		//... x 30번
		
		
		//Stream<String> stream2 = list.stream();
		
		//stream2.forEach((str) -> { System.out.println(str); });
		//stream2.forEach(str -> System.out.println(str)); //줄일수있으면 줄이는게 좋아.
		
		//함수형 프로그래밍 > 메소드 체인닝 > 문장이 길다.(****)
		list.stream().forEach(str -> System.out.println(str)); //최종 (참조변수도 굳이 따로 안만들어돼) //30회전
		// 처음부터 다시 읽고 싶으면 stream을 새로 만들어야해 -> 한번 탐색을 끝낸 stream은 재사용 X
		
		list.stream().forEach(str -> System.out.println(str)); //30회전
		
		
	}

	private static void m1() {
		
		//데이터 집합이 필요. (아까 다운받은 선생님 Data 메소드)
		
		int[] nums1 = Data.getIntArray();
		System.out.println(nums1.length); //100개짜리
		
		int[] nums2 = Data.getIntArray(10); //원하는 개수만큼 가져올 수 있도록 오버로딩 설정되어있음.
		System.out.println(nums2.length); //10
		
		
		//위는 순수배열 아래는 ArrayList
		List<Integer> nums3 = Data.getIntList();
		System.out.println(nums3.size());	//100
		
		List<Integer> nums4 = Data.getIntList(5); //얘도 사이즈 지정 가능하게 오버로딩
		System.out.println(nums4.size());	//5
		
		
		
		//문자열 다량으로 필요할때
		
		String[] txt1 = Data.getStringArray();	//얘도 개수 지정 가능
		System.out.println(Arrays.toString(txt1)); //덤프해서 내용확인
		System.out.println(txt1.length); //287개
		
		
		User[] list = Data.getUserArray(3); //
		System.out.println(Arrays.toString(list)); //배열이라 자동 덤프안되니까 Arrays.toString해줘야해
		
		
		
	}
	

	
}//Ex75




























