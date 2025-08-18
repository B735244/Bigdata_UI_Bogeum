package Ch04;

class C02Simple{
	
	
	static int n1;
	int n2;
	
	void func1() {
n1 =100;
	n2=200;}
	static void func2() {
		n1=300;
//		n2=400; //문제 발생 왜? static은 객체생성을 안해도 만들어짐. 아직 n2가 생성이 되지도 않았을 수도 있는데 값을 먼저 대입해버리니까 오류가 발생한다.
	}
}

public class C02StaticMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
