package Ch01;
//생성자 메서드
//ex) Scanner sc = new Scanner(System.in)
//생성자 메서드 Scanner();

//객체 생성 시 한 번만 호출되는 메서드 
//생성 된 객체 내에서는 사용이 불가능
//객체 생성 시에 필요한 메모리 공간 형성과 초기값을 부여하는데 사용 됨.
//생성자 메서드의 이름은 Class명과 동일하게 부여해야 함
//생성자 메서드는 반환자료형을 가지지 않음.

//생성자 함수를 클래스 내에서 명시하지 않으면(코드 삽입x) 컴파일러에 의해서 기본 생성자 함수가 주입 됨.(디폴트 생성자)

class C08Simple{
	
	int n1;
	double n2;
	boolean n3;
String n4;

//디폴트생성자
C08Simple(){
System.out.println("C08Simple()생성자 호출");
this.n1=10;
this.n2=10.10;
this.n3= false;
this.n4 = "손보금입니다";
}



C08Simple(int n1){
	System.out.println("C08Simple(int n1)생성자 호출");
	this.n1= n1;
}
C08Simple(int n1, double n2){
	System.out.println("C08Simple(int n1, int n2)생성자 호출");
	this.n1 =n1;
	this.n2 =n2;
	
}
C08Simple(int n1, double n2, boolean n3)
{
	System.out.println("C08Simple(int n1, int n2, int n3)생성자 호출");
	this.n1 =n1;
	this.n2 =n2;
	this.n3=n3;
	}
C08Simple(int n1, double n2, boolean n3, String n4){
	System.out.println("C08Simple(int n1, int n2, int n3, int n4)생성자 호출");
	this.n1 =n1;
	this.n2 =n2;
	this.n3=n3;
	this.n4= n4;
}








@Override
public String toString() {
	return "C08Simple [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + "]";
}
}
public class C08ConstructorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
C08Simple obj =new C08Simple();
C08Simple obj1 =new C08Simple(10);
C08Simple obj2 =new C08Simple(10,10.1);
C08Simple obj3 =new C08Simple(10,10.1,false);
C08Simple obj4=new C08Simple(10,10.1,false,"손보금");


	}

}
