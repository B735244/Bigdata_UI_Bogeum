package Ch02;
import java.util.Scanner;
public class C03Ex {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		try {
		System.out.print("나눗셈을 위한 두 값을 입력하세요:");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();

		System.out.println("나눗셈 결과: " + n1 / n2);
		}
		catch(ArithmeticException e ) {
			System.out.println("예외 발생:"+ e);
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
			
		}finally {
		
		}
	
		
		System.out.println("실행되어야 할 코드 1");
		System.out.println("실행되어야 할 코드 2");
		System.out.println("프로그램 종료");
		

	}

}
