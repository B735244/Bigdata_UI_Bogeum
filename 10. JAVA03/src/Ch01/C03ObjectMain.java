package Ch01;

import java.util.Objects;

class C03Simple{
	
	int n;
	
	C03Simple(int n){
		this.n =n;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.n);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		C03Simple other = (C03Simple) obj;
		return n == other.n;
	}
	
}
public class C03ObjectMain {

	public static void main(String[] args) {
	C03Simple obj1 =new C03Simple(11);
	System.out.println(obj1.toString());
	System.out.printf("%x \n", obj1.hashCode());
	

	}

}
