package Ch04;
import java.util.ArrayList;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;



public class C04Ex {

	public static void main(String[] args) throws InterruptedException  {
		// 1 ~ 45 까지의 숫자를 6개 랜덤으로 받아(Random 클래스 이용) set에 저장/출력
Set<Integer> set = new HashSet();
		Random rnd = new Random();
		while(set.size()<6) {
	set.add(rnd.nextInt(45)+1);
	Thread.sleep(500);
		}
for(Integer el :set)
{
	System.out.print(el+"");
	System.out.println();
	}

List<Integer>list = set.stream().sorted().collect(Collectors.toList());
list.stream().forEach(System.out::println);
		// 저장된 set의 오름차순 정렬을 해보시오.(검색을 통해서 해결해 봅시다. - 스트림함수 사용)

		List<Integer> li = new ArrayList(set);
		Collections.sort(li);
		list.stream().forEach(System.out::println);
		Collections.sort(li.reversed());
	}

}
