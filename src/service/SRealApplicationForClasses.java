package service;

import java.util.ArrayList;
import java.util.Vector;

import valueObject.VLecture;
import valueObject.VRealApplicationForClasses;

public class SRealApplicationForClasses extends Stub {

	private ArrayList<String> sendList;
	private Vector<VRealApplicationForClasses> vRealApplicationForClassesVector;

	public SRealApplicationForClasses() {
		sendList = new ArrayList<String>();
	}

	public void saveVRealApplicationForClasses(String id, VLecture vLecture) {
		sendList.add("vRealApplicationForClasses");
		sendList.add("setUserId");
		sendList.add(id);

		sendList.add("vRealApplicationForClasses");
		sendList.add("setLectureId");
		sendList.add(vLecture.getId());

		sendList.add("vRealApplicationForClasses");
		sendList.add("setLecture");
		sendList.add(vLecture.getLecture());

		sendList.add("vRealApplicationForClasses");
		sendList.add("setProfessor");
		sendList.add(vLecture.getProfessor());

		sendList.add("vRealApplicationForClasses");
		sendList.add("setCredit");
		sendList.add(vLecture.getCredit());

		sendList.add("vRealApplicationForClasses");
		sendList.add("setTime");
		sendList.add(vLecture.getTime());
	}

	public void saveVRealApplicationForClasses(String id) {
		sendList.add("vRealApplicationForClasses");
		sendList.add("setUserId");
		sendList.add(id);
	}

	public void saveStoreMethod() {
		sendList.add("sRealApplicationForClasses");
		sendList.add("store");
		sendList.add("");
	}

	public void saveGetDataMethod() {
		sendList.add("sRealApplicationForClasses");
		sendList.add("getData");
		sendList.add("");
	}

	public Vector<VRealApplicationForClasses> receivedValueObject(ArrayList<String> sendList) {
			this.vRealApplicationForClassesVector = new Vector<VRealApplicationForClasses>();
			for (int i = 0; i < sendList.size(); i++) {
				VRealApplicationForClasses vRealApplicationForClasses = new VRealApplicationForClasses();

//				vPreApplicationForClasses.setUserId(sendList.get(i++));
				vRealApplicationForClasses.setLectureId(sendList.get(i++));
				vRealApplicationForClasses.setLecture(sendList.get(i++));
				vRealApplicationForClasses.setProfessor(sendList.get(i++));
				vRealApplicationForClasses.setCredit(sendList.get(i++));
				vRealApplicationForClasses.setTime(sendList.get(i));

				this.vRealApplicationForClassesVector.add(vRealApplicationForClasses);
			}
		return this.vRealApplicationForClassesVector;
	}

	// 프린트 라인으로 완료 되었다는 글 찍기
	public void store(String id, VLecture vLecture) {
		sendList.clear();

		this.saveVRealApplicationForClasses(id, vLecture);
		this.saveStoreMethod();

		this.send(sendList);
		System.out.println(sendList.get(0));
	}

	public Vector<VRealApplicationForClasses> getData(String id) {
		sendList.clear();

		this.saveVRealApplicationForClasses(id);
		this.saveGetDataMethod();

		return this.receivedValueObject(this.send(sendList));
	}

}
