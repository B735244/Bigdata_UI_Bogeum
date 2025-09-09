package Ch10;

public class C01ThreadMain {

	public static void main(String[] args) throws InterruptedException {
	 for (int i=0; i<5; i++) {
		 System.out.println("Task01...");
		 Thread.sleep(500);
		 
	 }
	 
	 for (int i=0; i<5; i++) {
		 System.out.println("Task02...");
		 Thread.sleep(500);
		 
	 }
	}

}
