package service;

import java.rmi.RemoteException;
import java.util.Vector;

import valueObject.VLecture;
import valueObject.VPreApplicationForClasses;

public class SPreApplicationForClasses extends Stub {

	Vector<VPreApplicationForClasses> vPreApplicationForClassesVector;
	
	public SPreApplicationForClasses() {
	}
	// 프린트 라인으로 완료 되었다는 글 찍기
	public void store(String id, VLecture vLecture) {
		try {
			remoteObject.preStore(id, vLecture);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void store(String id, Vector<String> lectures) {
		try {
			remoteObject.preStore(id, lectures);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Vector<VPreApplicationForClasses> getData(String id) {

		try {
			this.vPreApplicationForClassesVector = remoteObject.getPreApplicationForClassesData(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.vPreApplicationForClassesVector;
	}

}
