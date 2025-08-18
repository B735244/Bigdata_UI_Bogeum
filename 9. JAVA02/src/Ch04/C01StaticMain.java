package Ch04;
//static : 공유메모리에 변수/메서드 적재, 객체생성과는 무관하게 공간 할당, 클래스 명으로 접근가능 

class C01Simple{
	
	static int n1;
	int n2;
	
	
	public C01Simple(){
		
	}


	public C01Simple(int n1, int n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}



	@Override
	public String toString() {
		return "C01Simple [n1=" + n1 + ", n2=" + n2 + "]";
	}
	
}


public class C01StaticMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
C01Simple.n1=100;
System.out.println(C01Simple.n1);

C01Simple ob1 =new C01Simple();
C01Simple ob2 =new C01Simple();

System.out.println("ob1:"+ob1);
System.out.println("ob2:"+ob2);

	}

}
