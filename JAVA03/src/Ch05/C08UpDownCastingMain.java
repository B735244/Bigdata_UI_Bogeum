package Ch05;


class Parent
{
	void func1() {System.out.println("Parent's func1() call!!!");}
	void func2() {System.out.println("Parent's func2() call!!!");}
	}
	
class Son extends Parent{
	void func2() {System.out.println("Son's func2() call!!!");}//재정의
}
public class C08UpDownCastingMain {

	public static void main(String[] args) {
		//NoCasting
		Parent obj1 =new Parent();
		obj1.func1();
		System.out.println("----------------------------------------");
		
		//NoCasting
		Son obj2 = new Son();
		obj2.func1();
		obj2.func2();
		System.out.println("----------------------------------------");
		
		//UpCasting
		Parent obj3 =new Son();
		obj3.func1();
		obj3.func2();
		System.out.println("----------------------------------------");
		//UpCasting 된 상태에서
		//확장된(멤버추가) 멤버변수 및 함수 접근 가능한가? X -> Downcasting해줘야 함
		// 재정의된 멤버함수 접근 가능한가? O -> 가능하다 이미 부모가 갖고있는 변수이기때문에 애초에 할당된 메모리 영역이 부모영역이 더 큼/ 그래서 그냥 사용 가능한 것.
	}

}



//클래스구조(속성/기능/생성자)
//오버로딩(생성자, 멤버함수)
//정보은닉/ this/static/배열

//2)상속
//상속개념(상-하/ 속성기능 물려받는 개념0)
//오버라이딩
//캐스팅(no/up/down)
//upcasting : 상위클래스형 참조변수 = 하위객체
//-모든 상속관계의 생성된 객체를 단일 참조변수로 바인딩하기 위함
//= 재정의된 메서드에 접근하기 위함

//downcasting: 하위클래스형 참조변수 = 상위객체
