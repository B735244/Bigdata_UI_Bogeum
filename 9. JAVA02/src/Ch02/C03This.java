package Ch02;
class C03Simple

{
	int x;
	int y;
	
	
	C03Simple(){
	
		System.out.println("C03Simple()호출");
	}
	C03Simple(int x){
		this(x,0);
//		this.x=x;
		System.out.println("C03Simple(int x)호출");
	}
	C03Simple(int x,int y){
		this.x=x;
		this.y=y;
		System.out.println("C03Simple(int x, int y)호출");
	}
	
	
	public C03Simple getThis() {
		return this;
	}
	
	
	
}
public class C03This {

	public static void main(String[] args) {
		C03Simple obj = new C03Simple();
	}

}
