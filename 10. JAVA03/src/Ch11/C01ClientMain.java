package Ch11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class C01ClientMain {
	public static void main(String[] args) throws Exception {
		Socket client = new Socket("192.168.5.35", 7015);// IP :192.168.5.11, PORT:7000
		System.out.println("Server와 연결이 되었따. 피곤하다");

		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();
		// text형태로 받아야 하는데 input 스트림은 byte 형태임

		DataInputStream din = new DataInputStream(in);
		DataOutputStream dout = new DataOutputStream(out);

		//
		C01ClientRecvThread recv = new C01ClientRecvThread(din);
		C01ClientSendThread send = new C01ClientSendThread(dout);

		Thread th1 = new Thread(recv);
		Thread th2 = new Thread(send);

		th1.start();
		th2.start();

		th1.join();
		th2.join();

		dout.close();
		din.close();
		out.close();
		in.close();
		client.close();

		System.out.println("[Server] 연결을 종료하겠다. 졸려죽겠다. ");
	}
}
