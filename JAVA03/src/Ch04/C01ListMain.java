package Ch04;
import java.util.List;
import java.util.ArrayList;

public class C01ListMain {

	public static void main(String[] args) {
		List<String> list = new ArrayList();

		list.add("HTML/CSS/JS");
		list.add("NODEJS");
		list.add("SCSS");
		list.add("REACT");
		list.add("JAVA");
		list.add("BODONG");
		list.add("GEUMDONG");
		list.add("KYUDONG");
		
		//조회\
		System.out.println("갯수 확인:" + list.size());
		System.out.println("idx 조회: " + list.get(2));
		System.out.println("Value로 idx확인 :" + list.indexOf("KYUDONG"));
		list.forEach(System.out::println);
		
		
		//삭제
		list.remove(0);
		list.remove("JQUERY");
		System.out.println("---");
		list.forEach(System.out::println);
		
		
		//전체삭제
		list.clear();
	}
	
	

}
