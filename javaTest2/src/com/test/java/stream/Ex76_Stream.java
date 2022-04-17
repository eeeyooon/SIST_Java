package com.test.java.stream;	//04.13 //m4부터 04.14 //m6부터 04.15

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import com.test.data.Data;
import com.test.data.User;

public class Ex76_Stream {

	public static void main(String[] args) {
		//Ex76_Stream.java
		
		/*
			
			스트림, Stream
			- 데이터 소스로부터 탐색/조작 가능한 도구
			- list.stream().forEach()
			
			
			파이프, pipe
			- 스트림에다가 점 찍고 나오는 모든 메소드를 가리킴. 
			- >> 스트림 객체 메소드
			1. 중간 파이프
				- 반환값이 스트림
				
			2. 최종 파이프
				- 반환값이 스트림이 아닌 모든 것. > 리턴값이 없는 것도 있고, 다른 자료형 반환도 있고.. 여러가지있음
				(출력을 하든, 아무튼 최종 형태의 행동을 함.)
			
			필터링
			- filter()
			- 중간처리 파이프
			- 앞의 스트림에서 조건에 맞는 요소만 남기고 맞지 않는 요소는 버린다. 
				> 조건에 맞는 요소만 남아있는 스트림을 반환함. (중간파이프는 새로운 스트림을 반환함)
				
			
			
			처리
			- forEach()
			- 최종 처리 파이프 (like 수도꼭지)
			- 앞의 스트림의 요소를 최종 처리하는 메소드
			
				
			//04.14 정리
			
			스트림 > 최근 JavaScript에서도 유사한 기능 제공함.
			 
			 
		
		*/
		
		//m1();
		//m2();
		//m3();
		//m4(); //04.14
		//m5(); //실수로 하나 더 만듦 (선생님은 m4()안에 다 넣음)
		//m6();	//04.15
		//m7();
		//m8();
		//m9();
		//m10();
		m11();
		
		
	}//main

	
	
	private static void m11() {
		
		List<Integer> list = Data.getIntList(10);
		
		System.out.println(list);
		list.stream()						//숫자 10개
				.filter(n -> n >= 50)		// 숫자 1개만 뽑아서 필터에 넣고, 
											//그걸 바로 peek에 , filter1,foreach까지 가고나서야 다음 숫자로
				//.forEach(n -> System.out.println(n)) //-> 얜 최종 파이프라서 중간에 확인하고 싶으면 밑에 주석 달아야돼
				.peek(n -> System.out.println("@" + n)) //위 상황 때 쓰는게 바로 peek (리턴타입 - 스트림)
				.filter(n -> n % 2 == 1) //여기서 막히면 @없이 안나옴.
				.forEach(n -> System.out.println(n));
		
		/*
		
		@86
		@65
		65
		@85
		85
		@86

		*/
		
		
	}



	private static void m10() {
		
		//avg, sum
		
		List<Integer> list = Data.getIntList();
		
		//총합
		System.out.println(list.stream().mapToInt(n -> n).sum()); //mapToInt를 써야 sum 쓸 수 있나?
		//stream() > Stream<Integer> 제네릭을 반환
		//mapToInt(n -> n) > 준걸 그대로 리턴. 근데 mapToInt는 제네릭이 아닌 int 스트림을 반환해줌.
		//sum은 제네릭이 아닌 전용타입 숫자 스트림에만 사용가능. (mapToDouble, maptToInt이런거 써서 숫자로 반환해줘야해)
		//4746
		
		System.out.println(list.stream().mapToInt(n -> n).average().getAsDouble()); //얘도 숫자로 받아야함.
		// >> 얜 Optional로 반환. sum은 아무것도 없으면 0을 반환하는데, 평균은 아무것도 없으면 안나오니까.
		// Optional이 보기싫으면 get.. - 전용메소드, getAsDouble.. -범용메소드 사용하면 숫자만 나옴.
		//47.46
		
		System.out.println(Data.getUserList().stream()
						.filter(u -> u.getGender() == 1) //남자만 보고싶을때 filter
						.mapToInt(u -> u.getHeight())
						.average().getAsDouble()); 
		//174.57142857142858
		
	}



