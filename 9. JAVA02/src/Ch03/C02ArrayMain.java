package Ch03;

import java.util.Arrays;

public class C02ArrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr1[]= {10,23,30};
int arr2[];
arr2 = arr1;//주소 복사, 하나의 배열을 가르키는 2개의 변수가 생겨버림

arr1[0]=100;//배열안에 있는 값이 바뀌게 되면 다같이 바뀌게 되겠죠?

Arrays.stream(arr1).forEach(System.out::println);
System.out.println("-----------");
Arrays.stream(arr2).forEach(System.out::println);


//깊은복사(값복사)
		int arr3[] = new int[3];
		for(int i=0;i<arr1.length;i++)
			arr3[i] = arr1[i];
		
		//Arrays API
		int arr4[] = Arrays.copyOf(arr1,arr1.length);
		
		System.out.println("arr1 : " + arr1);
		System.out.println("arr2 : " + arr2);
		System.out.println("arr3 : " + arr3);
		System.out.println("arr4 : " + arr4);
			

	}

}
