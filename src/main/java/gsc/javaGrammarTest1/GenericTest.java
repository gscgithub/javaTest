package gsc.javaGrammarTest1;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    @Test
    public void test() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        //这⾥直接添加会报错
        //list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        //但是通过反射添加，是可以的
        add.invoke(list, "kl");
        System.out.println(list);
    }
}
