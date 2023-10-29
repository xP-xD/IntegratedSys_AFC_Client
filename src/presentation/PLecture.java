package presentation;

import java.util.Scanner;
import java.util.Vector;

import service.SLecture;
import valueObject.VLecture;

public class PLecture {

	public VLecture show(Scanner scanner, String fileName) {

		System.out.println("선택하세요.");
		SLecture sLecture = new SLecture();
		Vector<VLecture> vLectures = sLecture.getData(fileName);
		if (vLectures != null) {
			for (VLecture vLecture : vLectures) {
				System.out.println(vLecture.getId() + " " + vLecture.getLecture() + " " + vLecture.getProfessor() + " "
						+ vLecture.getCredit() + " " + vLecture.getTime());
			}

			System.out.println("입력: ");
			int selection = scanner.nextInt();

			for (VLecture vLecture : vLectures) {
				if (Integer.parseInt(vLecture.getId()) == selection) {
					return vLecture;
				}
			}
		}
		return null;
	}

//	public VLecture show(Scanner scanner, String fileName) {
//		
//		System.out.println("선택하세요.");
//		SLecture sLecture = new SLecture();
//		Vector<VLecture> vLectures = sLecture.getData(fileName);
//		if (vLectures != null) {
//			for (VLecture vLecture : vLectures) {
//				System.out.println(vLecture.getId() + " " + vLecture.getLecture() + " " + vLecture.getProfessor()+ " " +
//						vLecture.getCredit() + " " + vLecture.getTime());
//			}
//			
//			int selection = 0;
//			boolean exist = true;
//			while (exist) {
//				System.out.println("번호입력: ");
//				String input = scanner.nextLine();
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
//					for(VLecture vLecture : vLectures) {
//						if(vLecture.getId() == selection) {
//							return vLecture;
//						}
//					}
//				}
//				
//				System.out.println("선택지의 번호로 재입력해주세요");
//				exist = true;
//			}
//		}
//		return null;
//	}

}
