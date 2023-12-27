package presentation;

import java.util.Scanner;
import java.util.Vector;

import service.SPreApplicationForClasses;
import service.SRealApplicationForClasses;
import valueObject.VLecture;
import valueObject.VPersonalInfo;
import valueObject.VPreApplicationForClasses;
import valueObject.VRealApplicationForClasses;

//수강신청 프레젠테이션
public class PApplicationForClasses {

	public PApplicationForClasses() {
	}

	public void show(Scanner scanner, VPersonalInfo vPersonalInfo) {

		System.out.println(vPersonalInfo.getName() + "님, 다음 메뉴를 선택하세요.");
		System.out.println("");
		String fileName = "root";

		boolean finished = false;
		while (!finished == true) {

			System.out.println("==미리담기 내역==");
			SPreApplicationForClasses sPreApplicationForClasses = new SPreApplicationForClasses();
			Vector<VPreApplicationForClasses> vPreApplicationForClasses = sPreApplicationForClasses.getData(vPersonalInfo.getId());
			for (VPreApplicationForClasses vPreApplicationForClass : vPreApplicationForClasses) {
				System.out.println(vPreApplicationForClass.getLecture());
			}
			System.out.println("");

			System.out.println("==수강신청 내역==");
			SRealApplicationForClasses sRealApplicationForClasses = new SRealApplicationForClasses();
			Vector<VRealApplicationForClasses> vRealApplicationForClasses = sRealApplicationForClasses.getData(vPersonalInfo.getId());
			for (VRealApplicationForClasses vRealApplicationForClass : vRealApplicationForClasses) {
				System.out.println(vRealApplicationForClass.getLecture());
			}
			System.out.println("");

			System.out.println("1. 미리담기, 2. 수강신청 3. 종료");
			System.out.print("입력: ");
			int selection = scanner.nextInt();
			System.out.println("");

			if (selection == 1) {
				PMajor pCampus = new PMajor();
				fileName = pCampus.show(scanner, fileName);
				PMajor pCollege = new PMajor();
				fileName = pCollege.show(scanner, fileName);
				PMajor pMajor = new PMajor();
				fileName = pMajor.show(scanner, fileName);
				PLecture pLecture = new PLecture();
				VLecture vLecture = pLecture.show(scanner, fileName);

				sPreApplicationForClasses.store(vPersonalInfo.getId(), vLecture);

				fileName = "root";
			} else if (selection == 2) {

				PMajor pCampus = new PMajor();
				fileName = pCampus.show(scanner, fileName);
				PMajor pCollege = new PMajor();
				fileName = pCollege.show(scanner, fileName);
				PMajor pMajor = new PMajor();
				fileName = pMajor.show(scanner, fileName);
				PLecture pLecture = new PLecture();
				VLecture vLecture = pLecture.show(scanner, fileName);

				sRealApplicationForClasses.store(vPersonalInfo.getId(), vLecture);
				fileName = "root";
			} else if (selection == 3) {
				finished = true;
				System.out.println("작업을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("1,2,3번중에 선택해주세요.");
			}

		}
	}

}
