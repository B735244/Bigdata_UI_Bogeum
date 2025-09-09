package Ch17;

//+ ,-, *, /을 수행하는 함수형 인터페이스 정의
interface Calculator{
	
	
int calculate (int num1, int num2);
}
public class C03Lamda {

	public static void main(String[] args) {
		
		Calculator add = (num1, num2)->{
			return num1+num2;
		};
		
		Calculator sub = (num1,num2)->{
			return num1 - num2;
		};
		
		Calculator mul =(num1, num2)->{
			return num1*num2;
		};
		
		Calculator div =(num1, num2)->{
			return num1/num2;
		};
		
		
		System.out.println(add.calculate(10,20));
		System.out.println(sub.calculate(30,20));
		System.out.println(mul.calculate(10,20));
		System.out.println(div.calculate(100,20));
		
		//
//		System.out.println(add.calculate(10, 20,50,60,70,80,90,100));

	}

}
