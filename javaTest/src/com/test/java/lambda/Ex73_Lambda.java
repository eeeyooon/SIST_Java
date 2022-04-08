package com.test.java.lambda; //04.08

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Ex73_Lambda {

	public static void main(String[] args) {
		
		//Ex73_Lambda
		
		//익명 객체 활용하는 곳 > 람다식 활용하는 곳
		
		
		Random rnd = new Random();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for (int i=0; i<10; i++) {
			nums.add(rnd.nextInt(20) + 1); //1~20 사이의 값
		}
		
		System.out.println(nums);
		
		
		//오름차순 정렬
		
		nums.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1 - o2; //오름차순
			}
			
		});
		
		System.out.println(nums);
		
		
		//이제 이걸 람다식으로 바꿀것 
		
		nums.sort((Integer o1, Integer o2) -> {
			
			return o1-o2;
			
		});
		
		//최종 
		nums.sort((o1, o2) -> o2-o1); //중괄호를 생략하면 return도 반드시 생략해야 해 //내림차순
		
		System.out.println(nums);
		
		
		
		try {
			
			
			BufferedReader reader = new BufferedReader(new FileReader("data\\user.txt"));
			ArrayList<User> list = new ArrayList<User>();
			
			String line = null;
			
			
			//Java > Data Type > Strong Type > == 엄격한 자료형 사용(형변환 필수)
			//나머지 > Weak Type > 유연한 자료형 사용
			
			while ((line = reader.readLine()) != null) {
				
				String [] temp = line.split(",");
				String [] ctemp = temp[4].split("-"); //2022-01-01
				
				Calendar c = Calendar.getInstance();
				c.set(Integer.parseInt(ctemp[0]),
					  Integer.parseInt(ctemp[1]),
					  Integer.parseInt(ctemp[2]));
				
				User user = new User(temp[0],
									 temp[1],
									 Integer.parseInt(temp[2]),
									 temp[3],
									 c);
			
				list.add(user);//**** 다 하고 나면 상자에 담아야지
			}
			
			
			System.out.println(list);
			
			
			
			//8명의 사람, 즉 8개의 객체가 존재함 > 이걸 정렬해보자
			
			Collections.sort(nums);
			//얜 에러 x //ArrayList<Integer>
			
			//Collections.sort(list); //얜 배열만 넣어도 되고 원하면 컴패어도 넣을 수 있음.
			//얜 에러	 //ArrayList<User>
			
			//why?
			//>> 'list'를 정렬하기엔 비교 기준을 알 수 없음. -> 명확한 기준을 함께 제시해야 함.
			
			
			list.sort(new Comparator<User>() {

				@Override
				public int compare(User o1, User o2) {
					return o1.getAge() - o2.getAge();	//나이순 정렬
				}
							
			});
			
			
			System.out.println(list);
			
			//**Comparator 쓸줄 알아야해
			
			System.out.println();
			
			//모르겠으면 일단 외워
			//TODO Comparator 람다식 (2022. 4. 8. 오후 2:42:59)
			
			//객체배열 > 숫자 필드 정렬
			list.sort((u1, u2) -> u2.getAge() - u1.getAge()); //나이순 역순 정렬
			System.out.println(list);
			
			
			//객체배열 > 문자열 멤버 정렬
			list.sort((u1, u2) -> u1.getName().compareTo(u2.getName())); //이름 정렬
			System.out.println(list);
			
			
			//객체배열 > 날짜 멤버 정렬
			
			
			list.sort((u1, u2) -> u1.getHireDate().compareTo(u2.getHireDate())); //경력순 정렬
			//틱값으로도 비교할수있지만 여러 문제가능성때문에 이 역시 컴패어투로 비교해
			
			
			System.out.println(list);
			System.out.println();
			
			//객체배열 > 직급별 정렬 (부장 > 차장 > 과장 > 대리 > 사원)
			
			list.sort((u1, u2) -> u1.getPosition().compareTo(u2.getPosition())) ; //이러면 가나다순 정렬
			System.out.println(list); //직급순이 아닌 가나다 순으로 정렬되어버림.
			System.out.println();
			
			
			//이건 개노가다 > 한번 보여줄게
			list.sort((u1, u2) -> {
				if (u1.getPosition().equals("부장") && u2.getPosition().equals("차장")) {
					//앞에거가 크고 뒤에거가 작으면 그대로 둠.
					return -1; //앞사람이 크면 -1 리턴 == 자리바꾸지마세요
				} else if (u1.getPosition().equals("부장") && u2.getPosition().equals("과장")) {
					return -1;
				} else if (u1.getPosition().equals("부장") && u2.getPosition().equals("대리")) {
					return -1;
				} else if (u1.getPosition().equals("부장") && u2.getPosition().equals("사원")) {
					return -1;
				} else if (u1.getPosition().equals("차장") && u2.getPosition().equals("부장")) {
					return 1;
				} else if (u1.getPosition().equals("차장") && u2.getPosition().equals("과장")) {
					return -1;
				} else if (u1.getPosition().equals("차장") && u2.getPosition().equals("대리")) {
					return -1;
				} else if (u1.getPosition().equals("차장") && u2.getPosition().equals("사원")) {
					return -1;
				} else if (u1.getPosition().equals("과장") && u2.getPosition().equals("부장")) {
					return 1;
				} else if (u1.getPosition().equals("과장") && u2.getPosition().equals("차장")) {
					return 1;
				} else if (u1.getPosition().equals("과장") && u2.getPosition().equals("대리")) {
					return -1;
				} else if (u1.getPosition().equals("과장") && u2.getPosition().equals("사원")) {
					return -1;
				} else if (u1.getPosition().equals("대리") && u2.getPosition().equals("부장")) {
					return 1;
				} else if (u1.getPosition().equals("대리") && u2.getPosition().equals("차장")) {
					return 1;
				} else if (u1.getPosition().equals("대리") && u2.getPosition().equals("과장")) {
					return 1;
				} else if (u1.getPosition().equals("대리") && u2.getPosition().equals("사원")) {
					return -1;
				} else if (u1.getPosition().equals("사원") && u2.getPosition().equals("부장")) {
					return 1;
				} else if (u1.getPosition().equals("사원") && u2.getPosition().equals("차장")) {
					return 1;
				} else if (u1.getPosition().equals("사원") && u2.getPosition().equals("과장")) {
					return 1;
				} else if (u1.getPosition().equals("사원") && u2.getPosition().equals("대리")) {
					return 1;
				} else {
					return 0;
				}
				
			}) ; 
			
			
			System.out.println(list); 
			System.out.println();
			
			
			
		} catch (Exception e) {
			System.out.println("Ex73_Lambda.main");
			e.printStackTrace();
		}
		
		
		
		
		
		
	}//main
	
}//Ex73



//user데이터 담을 컨테이너
//1,홍길동,25,사원,2011-02-05
class User {
	
	//생성자, Getter&Setter, toString
	
	private String seq;
	private String name;
	private int age;
	private String position;
	private Calendar hireDate; //고용날짜 
	
	
	//생성자 자동생성
	public User(String seq, String name, int age, String position, Calendar hireDate) {
		super();
		this.seq = seq;
		this.name = name;
		this.age = age;
		this.position = position;
		this.hireDate = hireDate;
	}


	public String getSeq() {
		return seq;
	}


	public void setSeq(String seq) {
		this.seq = seq;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public Calendar getHireDate() {
		return hireDate;
	}


	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}


	@Override
	public String toString() {
		return String.format("User [seq=%s, name=%s, age=%s, position=%s, hireDate=%tF]\n", seq, name,
				age, position, hireDate);
	}

	//hireDate = %s를 -> %tF로 바꿔주기
	//toString자동생성할때 코드 스타일을 String.format으로 해주면 자동으로 String format해줌
	
	

	
	
}


















