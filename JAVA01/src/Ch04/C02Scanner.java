package Ch04;

import java.util.Scanner;

public class C02Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);

System.out.print("정수입력:");
int num1 = sc.nextInt();
System.out.println("입력된 정수 값 : "+num1);

System.out.print("실수입력:");
double num2 = sc.nextInt();
System.out.println("입력된 정수 값 : "+num2);

System.out.print("문자열 입력:");
//String str1 = sc.nextInt();// 문자열 입력받기 기능 함수, 띄어쓰기
//System.out.println("입력된 정수 값 : "+str1);
sc.nextLine();
String str1 = sc.nextLine();
System.out.println("입력된 문자열: "+(int)str1.charAt(0));

sc.close();


	}

}
