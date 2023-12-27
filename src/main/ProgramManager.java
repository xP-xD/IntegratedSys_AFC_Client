package main;

import java.util.Scanner;

import presentation.LLoginDialog;
import presentation.PConsoleUI;

public class ProgramManager {
	
	
	public ProgramManager() {
	}
	

	public void selectProgram() {
		
		Scanner scanner = new Scanner(System.in);
		
//		System.out.println("select langauge");
//		System.out.println("1. 한국어");
//		System.out.println("2. 日本語");
		

		boolean executed = false;
		while(!executed) {
			
			System.out.println("실행할 프로그램 유형을 선택하십시오");
			System.out.println("1.콘솔 2.스윙 3.종료");
			String in = scanner.next();
			int selected = in.charAt(0) - 48;
			
			if(selected == 1) {
				PConsoleUI pmain = new PConsoleUI();
				pmain.show(scanner);
				
				executed = true;
			}else if(selected == 2) {
				LLoginDialog lloginDialog = new LLoginDialog();
				lloginDialog.initialize();
				lloginDialog.setVisible(true);
				
				executed = true;
			}else if(selected == 3) {
				executed = true;
			}else {
				System.out.println("올바르게 선택하십시오");
			}
			
		}
		
		scanner.close();
	}

}
