package Ch03;

import java.util.Arrays;
import java.util.Scanner;
public class C01ArrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);

int [] arr1= new int[5];
System.out.println("배열길이:"+arr1.length);
System.out.println("5개의 값을 입력하세요");
arr1[0]=sc.nextInt();
arr1[1]=sc.nextInt();
arr1[2]=sc.nextInt();
arr1[3]=sc.nextInt();
arr1[4]=sc.nextInt();


//for(int i=0;i<arr1.length; i++) {
//	System.out.println(i+"번째에 담겨있음->"+arr1[i]);
//}
//System.out.println("for문 종료");
//
//for(int el :arr1) {
//	System.out.println(el);
//}
//System.out.println("for문 종료");

//Arrays.stream(arr1).forEach((el)->{System.out.println(el);});
//Arrays.stream(arr1).forEach(el->System.out.println(el));
//Arrays.stream(arr1).forEach(System.out::println);


//배열에 입력된 정수중에 최대값과 최소값을 출력하세요.
int max  =arr1[0];
int min =arr1[0];
for(int d:arr1){
	if(max<d) max=d;
	if(min>d) min =d;
	
}
	



System.out.println("MAX :" + Arrays.stream(arr1).max().getAsInt());
System.out.println("MIN :" + Arrays.stream(arr1).min().getAsInt());
	}

}
