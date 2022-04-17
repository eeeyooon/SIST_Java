package com.test.java.collection; //04.01과제

public class MyHashMap {

	private int index = 0;
	private String[] key = new String [4];  //키
	private String[] value = new String [4]; //데이터
	
	
	
	public String put(String key, String value) {	//'수정'시 코드 오류.. 
		//키와 값을 요소로 추가한다.
		//key : 추가할 요소의 키
		//value : 추가할 요소의 값
		
		this.key[this.index] = key;
		this.value[this.index] = value;
		
		if (getIndex(key) > -1) {					//선생님은 복사 사용
			this.key[getIndex(key)] = key;
			this.value[getIndex(key)] = value;
			
		}
		
		
		if (checkLenth()) {	//방의 크기가 꽉 차면
			doubleList();	//방을 늘려라 (키와 데이터)
		}
		
		this.index++;
		
		return value;	
	}
	
	
	
	private int getIndex(String key) {			//수정
		for(int i=0; i<=this.index; i++) {
			if(this.key[i].equals(key)) {
				return i;
			}
		}
		
		return -1;
	}
	
	private void doubleList() {
		
		String[] keyTemp = new String [this.key.length * 2];
		String[] valueTemp = new String [this.value.length * 2];
		
		for (int i=0; i<this.key.length; i++) {
			keyTemp[i] = this.key[i];
			valueTemp[i] = this.value[i];
			
		}
		
		this.key = keyTemp;
		this.value = valueTemp;
		
		
		
	}

	private boolean checkLenth() {
		
		if (this.index == this.key.length) {
			return true;
		}
		
		return false;
	}
	
	
	public String get(String key) {
		//키에 대응하는 요소의 값을 가져온다. key: 가져올 요소의 키
		
		return this.value[getIndex(key)]; //가져올 요소의 값
	}
	
	
	
	
	public int size() {				// >> 수정하거나 삭제한 이후부터는 개수가 틀리게 나옴.
		//요소의 개수를 반환한다
		
		return this.index;			// 수정
	}
	
	public String remove(String key) {	// > 삭제 코드 새로 짜야함.
		//원하는 키의 요소를 삭제함.
		//-key: 삭제할 요소의 키
		//-return: 삭제된 요소의 값
		
		int index =0;
		index = getIndex(key);
		String temp = this.value[index];
		this.value[index] = null;
		return temp;
		
		
		/* 선생님 코드
		int index = getIndex(key);
		
		if (index == -1) {
			return null;
		}
		
		for (int i=index; i<this.key.length; i++ ) {
			this.key[i] = this.key[i+1];
			this.value[i] = this.value[i+1];
		}
		
		this.index--;
		
		return this.value[index];
		*/
	}
	
	public boolean containKey(String key) {
		//해당 키가 존재하는지 확인한다.
		//-key : 확인할 키
		
		//기존방법인데 코드 중복이라서 getIndex() 사용
//		for(int i=0; i<=this.index; i++) {
//			if(this.key[i].equals(key)) {
//				return true;
//			}
//		}
		
		
		if (getIndex(key) > -1) {
			return true;
		}
		
		
		return false; //키의 존재 유무
	}
	
	public boolean containsValue(String value) {
		//해당값이 존재하는지 확인한다.
		//-value: 확인할 값
		
		for(int i=0; i<=this.index; i++) {
			if(this.value[i].equals(value)) {
				return true;
			}
		}
		
		return false; //값의 존재 유무
	}
	
	public void clear() {
		//배열의 모든 요소를 삭제한다.
		
//		for(int i=0; i<this.index; i++){
//			this.key[i] = null;
//			this.value[i] = null;
//		}
//		
//		this.index = 0;
		
		this.index = 0; 
	
	}
	
	public void trimToSize() {
		//배열안의 요소의 개수만큼 배열의 길이를 줄인다. 
		
		String[] keyTemp = new String[this.index];
		String[] valueTemp = new String[this.index];
		
		for (int i=0; i<this.index; i++) {
			keyTemp[i] = this.key[i];
			valueTemp[i] = this.value[i];
		}
		
		this.key = keyTemp;
		this.value = valueTemp;
		
		
	}
	
	
	
	@Override
	public String toString() {
		
		String temp = "";

		temp += "\n";
		temp += String.format("length: %d\n", this.key.length);
		temp += String.format("size: %d\n", this.index);
		temp += String.format("[\n");
		for (int i = 0; i < this.key.length; i++) {
			temp += String.format("   %s: %s\n", this.key[i], this.value[i]);
		}
		temp += String.format("]");
		temp += "\n";

		return temp;
	}

}
