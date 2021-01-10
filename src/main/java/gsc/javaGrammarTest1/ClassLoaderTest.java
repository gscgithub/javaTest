package gsc.javaGrammarTest1;

import org.junit.Test;

public class ClassLoaderTest {

    {
        System.out.println("ClassLoaderTest初始化块");
    }

    @Test
    public void testClassLoder() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
    }

    @Test
    public void testClassLoder2() {
        //启动时执行一次初始化块(test的时候会new 类)
        //不执行初始化块
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        try {
//          使用ClassLoader.loadClass()来加载类，未执行初始化块
			loader.loadClass("gsc.javaGrammarTest1.ClassLoaderTest");
//          使用Class.forName()来加载类，未执行初始化块
            Class<ClassLoaderTest> classLoaderTest = (Class<ClassLoaderTest>) Class.forName("gsc.javaGrammarTest1.ClassLoaderTest");
            System.out.println("forName:" + classLoaderTest);
//          使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行初始化块
            Class.forName("gsc.javaGrammarTest1.ClassLoaderTest", false, loader);
            //只有new的时候执行初始化块
            new ClassLoaderTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ClassLoaderTest{}";
    }
}

class Test2{
    public String str = "good";
    public void change(String str){
        //注意不加this改变不了对象的str值
        this.str="test ok";
    }

    public static void main(String[] args) {
        Test2 ex = new Test2();
        ex.change(ex.str);
        System.out.print(ex.str + " ");
    }
}

class Test1{
    private int i = getValue();
    private int j= 10;
    int getValue() {
        return j;
    }
    public static void main(String[] args) {
        System.out.println(new Test1().j);
    }
}