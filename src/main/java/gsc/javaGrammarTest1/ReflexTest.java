package gsc.javaGrammarTest1;

import org.junit.Test;

import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;

public class ReflexTest {

    @Test
    public void test1() {
        AnnotatedType[] annotatedInterfaces = ArrayList.class.getAnnotatedInterfaces();
        for (AnnotatedType annotatedInterface : annotatedInterfaces) {
            System.out.println(annotatedInterface.getType());
        }
    }
}
