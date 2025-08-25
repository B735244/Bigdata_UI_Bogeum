package Ch04;

import java.util.Vector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
public class C03SetMain {

	public static void main(String[] args) {
		Set<String> set = new HashSet();
		//추가
		set.add("HTML/CSS/JS");
		set.add("NODEJS");
		set.add("SCSS");
		set.add("REACT");
		set.add("JAVA");//older
		set.add("JAVA");//newer(적용) 나중에 들어온 것으로 대체됨. 중복을 허용하지 않는다.
		set.add("JSP/SERVLET");
		set.add("STS");
		set.add("SPRING BOOT");
		set.add("SPRING BOOT");
		//삭제
				set.remove("REACT");
		
		
		//출력확인
		System.out.println("갯수 확인: " +set.size());
		
		//탐색(고전) - Iterator 사용, ㄱ
		Iterator <String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		//탐색(최근)
		for(String el : set) {
			System.out.println(el);
		}
		set.clear();
	}

}