	private static void m9() {

		// max, min
		
		List<Integer> list = Data.getIntList();
		
		//최댓값? 최솟값?
		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
		
		System.out.println(list.stream().max((a,b) -> a - b)); //max와 min은 Comparator 요구
		//Optional[99]
		System.out.println(list.stream().min((a,b) -> a - b));
		//Optional[0]
		
		//근데 갑자기 클리어시켜버리면?
		//list.clear(); //100->0
		
		Optional<Integer> result = list.stream().max((a,b) -> a-b);
		System.out.println("최댓값: " + result);
		//값이 clear되면 >> // 최댓값: Optional.empty (값이 없는게 반환됨.) = 값이 존재하지 않는다.
		
		
		if (result.isPresent()) {
			//값이 있는지 먼저 확인
			System.out.println("최댓값 : " + result.get()); //이걸 쓰면 원래쓰던 int로 형변환해줘
			//최댓값 : 99
		} else {
			System.out.println("빈배열");
			//clear했으면 빈배열이 뜨게
		}
		
		System.out.println();
		
		//Optional? 
		//- 값형이 null을 가질 수 없는 특성을 보완하기 위해 만들어진 자료형
		
		//지역 변수
		//- 값형 + 참조형 > 초기화를 하지 않으면 사용 불가능!!
		
		//멤버 변수
		//- 생성자가 무조건 초기화를 해버림. >
		
		
		//값형 : null을 가질 수 없다. > 의도적으로 공간을 비울 수 없음.
								// > 0, 0.0, false...
		
		//참조형 : null을 가질 수 있다.
		
		
		//D (맨밑 새로운 클래스 Test)
		
		Test t = new Test();
		System.out.println(t.a); //0
		System.out.println(t.b); //false
		//>>값형은 반드시 값이 O. null X
		
		System.out.println(t.c); //null
		System.out.println(t.d); //null
		
		//E 메소드 만들어보자
		
		User temp = getUser();
		//int n = getNum();
		
		//Optional<T> : 값형이 null을 가질 수 없는 특성을 보완하기 위해 만들어진 자료형
		
		
		//User naxUser = Data.getUserList().stream().max(); //User의 최대, 최소 기준이 뭔지 모름 -> 알려줘야해
		Optional<User> maxUser = Data.getUserList().stream()
											.max((u1, u2) -> u1.getAge() - u2.getAge()); 
		
		System.out.println(maxUser.get()); //29살인 user가 나옴. 
		
	}
	
	//E-2 이번엔 int 반환하는 메소드
//	private static int getNum() {
//		
//		boolean condition = true;
//		
//		if (condition) {
//			return 100;
//		}
//		
//		return null // 돌려주기 싫으면 돌려주기 싫은 표현을.. 참조형엔 null반환하는것처럼.
//				// -> 근데 값형은 안됨..
//		
//	}
	
	//E 간단한 메소드 만들자
	
	private static User getUser() {
		
		//실행하면 User객체 반환하는 메소드
		
		boolean condition = true; //or flase // 조건이 있는데 그게 만족될지 되지않을지 모르는 상태로 가정.
		
		if(condition) {			 // 조건을 만족할때만
			return new User(); 	//User객체를 반환해주는 메소드
		}
		
		//아무것도 돌려주기 싫어도 돌려줘야해 그럴때 null을 반환
		
		return null;
		
		//이게 가능한 이유? User는 참조형이고, 참조형은 null을 가질 수 있기 때문에
		
		
	}



