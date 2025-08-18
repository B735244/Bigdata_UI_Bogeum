package Ch02;

public class C02ArrayIndexBoundExceptionMain {

	public static void main(String[] args) {
		
int [] arr = {10,20,30};
System.out.println(arr[0]);
System.out.println(arr[1]);
System.out.println(arr[2]);
try {
System.out.println(arr[3]);
}catch(ArrayIndexOutOfBoundsException e) {
	System.out.println("예외 발생:"+ e);
	System.out.println(e.getCause());
	System.out.println(e.getStackTrace());
	
}finally {
	//예외가 발생하던 안하던 무조건 실행되어야 하는 코드!!
	//보통 작업을 위해 만들었던 자원들(JDBC, SOCKET, STREAM, SCANNER ...)을 제거하는데 사용됨.
	
}


System.out.println("실행되어야 할 코드1");
System.out.println("실행되어야 할 코드2");

	}

}
//TRY{
//}CATCH(){
//}FINALLY{
//} 이 순서대로 예외처리 흐름을 사용해야한다