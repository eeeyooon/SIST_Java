package com.test.java.collection; //04.01 과제 (완료)


public class MyQueue {

	
	private String[] list; 
	private int index; 
	
	
	
	public MyQueue() {
		this.index = 0;
	}
	
	public boolean add(String value) {
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
	
	
	
	public String poll() {
		//값을 순차적으로 가져옴. (읽고 삭제함)
		
		//1. 가장 첫번째 숫자 복사
		//2. 가장 첫번째 숫자 삭제
			//2.2 데이터가 없을 땐 null
		//3. 복사한 가장 첫번째 숫자 반환

		
		if(this.index == 0 ) {
			return null;
		}
		
		String remove_value = this.list[0];
		for (int i=0; i<this.index-1; i++) {
			this.list[i] = this.list[i+1];
		}
		this.index--;
		this.list[this.index] = null;
		
		return remove_value;
	}
	
	
	
	public int size() {
		//요소의 개수를 반환한다.
		
		return this.index; //요소의 개수를 반환한다.
		
	}
	
	public String peek() {
		//이번에 가져올 값을 확인한다.
		//데이터가 없을땐 null 반환
		
		if (this.index == 0) {
			return null;
		}
		
		return this.list[0]; // 값 반환
	}
	
	
	
	public void trimToSize() {
		//배열 안의 요소의 개수만큼 배열의 길이를 줄인다. 
		
		String[] temp = new String[this.index]; 
		
		for (int i=0; i<this.index; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;
	}
	
	
	public void clear() {
		//배열의 모든 요소를 삭제한다.
		
		 this.index = 0;
		
	}
	
	
}






















