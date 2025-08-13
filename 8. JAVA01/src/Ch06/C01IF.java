package Ch06;

import java.util.Scanner;

public class C01IF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Scanner sc =new Scanner(System.in);
//System.out.print("나이:");
//int age = sc.nextInt();
//if(age >=8)
//	System.out.println("학교에 다닙니다");
//
//System.out.println("첫번째 IF문 종료");
//
//if(age<8)
//	System.out.println("학교에 다니지 않습니다");
//
//System.out.println("두번재 IF문 종료");
//System.out.println("프로그램을 종료합니다");
//
//sc.close();


Scanner sc = new Scanner(System.in);
//int 과목1 = sc.nextInt();
//int 과목2 = sc.nextInt();
//int 과목3 = sc.nextInt();
//int 과목4 = sc.nextInt();
//double avg = (double)(과목1+과목2+과목3+과목4)/4;
//
//if(과목1<40) {
//	System.out.println("불합격");
//}
//
//else if(과목2<40) {
//	System.out.println("불합격");
//}
//	
//	else if(과목3<40) {
//		System.out.println("불합격");
//}
//
//else if(과목4<40) {
//	System.out.println("불합격");
//}
//else if(avg<60)
//{
//	System.out.println("불합격");
//}
//
//else {
//	System.out.println("합격");
//}

System.out.println("점수를 입력하세요:");
int class1 =sc.nextInt();
if(class1>=90 && class1<=100) {
	
	System.out.printf("A");
}

else if(class1>=80 && class1<90) {
	System.out.printf("B");
}
else if(class1>=70 && class1<80) {
	System.out.printf("C");
}
else if(class1>=60 && class1<70) {
	System.out.printf("D");
}
else {System.out.printf("F");}


}
	
}



