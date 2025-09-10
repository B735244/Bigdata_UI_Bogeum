package Ch19;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//제공되는 함수형 인터페이스들
//Function<T, R>:
//apply 메서드를 가지고 있어서 하나의 인자(T)를 받아서 결과(R)를 반환하는 함수형 인터페이스 입니다.

//Supplier<T>:
//get 메서드를 가지고 있어서 어떠한 인자도 받지 않고 결과만을 제공하는 함수형 인터페이스 입니다.
//
//Consumer<T>:
//accept 메서드를 가지고 있어서 어떠한 인자를 받아서 결과를 반환하지 않는 함수형 인터페이스 입니다.
//
//Predicate<T>:
//test 메서드를 가지고 있어서 어떠한 인자를 받아서 불리언 결과를 반환하는 함수형 인터페이스 입니다.
//
//UnaryOperator<T>:
//apply 메서드를 가지고 있어서 하나의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스 입니다.
//
//BinaryOperator<T>:
//apply 메서드를 가지고 있어서 두 개의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스 입니다.

public class C03FunctionalInterfaceMain {

	public static Function<Integer, Integer> func1 = x -> x * x;
	public static Function<Integer, Integer> func2 = x -> x + x;
	public static Function<List<Integer>, Integer> func3 = x ->
	// x.stream().reduce(누적변수초기값,(누적변수, 요소변수)->{return 누적연산;});
	x.stream().reduce(0, (sum, el) -> {
		return sum + el;
	});

	// 반환형이 Integer
	public static Function<List<Object>, Integer> func4 = (list) -> {
		// 01 List의 각 요소 중 Integer만 Filter하겠다.
		// 02 필터링 된 Integer의 재구성(map)
		// 03 누적합(reduce)
		return list.stream().filter((el) -> {
			return el instanceof Integer;
		}).map((el) -> {
			return (Integer) el;
		}).reduce(0, (sum, el) -> {
			return sum + el;
		});

	};

	// 반환형이 String
	public static Function<List<Object>, List<String>> func5 = (list) -> {
		return list.stream().filter((el) -> {
			return el instanceof String;
		}).map((el) -> {
			return "-" + (String) el + "-";
		}).collect(Collectors.toList());

	};

	//
	public static Function<Integer, Integer> func6 = func1.andThen(func2);

	//
	public static Function<List<Integer>, Integer> func7 = func3.andThen(func1).andThen(func2);

	// 반환형이 함수식(람다식)
	public static Function<Integer, Function<Integer, Integer>> func8 = (x) -> {
	
		System.out.println("func8 :" + x);

		return (i -> {
			System.out.println("func8 : " + i);
			return x+i;
		});
	};
	
	// 반환형 함수식(람다식) 축약 버전
	public static Function<Integer, Function<Integer, Integer>> func9 =(x ->  n-> x+n);
		
	public static void main(String[] args) {

		System.out.println(func1.apply(10));
		System.out.println(func2.apply(10));
		System.out.println(func3.apply(Arrays.asList(10, 20, 30, 40)));
		System.out.println(func4.apply(Arrays.asList(11, 8.5, 30, 40, "test", true, new StringBuffer(), 20, 40)));
		System.out.println(func5.apply(Arrays.asList("10", 20, 30, "손보굼", true, "bread")));
		System.out.println(func6.apply(10));
		System.out.println(func7.apply(Arrays.asList(10, 20, 30, 40)));
		System.out.println(func8.apply(10).apply(20));
		System.out.println(func9.apply(10).apply(20));
	}

}
