package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Stub {

	public Stub() {
	}

	public ArrayList<String> send(ArrayList<String> sendList) {
		final String SERVER_IP = "localhost";
		final int SERVER_PORT = 10000;

		try {
			// 서버에 연결
			Socket socket = new Socket(SERVER_IP, SERVER_PORT);
//			System.out.println("stub-conneted to server for recive");

			// 서버와 데이터를 주고받기 위한 입력 및출력 스트림 생성
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

			// 서버로 메시지 전송
			writer.println(sendList.size());
			for (String string : sendList) {
				writer.println(string);
//				System.out.println("stub-Message sent to skeleton: " + string);
			}

			// 서버로부터 응답 받기
			sendList.clear();
			int repeatCount = Integer.parseInt(reader.readLine());
			for (int i = 0; i < repeatCount; i++) {
				sendList.add(reader.readLine());
//				System.out.println("Skeleton-Received: " + objectInfoList.get(i));
			}

			// 연결 종료
			socket.close();

			return sendList;

		} catch (IOException | IllegalArgumentException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
}
