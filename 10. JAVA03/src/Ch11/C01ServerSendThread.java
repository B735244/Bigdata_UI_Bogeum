package Ch11;

import java.io.DataOutputStream;
import java.util.Scanner;

public class C01ServerSendThread implements Runnable {
	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);

	public C01ServerSendThread(DataOutputStream dout) {
		// TODO Auto-generated constructor stub
		this.dout = dout;

	}

	@Override
	public void run() {
		String send = null;

		while (true) {
			//

			try {
				System.out.print("[Server (q: 종료) :]");
				send = sc.nextLine();
				dout.writeUTF(send);
				dout.flush();
				if (send.equals("q"))
					break;
				// Server -> Client 송신

			} catch (Exception e) {
				System.out.println("[Exception] 예외발생 Send Thread 종료!!!");
			} finally {
				
				sc.close();
			}
			try {
				dout.close();
			} catch (Exception e2) {
			}
		}

	}
}