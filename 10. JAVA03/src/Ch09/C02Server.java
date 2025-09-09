package Ch09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
;
public class C02Server {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(7000);
		System.out.println("[INFO] Server Socket Listening");

		Socket client = server.accept();
		System.out.println("[INFO] Server Accept..Client IP :" + client.getInetAddress());

		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();
		// text형태로 받아야 하는데 input 스트림은 byte 형태임

		DataInputStream din = new DataInputStream(in);
		DataOutputStream dout = new DataOutputStream(out);

		// Server -> Client(송신)
		Scanner sc = new Scanner(System.in);
		String recv = null;
		String send = null;

		while (true) {
			//
			System.out.print("[Server (q: 종료) :]");
			send = sc.nextLine();
			if (send.equals("q"))
				break;
			// Server -> Client 송신
			dout.writeUTF(send);
			dout.flush();
			
			//Client -> Server(수신)
			recv = din.readUTF();
			if(recv.equals("q"))
				break;
			System.out.println("[Client] : "+recv);
			

		}
		sc.close();
		dout.close();
		din.close();
		out.close();
		in.close();
		client.close();
		server.close();
		System.out.println("[Server] 연결을 종료하겠다. 졸려죽겠다. ");
	}

}
