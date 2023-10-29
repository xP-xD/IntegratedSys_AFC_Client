package main;
import presentation.PMainUI;

public class CMain {

	public void run() {
//		View view = new View();
//		view.showUserInfo();
	
		PMainUI pmain = new PMainUI();
		pmain.show();
	}

	public static void main(String[] args) {

		CMain main = new CMain();
		main.run();
	}

}
