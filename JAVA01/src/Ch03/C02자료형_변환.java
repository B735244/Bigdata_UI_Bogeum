package Ch03;

public class C02자료형_변환 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//강제형변환
		//좁은 범위 공간에 큰값을 넣으려고 하는 경우
		//기본적으로 불가능하기 때문에 강제로 자료형을 바꿔어 전달한다
		//데이터 손실의 염려가 있다
		
		int intValue =44032;
		char charValue =(char)intValue;
		System.out.println((int)charValue);
		
		
		long longValue = 500;
		intValue = (int)longValue;
		System.out.println(intValue);
		
		double doubleValue = 3.14;
		intValue = (int)doubleValue;
		System.out.println(intValue);
		
		int num1 =129;
		int num2 =130;
		byte ch1 = (byte)num1;
		byte ch2 = (byte)num2;
		
		System.out.printf("%d \n", ch1);
		System.out.printf("%d \n", ch2);
		
	}

}
