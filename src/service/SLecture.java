package service;

import java.util.ArrayList;
import java.util.Vector;

import valueObject.VLecture;

public class SLecture extends Stub {
	
	private ArrayList<String> sendList;
	private Vector<VLecture> vLectureVector;

	public SLecture() {
		sendList = new ArrayList<String>();
	}

	public void saveVLecture(String fileName) {
		sendList.add("vLecture");
		sendList.add("setFileName");
		sendList.add(fileName);
	}

	public void saveGetDataMethod() {
		sendList.add("sLecture");
		sendList.add("getData");
		sendList.add("");
	}

	public Vector<VLecture> receivedValueObject(ArrayList<String> sendList) {
		if(sendList.size() > 1) {
			this.vLectureVector = new Vector<VLecture>();
			for(int i = 0; i<sendList.size();i++) {
				VLecture vLecture = new VLecture();
				
				vLecture.setId(sendList.get(i++));
				vLecture.setLecture(sendList.get(i++));
				vLecture.setProfessor(sendList.get(i++));
				vLecture.setCredit(sendList.get(i++));
				vLecture.setTime(sendList.get(i));
				
				vLectureVector.add(vLecture);
			}
			
		}
		return this.vLectureVector;
	}

	public Vector<VLecture> getData(String fileName) {
		this.saveVLecture(fileName);
		this.saveGetDataMethod();

		return this.receivedValueObject(this.send(sendList));
	}

}
