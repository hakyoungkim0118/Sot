package controller;

public class ViewMain {
	public void welcome() {
		System.out.println("통장개설을 환영합니다!");
	}
	
	public void showMenu () {
		System.out.println("1. 자유저축 2. 대출 3. 신탁  4. 종료");
	}

	public void pressKeyError() {
		System.out.println("잘못 입력 하셨습니다");
	}
	
}
