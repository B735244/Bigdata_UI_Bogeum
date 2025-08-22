package Ch01;


class A{
	int x;
	int y;
	
	@Override
	public String toString() {
		return "A [x=" + x + ", y=" + y + "]";
	}
	
}
public class C01ObjectMain {

	public static void main(String[] args) {
	A obj1 = new A();
	obj1.toString();
	System.out.println(obj1);
	System.out.println(obj1.toString());
	
	Object obj2 = new Object();
	System.out.println(obj2);
	System.out.println(obj2.toString());
	
	}

}
