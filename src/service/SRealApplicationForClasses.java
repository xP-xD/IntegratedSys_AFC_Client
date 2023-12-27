package service;

import java.rmi.RemoteException;
import java.util.Vector;

import valueObject.VLecture;
import valueObject.VRealApplicationForClasses;

public class SRealApplicationForClasses extends Stub {

	Vector<VRealApplicationForClasses> vRealApplicationForClasses;
	
	public SRealApplicationForClasses() {
	}
	// 프린트 라인으로 완료 되었다는 글 찍기
	public void store(String id, VLecture vLecture) {
		try {
			remoteObject.realStore(id, vLecture);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void store(String id, Vector<String> lectures) {
		try {
			remoteObject.realStore(id, lectures);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Vector<VRealApplicationForClasses> getData(String id) {

		try {
			this.vRealApplicationForClasses = remoteObject.getRealApplicationForClassesData(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.vRealApplicationForClasses;
	}

}
