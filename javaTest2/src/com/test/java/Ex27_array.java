package com.test.java; //03.21

public class Ex27_array {

	public static void main(String[] args) {
		//Ex27_array.java
		
		//다차원 배열
		//- 배열의 차원
		
		//m1();
		//m2();
		//m3(); //수업땐 m6()
		m4();
		//m3(),m4(),m5() -> array과제 6,7,8번 teachig 클래스로
		
	}

	private static void m4() {
		//문제 설명 (성적 처리 빼곤 전부다 int 타입)
		//5x5 2차원 배열 
		
		int[][] nums = new int[5][5];
		
		//데이터 입력
		int n = 1; //(루프 변수를 대신할 n)
		
		//여기서 i변수와 j변수를 어떻게 처리하냐에 따라 방향이 달라짐.
		for (int i=0; i<5; i++) { //일단 (?) length 말고 상수..
			for (int j=4; j>=0; j--) { //거꾸로 지그재그
				// j=0; j<5; j++ > 정석대로
				nums[i][j] = n;
				n++; //n도 1~25까지 들어감.
			}
		}
		
		//데이터 출력 > 절대 수정 금지. 이거 그대로 써야 함. 
		
		for (int i=0; i<5; i++) { //일단 (?) length 말고 상수..
			for (int j=0; j<5; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
		
	}

	private static void m3() {
		
		//배열 검색
		//- 집합에서 원하는 항목을 검색
		
		
		String[] member = {"홍길동", "유재석", "박나래", "정형돈", "박명수", "이광수", "김종국",
						   "노홍철", "강호동", "하하"};
		
		//요소 검색 > 결과로 크게 두가지를 반환함. (반환값)
		//1. boolean
		//2. index
		
		//변수의 초기값 > 실패하거나 아무일도 안일어났을때 가져야될 값으로 초기화함. (피해가 가장 적을 값)
		boolean result = false;
		String search = "이광수";
		
		for (int i=0; i<member.length; i++) {
			if (member[i].equals(search)) {
				result = true; //찾았다.
				break; //불필요한 회전 중단
			}
		}
		if (result) {
			System.out.println(search + " 발견 !");
		} else {
			System.out.println(search + " 없음;;");
		}
		
		
		int index = -1; //발견 위치 0과 양수는 방번호로 의미가 생겨버리니까 음수 아무거나를 씀.
		
		for (int i=0; i<member.length; i++) {
			if (member[i].equals(search)) {
				index = i; // 찾은 위치 > i
				break; //불필요한 회전 중단
			}
		}
		
		System.out.println(search + "의 위치: " + index);
		
		
		System.out.println(contains(member, search));
		System.out.println(indexOf(member, search));
		
	}
	
	
	//단위화, 모듈화, 기능화 .. > 가독성, 재사용성 높아짐.
	public static boolean contains(String[] member, String search) { 
		//포함됐는지 확인할땐 보통 이름 contain / contains
		
		for (int i=0; i<member.length; i++) {
			if (member[i].equals(search)) {
				return true; //찾은 순간 return -> 그럼 메소드 끝나니까 break 필요없음
				//break는 포함된 제어문만 탈출하지만 return은 제어문뿐만 아니라 메소드를 빠져나감.
			}
			
		}
		
		return false; //못찾았다는 뜻.
	}
	
	//어느 위치에 있느냐 할때 보통 indexOf 라는 이름을 씀.
	public static int indexOf(String[] member, String search) {
		
		for (int i=0; i<member.length; i++) {
			if (member[i].equals(search)) {
				return i;
			}
		}
		
		return -1;
		
	}

	private static void m2() {
		
		//다차원 배열의 초기화 리스트
		int[] nums1 = { 10, 20, 30};
		
		//2차원 배열
		int[][] nums2 = { { 10, 20, 30}, { 40, 50, 60 } };
		
		//3차원 배열
		//=new int[2][2][3];
		int[][][] nums3 = {{ { 10, 20, 30 }, { 40, 50, 60 } }, { { 10, 20, 30 }, { 40, 50, 60 } }};
		
		int[][][] nums4 =  //가독성 면에서 낫다
			{
				{
					{ 10, 20, 30 },
					{ 40, 50, 60 }
					
				},
				{
					{ 10, 20, 30 },
					{ 40, 50, 60 } 
				}
			};
		
		
		
	}//m2

	private static void m1() {
		
		//1차원배열
		int[] nums1  = new int[3];
		
		//2차원 배열(테이블)
		int[][] nums2 = new int[2][3]; //2(행), 3(열). 먼저 나온 수가 차원수가 더 높음
		
		//3차원 배열
		int[][][] nums3 = new int[2][2][3]; //2(면), 2(행), 3(열).
		
		
		//더 높은 차원을 먼저 표현
		//행 = 층 열 = 호수
		
		//배열 요소 접근(방번호 매기기)
		//1차원 배열 ->for문
		nums1[0] = 100;
		nums1[1] = 200;
		nums1[2] = 300;
		
		//2차원 배열 > 차원 2개 > 첨자 2개 -> 이중for문
		nums2[0][0]	= 100;
		nums2[0][1]	= 200;
		nums2[0][2]	= 300;
		nums2[1][0]	= 400;
		nums2[1][1]	= 500;
		nums2[1][2]	= 500;
		
		//3차원 배열 > 차원 3개 > 첨자 3개 -> 삼중for문
		
		nums3[0][0][0] = 100;
		nums3[0][0][1] = 200;
		nums3[0][0][2] = 300;
		
		nums3[0][1][0] = 400;
		nums3[0][1][1] = 500;
		nums3[0][1][2] = 600;
		
		nums3[1][0][0] = 700;
		nums3[1][0][1] = 800;
		nums3[1][0][2] = 900;
		
		nums3[1][1][0] = 1000;
		nums3[1][1][1] = 1100;
		nums3[1][1][2] = 1200;
		
		
		//배열 탐색(+조작)
		//- 1차원 배열 > 단일 for문
		//- 2차원 배열 > 2중 for문 (차원 높은만큼 loop하나 더)
		//- 3차원 배열 > 3중 for문
		
		//1차원 배열
		for (int i=0; i<nums1.length; i++) {
			System.out.printf("nums1[%d] = %d\n", i, nums1[i]);
		}
		System.out.println();
		
		for (int i=0; i<nums1.length; i++) {
			System.out.printf("%5d", nums1[i]);
		}
		System.out.println();
		System.out.println();
		
		
		//2차원 배열
		
		for(int i=0; i<2; i++) {
			for (int j=0; j<3; j++) {
				System.out.printf("nums2[%d][%d] = %d\n", i, j, nums2[i][j]);
			}
			
		}
		System.out.println();
		
		for(int i=0; i<nums2.length; i++) {
			for (int j=0; j<nums2[0].length; j++) {
				System.out.printf("%5d", nums2[i][j]);
			}//한줄 출력 후 엔터 //행
			System.out.println();
		}
		System.out.println();
		System.out.println();
		
		
		//3차원 배열
		for (int i=0; i<2; i++) {
			for (int j=0; j<2; j++) {
				for (int k=0; k<3; k++) {
					
					System.out.printf("nums3[%d][%d][%d] = %d\n", i, j, k, nums3[i][j][k]);
				}
			}
		}
		
		System.out.println();
		System.out.println();
		
		
		for (int i=0; i<nums3.length; i++) {
			for (int j=0; j<nums3[0].length; j++) {
				for (int k=0; k<nums3[0][0].length; k++) {
					
					System.out.printf("%5d",nums3[i][j][k]);
				}
				System.out.println(); //행
			}
			System.out.println(); //면
		}
		System.out.println();
		System.out.println();
		
		
		//다차원 배열의 길이(= 방의 개수)
		//1차원 배열
		//=new int[3];
		System.out.println(nums1.length); //확인용
		System.out.println();
		
		//2차원 배열
		//= new int[2][3]
		System.out.println(nums2.length); //2 (행의 개수) // 그럼 열의 개수는?
		System.out.println(nums2[0].length); //열의 개수 3
		System.out.println();
		
		//3차원 배열
		//=new int[2][2][3]
		System.out.println(nums3.length); //면의 개수
		System.out.println(nums3[0].length); //행의 개수
		System.out.println(nums3[0][0].length); //열의 개수
		
	}
}



























