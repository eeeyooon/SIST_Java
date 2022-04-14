package com.test.java.stream;	//04.13 //m4부터 04.14

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
			
				
		
		*/
		
		//m1();
		//m2();
		//m3();
		//m4(); //04.14
		m5();
		
	}//main

	
	
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












