package com.test.java.collection; //04.01 과제 (완료)

import java.util.EmptyStackException;

public class MyStack {
	
	private String[] list; 
	private int index; 
	
	public MyStack() {
		this.index = 0;
	}
	
	
	public boolean push(String value) {
		//값을 순차적으로 추가
		
		//값을 넣을때마다 방 늘리기
		//1. 처음 값을 넣을 때 하나짜리 배열 생성
			//1.2 값을 하나 넣을때마다 기존 배열보다 1 더 큰 배열 생성하기
		//2. 데이터 저장하기
		
		firstInt();
		
		if (checkLength()) {
			doubleList();
		}
		
		this.list[this.index] = value;
		this.index++;
		
		
		
		return true; //성공 유무
	}
	
	private void doubleList() { //
		
		String [] temp = new String[this.list.length + 1]; //기존 배열보다 1 더 큰 배열 생성
		
		for (int i=0; i<this.list.length; i++) { 
			temp[i] = this.list[i];
		}
		
		this.list = temp;
		
	}


	private boolean checkLength() { //방이 꽉찼는지
		
		if (this.list.length == this.index) {
			return true;
		}
		
		return false;
	}


	private void firstInt() {
		
		//처음 값을 넣을때 1칸짜리 배열 생성
		if (this.index == 0) {
			list = new String[1];
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

	public String pop() {
		//값을 순차적으로 가져옴. (읽고 삭제함)
		
		//1. 가장 마지막 숫자 복사
		//2. 가장 마지막 숫자 삭제
			//2.2 데이터가 없는데 pop을 할경우 error -> EmptyStackException
		//3. 복사한 가장 마지막 숫자 반환

		
		//EmptyStackException
		if(this.index == 0 ) {
			throw new EmptyStackException();
		}
		
		String remove_value = this.list[this.index-1];
		this.index--;
		this.list[this.index] = null;
		
		return remove_value;
		
		
	}
	
	public int size() {
		//요소의 개수 반환
		
		
		
		return this.index;	//요소의 개수
	}
	
	public String peek() {
		//가져올 값을 확인한다.
		//데이터가 없을때 peek하면 error -> EmptyStackException
		
		if (this.index == 0) {
			throw new EmptyStackException();
		}
		
		return this.list[this.index-1]; //값 반환
	}
	
	public void clear() {
		//배열 안의 모든 요소를 삭제한다.
		
		this.index = 0;
		
	}
	
	public void trimToSize() {
		//배열안의 요소의 개수만큼 배열의 길이를 줄인다.
		
		String[] temp = new String[this.index]; 
		
		for (int i=0; i<this.index; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;
		
		
	}

	
} // MyStack










































