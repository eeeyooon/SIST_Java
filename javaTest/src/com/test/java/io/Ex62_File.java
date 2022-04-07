package com.test.java.io;	//04.04

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex62_File {
	
	//누적변수 멤버로 빼기 (m15)
	private static int count = 0; //우리가 만든 메소드가 static이니까 -> 멤버니까 모든 메소드에 접근 가능
	

	public static void main(String[] args) {
		
		//Ex62_File
		
		/*
			
			1. 파일/디렉토리 조작
				- 윈도우 탐색기로 하는 행동	> 자바로 구현 가능
				- 파일 > 정보 확인, 새로 만들기, 이름바꾸기, 이동하기, 삭제하기, 복사 등
				- 폴더 > 정보 확인, 새로 만들기, 이름바꾸기, 이동하기, 삭제하기, 복사 등
				
			2. 파일 입출력
				- 파일 > 읽기/쓰기
				- 텍스트 입출력
				- 메모장, 이클립스 등
			
		*/
		
		
		//m1();
		//m2();
		//m3(); //파일 생성하기
		//m4();	//파일명 수정하기
		//m5();	//파일 이동
		//m6();
		//m7();
		//m8();
		//m9();
		//m10(); //폴더명 수정
		//m11();
		//m12(); 	//폴더 삭제
		//m13();
		//m14();
		//m15();	//재귀메소드로 파일개수 세기
		m16();
		
		
		//오늘 수업 요약
		//파일(폴더) > 생성, 이름 수정, 이동, 삭제 
		//폴더 > 내용 보기(listFiles())
		//		> 재귀호출(폴더 탐색) ***
		
		
		
		//TreeView - 폴더나 드라이브를 계층 구조로 보여줌.
		//ListView - 그 계층 구조중 하나를 골랐을때 그 폴더나 드라이브의 리스트를 보여줌. (자식 폴더와 자식 파일을 목록으로 출력)
		
	}//main

	private static void m16() {
		
		//List -> 순서 존재 -> 루프 사용(방번호)
		//Set -> 순서 없음 -> 루프 사용(Iterator)
		//Map -> 순서 없음 -> 루프 사용 X
		
		//Map 루프 돌리는 방법
		HashMap<String,String> map = new HashMap<String, String>();
		
		map.put("one", "하나");
		map.put("two", "둘");
		map.put("three", "셋");
		map.put("four", "넷");
		map.put("five", "다섯");
		
		//HashSet(c) > Set(I)	//인터페이스를 변수로 받아도 ㄱㅊ 어차피 set가지고 Hashset을 한거니까 (?) 반대인가?
		Set<String>	set = map.keySet();
		Collection<String> values = map.values(); //value들로만 구성된 Collection
		
		//System.out.println(set); //value는 안나오고 key값만. HashMap의 key들로만 구성된 SEt
		//System.out.println(values);
		
		//set은 Interator 뽑아낼 수 있음. -> loop 돌릴 수 있음.
		
		Iterator<String> iter = set.iterator();
		
		
		//향상된 for문 구조임. (향상된 for문의 내부구조는 Iterator로 되어있음)
		while (iter.hasNext()) {
			//System.out.println(iter.next()); //소비(Stack,Queue 유사)		//key로만 구성된 set을 돌리는 것.
			
			String key = iter.next();
			
			System.out.println(key + ":" + map.get(key));
		}
		
		//식 정도로만 알아둬 자주 쓰는건 아님.
		
		
	}
	

	private static void m15() {	//재귀메소드사용
		//폴더의 내용 보기 + 업무 추가
		//> 특정 폴더의 모든 파일 개수 세기?
		
		//파일 11,987 / 폴더 2,590 / 크기 794,762,947 바이트 >> 구하는 방식은 모두 같음
		
		String path = "C:\\class\\eclipse";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			 countFile(dir);
			
			System.out.printf("총 파일 개수: %,d개\n", count);	//7 //처음 시작시 7개
			
			
		}
	}
	
	//넘어온 폴더(dir)의 파일 개수 누적하는 역할. 
	private static void countFile(File dir) { //반복되는 애들 따로 메소드로 빼기
		
		//1. 목록 가져오기
		File[] list = dir.listFiles(); //dir은 매개변수로 넘어옴
		
		//2. 파일 개수 세기 + //2.3 크기 구하기(바이트)
		for (File subfile : list) {
			if (subfile.isFile()) {
				count++;
				//count += subfile.length(); //크기 구하기 (2.3)
			}
		}
		
		
		//2.2 폴더 개수
		//3. 자식 폴더를 대상으로 1~2번 반복
		for (File subdir : list) {
			if (subdir.isDirectory()) {
				
				//count++; //폴더인 애들만 카운트 (2.2) > 이거하려면 2번 전체 주석처리해야해.
				
				//폴더인 애들 대상으로 (true일때) 1~3번 반복 그 안에서 또 반복 또 반복.
				
				countFile(subdir); //이번엔 자식 폴더를 대상으로 1~3번 반복. => 재귀 호출
				
				
			}
		}
		
		//이 재귀 호출은 countFile이 더이상호출하지 않을때 -> 어떤 폴더가 자식 폴더가 없을때까지. (자식없는 폴더에 도착할때)
		
		//2. 출력] 총 파일 개수: 11,987개
		//2.2 출력] 총 파일 개수: 2,590개
		//2.3 출력] 총 바이크 크기 : 794,762,947

	}
	
	

	private static void m14() {
		
		//폴더의 내용 보기 + 업무 추가
		//> 특정 폴더의 모든 파일 개수 세기?
		
		//파일 11,987 / 폴더 2,590 / 크기 794,762,947 바이트 >> 구하는 방식은 모두 같음
		
		String path = "C:\\class\\eclipse";
		
		File dir = new File(path);
		
		int count = 0; //누적 변수
		
		if (dir.exists()) {	//eclipse 안에 있는 내용물들을 먼저 가져올 거임.
			
			File [] list = dir.listFiles();
			
			for (File subfile : list) {
				if (subfile.isFile()) {
					count++;
				}
			}
			
			//자식 폴더 접근
			for (File subdir : list) {
				
				//자식중에 하나를 들어갔어 -> 이제 목록을 얻어와
				
				if (subdir.isDirectory()) {	//먼저 폴더인지 파일인지 확인부터해야해. 폴더이면 목록 가져오기
					//자식폴더로부터 목록을 얻어와야 해 (내용물)
					File [] sublist = subdir.listFiles();
					
					for (File subsubfile : sublist) {
						if (subsubfile.isFile()) {
							count++;
						}
					}
					
					//자식의 자식 폴더 접근 (이클립스의 손자)
					for (File subsubdir : sublist) {	//자식 목록 중에서 폴더인 애들
						if (subsubdir.isDirectory()) {
							
							//손자 폴더 (예 폴더입니다)
							//손자 폴더의 내용물 (리스트) 얻어와야 해
							File[] subsublist = subsubdir.listFiles();
							
							for (File subsubsubfile : subsublist) {
								if (subsubsubfile.isFile()) {
									count++; 
								}	
							}
						// 이걸 언제까지?? >> 몰라. 어디까지 폴더가 더 있는지 알 수 없음. 이 방법으로는 못구해
							//이럴때 재귀 메소드를 사용해야해
						}
					}
				}
			}
			
			System.out.printf("총 파일 개수: %,d개\n", count); //7개 -> O
			
		}
		
	}

	private static void m13() {
		//폴더의 내용 보기
		
		File dir = new File("C:\\class\\eclipse");
		
		if (dir.exists()) {
//			
//			//1. 자식 파일명 + 자식 폴더명을 가져온것. (>> 딱 이름만!)
//			String[] list = dir.list();	//리턴값 문자열배열
//			
//			for (String f : list) {
//				System.out.println(f); //출력 잘됨. 정렬은 실제 ListView와는 좀 다름.
//			}
		
//			//2. > 파일인지 폴더인지도 확인
//			String[] list = dir.list();
//			
//			for (String f : list) {
//				
//				//이름 사용 > File 객체 생성 > isFile(), isDirectory()
//				System.out.println(f);
//				
//				File file = new File(dir.getAbsolutePath() + "\\" + f); 	//끝에 역슬래시가 없으니까 따로 챙겨줘야해
//				System.out.println(file.isFile()); //isFile이나 isDirectory둘다 가능	// >>true는 file, false는 folder
//				System.out.println();
//		
//		
//			}
			
//			//3.
//			File[] list = dir.listFiles(); //return값이 파일 객체 -> 위 행동을 미리 해놓은 것.
//			
//			for (File f : list) {
//				System.out.println(f.isDirectory());
//				System.out.println(f.getName());
//				System.out.println();
//				
//			}
			
			//탐색기 느낌을 내보자
			File[] list = dir.listFiles(); //목록 가져오기
			
			for (File d : list) {
				
				if (d.isDirectory()) {
					
					System.out.printf("[%s]\n", d.getName()); //폴더만 출력
				}
			}
			
			for (File f : list) {
				
				if (f.isFile()) {
					
					System.out.printf("%s\n", f.getName()); //그 다음 파일 출력
				}
				
			}
		}
	}

	private static void m12() {

		//폴더 삭제하기
		//- 빈폴더만 삭제가 가능함.
		
		File dir = new File("C:\\class\\java\\file\\aaa");
		
		if (dir.exists()) {
			boolean result = dir.delete();
			System.out.println(result); //true
		}
		
		
	}

	private static void m11() {
		
		//폴더 이동하기
		File dir = new File("C:\\class\\java\\file\\todo");
		File dir2 = new File("C:\\class\\java\\move\\todo"); //file에서 move로 todo 옮기기
		
		//여기선 중복검사 안할게 원랜 해야해
		boolean result = dir.renameTo(dir2);
		System.out.println(result); //true -> 폴더 위치 이동 (move로)
		
	}

	private static void m10() {
		
		//폴더명 바꾸기
		
		File dir = new File("C:\\class\\java\\file\\할일");
		File dir2 = new File("C:\\class\\java\\file\\todo");
		
		//여기선 중복검사 안할게 원랜 해야해
		boolean result = dir.renameTo(dir2);
		System.out.println(result); //true -> 폴더명 바뀜
		
	}

	private static void m9() {
		
		//요구사항] 할일 > 날짜별 폴더 > "2022-01-01" ~ "2022-12-31"
		
		Calendar c = Calendar.getInstance();
		c.set(2022, 0, 1); //시작날짜로 먼저 set
		
		/*
		System.out.printf("%tF", c); //2022-01-01
		
		c.add(Calendar.DATE, 1);
		
		System.out.printf("%tF", c); //2022-01-02
		*/
		
		//System.out.println(c.getActualMaximum(Calendar.DATE)); //그 월의 마지막 날짜(최댓값 구하기) //31
		System.out.println(c.getActualMaximum(Calendar.DAY_OF_YEAR));
		//그 년도의 마지막 날짜(올해들어서 며칠인지) -> 그 년의 일수 //올해는 윤년x ->365 (윤년일땐 366)
																				
		for (int i=0; i<c.getActualMaximum(Calendar.DAY_OF_YEAR); i++) {
			
			String path = String.format("%tF", c);
			
			File dir = new File("C:\\class\\java\\file\\할일\\" + path);
			
			System.out.println(dir.mkdir()); //true가 365개 찍혀야함.
			
			c.add(Calendar.DATE, 1); //일수가 증가해야 모든 날짜
			
		
		}
		
		System.out.println("종료");
		
	}

	private static void m8() {
			
		//요구사항] 회원 > 회원명으로 개인 폴더 생성 
		String[] member = {	"홍길동", "아무개", "하하하", "호호호", "후후후" };
	
		for (int i=0; i<member.length; i++) {
			
			String path = String.format("C:\\class\\java\\file\\회원\\[개인폴더]%s님", member[i]);
			
			File dir = new File(path);
			
			System.out.println(dir.mkdir()); 	//log..
			//true true true true true 
			
		}
		
	}

	private static void m7() {
		
		//폴더 생성하기
		
//		File dir = new File("C:\\class\\java\\file\\aaa");
//		
//		if (!dir.exists()) {
//			boolean result = dir.mkdir();	
//			System.out.println(result);	//true
//		//한번 더 실행하면 false -> 첫번째 실행때 이미 생성했으니까
//		} else {
//			System.out.println("이미 같은 이름의 폴더가 존재함.");
//		}
		
		
		
		File dir = new File("C:\\class\\java\\bbb\\ccc");
		
		if (!dir.exists()) {
			boolean result = dir.mkdirs();	//부모 자식 동시에 만들땐 mkdirs 한놈이면 mkdir
			System.out.println(result);	//true
		//한번 더 실행하면 false -> 첫번째 실행때 이미 생성했으니까
		} else {
			System.out.println("이미 같은 이름의 폴더가 존재함.");
		}
	}

	private static void m6() {
		
		//휴지통은 그냥 파일이동이지 진짜 삭제는 아녀
		File file = new File("C:\\class\\java\\file\\data.txt");
		
		if (file.exists()) {
			
			boolean result = file.delete();	//진짜 삭제 
			System.out.println(result);
			
		}
		
	}

	private static void m5() {
		
		//파일 이동하기
		//- file\hello.txt > move\hello.txt 로 이동
		
		File file = new File("C:\\class\\java\\file\\hello.txt");	//현재 파일 위치 (file)
		File file2 = new File("C:\\class\\java\\move\\hi.txt");	//바꾸고 싶은 파일 위치 (move)
		
		if (file.exists()) {
			
			boolean result = file.renameTo(file2);	
			//여기서의 rename은 파일의 이름만 바꾸는게 아니라 경로도 바꿀 수 있는 메소드임. 이름+경로 둘다 바꾸는 것도 가능
			System.out.println(result);
		}
		
	}

	private static void m4() {
		
		//파일명 바꾸기
		//-hello.txt -> hi.txt로 바꿔보자
		
		File file = new File("C:\\class\\java\\file\\hello.txt");	//현재 이름
		File file2 = new File("C:\\class\\java\\file\\hi.txt");		//내가 바꾸고싶은 이름
		
		
		if (file.exists()) {	//얘는 무조건 깔고가
			
			//file(hello.txt) -> file2(hi.txt)
			boolean result = file.renameTo(file2);		//인자값이 또다른 파일 객체임 -> 매개변수의 자료형도 file임
			System.out.println(result); //true //이름 바꾼 것.
		}
		
	}

	private static void m3() {
		
		//파일 조작 > 생성, 복사(이건 지금X), 이동, 파일명 수정, 삭제 //나머지는 메소드가 있는데 복사는 직접 해야해 
		
		//새파일 만들기
		File file = new File("C:\\class\\java\\file\\hello.txt");	//hello.txt를 새로 만들고싶다 (가상의 경로로 참조객체생성)
		
		if (!file.exists()) {
			
			try {
				
			//동일한 파일이 존재하면 새로 만들기를 실패 (근데 제일 처음에 파일검사함 -> file.exist() 이거 안해도 파일 없으면 생성 안함.)
				System.out.println(file.createNewFile());	
				//예외 미루기가 들어있는 메소드. 근데 trycatch안해놓음 -> 우리가 해야해.
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("이미 동일한 파일이 존재합니다.");
		}
		
		
	}

	private static void m2() {
			
		//폴더 > 정보
		//- 폴더(Folder), 디렉토리(Directory)
		
		//경로
		
		final String PATH = "C:\\class\\java\\file";
		
		//디렉토리 참조 객체
		//- 디렉토리(폴더)는 파일이다.
		File dir = new File(PATH);
		
		if (dir.exists()) {
			System.out.println("폴더 있음");
		} else {
			System.out.println("폴더 없음");
		}
		
		System.out.println(dir.getName());				//file
		
		System.out.println(dir.isFile());				//false
		System.out.println(dir.isDirectory());			//true	
		
		System.out.println(dir.length());				//0		//**폴더 크기 (폴더는 실제 공간이 X 그래서 항상 0)
																//폴더 속성 안 크기는 -> 폴더 안의 파일 크기임.
		
		System.out.println(dir.getAbsolutePath());		//C:\class\java\file
		System.out.println(dir.getPath());				//C:\class\java\file
	
		System.out.println(dir.lastModified());			//1649031810183
		
		System.out.println(dir.isHidden());				//flase
		
		System.out.println(dir.getParent());			//C:\class\java		//부모 폴더
		
		
	}

	private static void m1() {
		
		//파일 > 정보
		//	"C:\class\java\file" 폴더 생성
		//	"C:\class\java\file\data.txt" 파일 생성
		
		//자바에서 외부의 파일을 접근 !!
		//1. 외부 파일을 참조하는 참조 객체 생성 > 대리인, 혹은 위임자를 만들어야함.
		//2. 참조 객체를 조작. > 외부 파일에 적용 
		
		//경로 >> 얘는 보통 수정되지 않으니까 나중에 실수가 나오지 않게 상수로 함. (변수로 할때도있긴함)
		final String PATH = "C:\\class\\java\\file\\data.txt";
		
		// 파일 참조 객체 >> java.io.File
		// - file 객체 == data.txt
		File file = new File(PATH);	//기본 생성자는 없고 매개변수가 꼭 들어가야 함.
		
		//System.out.println(file.exists()); //boolean값 반환 //true //경로에 file이 실제로 존재하는지 검사해주는 메소드
		
		//true일때만 시작해야해. 그러니까 시작문은 보통 이렇게
		if (file.exists()) {
			
			System.out.println("파일 있음");
			
			//정보
			System.out.println(file.getName());				//data.txt
			
			System.out.println(file.isFile());				//true		//나 파일 맞아 
			System.out.println(file.isDirectory());			//false		//너 파일이야 디렉토리(폴더)야? -> 디렉토리 아니야
			
			System.out.println(file.length());				//19		//파일 크기(바이트)
			
			System.out.println(file.getAbsolutePath());		//C:\class\java\file\data.txt	//절대 경로->나중에 구분해줄게
			System.out.println(file.getPath());				//C:\class\java\file\data.txt	//해당 파일의 경로
			
			System.out.println(file.lastModified());		//1649031841321	//속성에서 수정한 날짜 tick
																			//(자바에선 수정날짜만 가져올 수 있음)
			
			System.out.println(file.isHidden());			//false		//숨긴 파일인지 아닌지
			
			
			//tick -> 년월일시분초로 바꾸는 방법
			Calendar c1 = Calendar.getInstance();
			System.out.println(c1.getTimeInMillis()); //->얘가 tick을 가져오는것
			c1.setTimeInMillis(file.lastModified()); 
			//-> 파일의 tick값을 c1에 저장한것.(덮어쓰기) 해당 캘린더에다가 "1649031841321"을 저장해 정확한 년월일시분초를 알려줌.
			
			System.out.printf("%tF %tT\n", c1, c1); //2022-04-04 09:24:01 
			
		} else {
			System.out.println("파일 없음");
		}
		
	}
	
}//Ex62








































