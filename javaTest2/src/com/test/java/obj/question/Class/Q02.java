package com.test.java.obj.question.Class; //03.24과제 (완료)

public class Q02 {

	public static void main(String[] args) {
		//Q02. Note
		
		
		Note note = new Note ();
		
		note.setSize("a5");
		note.setColor("흰색");
		note.setPage(10);
		note.setOwner("홍길동");
	
		System.out.println(note.info());
		
	}//main
}//Q02



class Note {
	private String size;
	private String color;
	private String page; //int에서 string으로 ****
	private String owner;
	private int price; //setter getter 구현 x
	
	
	
	
	public void setSize(String size) { // 사이즈 유효성 검사
		
		size = size.toUpperCase();	//대문자로 입력하든 소문자로 입력하든 상관없이
		if (size.equals("A3")
			|| size.equals("A4")
			|| size.equals("A5")
			|| size.equals("B3")
			|| size.equals("B4")
			|| size.equals("B5")) {
		this.size = size;
		} else {
			System.out.println("존재하지 않는 크기입니다.");
		}
	}
	
	
	
	public void setColor(String color) { // 색상 유효성 검사
		
		if (color.equals("검정색")
				|| color.equals("흰색")
				|| color.equals("노란색")
				|| color.equals("파란색")) {
			this.color = color;	
		} else {
			System.out.println("존재하지 않는 색상입니다.");
		}
	}
	
	

	
	public void setPage(int page) { // 메소드로 해보자
		
		
		
		if (checkPage(page).equals("얇은")) {
			this.page = "얇은" ;
		} else if (checkPage(page).equals("보통")) {
			this.page = "보통"; 
		} else if (checkPage(page).equals("두꺼운")) {

			this.page = "두꺼운";
		} else {
			System.out.println("페이지수는 1~200페이지 이내입니다.");
		}
		
		
	}
	
	
	


	public void setOwner(String owner) { //소유자 유효성 검사 > 한글로 2~5자이내
		if (checkOwner(owner)) {
			this.owner = owner;
		}
	}	
	
	
	private boolean checkOwner(String owner) { //소유자 유효성 검사
		
		if (owner.length() < 2 || owner.length() > 5) {
			return false;
		}
		
		for (int i=0; i<owner.length(); i++) {
			char ch = owner.charAt(i);
			
			if (ch < '가' || ch > '힣') {
				return false;
			}
			
		}
		
		return true;
	}

	
	private String checkPage(int page) { //int -> String으로 바꿈.
		
		this.price = 500;
		
		if(10 <= page && page <= 200) {
			this.price += (page-10) * 10;
			
			if (page <= 50 ) {
				return "얇은";
			} else if (51 <= page && page <=100) {
				return "보통"; 
			} else {
				return "두꺼운";
			}
		
		}
		
		return "";
		
	}

	

	//객체 메소드
	
	public String info() {
		
		
		
		
		
		switch(this.color) {
			case "흰색":
				break;
			case "검정색":
				this.price += 100;
				break;
			case "노란색":
				this.price += 200;
				break;
			case "파란색":
				this.price += 200;
				break;
		}
		
		switch(this.size) {
			case "A5":
				break;
			case "A3":
				this.price += 400;
				break;
			case "A4":
				this.price += 200;
				break;
			case "B3":
				this.price += 500;
				break;
			case "B4":
				this.price += 300;
				break;
			case "B5":
				this.price += 100;
				break;	
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		if (owner != null) { //소유자가 있는 경우
			
			
		sb.append("■ ■ ■ ■ ■ 노트 정보 ■ ■ ■ ■ ■\n");
		sb.append("소유자: " + this.owner);
		sb.append("\r\n");
		sb.append("특성: " + this.color + " " + this.page + " " + this.size + "노트");
		sb.append("\r\n");
		sb.append(String.format("가격: %,d원", this.price));
		sb.append("\r\n");
		sb.append("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■\n");
		
		return sb.toString();
		
	} else { //소유자가 없는 경우
		
		sb.append("■ ■ ■ ■ ■ 노트 정보 ■ ■ ■ ■ ■\n");
		sb.append("주인 없는 노트");
		sb.append("\r\n");
		sb.append("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■\n");
		
		return sb.toString();
	}
}
	
	
	
	
	
	
}