	private static void m8() {
		
		//집계, Reduce
		//- count(), max(), min(), sum(), avg()
		//- 최종처리 파이프
		//- 요소들을 가공해서 축소하는 작업, 통계값
		
		
		System.out.println(Data.getIntList().stream().count()); //100
		System.out.println();
		
		
		//스트림으로 빼볼까?
		//Stream<User> stream = Data.getUserList().stream(); // User스트림
		//error
		
		//System.out.println("총 인원수 : " + stream.count());
		//이 count를 셀때 이미 스트림을 써버려서
		
		//System.out.println("남자수 : " + stream.filter(u -> u.getGender() == 1).count());
		//난 이제 스트림 못써..-> 라고 에러나옴.
		//stream has already been operated upon or closed

		//스트림은 재사용 안된다고 했잖아
		
		
		//Stream으로 빼지말고 다시 리스트로 만들어서 따로따로 스트림 뽑자
		
		List<User> list = Data.getUserList();
		System.out.println("총 인원수 : " + list.stream().count());
		System.out.println("남자수 : " + list.stream().filter(u -> u.getGender() == 1).count());
		System.out.println("여자수 : " + list.stream().filter(u -> u.getGender() == 2).count());
		
		
		System.out.println(Data.getIntList().stream().distinct().count()); //중복제거후 남은 숫자개수는?
		//61
		
		
	}



	private static void m7() {
		
		//매칭
		//- allMatch(), anyMatch(), noneMatch()
		//- 최종처리 파이프
		//- 스트림 요소들이 제시하는 조건을 만족 유무 판단
		// a. boolean allMatch(Predicate) : 모든 요소가 조건을 100% 만족하는지
		// b. boolean anyMatch(Predicate) : 일부 요소가 조건을 만족
		// c. boolean noneMatch(Predicate) : 모든 요소가 조건을 0% 만족? (불만족)
		
		//int[] nums = { 2, 4, 6, 8, 10 };
		//int[] nums = { 1, 3, 5, 7, 9 };
		int[] nums = { 2, 3, 5, 7, 9 };
		
		//요구사항] 배열안에 짝수만 들어있는지?
		
		boolean result = false;
		
		for (int n : nums) {
			if (n % 2 == 1) { //홀수를 먼저
				result = true;
				break;
			}
		}
		
		if (result) {
			System.out.println("홀수 발견!");
		} else {
			System.out.println("짝수만");
		}
		
		//allMatch() > && 연산자
		//1.nums안에 각 요소를 Predicate에 넣어서 검사해라! 
		//2. 모든 요소가 true를 반환 > 자신도 true
		//3. 일부 요소가 false를 반환 > 자신은 false
		//한 놈이라도 false면 false 반환 "allMatch" -> 모든 놈들이 짝수냐 
		
		System.out.println(Arrays.stream(nums).allMatch(n -> n % 2 == 0));
		//지금 검사한 숫자들이 모두 짝수냐
		//>> true
		
		//noneMatch()
		System.out.println(Arrays.stream(nums).noneMatch(n -> n % 2 == 0));
		//모두다 불만족하느냐 (모두다 짝수x, 홀수냐)
		//>> false
		//한놈이라도 만족하면 false
		
		
		//anyMatch() > || 연산자 정립
		//1. nums안에 각 요소를 Predicate에 넣어서 검사해라!!
		//2. 일부 요소가 true를 반환 > 자신도 true
		//3. 모든 요소가 false를 반환 > 자신도 false
		
		//nums = { 2, 4, 6, 8, 10 }; >> true
		//nums = { 1, 3, 5, 7, 9 }; >> false
		//nums = { 2, 3, 5, 7, 9 }; >> true
		System.out.println(Arrays.stream(nums).anyMatch(n -> n%2 == 0));
		
		//여자 > 이상형 > User + 175cm + 65kg > anyMatch
		
		result = Data.getUserList().stream()
					.filter(u -> u.getGender() == 1) 
					.anyMatch(u -> u.getHeight() >= 175 && u.getWeight() >=65); //얜 연달아못써 한번에 써야돼!
							
		if (result) {
			System.out.println("이상형이 있습니다.");
			
			Data.getUserList().stream()
							.filter(u -> u.getGender() == 1)
							.filter(u -> u.getHeight() >= 175)
							.filter(u -> u.getWeight() >= 65)
							.forEach(u -> System.out.println(u));
			
		} else {
			System.out.println("다음 기회에");
	
		}
	}



