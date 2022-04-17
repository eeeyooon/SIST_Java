package com.test.java.obj.access; //03.24

public class Ex35 {

	public static void main(String[] args) {
		
		
		
		CPU cpu = new CPU();
		cpu.setModel("Intel i5");
		cpu.setSpeed("1.8");
		
		MainBoard mainboard = new MainBoard();
		mainboard.setModel("M5000");
		
		Storage storage = new Storage();
		storage.setModel("SM");
		storage.setType("SSD");
		storage.setSize(500);
		
		
		Computer computer = new Computer();
		computer.setCpu(cpu);
		computer.setMainboard(mainboard);
		computer.setStorage(storage);
		
		
		//c.
		
		Memory memory = new Memory();
		computer.setMemory(memory); //첫번째메모리
		
		Memory memory2 = new Memory();
		computer.setMemory(memory2); //두번째메모리
		
		Memory memory3 = new Memory();
		computer.setMemory(memory3); //세번째메모리
		
		Memory memory4 = new Memory();
		computer.setMemory(memory4); //네번째메모리
		
		computer.removeMemory();
		computer.removeMemory();
		computer.removeMemory();
		computer.removeMemory(); // 여기까진 콘솔창에 반응없음 (4번 넣고 4번 삭제했으니까)
		computer.removeMemory(); // 출력 : 더 이상 제거할 수 있는 메모리가 없습니다. 

		
		
		//c.
		//Memory memory5 = new Memory();
		//computer.setMemory(memory2); //다섯번째메모리
		// -> 출력 : 더이상 남아있는 메모리 슬롯이 없습니다.
		
		//b.
//		Memory[] mlist = new Memory[2];
//		Memory m1 = new Memory();
//		
//		mlist[0] = m1;
//		
//		mlist[1] = new Memory();
//		
//		computer.setMemorylist(null);
		
		
		
		// >> b방법(배열을 생성해서 이용)보다 c 방법이 훨씬 쉽고 편리 (************) 또한 c방법은 배열이 직접 보이지 않음. b는 보이는데
		
		
		//d
		User hong = new User();
		
		hong.setNick(0, "강아지"); //별명을 어느 방에 넣을지 직접 지정할 수 있음.
		hong.setNick(1, "천재");
		hong.setNick(2, "뚱보");
		
		System.out.println(hong.getNick(1)); //이번엔 내가 보고싶은 별명을 직접 골라서 볼 수 있음.
		//이것도 배열을 직접적으로 드러내진 않음. (반쯤 보이긴함. 인덱스땜에)
		
		
		//배열도 객체 클래스의 멤버변수가 될 수 있고, 대신 getter setter를 오래 고민해야해.
		// 그 중 3가지 형태를 알려준건고, 나중에 배열을 쓸 때 이 세가지 스타일을 적용하거나 혹은 새로운 스타일로 보완해서 사용하면돼.
		// 근데 이미 말해준 3개가 가장 보편적인 방식임.  > c방법 d방법을 주로 연습해
		
	}//main
	
}//Ex35


//컴퓨터
//- CPU
//- MainBoard
//- Memory
//- Storage


class Computer {
	
	private CPU cpu;
	private MainBoard mainboard;
	private int i = 0;	//메모리 관리를 위한 변수
	private Memory[] memorylist = new Memory[4]; //*** // 일단 미리 깔아놔. 일단 4개 들어가는 걸로
	private Storage storage;
	
	
	
	public CPU getCpu() {
		return cpu;
	}
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	public MainBoard getMainboard() {
		return mainboard;
	}
	public void setMainboard(MainBoard mainboard) {
		this.mainboard = mainboard;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
	
	
	
//	public Memory[] getMemorylist() { //나중에 보면 상당히 불안정한 코드 //TODO 객체배열 나중에 (2022. 3. 24. 오후 3:22:54)
//		return memorylist;
//	}
//	public void setMemorylist(Memory[] memorylist) {
//		this.memorylist = memorylist;
//	}
	
	
	public void setMemory(Memory memory) {
		
		if (i == 4) {
			System.out.println("더이상 남아있는 메모리 슬롯이 없습니다."); //아까 길이가 4까지인 배열을 만들었으니까.
			return; //중단 (void라고 하고 return을 쓰면 에러나는데 지금은 안남. 왜냐 주는게 아무것도 없거든
					// 이걸 빈 리턴문이라고 해. -> 즉, 이건 돌려준다는게 아니라 메소드만 중지시키겠다는거. 
					// 리턴문 기능이 1) 값 돌려주기 2) 값돌려주자마자 메소드 강제 중단하기 
					// => 그래서 빈리턴문은 값은 못돌려줘도 메소드 강제중단은 할 수 있음.
					// i가 4일때 여기서 메소드 중단을 하지 않으면 방번호 오버됐다는 에러가 뜸. 
		}
		this.memorylist[i] = memory; //처음 만든 메모리는 0번방에 들어감.
		i++; //for문 없는 for문이 된 것. (한번 호출하면 0번 방에 들어가는데, 다음 메모리를 만들면 1번 방에, 다음 메모리는 2번방에 ...)
		
		
	}
	
	public void removeMemory() {
		//무조건 마지막에 꽂은 메모리를 삭제.
		
		if (i == 0) {
			System.out.println("더 이상 제거할 수 있는 메모리가 없습니다.");
			return;
		}
		
		i--;
		this.memorylist[i] = null; //참조형 변수에 NULL 상수, NULL 리터럴을 넣으면 그 주소값이 삭제됨. > garbage가 돼서 삭제됨.
		
		//실행을 계속하면 네번째 삭제, 그다음 세번째방 삭제, 그 다음 두번째 방 삭제 ...
		// i : 4->3->2->1  => i 값이 바뀌다가 0이 되면 그때 중단 (빈리턴문)
		
	}
	
	
}

class CPU {
	
	private String model;
	private String speed;
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
	
}

class MainBoard {
	private String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
}

	
class Memory {
	private String model;
	private int size;
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}

class Storage {
	private String model;
	private String type;
	private int size;
	
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}


//d 방법.

class User {
	
	private String name;
	private int age;
	private String[] nick = new String[10]; //이름은 하나 나이도 하나지만 별명은 여러개 -> 배열로 만들면 돼.
	
	//이번엔 i 변수를 안만들었음. (메모리를 넣을 때마다 방을 한칸씩 뒤로 밀어주는 / 삭제할때마다 방을 당겨주는 > 가이드 역할을 함.)
	
	public void setNick(int index, String value) { //value는 별명
		this.nick[index] = value; //직접적으로 사용자가 방을 지정하라고 (어느 방에 넣을지) 이렇게 한거임. i없이
	}
	
	public String getNick(int index) {
		return this.nick[index];
	}
	
	
	
}




























