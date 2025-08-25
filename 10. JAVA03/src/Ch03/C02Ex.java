package Ch03;
class 맛{// 맛이라는 클래스를 하나 만들고 그 안에 무슨 맛인지 사용할 맛들을 extends로 상속받아줍니다.
	
}

class 캬라멜 extends 맛{

	@Override
	public String toString() {
		return "캬라멜";
	}
	
}
class 버터옥수수 extends 맛 {

	@Override
	public String toString() {
		return "버터옥수수";
	}
	
}
class PopCorn<T>{
	private T 맛;
	public PopCorn(T 맛) {
		this.맛 = 맛;
		
	}
	@Override
	public String toString() {
		return "PopCorn [맛=" + 맛 + "]";
	}
	
}
public class C02Ex {

	public static void main(String[] args) {
		
		PopCorn<캬라멜> ob1 = new PopCorn<캬라멜>(new 캬라멜());
		System.out.println(ob1);
		
		PopCorn<버터옥수수> ob2 = new PopCorn<버터옥수수>(new 버터옥수수());
		System.out.println(ob2);

	}

}
