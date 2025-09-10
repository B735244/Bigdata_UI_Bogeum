package Ch20;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 어노테이션의 유지기간(프로그램이 동작중인 상태에서만 실행한다.)
@Target({ElementType.TYPE,ElementType.METHOD}) 
//ElementType.Type : 클래스, 인터페이스, eum.. 적용
//ElementType.Field : 멤버 변수에 적용
//ElementType.METHOD : 메서드에 적용

public @interface C01CustomAnnotation {
	
	String  value() default "Hungry";
	int number() default 28;
	boolean isOpen() default false;

}
