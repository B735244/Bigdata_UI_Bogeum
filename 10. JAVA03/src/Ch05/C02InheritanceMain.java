package Ch05;


class Point2D{
	
	int x;
	int y;
	
	
	Point2D(){
		System.out.println("Point2D 디폴트 생성자 호출");
	};
	Point2D(int x){
		System.out.println("Point2D(int x)생성자 호출!");
		
	}
	Point2D(int x, int y){
		System.out.println("Point2D(int x, int y)생성자 호출!");
		
	}
}

class Point3D extends Point2D{
	int z;

	Point3D(){
		super(); //상위클래스 Point2D() 생성자 호출!!
		System.out.println("Point3D 디폴트 생성자 호출");
	};
	
	Point3D(int x){super(x); System.out.println("Point3D(int x) 생성자 호출!");};
	
	@Override
	public String toString() {
		return "Point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
	}
}
public class C02InheritanceMain {

	public static void main(String[] args) {
		Point3D obj = new Point3D(10);
		obj.x =10;
		obj.y=20;
		obj.z=30;
		System.out.println(obj);

	}

}
