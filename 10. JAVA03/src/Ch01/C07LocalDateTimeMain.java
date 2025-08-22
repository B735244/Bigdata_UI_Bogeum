package Ch01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class C07LocalDateTimeMain {

	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
//		System.out.print("YYYY/MM/DD 입력 :");
//		String ymd = sc.next();
//
//		// 포매터 객체 생성(입력용)
//		DateTimeFormatter fmtin = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//		LocalDate date = LocalDate.parse(ymd, fmtin);
//		System.out.println(date);
//		
//		DateTimeFormatter fmtout = DateTimeFormatter.ofPattern("yyyy--MM--dd");
//		System.out.println("출력 포맷 :" +fmtout.format(date));
	
		
		Scanner sc = new Scanner(System.in);
		System.out.print("YYYY/MM/DD HH:MM:SS 입력 :");
		String ymd = sc.nextLine();
		DateTimeFormatter fmtin = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime date = LocalDateTime.parse(ymd, fmtin);
		System.out.println(date);
		
		DateTimeFormatter fmtout = DateTimeFormatter.ofPattern("yyyy--MM--dd HH-mm-ss");
		System.out.println("출력 포맷 :" +fmtout.format(date));
	
	
	}
	


}
