package Ch05;

//부모 Class
class Super{
	int n1;
	}

class Sub extends Super{
	int n2;
}

public class C06UpDownCastingMain {

	public static void main(String[] args) {
		
		//NoCasting(형변환 없음/ 자료형 일치)
		
		Super obj1 = new Super();//같은 클래스형
		Sub obj2 = new Sub();// 
		obj2.n1=10;
		obj2.n2 =30;
		
		//UpCasting(상위클래스 참조변수 = 하위클래스형 객체)(자동형변환)
		//자동형변환이 일어나는 이유 : 메모리 영역을 침범할 우려가 없기 때문
		//UpCasting을 사용하는 이유 : 1)상속관계에 있는 모든 하위객체를 연결할 수 있기 때문
		//                           2)Upcasting된 상태에서는 재정의된 함수에 접근이 가능하기 때문
		//
		Super obj3 = new Sub();
		obj3.n1=100;
//		obj3.n2=200;//접근 불가능
		//Super는 n2라는 범위는 모른다!! 
		//실제로는 n2가 있는데 상위클래스가 아는 범위(n1)까지만 접근이 가능한 것.
		Super obj4 = obj2;
		
		obj4.n1=400;
//		obj4.n2=600;// odbj4는 super이고 obj2는 sub이라서 n1까지밖에 접근이 안됨.
		
		//DownCasting(하위클래스 참조변수 = 상위클래스형 객체)(강제형변환)
		//UpCasting된 상태에서 DownCasting을 사용하여 원래 접근하지 못하던 하위클래스 안에 요소들을 쓸 수 있게되는 것
//		Sub obj5 =(Sub)obj1;
//		obj5.n1 =100;//실재있는 n1공간에 값 대입(문제 없음)
//		obj5.n2 =200;//없는변수에 접근하려하면 예외가 생긴다.
		
		//Upcasting 후 Downcasting한 예제
		Sub down =(Sub) obj4;
		down.n2 =987;//이제서야 n2에 접근이 가능해진다.

	}

}
