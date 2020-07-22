package controller;

import java.util.Calendar;
import java.util.Scanner;

import controller.model.BankAccount;
import controller.model.FreeSavingRepo;
import controller.model.FreeSavings;
import util.DBConnection;

public class Service {
	ViewMain vm = new ViewMain();
	Scanner scan = new Scanner(System.in);
	
	public void start() {
		vm.welcome();
		boolean flag = true;
		while(flag) {
			flag = selectMenu();
		}
	}
	
	public boolean selectMenu() {
		int menu; 
		vm.showMenu();
		menu = scan.nextInt();
		scan.nextLine();
		switch(menu) {
			case 1 : 
				createAccount();
				return true;
			case 2 :
				return true;
			case 3 :
				return true;
			case 4 :
				return false;
			default : 
				vm.pressKeyError();
		}
		return true;
	}
	
	private void createAccount() {
		BankAccount freesaving = new FreeSavings();
		System.out.println("�̸��� �Է��ϼ���:");
		freesaving.setName(scan.nextLine());
		System.out.println("�ݾ��� �Է��ϼ���:");
		freesaving.setPrice(scan.nextInt());
		System.out.println("�����Ϸ�");
		freesaving.setCreateDate(Calendar.getInstance());
		System.out.println(freesaving);
		FreeSavingRepo createData = new FreeSavingRepo();
		createData.insert((FreeSavings) freesaving);
	}

	public void end() {
		
	}
}
