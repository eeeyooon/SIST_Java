package com.test.java.obj.question.Class; //03.24과제 (완료)

public class Q01 {

	public static void main(String[] args) {
		//Q01. Book
		
		
		Book b1 = new Book();
		
		b1.setTitle("자바의 정석");
		b1.setPrice(45000);
		b1.setAuthor("남궁성");
		b1.setPublisher("도우출판");
		b1.setIsbn("8994492038");
		b1.setPage(1022);
		
		System.out.println(b1.info());
		
		
	}//main
	
}//Q01


/*

제목 : 읽기/쓰기, 최대 50자 이내 (한글, 영어, 숫자)
가격 : 읽기/쓰기, 0 ~ 1000000원
저자 : 읽기/쓰기, 제한없음(유효성 검사x)
페이지수 : 읽기/쓰기, 1~무제한
출판사 : 쓰기 전용 	> Setter만
발행년도 : 읽기 전용(2019년) > getter만
ISBN : 읽기/쓰기


*/


class Book {
	
	private String title;
	private int price;
	private String author;
	private String publisher; //출판사는 쓰기전용
	private String pubYear = "2019년"; //읽기전용
	private String isbn;
	private int page;
	
	
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		
		if (checkTitle(title)) {
			this.title = title;
		} else {
			System.out.println("제목이 올바르지 않습니다.");
		}
	}
	

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {	//가격 유효성 검사
		if (0 <= price && price <= 1000000) {
		this.price = price;
		} else {
			System.out.println("가격 오류");
		}
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) { //페이지 수 유효성 검사 > 1~무제한
		if (page > 0) {
		this.page = page;
		} else {
			System.out.println("페이지 오류");
		}
	}
	
	public String getPubYear() {
		return pubYear;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	
	//객체 메소드
	private boolean checkTitle(String title) { //제목 유효성 검사 > 50자 이내, 한글/영어/숫자만
		
//		if (title.length() < 50) {
//		
//			for (int i=0; i<title.length(); i++) {
//				char ch = title.charAt(i);
//				if (ch >= '가' && ch <= '힣'
//					|| ch >= 'a' && ch <= 'z'
//					|| ch >= 'A' && ch <= 'Z'
//					|| ch >= '0' && ch <= '9') {
//					return true;
//				}
//			}
//		
//		}
//		
//		return false;
		
		if (title.length() > 50) {
			return false;
		}
		for(int i=0; i<title.length(); i++) {
			
			char c = title.charAt(i);
			
			if ((c < '가' || c > '힣') 
					&& (c < 'A' || c > 'Z')
					&&  (c < 'a' || c > 'z') 
					&& (c < '0' || c > '9')
					&& (c != ' ')) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public String info() {
		
//		String result = "";
//		
//		result = "제목: " + this.getTitle() + "\n" + "가격: " + this.getPrice() + "원\n" +
//				 "저자: " + this.getAuthor() + "\n" + "출판사: " + this.publisher + "\n" +
//				 "발행년도: " + this.getPubYear() + "\n" + "ISBN: " + this.getIsbn() + "\n" +
//				 "페이지: " + this.getPage() + "장\n";
//		
//		//TODO class Q01 질문 (2022. 3. 24. 오후 12:06:41)
//		// String result에 어떻게 this.getPrice()가 저장되는지.. 얘 타입은 int아닌가? 그런거 상관없나? getter는?
//		// String type으로 반환하는데 ','를 넣을 수 있는지.. (printf를 안쓰고 %, 쓰는 방법이 있나?)
//		// 문자열 더하기에는 컴마는 어떻게?
//		
//		return result;
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("제목: " + this.title);
		sb.append("\r\n");
		sb.append(String.format("가격: %,d원", this.price));
		sb.append("\r\n");
		sb.append("저자: " + this.author);
		sb.append("\r\n");
		sb.append("출판사: " + this.publisher);
		sb.append("\r\n");
		sb.append(String.format("발행년도: %s년", this.pubYear));
		sb.append("\r\n");
		sb.append("ISBN: " + this.isbn);
		sb.append("\r\n");
		sb.append(String.format("페이지: %,d장", this.page));
		
		return sb.toString(); // StringBuilder를 String으로 바꿔줌.
	}
	
	
}







