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

//	public String show(Scanner scanner, String fileName) {
//
//		System.out.println("선택하세요.");
//		SMajor sMajor = new SMajor();
//		Vector<VMajor> vData = sMajor.getData(fileName);
//		if (vData != null) {
//			for (VMajor vDatum : vData) {
//				System.out.println(vDatum.getId() + " " + vDatum.getText());
//			}
//
//			int selection = 0;
//			boolean exist = true;
//			while (exist) {
//				System.out.println("번호입력: ");
//				String input = scanner.nextLine().trim();
//				
//				for (int i = 0; i < input.length(); i++) {
//					char temp = input.charAt(i);
//					if ('0' <= temp && temp <= '9') {
//						exist = false;
//					}
//				}
//
//				if(exist == true) {
//					selection = Integer.parseInt(input);
//					
//					for (VMajor vDatum : vData) {
//						if (vDatum.getId() == selection) {
//							return vDatum.getFileName();
//						}
//					}
//				}
//				
//				System.out.println("선택지의 번호로 재입력해주세요");
//				exist = true;
//			}
//
//		}
//		return null;
//	}

}
