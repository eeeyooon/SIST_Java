package mylibrary.utill; //04.12

import java.util.Random;

public class MyUtil {

	//요구사항] 난수 10~20 사이의 X N회
	public int getNum() {
		
		Random rnd = new Random();
		return rnd.nextInt(11) + 10;
		
		//무조건 프로젝트가 다르면 교류가 불가능 (별도의 프로그램)
		//그렇다고 같은 클래스를 다른 프로젝트로 복붙하는건 안좋음 (중복 코드) 
		//-> 나중에 이 클래스를 수정할때 복사해놓은 모든 파일을 수정해야해
		
		//공통으로 쓰고 싶은 클래스가 있으면 따로 프로젝트에 넣고 jar파일에 넣음
	}
	
}



















