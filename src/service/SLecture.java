package service;

import java.rmi.RemoteException;
import java.util.Vector;

import valueObject.VLecture;

public class SLecture extends Stub {
	
	Vector<VLecture> vLectureVector;
	
	public SLecture() {
	}

	public Vector<VLecture> getData(String fileName) {
		try {
			this.vLectureVector = remoteObject.getLectureData(fileName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.vLectureVector;
	}

}
