package Ch11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class C01ServerMain {

	public static void main(String[] args) throws Exception{
		
		ServerSocket server = new ServerSocket(7006);
		System.out.println("[INFO] Server Socket Listening");

		Socket client = server.accept();
		System.out.println("[INFO] Server Accept..Client IP :" + client.getInetAddress());

		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();
		// text형태로 받아야 하는데 input 스트림은 byte 형태임

		DataInputStream din = new DataInputStream(in);
		DataOutputStream dout = new DataOutputStream(out);
		
		//
		C01ServerRecvThread recv = new C01ServerRecvThread(din);
		C01ServerSendThread send = new C01ServerSendThread(dout);
		
		Thread th1 = new Thread (recv);
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
		server.close();
		System.out.println("[Server] 연결을 종료하겠다. 졸려죽겠다. ");
	}

}
