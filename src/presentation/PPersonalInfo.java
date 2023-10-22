package presentation;
import java.util.Scanner;

import service.SPersonalInfo;
import valueObject.VPersonalInfo;

public class PPersonalInfo {
	
	private SPersonalInfo sPersonalInfo;
	
	public PPersonalInfo() {
		sPersonalInfo = new SPersonalInfo();
	}
	
	public void show(Scanner scanner) {
		System.out.println("개인정보를 입력하세요.");
		//개인정보 입력창 표출
		//개인정보 수집
		
		//new valueObject
		VPersonalInfo vPersonalInfo = new VPersonalInfo();
		
		System.out.print("ID를 입력하세요: ");
		vPersonalInfo.setId(scanner.next());
		System.out.print("Password를 입력하세요: ");
		vPersonalInfo.setPassword(scanner.next());
		System.out.print("Name를 입력하세요: ");
		vPersonalInfo.setName(scanner.next());

		sPersonalInfo.sendPersonalInfo(vPersonalInfo);
		
	}

}
