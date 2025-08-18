package Ch03;

public class C03ArrayMain {
	public static void main(String[] args) {
		int arr[][] = {
				{10,20,30},
				{40,50,60,65,67},
				{70,80,90,96,11,56},
				{100,110,120,15,22,33,44},
		};
		
		System.out.println("행의 길이 : "  + arr.length);// 전체 몇개의 행이 있니? 4개
		System.out.println("행의 길이 : "  + arr[0].length);// 첫 번째 행의 길이는? 3
		System.out.println("행의 길이 : "  + arr[1].length);// 두 번째 해으이 길이는? 5
		System.out.println("행의 길이 : "  + arr[2].length);// 세 번째 행의 길이는? 6
		System.out.println("행의 길이 : "  + arr[3].length);// 네 번째 행의 길이는 ? 7
	}
}

