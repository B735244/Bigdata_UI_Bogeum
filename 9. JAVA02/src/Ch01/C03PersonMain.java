package Ch01;


class C03Person {

	
	// 속성
	public String name;
	public int age;
	public float height;
	public double weight;
	
	//기능
	
void talk( ) {System.out.printf("%s 님이 말합니다. \n", this.name);}
void walk( ) {System.out.printf("%s 님이 걷습니다. \n", this.name);}
void showInfo() {System.out.printf("%s %d %f %f \n", this.name, this.age, this.height, this.weight);}
@Override
public String toString() {
	return "C03Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
}



}

public class C03PersonMain {

	
	public static void main(String[] args) {
		C03Person son = new C03Person();
		son.name = "손보금";
		son.age = 28;
		son.height= 160.0f;
		son.weight = 41.0;
		
		
		son.talk();
		son.walk();
		son.showInfo();
				
		System.out.println(son.toString());
		System.out.println(son);

	}

}
