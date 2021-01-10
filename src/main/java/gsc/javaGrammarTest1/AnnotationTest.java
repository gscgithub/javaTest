package gsc.javaGrammarTest1;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class AnnotationTest {

	public static void main(String[] args) {
		testGetAnnotation();
		
	}
	public static void testGetAnnotation() {
		try {
			Class<AnnotationTest> clazz = AnnotationTest.class;
			Method getAnnotationTest1Method = clazz.getMethod("getAnnotationTest1");
			Annotation[] annotations = getAnnotationTest1Method.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
	}
	@MyAnnotation1
	public void getAnnotationTest1() {
		
	}
	@MyAnnotation2(id=10)
	public void getAnnotationTest2() {
		
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation1 {
	String value() default "myAnnotation1DefalutValue";
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation2 {
	int id() default 0;
}













