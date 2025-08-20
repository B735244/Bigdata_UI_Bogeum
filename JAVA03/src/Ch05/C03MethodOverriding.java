package Ch05;


//함수재정의(Method Overriding)
//상속관계를 전제로 상위클래스의 메서드를 하위클래스가 재정의(고쳐사용) 하는것을 허용하는 문법
//메서드의 헤더부분은 동일하고 본체({})의 로직을 수정하게 끔 허용함으로 다양한 형태의 객체가 형성될 수 있도록 유도(다형성)
//상위클래스로부터 동일한 메서드를 물려받더라도 각 하위클래스마다 다른기능구현의 결과물을 만들어 낼 수 있다.
// 오버로딩 vs 오버라이딩
// 1. 오버로딩 : 상속을 전제로 하지 않음.
// 함수헤더를 변경(함수이름 중복허용, 파라미터는 다양하게 적용)
// 개발자의 편의성에 중점을 둠

// 2. 오버라이딩
// 상속을 전제로 함
// 함수의 본문 변경(헤더 고정)
// 다형성을 목적으로 한 문법요소
class Animal{
	void Sound() {System.out.println("소리낸다...");}
}

class Dog extends Animal{
	void Sound() {System.out.println("멍멍");}
}

class Cat extends Animal{
	
	void Sound() {System.out.println("꺅 꼭엑!");}
}

//재정의하지 않았다면 

public class C03MethodOverriding {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Animal();
		animal.Sound();
		
		Dog dog = new Dog();
		dog.Sound();
		
		Cat cat = new Cat();
		cat.Sound();
		
		System.out.println("---------");
		animal = dog; //상위클래스형 참조변수 = 하위객체 Upcasting 알아서 왼쪽의 자료형으로 형변환시켜준다.
		animal.Sound();//멍멍소리가나옴
		animal= cat;
		animal.Sound();// cat이 재정의되어있다면 그 상속받은 cat.sound를 따라간다.

	}

}
