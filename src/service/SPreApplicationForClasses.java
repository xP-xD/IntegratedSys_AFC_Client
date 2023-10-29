package service;

import java.util.ArrayList;
import java.util.Vector;

import valueObject.VLecture;
import valueObject.VPreApplicationForClasses;

public class SPreApplicationForClasses extends Stub {

	private ArrayList<String> sendList;
	private Vector<VPreApplicationForClasses> vPreApplicationForClassesVector;

	public SPreApplicationForClasses() {
		sendList = new ArrayList<String>();
	}

	public void saveVPreApplicationForClasses(String id, VLecture vLecture) {
		sendList.add("vPreApplicationForClasses");
		sendList.add("setUserId");
		sendList.add(id);

		sendList.add("vPreApplicationForClasses");
		sendList.add("setLectureId");
		sendList.add(vLecture.getId());

		sendList.add("vPreApplicationForClasses");
		sendList.add("setLecture");
		sendList.add(vLecture.getLecture());

		sendList.add("vPreApplicationForClasses");
		sendList.add("setProfessor");
		sendList.add(vLecture.getProfessor());

		sendList.add("vPreApplicationForClasses");
		sendList.add("setCredit");
		sendList.add(vLecture.getCredit());

		sendList.add("vPreApplicationForClasses");
		sendList.add("setTime");
		sendList.add(vLecture.getTime());
	}

	public void saveVPreApplicationForClasses(String id) {
		sendList.add("vPreApplicationForClasses");
		sendList.add("setUserId");
		sendList.add(id);
	}

	public void saveStoreMethod() {
		sendList.add("sPreApplicationForClasses");
		sendList.add("store");
		sendList.add("");
	}

	public void saveGetDataMethod() {
		sendList.add("sPreApplicationForClasses");
		sendList.add("getData");
		sendList.add("");
	}

	public Vector<VPreApplicationForClasses> receivedValueObject(ArrayList<String> sendList) {
			this.vPreApplicationForClassesVector = new Vector<VPreApplicationForClasses>();
			for (int i = 0; i < sendList.size(); i++) {
				VPreApplicationForClasses vPreApplicationForClasses = new VPreApplicationForClasses();

//				vPreApplicationForClasses.setUserId(sendList.get(i++));
				vPreApplicationForClasses.setLectureId(sendList.get(i++));
				vPreApplicationForClasses.setLecture(sendList.get(i++));
				vPreApplicationForClasses.setProfessor(sendList.get(i++));
				vPreApplicationForClasses.setCredit(sendList.get(i++));
				vPreApplicationForClasses.setTime(sendList.get(i));

				this.vPreApplicationForClassesVector.add(vPreApplicationForClasses);
			}
		return this.vPreApplicationForClassesVector;
	}

	// 프린트 라인으로 완료 되었다는 글 찍기
	public void store(String id, VLecture vLecture) {
		sendList.clear();

		this.saveVPreApplicationForClasses(id, vLecture);
		this.saveStoreMethod();

		this.send(sendList);
		System.out.println(sendList.get(0));
	}

	public Vector<VPreApplicationForClasses> getData(String id) {
		sendList.clear();

		this.saveVPreApplicationForClasses(id);
		this.saveGetDataMethod();

		return this.receivedValueObject(this.send(sendList));
	}

}
