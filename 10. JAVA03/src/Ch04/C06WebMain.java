package Ch04;

import java.util.HashMap;
import java.util.Map;

public class C06WebMain {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap();

		// 추가
		map.put("aaa", 1111);
		map.put("bbb", 2222);
		map.put("ccc", 3333);
		map.put("ddd", 4444);//older//삭제
		map.put("ddd", 5555);//newer //적용

		// 삭제
		map.remove("aaa");

		// 확인
		for (String key : map.keySet()) {
			System.out.println("KEY: " + key + " VALUE: " + map.get(key));
		}
		System.out.println("SIZE:" + map.size());
		System.out.println("단건:" + map.get("bbb"));

	}

}
