package Ch05;


class A{
	int a;

	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}
	
	
}
class B extends A{
	int b;

	@Override
	public String toString() {
		return "B [b=" + b + ", a=" + a + "]";
	}

	
	}
	

class C extends A{
	int c;

	@Override
	public String toString() {
		return "C [c=" + c + ", a=" + a + "]";
	}


	
}
//---------------------------------------------------------------

class D extends B{
	int d;

	@Override
	public String toString() {
		return "D [d=" + d + ", b=" + b + ", a=" + a + "]";
	}

	
}
class E extends B{
	int e;

	@Override
	public String toString() {
		return "E [e=" + e + ", b=" + b + ", a=" + a + "]";
	}


	
}
//----------------------------------------------------------------

class F extends C{
	int f;

	@Override
	public String toString() {
		return "F [f=" + f + ", c=" + c + ", a=" + a + "]";
	}

	
}
class G extends C{
	int g;

	@Override
	public String toString() {
		return "G [g=" + g + ", c=" + c + ", a=" + a + "]";
	}

	
	
}
//---------------------------------------------------------------
public class C07UpDownCasting {
	//A class는 최상위 클래스
	public static void UpDownCastTestFunc(A obj) {
		
		obj.a=100;
		if(obj instanceof B) {
		B down1 = (B)obj;
		down1.b=200;
	}
		if(obj instanceof C) {
			C down1=(C)obj;
			down1.c=230;
		}
		if(obj instanceof D) {
			D down1=(D)obj;
			down1.d=240;
		}
		if(obj instanceof E) {
			E down1=(E)obj;
			down1.e=250;
		}
		if(obj instanceof F) {
			F down1=(F)obj;
			down1.f=260;
		}
		if(obj instanceof G) {
			G down1=(G)obj;
			down1.g=270;
		}
		
		
		
		System.out.println(obj);
		
		
	}

	
	
	
	public static void main(String[] args) {
		UpDownCastTestFunc(new A());
		UpDownCastTestFunc(new B());
		UpDownCastTestFunc(new C());
		UpDownCastTestFunc(new D());
		UpDownCastTestFunc(new E());
		UpDownCastTestFunc(new F());
		UpDownCastTestFunc(new G());


	}

}
