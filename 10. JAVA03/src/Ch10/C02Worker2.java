package Ch10;

public class C02Worker2 implements Runnable{

	@Override
	public void run() {
//반드시 만들어줘야 하는 run()함수
		for (int i=0; i<5; i++) {
			 System.out.println("Task02...");
			 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// 직접 예외를 관리해줍니다.
				e.printStackTrace();
			}
			 
		 }

		
	}

}
