package Ch02;

import java.awt.AWTException;

class A{
	public void Ex1() throws NullPointerException {
		System.out.println("A의 Ex Func call!!!");
		
		String a =null;
		a.toString();
		System.out.println("Ex1에서 실행되어야 할 코드");
		
	}
	
}
class B{
	public void Ex2() throws AWTException {
		System.out.println("B의 Ex Func call!!!");
		throw new AWTException("AWT 예외발생!!!");
	}
}
public class C06ThrowAndThrowsMain {
	public static void main(String[] args) {
		A ob1 = new A();
		B ob2 = new B();
		try {
		ob1.Ex1();
		ob2.Ex2();
		}catch(NullPointerException e ) {System.out.println("NULLPOINTER 예외처리!");}
		catch(AWTException e1) {System.out.println("AWT 예외처리!!!");}
	}

}
