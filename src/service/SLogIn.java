package service;

import java.rmi.RemoteException;

import valueObject.VLogIn;
import valueObject.VPersonalInfo;

public class SLogIn extends Stub {
	
	VPersonalInfo vPersonalInfo;
	
	public SLogIn() {
	}
	
	public VPersonalInfo validate(VLogIn vLogIn) {
		try {
			 this.vPersonalInfo = remoteObject.validate(vLogIn);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vPersonalInfo;
	}
	
	

}
