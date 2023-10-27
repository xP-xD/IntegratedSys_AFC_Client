package service;

import java.util.ArrayList;

import valueObject.VLogIn;
import valueObject.VPersonalInfo;

public class SLogIn extends Stub {
	
	private ArrayList<String> sendList;
	private VPersonalInfo vPersonalInfo;
	
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
	
	public VPersonalInfo receivedValueObject(ArrayList<String> sendList) {
		if(sendList.size() > 1) {
			vPersonalInfo = new VPersonalInfo();
			for(int i =0; i <sendList.size(); i++) {
				vPersonalInfo.setId(sendList.get(i++));
				vPersonalInfo.setPassword(sendList.get(i++));
				vPersonalInfo.setName(sendList.get(i));
			}
		}else {
			System.out.println(sendList.get(0));
		}
		return vPersonalInfo;
	}
	
	public VPersonalInfo sendLogInInfo(VLogIn vLogIn) {
		this.saveVLogInInfo(vLogIn);
		this.saveSLogInInfo();
		
		VPersonalInfo vPersonalInfo = this.receivedValueObject(this.send(sendList));
		return vPersonalInfo;
	}
	
	

}
