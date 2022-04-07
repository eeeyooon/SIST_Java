package com.test.java; //03/08

public class Ex07_Output {

	public static void main(String[] args) {
		
		//Ex07_Output.java
		
		/*
			
			콘솔 입출력, Console Input Output, IO
			- 기본 입력 장치 : 키보드
			- 기본 출력 장치 : 모니터
			
			콘솔 출력
			-   클래스 .필드.메소드()
			-	'()' 이 소괄호 안에 값을 넣을 수 있는데, 상수나 변수 넣는 것 가능. 변수를 넣으면 데이터의 의미.
			
			1. System.out.print()
				- 값을 출력하고 종료
				
			2. System.out.println()
				- print line > 줄단위로 출력(무조건 한 줄로)
				- 값을 출력하고 엔터치고 종료
				
			3. System.out.printf()
				- print format > 여러가지 출력 형식 제공
				
		*/
		
		int age = 20;
		String name = "홍길동";
		char type = 'A';
		
		//print()
		//-소괄호안에 아무것도 안넣으면 그냥 무쓸모
		
		System.out.print(10);
		System.out.print(age);
		System.out.print(name);
		System.out.print("안녕하세요.");
		
		//println()
		
		System.out.println(10);
		System.out.println(age);
		System.out.println(name);
		System.out.println("안녕하세요.");
		
		//-println()은 이 소괄호 안에 아무것도 안넣어도됨. 그러면 엔터만 출력 > 빈 라인 생성
		System.out.println();
		
		System.out.print("\r\n"); //빈 라인 생성
		
		
		//성적표 출력하기
		String name1 = "홍길동";
		int kor1 = 100;
		int eng1 = 90;
		int math1 = 80;
		
		String name2 = "아무개";
		int kor2 = 95;
		int eng2 = 89;
		int math2 = 77;
		
		
		
		System.out.println("=============================");
		System.out.println("            성적표");
		System.out.println("=============================");
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]");	//\t쓸때 굳이 띄어쓰기 하지마 ㅎ 그것도 출력되니까 익숙해져라
		System.out.println("------------------------------");
		
		//print()
		System.out.print(name1 + "\t");
		System.out.print(kor1 + "\t");
		System.out.print(eng1 + "\t");
		System.out.print(math1 + "\n");
		
		//한줄로 표시하면 / (주관적이긴 하나) 위에 거가 좀 더 가독성 있음 (다만 더 오래 걸림)
		System.out.print(name1 + "\t" + kor1 + "\t" + eng1 + "\t" + math1 + "\n");
		
		//println()
		System.out.println(name2 + "\t" + kor2 + "\t" + eng2 + "\t" + math2);
		
		
		//print() + println()
		System.out.print(name1 + "\t");
		System.out.print(kor1 + "\t");
		System.out.print(eng1 + "\t");
		System.out.println(math1);
		
		// 예제 구분 빈라인
		System.out.println();
		
		
		//printf()
		//-형식 문자 제공 (지시자?)
		//1. %s -> String
		//2. %d	-> Decimal (정수, byte , short, int, long)
		//3. %f	-> Float (실수, float, double)
		//4. %c	-> Char
		//5. %b	-> Boolean
		
		
		//요구사항] "안녕하세요. 홍길동님" 출력
		name = "홍길동";
		
		System.out.println("안녕하세요. " + name + "님");
		
		System.out.printf("안녕하세요. %s님\n", "아무개");
		
		System.out.printf("안녕하세요. %s님\n", name); // 쓰다보면 이게 훨씬 더 가독성 있음.
		
		
		//요구사항] "안녕하세요. 홍길동님. 반갑습니다. 홍길동님"
		System.out.println("안녕하세요. " + name + "님. 반갑습니다. "	+ name + "님");
		
		System.out.printf("안녕하세요. %s님. 반갑습니다. %s님\n", name, name);
		
		
		//요구사항] SQL
		//insert into tblMember (seq, name, age, address, tel) values (1, '홍길동', 20, '서울시 강남구 역삼동', '010-1234-5678');
		
