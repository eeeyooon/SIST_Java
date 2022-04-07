package com.test.java.obj.stereo; //03.29

public class Ex52_Generic {

	public static void main(String[] args) {
		
		//Ex52_Generic.java
		
		//tap / shift + tap ㅎㅎ
		
		//클래스 종류 -> 오늘 수업 내용 
		//1. 클래스
		//2. 인터페이스
		//3. 추상 클래스
		//4. enum
		//5. 제네릭 클래스 
		
		
		
		//제네릭, Generic
		//1. 제네릭 클래스 > 오늘 수업은 얘를 할거임
		//2. 제네릭 메소드
		
		
		//요구사항] 클래스  설계
		//1. 멤버 변수 선언 > int로
		//2. 멤버 변수를 중심으로 여러가지 행동을 하는 메소드 선언
		
		WrapperInt n1 = new WrapperInt(10);
		System.out.println(n1.toString());		//data= 10
		System.out.println(n1.getData() * 2); 	//20
		System.out.println();
		
		
		//03.30
		//object로 int 해보기
		
		WrapperObject n2 = new WrapperObject(20);
		System.out.println(n2.toString()); //20
		System.out.println((int)n2.getData() * 2); //참조형은 산술연산의 대상이 될 수 없다. -> 그래서 원래 자료형으로 다운캐스팅해야함.
		System.out.println();
		System.out.println();
		
		//추가사항] String을 중심으로 하는 클래스를 추가로 설계 요청 (문자열도 넣고싶어)
		
		WrapperString s1 = new WrapperString("홍길동");
		System.out.println(s1.toString()); //data= 홍길동
		System.out.println(s1.getData().length()); //3
		System.out.println();
		
		WrapperObject s2 = new WrapperObject("아무개"); //Object를 넣으라는 말은, 어떤 자료형이든 받을 수 있다는 말.
													  //(String이 object로 업캐스팅)
		System.out.println(s2.toString());
		System.out.println(((String)s2.getData()).length()); //String으로 다운캐스팅. -> 괄호로 한번 더 묶어야 length확인가능
		System.out.println();
		System.out.println();
		
		
		
		//추가사항] boolean을 중심으로 하는 클래스를 추가로 설계 요청 
		
		WrapperBoolean b1 = new WrapperBoolean(true);
		System.out.println(b1.toString()); //data= true
		System.out.println(b1.getData() ? "참" : "거짓"); //참
		System.out.println();
		
		WrapperObject b2 = new WrapperObject(false);
		System.out.println(b2.toString()); //data= false
		System.out.println(((boolean)b2.getData()) ? "참" : "거짓"); //boolean으로 다운캐스팅 //거짓
		System.out.println();
		System.out.println();
		
		//추가사항] double을 중심으로 하는 클래스를 추가로 ?
		//추가사항] byte를 중심으로 하는 클래스를 추가로 ?
		//추가사항] Calendar를 중심으로 하는 클래스를 추가로 ?
		//추가사항] Date ?
		//추가사항] 무한대....
		
		
		
		//위의 문제점 > 해결방안
		//1. Object 클래스 > 오래된 방식
		//2. 제네릭 클래스 > 최신 방식 >> 뭐 그렇다고 완벽하게 제네릭이 더 좋은 방식은 아님. 
								//>> 그래서 현재는 둘다 잘 씀. 근데 제네릭을 더 권장하긴 해ㅎㅎ
		
		
		
		
		//03.30 제네릭
		//-Object는 범용(하나가지고 다 할 수 있음)
		//-하지만 Object는 사용할때 다운캐스팅을 해야하는데 
		//-제네릭도 범용.(클래스는 하나지만 '<>'안에 어떤 자료형을 넣느냐에 따라 모든 자료형 사용 가능)
		//-제네릭은 바로 사용이 가능. (처음 자료형을 명시적으로 정해놓고 시작하기 때문에) > 전용과 같이 기능함.
		//-처음 자료형을 내 마음대로 저장할 수 있기때문에 범용임. => 제네릭은 Object의 개선책이라 볼 수 있음.
		
		System.out.println("[제네릭 예제]");
		
		//int
		Wrapper<Integer> n3 = new Wrapper<Integer>(30);
		System.out.println(n3.toString()); //Object는 항상 다운캐스팅을 해야 본연의 자료형으로 돌려놓을 수 있었으나.
		System.out.println(n3.getData() * 2);  //참조형의 Integer지만 값형의 int와 동일 취급 -> 산술연산 가능.
		System.out.println();
		
		//String 
		Wrapper<String> s3 = new Wrapper<String>("테스트");
		System.out.println(s3.toString());
		System.out.println(s3.getData().length()); //문자열의 길이도 다운 캐스팅없이 바로 출력 가능.
		System.out.println();
		
		//Boolean
		Wrapper<Boolean> b3 = new Wrapper<Boolean>(false);
		System.out.println(b3.toString());
		System.out.println(b3.getData() ? "참" : "거짓");
		System.out.println();
		
	} //main

} //Ex52


class WrapperInt {	//무언가를 대상으로 감싸서 Object화 시키는 애들을 Wrapper클래스라고함.
	
	private int data; // 클래스의 중심이 되는 데이터!!
	
	public WrapperInt(int data) {
		this.data = data;
	}

	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	

	@Override
	public String toString() {
		return "data= " + data;
	}
	
}//WrapperInt


class WrapperString {	//무언가를 대상으로 감싸서 Object화 시키는 애들을 Wrapper클래스라고함.
	
	private String data; // 클래스의 중심이 되는 데이터!! >> String으로
	
	public WrapperString(String data) {
		this.data = data;
	}

	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	

	@Override
	public String toString() {
		return "data= " + data;
	}
	
}//WrapperString


class WrapperBoolean {	//무언가를 대상으로 감싸서 Object화 시키는 애들을 Wrapper클래스라고함.
	
	private Boolean data; // 클래스의 중심이 되는 데이터!! >> Boolean으로
	
	public WrapperBoolean(Boolean data) {
		this.data = data;
	}

	
	public Boolean getData() {
		return data;
	}

	public void setData(Boolean data) {
		this.data = data;
	}

	

	@Override
	public String toString() {
		return "data= " + data;
	}
	
}//WrapperBoolean


//03.30

class WrapperObject {	
	
	private Object data; // 클래스의 중심이 되는 데이터!! >> Object로
	
	public WrapperObject(Object data) {
		this.data = data;
	}

	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	

	@Override
	public String toString() {
		return "data= " + data;
	}
	
}//WrapperObject


//03.30
//제네릭


class Wrapper<T> {
	
	private T data; //클래스의 중심이 되는 데이터!!
	
	public Wrapper(T data) {	//생성자는 타입변수 XX
		this.data = data;
	}
	
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


	@Override
	public String toString() {
		
		return "data= " + this.data;
	}
	
}
























