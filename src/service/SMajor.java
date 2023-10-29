package service;

import java.util.ArrayList;
import java.util.Vector;

import valueObject.VMajor;

public class SMajor extends Stub {

	private ArrayList<String> sendList;
	private Vector<VMajor> vMajorVector;

	public SMajor() {
		sendList = new ArrayList<String>();
	}

	public void saveVMajor(String fileName) {
		sendList.add("vMajor");
		sendList.add("setFileName");
		sendList.add(fileName);
	}

	public void saveGetDataMethod() {
		sendList.add("sMajor");
		sendList.add("getData");
		sendList.add("");
	}

	public Vector<VMajor> receivedValueObject(ArrayList<String> sendList) {
		if(sendList.size() > 1) {
			this.vMajorVector = new Vector<VMajor>();
			for(int i = 0; i<sendList.size();i++) {
				VMajor vMajor = new VMajor();
				
				vMajor.setId(sendList.get(i++));
				vMajor.setText(sendList.get(i++));
				vMajor.setFileName(sendList.get(i));
				
				vMajorVector.add(vMajor);
			}
			
		}
		return this.vMajorVector;
	}

//	sMajor.getData("root");
//	sMajor.getData(fileName);
	public Vector<VMajor> getData(String fileName) {
		this.saveVMajor(fileName);
		this.saveGetDataMethod();

		return this.receivedValueObject(this.send(sendList));
	}

}
