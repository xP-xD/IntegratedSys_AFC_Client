package presentation;

import java.util.Scanner;

import service.SLogIn;
import valueObject.VLogIn;
import valueObject.VPersonalInfo;

public class PLogIn{
	
	private SLogIn sLogIn;
	private VLogIn vLogIn;
	
	public PLogIn() {
		sLogIn = new SLogIn();
		vLogIn = new VLogIn();
	}
	
	public void login() {
		
	}
	
	public VPersonalInfo show(Scanner scanner) {
		
		System.out.println("아이디, 비밀번호를 입력하세요.");
		
		System.out.print("ID: ");
		vLogIn.setId(scanner.next());
		System.out.print("Password: ");
		vLogIn.setPassword(scanner.next());
		
		return sLogIn.sendLogInInfo(vLogIn);
	}

}
