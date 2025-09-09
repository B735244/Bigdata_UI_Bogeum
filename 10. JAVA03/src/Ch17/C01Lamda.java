package Ch17;

import java.util.ArrayList;
import java.util.List;

class Person {
	private String name;
	private int age;
	private String addr;

	// 1. 기본 인자 생성
	public Person() {
	}

	// 2. 모든 인자 생성
	public Person(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

//Getter/Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

//toString
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}

}

public class C01Lamda {

	public static void main(String[] args) {
		List <Person> list = new ArrayList();
		list.add(new Person("손보금",28,"진주"));
		list.add(new Person("손보동",4,"진주"));
		list.add(new Person("손금동",5,"진주"));
		
		list.stream().forEach((item)->{System.out.println(item);});
		System.out.println("===================================");
		
		list.sort((a,b)->{return b.getAge()-a.getAge();});
		list.stream().forEach((item)->{System.out.println(item);});

	}

}
