package com.test.java.obj.question.Class; //(완료)

public class Q04 {

	public static void main(String[] args) {
		// Q04. 직원(Employee) 클래스를 설계하시오.
		
		// 연락처 유효성 검사 다시 *******
		
		
		Employee e1 = new Employee();

		e1.setName("홍길동");
		e1.setDepartment("홍보부");
		e1.setPosition("대리");
		e1.setTel("010-1234-5678");
		e1.setBoss(null);
		
		e1.info();
		
		
		Employee e2 = new Employee();

		e2.setName("아무개");
		e2.setDepartment("홍보부");
		e2.setPosition("사원");
		e2.setTel("010-2541-8569");
		e2.setBoss(e1); //직속 상사 e1(홍길동)

		e2.info();
		

		
	}// main

}// Q04


class Employee {
	
	private String name;
	private String department;
	private String position;
	private String tel;
	
	
	private Employee boss;
	
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) { //유효성 검사
		if (checkName(name)) {
			this.name = name;
		} else {
			System.out.println("이름 오류");
		}
	}
	

	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) { //부서 유효성 검사
		if (department == "영업부" 
			|| department == "기획부"
			|| department == "총무부"
			|| department == "개발부"
			|| department == "홍보부") {
			
			this.department = department;
		} else {
			System.out.println("부서 오류");
		}
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) { //직책 유효성 검사
		if (position == "부장"
			|| position == "과장"
			|| position == "대리"
			|| position == "사원"	) {
			
			this.position = position;
		} else {
			System.out.println("직책 오류");
		}
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		if (checkTel(tel)) {
			this.tel = tel;
		} else {
			System.out.println("연락처 오류");
		}
	}
	
	

	public Employee getBoss() {
		
		return boss;
		
	}

	public void setBoss(Employee boss) {
		
		if (boss != null) {
			if (this.department.equals(boss.getDepartment())) { //같은 부서인지 유효성 검사
				this.boss = boss;
			} else {
				System.out.println("직속상사 오류");
			}
		} else { //따로 null 지정 안해도 이미 null이니까 굳이 지정 안해도 됨
			this.boss = null;
		}
	}
	


	private boolean checkName(String name) { //이름 유효성 검사 > 한글, 2~5자이내
		
		if (name.length() < 2 || name.length() >5) {
			return false;
		}
		
		for (int i=0; i<name.length(); i++) {
			char ch = name.charAt(i);
			if (ch < '가' || ch > '힣') {
				return false;
			}
		}
		
		
		return true;
	}
	
	private boolean checkTel(String tel) { //연락처 유효성 검사
		
		
		tel = tel.replace("-", "");
		
		if (tel.length() == 11) {
			if (tel.startsWith("010")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
}
	

	
	public void info() {
			
			//boss가 null이 아닐때
		if (boss != null) {	
			System.out.printf("[%s]\n", this.name);
			System.out.printf("- 부서: %s\n", this.department);
			System.out.printf("- 직위: %s\n", this.position);
			System.out.printf("- 연락처: %s\n", this.tel);
			String bossInfo = String.format("- 직속상사: %s(%s %s)\n", boss.getName(), boss.getDepartment(), boss.getPosition());
			System.out.println(bossInfo);
			System.out.println();
			
			
//			System.out.printf("- 직속상사: %s(%s %s)\n",
//								this.boss.name, this.boss.department, this.boss.position);
			
			//boss가 null일때 > 직속상사 없음	
		} else { 
			System.out.printf("[%s]\n", this.name);
			System.out.printf("- 부서: %s\n", this.department);
			System.out.printf("- 직위: %s\n", this.position);
			System.out.printf("- 연락처: %s\n", this.tel);
			System.out.println("- 직속상사: 없음.");
			System.out.println();
		}
	}
	
	
	
	
}


