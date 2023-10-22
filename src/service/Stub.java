package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import valueObject.VLogIn;
import valueObject.VPersonalInfo;

public class Stub {
	
	ArrayList<String> objectInfoList;
	private HashMap<String, Object> objectMap;

	public Stub() {
		this.objectInfoList = new ArrayList<String>();
		this.objectMap = new HashMap<String, Object>(); 
		
		this.objectMap.put("vPersonalInfo", new VPersonalInfo());
		this.objectMap.put("vLogIn", new VLogIn());
	}

	public Object sendForRecive(ArrayList<String> sendList) {
		final String SERVER_IP = "localhost";
		final int SERVER_PORT = 10000;

		try {
			// 서버에 연결
			Socket socket = new Socket(SERVER_IP, SERVER_PORT);
			System.out.println("stub-conneted to server for recive");

			// 서버와 데이터를 주고받기 위한 입력 및출력 스트림 생성
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

			// 서버로 메시지 전송
			writer.println(sendList.size());
			for (String string : sendList) {
				writer.println(string);
				System.out.println("stub-Message sent to skeleton: " + string);
			}

			// 서버로부터 응답 받기
			int repeatCount = Integer.parseInt(reader.readLine());
			for(int i = 0; i< repeatCount; i++) {
				objectInfoList.add(reader.readLine());
				 System.out.println("Skeleton-Received: " + objectInfoList.get(i));
			}
			
			String objectName = null;
			String methodName = null;
			String args = null;
			Object valueObject = null;
			for(int i = 0; i < objectInfoList.size(); i++) {

				objectName = objectInfoList.get(i); i++;
				methodName = objectInfoList.get(i); i++;
				args = objectInfoList.get(i);
				
				Object object = this.objectMap.get(objectName);
				
				if(object instanceof VPersonalInfo) {
					try {
						object.getClass().getMethod(methodName, String.class).invoke(object, args);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					valueObject = object;
				}else if(object instanceof SPersonalInfo) {
					try {
						object.getClass().getMethod(methodName, valueObject.getClass()).invoke(object, valueObject);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			

			// 연결 종료
			socket.close();

			return valueObject;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String sendForSend(ArrayList<String> sendList) {
		final String SERVER_IP = "localhost";
		final int SERVER_PORT = 10001;

		try {
			// 서버에 연결
			Socket socket = new Socket(SERVER_IP, SERVER_PORT);
			System.out.println("stub-conneted to server for send");

			// 서버와 데이터를 주고받기 위한 입력 및출력 스트림 생성
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

			// 서버로 메시지 전송
			writer.println(sendList.size());
			for (String string : sendList) {
				writer.println(string);
				System.out.println("stub-Message sent to skeleton: " + string);
			}

			// 서버로부터 응답 받기
			String result = reader.readLine();
			System.out.println("stub-Message receive from skeleton: " + result);

			// 연결 종료
			socket.close();

			return result;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
