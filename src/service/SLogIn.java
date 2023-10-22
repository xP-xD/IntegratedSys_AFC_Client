package service;

import java.util.ArrayList;

import valueObject.VLogIn;
import valueObject.VPersonalInfo;

public class SLogIn extends Stub {
	
	private ArrayList<String> sendList;
	
	public SLogIn() {
		sendList = new ArrayList<String>();
	}
	
	public void saveVLogInInfo(VLogIn vLogIn) {
		sendList.add("vLogIn");
		sendList.add("setId");
		sendList.add(vLogIn.getId());
		
		sendList.add("vLogIn");
		sendList.add("setPassword");
		sendList.add(vLogIn.getPassword());
	}
	
	public void saveSLogInInfo() {
		sendList.add("sLogIn");
		sendList.add("validate");
		sendList.add("");
	}
	
	public VPersonalInfo sendLogInInfo(VLogIn vLogIn) {
		saveVLogInInfo(vLogIn);
		saveSLogInInfo();
		
		VPersonalInfo vPersonalInfo = (VPersonalInfo)this.sendForRecive(sendList);
		return vPersonalInfo;
	}
	
	

}
