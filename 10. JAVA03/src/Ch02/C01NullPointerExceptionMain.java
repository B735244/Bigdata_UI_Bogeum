package Ch02;

public class C01NullPointerExceptionMain {
	public static void main(String[] args) {
		try {
String str = null;
System.out.println(str.toString());
		}catch(NullPointerException e) {
			System.out.println("예외 발생:"+ e);
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
System.out.println("실행되어야 할 코드1");
System.out.println("실행되어야 할 코드2");
}
}