	private static void m6() {
		
		Data.getUserList().stream()
				.filter(user -> user.getGender() == 1)
				.map(user -> user.getWeight())
				.distinct()	
				.forEach(weight -> System.out.println(weight));
		
		System.out.println();
		
		
		//정렬
		//- sorted()
		//- 중간처리 파이프
		//- 배열, 컬렉션의 sort()와 사용법이 동일
		// a. 단일값 오름차순 > sort()
		// b. 단일값 내림차순 > sort (구현)
		// c. 복합값 오름차순, 내림차순 > sort(구현)
		
		
		List<Integer> nums = Data.getIntList(10);
		System.out.println(nums);
		
		nums.sort((a,b) -> a - b);
		//위 람다식과 밑 메소드는 동급
		nums.sort(Comparator.naturalOrder()); //Comparator 객체 반환 > 오름차순 정렬 객체
		nums.sort(Comparator.reverseOrder()); //내림차순 정렬 객체 (반환)
		//이건 배열의 본래기능(?)
		System.out.println(nums);
		
		//이번엔 스트림
		
		//nums.stream().sorted() > 그냥 오름차순
		//nums.stream().sorted(구현)
		
		//배열에 있는 sort는 원본 배열을 정렬하는거고, 
		//stream().sorted()는 배열을 정리한게 아니라 스트림을 정렬 > 원본 배열에 영향 x
		//*****스트림의 조작은 원본 배열에 영향을 미치지 않는다. >> 소비성 행동
		
		//먼저 오름차순
		nums.stream().sorted().forEach(n -> System.out.println(n));	//중간 파이프니까 자료형은 일치
		
		
		System.out.println(nums); //여전히 위에서 배열 내림차순했던 그대로임.
		
		
		nums.stream().sorted((a,b) -> b - a).forEach(n -> System.out.println(n)); //내림 차순
		
		System.out.println();
		
		Data.getIntList().stream()
							.distinct()
							.filter(n -> n % 2 == 0)
							.sorted()
							.forEach(n -> System.out.println(n));
		
		
	}



	private static void m5() {
		
		//C (클래스 밑에 Student 클래스 생성)
		List<Student> slist = new ArrayList<Student>();
		
		slist.add(new Student("가가가", 100, 90, 80));
		slist.add(new Student("나나나", 77, 88, 66));
		slist.add(new Student("다다다", 92, 82, 84));
		slist.add(new Student("라라라", 100, 92, 88));
		slist.add(new Student("마마마", 56, 47, 35));
		
		slist.stream()
				.map(s -> {
					int total = s.getKor() + s.getEng() + s.getMath();
					if (total >= 180) {
						return s.getName() + " : 합격";
					} else {
						return s.getName() + " : 불합격";
					}
				}) //Stream<Student> -> Stream<String>
				.forEach(result -> System.out.println(result));
		System.out.println();
		
		//>> 이건 이름과 결과가 한번에 나와서 수정하거나 가공이 불편
		
		//C-2. Result class 생성
		
		
		slist.stream()
				.map(s -> {
					int total = s.getKor() + s.getEng() + s.getMath();
					
					Result r = null;
					
					if (total >= 180) {
						r = new Result(s.getName(), "합격");
					} else {
						r = new Result(s.getName(), "불합격");
					} //결과값은 Result Stream이 됨.
					
					return r;
				}).forEach(r -> System.out.printf("%s(%s)\n", r.getName(), r.getResult()));
	
			//>> 이름과 결과를 따로따로 생성 (result 객체로)
	}
	


