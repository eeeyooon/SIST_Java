package com.test.java.collection; //03.30 , 03.31

import java.util.ArrayList;

public class Ex56_ArrayList {

	public static void main(String[] args) {
		
		
		/*
		
			컬렉션, Collection
			- JCF, Java Collection Framework
			- (향상된) 배열
			- 기존의 순수 배열의 성능 향상(입출력), 사용법을 개량 > 클래스로 만들어놓음.
			- 내부에 순수 배열이 존재, 공개된 public 메소드들을 통해서 성능 or 사용법을 개량시켜놓은 것.
			- 길이 가변 > 방의 개술르 마음대로 늘리고 줄이는 게 가능
			- 자료구조
			
			
			03.31
			총 4개의 인터페이스를 알아야 함.
			1. Collection
			2. list계열
			3. set계열
			4. map 
			>> 인터페이스의 이름.
			
			
			부모 : Collenction -> 자식 : List, Set
			
			//젤 마지막에 정리 + 03.31 수업 마지막때도 다시 봄. 같은 계열인거 체크
			컬렉션 종류
			1. List 계열
				- ArrayList
				- LinkedList //큐에 담겨서 큐처럼 쓸수도 있고 , 본연의 스타일 그대로 쓸 수도 있음.
				- Queue
				- Stack
				- Vector(legacy)
				
			2. Set 계열
				- HashSet
				- TreeSEt
				
			3. Map 계열
				- HashMap
				- TreeMap
				- Properties
				- HashTable
			
			
			
			//tip
			//도큐먼트에서 상속받은 인터페이스들 확인하는게 좋음.  -> docs.oracle에서 확인해 (선생님 깃허브 첫번째사이트)
			  
			 
			 
			ArrayList 클래스
			-제네릭 클래스(<E> : Elements)
			- ArrayList(C) -> List(I) -> Collection(I) *** 이건 기억해. (컬렉션으로부터 리스트 상속받고 리스트로부터 어레이리스트상속)
			- 순수 배열하고 구조가 가장 유사함.
			- 사용빈도가 가장 높음 -> 가장 많이 복습을 해야 함. **** 가장 오래 가장 많이 공부해야해. 컬렉션 중엔 얘가 가장 기본
			- 첨자(index)를 사용해서 요소(element)에 접근
			
		
		*/
		
		//m1(); //ArrayList란?
		//m2();	//ArrayList의 사용법
		//m3();
		//m4();
		//m5();
		//m6(); //03.31
		m7(); //size가 코드에 미치는 영향?
		
		
	}//main
	
	private static void m7() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		 
		//**** 컬렉션에 반복적으로 데이터에 넣는 행동을 할때 생기는 문제점 > 가변 특성을 유지하기 위해 발생하는 문제들
		//1. 가비지 발생 > 비용 발생 (복사한 후 뒤바뀐 당한 원래 배열들 -> 가비지로)
		//2. 배열 복사 발생 > 비용 발생
		
		
		//위의 문제점을 해결하는 방법
		//- ArrayList의 초기 길이를 지정할 수 있음.
		//ArrayList<Integer> list = new ArrayList<Integer>(10); -> 초기 길이 지정하는거 습관돼야해!
		//
		
		
		for (int i=0; i<10; i++) {
			list.add(i);
		}
		
		System.out.println(list.size()); //10
		System.out.println();
		
		//list.add(10); -> 20칸이 되어버림. (2배가 되니께)
		//** 이 이후로 list에 데이터를 더 추가할 일이 없을 것 같아. (추가된 10칸 중 1칸만 써도 끝이야) -> 9칸이 남네;;
		// 그럼 이번엔 반대로 그 9칸을 없애는 방법이 있어.
		
		list.trimToSize(); 
		//실행을 해도 사용자는 겉으론 행동의 결과를 알 수 있는 방법이 없음. 근데 얘는 20칸에서 11칸으로 줄여줌.
		// 딱 데이터가 있는 방까지만 남기고. -> how? 데이터의 수만큼 방(11칸)을 만들고 데이터를 복사 바꿔치기. 원본(20칸)삭제
		// -> 얘도 자주 쓰면 안돼 이것도 남용하면 낭비임. 그래서 확실할때만 가끔 사용!
		
