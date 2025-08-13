package Ch01;

public class C01Main {

	public static void main(String[] args) {
		C01Person son = new C01Person();
		son.name = "손보금";
		son.age = 28;
		son.height= 160.0f;
		son.weight = 41.0;
		
		System.out.printf("%s %d %f %f \n", son.name, son.age, son.height,son.weight);
				

	}

}
