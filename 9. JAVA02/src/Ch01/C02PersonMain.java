package Ch01;


class C02Person {

	
	// 속성
	public String name;
	public int age;
	public float height;
	public double weight;
	
	//기능
	



}

public class C02PersonMain {

	
	public static void main(String[] args) {
		C02Person son = new C02Person();
		son.name = "손보금";
		son.age = 28;
		son.height= 160.0f;
		son.weight = 41.0;
		
		System.out.printf("%s %d %f %f \n", son.name, son.age, son.height,son.weight);
				

	}

}
