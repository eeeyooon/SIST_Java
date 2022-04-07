package com.test.java.collection; //03.31

import java.util.Arrays;

// ArrayList와 동일한 동작을 하는 클래스를 선언하시오.
// 모든 기능의 디테일은 > 실제 ArrayList와 비교해봐라



public class MyArrayList { // 제네릭말고 일반클래스로 만들어

	private String[] list; // ArrayList의 내부 배열(*****)
	private int index; // ****가장 중요


	public MyArrayList() {
		this.index = 0;

		

	}


	// "홍길동"은 0번방에.
	// "아무개"는 1번방에 > 집어 넣을때마다 방번호 증가시켜줘 >> int index를 방번호로

	// list.add("홍길동") 
	public boolean add(String s) {

		//배열의 끝에 아이템 넣기
		//1. 처음 넣을 때 배열 만들기  > O
		//	1.2 방이 모자라면 배열을 2배로 늘리기
		//2. 데이터 넣기
		
		
		try {
			init();
			
				//1.2
			if (checkLength()) { 
				doubleList();	 
			}
			
			
			this.list[this.index] = s;
			this.index++; 				
		
				return true;
			} catch (Exception e) {		
				
				return false;
				
			}
		
	}
	
	private void doubleList() {
		
	
		
		
		String[] temp = new String[this.list.length * 2]; //현재 배열의 길이의 2배
		
		for (int i=0; i<this.list.length; i++) { 
			temp[i] = this.list[i];
		}
		
		this.list = temp;
		
		
	}


	private boolean checkLength() {
		
		//방이 꽉찼는지?
		if (this.index == this.list.length) { 
			 return true;
		}
		
		return false;
	}

	private void init() {
		
		//처음 넣을 때 배열만들기
		
		if (this.index == 0) {	
			this.list = new String[4];
		}
	}
	
	
	@Override
		public String toString() {
			
		//객체의 상태의 확인하는 용도
		// > 되도록 상황에 따라 보기좋게 구 현

		String temp = "";
		
		temp += "\r\n";
		temp += String.format("length: %d\n", this.list.length); //배열의 실제 길이
		temp += String.format("index: %d\n", this.index);	//현재 방번호
		temp += String.format("[\n");
		
		for (int i=0; i<this.list.length; i++) {
			temp += String.format("  %d: %s \n", i, this.list[i]);
		}
		
		temp += String.format("\n]\n");
		
		return temp;
		
		}
		


	// 없는 방번호를 요청했을때 반응은 ? >> error 메세지 
	public String get(int index) {
		// 원하는 위치에 있는 요소를 가져온다.
		if (!checkIndex(index)) {	//올바른 인덱스인지 검사
			//잘못된 방번호
			throw new IndexOutOfBoundsException();	
		}
		
		return this.list[index];


	}

	private boolean checkIndex(int index2) {
		
		//유효한 index의 범위?
		//0 ~ (index - 1)
		
		if (this.index >= 0 && index < this.index) {
			return true;
		}
		
		return false;
	}


	public int size() {
		// 요소의 개수를 반환한다.

		return this.index; // 요소의 개수

	}

	public String set(int index, String value) {
		// 원하는 위치의 요소를 다른 값으로 수정한다.

		
		String temp = this.list[index];
		
		this.list[index] = value;
		
		return temp; //수정전 요소의 값
		
	}

	public String remove(int index) {
		// 원하는 위치의 요소를 삭제한다. >> Left Shift

		String temp = this.list[index];

		for (int i = index; i < this.list.length-1; i++) {

			this.list[i] = this.list[i + 1]; // 앞으로 당기기

		}
		
		//데이터를 지우면 인덱스에도 반영 *****
		this.index--;
		
		return temp; // 삭제된 요소의 값
	}


	public boolean add(int index, String value) {
		// Insert모드로 원하는 위치에 요소를 삽입한다.  Right Shift


		
		try {
			
			if (checkLength()) { //방이 꽉찼는가? true면
				doubleList();	 //방을 늘려라
			} //안해주면 계속 데이터가 추가되다가 마지막자리에 있는 데이터들이 삭제됨.(밀려나서)
			
			for (int i = this.list.length - 1; i > index; i--) {
				this.list[i] = this.list[i - 1];		
			}
			
			this.index++;
			this.list[index] = value;
			
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
		


	}

	public int indexOf(String value) {
		// 원하는 요소가 몇번째 위치에 있는지 위치값을 반환한다.
		// value = 검색할 요소의 값

		for (int i = 0; i < this.index; i++) {	
			if (this.list[i].equals(value)) {
				return i; //찾았을때 방번호
			}
		}

		return -1; //못찾았을때


	}

	public int lastIndexOf(String value) {
		// -원하는 요소가 몇번째 위치에 있는지 위치값을 반환한다. (뒤에서부터 검색)
		// -value : 검색할 요소의 값

		for (int i = this.index-1; i > 0; i--) {
			if (this.list[i].equals(value)) {
				return i;
			}
		}

		return -1; // 검색된 요소의 위치
	}

	public void clear() {
		// -배열의 모든 요소를 삭제한다.
	
		this.index = 0; 

	}

	public void trimToSize() {
		// -배열안의 요소의 개수만큼 배열의 길이를 줄인다.
		
		String[] temp = new String[this.index]; 
		
		for (int i=0; i<this.index; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;

		


	}


} // MyArrayList


