package Ch03;

public class C04자료형_변환 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		byte x= 10;
//		byte y= 20;
//		byte result1 =x+y;//???????????????????
		//정수 연산식 자동형변환 (int 보다 작은 변수 자료형간의 산술연산시 ->int로 저동형변환)
		
//		byte result1 =(byte)(x+y);
//		int result2 = x+y;
		
		//정수 연산식 자동형변환(int보다 큰 변수 자료형간의 산술연산시 => 큰 자료형(long)으로 자동형변환)
		byte var1 = 10;
		int var2 = 100;
		long var3 = 1000L;
		//int result =var1+var2+var3;

		
		//실수연산식
		//큰  타입으로 자동형변환
		int intvar = 10;
		float flvar =3.3F;
		double dbvar = 5.5;
		int result3 = (int)(intvar+flvar+dbvar);
		//double result4 = intvar + flvar+ dbvar;
		System.out.println(result3);
		
	}

}
