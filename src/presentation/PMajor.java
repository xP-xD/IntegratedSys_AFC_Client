package presentation;

import java.util.Scanner;
import java.util.Vector;

import service.SMajor;
import valueObject.VMajor;

public class PMajor {
	
	public String show(Scanner scanner, String fileName) {

		System.out.println("선택하세요.");
		SMajor sMajor = new SMajor();
		Vector<VMajor> vData = sMajor.getData(fileName);
		if (vData != null) {
			for (VMajor vDatum : vData) {
				System.out.println(vDatum.getId() + " " + vDatum.getText());
			}
			
			System.out.println("입력: ");
			int selection = scanner.nextInt();
			
			for(VMajor vDatum : vData) {
				if(Integer.parseInt(vDatum.getId()) == selection) {
					return vDatum.getFileName();
				}
			}
		}
		return null;
	}

}
