/**
 중요합니다
 */
package Ch03;


class C04Person{
	String name;
	int age;
	
	
	@Override
	public String toString() {
		return "C04Person [name=" + name + ", age=" + age + "]";
	}


	public C04Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}
/**
 * 
 */
public class C04ClassArrayMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
C04Person list[] = new C04Person[3];
//list[0] = new C04Person();
list[0].name = "손보금";
list[0].age = 28;

System.out.println(list[0]);
	}

}
