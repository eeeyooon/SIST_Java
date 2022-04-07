package com.test.java.obj.question.Class;

public class Q05 {

	public static void main(String[] args) {
		//Q05. Box 클래스와 Macaron 클래스를 설계하시오.
		
		
		Box box = new Box();
		
		box.cook();
		System.out.println();
		box.check();
		System.out.println();
		box.list();
		
	}//main
	
}//Q05

//생산 크기(5cm ~ 15cm) → 판매 유효 크기(8cm ~ 14cm)
//생산 색상(red, blue, yellow, white, pink, purple, green, black) → 판매 유효 색상(black을 제외한 모든 색상)
//생산 샌드 두께(1mm ~ 20mm) → 판매 유효 두께(3mm ~ 18mm)

//-> Box에서 하는 이유.
//-> getter/setter에서는 필요한 유효성 검사외엔 굳이


class Box {
	private Macaron[] list = new Macaron[10];

	public void cook() {
		
		for (int i=0; i<list.length; i++) {
			
			Macaron m = new Macaron();
			
			int n = (int)(Math.random() * 11) + 5; // 5~ 15
			
			m.setSize(n);
			
			String[] color = {"red", "blue", "yellow", "white", "pink", "pubple", "green", "black"};
			
			n = (int)(Math.random() * color.length);
			
			m.setColor(color[n]); // 색상 8개 난수 (배열 방번호 0~7)
			
			n = (int)(Math.random()* 20) + 1;
			
			m.setThickness(n);
			
			
			this.list[i] = m;
			
		}
		
		System.out.println("마카롱을" + list.length + "개 만들었습니다.\n");
		
	}
	
	public void check() {
		
		//QC 합격 개수 / QC 불합격 개수
		
		
		int pass =0;
		int fail = 0;
		
		for (int i=0; i<this.list.length; i++) {
			
			Macaron m = this.list[i];
			
			if (checkMacaron(m)) {
				pass++;
			} else {
				fail++;
			}
			
		}
		
		System.out.printf("[박스 체크 결과]\n"
							+ "QC 합격 개수 : %d개\n"
							+ "QC 불합격 개수 : %d개\n"
							, pass
							, fail);
		
	}
	
	
	private boolean checkMacaron(Macaron m) { //마카롱 판매 유효 체크
		//판매 유효 크기 : 8~14cm
		//판매 유효 색상 : black 제외 전원
		//판매 유효 두께 : 3~18mm
		
		if (m.getSize() < 8 || m.getSize() > 14) {
			return false;
		}
		
		if (m.getColor().equals("black")) {
			return false;
		}
		
		if (m.getThickness() < 3 || m.getThickness() > 18) {
			return false;
		}
		
		return true;
	}

	
	
	public void list() {
		System.out.println("[마카롱 목록]");
		
		for (int i=0; i<this.list.length; i++) {
		
			Macaron m = this.list[i];
			
			System.out.printf("%2d번 마카롱 : %2dcm(%7s, %2dmm) : %3s\n"
								, (i+1)
								, m.getSize()
								, m.getColor()
								, m.getThickness()
								, checkMacaron(m) ? "합격" : "불합격"); //이걸 위해서 체크마카롱을 메소드로 뺀 것.
		}
		
	}
	
	
}

class Macaron {
	
	 private int size;
	 private String color;
	 private int thickness;
	 
	 
	 
	 
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getThickness() {
		return thickness;
	}
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	 
	 
	 
	 
}





















