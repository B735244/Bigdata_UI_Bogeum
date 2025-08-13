package Ch07;

import java.util.Scanner;

public class C01While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//while(조건식) {
//	조건식이 true인 동안 실행되는 종속문장
//}
		//01Hello World 10회 출력
		// 탈출용 변수 : i
		// 탈출용 조건식 : i<10
		// 탈출 연삭식 : i++
//		int i =0;
//		while(true) {
//			System.out.println("Hello World!!!");
//			i++;
//		}
		
		//02

//		int n = sc.nextInt();
//		int i = 0;
//		if(n<=0)
//			System.out.printf("n은 0보다 커야 합니다\n");
//			System.exit(-1);
//		while(i<n) {
//			System.out.println(i+"Hello World!!!");
//			i++;
			//03 1부터 10까지 누적합 구하기
//			int i=0;
//			int sum=0;
//			while(i<=10) {
//				sum += i;
//			i++;
//			}
			
//			System.out.printf("1에서 10까지의 합은 : %d 입니다", sum);
			
			//04 N부터 M까지 누적합 구하기(N<M이어야 한다)
			Scanner sc = new Scanner(System.in);
//			System.out.println("숫자 두개를 입력하면 둘 중 작은 수부터 큰수까지의 정수의 합을 구해줍니다. 입력하세요.:");
//			int a= sc.nextInt();
//			int b = sc.nextInt();
//			
//			
//			if (a > b) {              // 조건을 올바르게!
//			    int sum = 0;
//			    for (int i = b; i <= a; i++) sum += i;
//			    System.out.printf("%d부터 %d까지의 합은 %d입니다.%n", b, a, sum);
//			} else {
//			    int sum = 0;
//			    for (int i = a; i <= b; i++) sum += i;
//			    System.out.printf("%d부터 %d까지의 합은 %d입니다.%n", a, b, sum);
//			}
			
			//07 n단 구구단 출력
			System.out.println("구구단을 외자, 구구단을 외자");
			int i =2;
			while(i<=9) {
				
				int d =1;
				while(d<=9) {
					int result = i*d;
					System.out.printf("%d * %d = %d \n", i, d,result);
					d++;
				}
				i++;
			}

			sc.close();
		}
	}


