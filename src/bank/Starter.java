package bank;

import controller.Service;

public class Starter {

	public static void main(String[] args) {
		Service sv = new Service();
		sv.start();
		sv.end(); 
	}

}
