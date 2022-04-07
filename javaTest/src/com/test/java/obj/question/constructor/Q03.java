package com.test.java.obj.question.constructor; //03.25 과제 (완료)

public class Q03 {

	public static void main(String[] args) {
		//Q03. 포장하는 직원 객체를 만드시오. 그 직원을 통해 연필, 지우개, 볼펜, 자를 포장하시오.
		
		
		
		//포장하는 직원
		Packer packer = new Packer();

		//연필
		Pencil p1 = new Pencil();
		p1.setHardness("HB");
		packer.packing(p1);
		
		Pencil p2 = new Pencil();
		p2.setHardness("4B");
		packer.packing(p2);
		

		
		//지우개
		Eraser e1 = new Eraser();
		e1.setSize("Large");
		packer.packing(e1);
		
		
		//볼펜
		BallPointPen b1 = new BallPointPen();
		b1.setThickness(0.3);
		b1.setColor("black");
		packer.packing(b1);

		BallPointPen b2 = new BallPointPen();
		b2.setThickness(1.5);
		b2.setColor("red");
		packer.packing(b2);

		//자
		Ruler r1 = new Ruler();
		r1.setLength(30);
		r1.setShape("줄자");
		packer.packing(r1);

		//결과 확인
		packer.countPacking(0);
		packer.countPacking(1);
		packer.countPacking(2);
		packer.countPacking(3);
		packer.countPacking(4);
		
		
		
		
	}//main
}//Q03


class Packer {
	
	
	
	private static int pencilCount;			//연필 포장개수(개)
	private static int eraserCount;			//지우개 포장 개수(개)
	private static int ballPointPenCount;	//볼펜 포장 개수(개)
	private static int rulerCount;			//자 포장 개수(개)
	
	
	public void packing(Pencil pencil) {
		
		pencilCount++; //연필 개수 count
		System.out.println(pencil.info()); //info()출력
		System.out.println("포장을 완료했습니다.");
	}
	
	public void packing(Eraser eraser) {
		eraserCount++;
		System.out.println(eraser.info());
		System.out.println("포장을 완료했습니다.");
	}
	
	public void packing(BallPointPen ballPointPen) {
		ballPointPenCount++;
		System.out.println(ballPointPen.info());
		System.out.println("포장을 완료했습니다.");
	}
	
	public void packing(Ruler ruler) {
		rulerCount++;
		System.out.println(ruler.info());
		System.out.println("포장을 완료했습니다.");
	}
	
	public void countPacking(int type) {	//포장한 내용물의 종류에 따른 개수
		
		if (type > 4) {
			System.out.println("출력할 내용물의 종류 오류");
		}
			System.out.println();
			System.out.println("=====================");
			System.out.println("포장 결과");
			System.out.println("=====================");
			
			switch(type) {
				case 0:
					System.out.printf("연필 %d회\n", pencilCount);
					System.out.printf("지우개 %d회\n", eraserCount);
					System.out.printf("볼펜 %d회\n", ballPointPenCount);
					System.out.printf("자 %d회\n", rulerCount);
					System.out.println();//공백
					break;
				case 1:
					System.out.printf("연필 %d회\n", pencilCount);
					System.out.println();//공백
					break;
				case 2:
					System.out.printf("지우개 %d회\n", eraserCount);
					System.out.println();//공백
					break;
				case 3:
					System.out.printf("볼펜 %d회\n", ballPointPenCount);
					System.out.println();//공백
					break;
				case 4:
					System.out.printf("자 %d회\n", rulerCount);
					System.out.println();//공백
					break;
					
			}
		
	}
	

} //Packer


class Pencil {
	
	private String hardness;
	
	
	public void setHardness(String hardness) {
		
		if (hardness.equals("4B")
			|| hardness.equals("3B")
			|| hardness.equals("2B")
			|| hardness.equals("B")
			|| hardness.equals("HB")
			|| hardness.equals("H")
			|| hardness.equals("2H")
			|| hardness.equals("3H")
			|| hardness.equals("4H")) {
			
			this.hardness = hardness;
		} else {
			System.out.println("흑연 등급 오류");
		}
		
	}
	
	public String info() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("포장 전 검수 : %s 진하기 연필입니다.", this.hardness));
		
		return sb.toString();
		
	}
	
	
} //Pencil


class Eraser {
	
	private String size;
	
	
	
	public void setSize(String size) {
		if (size.equals("Large")  || size.equals("Medium") || size.equals("Small")) {
			this.size = size;
		} else {
			System.out.println("지우개 크기 오류");
		}
	}
	
	public String info() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("포장 전 검수 : %s 사이즈 지우개입니다.", this.size));
		
		return sb.toString();
		
	}
	

} //Eraser




class BallPointPen {
	
	
	private double thickness;
	private String color;
	


	public void setThickness(double thickness) {
		if (thickness == 0.3 || thickness == 0.5
			|| thickness == 0.7 || thickness ==1 || thickness ==1.5) {
			
			this.thickness = thickness;
			
		} else {
			System.out.println("볼펜 심 두께 오류");
		}
	}
	
	
	public void setColor(String color) {
		if (color.equals("red") || color.equals("blue")
				|| color.equals("green")  || color.equals("black")) {
			this.color = color;
		} else {
			System.out.println("볼펜 색상 오류");
		}
	}
	
	
	public String info() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("포장 전 검수 : %s 색상 %.1fmm 볼펜입니다.", this.color, this.thickness));
		//double이니까 %f (주의)
		return sb.toString();
		
		
	}
	
} //BallPointPen



class Ruler {
	
	private int length;
	private String shape;
	
	
	
	public void setLength(int length) {
		if (length == 30 || length == 50 || length == 100) {
			this.length = length;
		} else {
			System.out.println("자 길이 오류");
		}
	}

	
	
	public void setShape(String shape) {
		if (shape.equals("줄자") || shape.equals("운형자") || shape.equals("삼각자")) {
			this.shape = shape;
		} else {
			System.out.println("자 형태 오류");
		}
	}
	
	
	public String info() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("포장 전 검수 : %dcm %s입니다.", this.length, this.shape));
		
		return sb.toString();
		
	}

	
} //Ruler

















