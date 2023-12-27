package service;

import java.rmi.RemoteException;

import valueObject.VPersonalInfo;

public class SPersonalInfo extends Stub {

	public SPersonalInfo() {
	}

	public String write(VPersonalInfo vPersonalInfo) {

		String result = null;
		try {
			result = remoteObject.write(vPersonalInfo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
