package Ch10;

public class C03Worker1 implements Runnable {
	C03GUI gui;

	public C03Worker1(C03GUI c03gui) {
		this.gui = c03gui;
	}

	@Override
	public void run() {
		while (true) {
			try {
				gui.area1.append("Taks01 ....\n");
				Thread.sleep(500);
			} catch (InterruptedException e) {// 중지신호를 전달받았을 때
				e.printStackTrace();
				break;// 실제로 중지시켜줍니다.
			}
		}
		System.out.println("Worker1 Thread Interrupted....");

	}

}
