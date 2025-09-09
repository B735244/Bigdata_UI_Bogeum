package Ch10;

public class C02Worker1 implements Runnable {

	@Override
	public void run() {
		//반드시 만들어줘야 하는 함수 run()
		for (int i=0; i<5; i++) {
			 System.out.println("Task01...");
			 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// 직접 예외를 관리해줍니다.
				e.printStackTrace();
			}
			 
		 }
		 

		
		
	}

}
