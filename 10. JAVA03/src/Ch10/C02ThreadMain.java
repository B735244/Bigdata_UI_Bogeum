package Ch10;

public class C02ThreadMain {

	public static void main(String[] args) {
		// 1. 해당 작업 개체를 만들어줍니다.
		C02Worker1 w1 = new C02Worker1();// 아직은 객체 생성만 해줬습니다.
		C02Worker2 w2 = new C02Worker2();

		// 2. worker1과 worker2를 분리해주는 작업을 해줍니다.
		// Runnable에 상속관계에 있는 Thread
		Thread th1 = new Thread(w1);
		Thread th2 = new Thread(w2);

		// 3. 각각의 Thread들을 분리하여 실행해줍니다.
		th1.start();
		th2.start();

		// 4. Thread class를 활용하는 방식도 있습니다.
		// 참조변수 없이 바로 구현해야하는 내용을 바로 붙여서 전달하는 방식입니다.
		new Thread() {

			@Override
			public void run() {
				// 상속관계이기 때문에 source에서 바로 overriding 가능함.
				for (int i = 0; i < 5; i++) {
					System.out.println("Task03...");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// 예외는 직접 처리해줍니다.
						e.printStackTrace();
					}
				}
			}

		}.start();

	}

}