	private static void m4() {
		//***꼭 복습하기(중요한내용)
		//매핑 (파이프) **
		//- map(), mapXXX()
		//- 중간처리 파이프
		//- 변환 작업에 사용함. (*********)
		//- map() >					앞의 스트림을 처리 후 다른 타입의 스트림을 반환
		//- distinct(), filter() > 	앞의 스트림 처리 후 동일한 타입의 스트림을 반환
		
		
		List<String> list = Data.getStringList(10);
		System.out.println(list);
		
		System.out.println();
		
		list.stream()													//Stream<String>
					.filter(word -> word.length() <= 3)					//Stream<String>
					.forEach(word -> System.out.println(word));
		System.out.println();
		
		
		list.stream()							//Stream<String> : 단어 스트림
					.map(word -> {				//Stream<Integer> : 단어 길이 스트림 (foreach한테 int만 있는 스트림을 넘겨줌)
						return word.length();	
					})
					.forEach(num -> System.out.println(num));
		
		//넘어온 단어를 확인하고 그 단어의 길이(정수값)을 돌려줌. (map은 foreach한테 integer)
		//반환값은 자유
		
		System.out.println();
		
		//생략
		list.stream()
					//.filter(word -> word.length()>=5) //얘가 위에 있어도 결과는 같음. (내용은 다름!)
					.map(word -> word.length())
					.distinct()	//이거 추가하면 -> 중복숫자 생략
					.filter(length -> length >= 5) //이거 추가하면 5이상인 길이(숫자)만
					.forEach(length -> System.out.println(length));
		System.out.println();
		
		String[] names = { "홍길동", "홍재석", "테스트", "아무개", "하하하", "호호호", "후후후", "유재석", "박명수" };
		
		Arrays.stream(names)		//성은 버리고 이름만
					.map(name -> name.substring(1)) //1번째 자리부터 끝까지
					.forEach(name -> System.out.println(name));
		System.out.println();
		
		//매핑 -> A와 B를 연결한다. / 또다른 C로변환한다. (이럴 때 '매핑'이라는 단어가 쓰임)
		
		
		List<User> ulist = Data.getUserList();
		
		//map()이 들어가면 의도가 원본 데이터를 다른 형태로 가공하겠다는 것.
		ulist.stream()
				//.map(user -> user.getName())	//user객체를 받아서 이름만 돌려줌. (문자열) >> 객체 배열을 문자열로 돌려줌.
				//.map(user -> user.getAge())     //user객체를 나이만 돌려줌 (int)
				.map(user -> user.getHeight() >= 180 && user.getWeight() <= 80) //이건 또 조건에 맞으면 true, 아니면 false
				.forEach(user -> System.out.println(user));
		
		System.out.println();
	}



