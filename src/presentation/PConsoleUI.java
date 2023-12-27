package presentation;


import java.util.Scanner;

import valueObject.VPersonalInfo;

public class PConsoleUI {
//==View
	
	public void show(Scanner scanner){
//		Scanner scanner = new Scanner(System.in);
		
		VPersonalInfo vPersonalInfo = this.login(scanner);
		if (vPersonalInfo != null) {
			this.applicationForClasses(scanner, vPersonalInfo);
		} else {
			this.terminate();
		}

//		scanner.close();
	}

	private void terminate() {
		
	}

	private void applicationForClasses(Scanner scanner, VPersonalInfo vPersonalInfo) {
		PApplicationForClasses pApplicationForClasses = new PApplicationForClasses();
		pApplicationForClasses.show(scanner, vPersonalInfo);

	}

	private VPersonalInfo login(Scanner scanner){

		System.out.println("수강신청 사이트입니다. 어떤 작업을 하실지 선택해주세요");
		VPersonalInfo vPersonalInfo = null;

		boolean finished = false;
		while (!finished == true) {

			System.out.println("1. 회원가입, 2. 로그인 3. 작업종료");
			System.out.print("입력: ");
			int selection = scanner.nextInt();
			System.out.println("");

			if (selection == 1) {
				PPersonalInfo pPersonalInfo = new PPersonalInfo();
				pPersonalInfo.show(scanner);
			} else if (selection == 2) {
				PLogIn pLogIn = new PLogIn();
				vPersonalInfo = pLogIn.show(scanner);

				if (vPersonalInfo != null) {

					System.out.println("");
					System.out.println(vPersonalInfo.getName() + "님 안녕하세요 로그인이 완료되었습니다.");
					System.out.println("");
					finished = true;
				} 
				else {
					System.out.println("");
					System.out.println("로그인 정보가 잘못 되었습니다. 다시 로그인 해주세요.");
					System.out.println("");
				}
			} else if (selection == 3) {
				finished = true;
				System.out.println("작업을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("1, 2, 3번 중에서 선택해주세요.");
				System.out.println("");
			}
		}
		return vPersonalInfo;
	}

}
