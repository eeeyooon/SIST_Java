package com.test.java.collection; //04.01과제

public class MySet {

	private int index = 0; //방번호
	private String[] set = new String [4]; //데이터
	
	//순서X, 중복값X
	//모든 요소 출력시 정렬x 상태로 출력
	
	
	public boolean add(String s) {
		//배열에 요소를 추가한다. 
		//s: 추가할 요소    //중복값XX
		
		
		//add -> 선생님 코드
		try {
			if (isDuplicate(s)) {
				return false;
			}
			
			
			if (checkLenth()) {	//방의 크기가 꽉 차면
				doubleList();	//방을 늘려라 (키와 데이터)
			}
			
			this.set[this.index] = s;
			this.index++;
			
			
			return true;	//추가된 요소의 값
		} catch(Exception e) {
			return false;
		}
	}
	
	
	
	private boolean isDuplicate(String s) {	//-> 중복값 코드

		for (int i=0; i<this.index; i++) {
			if (this.set[i].equals(s)) {
				return true;
			}
		}
		return false;
	}

	private void doubleList() {
		
		String[] valueTemp = new String [this.set.length * 2];
		
		for (int i=0; i<this.set.length; i++) {
			valueTemp[i] = this.set[i];
			
		}
		
		this.set = valueTemp;
		
		
		
	}

	private boolean checkLenth() {
		
		if (this.index == this.set.length) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		
		String temp = "";

		temp += "\n";
		temp += String.format("length: %d\n", this.set.length);
		temp += String.format("size: %d\n", this.index);
		temp += String.format("[\n");
		for (int i = 0; i < this.set.length; i++) {
			temp += String.format("   %s: %s\n", this.set[i], this.set[i]);
		}
		temp += String.format("]");
		temp += "\n";

		return temp;
	}


	
	public int size() {
		//요소의 개수를 반환
		
		return this.index; //요소의 개수
	}
	
	

	public String remove(String value) { 	//boolean -> String //선생님코드
		//배열의 요소를 삭제한다.
		//s : 삭제할 요소
		
		int index = -1;
		
		for(int i=0; i<this.index; i++) {
			if (this.set[i].equals(value)) {
				index = i;
				break;
			}
		}
		
		for (int i=index; i<this.set.length-1; i++) {
			this.set[i] = this.set[i+1];
		}
		
		this.index--;
		
		
		return value; 
	}
	
	public void clear() {
		//배열의 모든 요소를 삭제한다.
		
		
		this.index = 0;
		
	}
	
	public boolean hasNext() {	// -> X
		//다음 요소가 있는지 확인한다.
		
		
		return true; //존재 유무
	}
	
	public String next() {		// -> X
		//다음 요소를 반환함
		
		return ""; //다음 요소
	}


}