	private static void m3() {
		
		//중복 제거
		//- distinct)
		//- 중간처리 파이프
		//앞의 스트림에서 중복값을 제거하고 > 유일한 요소만 남아있는 스트림을 반환함.
		//- Set의 성질과 유사.
		
		
		System.out.println(Data.getIntList().size()); //중복값이 있는 int 100개
		
		List<Integer> list = Data.getIntList(); //int 100개를 list에 빼놓음.
		
		//요구사항] 위의 배열에서 중복값 제거
		
		//Case1.
		Set<Integer> set = new HashSet<Integer>();
		
		for (int n : list) {
			set.add(n);
		}
		
		//list의 값을 set에 저장
		
		System.out.println(set.size()); //61
		//이게 가장 손쉬운 방법
		
		
		//Case2.
		//- ArrayList -> HashSet으로 복사 (변환의 의미)
		Set<Integer> set2 = new HashSet<Integer>(list);
												//컬렉션 인터페이스로부터 상속받은 모든 애들을 여기 넣을수도 있음.
												//ArrayList, LinkedList, HashSet 이런거
		System.out.println(set2.size()); //61
		
		
		System.out.println();
		
		
		//Case3. Stream (distinct(), count() 사용)
		
		//list.stream().distinct().forEach(n -> System.out.println(n)); -> 중복값 제거된 모든 수 출력
		System.out.println(list.stream().count());
		//count() -> 반환값이 long(스트림x) => 최종 파이프 
		//length()나 size()처럼 개수반환
		
		System.out.println(list.stream().distinct().count()); //61
		
		
		String[] names = { "홍길동", "아무개", "하하하", "홍길동", "호호호", "후후후", "홍길동" };
		//배열은 Arrays.stream(배열이름)으로 stream만들기
		Arrays.stream(names).distinct().forEach(name -> System.out.println(name));
		
		
		
		//B (Ex76클래스 끝나는 곳 밑으로) -> Cup class 생성
		
		
		List<Cup> clist = new ArrayList<Cup>();
		
		clist.add(new Cup(Cup.BLACK,  200));
		clist.add(new Cup(Cup.WHITE,  300)); //1
		clist.add(new Cup(Cup.RED,	  400));
		clist.add(new Cup(Cup.YELLOW, 500));
		clist.add(new Cup(Cup.BLUE,   600)); //2
		clist.add(new Cup(Cup.BLACK,  700));
		clist.add(new Cup(Cup.WHITE,  300)); //1
		clist.add(new Cup(Cup.RED,    900));
		clist.add(new Cup(Cup.YELLOW, 1000));
		clist.add(new Cup(Cup.BLUE,   600)); //2
		
		//*** 기본적으로 같은 자료형(클래스)의 객체가 동일한 값(상태)을 가지더라도 다른 객체임.
		//		> 두 객체는 독립적으로 존재함. (메모리 주소가 다름)  == 쌍둥이
		//		>> 객체의 유일성
		// 근데 가끔 같은 애로 처리해야할 때가 있음. > 이게 문제 >> 이건 distinct도 문제
		
		
		clist.stream().distinct().forEach(cup -> System.out.println(cup)); 
									//10개 -> WHITE들,BLUE들을 각각 다른 애로 취급
									//B-2 이후 (해쉬코드,equals재정의후) 8개나옴.
		
		//WHITE도 하나만, BLUE도 하나만 나오게해보자
		
		//Set, distinct() > 중복 객체를 제거하려면?
		//1. HashCode()를 재정의하고
		//2. equals()를 재정의하면 됨.
		
		//>>> 이건 Cup class 가서 해야돼 (내부에서) 다시 B-2로
		
		
		
		
	}//m3

	
	
	private static void m2() {
		//이번엔 문자열로 filter 사용
		
		Data.getStringList().stream()
				.filter(word -> word.length() >= 5)
				.forEach(word -> System.out.println(word));
		System.out.println();
		
		Data.getUserList().stream()
				.filter(user -> user.getWeight() >= 70)
				.filter(user -> user.getGender() == 1)
				.filter(user -> user.getHeight() >= 180)
				.forEach(user -> System.out.println(user));
		System.out.println();
		
		
		
	}//m2

