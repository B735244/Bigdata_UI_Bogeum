package Ch06;

//-------------------------------------
//일반클래스 상속관계
class Parent {
	void func() {
		System.out.println("Parent's func() call!!!");
	}

}

class Son extends Parent {
	void func() {
		System.out.println("Son's func() call!!!");
	}
}

// ----------------------------------------
// 추상클래스 상속관계
// 메서드 구현의 강제성 부여
abstract class Parent2 {
	abstract void func();// 추상메서드(미완성 된 함수, {}가 없음)
	// 추상클래스로 객체 생성은 불가능함.

}

class Son2 extends Parent2 {
	void func() {
		System.out.println("Son2's func() call!!!");
	}// 재정의
}
//----------------------------------------------------

public class C01AbstractMain {

	public static void main(String[] args) {
// 일반 클래스 상속관계
		Parent obj1 = new Parent();// 상위클래스형으로 객체 생성(o)
		Son obj2 = new Son();// 하위클래스형으로 객체 생성(O)
		Parent obj3 = new Son(); // 재정의된 func()접근 가능하다.
		obj3.func();
		System.out.println("--------------------------------");

// 추상 클래스 상속관계
//Parent2 obj4 = new Parent2();//추상클래스로 객체 생성 불가능 왜냐하면 미완성된 함수를 하나 이상 가지고 있기 때문이다. 완성시키고 객체 생성해야함.
		Son2 obj5 = new Son2();// 하위클래스형으로 객체 생성 가능하다 왜냐하면 Son에서는 함수가 완성되어 있기 때문에.
		obj5.func();
		Parent2 obj6 = new Son2();// Upcasting으로 연결가능! 재정의된 함수에는 접근 가능하기떄문에
		obj6.func();

	}

}