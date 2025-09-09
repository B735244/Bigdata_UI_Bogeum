package Ch11;

import java.io.DataOutputStream;
import java.util.Scanner;

public class C01ClientSendThread implements Runnable {
	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);

	public C01ClientSendThread(DataOutputStream dout) {
		this.dout = dout;
	}

	@Override
	public void run() {
		String send = null;

		while (true) {
			//

			try {
				System.out.print("[Client (q: 종료) :]");
				send = sc.nextLine();
				// Client -> Server 송신
				dout.writeUTF(send);
				dout.flush();
				if (send.equals("q"))
					break;
				

			} catch (Exception e) {
				System.out.println("[Exception] 예외발생 Send Thread 종료!!!");
			}
				
				sc.close();
			
			
		}

	}
}
