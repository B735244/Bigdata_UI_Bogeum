package Ch02;


class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}



public class C04ClassCastExceptionMain {

	public static void main(String[] args) {
		Animal bodong =new Dog();//upcasting
		Animal geumdong = new Cat();//upcasting
		
		//Dog로 다운캐스팅
		try {
		Dog down1 = (Dog)bodong;
		Dog down2 = (Dog)geumdong;//예외 발생!!! -> 
		}catch(ClassCastException e) {e.printStackTrace();}

	}

}
