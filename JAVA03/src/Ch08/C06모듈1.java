package Ch08;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class C06모듈1 {
	private static Scanner sc = new Scanner(System.in);
	private static List<String> wordList = new ArrayList<String>();
	
	public static void sort(boolean isAsend) {
		if(isAsend) {//true가 넘어왔을 때
			Collections.sort(wordList); //Collection.sort()를 사용하여 오름차순으로 정렬한다.
	        System.out.println("오름차순으로 정렬하였습니다.");
		}
		else {//false가 넘어왔을 때
			Collections.sort(wordList.reversed());//Collection.sort(reversed();)를 사용하여 내림차순으로 정렬한다.
			System.out.println("내림차순으로 정렬하였습니다.");
		}
	}
	public static void add(String word) {
		 wordList.add(word);  //add(word)가 호출되면 생성된 wordList에 차례로 입력받은 word값을 저장하게된다.
	}
	public static void show() {
		int i =0; 
		int n = wordList.size();//리스트 길이만큼 돌릴거니까 n을 리스트길이로 초기화 시켜준다.
		while(i<n) {
			System.out.print(wordList.get(i));// 리스트의 갯수만큼 while문을 돌려서 첫번째 리스트 출력하고 행바꿈, 두번째 리스트 출력하고 행바꿈 ... 해서 출력하였다.
			System.out.println("");
			i++;
		
		}
		
		
	}

	public static void main(String[] args) {
		int n =0;
		while(true)
		{
			System.out.println("-------M E N U-------");
			System.out.println("1. 추가");
			System.out.println("2. 정렬");
			System.out.println("3. 확인");
			System.out.println("4. 종료");
			System.out.println("-------M E N U-------");
			n= sc.nextInt();
			switch(n) {
			case 1:
				System.out.print("단어입력 :");
			String word = sc.next();
			add(word);
				break;
			case 2:
				System.out.println("오름차순 여부(1: 오름차순, 0: 내림차순)");
			int no = sc.nextInt();
			if(no==1) sort(true);
			else sort(false);
				break;
			case 3:
				show();
				break;
			case 4:
				System.out.println("종료합니다.");
			System.exit(-1);
				break;
			default:
				System.out.println("다시 입력하세요.");
			
			}
		}
	}

}
