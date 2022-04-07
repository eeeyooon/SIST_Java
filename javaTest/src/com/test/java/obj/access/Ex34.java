package com.test.java.obj.access; //03.24

import java.util.Calendar;

public class Ex34 {

	public static void main(String[] args) {
		
		//Ex34.java
		
		/*
			1. Person 클래스 정의
				- 이름
				- 나이
				- 성별
				- 생일 (**)
				- 아빠 (**)
				- 엄마 (**)
			2. 몇명의 Person 객체 생성
				
		
		*/
		
		Person father = new Person();
		father.setName("홍기철");
		father.setAge(50);
		father.setGender("m");
		father.setBirthday(1965, 5, 10);
		
		Person mother = new Person();
		mother.setName("호호호");
		mother.setAge(46);
		mother.setGender("f");
		mother.setBirthday(1969, 8, 20);
		
		
		Person hong = new Person();
		
		hong.setName("홍길동");
		hong.setAge(20);
		hong.setGender("m");
		
		//b. 생일
//		Calendar birthday = Calendar.getInstance();
//		birthday.set(1995, 2, 24);	//참조형 나머지 애들은 오브젝트로 만들어서 넣어줘야해
//		hong.setBirthday(birthday); //매개변수로 전달
		
		//c. b를 이렇게 고친 것 (클래스 내부로 캘린더를 옮기면서)
		
		
		hong.setBirthday(1995, 3, 24);
		System.out.println(hong.getBirthday());
		
		//자식객체가 부모객체 지정 > 관계설정
		hong.setFather(father);
		hong.setMother(mother);
		
		//d.먼저 태어나는 객체는 후에 태어나는 객체를 모르기때문에 관계지정을 할 수 없음.
		//그러니까 부모객체는 자식객체를 지정할 수 없지만 자식 객체는 만들어졌을 때 이미 부모객체가
		//존재하기 때문에 자식객체가 먼저 태어난 객체를 부모객체로 지정함. (관계지정은 뒤에 만들어진 객체만 가능)
		
		hong.hello();
		hong.info();
		
		
		
	}//main
	
}//E34

class Person {
	

	//클래스(객체)의 멤버 변수
	//- 멤버 변수
	//- 필드
	//- 상태
	//- (객체) 데이터			//도메인(Domain) 정의 > 업무 지식
	private String name;	//이름 : 한글 2~5자 이내
	private int age;		//나이 : 0살 ~ 140살
	private String gender;	//성별 : m, f
	
	private Calendar birthday; 	//생일
	private Person father;		//아빠 ->person 타입의 객체를 넣을 수 있는 변
	private Person mother;		//엄마
	
	
	//엄마
	
	//클래스 멤버 메소드
	//- 객체의 행동 > 객체가 가지는 데이터를 활용해서 행동 (객체 자신의 데이터) > 메소드 안의 코드를 실행시키니까 = 행동
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		
		if (checkName(name)) {	//이름 유효성 검사는 길어서 밑으로
		this.name = name;
		}
	}
	

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if (age >= 0 && age <=140) {
			this.age = age;
		} else {
			System.out.println("올바르지 않은 나이입니다.");
		}
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		if (gender.equals("m") || gender.equals("f")) {
			this.gender = gender;
		} else {
			System.out.println("올바르지 않은 성별입니다.");
		}
	}

//d. 이번엔 getter도 만들자	
//	public Calendar getBirthday() {
//		return birthday;
//	}
	
	public String getBirthday() {
		return String.format("%tF", this.birthday);
		
	}
	
	
//b.
//	public void setBrithday(Calendar brithday) {
//		this.brithday = brithday;
//	}
	// >  이건 사용자 입장에서 캘린더 하나 쓰자고 캘린더 새로 만들기가 넘 귀찮고 번거로움
	
	
	//c. setter만 다시 만들거야
	// > 그래서 사용자가 아닌 클래스 내부에서 만들도록 위치변경. 이렇게하면 사용자는 새로 만들 필요는 없음.
	public void setBirthday(int year, int month, int date) {
		
		Calendar birthday = Calendar.getInstance();
		birthday.set(year, month-1, date);
		
		this.birthday = birthday;
		
	}
	
	
	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public Person getMother() {
		return mother;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	
	
	
	
	private boolean checkName(String name) { //이름 유효성검사 : 2~5자이내, 한글로만
		if (name.length() < 2 || name.length() > 5) {
			
			return false;
		}
		
		for (int i=0; i<name.length(); i++) {
			char c = name.charAt(i);
			if (c < '가' || c > '힣') {
				
				return false;
			}
			
		}
		
		return true;
	}
	
	//인사하는 메소드
	
	public void hello() {
		System.out.printf("안녕하세요. 저는 %s입니다.\n", this.name);
	}
	
	
	//자기소개하는 메소드
	
	public void info() {
		System.out.printf("반갑습니다. 저는 %s이고요. %d살입니다.\n생일은 %tF입니다.\n아빠는 %s이고, 나이는 %d살이고, 생일은 %s입니다.\n엄마는 %s이고, 나이는 %d살, 생일은 %s입니다.\n" 
								, this.gender.equals("m") ? "남자" : "여자"
								, this.age
								, this.birthday
								, this.father.getName()
								, this.father.getAge()
								, this.father.getBirthday()
								, this.mother.getName()
								, this.mother.getAge()
								, this.mother.getBirthday());
							//같은 클래스 내라도 직접 변수를 가져오지말고 get변수로 가져와
		
		//TODO getAge 질문 완료 (2022. 3. 24. 오전 10:38:55)
		// 강사님은 getAge안된다고 했는데 왜..? 되는데..? >> 된대! 말 꼬이신거래!
	}


	
	
	
}
























