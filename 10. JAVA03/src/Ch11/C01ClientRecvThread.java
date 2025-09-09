package Ch11;

import java.io.DataInputStream;

public class C01ClientRecvThread implements Runnable {
	DataInputStream din;

	public C01ClientRecvThread(DataInputStream din) {
		this.din = din;
	}

	@Override

	public void run() {
		String recv = null;
		while (true) {
			//

			try {
				// Client -> Server(수신)
				recv = din.readUTF();
				if (recv.equals("q"))
					break;
				System.out.println("[Client] : " + recv);

			} catch (Exception e) {
				System.out.println("[Exception] 예외발생 Recieve Thread 종료!!!");
				break;
			}
//				

		}
	}

}
