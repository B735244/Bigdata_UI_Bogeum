package Ch05;

class Employee {
	public String name;
	protected int age;// 상속받은 하위클래스에서도 이 변수를 사용할 수 있음.
	protected String addr;

//기본인자생성자
	public Employee() {
	}

	// 모든인자생성자
	public Employee(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	// getter, setter 생성자
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

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}

}

class Parttimer extends Employee {
	private int hour_pay;
//기본생성자
	public Parttimer() {
	}
//getter/setter
	public void setHour_pay(int hour_pay) {
		this.hour_pay = hour_pay;
	}
//전체인자생성자
	public Parttimer(String name, int age, String addr, int hour_pay) {
		super(name, age, addr);
		this.hour_pay = hour_pay;
	}
	@Override
	public String toString() {
		return "Parttimer [hour_pay=" + hour_pay + ", name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}


}

class Regular extends Employee {
	private int salary;
	
	public Regular() {}

	public Regular(String name, int age, String addr, int salary) {
		super(name, age, addr);
		this.salary = salary;
	}

	
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Regular [salary=" + salary + ", name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
	
	
	
	
	
}

public class C05Ex {

	public static void main(String[] args) {
	Parttimer emp1 = new Parttimer("손보굼", 28,"진주",4000);
	emp1.setAge(100);
	
	Regular emp2 = new Regular("손보동",4,"진주",5000);
	emp2.setAge(400);

	}

}
