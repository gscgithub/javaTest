package gsc.javaGrammarTest1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class BaseGrammarTest {

    @Test
    public void someTest2() throws IOException {
//		@SuppressWarnings("unchecked")
//		@SuppressWarnings("resource")
//		@SuppressWarnings("rawtypes")
//		@SuppressWarnings("rawtypes")
    }

    @Test
    public void test1() {

        int result = new BaseGrammarTest().method1();
        System.out.println("result:" + result);
    }

    public int method1() {
        int v = 0;
        try {
            return v;
        } catch (Exception e) {

        } finally {
            v++;
            System.out.println("finally v:" + v);
        }
        System.out.println("last v:" + v);
        return v;
    }
}
