package Ch19;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

interface Func1 {
	void say(String message);
}

interface Func2 {
	int sum(Integer... args);
}

interface Func3 {
	List <Integer> sum(Object... args);
}

public class C01FunctionalInterfaceMain {

	public static void main(String[] args) {

		Func1 func1 = (message) -> {
			System.out.println(message + "_!");
		};
		func1.say("Hello World!!!");

		Func1 func2 = System.out::println;
		func2.say("Hello World!!!");

		Func2 func3 = (arr) -> {
			int sum = 0;
			for (Integer n : arr)
				sum += n;
			return sum;

		};

		System.out.println(func3.sum(10, 20, 30, 40, 500));
		
		
		//3.
		Func3 func4 = (arr)->{
			return Arrays.stream(arr)
					//.filter((obj)->{return obj instanceof Integer ;})
					.filter(obj->obj instanceof Integer)
					.map((obj)->{return (Integer)obj;})
					.collect(Collectors.toList());
			
			
			
		};
		System.out.println(func4.sum(10,20,30,40,50,50,"손보금",true));
	}

}
