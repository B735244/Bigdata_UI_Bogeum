package Ch01;


class C02Simple{
	
	int n;
	
	C02Simple(int n){
		this.n =n;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof C02Simple) {
			C02Simple down = (C02Simple)obj;
		return	this.n == down.n;
			
		}
		return false;
	}
	
}
public class C02ObjectMain {

	public static void main(String[] args) {
	C02Simple obj1 =new C02Simple(11);
	C02Simple obj2 =new C02Simple(22);
	C02Simple obj3 =new C02Simple(33);
	
	
	System.out.println(obj1);
	System.out.println(obj2);
	System.out.println(obj3);
	System.out.println("---");
	
	System.out.println(obj1.equals(obj2));
	System.out.println(obj1.equals(obj3));
	

	}

}
