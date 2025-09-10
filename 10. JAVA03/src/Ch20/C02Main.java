package Ch20;


@C01CustomAnnotation(value ="손보금", number= 203,isOpen =true)
class Simple{
	
	String value;
	int number;
	boolean isOpen;
	
	Simple(){
	C01CustomAnnotation ref=	this.getClass().getAnnotation(C01CustomAnnotation.class);
	System.out.println("VALUE: " +ref.value());
	System.out.println("NUMBER:" +ref.number());
	System.out.println("ISOPEN:"+ref.isOpen());
	this.value=ref.value();
	this.number=ref.number();
	this.isOpen=ref.isOpen();
	
		
	}
}

public class C02Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simple obj = new Simple();
		System.out.println(obj);

	}

}