		int[] num = new int[10];
		
		for (int i=0; i<10; i++) {
			num[i] = i;
		}
		
		
		//출력
		for (int n : list) {
		System.out.println(n);
		}
		
		System.out.println(); //공백
		
		for (int n : num) {
			System.out.println(n);
		}
	}	

	private static void m6() {
		
		//ArrayList(컬렉션) 특징
		//1. 내부에 배열을 가지고 있다. == ArrayList를 배열이라고 생각하자
		//2. ArrayList 클래스의 대부분 기능이 내부 배열을 조작하는 기능으로 구성되어있음.
		//3. 길이가 가변 > 데이터를 넣으면 계속 공간이 늘어난다. 
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(10);
		System.out.println(list.size()); //내부 배열의 실제 길이는 4인데, size는 1로 나옴.
										 //size는 들어있는 데이터의 개수를 반환함. 

		list.add(20);
		list.add(30);
		list.add(40);
		
		//기존 배열에 방을 추가하는게 아니라 기존배열x2칸짜리 방을 만든뒤 일대일로 복사하고 배열바꿔치기를 함. 
		//첫번째 값을 입력하면 4칸짜리 방이 생김.
		
		
		System.out.println(list.size()); //내부 배열의 길이는
		
		list.add(50);
		list.add(60);
		list.add(70);
		list.add(80);
		list.add(90);
		
		System.out.println(list.size());
		
		//.size()는 단순 배열의 길이를 반환하는게 아니라 들어있는 데이터의 개수를 반환함. -> 그래서 length가 아니라 카운트 세는 것에 가까움.
		
	}

	private static void m5() {
		
		//선택?
		//배열(고정일때) vs ArrayList (불확실할때)
		//- 길이로 선택
		
		ArrayList<Student> list = new ArrayList<Student>(); //학생 만든거 x 학생을 넣을 수 있는 방을 만든 것.
		
		//난수로 국어 영어 수학 생성
		//난수로 이름 구하기는 나중에 하자
		
		
		for (int i=0; i<5; i++) {
			
			int kor = (int)(Math.random() * 41) + 60; //-> 60~100점 사이에 난수 구하기
			int eng = (int)(Math.random() * 41) + 60;
			int math = (int)(Math.random() * 41) + 60;
			
			Student s = new Student("학생" + i, kor, eng, math);
			
			list.add(s); //배열에 학생 추가
			
		}//for
		
		//성적표 출력
		System.out.println("=============================================");
		System.out.println("                  성적표");
		System.out.println("=============================================");
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]");
		
		//list안에 있는걸 모두 꺼낼거면 향상된 for문이 편함.
		for (Student s : list) {
			
		
			int total = s.getKor() + s.getEng() + s.getMath();
			double avg = total / 3.0;
			
			System.out.printf("%s\t%5d\t%5d\t%5d\t%5d\t%5.1f\n"
								, s.getName()
								, s.getKor()
								, s.getEng()
								, s.getMath()
								, total
								, avg);
			
		}
		
	}

	private static void m4() {
		//*****복습 잘하자*******
		//배열(컬렉션)의 요소
		//- 값형 데이터, 문자열
		//- 객체
		
		//가볍게 class 예제 하나 만들기 (맨 밑에 class Cup -> 입출력만 가능하게)
		
		//1. Cup을 5개 만들어라	 >> 인스턴스(객체)를 5개 만들어라.
		//2. Cup을 담을 수 있는 방을 5개 만들어라.
		//수업 내용이 정리돼야 이 두개의 차이가 이해됨.
//		Cup[] clist = new Cup[5];	//*******이건 2번이야.
//									//배열이 하는 일이 뭐야? 앞에 있는 타입(Cup)을 집어넣을 수 있는 방을 여러개만들 수 있는 기술이야.
//									//Cup변수 5개 만들어준거일뿐.
//		
//		System.out.println(clist[0].toString()); //NullPointerException		
//											 	 // > 존재하지 않은걸 호출할때 나오는 error. clist[0] -> 지금 Cup없어 방만 만듦.
//		
//		Cup c1 = new Cup("",0);
//		Cup c2 = new Cup("",0);
//		Cup c3 = new Cup("",0);
//		Cup c4 = new Cup("",0);
//		Cup c5 = new Cup("",0);
//		//이게 컵을 5개 만들라는 얘기야. 컵을 만드려면 반드시 new연산자랑 생성자가 필요함. -> 이게 있어야 객체생성이 가능해.
//		
//		
//		Cup p1;
//		Cup p2;
//		Cup p3;
//		Cup p4;
//		Cup p5;
//		
//		//이게 2번. Cup을 담을 수 있는 방을 5개 만들어라 = 변수 5개를 만들어라.  (컵은 없음. 인스턴스 X)
		
		
		//다시 본론
		
		Cup[] clist = new Cup[5];
		
		clist[0] = new Cup("", 0); //1번째 컵 객체
		clist[1] = new Cup("", 0); //2번째 컵 객체
		clist[2] = new Cup("", 0); //3번째 컵 객체
		clist[3] = new Cup("", 0); //4번째 컵 객체
		clist[4] = new Cup("", 0); //5번째 컵 객체
		
		
		ArrayList<Cup> list = new ArrayList<Cup>(); //아직 컵은 하나도 안만든거야
		
		list.add(new Cup("",0)); //1번째 컵 생성
		list.add(new Cup("",0)); //2번째 컵 생성
		list.add(new Cup("",0)); //3번째 컵 생성
		list.add(new Cup("",0)); //4번째 컵 생성
		list.add(new Cup("",0)); //5번째 컵 생성
		
		
		for (int i=0; i<clist.length; i++) {
			System.out.println(clist[i]);
		}
		
		//위 for문과 똑같. 향상된 for문은 인덱스가 눈에 안보임. (내부적으로 처리)
		for (Cup cup : clist) {
			System.out.println(cup);
		}
		
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//향상된 for문은 굉장히 추상화가 잘되어있음 -> 이게 장단점.
		for (Cup cup : list) {
			System.out.println(cup);
		}
		
		
	}

	private static void m3() {
		
		int[] 		ns1 = new int[2];
		int[][] 	ns2 = new int[2][3];
		int[][][]	ns3 = new int[2][3][3];
		
		//ns1와 같은 배열 > 1차원 정수 배열
		ArrayList<Integer> ms1 = new ArrayList<Integer>();
		
		//ns2와 같은 배열 > 2차원 정수 배열
		ArrayList<ArrayList<Integer>> ms2 = new ArrayList<ArrayList<Integer>>();
		//'<>'안에 있는게 자료형임. = ArrayList<Integer>도 자료형. -> 숫자가 아니라 1차원배열..
		
		//ns3와 같은 배열 > 3차원 정수 배열
		ArrayList<ArrayList<ArrayList<Integer>>> ms3 = new ArrayList<ArrayList<ArrayList<Integer>>>();
		
		
		//2차원 배열 초기화
		ns2[0][0] = 10;		//***********
		
		//2차원 컬렉션의 초기화
		ArrayList<Integer> list = new ArrayList<Integer>(); //바깥 차원의 어레이리스트는 어레이리스트를 요구하니까. //*******
		list.add(10); //이게 0,0에 10을 넣은 것.		
		ms2.add(list);
		
		//2차원배열 초기화 한문장과 2차원 컬렉션의 초기화 세문장이 같아 보일때까지 쳐다봐 (?) ㅋㅋㅋㅋ ㅠㅠ
		
	}

	private static void m2() {
		
		//ArrayList 사용법
		ArrayList<String> list = new ArrayList<String>(); //문자열 배열
		
		//1. 요소 추가하기
		//- boolean add(T value) > return값 받을 일 거의 없음. void라고 생각해도 무리x
		//- 배열의 맨 마지막 방에 추가함 > Append Mode (이렇게 부름. 이어붙이기)
		
		list.add("바나나");
		list.add("딸기");
		list.add("포도");
		list.add("귤");
		list.add("사과");
		list.add("파인애플");
		
		
		//2. 요소의 개수
		//- int size()
		System.out.println(list.size()); //5
		
		
		//3. 요소의 접근
		//- T get(int index)
		System.out.println(list.get(0));
		System.out.println(list.get(4));
		//System.out.println(list.get(5)); //error.IndexOutOfBoundsException (array는 ArrayIndex~) 
		System.out.println(list.get(list.size()-1)); //마지막 방의 데이터
		
		
		//4. 요소의 수정
		//- list[0] = 10; //배열은 대입과 수정이 동일한 표현법을 사용함.
		//- String set(int index, T newValue) //return값은 지워지는 값을 반환함.
		//list.set(2, "파인애플");
		String temp = list.set(2, "파인애플");
		System.out.println(temp); //포도
		System.out.println();
		System.out.println(list.get(2)); //파인애플 > 수정됨
		System.out.println();
		
		//5. 요소의 삭제
		//- 순수배열은 요소 삭제 불가능 (방 자체를 삭제할 순 없잖아)
		//- 컬렉션은 요소 삭제 가능
		//- T remove(int index) // > 방번호 삭제 >> 반환값 : 지워지는 애
		//- boolean remove(T value) > 값을 찾아서 삭제 //오버로딩 되어있음. >> 반환 성공하면 true, 실패하면 false
		//- ******* 시프트가 발생함. (-> 하나 추가되면 뒤로 밀리고 하나빠지면 앞으로 당기는거. left shift / right shift)
		//						>> 삭제된 방 이후의 모든 요소는 모두 방번호 -1 감소
		
		
		//b.
		//list.remove(2); //방법 두가지 뭘써도 상관 x
//		list.remove("파인애플");
		
		//b.
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		// list.remove(2); 일때나 list.remove("파인애플")일때나 > 바나나 딸기 귤 사과
		
		//만약 동일한 값을 가진 배열이 2개 이상일 경우? ex. 파인애플이 2개 이상이면?
		// > 첫번째 파인애플만 지운다 or 모든 파인애플을 지운다. => 처음 만나는 파인애플만 지운다!
		// > 다 지우고싶으면? list.remove("파인애플")을 여러번
		// >> 근데 이것보단 그냥 방번호를 지우는게 안전!
		
		//c. 배열 요소 전부확인
//		for(int i=0; i<list.size(); i++) {
//			System.out.printf("list[%d] = %s\n", i, list.get(i));
//		}
		//방번호가 삭제되고 자동 앞당겨짐.(shift발생..) > 방번호가 삭제된걸 알지못한다면 큰일날수도 
											//>> 길이도 줄어듦.(삭제된 애 뒤에서부턴 방번호도 줄어듦)
		
		
		
		
		//6. 탐색
		//- 루프
		
		for(int i=0; i<list.size(); i++) {
			System.out.printf("list[%d] = %s\n", i, list.get(i));
		}
		System.out.println();
		
		//bonus ^^ 향상된 for문
		//반복문 > for, whild, do while, for (향상된 for문)
		
		/*
		for (변수(배열의 방 하나를 저장할 수 있는 공간) : 배열(or컬렉션)) { 
			
		}
		*/
		
		
		for (String item : list) { 
		//list의 내용을 item에 복사(첫번째방부터 순서대로 들어가서 꺼내고 복사, 실행 -> 들어가 꺼내고 복사)반복
		//모든 방을 다 돌았으면 알아서 나감. 이런건 똑똑한데,, 통제가 안됨. 처음부터 끝까지 돌아야해. 도라이..
			
			System.out.println(item);
		}
		// 위에 for문과 같은 내용 출력됨. (배열의 모든 요소 출력)
		
		//오타도 안남. 같은 탐색이면 향상된 for문을 쓰는게 나음.
		
		
		//7. 요소의 추가 (위에꺼랑 달라!)
		//- 배열의 원하는 위치에 요소를 추가 > Insert Mode (삽입)
		//- 삽입
		//- void add(int index, T value)
		//- ********얘도 시프트 발생함 > 삽입된 방 이후의 모든 요소가 방번호 + 1
		
		list.add(2, "망고");
		
		for (String item : list) {
			System.out.println(item);
		}
		System.out.println();
		
		
		
		//8. 요소의 검색
		//- int indexOf(T value)
		//- int lastIndexOf(T value)
		//- boolean contains(T value)
		
		System.out.println(list.indexOf("사과")); //5
		System.out.println(list.contains("사과")); //true
		
		
		
		//9. 초기화
		//- 모든 요소 삭제
		//- void clear()
		list.clear(); //모든 과일을 다 지움 지우고 나면.. 낙장불입.. 못되돌려..ㅠ 과일 안녕..
		
		System.out.println(list.size()); //0 > 길이가 0 돼부렀어
		
		
		//10. 빈배열 확인?
		System.out.println(list.size() == 0); //true (과일이.. 다 없으니께..)
		//-> 이걸 메소드로!
		//- boolean isEmpty()
		System.out.println(list.isEmpty()); //true
				
	}

	private static void m1() {
		
		//ArrayList list1 = new ArrayList(); //제네릭 클래스는 타입변수 안써도 사용은 가능하지만,
		
		
		//순수배열
		//- 타입 명시(int)
		//- 길이 명시(3)
		
		int[] num1 = new int[3];
		
		//요소 접근 > 첨자(index)사용
		num1[0] = 10;
		num1[1] = 20;
		num1[2] = 30;
		
		//입출력 모두 동일한 표현을 사용
		System.out.println(num1[0]);	//'식별자[첨자]' -> 이 표기법을 인덱서(indexer) => java는 이거 배열만 쓸 수 있음.
		System.out.println(num1[1]);
		System.out.println(num1[2]);
		
		System.out.println(num1.length); //3
		System.out.println();
		
		
		//컬렉션
		//- 타입 명시(int)		> 제네릭
		//- 길이 명시(3)		> ???  >> 가변이니까! (데이터를 넣으면 알아서 자동으로 늘어남.)
		ArrayList<Integer> list1 = new ArrayList<Integer>(); //그래도 꼭 명시해
		
		
		//클래스다보니 'add'로 추가
		//요소 접근 > 첨자는? > 얜 Append임 >> 무조건 차례대로 마지막 방에 넣음. (방번호-첨자- 신경쓸필요x)
		list1.add(10);	//자동으로 0번째 방 추가
		list1.add(20);	//1번째 방 추가
		list1.add(30);	//2번째 방 추가
		
		//입력할땐 방번호가 없는데 출력할땐 방번호를 사용
		System.out.println(list1.get(0)); //get은 방번호로 가져옴. (자동으로 차례대로 정해진 방번호)
		System.out.println(list1.get(1));
		System.out.println(list1.get(2));
		
		System.out.println(list1.size()); //3 > length말고 size로
		
		list1.add(40);
		list1.add(50);
		
		System.out.println(list1.size()); //5 -> 방을 2개 추가하자 방의 길이 5로 바뀜.
		System.out.println();
		
		for (int i=0; i<list1.size(); i++) {
			System.out.println(list1.get(i));
		} //10 20 30 40 50
		
		
		
		
	}
}//Ex56


class Cup {
	
	private String color;
	private int price;
	
	
	public Cup(String color, int price) {
		this.color = color;
		this.price = price;
	}


	@Override
	public String toString() {
		return "Cup [color=" + color + ", price=" + price + "]";
	}
	
	
}


class Student {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	//toString()이나 Setter없이 Getter만 생성
	
	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}
	
	
}

//03.31
//배열설명하다가
//Member m = new Member();

class Member {
	
	private int a;
	private String b;
	private int[] c;
	public Member() {
		a = 10;
		b = "홍길동";
		c = new int[5];
		
	}
	
}

















