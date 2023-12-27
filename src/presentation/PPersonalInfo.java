package presentation;
import java.util.Scanner;

import service.SPersonalInfo;
import valueObject.VPersonalInfo;

public class PPersonalInfo {
	
	private SPersonalInfo sPersonalInfo;
	private VPersonalInfo vPersonalInfo;
	
	public PPersonalInfo() {
		sPersonalInfo = new SPersonalInfo();
		vPersonalInfo = new VPersonalInfo();
	}
	
	public void show(Scanner scanner) {
		System.out.println("개인정보를 입력하세요.");
		//개인정보 입력창 표출
		//개인정보 수집
		
		System.out.print("ID를 입력하세요: ");
		this.vPersonalInfo.setId(scanner.next());
		System.out.print("Password를 입력하세요: ");
		this.vPersonalInfo.setPassword(scanner.next());
		System.out.print("Name를 입력하세요: ");
		this.vPersonalInfo.setName(scanner.next());

		System.out.println(this.sPersonalInfo.write(vPersonalInfo));
		
	}

}
