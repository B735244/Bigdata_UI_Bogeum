package Ch01;
//변수 종류

//멤버 변수 : 클래스 내부 - 메서드 영역 외부 사이, 객체 개별데이터 저장용도
//지역변수 : 메서드 영역 내부에서 생성되는 변수
//(or)매서드 영역 내부에서 {}가 명시되어 있을 때 해당{} 내에서 생성되는 변수도 포함)
//파라미터 ,일반변수..
//static 변수 : 동일 클래스로부터 생성된 여러 객체 간 공유하는 멤버변수

class C05Simple
{
	//속성
	int num =10;
	void Func1() {
		System.out.println("num:" +num);
		int num = 20;//Func1의 지역변수
		num++;
		this.num++;// 객체 전체의 전역변수입니다.
		System.out.println("num:" +num);
	}
	
	void Func2() {
		System.out.println("num:" +num);
		if(num>0) {//멤버변수의 num
			int num =100;// if문 내의 지역변수
			System.out.println("num:" +num);
		}
		System.out.println("num:" +num);
		
		while(num<20) {
		System.out.println("num:"+ num);
		num++;
		}
	}
	
	
	void Func3(int num){
		this.num = num;
	
		
	}
	}


public class C05LocalVarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
C05Simple obj = new C05Simple();
obj.Func1();
System.out.println("-------------------");
obj.Func2();
	}

}
