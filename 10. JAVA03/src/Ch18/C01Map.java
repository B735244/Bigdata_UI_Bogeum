package Ch18;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person {

	protected String name;
	protected int age;

	// default 생성자
	public Person() {
	}

	// 모든 인자 생성자
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// getter/setter
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

	// toString
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}

class Employee extends Person{
	private String department;
	private String role;
	
	//디폴트
	public Employee() {}
	public Employee(Person person) {
		this.name= person.getName();
		this.age=person.getAge();
	}

	public Employee(String department, String role) {
		super();
		this.department = department;
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [department=" + department + ", role=" + role + ", name=" + name + ", age=" + age + "]";
	}
	
	

	
	
	
}

public class C01Map {
	public static void main(String[] args) {

		// filter 함수
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(list);
		List<Integer> result = list.stream().filter((n) -> {
			return n % 2 == 0;
		})// stream을 사용하면 계속적으로 뭔가를 붙여서 사용 가능하다.
				.collect(Collectors.toList());
		System.out.println(result);

		// map
		List<Integer> list2 = list.stream().filter((n) -> {
			return n % 2 == 1;
		}).map((n) -> {
			return n * n;
		}).collect(Collectors.toList());
		System.out.println(list2);

		// sorted
		List<Person> list3 = Arrays.asList(new Person("손보금", 1), new Person("손보동", 2), new Person("손금동", 6),
				new Person("박규동", 98), new Person("짬뽕헌터", 20)

		);
		System.out.println(list3);

		// 나이 순으로 내림차순 정렬 sorted((a,b)->{return b-a;})
		List<Person> sortedList = list3.stream().sorted((a, b) -> {
			return b.getAge() - a.getAge();
		}) // 나이 내림차순
				.collect(Collectors.toList());

//		System.out.println(sortedList);
		sortedList.forEach(System.out::println);

		List<Integer> list4 = list3.stream()
				// .map((el)->{return el.getAge();})
				.map(Person::getAge).collect(Collectors.toList());
		System.out.println(list4);

		List<Integer> list5 = list3.stream().map(Person::getName)// 메서드 참조(::) 이용 -> Person
				.map(String::length).collect(Collectors.toList());
		System.out.println(list5);

		
		List <Employee> list6 = list3.stream()
			//	.map((el)->{return new Employee(el);})
				.map(Employee::new)
				.collect(Collectors.toList());
	System.out.println(list6);
	}

}