		String seq = "1";
		name = "홍길동";
		String age2 = "20";
		String address = "서울시 강남구 역삼동";
		String tel = "010-1234-5678";
		
		//지저분한 코드..
		System.out.println("insert into tblMember (seq, name, age, address, tel) values"
				+ " (" + seq + ", '" + name + "', " + age2 + ", '" + address + "', '" + tel + "');");
		
		
		System.out.printf("insert into tblMember (seq, name, age, address, tel) values" 
				+ "(%s, '%s', %s, '%s', '%s');\n", seq, name, age, address, tel );
		

		//예제구분 빈라인
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		System.out.printf("문자열: %s\n", "문자열");
		System.out.printf("정수 : %d\n", 10);
		System.out.printf("실수: %f\n", 3.14);
		System.out.printf("문자: %c\n", 'A');
		System.out.printf("논리: %b\n", true);
		
		//System.out.printf("문자열: %d\n", "홍길동"); error.
		//System.out.printf("정수: %s\n", 20); //error안뜸. 형변환 때문에. 다만 에러 안뜬다고 해도 조합 맞추는게 좋음.
		
		
		//예제구분 빈라인
		System.out.println();
		System.out.println();
		
		
		//형식 문자의 확장 기능
		//1. %숫자d
		//-모든 형식 문자에 적용
		//-출력할 너비 지정
		//-(+) : 우측 정렬
		//-(-) : 좌측 정렬
		//-서식 작업에 사용 > 탭 문자와 같이 사용함.
		//-수치o 숫자 : 우측 정렬
		//-수치x 숫자 : 좌측, 우측 아무거나 마음대로
		//-문자열 : 좌측 정렬
		
		int num = 123;
		
		System.out.printf("[%d]\n", num);
		System.out.printf("[%10d]\n", num); // 10칸을 확보하고 그 안에 출력해라
		System.out.printf("[%-10d]\n", num); // 10칸을 확보하고 그 안에 출력해라
		System.out.printf("[%5d]\n", 1234567); //입력하는 수가 칸수보다 많으면 자릿수 무시하고 그냥 출력됨.
		
		//자릿수는 데이터가 남을때만 적용, 데이터가 더 클때는 아무 변화x
		
		
		
		//2. %.숫자f
		//- %f 전용
		//- 소수점 이하 출력 자릿수 지정
		
		double num2 = 3.14;
		System.out.println(num2);
		System.out.printf("%f\n",num2);	//printf가 소수점 6자리까지 출력하는 기능(?)이 있음. 그래서 빈자리는 0
		System.out.printf("%.2f\n",num2);	
		
		System.out.println(10.0/3);
		System.out.printf("%f\n", 10.0/3);
		System.out.printf("%.2f\n", 10.0/3);	//%.nf -> 소수점 뒤 n자리수까지 나옴.
		System.out.printf("%.0f\n", 10.0/3);	//%.0f -> 정수처럼 나옴.
		
		System.out.println();
		
		
		//3. %,d
		//- %d,%f 적용
		//- 천단위 표기(3자리)
		
		int price =1234567;
		
		System.out.printf("금액: %d원\n", price);
		System.out.printf("금액: %,d원\n", price); //%,d -> 3자리마다 컴마
		System.out.println();
		System.out.println();
		
		
		//****숫자 출력시 반드시 !!!! 단위 출력
		System.out.println("======================");
		System.out.println("       음료 가격");
		System.out.println("======================");
		System.out.printf("콜라: \t\t%5d원\n", 2500);
		System.out.printf("스무디: \t\t%5d원\n", 3500);
		System.out.printf("박카스: \t\t%5d원\n", 500);
		System.out.printf("아메리카노: \t%5d원\n", 12000); //가장 긴 12000원이 5자리기 때문에 5d
		
		
		
	}
}





















