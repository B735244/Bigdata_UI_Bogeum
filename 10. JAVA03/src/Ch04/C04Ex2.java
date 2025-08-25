package Ch04;
import java.util.ArrayList;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.List;



class Lotto {
	Set<Integer> set = new HashSet<>();
	Random random = new Random();

	public Lotto() {
		while (set.size() < 6) {
			int i = random.nextInt(45) + 1;
			set.add(i);
		}
		
		
		
	}
	
}

class Asc extends Lotto{


	public Asc() {
	
	List<Integer> asc =new  ArrayList<>(set);
	System.out.println("이번주 로또번호는?: " +set);
		Collections.sort(asc);
		System.out.println("오름차순 정렬:" +asc);
	}
	
}
public class C04Ex2 {

	public static void main(String[] args) {
		// 1 ~ 45 까지의 숫자를 6개 랜덤으로 받아(Random 클래스 이용) set에 저장/출력
Lotto lotto = new Lotto();
System.out.println("6개 난수 발생" + lotto.set);


		// 저장된 set의 오름차순 정렬을 해보시오.(검색을 통해서 해결해 봅시다. - 스트림함수 사용)
new Asc();
		
	}

}
