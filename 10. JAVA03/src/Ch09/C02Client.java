package Ch09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class C02Client {

	public static void main(String[] args) throws Exception {
		Socket client = new Socket("192.168.5.50",7000);//IP :192.168.5.11, PORT:7000
		System.out.println("Server와 연결이 되었따. 피곤하다");
		
		
		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();
		// text형태로 받아야 하는데 input 스트림은 byte 형태임

		DataInputStream din = new DataInputStream(in);
		DataOutputStream dout = new DataOutputStream(out);
		
		
				Scanner sc = new Scanner(System.in);
				String recv = null;
				String send = null;
				
				while (true) {
					
					//Server -> Client에게 수신 / 수신한걸 클라이언트가 출
					recv = din.readUTF();
					if(recv.equals("q"))
						break;
					System.out.println("[Server] : "+recv);
					
					
					System.out.print("[Client (q: 종료) ]:" );
					send = sc.nextLine();
					if (recv.equals("q"))
						break;
					// Server -> Client 송신
					dout.writeUTF(send);
					dout.flush();
					
					//Client -> Server(수신)
				;
					

				}
		
	
	}

}
