package service;

import java.rmi.RemoteException;
import java.util.Vector;

import valueObject.VMajor;

public class SMajor extends Stub {

	Vector<VMajor> vMajorVector;
	
	public SMajor() {
	}

//	sMajor.getData("root");
//	sMajor.getData(fileName);
	public Vector<VMajor> getData(String fileName) {
		try {
			this.vMajorVector = remoteObject.getMajorData(fileName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.vMajorVector;
	}

}
