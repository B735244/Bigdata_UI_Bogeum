package Ch11;

import java.io.DataInputStream;

public class C01ServerRecvThread implements Runnable {
	DataInputStream din;

	public C01ServerRecvThread(DataInputStream din) {
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
				System.out.println("[Server] : " + recv);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("[Exception] 예외발생 Recieve Thread 종료!!!");
				break;
			}
//			

		}
	}
}