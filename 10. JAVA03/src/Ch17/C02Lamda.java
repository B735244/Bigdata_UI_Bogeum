package Ch17;

import java.util.Scanner;

interface Printer {
//	void print(String name); // 추상 메서드
//String print(String message); 
String print();
}

public class C02Lamda {

	public static void main(String[] args) {

		// 1. 객체생성 없이 하나만 만든다는 조건 하에 람다식을 사용할 수 있음.
//		Printer printer = (message) -> {
//			System.out.println("1." + message);
//		};
//		printer.print("안녕하세요");
		
		
		// 2. 
		//Printer printer2 = (message)->{return "2."+ message;};
//		Printer printer2 = message-> "2."+ message;
//		String str =printer2.print("Hello World!!!");
//		System.out.println(str);
		
		// 3.
		Printer printer3 = ()->{
			Scanner sc = new Scanner(System.in);
			//Scanner 생성
			//키보드로 문자열 받기
			System.out.println("문자열을 쓰세요: ");
			String str = sc.nextLine();
			
		
			//입력된 값 리턴
			return str;
		};
		System.out.println(printer3.print());
	
		
	}

}
