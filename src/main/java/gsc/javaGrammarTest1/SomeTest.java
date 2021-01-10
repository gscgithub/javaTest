package gsc.javaGrammarTest1;

import org.junit.Test;

public class SomeTest {

    @Test
    public void test1() throws ClassNotFoundException {
        //不执行代码块
        Class<ClassLoaderTest> classLoaderTest = (Class<ClassLoaderTest>) Class.forName("gsc.javaGrammarTest1.ClassLoaderTest");
        System.out.println("forName:" + classLoaderTest);

        new ClassLoaderTest();
        new ClassLoaderTest();
    }
}
