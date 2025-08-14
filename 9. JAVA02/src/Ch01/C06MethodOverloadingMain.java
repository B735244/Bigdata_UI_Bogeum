
package Ch01;
//Overloading이란 함수이름이 동일하게 두어 인자를 다양하게 받을 수 있음
//반환형도 같아야하고 이름도 같아야하지만 파라미터만 다름
import java.util.Scanner;

class C06Simple {
	// 속성
	Scanner sc = new Scanner(System.in);
	// 기능
	public int sum(int n1, int n2) {
		System.out.println("sum1 함수 호출");
		return n1 + n2;
	}
	//-------------------------
	
	
	public int sum(int n1, int n2, int n3) {
		System.out.println("sum2 함수 호출");
		return n1 + n2+n3;
	}
	
	//---------------------------
	
	public int sum(int n1, int n2, int n3, int n4) {
		System.out.println("sum3 함수 호출");
		return n1 + n2+n3 +n4;
	}
}
public class C06MethodOverloadingMain{

	public static void main(String[] args) {
		C06Simple sumCalc = new C06Simple();
		System.out.println(sumCalc.sum(10, 20));
		System.out.println(sumCalc.sum(10,20,55));
		sumCalc.sum(10,20,55,121);//객체만 호출하고 출력은 안했음.
		System.out.println(sumCalc.sum(10,20,55,121));
		
	}

}

