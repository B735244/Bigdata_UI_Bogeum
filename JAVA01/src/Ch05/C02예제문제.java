package Ch05;
import java.util.Scanner;

public class C02예제문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.문제(삼항연산자 + 논리연산자)
		// 키보드로 국어/영어/수학 점수를 입력받아 각각의부분점수가 40점이상이고
		// 총점수합의 평균이 70점이상이면 '합격'
		// 미만이면 '불합격'을 출력합니다
		
//		System.out.print("국어/영어/수학 점수를 입력 : ");
//		
//		int kor = sc.nextInt();
//		int eng = sc.nextInt();
//		int math = sc.nextInt();
//		double avg = (double)(kor + eng + math)/3;	
//		String result =  (kor>=40&&eng>=40&&math>=40&&avg>=70) ? "합격" : "불합격";
//		System.out.println("시험결과 : " + result);
//		sc.close();
		
		//2.미니문제(%연산자)
		//키보드로 부터 정수값 2개를 입력받아
		//두수의 합이 짝수이면 "짝수입니다"
		//홀수이면 "홀수입니다" 를 출력하세요~
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하시면 짝수 홀수를 구분해드립니다:");
		int even = sc.nextInt();
		
		String result1  = (even%2==0) ? "짝수입니다." : "홀수입니다.";
		System.out.println("짝수일까요 홀수일까요? :"+result1);
		sc.close();

	}
	


	//2.미니문제(%연산자)
	//키보드로 부터 정수값 2개를 입력받아
	//두수의 합이 짝수이면 "짝수입니다"
	//홀수이면 "홀수입니다" 를 출력하세요~



}