	private static void m1() {
		List<Integer> list = Data.getIntList(20);
		System.out.println(list);
		
		//짝수만 출력
		
		
		//1. 일반 for문
		for (int i=0; i<list.size(); i++) {
			if (list.get(i) % 2 ==0) {
				System.out.printf("%4d", list.get(i));
			}
		}
		System.out.println();
		
		//2. 향상된 for문
		for(int n : list) {
			if (n%2 ==0) {
				System.out.printf("%4d", n);
			}
		}
		System.out.println();
		
		
		//3. stream().forEach()활용
		
		list.stream().forEach(n -> { 
			if (n%2 == 0) {
				System.out.printf("%4d", n);
			}
		});
		System.out.println();
		
		
		//filter는 predicate이 매개변수 -> 매개변수 하나가 들어오면 boolean으로 반환
		
		//1. list.stream() > 20개의 숫자 탐색.
		//2. filter(조건)	   > 20개의 숫자를 조건 검사(짝수인지 홀수인지)
		//                 > true인 요소들만 가지고 새로운 스트림 생성 >> filter는 그 새로운 스트림을 반환함.
		//3. forEach(소비)  > 짝수만 들어있는 스트림(filter의 반환 스트림)을 소비.
									
		list.stream().filter(n -> {
			if (n % 2 == 0) {
				return true;
			} else {
				return false;
			}
		}).forEach(n -> {
		System.out.printf("%4d", n);
		});
		System.out.println();
		
		
		//위 코드 요약본 -> 이 코드에 익숙해지고, 이렇게 줄이는 연습을 계속 해야해
		list.stream().filter(n -> n%2 ==0).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		//위가 헷갈리면 이렇게 파이프마다 끊어주기도 함
		list.stream()
			.filter(n -> n%2 ==0)
			.forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		System.out.println();
		
		//한 필터에 조건 두개
		list.stream().filter(n -> n % 2 ==0 && n >= 50).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		//각각 조건을 가지고 있는 필터 2개
		list.stream()
			.filter(n -> n % 2 ==0)
			.filter(n -> n >= 50)
			.forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		//결과는 같은데 취향차이? 근데 가독성이나 유지보수면에선 필터 2개로 하는게 더 나음.
		//그렇다고 무조건 밑에꺼가 더 좋은 것도 아님. 회전수 차이가 있음. 밑에는 기본 20회전 + 14회전 더 돌아
		
		//필터 순서 차이 (앞에서 얼마나 걸러주냐에 따라 뒤의 필터 회전수가 차이남)
		list.stream()
			.filter(n -> n >= 50)
			.filter(n -> n % 2 ==0)
			.forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		
		//>> 근데 이건 데이터가 진짜 수만개 이상일때야 유의미하지 평소엔 성능기준으로 선택하진 않음. 그냥 가독성면에서만 봐
	}
}//Ex76


//B.

class Cup {
	
	public static final int BLACK = 1;
	public static final int WHITE = 2;
	public static final int RED = 3;
	public static final int YELLOW = 4;
	public static final int BLUE = 5;
	//얘네는 어차피 public이니까 getter setter 생성하지마
	
	
	private int color;
	private int size;
	
	
	public Cup(int color, int size) {
		this.color = color;
		this.size = size;
	}


	public int getColor() {
		return color;
	}


	public void setColor(int color) {
		this.color = color;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	
	@Override
	public String toString() {
		return String.format("Cup [color=%s, size=%s]", color, size);
	}
	
	
	
	////TODO hashCode 복습하기 (2022. 4. 13. 오전 10:45:32)
	//B-2
	//개발자의 의도대로 Cup 객체를 비교하기 위해서..
	//1. hashCode() 재정의
	//2. equals() 재정의 
	
	//여백에 ctrl+space  hashCode() 찾기
	@Override
	public int hashCode() {
		//비교하려는 객체의 상태(멤버변수값)을 가지고 해시코드를 생성해서 반환하기
		
		return (""+ this.color + this.size).hashCode(); //앞에 빈문자열 더해줘야 문자열이됨.
	}
	
	//여백에 ctrl+space equal() 재정의
	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode(); //해쉬코드가 같으면 같은 객체로 인지
	}
	
	
}

//C 
class Student {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	//생성자, Getter&Setter, toString
	
	public Student(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	@Override
	public String toString() {
		return String.format("Student [name=%s, kor=%s, eng=%s, math=%s]", name, kor, eng, math);
	}
	
	
}


//C-2
//Stream<Student> -> map() -> Stream<Result> >> 복합 데이터는 객체를 돌려주는게 좋음.
class Result {
	private String name;
	private String result;
	
	//생성자 getter/setter까지만 (toString은 안쓸거같아)
	
	
	public Result(String name, String result) {
		super();
		this.name = name;
		this.result = result;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}

//D

class Test {
	
	public int a;
	public boolean b;
	
	public String c;
	public User d;
	
}










