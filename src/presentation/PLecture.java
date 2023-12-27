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

}
