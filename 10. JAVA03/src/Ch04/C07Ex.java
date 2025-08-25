package Ch04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C07Ex {
	static Map<String, Object> map = new HashMap();

	// set
	static void setMap(Map<String, Object> param) {
		for (String key : param.keySet()) {
			Object values = param.get(key);
			System.out.println("KEY : " + key + ",values : " + values);
			map.put(key, values);
		}
	}
	//get
	static Map<String, Object> getMap(){
		return map;
	}

	public static void main(String[] args) {
		// 01 파라미터 생성
		Map<String, Object> params = new HashMap();
		// 02 파라미터에 데이터 저장
		String[] values = { "웹디자인기능사", "정보처리기사", "네트워크관리사", "빅데이터분석기사" };
		params.put("자격증", values);
		setMap(params);

		List<String> values2 = new ArrayList();
		values2.add("등산");
		values2.add("취침");
		values2.add("요리");
		values2.add("게임");
		params.put("취미", values2);
		setMap(params);

		// 03
		Map<String, Object> mapDatas = getMap();
		for(String key : mapDatas.keySet()) {
			Object value = mapDatas.get(key);
			
			//배열일 때
		if(value instanceof String[]) {
			String [] arr = (String[])value;
			for(String el :arr) {
				System.out.println("자격증 배열 확인:" +el);
			}
		}
		else if(value instanceof List){
			System.out.println("KEY : " +key+ "Values:" +value);
		}
			
			//list
			
		}

	}
}
